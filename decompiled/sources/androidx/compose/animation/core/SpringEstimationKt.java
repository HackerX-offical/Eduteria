package androidx.compose.animation.core;

import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a0\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a@\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a9\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001aH\u0082\b\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "springConstant", "dampingCoefficient", "mass", "estimateUnderDamped", "firstRootReal", "firstRootImaginary", "p0", "v0", "estimateCriticallyDamped", "estimateOverDamped", "secondRootReal", "estimateDurationInternal", "initialPosition", "iterateNewtonsMethod", "x", UserDataStore.FIRST_NAME, "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    public static final long estimateAnimationDurationMillis(float f2, float f3, float f4, float f5, float f6) {
        return f3 == 0.0f ? MAX_LONG_MILLIS : estimateAnimationDurationMillis(f2, f3, f4, f5, f6);
    }

    public static final long estimateAnimationDurationMillis(double d2, double d3, double d4, double d5, double d6) {
        double dSqrt = 2.0d * d3 * Math.sqrt(d2);
        double d7 = (dSqrt * dSqrt) - (4.0d * d2);
        double dSqrt2 = d7 < 0.0d ? 0.0d : Math.sqrt(d7);
        double d8 = -dSqrt;
        return estimateDurationInternal((d8 + dSqrt2) * 0.5d, (d7 < 0.0d ? Math.sqrt(Math.abs(d7)) : 0.0d) * 0.5d, (d8 - dSqrt2) * 0.5d, d3, d4, d5, d6);
    }

    public static final long estimateAnimationDurationMillis(double d2, double d3, double d4, double d5, double d6, double d7) {
        double dSqrt = d3 / (Math.sqrt(d2 * d4) * 2.0d);
        double d8 = (d3 * d3) - ((4.0d * d4) * d2);
        double d9 = 1.0d / (2.0d * d4);
        double dSqrt2 = d8 < 0.0d ? 0.0d : Math.sqrt(d8);
        double d10 = -d3;
        return estimateDurationInternal((d10 + dSqrt2) * d9, (d8 < 0.0d ? Math.sqrt(Math.abs(d8)) : 0.0d) * d9, (d10 - dSqrt2) * d9, dSqrt, d5, d6, d7);
    }

    private static final double estimateUnderDamped(double d2, double d3, double d4, double d5, double d6) {
        double d7 = (d5 - (d2 * d4)) / d3;
        return Math.log(d6 / Math.sqrt((d4 * d4) + (d7 * d7))) / d2;
    }

    private static final double estimateCriticallyDamped(double d2, double d3, double d4, double d5) {
        double d6 = d5;
        double d7 = d2 * d3;
        double d8 = d4 - d7;
        double dLog = Math.log(Math.abs(d6 / d3)) / d2;
        double dLog2 = Math.log(Math.abs(d6 / d8));
        int i = 0;
        double dLog3 = dLog2;
        for (int i2 = 0; i2 < 6; i2++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / d2));
        }
        double d9 = dLog3 / d2;
        if (!((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) < 9218868437227405312L)) {
            dLog = d9;
        } else if ((Double.doubleToRawLongBits(d9) & Long.MAX_VALUE) < 9218868437227405312L) {
            dLog = Math.max(dLog, d9);
        }
        double d10 = (-(d7 + d8)) / (d2 * d8);
        double d11 = d2 * d10;
        double dExp = (Math.exp(d11) * d3) + (d8 * d10 * Math.exp(d11));
        if (Double.isNaN(d10) || d10 <= 0.0d) {
            d6 = -d6;
        } else if (d10 <= 0.0d || (-dExp) >= d6) {
            dLog = (-(2.0d / d2)) - (d3 / d8);
        } else {
            if (d8 < 0.0d && d3 > 0.0d) {
                dLog = 0.0d;
            }
            d6 = -d6;
        }
        double dAbs = Double.MAX_VALUE;
        while (dAbs > 0.001d && i < 100) {
            i++;
            double d12 = d2 * dLog;
            double d13 = d6;
            double dExp2 = dLog - ((((d3 + (d8 * dLog)) * Math.exp(d12)) + d6) / ((((((double) 1) + d12) * d8) + d7) * Math.exp(d12)));
            dAbs = Math.abs(dLog - dExp2);
            dLog = dExp2;
            d6 = d13;
        }
        return dLog;
    }

    private static final double estimateOverDamped(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d6;
        double d8 = d2 - d3;
        double d9 = ((d2 * d4) - d5) / d8;
        double d10 = d4 - d9;
        double dLog = Math.log(Math.abs(d7 / d10)) / d2;
        double dLog2 = Math.log(Math.abs(d7 / d9)) / d3;
        if ((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) < 9218868437227405312L) {
            if ((Double.doubleToRawLongBits(dLog2) & Long.MAX_VALUE) < 9218868437227405312L) {
                dLog = Math.max(dLog, dLog2);
            }
        } else {
            dLog = dLog2;
        }
        double d11 = d10 * d2;
        double dLog3 = Math.log(d11 / ((-d9) * d3)) / (d3 - d2);
        if (Double.isNaN(dLog3) || dLog3 <= 0.0d) {
            d7 = -d7;
        } else if (dLog3 <= 0.0d || (-estimateOverDamped$xInflection(d10, d2, dLog3, d9, d3)) >= d7) {
            dLog = Math.log((-((d9 * d3) * d3)) / (d11 * d2)) / d8;
        } else {
            if (d9 > 0.0d && d10 < 0.0d) {
                dLog = 0.0d;
            }
            d7 = -d7;
        }
        double d12 = d9 * d3;
        if (Math.abs((Math.exp(d2 * dLog) * d11) + (Math.exp(d3 * dLog) * d12)) < 1.0E-4d) {
            return dLog;
        }
        double dAbs = Double.MAX_VALUE;
        int i = 0;
        while (dAbs > 0.001d && i < 100) {
            i++;
            double d13 = d2 * dLog;
            double d14 = d3 * dLog;
            double dExp = dLog - ((((Math.exp(d13) * d10) + (Math.exp(d14) * d9)) + d7) / ((Math.exp(d13) * d11) + (Math.exp(d14) * d12)));
            dAbs = Math.abs(dLog - dExp);
            dLog = dExp;
        }
        return dLog;
    }

    private static final double estimateOverDamped$xInflection(double d2, double d3, double d4, double d5, double d6) {
        return (d2 * Math.exp(d3 * d4)) + (d5 * Math.exp(d6 * d4));
    }

    private static final long estimateDurationInternal(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double dEstimateCriticallyDamped;
        double d9 = d6;
        if (d7 == 0.0d && d9 == 0.0d) {
            return 0L;
        }
        if (d7 < 0.0d) {
            d9 = -d9;
        }
        double d10 = d9;
        double dAbs = Math.abs(d7);
        if (d5 > 1.0d) {
            dEstimateCriticallyDamped = estimateOverDamped(d2, d4, dAbs, d10, d8);
        } else if (d5 < 1.0d) {
            dEstimateCriticallyDamped = estimateUnderDamped(d2, d3, dAbs, d10, d8);
        } else {
            dEstimateCriticallyDamped = estimateCriticallyDamped(d2, dAbs, d10, d8);
        }
        return (long) (dEstimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d2, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d2 - (function1.invoke(Double.valueOf(d2)).doubleValue() / function12.invoke(Double.valueOf(d2)).doubleValue());
    }

    private static final boolean isNotFinite(double d2) {
        return !((Double.doubleToRawLongBits(d2) & Long.MAX_VALUE) < 9218868437227405312L);
    }
}
