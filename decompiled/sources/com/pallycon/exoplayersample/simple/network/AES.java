package com.pallycon.exoplayersample.simple.network;

import android.util.Base64;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
public class AES {
    private static int CIPHER_KEY_LEN = 16;
    private static String CIPHER_NAME = "AES/CBC/NoPadding";
    public static String strArrayKey = "!*@#)($^%1fgv&C=";
    public static String strArrayvector = "?\\:><{}@#Vjekl/4";

    public static String encryptPassword(String str) {
        String[] strArrSplit = str.split("1090##", 2);
        String str2 = strArrSplit[0];
        String[] strArrSplit2 = strArrSplit[1].split("==", 2);
        String str3 = strArrSplit2[0] + "==";
        String str4 = strArrSplit2[1];
        String str5 = new String(Base64.decode(str3, 0), StandardCharsets.UTF_8);
        new String(Base64.decode(str4, 0), StandardCharsets.UTF_8);
        return str5;
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(fixKey(str).getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str3.getBytes("UTF-8")), 0);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String fixKey(String str) {
        int length = str.length();
        int i = CIPHER_KEY_LEN;
        if (length < i) {
            int length2 = i - str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                str = str + "0";
            }
            return str;
        }
        int length3 = str.length();
        int i3 = CIPHER_KEY_LEN;
        return length3 > i3 ? str.substring(0, i3) : str;
    }

    public static String decrypt(String str, String str2, String str3) {
        try {
            if (str.contains(":")) {
                String[] strArrSplit = str.split(":");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance(CIPHER_NAME);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(Base64.decode(strArrSplit[0], 1)));
            }
            IvParameterSpec ivParameterSpec2 = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher2 = Cipher.getInstance(CIPHER_NAME);
            cipher2.init(2, secretKeySpec2, ivParameterSpec2);
            return new String(cipher2.doFinal(Base64.decode(str, 1)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String generatekey(String str) {
        String str2 = "";
        for (char c2 : str.split("_")[2].toCharArray()) {
            str2 = str2 + strArrayKey.toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str2;
    }

    public static String generateVector(String str) {
        String str2 = "";
        for (char c2 : str.split("_")[2].toCharArray()) {
            str2 = str2 + strArrayvector.toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str2;
    }
}
