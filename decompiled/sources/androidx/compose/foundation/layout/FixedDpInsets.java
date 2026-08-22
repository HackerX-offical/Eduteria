package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", InAppPurchaseConstants.METHOD_TO_STRING, "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    public /* synthetic */ FixedDpInsets(float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5);
    }

    private FixedDpInsets(float f2, float f3, float f4, float f5) {
        this.leftDp = f2;
        this.topDp = f3;
        this.rightDp = f4;
        this.bottomDp = f5;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return density.mo482roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return density.mo482roundToPx0680j_4(this.topDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return density.mo482roundToPx0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        return density.mo482roundToPx0680j_4(this.bottomDp);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.m8841toStringimpl(this.leftDp)) + ", top=" + ((Object) Dp.m8841toStringimpl(this.topDp)) + ", right=" + ((Object) Dp.m8841toStringimpl(this.rightDp)) + ", bottom=" + ((Object) Dp.m8841toStringimpl(this.bottomDp)) + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) other;
        return Dp.m8835equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m8835equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m8835equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && Dp.m8835equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    public int hashCode() {
        return (((((Dp.m8836hashCodeimpl(this.leftDp) * 31) + Dp.m8836hashCodeimpl(this.topDp)) * 31) + Dp.m8836hashCodeimpl(this.rightDp)) * 31) + Dp.m8836hashCodeimpl(this.bottomDp);
    }
}
