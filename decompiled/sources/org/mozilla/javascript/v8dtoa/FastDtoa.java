package org.mozilla.javascript.v8dtoa;

/* JADX INFO: loaded from: classes10.dex */
public class FastDtoa {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kFastDtoaMaximalLength = 17;
    static final int kTen4 = 10000;
    static final int kTen5 = 100000;
    static final int kTen6 = 1000000;
    static final int kTen7 = 10000000;
    static final int kTen8 = 100000000;
    static final int kTen9 = 1000000000;
    static final int maximal_target_exponent = -32;
    static final int minimal_target_exponent = -60;

    static long biggestPowerTen(int i, int i2) {
        int i3;
        int i4 = 1;
        int i5 = 0;
        switch (i2) {
            case 30:
            case 31:
            case 32:
                i3 = 1000000000;
                if (1000000000 <= i) {
                    i4 = 9;
                }
                i5 = i4;
                i4 = i3;
            case 27:
            case 28:
            case 29:
                i3 = kTen8;
                if (kTen8 <= i) {
                    i4 = 8;
                }
                i5 = i4;
                i4 = i3;
            case 24:
            case 25:
            case 26:
                i3 = kTen7;
                if (kTen7 <= i) {
                    i4 = 7;
                }
                i5 = i4;
                i4 = i3;
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 1000000;
                if (1000000 <= i) {
                    i4 = 6;
                }
                i5 = i4;
                i4 = i3;
            case 17:
            case 18:
            case 19:
                i3 = 100000;
                if (100000 <= i) {
                    i4 = 5;
                }
                i5 = i4;
                i4 = i3;
            case 14:
            case 15:
            case 16:
                i3 = 10000;
                if (10000 <= i) {
                    i4 = 4;
                }
                i5 = i4;
                i4 = i3;
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 1000;
                if (1000 <= i) {
                    i4 = 3;
                }
                i5 = i4;
                i4 = i3;
            case 7:
            case 8:
            case 9:
                i3 = 100;
                if (100 <= i) {
                    i4 = 2;
                }
                i5 = i4;
                i4 = i3;
            case 4:
            case 5:
            case 6:
                i3 = 10;
                if (10 <= i) {
                    i5 = i4;
                    i4 = i3;
                    break;
                }
            case 1:
            case 2:
            case 3:
                if (1 > i) {
                }
            case 0:
                i5 = -1;
                i4 = 0;
                break;
            default:
                i4 = 0;
                break;
        }
        return (((long) i4) << 32) | (((long) i5) & 4294967295L);
    }

