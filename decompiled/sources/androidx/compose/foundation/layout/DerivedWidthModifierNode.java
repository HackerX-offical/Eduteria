package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: WindowInsetsSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/DerivedWidthModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "widthCalc", "Landroidx/compose/foundation/layout/WindowInsetsWidthCalculator;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsetsWidthCalculator;)V", "widthInsets", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", DiscoverItems.Item.UPDATE_ACTION, "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DerivedWidthModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private WindowInsets insets;
    private WindowInsetsWidthCalculator widthCalc;
    private WindowInsets widthInsets = WindowInsetsKt.WindowInsets();

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public WindowInsets calculateInsets(WindowInsets ancestorConsumedInsets) {
        return ancestorConsumedInsets;
    }

    public DerivedWidthModifierNode(WindowInsets windowInsets, WindowInsetsWidthCalculator windowInsetsWidthCalculator) {
        this.insets = windowInsets;
        this.widthCalc = windowInsetsWidthCalculator;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public void insetsInvalidated() {
        this.widthInsets = WindowInsetsKt.exclude(this.insets, getAncestorConsumedInsets());
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    public final void update(WindowInsets insets, WindowInsetsWidthCalculator widthCalc) {
        if (Intrinsics.areEqual(this.insets, insets) && widthCalc == this.widthCalc) {
            return;
        }
        this.insets = insets;
        this.widthCalc = widthCalc;
        this.widthInsets = WindowInsetsKt.exclude(insets, getAncestorConsumedInsets());
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iCalculate = this.widthCalc.calculate(this.widthInsets, measureScope.getLayoutDirection(), measureScope);
        if (iCalculate == 0) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.foundation.layout.DerivedWidthModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DerivedWidthModifierNode.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, iCalculate, iCalculate, 0, 0, 12, null));
        return MeasureScope.layout$default(measureScope, iCalculate, placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.DerivedWidthModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DerivedWidthModifierNode.measure_3p2s80s$lambda$1(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
