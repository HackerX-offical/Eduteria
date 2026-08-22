package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: IntRect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0016H\u0007¨\u0006\u0018"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "topLeft", "bottomRight", "IntRect-E1MhUcY", "center", Constants.KEY_RADIUS, "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "toRect", "Landroidx/compose/ui/geometry/Rect;", "roundToIntRect", "ui-unit"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IntRectKt {
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m8991IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m8958getXimpl(j), IntOffset.m8959getYimpl(j), IntOffset.m8958getXimpl(j) + ((int) (j2 >> 32)), IntOffset.m8959getYimpl(j) + ((int) (j2 & 4294967295L)));
    }

    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m8990IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m8958getXimpl(j), IntOffset.m8959getYimpl(j), IntOffset.m8958getXimpl(j2), IntOffset.m8959getYimpl(j2));
    }

    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m8992IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m8958getXimpl(j) - i, IntOffset.m8959getYimpl(j) - i, IntOffset.m8958getXimpl(j) + i, IntOffset.m8959getYimpl(j) + i);
    }

    public static final IntRect lerp(IntRect intRect, IntRect intRect2, float f2) {
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f2), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f2), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f2), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f2));
    }

    public static final Rect toRect(IntRect intRect) {
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }

    public static final IntRect roundToIntRect(Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }
}
