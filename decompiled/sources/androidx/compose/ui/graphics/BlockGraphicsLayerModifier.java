package androidx.compose.ui.graphics;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphicsLayerModifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B \u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0007J#\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u0007*\u00020 H\u0016R+\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "setLayerBlock", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "invalidateLayerBlock", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", InAppPurchaseConstants.METHOD_TO_STRING, "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private final boolean isImportantForBounds;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public BlockGraphicsLayerModifier(Function1<? super GraphicsLayerScope, Unit> function1) {
        this.layerBlock = function1;
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final void setLayerBlock(Function1<? super GraphicsLayerScope, Unit> function1) {
        this.layerBlock = function1;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: isImportantForBounds, reason: from getter */
    public boolean getIsImportantForBounds() {
        return this.isImportantForBounds;
    }

    public final void invalidateLayerBlock() {
        LayoutModifierNodeKt.updateLayerBlock(this, this.layerBlock);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.BlockGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo7445measureBRTryo0, 0, 0, 0.0f, this.getLayerBlock(), 4, (Object) null);
            }
        }, 4, null);
    }

    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.layerBlock + ')';
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        boolean lastClip;
        Shape shape;
        if (ComposeUiFlags.isGraphicsLayerShapeSemanticsEnabled) {
            NodeCoordinator nodeCoordinatorM7617requireCoordinator64DMado = DelegatableNodeKt.m7617requireCoordinator64DMado(this, NodeKind.m7763constructorimpl(2));
            if (!nodeCoordinatorM7617requireCoordinator64DMado.getWasLayerBlockInvoked()) {
                if (GraphicsLayerModifierKt.reusableGraphicsLayerScope == null) {
                    GraphicsLayerModifierKt.reusableGraphicsLayerScope = new ReusableGraphicsLayerScope();
                } else {
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope = GraphicsLayerModifierKt.reusableGraphicsLayerScope;
                    Intrinsics.checkNotNull(reusableGraphicsLayerScope);
                    reusableGraphicsLayerScope.reset();
                }
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = GraphicsLayerModifierKt.reusableGraphicsLayerScope;
                Intrinsics.checkNotNull(reusableGraphicsLayerScope2);
                reusableGraphicsLayerScope2.setGraphicsDensity$ui(nodeCoordinatorM7617requireCoordinator64DMado.getLayoutNode().getDensity());
                reusableGraphicsLayerScope2.m6298setSizeuvyYCjk(IntSizeKt.m9013toSizeozmzZPI(nodeCoordinatorM7617requireCoordinator64DMado.mo7453getSizeYbymL2g()));
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    this.layerBlock.invoke(reusableGraphicsLayerScope2);
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    shape = reusableGraphicsLayerScope2.getShape();
                    lastClip = reusableGraphicsLayerScope2.getClip();
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            } else {
                Shape lastShape = nodeCoordinatorM7617requireCoordinator64DMado.getLastShape();
                lastClip = nodeCoordinatorM7617requireCoordinator64DMado.getLastClip();
                shape = lastShape;
            }
            if (lastClip) {
                SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, shape);
            }
        }
    }
}
