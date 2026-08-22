package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes10.dex */
public class NodeTransformer {
    private boolean hasFinally;
    private ObjArray loopEnds;
    private ObjArray loops;

    protected void visitCall(Node node, ScriptNode scriptNode) {
    }

    protected void visitNew(Node node, ScriptNode scriptNode) {
    }

    public final void transform(ScriptNode scriptNode, CompilerEnvirons compilerEnvirons) {
        transform(scriptNode, false, compilerEnvirons);
    }

    public final void transform(ScriptNode scriptNode, boolean z, CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons.getLanguageVersion() >= 200 && scriptNode.isInStrictMode()) {
            z = true;
        }
        transformCompilationUnit(scriptNode, z);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i), z, compilerEnvirons);
        }
    }

    private void transformCompilationUnit(ScriptNode scriptNode, boolean z) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        boolean z2 = scriptNode.getType() != 110 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z2);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z2, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0162  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.mozilla.javascript.NodeTransformer] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v25, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v30, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode r19, org.mozilla.javascript.Node r20, org.mozilla.javascript.ast.Scope r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NodeTransformer.transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode, org.mozilla.javascript.Node, org.mozilla.javascript.ast.Scope, boolean, boolean):void");
    }

    protected Node visitLet(boolean z, Node node, Node node2, Node node3) {
        Node node4;
        Node firstChild;
        Node node5;
        Node firstChild2;
        Node firstChild3 = node3.getFirstChild();
        Node next = firstChild3.getNext();
        node3.removeChild(firstChild3);
        node3.removeChild(next);
        int i = 159;
        boolean z2 = node3.getType() == 159;
        int i2 = 154;
        if (z) {
            Node nodeReplaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 160 : 130));
            ArrayList arrayList = new ArrayList();
            Node node6 = new Node(67);
            Node firstChild4 = firstChild3.getFirstChild();
            while (firstChild4 != null) {
                if (firstChild4.getType() == i) {
                    List list = (List) firstChild4.getProp(22);
                    Node firstChild5 = firstChild4.getFirstChild();
                    if (firstChild5.getType() != i2) {
                        throw Kit.codeBug();
                    }
                    if (z2) {
                        node5 = new Node(90, firstChild5.getNext(), next);
                    } else {
                        node5 = new Node(130, new Node(134, firstChild5.getNext()), next);
                    }
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            node6.addChildToBack(new Node(127, Node.newNumber(0.0d)));
                        }
                    }
                    firstChild2 = firstChild5.getFirstChild();
                } else {
                    node5 = next;
                    firstChild2 = firstChild4;
                }
                if (firstChild2.getType() != 39) {
                    throw Kit.codeBug();
                }
                arrayList.add(ScriptRuntime.getIndexObject(firstChild2.getString()));
                Node firstChild6 = firstChild2.getFirstChild();
                if (firstChild6 == null) {
                    firstChild6 = new Node(127, Node.newNumber(0.0d));
                }
                node6.addChildToBack(firstChild6);
                firstChild4 = firstChild4.getNext();
                next = node5;
                i = 159;
                i2 = 154;
            }
            node6.putProp(12, arrayList.toArray());
            nodeReplaceCurrent.addChildToBack(new Node(2, node6));
            nodeReplaceCurrent.addChildToBack(new Node(124, next));
            nodeReplaceCurrent.addChildToBack(new Node(3));
            return nodeReplaceCurrent;
        }
        Node nodeReplaceCurrent2 = replaceCurrent(node, node2, node3, new Node(z2 ? 90 : 130));
        Node node7 = new Node(90);
        Node firstChild7 = firstChild3.getFirstChild();
        while (firstChild7 != null) {
            if (firstChild7.getType() == 159) {
                Node firstChild8 = firstChild7.getFirstChild();
                if (firstChild8.getType() != 154) {
                    throw Kit.codeBug();
                }
                if (z2) {
                    node4 = new Node(90, firstChild8.getNext(), next);
                } else {
                    node4 = new Node(130, new Node(134, firstChild8.getNext()), next);
                }
                Scope.joinScopes((Scope) firstChild7, (Scope) node3);
                firstChild = firstChild8.getFirstChild();
            } else {
                node4 = next;
                firstChild = firstChild7;
            }
            if (firstChild.getType() != 39) {
                throw Kit.codeBug();
            }
            Node nodeNewString = Node.newString(firstChild.getString());
            nodeNewString.setScope((Scope) node3);
            Node firstChild9 = firstChild.getFirstChild();
            if (firstChild9 == null) {
                firstChild9 = new Node(127, Node.newNumber(0.0d));
            }
            node7.addChildToBack(new Node(56, nodeNewString, firstChild9));
            firstChild7 = firstChild7.getNext();
            next = node4;
        }
        if (z2) {
            nodeReplaceCurrent2.addChildToBack(node7);
            node3.setType(90);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildToBack(next);
            if (next instanceof Scope) {
                Scope scope = (Scope) next;
                Scope parentScope = scope.getParentScope();
                Scope scope2 = (Scope) node3;
                scope.setParentScope(scope2);
                scope2.setParentScope(parentScope);
                return nodeReplaceCurrent2;
            }
        } else {
            nodeReplaceCurrent2.addChildToBack(new Node(134, node7));
            node3.setType(130);
            nodeReplaceCurrent2.addChildToBack(node3);
            node3.addChildrenToBack(next);
            if (next instanceof Scope) {
                Scope scope3 = (Scope) next;
                Scope parentScope2 = scope3.getParentScope();
                Scope scope4 = (Scope) node3;
                scope3.setParentScope(scope4);
                scope4.setParentScope(parentScope2);
            }
        }
        return nodeReplaceCurrent2;
    }

    private static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
            return node4;
        }
        if (node3 != node2.getNext()) {
            Kit.codeBug();
        }
        node.addChildAfter(node4, node2);
        return node4;
    }

    private static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.replaceChild(node3, node4);
            return node4;
        }
        if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
            return node4;
        }
        node.replaceChild(node3, node4);
        return node4;
    }
}
