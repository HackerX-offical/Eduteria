package org.jivesoftware.smack.util.stringencoder;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes10.dex */
public class Base32 {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    private static final StringEncoder<String> base32Stringencoder = new StringEncoder<String>() { // from class: org.jivesoftware.smack.util.stringencoder.Base32.1
        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String encode(String str) {
            return Base32.encode(str);
        }

        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String decode(String str) {
            return Base32.decode(str);
        }
    };

    private static int lenToPadding(int i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToLen(int i) {
        if (i == 0) {
            return 5;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 6 ? -1 : 1;
        }
        return 2;
    }

    public static StringEncoder<String> getStringEncoder() {
        return base32Stringencoder;
    }

    public static String decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b2 : str.getBytes(StandardCharsets.UTF_8)) {
            char c2 = (char) b2;
            if (!Character.isWhitespace(c2)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c2));
            }
        }
        while (byteArrayOutputStream.size() % 8 != 0) {
            byteArrayOutputStream.write(56);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i = 0; i < byteArray.length / 8; i++) {
            short[] sArr = new short[8];
            int i2 = 8;
            for (int i3 = 0; i3 < 8; i3++) {
                byte b3 = byteArray[(i * 8) + i3];
                if (((char) b3) == '8') {
                    break;
                }
                short sIndexOf = (short) ALPHABET.indexOf(b3);
                sArr[i3] = sIndexOf;
                if (sIndexOf < 0) {
                    return null;
                }
                i2--;
            }
            int iPaddingToLen = paddingToLen(i2);
            if (iPaddingToLen < 0) {
                return null;
            }
            int i4 = sArr[0] << 3;
            short s = sArr[1];
            int i5 = i4 | (s >> 2);
            int i6 = sArr[2] << 1;
            short s2 = sArr[3];
            int i7 = i6 | ((s & 3) << 6) | (s2 >> 4);
            short s3 = sArr[4];
            int i8 = ((s2 & 15) << 4) | ((s3 >> 1) & 15);
            int i9 = (s3 << 7) | (sArr[5] << 2);
            short s4 = sArr[6];
            int[] iArr = {i5, i7, i8, i9 | (s4 >> 3), sArr[7] | ((s4 & 7) << 5)};
            for (int i10 = 0; i10 < iPaddingToLen; i10++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i10] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    public static String encode(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bytes.length + 4) / 5; i++) {
            short[] sArr = new short[5];
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = (i * 5) + i3;
                if (i4 < bytes.length) {
                    sArr[i3] = (short) (bytes[i4] & 255);
                } else {
                    sArr[i3] = 0;
                    i2--;
                }
            }
            int iLenToPadding = lenToPadding(i2);
            short s = sArr[0];
            short s2 = sArr[1];
            short s3 = sArr[2];
            short s4 = sArr[3];
            short s5 = sArr[4];
            int[] iArr = {(byte) ((s >> 3) & 31), (byte) (((s & 7) << 2) | ((s2 >> 6) & 3)), (byte) ((s2 >> 1) & 31), (byte) (((s2 & 1) << 4) | ((s3 >> 4) & 15)), (byte) (((s3 & 15) << 1) | (1 & (s4 >> 7))), (byte) ((s4 >> 2) & 31), (byte) (((s5 >> 5) & 7) | ((s4 & 3) << 3)), (byte) (s5 & 31)};
            for (int i5 = 0; i5 < 8 - iLenToPadding; i5++) {
                byteArrayOutputStream.write(ALPHABET.charAt(iArr[i5]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }
}
