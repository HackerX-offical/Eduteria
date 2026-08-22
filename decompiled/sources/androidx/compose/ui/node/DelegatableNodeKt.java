package androidx.compose.ui.node;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.BeyondBoundsLayoutProviderModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: DelegatableNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a3\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0011\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a1\u0010\u0013\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a1\u0010\u0014\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0080\b\u001a)\u0010\u0015\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a3\u0010\u0015\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a)\u0010\u0016\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a>\u0010\u0017\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u0015\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a>\u0010\u0016\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001c\u001aR\u0010\u0004\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b \u0010!\u001aJ\u0010\"\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b$\u0010%\u001a<\u0010&\u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010'\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b(\u0010)\u001a<\u0010*\u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010+\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b,\u0010-\u001a0\u0010\f\u001a\u0004\u0018\u0001H\u0018\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020.*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0080\b¢\u0006\u0004\b/\u00100\u001aH\u0010\u0013\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b1\u00102\u001aH\u00103\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b4\u00102\u001aH\u0010\u0014\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00010\nH\u0080\b¢\u0006\u0004\b5\u00102\u001aH\u00106\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b7\u00102\u001a\u001f\u00108\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b9\u0010:\u001a\u001f\u0010;\u001a\u00020<*\u00020\u00022\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b>\u0010?\u001a\f\u0010@\u001a\u00020\u000f*\u00020\u0002H\u0000\u001a\f\u0010A\u001a\u00020B*\u00020\u0002H\u0000\u001a\f\u0010C\u001a\u00020D*\u00020\u0002H\u0000\u001a\n\u0010E\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010F\u001a\u00020G*\u00020\u0002\u001a\n\u0010H\u001a\u00020I*\u00020\u0002\u001a\n\u0010J\u001a\u00020K*\u00020\u0002\u001a\n\u0010L\u001a\u00020M*\u00020\u0002\u001a\n\u0010N\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010O\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010P\u001a\u00020\u0005*\u00020\u0002\u001a\u0019\u0010Q\u001a\u00020\u0005*\u00020\u00022\u0006\u0010R\u001a\u00020S¢\u0006\u0004\bT\u0010U\u001a\f\u0010V\u001a\u0004\u0018\u00010W*\u00020\u0002\u001a\u000e\u0010X\u001a\u0004\u0018\u00010Y*\u00020\u000bH\u0000\u001a>\u0010Z\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b[\u0010\\\u001aF\u0010Z\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0006\u0010]\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b^\u0010_\u001a\u0016\u0010`\u001a\u0004\u0018\u00010\u000b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006a"}, d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "visitAncestors", "", "mask", "", "includeSelf", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Node;", "nearestAncestor", "getChildren", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "zOrder", "addLayoutNodeChildren", NodeElement.ELEMENT, "visitChildren", "visitSubtreeIf", "visitLocalDescendants", "visitLocalAncestors", "visitSelfAndLocalDescendants", ExifInterface.GPS_DIRECTION_TRUE, "type", "Landroidx/compose/ui/node/NodeKind;", "visitSelfAndLocalDescendants-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalDescendants-6rFNWt0", "visitLocalAncestors-6rFNWt0", "includeDelegates", "visitAncestors-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;IZZLkotlin/jvm/functions/Function1;)V", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "ancestors", "", "ancestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;IZ)Ljava/util/List;", "setOfAncestors", "Landroidx/collection/ScatterSet;", "setOfAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;IZ)Landroidx/collection/ScatterSet;", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "visitChildren-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitSelfAndChildren", "visitSelfAndChildren-Y-YKmho", "visitSubtreeIf-Y-YKmho", "visitSubtree", "visitSubtree-Y-YKmho", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "requireSemanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "requestAutofill", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invalidateSubtree", "invalidateMeasurementForSubtree", "invalidateDrawForSubtree", "dispatchOnScrollChanged", "delta", "Landroidx/compose/ui/geometry/Offset;", "dispatchOnScrollChanged-Uv8p0NA", "(Landroidx/compose/ui/node/DelegatableNode;J)V", "findNearestBeyondBoundsLayoutAncestor", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "dispatchToDelegates", "dispatchForKind-Y-YKmho", "(Landroidx/compose/ui/Modifier$Node;IZLkotlin/jvm/functions/Function1;)V", "pop", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DelegatableNodeKt {
    public static final boolean isDelegationRoot(DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    public static final void visitAncestors(DelegatableNode delegatableNode, int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        function1.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static /* synthetic */ void visitAncestors$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        NodeChain nodes;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        function1.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        return parent;
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    private static final MutableVector<LayoutNode> getChildren(LayoutNode layoutNode, boolean z) {
        if (z) {
            return layoutNode.getZSortedChildren();
        }
        return layoutNode.get_children$ui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node, boolean z) {
        MutableVector<LayoutNode> children = getChildren(requireLayoutNode(node), z);
        int size = children.getSize() - 1;
        LayoutNode[] layoutNodeArr = children.content;
        if (size < layoutNodeArr.length) {
            while (size >= 0) {
                mutableVector.add(layoutNodeArr[size].getNodes().getHead());
                size--;
            }
        }
    }

    public static final void visitChildren(DelegatableNode delegatableNode, int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child2 = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((child2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child2, z);
            } else {
                while (true) {
                    if (child2 == null) {
                        break;
                    }
                    if ((child2.getKindSet() & i) != 0) {
                        function1.invoke(child2);
                        break;
                    }
                    child2 = child2.getChild();
                }
            }
        }
    }

    public static final void visitSubtreeIf(DelegatableNode delegatableNode, int i, boolean z, Function1<? super Modifier.Node, Boolean> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & i) == 0 || function1.invoke(child2).booleanValue()) {
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z);
        }
    }

    public static final void visitLocalDescendants(DelegatableNode delegatableNode, int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                function1.invoke(node);
            }
            node = node.getChild();
        }
    }

    public static /* synthetic */ void visitLocalDescendants$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                function1.invoke(node);
            }
            node = node.getChild();
        }
    }

    public static final void visitLocalAncestors(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent = delegatableNode.getNode().getParent(); parent != null; parent = parent.getParent()) {
            if ((parent.getKindSet() & i) != 0) {
                function1.invoke(parent);
            }
        }
    }

    /* JADX INFO: renamed from: visitSelfAndAncestors-5BbP62I, reason: not valid java name */
    public static final /* synthetic */ <T> void m7626visitSelfAndAncestors5BbP62I(DelegatableNode delegatableNode, int i, int i2, Function1<? super T, Unit> function1) {
        NodeChain nodes;
        Modifier.Node node = delegatableNode.getNode();
        int i3 = i | i2;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i3) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i3) != 0) {
                        if (node2 != node && (node2.getKindSet() & i2) != 0) {
                            return;
                        }
                        if ((node2.getKindSet() & i) != 0) {
                            Modifier.Node nodePop = node2;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                                if (nodePop instanceof Object) {
                                    function1.invoke(nodePop);
                                } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                        if ((delegate$ui.getKindSet() & i) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodePop = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodePop = pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX INFO: renamed from: visitSelfAndChildren-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m7627visitSelfAndChildrenYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Unit> function1) {
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                    if ((delegate$ui.getKindSet() & i) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = pop(mutableVector);
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector2, delegatableNode.getNode(), z);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector2, nodePop, z);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                function1.invoke(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) nodePop).getDelegate(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild()) {
                                    if ((delegate$ui2.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector3);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitSelfAndChildren-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m7628visitSelfAndChildrenYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i3 = 0;
                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                    if ((delegate$ui.getKindSet() & i) != 0) {
                        i3++;
                        if (i3 == 1) {
                            node = delegate$ui;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui);
                            }
                        }
                    }
                }
                if (i3 == 1) {
                }
            }
            node = pop(mutableVector);
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector2, delegatableNode.getNode(), z);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector2, nodePop, z);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                function1.invoke(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node delegate$ui2 = ((DelegatingNode) nodePop).getDelegate(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild()) {
                                    if ((delegate$ui2.getKindSet() & i) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodePop = delegate$ui2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui2);
                                            }
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector3);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m7615has64DMado(DelegatableNode delegatableNode, int i) {
        return (delegatableNode.getNode().getAggregateChildKindSet() & i) != 0;
    }

    /* JADX INFO: renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m7617requireCoordinator64DMado(DelegatableNode delegatableNode, int i) {
        NodeCoordinator coordinator = delegatableNode.getNode().getCoordinator();
        Intrinsics.checkNotNull(coordinator);
        if (coordinator.getTail() != delegatableNode || !NodeKindKt.m7772getIncludeSelfInTraversalH91voCI(i)) {
            return coordinator;
        }
        NodeCoordinator wrapped$ui = coordinator.getWrapped();
        Intrinsics.checkNotNull(wrapped$ui);
        return wrapped$ui;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator coordinator = delegatableNode.getNode().getCoordinator();
        if (coordinator != null) {
            return coordinator.getLayoutNode();
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final SemanticsInfo requireSemanticsInfo(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode);
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).getOwner();
        if (owner != null) {
            return owner;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }

    public static final void requestAutofill(DelegatableNode delegatableNode) {
        requireLayoutNode(delegatableNode).requestAutofill$ui();
    }

    public static final Density requireDensity(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode delegatableNode) {
        return requireOwner(delegatableNode).getGraphicsContext();
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        LayoutCoordinates coordinates = m7617requireCoordinator64DMado(delegatableNode, NodeKind.m7763constructorimpl(2)).getCoordinates();
        if (!coordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return coordinates;
    }

    public static final void invalidateSubtree(DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().getIsAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, null);
        }
    }

    public static final void invalidateMeasurementForSubtree(DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().getIsAttached()) {
            requireLayoutNode(delegatableNode).invalidateMeasurementForSubtree();
        }
    }

    public static final void invalidateDrawForSubtree(DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().getIsAttached()) {
            LayoutNode.invalidateDrawForSubtree$default(requireLayoutNode(delegatableNode), false, 1, null);
        }
    }

    /* JADX INFO: renamed from: dispatchOnScrollChanged-Uv8p0NA, reason: not valid java name */
    public static final void m7614dispatchOnScrollChangedUv8p0NA(DelegatableNode delegatableNode, long j) {
        requireOwner(delegatableNode).mo7829dispatchOnScrollChangedk4lQ0M(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /* JADX INFO: renamed from: dispatchForKind-Y-YKmho, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ <T> void m7613dispatchForKindYYKmho(androidx.compose.ui.Modifier.Node r7, int r8, boolean r9, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r10) {
        /*
            r0 = 0
            r1 = r0
        L2:
            if (r7 == 0) goto L74
            r2 = 3
            java.lang.String r3 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r2, r3)
            boolean r2 = r7 instanceof java.lang.Object
            if (r2 == 0) goto L13
            r10.invoke(r7)
            if (r9 == 0) goto L6c
        L13:
            r2 = r7
            androidx.compose.ui.Modifier$Node r2 = (androidx.compose.ui.Modifier.Node) r2
            int r2 = r7.getKindSet()
            r2 = r2 & r8
            if (r2 == 0) goto L6c
            boolean r2 = r7 instanceof androidx.compose.ui.node.DelegatingNode
            if (r2 == 0) goto L6c
            r2 = r7
            androidx.compose.ui.node.DelegatingNode r2 = (androidx.compose.ui.node.DelegatingNode) r2
            androidx.compose.ui.Modifier$Node r2 = r2.getDelegate()
            r3 = 0
            r4 = r3
        L2a:
            r5 = 1
            if (r2 == 0) goto L69
            r6 = r2
            androidx.compose.ui.Modifier$Node r6 = (androidx.compose.ui.Modifier.Node) r6
            int r6 = r2.getKindSet()
            r6 = r6 & r8
            if (r6 == 0) goto L64
            int r4 = r4 + 1
            if (r4 != r5) goto L3d
            r7 = r2
            goto L64
        L3d:
            r5 = r1
            androidx.compose.runtime.collection.MutableVector r5 = (androidx.compose.runtime.collection.MutableVector) r5
            if (r1 != 0) goto L4e
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r5 = 16
            androidx.compose.ui.Modifier$Node[] r5 = new androidx.compose.ui.Modifier.Node[r5]
            r1.<init>(r5, r3)
            r5 = r1
            androidx.compose.runtime.collection.MutableVector r5 = (androidx.compose.runtime.collection.MutableVector) r5
        L4e:
            r5 = r7
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            if (r7 == 0) goto L5c
            r5 = r1
            androidx.compose.runtime.collection.MutableVector r5 = (androidx.compose.runtime.collection.MutableVector) r5
            if (r1 == 0) goto L5b
            r1.add(r7)
        L5b:
            r7 = r0
        L5c:
            r5 = r1
            androidx.compose.runtime.collection.MutableVector r5 = (androidx.compose.runtime.collection.MutableVector) r5
            if (r1 == 0) goto L64
            r1.add(r2)
        L64:
            androidx.compose.ui.Modifier$Node r2 = r2.getChild()
            goto L2a
        L69:
            if (r4 != r5) goto L6c
            goto L2
        L6c:
            r7 = r1
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            androidx.compose.ui.Modifier$Node r7 = access$pop(r1)
            goto L2
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m7613dispatchForKindYYKmho(androidx.compose.ui.Modifier$Node, int, boolean, kotlin.jvm.functions.Function1):void");
    }

    public static final void visitLocalDescendants(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & i) != 0) {
                    function1.invoke(child);
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitSelfAndLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m7629visitSelfAndLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            while (node != null) {
                if ((node.getKindSet() & i) != 0) {
                    Modifier.Node nodePop = node;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (nodePop instanceof Object) {
                            function1.invoke(nodePop);
                        } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                if ((delegate$ui.getKindSet() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        nodePop = pop(mutableVector);
                    }
                }
                node = node.getChild();
            }
        }
    }

    /* JADX INFO: renamed from: visitLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m7625visitLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & i) != 0) {
                    Modifier.Node nodePop = child;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (nodePop instanceof Object) {
                            function1.invoke(nodePop);
                        } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                if ((delegate$ui.getKindSet() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        nodePop = pop(mutableVector);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitLocalAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m7624visitLocalAncestors6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent = delegatableNode.getNode().getParent(); parent != null; parent = parent.getParent()) {
            if ((parent.getKindSet() & i) != 0) {
                Modifier.Node nodePop = parent;
                MutableVector mutableVector = null;
                while (nodePop != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (nodePop instanceof Object) {
                        function1.invoke(nodePop);
                    } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                        int i2 = 0;
                        for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                            if ((delegate$ui.getKindSet() & i) != 0) {
                                i2++;
                                if (i2 == 1) {
                                    nodePop = delegate$ui;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui);
                                    }
                                }
                            }
                        }
                        if (i2 == 1) {
                        }
                    }
                    nodePop = pop(mutableVector);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX INFO: renamed from: visitAncestors-QFhIj7k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ <T> void m7620visitAncestorsQFhIj7k(androidx.compose.ui.node.DelegatableNode r8, int r9, boolean r10, boolean r11, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m7620visitAncestorsQFhIj7k(androidx.compose.ui.node.DelegatableNode, int, boolean, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX INFO: renamed from: visitAncestors-QFhIj7k$default, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void m7621visitAncestorsQFhIj7k$default(androidx.compose.ui.node.DelegatableNode r6, int r7, boolean r8, boolean r9, kotlin.jvm.functions.Function1 r10, int r11, java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m7621visitAncestorsQFhIj7k$default(androidx.compose.ui.node.DelegatableNode, int, boolean, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    /* JADX INFO: renamed from: ancestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m7610ancestors6rFNWt0(DelegatableNode delegatableNode, int i, boolean z) {
        NodeChain nodes;
        boolean z2;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2 && (nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ancestors-6rFNWt0$default, reason: not valid java name */
    public static /* synthetic */ List m7611ancestors6rFNWt0$default(DelegatableNode delegatableNode, int i, boolean z, int i2, Object obj) {
        NodeChain nodes;
        boolean z2;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2 && (nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: setOfAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> ScatterSet<T> m7618setOfAncestors6rFNWt0(DelegatableNode delegatableNode, int i, boolean z) {
        NodeChain nodes;
        boolean z2;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        MutableScatterSet mutableScatterSetMutableScatterSetOf = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (mutableScatterSetMutableScatterSetOf == null) {
                                    mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                                }
                                mutableScatterSetMutableScatterSetOf.add(nodePop);
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2 && (nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return mutableScatterSetMutableScatterSetOf;
    }

    /* JADX INFO: renamed from: setOfAncestors-6rFNWt0$default, reason: not valid java name */
    public static /* synthetic */ ScatterSet m7619setOfAncestors6rFNWt0$default(DelegatableNode delegatableNode, int i, boolean z, int i2, Object obj) {
        NodeChain nodes;
        boolean z2;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        MutableScatterSet mutableScatterSetMutableScatterSetOf = null;
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (mutableScatterSetMutableScatterSetOf == null) {
                                    mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                                }
                                mutableScatterSetMutableScatterSetOf.add(nodePop);
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2 && (nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return mutableScatterSetMutableScatterSetOf;
    }

    /* JADX INFO: renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m7616nearestAncestor64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Object obj = (T) parent;
                        MutableVector mutableVector = null;
                        while (obj != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (obj instanceof Object) {
                                return (T) obj;
                            }
                            if ((((Modifier.Node) obj).getKindSet() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = obj.getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = (T) delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (obj != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            obj = (T) pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX INFO: renamed from: visitChildren-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m7622visitChildrenYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, nodePop, z);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                function1.invoke(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector2);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitChildren-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m7623visitChildrenYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, nodePop, z);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & i) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (!(nodePop instanceof Object)) {
                                if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                        if ((delegate$ui.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                nodePop = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else {
                                function1.invoke(nodePop);
                            }
                            nodePop = pop(mutableVector2);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: visitSubtreeIf-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m7632visitSubtreeIfYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Boolean> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (!function1.invoke(nodePop).booleanValue()) {
                                    break;
                                }
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector2);
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z);
        }
    }

    /* JADX INFO: renamed from: visitSubtreeIf-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m7633visitSubtreeIfYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (!((Boolean) function1.invoke(nodePop)).booleanValue()) {
                                    break;
                                }
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector2);
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z);
        }
    }

    /* JADX INFO: renamed from: visitSubtree-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m7630visitSubtreeYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Unit> function1) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                function1.invoke(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                    if ((delegate$ui.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate$ui;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = pop(mutableVector2);
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z);
        }
    }

    /* JADX INFO: renamed from: visitSubtree-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m7631visitSubtreeYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (!(nodePop instanceof Object)) {
                                if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                                        if ((delegate$ui.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                nodePop = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else {
                                function1.invoke(nodePop);
                            }
                            nodePop = pop(mutableVector2);
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final BeyondBoundsLayout findNearestBeyondBoundsLayoutAncestor(DelegatableNode delegatableNode) {
        NodeChain nodes;
        ?? r6;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(8388608) | NodeKind.m7763constructorimpl(32);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            ?? parent2 = parent;
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                while (parent2 != 0) {
                    if ((parent2.getKindSet() & iM7763constructorimpl) != 0) {
                        if ((NodeKind.m7763constructorimpl(8388608) & parent2.getKindSet()) != 0) {
                            if (!(parent2 instanceof BeyondBoundsLayoutProviderModifierNode)) {
                                if (parent2 instanceof DelegatingNode) {
                                    Modifier.Node delegate$ui = ((DelegatingNode) parent2).getDelegate();
                                    parent2 = 0;
                                    while (delegate$ui != null) {
                                        if (delegate$ui instanceof BeyondBoundsLayoutProviderModifierNode) {
                                            parent2 = delegate$ui;
                                        }
                                        delegate$ui = delegate$ui.getChild();
                                        parent2 = parent2;
                                    }
                                } else {
                                    parent2 = 0;
                                }
                            }
                            BeyondBoundsLayoutProviderModifierNode beyondBoundsLayoutProviderModifierNode = (BeyondBoundsLayoutProviderModifierNode) parent2;
                            if (beyondBoundsLayoutProviderModifierNode != null) {
                                return beyondBoundsLayoutProviderModifierNode.getBeyondBoundsLayout();
                            }
                            return null;
                        }
                        if ((NodeKind.m7763constructorimpl(32) & parent2.getKindSet()) == 0) {
                            continue;
                        } else {
                            if (parent2 instanceof ModifierLocalModifierNode) {
                                r6 = parent2;
                            } else if (parent2 instanceof DelegatingNode) {
                                Modifier.Node delegate$ui2 = ((DelegatingNode) parent2).getDelegate();
                                r6 = 0;
                                while (delegate$ui2 != null) {
                                    if (delegate$ui2 instanceof ModifierLocalModifierNode) {
                                        r6 = delegate$ui2;
                                    }
                                    delegate$ui2 = delegate$ui2.getChild();
                                    r6 = r6;
                                }
                            } else {
                                r6 = 0;
                            }
                            ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) r6;
                            if (modifierLocalModifierNode != null && modifierLocalModifierNode.getProvidedValues().contains$ui(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout())) {
                                return (BeyondBoundsLayout) modifierLocalModifierNode.getProvidedValues().get$ui(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
                            }
                        }
                    }
                    parent2 = parent2.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((NodeKind.m7763constructorimpl(2) & node.getKindSet()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate();
                while (delegate$ui != 0) {
                    if (delegate$ui instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate$ui;
                    }
                    if ((delegate$ui instanceof DelegatingNode) && (NodeKind.m7763constructorimpl(2) & delegate$ui.getKindSet()) != 0) {
                        delegate$ui = ((DelegatingNode) delegate$ui).getDelegate();
                    } else {
                        delegate$ui = delegate$ui.getChild();
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: dispatchForKind-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m7612dispatchForKind6rFNWt0(Modifier.Node node, int i, Function1<? super T, Unit> function1) {
        MutableVector mutableVector = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate(); delegate$ui != null; delegate$ui = delegate$ui.getChild()) {
                    if ((delegate$ui.getKindSet() & i) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = pop(mutableVector);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node pop(MutableVector<Modifier.Node> mutableVector) {
        if (mutableVector == null || mutableVector.getSize() == 0) {
            return null;
        }
        return mutableVector.removeAt(mutableVector.getSize() - 1);
    }
}
