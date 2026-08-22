package org.jivesoftware.smack.sasl.provided;

import com.clevertap.android.sdk.Constants;
import java.nio.charset.StandardCharsets;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.MD5;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class SASLDigestMD5Mechanism extends SASLMechanism {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INITAL_NONCE = "00000001";
    public static final String NAME = "DIGEST-MD5";
    private static final String QOP_VALUE = "auth";
    private static boolean verifyServerResponse = true;
    private String cnonce;
    private String digestUri;
    private String hex_hashed_a1;
    private String nonce;
    private State state = State.INITIAL;

    private enum DigestType {
        ClientResponse,
        ServerResponse
    }

    private enum State {
        INITIAL,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean authzidSupported() {
        return true;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] getAuthenticationText() {
        return null;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 210;
    }

    public static void setVerifyServerResponse(boolean z) {
        verifyServerResponse = z;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "DIGEST-MD5";
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLDigestMD5Mechanism newInstance() {
        return new SASLDigestMD5Mechanism();
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException {
        if (verifyServerResponse && this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException.SmackSaslException("DIGEST-MD5 no valid server response");
        }
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        String str;
        if (bArr.length == 0) {
            throw new SmackException.SmackSaslException("Initial challenge has zero length");
        }
        String[] strArrSplit = new String(bArr, StandardCharsets.UTF_8).split(Constants.SEPARATOR_COMMA);
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State[this.state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (verifyServerResponse) {
                    int length = strArrSplit.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str = null;
                            break;
                        }
                        String[] strArrSplit2 = strArrSplit[i2].split("=");
                        String str2 = strArrSplit2[0];
                        str = strArrSplit2[1];
                        if ("rspauth".equals(str2)) {
                            break;
                        }
                        i2++;
                    }
                    if (str == null) {
                        throw new SmackException.SmackSaslException("No server response received while performing DIGEST-MD5 authentication");
                    }
                    if (!str.equals(calcResponse(DigestType.ServerResponse))) {
                        throw new SmackException.SmackSaslException("Invalid server response  while performing DIGEST-MD5 authentication");
                    }
                }
                this.state = State.VALID_SERVER_RESPONSE;
                return null;
            }
            throw new IllegalStateException();
        }
        int length2 = strArrSplit.length;
        int i3 = 0;
        while (true) {
            if (i3 < length2) {
                String[] strArrSplit3 = strArrSplit[i3].split("=", 2);
                String strReplaceFirst = strArrSplit3[0].replaceFirst("^\\s+", "");
                String str3 = strArrSplit3[1];
                if ("nonce".equals(strReplaceFirst)) {
                    if (this.nonce != null) {
                        throw new SmackException.SmackSaslException("Nonce value present multiple times");
                    }
                    this.nonce = str3.replace("\"", "");
                } else if ("qop".equals(strReplaceFirst)) {
                    String strReplace = str3.replace("\"", "");
                    if (!strReplace.equals("auth")) {
                        throw new SmackException.SmackSaslException("Unsupported qop operation: " + strReplace);
                    }
                } else {
                    continue;
                }
                i3++;
            } else {
                if (this.nonce == null) {
                    throw new SmackException.SmackSaslException("nonce value not present in initial challenge");
                }
                byte[] bArrBytes = MD5.bytes(this.authenticationId + ':' + ((Object) this.serviceName) + ':' + this.password);
                this.cnonce = StringUtils.randomString(32);
                byte[] bArrConcat = ByteUtils.concat(bArrBytes, toBytes(":" + this.nonce + ':' + this.cnonce));
                this.digestUri = "xmpp/" + ((Object) this.serviceName);
                this.hex_hashed_a1 = StringUtils.encodeHex(MD5.bytes(bArrConcat));
                byte[] bytes = toBytes("username=\"" + quoteBackslash(this.authenticationId) + '\"' + (this.authorizationId != null ? ",authzid=\"" + ((Object) this.authorizationId) + '\"' : "") + ",realm=\"" + ((Object) this.serviceName) + "\",nonce=\"" + this.nonce + "\",cnonce=\"" + this.cnonce + "\",nc=00000001,qop=auth,digest-uri=\"" + this.digestUri + "\",response=" + calcResponse(DigestType.ClientResponse) + ",charset=utf-8");
                this.state = State.RESPONSE_SENT;
                return bytes;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State = iArr;
            try {
                iArr[State.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State[State.RESPONSE_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private String calcResponse(DigestType digestType) {
        StringBuilder sb = new StringBuilder();
        if (digestType == DigestType.ClientResponse) {
            sb.append("AUTHENTICATE");
        }
        sb.append(':');
        sb.append(this.digestUri);
        return StringUtils.encodeHex(MD5.bytes(this.hex_hashed_a1 + ':' + this.nonce + ":00000001:" + this.cnonce + ":auth:" + StringUtils.encodeHex(MD5.bytes(sb.toString()))));
    }

    public static String quoteBackslash(String str) {
        return str.replace("\\", "\\\\");
    }
}
