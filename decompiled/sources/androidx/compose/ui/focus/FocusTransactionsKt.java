package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusTransactions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a \u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0002\u001a)\u0010\n\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\b\u000f\u001a\f\u0010\u0010\u001a\u00020\u0002*\u00020\u0002H\u0002\u001a\u001b\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001b\u0010\u0017\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u001b\u0010\u0019\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"performRequestFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "captureFocus", "freeFocus", "clearFocus", "forced", "refreshFocusEvents", "grantFocus", "clearChildFocus", "requestOwnerFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-Etdf9zw", "requireActiveChild", "performCustomRequestFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomRequestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomClearFocus", "performCustomClearFocus-Mxy_nc0", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        NodeChain nodes;
        NodeChain nodes2;
        FocusOwner focusOwner;
        boolean z;
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusStateImpl2;
        NodeChain nodes3;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        MutableVector mutableVector2;
        FocusTargetNode focusTargetNode4 = focusTargetNode;
        FocusOwner focusOwner2 = DelegatableNodeKt.requireOwner(focusTargetNode4).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner2.getActiveFocusTargetNode();
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int i = 1;
        if (activeFocusTargetNode == focusTargetNode) {
            FocusStateImpl focusStateImpl3 = focusState;
            focusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl3, focusStateImpl3);
            return true;
        }
        MutableVector mutableVector3 = null;
        if (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if ((activeFocusTargetNode == null || activeFocusTargetNode.getIsInteropViewHost()) && !focusTargetNode.getIsInteropViewHost() && !m5646requestOwnerFocusEtdf9zw$default(focusTargetNode, null, null, 3, null)) {
                return false;
            }
        } else if (activeFocusTargetNode == null && !m5646requestOwnerFocusEtdf9zw$default(focusTargetNode, null, null, 3, null)) {
            return false;
        }
        int i2 = 1024;
        if (activeFocusTargetNode != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            FocusTargetNode focusTargetNode5 = activeFocusTargetNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode5.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector4 = mutableVector3;
                            Modifier.Node nodePop = parent;
                            while (nodePop != null) {
                                int i3 = i2;
                                if (nodePop instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) nodePop);
                                } else {
                                    if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                        int i4 = 0;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                                i4++;
                                                if (i4 == i) {
                                                    Unit unit = Unit.INSTANCE;
                                                    focusTargetNode3 = focusTargetNode4;
                                                    nodePop = delegate;
                                                } else {
                                                    if (mutableVector4 == null) {
                                                        focusTargetNode3 = focusTargetNode4;
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        focusTargetNode3 = focusTargetNode4;
                                                        mutableVector2 = mutableVector4;
                                                    }
                                                    if (nodePop != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(nodePop));
                                                        }
                                                        nodePop = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(delegate));
                                                    }
                                                    mutableVector4 = mutableVector2;
                                                }
                                            } else {
                                                focusTargetNode3 = focusTargetNode4;
                                            }
                                            delegate = delegate.getChild();
                                            focusTargetNode4 = focusTargetNode3;
                                            i = 1;
                                        }
                                        focusTargetNode2 = focusTargetNode4;
                                        int i5 = i;
                                        if (i4 == i5) {
                                            i = i5;
                                            i2 = i3;
                                            focusTargetNode4 = focusTargetNode2;
                                        }
                                    }
                                    nodePop = DelegatableNodeKt.pop(mutableVector4);
                                    i2 = i3;
                                    focusTargetNode4 = focusTargetNode2;
                                    i = 1;
                                }
                                focusTargetNode2 = focusTargetNode4;
                                nodePop = DelegatableNodeKt.pop(mutableVector4);
                                i2 = i3;
                                focusTargetNode4 = focusTargetNode2;
                                i = 1;
                            }
                        }
                        parent = parent.getParent();
                        i2 = i2;
                        focusTargetNode4 = focusTargetNode4;
                        i = 1;
                        mutableVector3 = null;
                    }
                }
                FocusTargetNode focusTargetNode6 = focusTargetNode4;
                int i6 = i2;
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                parent = (layoutNodeRequireLayoutNode == null || (nodes3 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes3.getTail();
                i2 = i6;
                focusTargetNode4 = focusTargetNode6;
                i = 1;
                mutableVector3 = null;
            }
        } else {
            mutableVector = null;
        }
        FocusTargetNode focusTargetNode7 = focusTargetNode4;
        int i7 = i2;
        MutableVector mutableVector5 = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector mutableVector6 = new MutableVector(new FocusTargetNode[16], 0);
        int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(i7);
        if (!focusTargetNode7.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent2 = focusTargetNode7.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode7);
        boolean z2 = true;
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                while (parent2 != null) {
                    if ((parent2.getKindSet() & iM7763constructorimpl2) != 0) {
                        Modifier.Node nodePop2 = parent2;
                        MutableVector mutableVector7 = null;
                        while (nodePop2 != null) {
                            if (nodePop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode8 = (FocusTargetNode) nodePop2;
                                focusOwner = focusOwner2;
                                if (Intrinsics.areEqual((Object) (mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode8)) : null), (Object) true)) {
                                    mutableVector5.add(focusTargetNode8);
                                } else {
                                    mutableVector6.add(focusTargetNode8);
                                }
                                if (focusTargetNode8 == activeFocusTargetNode) {
                                    z2 = false;
                                }
                                z = false;
                            } else {
                                focusOwner = focusOwner2;
                                z = true;
                            }
                            if (z && (nodePop2.getKindSet() & iM7763constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                                int i8 = 0;
                                while (delegate2 != null) {
                                    if ((delegate2.getKindSet() & iM7763constructorimpl2) == 0) {
                                        focusStateImpl2 = focusState;
                                    } else {
                                        i8++;
                                        if (i8 == 1) {
                                            Unit unit2 = Unit.INSTANCE;
                                            nodePop2 = delegate2;
                                            focusStateImpl2 = focusState;
                                        } else {
                                            if (mutableVector7 == null) {
                                                focusStateImpl2 = focusState;
                                                mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                focusStateImpl2 = focusState;
                                            }
                                            if (nodePop2 != null) {
                                                if (mutableVector7 != null) {
                                                    Boolean.valueOf(mutableVector7.add(nodePop2));
                                                }
                                                nodePop2 = null;
                                            }
                                            if (mutableVector7 != null) {
                                                Boolean.valueOf(mutableVector7.add(delegate2));
                                            }
                                        }
                                    }
                                    delegate2 = delegate2.getChild();
                                    focusState = focusStateImpl2;
                                }
                                focusStateImpl = focusState;
                                if (i8 == 1) {
                                }
                                focusOwner2 = focusOwner;
                                focusState = focusStateImpl;
                            } else {
                                focusStateImpl = focusState;
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector7);
                            focusOwner2 = focusOwner;
                            focusState = focusStateImpl;
                        }
                    }
                    parent2 = parent2.getParent();
                    focusOwner2 = focusOwner2;
                    focusState = focusState;
                }
            }
            FocusOwner focusOwner3 = focusOwner2;
            FocusStateImpl focusStateImpl4 = focusState;
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
            parent2 = (layoutNodeRequireLayoutNode2 == null || (nodes2 = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes2.getTail();
            focusOwner2 = focusOwner3;
            focusState = focusStateImpl4;
        }
        FocusOwner focusOwner4 = focusOwner2;
        FocusStateImpl focusStateImpl5 = focusState;
        if (z2 && activeFocusTargetNode != null && !clearFocus$default(activeFocusTargetNode, false, true, 1, null)) {
            return false;
        }
        grantFocus(focusTargetNode);
        if (ComposeUiFlags.isOptimizedFocusEventDispatchEnabled && z2 && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            Unit unit3 = Unit.INSTANCE;
        }
        if (mutableVector != null) {
            int size = mutableVector.getSize() - 1;
            Object[] objArr = mutableVector.content;
            if (size < objArr.length) {
                while (size >= 0) {
                    FocusTargetNode focusTargetNode9 = (FocusTargetNode) objArr[size];
                    if (focusOwner4.getActiveFocusTargetNode() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode9.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                    size--;
                }
            }
            Unit unit4 = Unit.INSTANCE;
        }
        int size2 = mutableVector6.getSize() - 1;
        Object[] objArr2 = mutableVector6.content;
        if (size2 < objArr2.length) {
            while (size2 >= 0) {
                FocusTargetNode focusTargetNode10 = (FocusTargetNode) objArr2[size2];
                if (focusOwner4.getActiveFocusTargetNode() != focusTargetNode) {
                    return false;
                }
                focusTargetNode10.dispatchFocusCallbacks$ui(focusTargetNode10 == activeFocusTargetNode ? FocusStateImpl.Active : FocusStateImpl.Inactive, FocusStateImpl.ActiveParent);
                size2--;
            }
        }
        if (focusOwner4.getActiveFocusTargetNode() != focusTargetNode) {
            return false;
        }
        focusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl5, FocusStateImpl.Active);
        if (focusOwner4.getActiveFocusTargetNode() != focusTargetNode) {
            return false;
        }
        if (ComposeUiFlags.isFocusRestorationEnabled) {
            FocusTargetNode focusTargetNode11 = (FocusTargetNode) (mutableVector5.getSize() == 0 ? null : mutableVector5.content[mutableVector5.getSize() - 1]);
            int iM7763constructorimpl3 = NodeKind.m7763constructorimpl(i7);
            if (!focusTargetNode7.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent3 = focusTargetNode7.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(focusTargetNode7);
            loop10: while (layoutNodeRequireLayoutNode3 != null) {
                if ((layoutNodeRequireLayoutNode3.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl3) != 0) {
                    while (parent3 != null) {
                        if ((parent3.getKindSet() & iM7763constructorimpl3) != 0) {
                            Modifier.Node nodePop3 = parent3;
                            MutableVector mutableVector8 = null;
                            while (nodePop3 != null) {
                                if (nodePop3 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode12 = (FocusTargetNode) nodePop3;
                                    FocusRestorerKt.saveFocusedChild(focusTargetNode12);
                                    if (focusTargetNode12 == focusTargetNode11) {
                                        break loop10;
                                    }
                                } else if ((nodePop3.getKindSet() & iM7763constructorimpl3) != 0 && (nodePop3 instanceof DelegatingNode)) {
                                    int i9 = 0;
                                    for (Modifier.Node delegate3 = ((DelegatingNode) nodePop3).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                                        if ((delegate3.getKindSet() & iM7763constructorimpl3) != 0) {
                                            i9++;
                                            if (i9 == 1) {
                                                Unit unit5 = Unit.INSTANCE;
                                                nodePop3 = delegate3;
                                            } else {
                                                if (mutableVector8 == null) {
                                                    mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop3 != null) {
                                                    if (mutableVector8 != null) {
                                                        Boolean.valueOf(mutableVector8.add(nodePop3));
                                                    }
                                                    nodePop3 = null;
                                                }
                                                if (mutableVector8 != null) {
                                                    Boolean.valueOf(mutableVector8.add(delegate3));
                                                }
                                            }
                                        }
                                    }
                                    if (i9 != 1) {
                                        nodePop3 = DelegatableNodeKt.pop(mutableVector8);
                                    }
                                }
                                nodePop3 = DelegatableNodeKt.pop(mutableVector8);
                            }
                        }
                        parent3 = parent3.getParent();
                    }
                }
                layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui();
                parent3 = (layoutNodeRequireLayoutNode3 == null || (nodes = layoutNodeRequireLayoutNode3.getNodes()) == null) ? null : nodes.getTail();
            }
            Unit unit6 = Unit.INSTANCE;
        }
        if (!ComposeUiFlags.isViewFocusFixEnabled || DelegatableNodeKt.requireLayoutNode(focusTargetNode7).getInteropView() != null) {
            return true;
        }
        m5645requestOwnerFocusEtdf9zw(focusTargetNode, FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5606getNextdhqQ8s()), null);
        return true;
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(true);
            focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Captured);
            return true;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(false);
            focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Active);
        }
        return true;
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
                }
            }
            return true;
        }
        if (i == 2) {
            if (z && !ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Inactive);
                }
            }
            return z;
        }
        if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!clearChildFocus(focusTargetNode, z, z2)) {
            return false;
        }
        if (z2) {
            focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
        }
        return true;
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt.grantFocus.1
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
                focusTargetNode.fetchFocusProperties$ui();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(focusTargetNode);
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    /* JADX INFO: renamed from: requestOwnerFocus-Etdf9zw$default, reason: not valid java name */
    static /* synthetic */ boolean m5646requestOwnerFocusEtdf9zw$default(FocusTargetNode focusTargetNode, FocusDirection focusDirection, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            focusDirection = null;
        }
        if ((i & 2) != 0) {
            rect = null;
        }
        return m5645requestOwnerFocusEtdf9zw(focusTargetNode, focusDirection, rect);
    }

    /* JADX INFO: renamed from: requestOwnerFocus-Etdf9zw, reason: not valid java name */
    private static final boolean m5645requestOwnerFocusEtdf9zw(FocusTargetNode focusTargetNode, FocusDirection focusDirection, Rect rect) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo5619requestOwnerFocus7o62pno(focusDirection, rect);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }

    /* JADX INFO: renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m5644performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        Modifier.Node nodePop;
        NodeChain nodes;
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 == 3) {
            return m5641performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM7763constructorimpl) != 0) {
                        nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                        i3++;
                                        if (i3 == 1) {
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
                                if (i3 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop;
        if (focusTargetNode3 == null) {
            return CustomDestinationResult.None;
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode3.getFocusState().ordinal()];
        if (i4 == 1) {
            return m5642performCustomEnterMxy_nc0(focusTargetNode3, i);
        }
        if (i4 == 2) {
            return CustomDestinationResult.Cancelled;
        }
        if (i4 == 3) {
            return m5644performCustomRequestFocusMxy_nc0(focusTargetNode3, i);
        }
        if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult customDestinationResultM5644performCustomRequestFocusMxy_nc0 = m5644performCustomRequestFocusMxy_nc0(focusTargetNode3, i);
        CustomDestinationResult customDestinationResult = customDestinationResultM5644performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? customDestinationResultM5644performCustomRequestFocusMxy_nc0 : null;
        return customDestinationResult == null ? m5642performCustomEnterMxy_nc0(focusTargetNode3, i) : customDestinationResult;
    }

    /* JADX INFO: renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m5641performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult customDestinationResultM5641performCustomClearFocusMxy_nc0 = m5641performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (customDestinationResultM5641performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    customDestinationResultM5641performCustomClearFocusMxy_nc0 = null;
                }
                return customDestinationResultM5641performCustomClearFocusMxy_nc0 == null ? m5643performCustomExitMxy_nc0(focusTargetNode, i) : customDestinationResultM5641performCustomClearFocusMxy_nc0;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m5642performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusProperties focusPropertiesFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                focusPropertiesFetchFocusProperties$ui.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                    FocusRequester cancel = FocusRequester.INSTANCE.getCancel();
                    if (cancel == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.INSTANCE.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m5628requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    FocusRequester redirect$ui = FocusRequester.INSTANCE.getRedirect$ui();
                    if (redirect$ui == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui == FocusRequester.INSTANCE.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m5628requestFocus3ESFkO8$default(redirect$ui, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m5643performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusProperties focusPropertiesFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                focusPropertiesFetchFocusProperties$ui.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                    FocusRequester cancel = FocusRequester.INSTANCE.getCancel();
                    if (cancel == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.INSTANCE.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m5628requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    FocusRequester redirect$ui = FocusRequester.INSTANCE.getRedirect$ui();
                    if (redirect$ui == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui == FocusRequester.INSTANCE.getRedirect$ui()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m5628requestFocus3ESFkO8$default(redirect$ui, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
