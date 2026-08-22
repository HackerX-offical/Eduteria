package com.appnew.android.Utils;

import android.text.TextUtils;
import android.util.Base64;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.appnew.android.Utils.Network.API;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class AES {
    private static int CIPHER_KEY_LEN = 16;
    private static String CIPHER_NAME = "AES/CBC/NoPadding";
    private static final String INIT_VECTOR = "abcdefghijklmnop";
    private static final String SECRET_KEY = "9876543212345678";
    public static String strArrayKey = "MTA5MCMj1090##JSFGKiZeJClfKiUzZiZCKw==XWc7dnMnMmFs";
    public static String strArrayKeyDownload = "MTA5MCMj1090##YUh9NXNbezsnPiwkMiZ2Ow==XWc7dnMnMmFs";
    public static String strArrayKeyDownloadV2 = "MTA5MDkwMTAjIw==c2w7NDYkJzsq10909010##ZyYnOy5Ic2Y0N15AO31bMCg4N2onNyY4XmpJJzooOCwuS2h0JTY0R2Y=MTA5MDkwMTAjIw==";
    public static String strArrayKeyLib = "!*@#)($^%1fgv&C=";
    public static String strArrayvector = "MTA5MCMj1090##IyokREp2eXcydyUhXy0kQA==XWc7dnMnMmFs";
    public static String strArrayvectorDownload = "MTA5MCMj1090##aTtHfSdodCNkKm86Jy8lZg==XWc7dnMnMmFs";
    public static String strArrayvectorLib = "?\\:><{}@#Vjekl/4";

    public static String encrypt(String data) {
        String strGeneratekeyAPI = generatekeyAPI();
        String strGenerateVectorAPI = generateVectorAPI();
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(strGenerateVectorAPI.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(fixKey(strGeneratekeyAPI).getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            String strEncodeToString = Base64.encodeToString(cipher.doFinal(data.getBytes("UTF-8")), 0);
            Base64.encodeToString(strGenerateVectorAPI.getBytes("UTF-8"), 0);
            return strEncodeToString + ":";
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String fixKey(String key) {
        int length = key.length();
        int i = CIPHER_KEY_LEN;
        if (length < i) {
            int length2 = i - key.length();
            for (int i2 = 0; i2 < length2; i2++) {
                key = key + "0";
            }
            return key;
        }
        int length3 = key.length();
        int i3 = CIPHER_KEY_LEN;
        return length3 > i3 ? key.substring(0, i3) : key;
    }

    public static String decrypt(String data, String key, String ivParameter) {
        try {
            if (data.contains(":")) {
                String[] strArrSplit = data.split(":");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(ivParameter.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance(CIPHER_NAME);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(Base64.decode(strArrSplit[0], 1)));
            }
            IvParameterSpec ivParameterSpec2 = new IvParameterSpec(ivParameter.getBytes());
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(key.getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher2 = Cipher.getInstance(CIPHER_NAME);
            cipher2.init(2, secretKeySpec2, ivParameterSpec2);
            return new String(cipher2.doFinal(Base64.decode(data, 1)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String generatekeyAPI() {
        String strSubstring;
        if (SharedPreference.getInstance() != null && SharedPreference.getInstance().getLoggedInUser() != null && !TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
            strSubstring = (SharedPreference.getInstance().getLoggedInUser().getId() + API.APITOKEN).substring(0, 16);
        } else {
            strSubstring = "01171086418644515_166".substring(0, 16);
        }
        String str = "";
        for (char c2 : strSubstring.toCharArray()) {
            str = str + encryptPassword(strArrayKey).toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String generateVectorAPI() {
        String strSubstring;
        if (SharedPreference.getInstance() != null && SharedPreference.getInstance().getLoggedInUser() != null && !TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
            strSubstring = (SharedPreference.getInstance().getLoggedInUser().getId() + API.APITOKEN).substring(0, 16);
        } else {
            strSubstring = "01171086418644515_166".substring(0, 16);
        }
        String str = "";
        for (char c2 : strSubstring.toCharArray()) {
            str = str + encryptPassword(strArrayvector).toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String generateLibkeyAPI(String token) {
        String str = "";
        for (char c2 : token.toCharArray()) {
            str = str + strArrayKeyLib.toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String generateLibVectorAPI(String token) {
        String str = "";
        for (char c2 : token.toCharArray()) {
            str = str + strArrayvectorLib.toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String generatekey(String token) {
        String str = "";
        for (char c2 : token.split("_")[2].toCharArray()) {
            str = str + encryptPassword(strArrayKey).toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String generateVector(String token) {
        String str = "";
        for (char c2 : token.split("_")[2].toCharArray()) {
            str = str + encryptPassword(strArrayvector).toCharArray()[Integer.parseInt(String.valueOf(c2))];
        }
        return str;
    }

    public static String encryptPassword(String key) {
        String[] strArrSplit = key.split("1090##", 2);
        String str = strArrSplit[0];
        String[] strArrSplit2 = strArrSplit[1].split("==", 2);
        String str2 = strArrSplit2[0] + "==";
        String str3 = strArrSplit2[1];
        String str4 = new String(Base64.decode(str2, 0), StandardCharsets.UTF_8);
        new String(Base64.decode(str3, 0), StandardCharsets.UTF_8);
        return str4;
    }

    public static String shareDataEncrypt(String value) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(value.getBytes("UTF-8")), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String shareDataDecrypt(String encrypted) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(encrypted, 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
