package com.google.zxing.datamatrix.encoder;

import cz.msebera.android.httpclient.HttpStatus;
import easypay.appinvoke.manager.Constants;
import org.bouncycastle.math.Primes;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes9.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, ByteCode.INVOKEINTERFACE, 166, 223, 248, 116, 255, 110, 61}, new int[]{ByteCode.DRETURN, 138, HttpStatus.SC_RESET_CONTENT, 12, ByteCode.MONITORENTER, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, ByteCode.GETSTATIC, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, ByteCode.INVOKEDYNAMIC, 83, ByteCode.INVOKEINTERFACE}, new int[]{83, ByteCode.MONITOREXIT, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, ByteCode.MONITOREXIT, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, ByteCode.FRETURN, ByteCode.INVOKEDYNAMIC, 172}, new int[]{52, 190, 88, HttpStatus.SC_RESET_CONTENT, 109, 39, ByteCode.ARETURN, 21, 155, ByteCode.MULTIANEWARRAY, 251, 223, 155, 21, 5, 172, 254, 124, 12, ByteCode.PUTFIELD, ByteCode.INVOKESTATIC, 96, 50, ByteCode.INSTANCEOF}, new int[]{Primes.SMALL_FACTOR_LIMIT, 231, 43, 97, 71, 96, 103, ByteCode.FRETURN, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, ByteCode.PUTFIELD, 102, 120, 84, ByteCode.PUTSTATIC, 220, 251, 80, ByteCode.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, ByteCode.DRETURN, ByteCode.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, ByteCode.INSTANCEOF, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, ByteCode.DRETURN, 95, 100, 9, ByteCode.GOTO, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, ByteCode.RETURN, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, HttpStatus.SC_RESET_CONTENT, 188, 237, 87, ByteCode.ATHROW, 106, 16, 147, 118, 23, 37, 90, 170, HttpStatus.SC_RESET_CONTENT, 131, 88, 120, 100, 66, 138, ByteCode.INVOKEDYNAMIC, 240, 82, 44, ByteCode.ARETURN, 87, ByteCode.NEW, 147, 160, ByteCode.DRETURN, 69, 213, 92, 253, 225, 19}, new int[]{ByteCode.DRETURN, 9, 223, 238, 12, 17, 220, 208, 100, 29, ByteCode.DRETURN, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, ByteCode.RET, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, ByteCode.WIDE, 37, ByteCode.INVOKEINTERFACE, 112, 134, 230, 245, 63, ByteCode.MULTIANEWARRAY, 190, 250, 106, ByteCode.INVOKEINTERFACE, Constants.EASY_PAY_MINIMIZE_ASSIST, ByteCode.DRETURN, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, ByteCode.ARETURN, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, ByteCode.LRETURN, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, ByteCode.MULTIANEWARRAY, 158, ByteCode.RETURN, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, ByteCode.INVOKEINTERFACE, 202, ByteCode.GOTO, ByteCode.PUTSTATIC, 25, 220, 232, 96, 210, 231, 136, 223, 239, ByteCode.PUTFIELD, 241, 59, 52, 172, 25, 49, 232, Primes.SMALL_FACTOR_LIMIT, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, ByteCode.INVOKEDYNAMIC}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, strCreateECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt != 0 && (i5 = iArr2[i9]) != 0) {
                    char c2 = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c2);
                } else {
                    cArr[i9] = cArr[i9 - 1];
                }
                i9--;
            }
            if (iCharAt != 0 && (i4 = iArr2[0]) != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
