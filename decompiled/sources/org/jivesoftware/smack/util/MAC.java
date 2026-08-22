package org.jivesoftware.smack.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes10.dex */
public class MAC {
    public static final String HMACSHA1 = "HmacSHA1";
    private static Mac HMAC_SHA1;

    static {
        try {
            HMAC_SHA1 = Mac.getInstance("HmacSHA1");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static synchronized byte[] hmacsha1(SecretKeySpec secretKeySpec, byte[] bArr) throws InvalidKeyException {
        HMAC_SHA1.init(secretKeySpec);
        return HMAC_SHA1.doFinal(bArr);
    }

    public static byte[] hmacsha1(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        return hmacsha1(new SecretKeySpec(bArr, "HmacSHA1"), bArr2);
    }
}
