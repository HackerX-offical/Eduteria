package org.mozilla.javascript.v8dtoa;

/* JADX INFO: loaded from: classes10.dex */
public class DoubleHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int kDenormalExponent = -1074;
    private static final int kExponentBias = 1075;
    static final long kExponentMask = 9218868437227405312L;
    static final long kHiddenBit = 4503599627370496L;
    static final long kSignMask = Long.MIN_VALUE;
    static final long kSignificandMask = 4503599627370495L;
    private static final int kSignificandSize = 52;

    static boolean isDenormal(long j) {
        return (j & kExponentMask) == 0;
    }

    static boolean isInfinite(long j) {
        return (j & kExponentMask) == kExponentMask && (j & kSignificandMask) == 0;
    }

    static boolean isNan(long j) {
        return (j & kExponentMask) == kExponentMask && (j & kSignificandMask) != 0;
    }

    static boolean isSpecial(long j) {
        return (j & kExponentMask) == kExponentMask;
    }

    static int sign(long j) {
        return (j & Long.MIN_VALUE) == 0 ? 1 : -1;
    }

    static DiyFp asDiyFp(long j) {
        return new DiyFp(significand(j), exponent(j));
    }

    static DiyFp asNormalizedDiyFp(long j) {
        long jSignificand = significand(j);
        int iExponent = exponent(j);
        while ((kHiddenBit & jSignificand) == 0) {
            jSignificand <<= 1;
            iExponent--;
        }
        return new DiyFp(jSignificand << 11, iExponent - 11);
    }

    static int exponent(long j) {
        return isDenormal(j) ? kDenormalExponent : ((int) (((j & kExponentMask) >>> 52) & 4294967295L)) - 1075;
    }

    static long significand(long j) {
        long j2 = kSignificandMask & j;
        return !isDenormal(j) ? j2 + kHiddenBit : j2;
    }

    static void normalizedBoundaries(long j, DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFpAsDiyFp = asDiyFp(j);
        boolean z = diyFpAsDiyFp.f() == kHiddenBit;
        diyFp2.setF((diyFpAsDiyFp.f() << 1) + 1);
        diyFp2.setE(diyFpAsDiyFp.e() - 1);
        diyFp2.normalize();
        if (z && diyFpAsDiyFp.e() != kDenormalExponent) {
            diyFp.setF((diyFpAsDiyFp.f() << 2) - 1);
            diyFp.setE(diyFpAsDiyFp.e() - 2);
        } else {
            diyFp.setF((diyFpAsDiyFp.f() << 1) - 1);
            diyFp.setE(diyFpAsDiyFp.e() - 1);
        }
        diyFp.setF(diyFp.f() << (diyFp.e() - diyFp2.e()));
        diyFp.setE(diyFp2.e());
    }
}
