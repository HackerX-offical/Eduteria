package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemoved;

/* JADX INFO: compiled from: ModifierLocalManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fJ\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fJ\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/node/Owner;)V", "getOwner", "()Landroidx/compose/ui/node/Owner;", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", IoTRemoved.ELEMENT, "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "invalidated", "", "invalidate", "", "triggerUpdates", "invalidateConsumersOfNodeForKey", NodeElement.ELEMENT, "Landroidx/compose/ui/Modifier$Node;", "key", "set", "", "updatedProvider", "insertedProvider", "removedProvider", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifierLocalManager {
    public static final int $stable = 8;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<BackwardsCompatNode> inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
    private final MutableVector<ModifierLocal<?>> insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    private final MutableVector<LayoutNode> removed = new MutableVector<>(new LayoutNode[16], 0);
    private final MutableVector<ModifierLocal<?>> removedLocal = new MutableVector<>(new ModifierLocal[16], 0);

    public ModifierLocalManager(Owner owner) {
        this.owner = owner;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (this.invalidated) {
            return;
        }
        this.invalidated = true;
        this.owner.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager.invalidate.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ModifierLocalManager.this.triggerUpdates();
            }
        });
    }

    public final void triggerUpdates() {
        this.invalidated = false;
        HashSet hashSet = new HashSet();
        MutableVector<LayoutNode> mutableVector = this.removed;
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            ModifierLocal<?> modifierLocal = this.removedLocal.content[i];
            if (layoutNode.getNodes().getHead().getIsAttached()) {
                invalidateConsumersOfNodeForKey(layoutNode.getNodes().getHead(), modifierLocal, hashSet);
            }
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector<BackwardsCompatNode> mutableVector2 = this.inserted;
        BackwardsCompatNode[] backwardsCompatNodeArr = mutableVector2.content;
        int size2 = mutableVector2.getSize();
        for (int i2 = 0; i2 < size2; i2++) {
            BackwardsCompatNode backwardsCompatNode = backwardsCompatNodeArr[i2];
            ModifierLocal<?> modifierLocal2 = this.insertedLocal.content[i2];
            if (backwardsCompatNode.getIsAttached()) {
                invalidateConsumersOfNodeForKey(backwardsCompatNode, modifierLocal2, hashSet);
            }
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).updateModifierLocalConsumer();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8 */
    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        Modifier.Node node2 = node;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(32);
        if (!node2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = node2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node3.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                for (Modifier.Node child2 = node3; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) nodePop;
                                if (modifierLocalModifierNode instanceof BackwardsCompatNode) {
                                    BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalModifierNode;
                                    if ((backwardsCompatNode.getElement() instanceof ModifierLocalConsumer) && backwardsCompatNode.getReadValues().contains(key)) {
                                        set.add(modifierLocalModifierNode);
                                    }
                                }
                                if (modifierLocalModifierNode.getProvidedValues().contains$ui(key)) {
                                    break;
                                }
                            } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node3, false);
        }
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.removed.add(DelegatableNodeKt.requireLayoutNode(node));
        this.removedLocal.add(key);
        invalidate();
    }
}
