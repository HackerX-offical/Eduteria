package androidx.compose.ui.util;

import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: MathHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001\u001a)\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0001H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0012H\u0086\b\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0011\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b¨\u0006\u001a"}, d2 = {"lerp", "", "start", "stop", "fraction", "", "", "fastMinOf", "a", "b", "c", "d", "fastMaxOf", "fastCoerceIn", "minimumValue", "maximumValue", "fastCoerceAtLeast", "fastCoerceAtMost", "", "fastIsFinite", "", "fastCbrt", "x", "normalizedAngleSin", "normalizedDegrees", "normalizedAngleCos", "ui-util"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MathHelpersKt {
    public static final double fastCoerceAtLeast(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    public static final float fastCoerceAtLeast(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static final int fastCoerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long fastCoerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final double fastCoerceAtMost(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    public static final float fastCoerceAtMost(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static final int fastCoerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long fastCoerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final double fastCoerceIn(double d2, double d3, double d4) {
        if (d2 < d3) {
            d2 = d3;
        }
        return d2 > d4 ? d4 : d2;
    }

    public static final float fastCoerceIn(float f2, float f3, float f4) {
        if (f2 < f3) {
            f2 = f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    public static final int fastCoerceIn(int i, int i2, int i3) {
        if (i < i2) {
            i = i2;
        }
        return i > i3 ? i3 : i;
    }

    public static final long fastCoerceIn(long j, long j2, long j3) {
        if (j < j2) {
            j = j2;
        }
        return j > j3 ? j3 : j;
    }

    public static final float lerp(float f2, float f3, float f4) {
        return ((1 - f4) * f2) + (f4 * f3);
    }

    public static final long lerp(long j, long j2, float f2) {
        return j + MathKt.roundToLong((j2 - j) * ((double) f2));
    }

    public static final float fastMinOf(float f2, float f3, float f4, float f5) {
        return Math.min(f2, Math.min(f3, Math.min(f4, f5)));
    }

    public static final float fastMaxOf(float f2, float f3, float f4, float f5) {
        return Math.max(f2, Math.max(f3, Math.max(f4, f5)));
    }

    public static final boolean fastIsFinite(float f2) {
        return (Float.floatToRawIntBits(f2) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final boolean fastIsFinite(double d2) {
        return (Double.doubleToRawLongBits(d2) & Long.MAX_VALUE) < 9218868437227405312L;
    }

    public static final float fastCbrt(float f2) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(f2)) & 8589934591L) / ((long) 3))) + 709952852);
        float f3 = fIntBitsToFloat - ((fIntBitsToFloat - (f2 / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f3 - ((f3 - (f2 / (f3 * f3))) * 0.33333334f);
    }

    public static final float normalizedAngleSin(float f2) {
        float fFloor = f2 - ((float) Math.floor(0.5f + f2));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f3 = 1.0f - fAbs;
        return ((fFloor * 8.0f) * f3) / (1.25f - (fAbs * f3));
    }

    public static final int lerp(int i, int i2, float f2) {
        return i + ((int) Math.round(((double) (i2 - i)) * ((double) f2)));
    }

    public static final float normalizedAngleCos(float f2) {
        float fFloor = (f2 + 0.25f) - ((float) Math.floor(0.5f + r3));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f3 = 1.0f - fAbs;
        return ((fFloor * 8.0f) * f3) / (1.25f - (fAbs * f3));
    }
}
