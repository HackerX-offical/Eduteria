package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM$annotations", "()V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaddingValuesImpl implements PaddingValues {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m1169getBottomD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m1170getEndD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m1171getStartD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m1172getTopD9Ej5fM$annotations() {
    }

    private PaddingValuesImpl(float f2, float f3, float f4, float f5) {
        this.start = f2;
        this.top = f3;
        this.end = f4;
        this.bottom = f5;
        if (!((f2 >= 0.0f) & (f3 >= 0.0f) & (f4 >= 0.0f)) || !(f5 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m1176getTopD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m1173getBottomD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo1096calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: from getter */
    public float getTop() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo1097calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: from getter */
    public float getBottom() {
        return this.bottom;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) other;
        return Dp.m8835equalsimpl0(this.start, paddingValuesImpl.start) && Dp.m8835equalsimpl0(this.top, paddingValuesImpl.top) && Dp.m8835equalsimpl0(this.end, paddingValuesImpl.end) && Dp.m8835equalsimpl0(this.bottom, paddingValuesImpl.bottom);
    }

    public int hashCode() {
        return (((((Dp.m8836hashCodeimpl(this.start) * 31) + Dp.m8836hashCodeimpl(this.top)) * 31) + Dp.m8836hashCodeimpl(this.end)) * 31) + Dp.m8836hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) Dp.m8841toStringimpl(this.start)) + ", top=" + ((Object) Dp.m8841toStringimpl(this.top)) + ", end=" + ((Object) Dp.m8841toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m8841toStringimpl(this.bottom)) + ')';
    }

    public /* synthetic */ PaddingValuesImpl(float f2, float f3, float f4, float f5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.m8830constructorimpl(0) : f2, (i & 2) != 0 ? Dp.m8830constructorimpl(0) : f3, (i & 4) != 0 ? Dp.m8830constructorimpl(0) : f4, (i & 8) != 0 ? Dp.m8830constructorimpl(0) : f5, null);
    }
}
