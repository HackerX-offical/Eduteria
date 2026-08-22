package org.jivesoftware.smack.sasl.core;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.csvreader.CsvReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.SHA1;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ScramMechanism extends SASLMechanism {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int RANDOM_ASCII_BYTE_COUNT = 32;
    private String clientFirstMessageBare;
    private String clientRandomAscii;
    private final ScramHmac scramHmac;
    private byte[] serverSignature;
    private State state = State.INITIAL;
    private static final byte[] CLIENT_KEY_BYTES = toBytes("Client Key");
    private static final byte[] SERVER_KEY_BYTES = toBytes("Server Key");
    private static final byte[] ONE = {0, 0, 0, 1};
    private static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>() { // from class: org.jivesoftware.smack.sasl.core.ScramMechanism.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };
    private static final Cache<String, Keys> CACHE = new LruCache(10);

    private enum State {
        INITIAL,
        AUTH_TEXT_SENT,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    private static boolean isPrintableNonCommaAsciiChar(char c2) {
        return c2 != ',' && c2 > ' ' && c2 < 127;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean authzidSupported() {
        return true;
    }

    protected byte[] getChannelBindingData() throws SmackException.SmackSaslException {
        return null;
    }

    protected ScramMechanism(ScramHmac scramHmac) {
        this.scramHmac = scramHmac;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] getAuthenticationText() {
        this.clientRandomAscii = getRandomAscii();
        this.clientFirstMessageBare = "n=" + escape(saslPrep(this.authenticationId)) + ",r=" + this.clientRandomAscii;
        String str = getGS2Header() + this.clientFirstMessageBare;
        this.state = State.AUTH_TEXT_SENT;
        return toBytes(str);
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "SCRAM-" + this.scramHmac.getHmacName();
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException {
        if (this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException.SmackSaslException("SCRAM-SHA1 is missing valid server response");
        }
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        byte[] bArrHmac;
        byte[] bArrHmac2;
        String str = new String(bArr, StandardCharsets.UTF_8);
        int i = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State[this.state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (!("v=" + Base64.encodeToString(this.serverSignature)).equals(str)) {
                    throw new SmackException.SmackSaslException("Server final message does not match calculated one");
                }
                this.state = State.VALID_SERVER_RESPONSE;
                return null;
            }
            throw new SmackException.SmackSaslException("Invalid state");
        }
        Map<Character, String> attributes = parseAttributes(str);
        String str2 = attributes.get(Character.valueOf(Constants.INAPP_POSITION_RIGHT));
        if (str2 == null) {
            throw new SmackException.SmackSaslException("Server random ASCII is null");
        }
        if (str2.length() <= this.clientRandomAscii.length()) {
            throw new SmackException.SmackSaslException("Server random ASCII is shorter then client random ASCII");
        }
        if (!str2.substring(0, this.clientRandomAscii.length()).equals(this.clientRandomAscii)) {
            throw new SmackException.SmackSaslException("Received client random ASCII does not match client random ASCII");
        }
        String str3 = attributes.get('i');
        if (str3 == null) {
            throw new SmackException.SmackSaslException("Iterations attribute not set");
        }
        try {
            int i2 = Integer.parseInt(str3);
            String str4 = attributes.get('s');
            if (str4 == null) {
                throw new SmackException.SmackSaslException("SALT not send");
            }
            String str5 = ("c=" + Base64.encodeToString(getCBindInput())) + ",r=" + str2;
            byte[] bytes = toBytes(this.clientFirstMessageBare + CsvReader.Letters.COMMA + str + CsvReader.Letters.COMMA + str5);
            String str6 = this.password + CsvReader.Letters.COMMA + str4 + CsvReader.Letters.COMMA + getName();
            Cache<String, Keys> cache = CACHE;
            Keys keysLookup = cache.lookup(str6);
            if (keysLookup == null) {
                byte[] bArrHi = hi(saslPrep(this.password), Base64.decode(str4), i2);
                bArrHmac = hmac(bArrHi, SERVER_KEY_BYTES);
                bArrHmac2 = hmac(bArrHi, CLIENT_KEY_BYTES);
                cache.put(str6, new Keys(bArrHmac2, bArrHmac));
            } else {
                bArrHmac = keysLookup.serverKey;
                bArrHmac2 = keysLookup.clientKey;
            }
            this.serverSignature = hmac(bArrHmac, bytes);
            byte[] bArrHmac3 = hmac(SHA1.bytes(bArrHmac2), bytes);
            int length = bArrHmac2.length;
            byte[] bArr2 = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr2[i3] = (byte) (bArrHmac2[i3] ^ bArrHmac3[i3]);
            }
            String str7 = str5 + ",p=" + Base64.encodeToString(bArr2);
            this.state = State.RESPONSE_SENT;
            return toBytes(str7);
        } catch (NumberFormatException e2) {
            throw new SmackException.SmackSaslException("Exception parsing iterations", e2);
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.sasl.core.ScramMechanism$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State = iArr;
            try {
                iArr[State.AUTH_TEXT_SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State[State.RESPONSE_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private String getGS2Header() {
        String str;
        if (this.authorizationId == null) {
            str = "";
        } else {
            str = "a=" + ((Object) this.authorizationId);
        }
        return getGs2CbindFlag() + CsvReader.Letters.COMMA + str + Constants.SEPARATOR_COMMA;
    }

    private byte[] getCBindInput() throws SmackException.SmackSaslException {
        byte[] channelBindingData = getChannelBindingData();
        byte[] bytes = toBytes(getGS2Header());
        return channelBindingData == null ? bytes : ByteUtils.concat(bytes, channelBindingData);
    }

    protected String getGs2CbindFlag() {
        if (this.sslSession != null && this.connectionConfiguration.isEnabledSaslMechanism(getName() + "-PLUS")) {
            return "y";
        }
        return CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY;
    }

    private static Map<Character, String> parseAttributes(String str) throws SmackException.SmackSaslException {
        if (str.length() == 0) {
            return Collections.emptyMap();
        }
        String[] strArrSplit = str.split(Constants.SEPARATOR_COMMA);
        HashMap map = new HashMap(strArrSplit.length, 1.0f);
        for (String str2 : strArrSplit) {
            if (str2.length() < 3) {
                throw new SmackException.SmackSaslException("Invalid Key-Value pair: " + str2);
            }
            char cCharAt = str2.charAt(0);
            if (str2.charAt(1) != '=') {
                throw new SmackException.SmackSaslException("Invalid Key-Value pair: " + str2);
            }
            map.put(Character.valueOf(cCharAt), str2.substring(2));
        }
        return map;
    }

    String getRandomAscii() {
        char[] cArr = new char[32];
        SecureRandom secureRandom = SECURE_RANDOM.get();
        int i = 0;
        while (i < 32) {
            char cNextInt = (char) secureRandom.nextInt(128);
            if (isPrintableNonCommaAsciiChar(cNextInt)) {
                cArr[i] = cNextInt;
                i++;
            }
        }
        return new String(cArr);
    }

    private static String escape(String str) {
        StringBuilder sb = new StringBuilder((int) (((double) str.length()) * 1.1d));
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ',') {
                sb.append("=2C");
            } else if (cCharAt == '=') {
                sb.append("=3D");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private byte[] hmac(byte[] bArr, byte[] bArr2) throws SmackException.SmackSaslException {
        try {
            return this.scramHmac.hmac(bArr, bArr2);
        } catch (InvalidKeyException e2) {
            throw new SmackException.SmackSaslException(getName() + " Exception", e2);
        }
    }

    private byte[] hi(String str, byte[] bArr, int i) throws SmackException.SmackSaslException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArrHmac = hmac(bytes, ByteUtils.concat(bArr, ONE));
        byte[] bArr2 = (byte[]) bArrHmac.clone();
        for (int i2 = 1; i2 < i; i2++) {
            bArrHmac = hmac(bytes, bArrHmac);
            for (int i3 = 0; i3 < bArrHmac.length; i3++) {
                bArr2[i3] = (byte) (bArr2[i3] ^ bArrHmac[i3]);
            }
        }
        return bArr2;
    }

    private static class Keys {
        private final byte[] clientKey;
        private final byte[] serverKey;

        Keys(byte[] bArr, byte[] bArr2) {
            this.clientKey = bArr;
            this.serverKey = bArr2;
        }
    }
}
