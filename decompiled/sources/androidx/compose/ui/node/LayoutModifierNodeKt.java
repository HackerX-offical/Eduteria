package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LayoutModifierNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"remeasureSync", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateLayer", "invalidatePlacement", "invalidateMeasurement", "requestRemeasure", "updateLayerBlock", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LayoutModifierNodeKt {
    public static final void remeasureSync(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).forceRemeasure();
    }

    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.m7617requireCoordinator64DMado(layoutModifierNode, NodeKind.m7763constructorimpl(2)).invalidateLayer();
    }

    public static final void invalidatePlacement(LayoutModifierNode layoutModifierNode) {
        LayoutNode.requestRelayout$ui$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, 1, null);
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui();
    }

    public static final void requestRemeasure(LayoutModifierNode layoutModifierNode) {
        LayoutNode.requestRemeasure$ui$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, false, false, 7, null);
    }

    public static final void updateLayerBlock(LayoutModifierNode layoutModifierNode, Function1<? super GraphicsLayerScope, Unit> function1) {
        NodeCoordinator wrapped;
        if (layoutModifierNode.getNode().getIsAttached() && (wrapped = DelegatableNodeKt.m7617requireCoordinator64DMado(layoutModifierNode, NodeKind.m7763constructorimpl(2)).getWrapped()) != null) {
            wrapped.updateLayerBlock(function1, true);
        }
    }
}
