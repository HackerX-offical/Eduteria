package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u0010-\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016J\u001c\u0010/\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u00100\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f2, float f3, float f4, float f5, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, z);
    }

    private SizeNode(float f2, float f3, float f4, float f5, boolean z) {
        this.minWidth = f2;
        this.minHeight = f3;
        this.maxWidth = f4;
        this.maxHeight = f5;
        this.enforceIncoming = z;
    }

    public /* synthetic */ SizeNode(float f2, float f3, float f4, float f5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM() : f2, (i & 2) != 0 ? Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM() : f3, (i & 4) != 0 ? Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM() : f4, (i & 8) != 0 ? Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM() : f5, z, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m1237setMinWidth0680j_4(float f2) {
        this.minWidth = f2;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m1236setMinHeight0680j_4(float f2) {
        this.minHeight = f2;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m1235setMaxWidth0680j_4(float f2) {
        this.maxWidth = f2;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m1234setMaxHeight0680j_4(float f2) {
        this.maxHeight = f2;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long m1229getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density r7) {
        /*
            r6 = this;
            float r0 = r6.maxWidth
            boolean r0 = java.lang.Float.isNaN(r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            if (r0 != 0) goto L16
            float r0 = r6.maxWidth
            int r0 = r7.mo482roundToPx0680j_4(r0)
            if (r0 >= 0) goto L17
            r0 = r2
            goto L17
        L16:
            r0 = r1
        L17:
            float r3 = r6.maxHeight
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L29
            float r3 = r6.maxHeight
            int r3 = r7.mo482roundToPx0680j_4(r3)
            if (r3 >= 0) goto L2a
            r3 = r2
            goto L2a
        L29:
            r3 = r1
        L2a:
            float r4 = r6.minWidth
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L41
            float r4 = r6.minWidth
            int r4 = r7.mo482roundToPx0680j_4(r4)
            if (r4 >= 0) goto L3b
            r4 = r2
        L3b:
            if (r4 <= r0) goto L3e
            r4 = r0
        L3e:
            if (r4 == r1) goto L41
            goto L42
        L41:
            r4 = r2
        L42:
            float r5 = r6.minHeight
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L59
            float r5 = r6.minHeight
            int r7 = r7.mo482roundToPx0680j_4(r5)
            if (r7 >= 0) goto L53
            r7 = r2
        L53:
            if (r7 <= r3) goto L56
            r7 = r3
        L56:
            if (r7 == r1) goto L59
            r2 = r7
        L59:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r4, r0, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.m1229getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density):long");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM8785getMinWidthimpl;
        int iM8783getMaxWidthimpl;
        int iM8784getMinHeightimpl;
        int iM8782getMaxHeightimpl;
        long jConstraints;
        long jM1229getTargetConstraintsOenEA2s = m1229getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m8798constrainN9IONVI(j, jM1229getTargetConstraintsOenEA2s);
        } else {
            if (!Float.isNaN(this.minWidth)) {
                iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(jM1229getTargetConstraintsOenEA2s);
            } else {
                iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(j);
                int iM8783getMaxWidthimpl2 = Constraints.m8783getMaxWidthimpl(jM1229getTargetConstraintsOenEA2s);
                if (iM8785getMinWidthimpl > iM8783getMaxWidthimpl2) {
                    iM8785getMinWidthimpl = iM8783getMaxWidthimpl2;
                }
            }
            if (!Float.isNaN(this.maxWidth)) {
                iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(jM1229getTargetConstraintsOenEA2s);
            } else {
                iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
                int iM8785getMinWidthimpl2 = Constraints.m8785getMinWidthimpl(jM1229getTargetConstraintsOenEA2s);
                if (iM8783getMaxWidthimpl < iM8785getMinWidthimpl2) {
                    iM8783getMaxWidthimpl = iM8785getMinWidthimpl2;
                }
            }
            if (!Float.isNaN(this.minHeight)) {
                iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(jM1229getTargetConstraintsOenEA2s);
            } else {
                iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(j);
                int iM8782getMaxHeightimpl2 = Constraints.m8782getMaxHeightimpl(jM1229getTargetConstraintsOenEA2s);
                if (iM8784getMinHeightimpl > iM8782getMaxHeightimpl2) {
                    iM8784getMinHeightimpl = iM8782getMaxHeightimpl2;
                }
            }
            if (!Float.isNaN(this.maxHeight)) {
                iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(jM1229getTargetConstraintsOenEA2s);
            } else {
                iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
                int iM8784getMinHeightimpl2 = Constraints.m8784getMinHeightimpl(jM1229getTargetConstraintsOenEA2s);
                if (iM8782getMaxHeightimpl < iM8784getMinHeightimpl2) {
                    iM8782getMaxHeightimpl = iM8784getMinHeightimpl2;
                }
            }
            jConstraints = ConstraintsKt.Constraints(iM8785getMinWidthimpl, iM8783getMaxWidthimpl, iM8784getMinHeightimpl, iM8782getMaxHeightimpl);
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.SizeNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SizeNode.measure_3p2s80s$lambda$1(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1229getTargetConstraintsOenEA2s = m1229getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m8781getHasFixedWidthimpl(jM1229getTargetConstraintsOenEA2s)) {
            return Constraints.m8783getMaxWidthimpl(jM1229getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m8799constrainHeightK40F9xA(jM1229getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m8800constrainWidthK40F9xA(jM1229getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1229getTargetConstraintsOenEA2s = m1229getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m8780getHasFixedHeightimpl(jM1229getTargetConstraintsOenEA2s)) {
            return Constraints.m8782getMaxHeightimpl(jM1229getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m8800constrainWidthK40F9xA(jM1229getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m8799constrainHeightK40F9xA(jM1229getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1229getTargetConstraintsOenEA2s = m1229getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m8781getHasFixedWidthimpl(jM1229getTargetConstraintsOenEA2s)) {
            return Constraints.m8783getMaxWidthimpl(jM1229getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m8799constrainHeightK40F9xA(jM1229getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m8800constrainWidthK40F9xA(jM1229getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM1229getTargetConstraintsOenEA2s = m1229getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m8780getHasFixedHeightimpl(jM1229getTargetConstraintsOenEA2s)) {
            return Constraints.m8782getMaxHeightimpl(jM1229getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m8800constrainWidthK40F9xA(jM1229getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m8799constrainHeightK40F9xA(jM1229getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
