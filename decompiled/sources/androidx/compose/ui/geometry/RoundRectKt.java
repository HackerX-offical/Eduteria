package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: RoundRect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0003\"\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b \u0010\u001e\"\u0015\u0010!\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010#\"\u0015\u0010$\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b$\u0010#\"\u0015\u0010%\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0015\u0010&\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010#\"\u0015\u0010'\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b'\u0010#\"\u0015\u0010(\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010+\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b,\u0010*\"\u0015\u0010-\u001a\u00020\u0019*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b0\u0010#¨\u00065"}, d2 = {"RoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "radiusX", "radiusY", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "rect", "Landroidx/compose/ui/geometry/Rect;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "translate", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "boundingRect", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "safeInnerRect", "getSafeInnerRect", "isEmpty", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isFinite", "isRect", "isEllipse", "isCircle", "minDimension", "getMinDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "maxDimension", "getMaxDimension", "center", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isSimple", "lerp", "start", "stop", "fraction", "ui-geometry"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RoundRectKt {
    public static final RoundRect RoundRect(Rect rect, float f2, float f3) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f2, f3);
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m5775RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m5779translateUv8p0NA(RoundRect roundRect, long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (4294967295L & j);
        return new RoundRect(roundRect.getLeft() + Float.intBitsToFloat(i), roundRect.getTop() + Float.intBitsToFloat(i2), roundRect.getRight() + Float.intBitsToFloat(i), Float.intBitsToFloat(i2) + roundRect.getBottom(), roundRect.m5773getTopLeftCornerRadiuskKHJgLs(), roundRect.m5774getTopRightCornerRadiuskKHJgLs(), roundRect.m5772getBottomRightCornerRadiuskKHJgLs(), roundRect.m5771getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft() + (Math.max(Float.intBitsToFloat((int) (roundRect.m5771getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m5773getTopLeftCornerRadiuskKHJgLs() >> 32))) * 0.29289323f), roundRect.getTop() + (Math.max(Float.intBitsToFloat((int) (roundRect.m5773getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m5774getTopRightCornerRadiuskKHJgLs() & 4294967295L))) * 0.29289323f), roundRect.getRight() - (Math.max(Float.intBitsToFloat((int) (roundRect.m5774getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m5772getBottomRightCornerRadiuskKHJgLs() >> 32))) * 0.29289323f), roundRect.getBottom() - (Math.max(Float.intBitsToFloat((int) (roundRect.m5772getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m5771getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        return (Float.floatToRawIntBits(roundRect.getLeft()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getTop()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getRight()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getBottom()) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final boolean isRect(RoundRect roundRect) {
        long jM5773getTopLeftCornerRadiuskKHJgLs = roundRect.m5773getTopLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM5773getTopLeftCornerRadiuskKHJgLs) & (jM5773getTopLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM5774getTopRightCornerRadiuskKHJgLs = roundRect.m5774getTopRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM5774getTopRightCornerRadiuskKHJgLs) & (jM5774getTopRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM5771getBottomLeftCornerRadiuskKHJgLs = roundRect.m5771getBottomLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM5771getBottomLeftCornerRadiuskKHJgLs) & (jM5771getBottomLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM5772getBottomRightCornerRadiuskKHJgLs = roundRect.m5772getBottomRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        return (((~jM5772getBottomRightCornerRadiuskKHJgLs) & (jM5772getBottomRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0;
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        return roundRect.m5773getTopLeftCornerRadiuskKHJgLs() == roundRect.m5774getTopRightCornerRadiuskKHJgLs() && roundRect.m5774getTopRightCornerRadiuskKHJgLs() == roundRect.m5772getBottomRightCornerRadiuskKHJgLs() && roundRect.m5772getBottomRightCornerRadiuskKHJgLs() == roundRect.m5771getBottomLeftCornerRadiuskKHJgLs() && ((double) roundRect.getWidth()) <= ((double) Float.intBitsToFloat((int) (roundRect.m5773getTopLeftCornerRadiuskKHJgLs() >> 32))) * 2.0d && ((double) roundRect.getHeight()) <= ((double) Float.intBitsToFloat((int) (roundRect.m5773getTopLeftCornerRadiuskKHJgLs() & 4294967295L))) * 2.0d;
    }

    public static final boolean isCircle(RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final float getMinDimension(RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(RoundRect roundRect) {
        float left = roundRect.getLeft() + (roundRect.getWidth() / 2.0f);
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(roundRect.getTop() + (roundRect.getHeight() / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        long jM5773getTopLeftCornerRadiuskKHJgLs = roundRect.m5773getTopLeftCornerRadiuskKHJgLs();
        return (jM5773getTopLeftCornerRadiuskKHJgLs >>> 32) == (jM5773getTopLeftCornerRadiuskKHJgLs & 4294967295L) && roundRect.m5773getTopLeftCornerRadiuskKHJgLs() == roundRect.m5774getTopRightCornerRadiuskKHJgLs() && roundRect.m5773getTopLeftCornerRadiuskKHJgLs() == roundRect.m5772getBottomRightCornerRadiuskKHJgLs() && roundRect.m5773getTopLeftCornerRadiuskKHJgLs() == roundRect.m5771getBottomLeftCornerRadiuskKHJgLs();
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f2) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f2), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f2), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f2), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f2), CornerRadiusKt.m5696lerp3Ry4LBc(roundRect.m5773getTopLeftCornerRadiuskKHJgLs(), roundRect2.m5773getTopLeftCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m5696lerp3Ry4LBc(roundRect.m5774getTopRightCornerRadiuskKHJgLs(), roundRect2.m5774getTopRightCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m5696lerp3Ry4LBc(roundRect.m5772getBottomRightCornerRadiuskKHJgLs(), roundRect2.m5772getBottomRightCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m5696lerp3Ry4LBc(roundRect.m5771getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m5771getBottomLeftCornerRadiuskKHJgLs(), f2), null);
    }

    public static final RoundRect RoundRect(float f2, float f3, float f4, float f5, float f6, float f7) {
        long jM5677constructorimpl = CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L));
        return new RoundRect(f2, f3, f4, f5, jM5677constructorimpl, jM5677constructorimpl, jM5677constructorimpl, jM5677constructorimpl, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m5777RoundRectgG7oq9Y(float f2, float f3, float f4, float f5, long j) {
        return RoundRect(f2, f3, f4, f5, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m5778RoundRectsniSvfs(Rect rect, long j) {
        return RoundRect(rect, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }
}