    private static boolean uint64_lte(long j, long j2) {
        if (j != j2) {
            if (!(((j < 0) ^ (j < j2)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    static boolean roundWeed(FastDtoaBuilder fastDtoaBuilder, long j, long j2, long j3, long j4, long j5) {
        long j6 = j - j5;
        long j7 = j + j5;
        long j8 = j3;
        while (j8 < j6 && j2 - j8 >= j4) {
            long j9 = j8 + j4;
            if (j9 >= j6 && j6 - j8 < j9 - j6) {
                break;
            }
            fastDtoaBuilder.decreaseLast();
            j8 = j9;
        }
        if (j8 < j7 && j2 - j8 >= j4) {
            long j10 = j8 + j4;
            if (j10 < j7 || j7 - j8 > j10 - j7) {
                return false;
            }
        }
        return 2 * j5 <= j8 && j8 <= j2 - (4 * j5);
    }

    static boolean digitGen(DiyFp diyFp, DiyFp diyFp2, DiyFp diyFp3, FastDtoaBuilder fastDtoaBuilder, int i) {
        FastDtoaBuilder fastDtoaBuilder2 = fastDtoaBuilder;
        long j = 1;
        DiyFp diyFp4 = new DiyFp(diyFp.f() - 1, diyFp.e());
        DiyFp diyFp5 = new DiyFp(diyFp3.f() + 1, diyFp3.e());
        DiyFp diyFpMinus = DiyFp.minus(diyFp5, diyFp4);
        DiyFp diyFp6 = new DiyFp(1 << (-diyFp2.e()), diyFp2.e());
        int iF = (int) ((diyFp5.f() >>> (-diyFp6.e())) & 4294967295L);
        long jF = diyFp5.f() & (diyFp6.f() - 1);
        long jBiggestPowerTen = biggestPowerTen(iF, 64 - (-diyFp6.e()));
        int i2 = (int) ((jBiggestPowerTen >>> 32) & 4294967295L);
        boolean z = true;
        int i3 = ((int) (jBiggestPowerTen & 4294967295L)) + 1;
        while (i3 > 0) {
            fastDtoaBuilder2.append((char) ((iF / i2) + 48));
            iF %= i2;
            i3--;
            boolean z2 = z;
            long j2 = (((long) iF) << (-diyFp6.e())) + jF;
            if (j2 < diyFpMinus.f()) {
                fastDtoaBuilder2.point = (fastDtoaBuilder2.end - i) + i3;
                return roundWeed(fastDtoaBuilder2, DiyFp.minus(diyFp5, diyFp2).f(), diyFpMinus.f(), j2, ((long) i2) << (-diyFp6.e()), 1L);
            }
            i2 /= 10;
            z = z2;
            j = 1;
        }
        boolean z3 = z;
        while (true) {
            long j3 = jF * 5;
            j *= 5;
            diyFpMinus.setF(5 * diyFpMinus.f());
            diyFpMinus.setE(diyFpMinus.e() + 1);
            diyFp6.setF(diyFp6.f() >>> (z3 ? 1L : 0L));
            diyFp6.setE(diyFp6.e() + 1);
            fastDtoaBuilder2.append((char) (((int) ((j3 >>> (-diyFp6.e())) & 4294967295L)) + 48));
            long jF2 = (diyFp6.f() - 1) & j3;
            i3--;
            if (jF2 < diyFpMinus.f()) {
                fastDtoaBuilder2.point = (fastDtoaBuilder2.end - i) + i3;
                return roundWeed(fastDtoaBuilder, DiyFp.minus(diyFp5, diyFp2).f() * j, diyFpMinus.f(), jF2, diyFp6.f(), j);
            }
            fastDtoaBuilder2 = fastDtoaBuilder;
            jF = jF2;
        }
    }

    static boolean grisu3(double d2, FastDtoaBuilder fastDtoaBuilder) {
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        DiyFp diyFpAsNormalizedDiyFp = DoubleHelper.asNormalizedDiyFp(jDoubleToLongBits);
        DiyFp diyFp = new DiyFp();
        DiyFp diyFp2 = new DiyFp();
        DoubleHelper.normalizedBoundaries(jDoubleToLongBits, diyFp, diyFp2);
        DiyFp diyFp3 = new DiyFp();
        int cachedPower = CachedPowers.getCachedPower(diyFpAsNormalizedDiyFp.e() + 64, minimal_target_exponent, maximal_target_exponent, diyFp3);
        return digitGen(DiyFp.times(diyFp, diyFp3), DiyFp.times(diyFpAsNormalizedDiyFp, diyFp3), DiyFp.times(diyFp2, diyFp3), fastDtoaBuilder, cachedPower);
    }

    public static boolean dtoa(double d2, FastDtoaBuilder fastDtoaBuilder) {
        return grisu3(d2, fastDtoaBuilder);
    }

    public static String numberToString(double d2) {
        FastDtoaBuilder fastDtoaBuilder = new FastDtoaBuilder();
        if (numberToString(d2, fastDtoaBuilder)) {
            return fastDtoaBuilder.format();
        }
        return null;
    }

    public static boolean numberToString(double d2, FastDtoaBuilder fastDtoaBuilder) {
        fastDtoaBuilder.reset();
        if (d2 < 0.0d) {
            fastDtoaBuilder.append('-');
            d2 = -d2;
        }
        return dtoa(d2, fastDtoaBuilder);
    }
}
