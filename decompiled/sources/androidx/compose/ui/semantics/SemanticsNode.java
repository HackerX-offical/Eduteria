package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: SemanticsNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020CJ\u001e\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010J\u001a\u00020\tH\u0002J7\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000L2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\"\u0010P\u001a\u00020G*\u00020\u00072\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010N\u001a\u00020\u0005H\u0002J1\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000L2\b\b\u0002\u0010W\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bXJ,\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00000L2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J2\u0010^\u001a\u00020G*\b\u0012\u0004\u0012\u00020\u00000I2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020G0`H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000f\u0010a\u001a\u0004\u0018\u00010bH\u0000¢\u0006\u0002\bcJ\n\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0016\u0010f\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J0\u0010g\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010i2\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020G0`¢\u0006\u0002\blH\u0002¢\u0006\u0002\bmJ\r\u0010n\u001a\u00020\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b0\u0010(R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u0010.R\u0011\u00104\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b5\u0010(R\u0011\u00106\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b7\u0010.R\u0011\u00108\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b9\u0010.R\u0014\u0010:\u001a\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010(R\u0014\u0010?\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u000fR\u0011\u0010D\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bE\u0010\u0013R\u0014\u0010K\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u000fR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00000L8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00000L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010Y\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bY\u0010\u000fR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006p"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<init>", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "getOuterSemanticsNode$ui", "()Landroidx/compose/ui/Modifier$Node;", "getMergingEnabled", "()Z", "getLayoutNode$ui", "()Landroidx/compose/ui/node/LayoutNode;", "getUnmergedConfig$ui", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "isFake", "isFake$ui", "isUnmergedLeafNode", "isUnmergedLeafNode$ui", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "id", "", "getId", "()I", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "unclippedBoundsInRoot", "getUnclippedBoundsInRoot$ui", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "boundsInRoot", "getBoundsInRoot", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "boundsInWindow", "getBoundsInWindow", "positionInWindow", "getPositionInWindow-F1C5BW0", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "boundsInParent", "getBoundsInParent$ui", "boundsInImportantForBoundsAncestor", "nodeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isTransparent", "isTransparent$ui", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "config", "getConfig", "mergeConfig", "", "unmergedChildren", "", "mergedConfig", "isMergingSemanticsOfDescendants", "", "includeFakeNodes", "includeDeactivatedNodes", "unmergedChildren$ui", "fillOneLayerOfSemanticsWrappers", "list", "children", "getChildren", "()Ljava/util/List;", "replacedChildren", "getReplacedChildren$ui", "includeReplacedSemantics", "getChildren$ui", "isRoot", Message.Thread.PARENT_ATTRIBUTE_NAME, "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "findOneLayerOfMergingSemanticsNodes", "forEachUnmergedChild", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui", "findSemanticsModifierNodeToGetBounds", "Landroidx/compose/ui/node/SemanticsModifierNode;", "emitFakeNodes", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", JivePropertiesExtension.ELEMENT, "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "copyWithMergingEnabled", "copyWithMergingEnabled$ui", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.getSemanticsId();
    }

    /* JADX INFO: renamed from: getOuterSemanticsNode$ui, reason: from getter */
    public final Modifier.Node getOuterSemanticsNode() {
        return this.outerSemanticsNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    /* JADX INFO: renamed from: getLayoutNode$ui, reason: from getter */
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* JADX INFO: renamed from: getUnmergedConfig$ui, reason: from getter */
    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui() {
        return this.fakeNodeParent != null;
    }

    public final boolean isUnmergedLeafNode$ui() {
        if (isFake$ui() || !getReplacedChildren$ui().isEmpty()) {
            return false;
        }
        LayoutNode parent$ui = this.layoutNode.getParent$ui();
        while (true) {
            if (parent$ui == null) {
                parent$ui = null;
                break;
            }
            SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.getIsMergingSemanticsOfDescendants()) {
                break;
            }
            parent$ui = parent$ui.getParent$ui();
        }
        return parent$ui == null;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner = this.layoutNode.getOwner();
        if (owner != null) {
            return owner.getRootForTest();
        }
        return null;
    }

    public final int getId() {
        return this.id;
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        if (semanticsModifierNodeFindSemanticsModifierNodeToGetBounds == null) {
            return this.layoutNode.getInnerCoordinator$ui().touchBoundsInRoot();
        }
        return SemanticsModifierNodeKt.effectiveBoundsInRoot(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig), true);
    }

    public final Rect getUnclippedBoundsInRoot$ui() {
        SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        if (semanticsModifierNodeFindSemanticsModifierNodeToGetBounds == null) {
            return SemanticsModifierNodeKt.boundsInRoot(this.layoutNode.getInnerCoordinator$ui(), false);
        }
        return SemanticsModifierNodeKt.effectiveBoundsInRoot(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig), false);
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m8026getSizeYbymL2g() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        return nodeCoordinatorFindCoordinatorToGetBounds$ui != null ? nodeCoordinatorFindCoordinatorToGetBounds$ui.mo7453getSizeYbymL2g() : IntSize.INSTANCE.m9006getZeroYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        Rect rectBoundsInRoot;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null && (rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(nodeCoordinatorFindCoordinatorToGetBounds$ui)) != null) {
                return rectBoundsInRoot;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m8023getPositionInRootF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionInRoot(nodeCoordinatorFindCoordinatorToGetBounds$ui);
            }
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    public final Rect getBoundsInWindow() {
        Rect rectBoundsInWindow$default;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null && (rectBoundsInWindow$default = LayoutCoordinatesKt.boundsInWindow$default(nodeCoordinatorFindCoordinatorToGetBounds$ui, false, 1, null)) != null) {
                return rectBoundsInWindow$default;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: renamed from: getPositionInWindow-F1C5BW0, reason: not valid java name */
    public final long m8024getPositionInWindowF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui);
            }
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m8025getPositionOnScreenF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return LayoutCoordinatesKt.positionOnScreen(nodeCoordinatorFindCoordinatorToGetBounds$ui);
            }
        }
        return Offset.INSTANCE.m5739getZeroF1C5BW0();
    }

    public final Rect getBoundsInParent$ui() {
        LayoutCoordinates coordinates;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null && (coordinates = nodeCoordinatorFindCoordinatorToGetBounds$ui.getCoordinates()) != null) {
                return boundsInImportantForBoundsAncestor(coordinates);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v7 */
    private final Rect boundsInImportantForBoundsAncestor(LayoutCoordinates nodeCoordinates) {
        ?? Pop;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.INSTANCE.getZero();
        }
        NodeChain nodes = parent.layoutNode.getNodes();
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(8);
        if ((nodes.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            loop0: for (Modifier.Node head = nodes.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Pop = head;
                    MutableVector mutableVector = null;
                    while (Pop != 0) {
                        if (Pop instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) Pop).isImportantForBounds()) {
                                break loop0;
                            }
                        } else if ((Pop.getKindSet() & iM7763constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                            int i = 0;
                            Pop = Pop;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        Pop = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (Pop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(Pop);
                                            }
                                            Pop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                delegate = delegate.getChild();
                                Pop = Pop;
                            }
                            if (i == 1) {
                            }
                        }
                        Pop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    break;
                }
            }
            Pop = 0;
        } else {
            Pop = 0;
        }
        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Pop;
        NodeCoordinator nodeCoordinatorM7617requireCoordinator64DMado = semanticsModifierNode != null ? DelegatableNodeKt.m7617requireCoordinator64DMado(semanticsModifierNode, NodeKind.m7763constructorimpl(8)) : null;
        if (nodeCoordinatorM7617requireCoordinator64DMado == null) {
            return parent.boundsInImportantForBoundsAncestor(nodeCoordinates);
        }
        return LayoutCoordinates.localBoundingBoxOf$default(nodeCoordinatorM7617requireCoordinator64DMado, nodeCoordinates, false, 2, null);
    }

    public final boolean isTransparent$ui() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            return nodeCoordinatorFindCoordinatorToGetBounds$ui.isTransparent();
        }
        return false;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            return nodeCoordinatorFindCoordinatorToGetBounds$ui.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final SemanticsConfiguration getConfig() {
        if (isMergingSemanticsOfDescendants()) {
            SemanticsConfiguration semanticsConfigurationCopy = this.unmergedConfig.copy();
            mergeConfig(new ArrayList(), semanticsConfigurationCopy);
            return semanticsConfigurationCopy;
        }
        return this.unmergedConfig;
    }

    private final void mergeConfig(List<SemanticsNode> unmergedChildren, SemanticsConfiguration mergedConfig) {
        if (this.unmergedConfig.getIsClearingSemantics()) {
            return;
        }
        unmergedChildren$ui$default(this, unmergedChildren, false, false, 6, null);
        int size = unmergedChildren.size();
        for (int size2 = unmergedChildren.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = unmergedChildren.get(size2);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                mergedConfig.mergeChild$ui(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(unmergedChildren, mergedConfig);
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.getIsMergingSemanticsOfDescendants();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List unmergedChildren$ui$default(SemanticsNode semanticsNode, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return semanticsNode.unmergedChildren$ui(list, z, z2);
    }

    public final List<SemanticsNode> unmergedChildren$ui(List<SemanticsNode> unmergedChildren, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (isFake$ui()) {
            return CollectionsKt.emptyList();
        }
        fillOneLayerOfSemanticsWrappers(this.layoutNode, unmergedChildren, includeDeactivatedNodes);
        if (includeFakeNodes) {
            emitFakeNodes(unmergedChildren);
        }
        return unmergedChildren;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsNode> list, boolean z) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        LayoutNode[] layoutNodeArr = zSortedChildren.content;
        int size = zSortedChildren.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isAttached() && (z || !layoutNode2.getIsDeactivated())) {
                if (layoutNode2.getNodes().m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
                    list.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                } else {
                    fillOneLayerOfSemanticsWrappers(layoutNode2, list, z);
                }
            }
        }
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren$ui$default(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> getReplacedChildren$ui() {
        return getChildren$ui$default(this, false, true, false, 4, null);
    }

    public static /* synthetic */ List getChildren$ui$default(SemanticsNode semanticsNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = !semanticsNode.mergingEnabled;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return semanticsNode.getChildren$ui(z, z2, z3);
    }

    public final List<SemanticsNode> getChildren$ui(boolean includeReplacedSemantics, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (!includeReplacedSemantics && this.unmergedConfig.getIsClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, arrayList, null, 2, null);
        }
        return unmergedChildren$ui(arrayList, includeFakeNodes, includeDeactivatedNodes);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        LayoutNode parent$ui;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        if (this.mergingEnabled) {
            parent$ui = this.layoutNode.getParent$ui();
            while (parent$ui != null) {
                SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration != null && semanticsConfiguration.getIsMergingSemanticsOfDescendants()) {
                    break;
                }
                parent$ui = parent$ui.getParent$ui();
            }
            parent$ui = null;
        } else {
            parent$ui = null;
        }
        if (parent$ui == null) {
            parent$ui = this.layoutNode.getParent$ui();
            while (true) {
                if (parent$ui == null) {
                    parent$ui = null;
                    break;
                }
                if (parent$ui.getNodes().m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
                    break;
                }
                parent$ui = parent$ui.getParent$ui();
            }
        }
        if (parent$ui == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(parent$ui, this.mergingEnabled);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, list2);
    }

    private final void forEachUnmergedChild(List<SemanticsNode> list, Function1<? super SemanticsNode, Unit> function1) {
        unmergedChildren$ui$default(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            function1.invoke(list.get(size2));
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui() {
        NodeCoordinator nodeCoordinatorM7617requireCoordinator64DMado;
        if (!isFake$ui()) {
            SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
            return (semanticsModifierNodeFindSemanticsModifierNodeToGetBounds == null || (nodeCoordinatorM7617requireCoordinator64DMado = DelegatableNodeKt.m7617requireCoordinator64DMado(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds, NodeKind.m7763constructorimpl(8))) == null) ? this.layoutNode.getInnerCoordinator$ui() : nodeCoordinatorM7617requireCoordinator64DMado;
        }
        SemanticsNode parent = getParent();
        if (parent != null) {
            return parent.findCoordinatorToGetBounds$ui();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v7 */
    private final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        ?? Pop;
        boolean z;
        ?? r5 = 0;
        r5 = 0;
        r5 = 0;
        r5 = 0;
        if (this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            NodeChain nodes = this.layoutNode.getNodes();
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(8);
            if ((nodes.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                Modifier.Node head = nodes.getHead();
                Pop = 0;
                while (head != null) {
                    if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = head;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof SemanticsModifierNode) {
                                SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) nodePop;
                                ?? r6 = Pop;
                                if (semanticsModifierNode.isImportantForBounds()) {
                                    r6 = Pop;
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        return semanticsModifierNode;
                                    }
                                    if (Pop == 0) {
                                        r6 = semanticsModifierNode;
                                    }
                                }
                                z = false;
                                Pop = r6;
                            } else {
                                z = true;
                                Pop = Pop;
                            }
                            if (z && (nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
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
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                        break;
                    }
                    head = head.getChild();
                    Pop = Pop;
                }
                r5 = Pop;
            }
        } else {
            NodeChain nodes2 = this.layoutNode.getNodes();
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(8);
            if ((nodes2.getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                loop3: for (Modifier.Node head2 = nodes2.getHead(); head2 != null; head2 = head2.getChild()) {
                    if ((head2.getKindSet() & iM7763constructorimpl2) != 0) {
                        Pop = head2;
                        MutableVector mutableVector2 = null;
                        while (Pop != 0) {
                            if (Pop instanceof SemanticsModifierNode) {
                                if (((SemanticsModifierNode) Pop).isImportantForBounds()) {
                                    r5 = Pop;
                                }
                            } else if ((Pop.getKindSet() & iM7763constructorimpl2) != 0 && (Pop instanceof DelegatingNode)) {
                                Modifier.Node delegate2 = ((DelegatingNode) Pop).getDelegate();
                                int i2 = 0;
                                Pop = Pop;
                                while (delegate2 != null) {
                                    if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            Pop = delegate2;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (Pop != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(Pop);
                                                }
                                                Pop = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate2);
                                            }
                                        }
                                    }
                                    delegate2 = delegate2.getChild();
                                    Pop = Pop;
                                }
                                if (i2 == 1) {
                                }
                            }
                            Pop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                    if ((head2.getAggregateChildKindSet() & iM7763constructorimpl2) == 0) {
                        break;
                    }
                }
            }
        }
        return (SemanticsModifierNode) r5;
    }

    private final void emitFakeNodes(List<SemanticsNode> unmergedChildren) {
        final Role role = SemanticsNodeKt.getRole(this);
        if (role != null && this.unmergedConfig.getIsMergingSemanticsOfDescendants() && !unmergedChildren.isEmpty()) {
            unmergedChildren.add(m8022fakeSemanticsNodeypyhhiA(role, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, role.getValue());
                }
            }));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && !unmergedChildren.isEmpty() && this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            final String str = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
            if (str != null) {
                unmergedChildren.add(0, m8022fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    /* JADX INFO: renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m8022fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        properties.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(properties), false, new LayoutNode(true, role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this)), semanticsConfiguration);
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    public final SemanticsNode copyWithMergingEnabled$ui() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> unmergedChildren, List<SemanticsNode> list) {
        unmergedChildren$ui$default(this, unmergedChildren, false, false, 6, null);
        int size = unmergedChildren.size();
        for (int size2 = unmergedChildren.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = unmergedChildren.get(size2);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.getIsClearingSemantics()) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(unmergedChildren, list);
            }
        }
        return list;
    }
}
