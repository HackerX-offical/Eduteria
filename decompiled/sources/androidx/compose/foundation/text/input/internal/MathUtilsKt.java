package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MathUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "findClosestRect", "Landroidx/compose/ui/geometry/Offset;", "rect1", "Landroidx/compose/ui/geometry/Rect;", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "distanceSquaredToClosestCornerFromOutside", "", "rect", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, Function0<Integer> function0) {
        int i3 = i + i2;
        return ((i ^ i3) & (i2 ^ i3)) < 0 ? function0.invoke().intValue() : i3;
    }

    public static final int subtractExactOrElse(int i, int i2, Function0<Integer> function0) {
        int i3 = i - i2;
        return ((i ^ i3) & (i2 ^ i)) < 0 ? function0.invoke().intValue() : i3;
    }

    /* JADX INFO: renamed from: findClosestRect-9KIMszo, reason: not valid java name */
    public static final int m2048findClosestRect9KIMszo(long j, Rect rect, Rect rect2) {
        float fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k = m2047distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect);
        float fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k2 = m2047distanceSquaredToClosestCornerFromOutside3MmeM6k(j, rect2);
        if (fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k == fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k2) {
            return 0;
        }
        return fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k < fM2047distanceSquaredToClosestCornerFromOutside3MmeM6k2 ? -1 : 1;
    }

    /* JADX INFO: renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k, reason: not valid java name */
    private static final float m2047distanceSquaredToClosestCornerFromOutside3MmeM6k(long j, Rect rect) {
        if (SelectionManagerKt.m2340containsInclusiveUv8p0NA(rect, j)) {
            return 0.0f;
        }
        float fM5722getDistanceSquaredimpl = Offset.m5722getDistanceSquaredimpl(Offset.m5727minusMKHz9U(rect.m5758getTopLeftF1C5BW0(), j));
        if (fM5722getDistanceSquaredimpl >= Float.MAX_VALUE) {
            fM5722getDistanceSquaredimpl = Float.MAX_VALUE;
        }
        float fM5722getDistanceSquaredimpl2 = Offset.m5722getDistanceSquaredimpl(Offset.m5727minusMKHz9U(rect.m5759getTopRightF1C5BW0(), j));
        if (fM5722getDistanceSquaredimpl2 < fM5722getDistanceSquaredimpl) {
            fM5722getDistanceSquaredimpl = fM5722getDistanceSquaredimpl2;
        }
        float fM5722getDistanceSquaredimpl3 = Offset.m5722getDistanceSquaredimpl(Offset.m5727minusMKHz9U(rect.m5751getBottomLeftF1C5BW0(), j));
        if (fM5722getDistanceSquaredimpl3 < fM5722getDistanceSquaredimpl) {
            fM5722getDistanceSquaredimpl = fM5722getDistanceSquaredimpl3;
        }
        float fM5722getDistanceSquaredimpl4 = Offset.m5722getDistanceSquaredimpl(Offset.m5727minusMKHz9U(rect.m5752getBottomRightF1C5BW0(), j));
        return fM5722getDistanceSquaredimpl4 < fM5722getDistanceSquaredimpl ? fM5722getDistanceSquaredimpl4 : fM5722getDistanceSquaredimpl;
    }
}
