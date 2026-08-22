package com.razorpay;

import android.util.Base64;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
class CryptLib {
    Cipher _cx = Cipher.getInstance("AES/GCM/NoPadding");
    byte[] _key = new byte[32];
    byte[] _iv = new byte[16];

    private enum EncryptMode {
        ENCRYPT,
        DECRYPT
    }

    CryptLib() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    private String encryptDecrypt(String str, String str2, EncryptMode encryptMode, String str3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        String strEncodeToString;
        int length = str2.getBytes("UTF-8").length;
        int length2 = str2.getBytes("UTF-8").length;
        byte[] bArr = this._key;
        if (length2 > bArr.length) {
            length = bArr.length;
        }
        int length3 = str3.getBytes("UTF-8").length;
        int length4 = str3.getBytes("UTF-8").length;
        byte[] bArr2 = this._iv;
        if (length4 > bArr2.length) {
            length3 = bArr2.length;
        }
        System.arraycopy(str2.getBytes("UTF-8"), 0, this._key, 0, length);
        System.arraycopy(str3.getBytes("UTF-8"), 0, this._iv, 0, length3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(this._key, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this._iv);
        if (!encryptMode.equals(EncryptMode.ENCRYPT)) {
            strEncodeToString = "";
        } else {
            this._cx.init(1, secretKeySpec, ivParameterSpec);
            strEncodeToString = Base64.encodeToString(this._cx.doFinal(str.getBytes("UTF-8")), 0);
        }
        if (encryptMode.equals(EncryptMode.DECRYPT)) {
            try {
                this._cx.init(2, secretKeySpec, ivParameterSpec);
                return new String(this._cx.doFinal(Base64.decode(str, 0)), StandardCharsets.UTF_8);
            } catch (Exception unused) {
            }
        }
        return strEncodeToString;
    }

    static String SHA256(String str, int i) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes("UTF-8"));
        byte[] bArrDigest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArrDigest) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        if (i > stringBuffer.toString().length()) {
            return stringBuffer.toString();
        }
        return stringBuffer.toString().substring(0, i);
    }

    String encrypt(String str, String str2, String str3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        return encryptDecrypt(str, str2, EncryptMode.ENCRYPT, str3);
    }

    String decrypt(String str, String str2, String str3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        return encryptDecrypt(str, str2, EncryptMode.DECRYPT, str3);
    }

    static String generateRandomIV(int i) {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 16; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        if (i > stringBuffer.toString().length()) {
            return stringBuffer.toString();
        }
        return stringBuffer.toString().substring(0, i);
    }
}
