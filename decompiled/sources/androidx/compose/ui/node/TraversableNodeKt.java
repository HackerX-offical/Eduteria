package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmAndAndroidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: TraversableNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u0005¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"findNearestAncestor", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "traverseAncestors", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TraversableNodeKt {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends androidx.compose.ui.node.TraversableNode> T findNearestAncestor(T r12) {
        /*
            r0 = r12
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 262144(0x40000, float:3.67342E-40)
            int r1 = androidx.compose.ui.node.NodeKind.m7763constructorimpl(r1)
            boolean r2 = androidx.compose.ui.ComposeUiFlags.isTraversableDelegatesFixEnabled
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            boolean r3 = r3.getIsAttached()
            if (r3 != 0) goto L1b
            java.lang.String r3 = "visitAncestors called on an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r3)
        L1b:
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getParent()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L27:
            r4 = 0
            if (r0 == 0) goto Lc7
            androidx.compose.ui.node.NodeChain r5 = r0.getNodes()
            androidx.compose.ui.Modifier$Node r5 = r5.getHead()
            int r5 = r5.getAggregateChildKindSet()
            r5 = r5 & r1
            if (r5 == 0) goto Lb2
        L39:
            if (r3 == 0) goto Lb2
            int r5 = r3.getKindSet()
            r5 = r5 & r1
            if (r5 == 0) goto Lad
            r5 = r3
            r6 = r4
        L44:
            if (r5 == 0) goto Lad
            boolean r7 = r5 instanceof androidx.compose.ui.node.TraversableNode
            if (r7 == 0) goto L64
            r7 = r5
            androidx.compose.ui.node.TraversableNode r7 = (androidx.compose.ui.node.TraversableNode) r7
            java.lang.Object r8 = r12.getTraverseKey()
            java.lang.Object r9 = r7.getTraverseKey()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L62
            boolean r8 = androidx.compose.ui.Actual_jvmAndAndroidKt.areObjectsOfSameType(r12, r7)
            if (r8 == 0) goto L62
            return r7
        L62:
            if (r2 == 0) goto La8
        L64:
            int r7 = r5.getKindSet()
            r7 = r7 & r1
            if (r7 == 0) goto La8
            boolean r7 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto La8
            r7 = r5
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = 0
            r9 = r8
        L78:
            r10 = 1
            if (r7 == 0) goto La5
            int r11 = r7.getKindSet()
            r11 = r11 & r1
            if (r11 == 0) goto La0
            int r9 = r9 + 1
            if (r9 != r10) goto L88
            r5 = r7
            goto La0
        L88:
            if (r6 != 0) goto L93
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            r10 = 16
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r10]
            r6.<init>(r10, r8)
        L93:
            if (r5 == 0) goto L9b
            if (r6 == 0) goto L9a
            r6.add(r5)
        L9a:
            r5 = r4
        L9b:
            if (r6 == 0) goto La0
            r6.add(r7)
        La0:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L78
        La5:
            if (r9 != r10) goto La8
            goto L44
        La8:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L44
        Lad:
            androidx.compose.ui.Modifier$Node r3 = r3.getParent()
            goto L39
        Lb2:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui()
            if (r0 == 0) goto Lc4
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes()
            if (r3 == 0) goto Lc4
            androidx.compose.ui.Modifier$Node r3 = r3.getTail()
            goto L27
        Lc4:
            r3 = r4
            goto L27
        Lc7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.findNearestAncestor(androidx.compose.ui.node.TraversableNode):androidx.compose.ui.node.TraversableNode");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    public static final <T extends TraversableNode> void traverseAncestors(T t, Function1<? super T, Boolean> function1) {
        NodeChain nodes;
        T t2 = t;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = t2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            boolean zBooleanValue = true;
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmAndAndroidKt.areObjectsOfSameType(t, traversableNode)) {
                                    zBooleanValue = function1.invoke(traversableNode).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else {
                                if (((nodePop.getKindSet() & iM7763constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0038, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseChildren(T r11, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r12) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.TraversableNode, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    public static final <T extends TraversableNode> void traverseDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke;
        T t2 = t;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = t2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmAndAndroidKt.areObjectsOfSameType(t, traversableNode)) {
                                    traverseDescendantsActionInvoke = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsActionInvoke = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
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
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.node.TraversableNode findNearestAncestor(androidx.compose.ui.node.DelegatableNode r11, java.lang.Object r12) {
        /*
            r0 = 262144(0x40000, float:3.67342E-40)
            int r0 = androidx.compose.ui.node.NodeKind.m7763constructorimpl(r0)
            boolean r1 = androidx.compose.ui.ComposeUiFlags.isTraversableDelegatesFixEnabled
            androidx.compose.ui.Modifier$Node r2 = r11.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 != 0) goto L18
            java.lang.String r2 = "visitAncestors called on an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r2)
        L18:
            androidx.compose.ui.Modifier$Node r2 = r11.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent()
            androidx.compose.ui.node.LayoutNode r11 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r11)
        L24:
            r3 = 0
            if (r11 == 0) goto Lba
            androidx.compose.ui.node.NodeChain r4 = r11.getNodes()
            androidx.compose.ui.Modifier$Node r4 = r4.getHead()
            int r4 = r4.getAggregateChildKindSet()
            r4 = r4 & r0
            if (r4 == 0) goto La5
        L36:
            if (r2 == 0) goto La5
            int r4 = r2.getKindSet()
            r4 = r4 & r0
            if (r4 == 0) goto La0
            r4 = r2
            r5 = r3
        L41:
            if (r4 == 0) goto La0
            boolean r6 = r4 instanceof androidx.compose.ui.node.TraversableNode
            if (r6 == 0) goto L57
            r6 = r4
            androidx.compose.ui.node.TraversableNode r6 = (androidx.compose.ui.node.TraversableNode) r6
            java.lang.Object r7 = r6.getTraverseKey()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r7)
            if (r7 == 0) goto L55
            return r6
        L55:
            if (r1 == 0) goto L9b
        L57:
            int r6 = r4.getKindSet()
            r6 = r6 & r0
            if (r6 == 0) goto L9b
            boolean r6 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L9b
            r6 = r4
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate()
            r7 = 0
            r8 = r7
        L6b:
            r9 = 1
            if (r6 == 0) goto L98
            int r10 = r6.getKindSet()
            r10 = r10 & r0
            if (r10 == 0) goto L93
            int r8 = r8 + 1
            if (r8 != r9) goto L7b
            r4 = r6
            goto L93
        L7b:
            if (r5 != 0) goto L86
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
        L86:
            if (r4 == 0) goto L8e
            if (r5 == 0) goto L8d
            r5.add(r4)
        L8d:
            r4 = r3
        L8e:
            if (r5 == 0) goto L93
            r5.add(r6)
        L93:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild()
            goto L6b
        L98:
            if (r8 != r9) goto L9b
            goto L41
        L9b:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r5)
            goto L41
        La0:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent()
            goto L36
        La5:
            androidx.compose.ui.node.LayoutNode r11 = r11.getParent$ui()
            if (r11 == 0) goto Lb7
            androidx.compose.ui.node.NodeChain r2 = r11.getNodes()
            if (r2 == 0) goto Lb7
            androidx.compose.ui.Modifier$Node r2 = r2.getTail()
            goto L24
        Lb7:
            r2 = r3
            goto L24
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.findNearestAncestor(androidx.compose.ui.node.DelegatableNode, java.lang.Object):androidx.compose.ui.node.TraversableNode");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((nodePop.getKindSet() & iM7763constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void traverseChildren(androidx.compose.ui.node.DelegatableNode r10, java.lang.Object r11, kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.TraversableNode, java.lang.Boolean> r12) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.DelegatableNode, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    public static final void traverseDescendants(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    traverseDescendantsActionInvoke = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsActionInvoke = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
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
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }
}
