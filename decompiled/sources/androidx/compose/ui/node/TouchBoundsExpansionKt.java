package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TouchBoundsExpansion.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0002\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"TouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "start", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "(IIII)J", "DpTouchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "Landroidx/compose/ui/unit/Dp;", "DpTouchBoundsExpansion-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TouchBoundsExpansionKt {
    public static /* synthetic */ long TouchBoundsExpansion$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return TouchBoundsExpansion(i, i2, i3, i4);
    }

    public static final long TouchBoundsExpansion(int i, int i2, int i3, int i4) {
        if (!(i >= 0 && i < 32768)) {
            InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
        }
        if (!(i2 >= 0 && i2 < 32768)) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
        }
        if (!(i3 >= 0 && i3 < 32768)) {
            InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
        }
        if (!(i4 >= 0 && i4 < 32768)) {
            InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
        }
        return TouchBoundsExpansion.m7851constructorimpl(TouchBoundsExpansion.INSTANCE.pack$ui(i, i2, i3, i4, true));
    }

    /* JADX INFO: renamed from: DpTouchBoundsExpansion-a9UjIt4, reason: not valid java name */
    public static final DpTouchBoundsExpansion m7865DpTouchBoundsExpansiona9UjIt4(float f2, float f3, float f4, float f5) {
        return new DpTouchBoundsExpansion(f2, f3, f4, f5, true, null);
    }

    /* JADX INFO: renamed from: DpTouchBoundsExpansion-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m7866DpTouchBoundsExpansiona9UjIt4$default(float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f4 = Dp.m8830constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f5 = Dp.m8830constructorimpl(0);
        }
        return m7865DpTouchBoundsExpansiona9UjIt4(f2, f3, f4, f5);
    }
}
