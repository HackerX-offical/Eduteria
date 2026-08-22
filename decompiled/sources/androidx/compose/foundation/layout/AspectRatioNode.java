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
import androidx.compose.ui.unit.IntSize;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010 \u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u001c\u0010\"\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0013\u0010#\u001a\u00020$*\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001b\u0010-\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010*J\u001b\u0010/\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010*R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", Constants.INAPP_ASPECT_RATIO, "", "matchHeightConstraintsFirst", "", "<init>", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "maxIntrinsicWidth", "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicHeight", "findSize", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "tryMaxWidth", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxHeight", "tryMaxHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f2, boolean z) {
        this.aspectRatio = f2;
        this.matchHeightConstraintsFirst = z;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setAspectRatio(float f2) {
        this.aspectRatio = f2;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM845findSizeToXhtMw = m845findSizeToXhtMw(j);
        if (!IntSize.m8999equalsimpl0(jM845findSizeToXhtMw, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m8793fixedJhjzzOo((int) (jM845findSizeToXhtMw >> 32), (int) (jM845findSizeToXhtMw & 4294967295L));
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.AspectRatioNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AspectRatioNode.measure_3p2s80s$lambda$0(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m845findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM847tryMaxWidthJN0ABg = m847tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM847tryMaxWidthJN0ABg, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM847tryMaxWidthJN0ABg;
            }
            long jM846tryMaxHeightJN0ABg = m846tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM846tryMaxHeightJN0ABg, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM846tryMaxHeightJN0ABg;
            }
            long jM849tryMinWidthJN0ABg = m849tryMinWidthJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM849tryMinWidthJN0ABg, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM849tryMinWidthJN0ABg;
            }
            long jM848tryMinHeightJN0ABg = m848tryMinHeightJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM848tryMinHeightJN0ABg, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM848tryMinHeightJN0ABg;
            }
            long jM847tryMaxWidthJN0ABg2 = m847tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM847tryMaxWidthJN0ABg2, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM847tryMaxWidthJN0ABg2;
            }
            long jM846tryMaxHeightJN0ABg2 = m846tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM846tryMaxHeightJN0ABg2, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM846tryMaxHeightJN0ABg2;
            }
            long jM849tryMinWidthJN0ABg2 = m849tryMinWidthJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM849tryMinWidthJN0ABg2, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM849tryMinWidthJN0ABg2;
            }
            long jM848tryMinHeightJN0ABg2 = m848tryMinHeightJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM848tryMinHeightJN0ABg2, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM848tryMinHeightJN0ABg2;
            }
        } else {
            long jM846tryMaxHeightJN0ABg3 = m846tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM846tryMaxHeightJN0ABg3, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM846tryMaxHeightJN0ABg3;
            }
            long jM847tryMaxWidthJN0ABg3 = m847tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM847tryMaxWidthJN0ABg3, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM847tryMaxWidthJN0ABg3;
            }
            long jM848tryMinHeightJN0ABg3 = m848tryMinHeightJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM848tryMinHeightJN0ABg3, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM848tryMinHeightJN0ABg3;
            }
            long jM849tryMinWidthJN0ABg3 = m849tryMinWidthJN0ABg(j, true);
            if (!IntSize.m8999equalsimpl0(jM849tryMinWidthJN0ABg3, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM849tryMinWidthJN0ABg3;
            }
            long jM846tryMaxHeightJN0ABg4 = m846tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM846tryMaxHeightJN0ABg4, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM846tryMaxHeightJN0ABg4;
            }
            long jM847tryMaxWidthJN0ABg4 = m847tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM847tryMaxWidthJN0ABg4, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM847tryMaxWidthJN0ABg4;
            }
            long jM848tryMinHeightJN0ABg4 = m848tryMinHeightJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM848tryMinHeightJN0ABg4, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM848tryMinHeightJN0ABg4;
            }
            long jM849tryMinWidthJN0ABg4 = m849tryMinWidthJN0ABg(j, false);
            if (!IntSize.m8999equalsimpl0(jM849tryMinWidthJN0ABg4, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                return jM849tryMinWidthJN0ABg4;
            }
        }
        return IntSize.INSTANCE.m9006getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m847tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
        if (iM8783getMaxWidthimpl == Integer.MAX_VALUE || (iRound = Math.round(iM8783getMaxWidthimpl / this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m843isSatisfiedByNN6EwU(j, iM8783getMaxWidthimpl, iRound))) {
            return IntSize.INSTANCE.m9006getZeroYbymL2g();
        }
        return IntSize.m8996constructorimpl((((long) iM8783getMaxWidthimpl) << 32) | (((long) iRound) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m846tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
        if (iM8782getMaxHeightimpl == Integer.MAX_VALUE || (iRound = Math.round(iM8782getMaxHeightimpl * this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m843isSatisfiedByNN6EwU(j, iRound, iM8782getMaxHeightimpl))) {
            return IntSize.INSTANCE.m9006getZeroYbymL2g();
        }
        return IntSize.m8996constructorimpl((((long) iRound) << 32) | (((long) iM8782getMaxHeightimpl) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m849tryMinWidthJN0ABg(long j, boolean z) {
        int iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(j);
        int iRound = Math.round(iM8785getMinWidthimpl / this.aspectRatio);
        if (iRound <= 0 || (z && !AspectRatioKt.m843isSatisfiedByNN6EwU(j, iM8785getMinWidthimpl, iRound))) {
            return IntSize.INSTANCE.m9006getZeroYbymL2g();
        }
        return IntSize.m8996constructorimpl((((long) iM8785getMinWidthimpl) << 32) | (((long) iRound) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m848tryMinHeightJN0ABg(long j, boolean z) {
        int iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(j);
        int iRound = Math.round(iM8784getMinHeightimpl * this.aspectRatio);
        if (iRound <= 0 || (z && !AspectRatioKt.m843isSatisfiedByNN6EwU(j, iRound, iM8784getMinHeightimpl))) {
            return IntSize.INSTANCE.m9006getZeroYbymL2g();
        }
        return IntSize.m8996constructorimpl((((long) iRound) << 32) | (((long) iM8784getMinHeightimpl) & 4294967295L));
    }
}
