package org.minidns.util;

/* JADX INFO: loaded from: classes10.dex */
public final class Base32 {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUV";
    private static final String PADDING = "======";

    private Base32() {
    }

    public static String encodeToString(byte[] bArr) {
        int length = ((int) (8.0d - (((double) (bArr.length % 5)) * 1.6d))) % 8;
        byte[] bArr2 = new byte[bArr.length + length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 5) {
            long j = (((long) (bArr2[i] & 255)) << 32) + (((long) (bArr2[i + 1] & 255)) << 24) + ((long) ((bArr2[i + 2] & 255) << 16)) + ((long) ((bArr2[i + 3] & 255) << 8)) + ((long) (bArr2[i + 4] & 255));
            sb.append(ALPHABET.charAt((int) ((j >> 35) & 31))).append(ALPHABET.charAt((int) ((j >> 30) & 31))).append(ALPHABET.charAt((int) ((j >> 25) & 31))).append(ALPHABET.charAt((int) ((j >> 20) & 31))).append(ALPHABET.charAt((int) ((j >> 15) & 31))).append(ALPHABET.charAt((int) ((j >> 10) & 31))).append(ALPHABET.charAt((int) ((j >> 5) & 31))).append(ALPHABET.charAt((int) (j & 31)));
        }
        return sb.substring(0, sb.length() - length) + PADDING.substring(0, length);
    }
}
