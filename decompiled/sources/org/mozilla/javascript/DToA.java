package org.mozilla.javascript;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    static final int DTOSTR_EXPONENTIAL = 3;
    static final int DTOSTR_FIXED = 2;
    static final int DTOSTR_PRECISION = 4;
    static final int DTOSTR_STANDARD = 0;
    static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;
    private static final int P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    private static final int[] dtoaModes = {0, 0, 3, 2, 2};

    private static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    private static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            i2++;
            if ((i & 1073741824) == 0) {
                return 32;
            }
        }
        return i2;
    }

    private static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    DToA() {
    }

    private static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static BigInteger d2b(double d2, int[] iArr, int[] iArr2) {
        byte[] bArr;
        int iLo0bits;
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        int i = (int) (jDoubleToLongBits >>> 32);
        int i2 = (int) jDoubleToLongBits;
        int i3 = 1048575 & i;
        int i4 = (i & Integer.MAX_VALUE) >>> 20;
        if (i4 != 0) {
            i3 |= 1048576;
        }
        int i5 = 1;
        if (i2 != 0) {
            bArr = new byte[8];
            iLo0bits = lo0bits(i2);
            int i6 = i2 >>> iLo0bits;
            if (iLo0bits != 0) {
                stuffBits(bArr, 4, i6 | (i3 << (32 - iLo0bits)));
                i3 >>= iLo0bits;
            } else {
                stuffBits(bArr, 4, i6);
            }
            stuffBits(bArr, 0, i3);
            if (i3 != 0) {
                i5 = 2;
            }
        } else {
            bArr = new byte[4];
            int iLo0bits2 = lo0bits(i3);
            i3 >>>= iLo0bits2;
            stuffBits(bArr, 0, i3);
            iLo0bits = iLo0bits2 + 32;
        }
        if (i4 != 0) {
            iArr[0] = (i4 - 1075) + iLo0bits;
            iArr2[0] = 53 - iLo0bits;
        } else {
            iArr[0] = (i4 - 1074) + iLo0bits;
            iArr2[0] = (i5 * 32) - hi0bits(i3);
        }
        return new BigInteger(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0122, code lost:
    
        if (r8 > 0) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String JS_dtobasestr(int r12, double r13) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtobasestr(int, double):java.lang.String");
    }

    static int word0(double d2) {
        return (int) (Double.doubleToLongBits(d2) >> 32);
    }

    static double setWord0(double d2, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d2) & 4294967295L) | (((long) i) << 32));
    }

    static int word1(double d2) {
        return (int) Double.doubleToLongBits(d2);
    }

    static BigInteger pow5mult(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i));
    }

    static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            int i = length - 1;
            char cCharAt = sb.charAt(i);
            if (cCharAt != '9') {
                sb.setCharAt(i, (char) (cCharAt + 1));
                sb.setLength(length);
                return false;
            }
            length = i;
        }
        sb.setLength(0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:351:0x05f0, code lost:
    
        if (r13 <= 0) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x05f2, code lost:
    
        r2 = r8.shiftLeft(1).compareTo(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x05fb, code lost:
    
        if (r2 > 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x05fd, code lost:
    
        if (r2 != 0) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0601, code lost:
    
        if ((r3 & 1) == 1) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0603, code lost:
    
        if (r49 == false) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0606, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0608, code lost:
    
        r0 = (char) (r3 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x060d, code lost:
    
        if (r3 != '9') goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x060f, code lost:
    
        r52.append('9');
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0616, code lost:
    
        if (roundOff(r52) == false) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0618, code lost:
    
        r9 = r9 + 1;
        r52.append('1');
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0621, code lost:
    
        return r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0622, code lost:
    
        r2 = 1;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0625, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0626, code lost:
    
        r52.append(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x062a, code lost:
    
        return r9 + r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x064f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0662  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int JS_dtoa(double r46, int r48, boolean r49, int r50, boolean[] r51, java.lang.StringBuilder r52) {
        /*
            Method dump skipped, instruction units count: 1667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtoa(double, int, boolean, int, boolean[], java.lang.StringBuilder):int");
    }

    private static void stripTrailingZeroes(StringBuilder sb) {
        int length = sb.length();
        while (true) {
            int i = length - 1;
            if (length <= 0 || sb.charAt(i) != '0') {
                break;
            } else {
                length = i;
            }
        }
        sb.setLength(length);
    }

    static void JS_dtostr(StringBuilder sb, int i, int i2, double d2) {
        boolean z;
        boolean[] zArr = new boolean[1];
        if (i == 2 && (d2 >= 1.0E21d || d2 <= -1.0E21d)) {
            i = 0;
        }
        int i3 = i2;
        int iJS_dtoa = JS_dtoa(d2, dtoaModes[i], i >= 2, i3, zArr, sb);
        int length = sb.length();
        if (iJS_dtoa != 9999) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        i3 = i3 >= 0 ? iJS_dtoa + i3 : iJS_dtoa;
                    } else if (i != 3) {
                        if (i != 4) {
                            z = false;
                            i3 = 0;
                        } else if (iJS_dtoa < -5 || iJS_dtoa > i3) {
                        }
                    }
                    z = false;
                } else {
                    i3 = 0;
                }
                z = true;
            } else {
                if (iJS_dtoa < -5 || iJS_dtoa > 21) {
                    z = true;
                    i3 = 0;
                }
                z = false;
            }
            if (length < i3) {
                do {
                    sb.append('0');
                } while (sb.length() != i3);
                length = i3;
            }
            if (z) {
                if (length != 1) {
                    sb.insert(1, '.');
                }
                sb.append('e');
                int i4 = iJS_dtoa - 1;
                if (i4 >= 0) {
                    sb.append('+');
                }
                sb.append(i4);
            } else if (iJS_dtoa != length) {
                if (iJS_dtoa > 0) {
                    sb.insert(iJS_dtoa, '.');
                } else {
                    for (int i5 = 0; i5 < 1 - iJS_dtoa; i5++) {
                        sb.insert(0, '0');
                    }
                    sb.insert(1, '.');
                }
            }
        }
        if (zArr[0]) {
            if (word0(d2) == Integer.MIN_VALUE && word1(d2) == 0) {
                return;
            }
            if ((word0(d2) & Exp_mask) != Exp_mask || (word1(d2) == 0 && (word0(d2) & 1048575) == 0)) {
                sb.insert(0, '-');
            }
        }
    }
}
