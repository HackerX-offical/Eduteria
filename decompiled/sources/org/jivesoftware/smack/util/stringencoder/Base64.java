package org.jivesoftware.smack.util.stringencoder;

import java.nio.charset.StandardCharsets;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class Base64 {
    private static Encoder base64encoder;

    public interface Encoder {
        byte[] decode(String str);

        byte[] encode(byte[] bArr);

        String encodeToString(byte[] bArr);

        String encodeToStringWithoutPadding(byte[] bArr);
    }

    public static void setEncoder(Encoder encoder) {
        Objects.requireNonNull(encoder, "encoder must no be null");
        base64encoder = encoder;
    }

    public static final String encode(String str) {
        return encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static final String encodeToString(byte[] bArr) {
        return base64encoder.encodeToString(bArr);
    }

    public static final String encodeToString(byte[] bArr, int i, int i2) {
        return encodeToString(slice(bArr, i, i2));
    }

    public static final String encodeToStringWithoutPadding(byte[] bArr) {
        return base64encoder.encodeToStringWithoutPadding(bArr);
    }

    public static final byte[] encode(byte[] bArr) {
        return base64encoder.encode(bArr);
    }

    public static final String decodeToString(String str) {
        return new String(decode(str), StandardCharsets.UTF_8);
    }

    public static final byte[] decode(String str) {
        try {
            return base64encoder.decode(StringUtils.deleteXmlWhitespace(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final byte[] decode(byte[] bArr) {
        return decode(new String(bArr, StandardCharsets.US_ASCII));
    }

    private static byte[] slice(byte[] bArr, int i, int i2) {
        if (i == 0 && i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
