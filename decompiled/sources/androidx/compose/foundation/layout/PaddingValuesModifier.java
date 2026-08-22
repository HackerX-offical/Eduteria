package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public PaddingValuesModifier(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float fMo1096calculateLeftPaddingu2uoSUM = this.paddingValues.mo1096calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float top = this.paddingValues.getTop();
        float fMo1097calculateRightPaddingu2uoSUM = this.paddingValues.mo1097calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float bottom = this.paddingValues.getBottom();
        float f2 = 0;
        if (!((Dp.m8829compareTo0680j_4(bottom, Dp.m8830constructorimpl(f2)) >= 0) & (Dp.m8829compareTo0680j_4(fMo1096calculateLeftPaddingu2uoSUM, Dp.m8830constructorimpl(f2)) >= 0) & (Dp.m8829compareTo0680j_4(top, Dp.m8830constructorimpl(f2)) >= 0) & (Dp.m8829compareTo0680j_4(fMo1097calculateRightPaddingu2uoSUM, Dp.m8830constructorimpl(f2)) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        final int i = measureScope.mo482roundToPx0680j_4(fMo1096calculateLeftPaddingu2uoSUM);
        int i2 = measureScope.mo482roundToPx0680j_4(fMo1097calculateRightPaddingu2uoSUM) + i;
        final int i3 = measureScope.mo482roundToPx0680j_4(top);
        int i4 = measureScope.mo482roundToPx0680j_4(bottom) + i3;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j, -i2, -i4));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8800constrainWidthK40F9xA(j, placeableMo7445measureBRTryo0.getWidth() + i2), ConstraintsKt.m8799constrainHeightK40F9xA(j, placeableMo7445measureBRTryo0.getHeight() + i4), null, new Function1() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingValuesModifier.measure_3p2s80s$lambda$1(placeableMo7445measureBRTryo0, i, i3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
