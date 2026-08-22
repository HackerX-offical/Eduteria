package com.clevertap.android.sdk.cryption;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AESCrypt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0003H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/sdk/cryption/AESCrypt;", "Lcom/clevertap/android/sdk/cryption/Crypt;", "accountID", "", "<init>", "(Ljava/lang/String;)V", "keyPassword", "encryptInternal", "plainText", "decryptInternal", "cipherText", "parseCipherText", "", "performCryptOperation", "mode", "", "password", "text", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AESCrypt extends Crypt {
    private static final String APP_ID_KEY_PREFIX;
    private static final String APP_ID_KEY_SUFFIX;
    private final String keyPassword;

    public AESCrypt(String accountID) {
        Intrinsics.checkNotNullParameter(accountID, "accountID");
        this.keyPassword = APP_ID_KEY_PREFIX + accountID + APP_ID_KEY_SUFFIX;
    }

    @Override // com.clevertap.android.sdk.cryption.Crypt
    public String encryptInternal(String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        String str = this.keyPassword;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = plainText.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrPerformCryptOperation = performCryptOperation(1, str, bytes);
        if (bArrPerformCryptOperation == null) {
            return null;
        }
        String string = Arrays.toString(bArrPerformCryptOperation);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.clevertap.android.sdk.cryption.Crypt
    public String decryptInternal(String cipherText) {
        byte[] bArrPerformCryptOperation;
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        byte[] cipherText2 = parseCipherText(cipherText);
        if (cipherText2 == null || (bArrPerformCryptOperation = performCryptOperation(2, this.keyPassword, cipherText2)) == null) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(bArrPerformCryptOperation, UTF_8);
    }

    private final byte[] parseCipherText(String cipherText) {
        try {
            String strSubstring = cipherText.substring(1, cipherText.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            List<String> listSplit = new Regex("\\s*,\\s*").split(StringsKt.trim((CharSequence) strSubstring).toString(), 0);
            byte[] bArr = new byte[listSplit.size()];
            int size = listSplit.size();
            for (int i = 0; i < size; i++) {
                bArr[i] = Byte.parseByte(listSplit.get(i));
            }
            return bArr;
        } catch (Exception e2) {
            Logger.v("Unable to parse cipher text", e2);
            return null;
        } catch (OutOfMemoryError e3) {
            Logger.v("Unable to parse cipher text", e3);
            return null;
        }
    }

    private final byte[] performCryptOperation(int mode, String password, byte[] text) {
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = Constants.CRYPTION_SALT.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Charset UTF_82 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
            byte[] bytes2 = Constants.CRYPTION_IV.getBytes(UTF_82);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            char[] charArray = password.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithMD5And128BitAES-CBC-OpenSSL").generateSecret(new PBEKeySpec(charArray, bytes, 1000, 256)).getEncoded(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(mode, secretKeySpec, new IvParameterSpec(bytes2));
            return cipher.doFinal(text);
        } catch (Exception e2) {
            Logger.v("Unable to perform crypt operation", e2);
            return null;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("Lq3fz", "toString(...)");
        APP_ID_KEY_PREFIX = "Lq3fz";
        Intrinsics.checkNotNullExpressionValue("bLti2", "toString(...)");
        APP_ID_KEY_SUFFIX = "bLti2";
    }
}
