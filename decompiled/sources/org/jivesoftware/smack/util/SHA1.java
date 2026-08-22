package org.jivesoftware.smack.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes10.dex */
public class SHA1 {
    private static MessageDigest SHA1_DIGEST;

    static {
        try {
            SHA1_DIGEST = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static synchronized byte[] bytes(byte[] bArr) {
        SHA1_DIGEST.update(bArr);
        return SHA1_DIGEST.digest();
    }

    public static byte[] bytes(String str) {
        return bytes(StringUtils.toUtf8Bytes(str));
    }

    public static String hex(byte[] bArr) {
        return StringUtils.encodeHex(bytes(bArr));
    }

    public static String hex(String str) {
        return hex(StringUtils.toUtf8Bytes(str));
    }
}
