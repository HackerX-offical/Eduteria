package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: DelegatingNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b\rJ!\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001eJ\u001f\u0010\u000e\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0004J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0)H\u0080\b¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\nH\u0010¢\u0006\u0002\b,J\r\u0010-\u001a\u00020\nH\u0010¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\r\u00101\u001a\u00020\nH\u0010¢\u0006\u0002\b2J\r\u00103\u001a\u00020\nH\u0010¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "selfKindSet", "", "getSelfKindSet$ui$annotations", "getSelfKindSet$ui", "()I", "updateCoordinator", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui", "delegate", "getDelegate$ui", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui", "(Landroidx/compose/ui/Modifier$Node;)V", "delegateUnprotected", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "delegateUnprotected$ui", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "undelegateUnprotected", "instance", "undelegateUnprotected$ui", "setAsDelegateTo", "owner", "setAsDelegateTo$ui", "undelegate", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "forEachImmediateDelegate", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "forEachImmediateDelegate$ui", "markAsAttached", "markAsAttached$ui", "runAttachLifecycle", "runAttachLifecycle$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "markAsDetached", "markAsDetached$ui", "reset", "reset$ui", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public static /* synthetic */ void getSelfKindSet$ui$annotations() {
    }

    /* JADX INFO: renamed from: getSelfKindSet$ui, reason: from getter */
    public final int getSelfKindSet() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui(NodeCoordinator coordinator) {
        super.updateCoordinator$ui(coordinator);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui(coordinator);
        }
    }

    /* JADX INFO: renamed from: getDelegate$ui, reason: from getter */
    public final Modifier.Node getDelegate() {
        return this.delegate;
    }

    public final void setDelegate$ui(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui(T delegatableNode) {
        return (T) delegate(delegatableNode);
    }

    public final void undelegateUnprotected$ui(DelegatableNode instance) {
        undelegate(instance);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui(Modifier.Node owner) {
        super.setAsDelegateTo$ui(owner);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.setAsDelegateTo$ui(owner);
        }
    }

    protected final <T extends DelegatableNode> T delegate(T delegatableNode) {
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node parent = node2 != null ? node2.getParent() : null;
            if (node == getNode() && Intrinsics.areEqual(parent, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }
        if (node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui(getNode());
        int kindSet$ui = getKindSet();
        int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
        node.setKindSet$ui(iCalculateNodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(iCalculateNodeKindSetFromIncludingDelegates, node);
        node.setChild$ui(this.delegate);
        this.delegate = node;
        node.setParent$ui(this);
        updateNodeKindSet(getKindSet() | iCalculateNodeKindSetFromIncludingDelegates, false);
        if (getIsAttached()) {
            if ((iCalculateNodeKindSetFromIncludingDelegates & NodeKind.m7763constructorimpl(2)) != 0 && (kindSet$ui & NodeKind.m7763constructorimpl(2)) == 0) {
                NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                getNode().updateCoordinator$ui(null);
                nodes.syncCoordinators();
            } else {
                updateCoordinator$ui(getCoordinator());
            }
            node.markAsAttached$ui();
            node.runAttachLifecycle$ui();
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
        return delegatableNode;
    }

    protected final void undelegate(DelegatableNode instance) {
        Modifier.Node node = null;
        for (Modifier.Node child = this.delegate; child != null; child = child.getChild()) {
            if (child == instance) {
                if (child.getIsAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(child);
                    child.runDetachLifecycle$ui();
                    child.markAsDetached$ui();
                }
                child.setAsDelegateTo$ui(child);
                child.setAggregateChildKindSet$ui(0);
                if (node == null) {
                    this.delegate = child.getChild();
                } else {
                    node.setChild$ui(child.getChild());
                }
                child.setChild$ui(null);
                child.setParent$ui(null);
                int kindSet$ui = getKindSet();
                int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(iCalculateNodeKindSetFromIncludingDelegates, true);
                if (getIsAttached() && (kindSet$ui & NodeKind.m7763constructorimpl(2)) != 0 && (NodeKind.m7763constructorimpl(2) & iCalculateNodeKindSetFromIncludingDelegates) == 0) {
                    NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                    getNode().updateCoordinator$ui(null);
                    nodes.syncCoordinators();
                    return;
                }
                return;
            }
            node = child;
        }
        throw new IllegalStateException(("Could not find delegate: " + instance).toString());
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int kindSet$ui = getKindSet();
        if ((delegateKindSet & NodeKind.m7763constructorimpl(2)) == 0 || (NodeKind.m7763constructorimpl(2) & kindSet$ui) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode);
    }

    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        Modifier.Node child;
        int kindSet$ui = getKindSet();
        setKindSet$ui(newKindSet);
        if (kindSet$ui != newKindSet) {
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui(newKindSet);
            }
            if (getIsAttached()) {
                Modifier.Node node = getNode();
                DelegatingNode parent = this;
                while (parent != null) {
                    newKindSet |= parent.getKindSet();
                    parent.setKindSet$ui(newKindSet);
                    if (parent == node) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (recalculateOwner && parent == node) {
                    newKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui(newKindSet);
                }
                int aggregateChildKindSet = newKindSet | ((parent == null || (child = parent.getChild()) == null) ? 0 : child.getAggregateChildKindSet());
                while (parent != null) {
                    aggregateChildKindSet |= parent.getKindSet();
                    parent.setAggregateChildKindSet$ui(aggregateChildKindSet);
                    parent = parent.getParent();
                }
            }
        }
    }

    public final void forEachImmediateDelegate$ui(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            block.invoke(delegate);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui() {
        super.markAsAttached$ui();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui(getCoordinator());
            if (!delegate.getIsAttached()) {
                delegate.markAsAttached$ui();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui() {
        super.runDetachLifecycle$ui();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runDetachLifecycle$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui() {
        super.reset$ui();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.reset$ui();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runAttachLifecycle$ui();
        }
        super.runAttachLifecycle$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.markAsDetached$ui();
        }
        super.markAsDetached$ui();
    }
}
