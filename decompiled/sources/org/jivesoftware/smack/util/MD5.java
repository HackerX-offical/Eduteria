package org.jivesoftware.smack.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes10.dex */
public class MD5 {
    private static MessageDigest MD5_DIGEST;

    static {
        try {
            MD5_DIGEST = MessageDigest.getInstance(StringUtils.MD5);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static synchronized byte[] bytes(byte[] bArr) {
        return MD5_DIGEST.digest(bArr);
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
