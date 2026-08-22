package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: WindowInsetsPadding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J#\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "calculateInsets", "ancestorConsumedInsets", "insetsInvalidated", "", DiscoverItems.Item.UPDATE_ACTION, "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InsetsPaddingModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    public static final int $stable = 8;
    private WindowInsets insets;

    public InsetsPaddingModifierNode(WindowInsets windowInsets) {
        this.insets = windowInsets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public WindowInsets calculateInsets(WindowInsets ancestorConsumedInsets) {
        return WindowInsetsKt.union(ancestorConsumedInsets, this.insets);
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public void insetsInvalidated() {
        super.insetsInvalidated();
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    public final void update(WindowInsets insets) {
        if (Intrinsics.areEqual(insets, this.insets)) {
            return;
        }
        this.insets = insets;
        insetsInvalidated();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        MeasureScope measureScope2 = measureScope;
        final int left = getConsumedInsets().getLeft(measureScope2, measureScope.getLayoutDirection()) - getAncestorConsumedInsets().getLeft(measureScope2, measureScope.getLayoutDirection());
        final int top = getConsumedInsets().getTop(measureScope2) - getAncestorConsumedInsets().getTop(measureScope2);
        int right = (getConsumedInsets().getRight(measureScope2, measureScope.getLayoutDirection()) - getAncestorConsumedInsets().getRight(measureScope2, measureScope.getLayoutDirection())) + left;
        int bottom = (getConsumedInsets().getBottom(measureScope2) - getAncestorConsumedInsets().getBottom(measureScope2)) + top;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j, -right, -bottom));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8800constrainWidthK40F9xA(j, placeableMo7445measureBRTryo0.getWidth() + right), ConstraintsKt.m8799constrainHeightK40F9xA(j, placeableMo7445measureBRTryo0.getHeight() + bottom), null, new Function1() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InsetsPaddingModifierNode.measure_3p2s80s$lambda$0(placeableMo7445measureBRTryo0, left, top, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
