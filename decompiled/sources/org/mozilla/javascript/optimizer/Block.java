package org.mozilla.javascript.optimizer;

import java.util.BitSet;
import java.util.HashMap;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.ast.Jump;

/* JADX INFO: loaded from: classes10.dex */
class Block {
    static final boolean DEBUG = false;
    private static int debug_blockCount;
    private int itsBlockID;
    private int itsEndNodeIndex;
    private BitSet itsLiveOnEntrySet;
    private BitSet itsLiveOnExitSet;
    private BitSet itsNotDefSet;
    private Block[] itsPredecessors;
    private int itsStartNodeIndex;
    private Block[] itsSuccessors;
    private BitSet itsUseBeforeDefSet;

    private void printLiveOnEntrySet(OptFunctionNode optFunctionNode) {
    }

    private static String toString(Block[] blockArr, Node[] nodeArr) {
        return null;
    }

    private static class FatBlock {
        private ObjToIntMap predecessors;
        Block realBlock;
        private ObjToIntMap successors;

        private FatBlock() {
            this.successors = new ObjToIntMap();
            this.predecessors = new ObjToIntMap();
        }

        private static Block[] reduceToArray(ObjToIntMap objToIntMap) {
            if (objToIntMap.isEmpty()) {
                return null;
            }
            Block[] blockArr = new Block[objToIntMap.size()];
            ObjToIntMap.Iterator iteratorNewIterator = objToIntMap.newIterator();
            iteratorNewIterator.start();
            int i = 0;
            while (!iteratorNewIterator.done()) {
                blockArr[i] = ((FatBlock) iteratorNewIterator.getKey()).realBlock;
                iteratorNewIterator.next();
                i++;
            }
            return blockArr;
        }

        void addSuccessor(FatBlock fatBlock) {
            this.successors.put(fatBlock, 0);
        }

        void addPredecessor(FatBlock fatBlock) {
            this.predecessors.put(fatBlock, 0);
        }

        Block[] getSuccessors() {
            return reduceToArray(this.successors);
        }

        Block[] getPredecessors() {
            return reduceToArray(this.predecessors);
        }
    }

    Block(int i, int i2) {
        this.itsStartNodeIndex = i;
        this.itsEndNodeIndex = i2;
    }

    static void runFlowAnalyzes(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int paramCount = optFunctionNode.fnode.getParamCount();
        int paramAndVarCount = optFunctionNode.fnode.getParamAndVarCount();
        int[] iArr = new int[paramAndVarCount];
        for (int i = 0; i != paramCount; i++) {
            iArr[i] = 3;
        }
        for (int i2 = paramCount; i2 != paramAndVarCount; i2++) {
            iArr[i2] = 0;
        }
        Block[] blockArrBuildBlocks = buildBlocks(nodeArr);
        reachingDefDataFlow(optFunctionNode, nodeArr, blockArrBuildBlocks, iArr);
        typeFlow(optFunctionNode, nodeArr, blockArrBuildBlocks, iArr);
        while (paramCount != paramAndVarCount) {
            if (iArr[paramCount] == 1) {
                optFunctionNode.setIsNumberVar(paramCount);
            }
            paramCount++;
        }
    }

    private static Block[] buildBlocks(Node[] nodeArr) {
        HashMap map = new HashMap();
        ObjArray objArray = new ObjArray();
        int i = 0;
        for (int i2 = 0; i2 < nodeArr.length; i2++) {
            int type = nodeArr[i2].getType();
            if (type == 5 || type == 6 || type == 7) {
                FatBlock fatBlockNewFatBlock = newFatBlock(i, i2);
                if (nodeArr[i].getType() == 132) {
                    map.put(nodeArr[i], fatBlockNewFatBlock);
                }
                objArray.add(fatBlockNewFatBlock);
                i = i2 + 1;
            } else if (type == 132 && i2 != i) {
                FatBlock fatBlockNewFatBlock2 = newFatBlock(i, i2 - 1);
                if (nodeArr[i].getType() == 132) {
                    map.put(nodeArr[i], fatBlockNewFatBlock2);
                }
                objArray.add(fatBlockNewFatBlock2);
                i = i2;
            }
        }
        if (i != nodeArr.length) {
            FatBlock fatBlockNewFatBlock3 = newFatBlock(i, nodeArr.length - 1);
            if (nodeArr[i].getType() == 132) {
                map.put(nodeArr[i], fatBlockNewFatBlock3);
            }
            objArray.add(fatBlockNewFatBlock3);
        }
        for (int i3 = 0; i3 < objArray.size(); i3++) {
            FatBlock fatBlock = (FatBlock) objArray.get(i3);
            Node node = nodeArr[fatBlock.realBlock.itsEndNodeIndex];
            int type2 = node.getType();
            if (type2 != 5 && i3 < objArray.size() - 1) {
                FatBlock fatBlock2 = (FatBlock) objArray.get(i3 + 1);
                fatBlock.addSuccessor(fatBlock2);
                fatBlock2.addPredecessor(fatBlock);
            }
            if (type2 == 7 || type2 == 6 || type2 == 5) {
                Node node2 = ((Jump) node).target;
                FatBlock fatBlock3 = (FatBlock) map.get(node2);
                node2.putProp(6, fatBlock3.realBlock);
                fatBlock.addSuccessor(fatBlock3);
                fatBlock3.addPredecessor(fatBlock);
            }
        }
        Block[] blockArr = new Block[objArray.size()];
        for (int i4 = 0; i4 < objArray.size(); i4++) {
            FatBlock fatBlock4 = (FatBlock) objArray.get(i4);
            Block block = fatBlock4.realBlock;
            block.itsSuccessors = fatBlock4.getSuccessors();
            block.itsPredecessors = fatBlock4.getPredecessors();
            block.itsBlockID = i4;
            blockArr[i4] = block;
        }
        return blockArr;
    }

    private static FatBlock newFatBlock(int i, int i2) {
        FatBlock fatBlock = new FatBlock();
        fatBlock.realBlock = new Block(i, i2);
        return fatBlock;
    }

    private static void reachingDefDataFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        Block[] blockArr2;
        for (Block block : blockArr) {
            block.initLiveOnEntrySets(optFunctionNode, nodeArr);
        }
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        int length = blockArr.length - 1;
        zArr[length] = true;
        while (true) {
            boolean z = false;
            while (true) {
                if (zArr[length] || !zArr2[length]) {
                    zArr2[length] = true;
                    zArr[length] = false;
                    if (blockArr[length].doReachedUseDataFlow() && (blockArr2 = blockArr[length].itsPredecessors) != null) {
                        for (Block block2 : blockArr2) {
                            int i = block2.itsBlockID;
                            zArr[i] = true;
                            z |= i > length;
                        }
                    }
                }
                if (length == 0) {
                    break;
                } else {
                    length--;
                }
            }
            if (z) {
                length = blockArr.length - 1;
            } else {
                blockArr[0].markAnyTypeVariables(iArr);
                return;
            }
        }
    }

    private static void typeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, Block[] blockArr, int[] iArr) {
        boolean z;
        Block[] blockArr2;
        boolean[] zArr = new boolean[blockArr.length];
        boolean[] zArr2 = new boolean[blockArr.length];
        zArr[0] = true;
        do {
            int i = 0;
            z = false;
            while (true) {
                if (zArr[i] || !zArr2[i]) {
                    zArr2[i] = true;
                    zArr[i] = false;
                    if (blockArr[i].doTypeFlow(optFunctionNode, nodeArr, iArr) && (blockArr2 = blockArr[i].itsSuccessors) != null) {
                        for (Block block : blockArr2) {
                            int i2 = block.itsBlockID;
                            zArr[i2] = true;
                            z |= i2 < i;
                        }
                    }
                }
                if (i == blockArr.length - 1) {
                    break;
                } else {
                    i++;
                }
            }
        } while (z);
    }

    private static boolean assignType(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        int i4 = i2 | i3;
        iArr[i] = i4;
        return i3 != i4;
    }

    private void markAnyTypeVariables(int[] iArr) {
        for (int i = 0; i != iArr.length; i++) {
            if (this.itsLiveOnEntrySet.get(i)) {
                assignType(iArr, i, 3);
            }
        }
    }

    private void lookForVariableAccess(OptFunctionNode optFunctionNode, Node node) {
        int type = node.getType();
        if (type != 55) {
            if (type != 56) {
                if (type == 107 || type == 108) {
                    Node firstChild = node.getFirstChild();
                    if (firstChild.getType() == 55) {
                        int varIndex = optFunctionNode.getVarIndex(firstChild);
                        if (!this.itsNotDefSet.get(varIndex)) {
                            this.itsUseBeforeDefSet.set(varIndex);
                        }
                        this.itsNotDefSet.set(varIndex);
                        return;
                    }
                    lookForVariableAccess(optFunctionNode, firstChild);
                    return;
                }
                if (type == 138) {
                    int indexForNameNode = optFunctionNode.fnode.getIndexForNameNode(node);
                    if (indexForNameNode <= -1 || this.itsNotDefSet.get(indexForNameNode)) {
                        return;
                    }
                    this.itsUseBeforeDefSet.set(indexForNameNode);
                    return;
                }
                if (type != 157) {
                    for (Node firstChild2 = node.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNext()) {
                        lookForVariableAccess(optFunctionNode, firstChild2);
                    }
                    return;
                }
            }
            lookForVariableAccess(optFunctionNode, node.getFirstChild().getNext());
            this.itsNotDefSet.set(optFunctionNode.getVarIndex(node));
            return;
        }
        int varIndex2 = optFunctionNode.getVarIndex(node);
        if (this.itsNotDefSet.get(varIndex2)) {
            return;
        }
        this.itsUseBeforeDefSet.set(varIndex2);
    }

    private void initLiveOnEntrySets(OptFunctionNode optFunctionNode, Node[] nodeArr) {
        int varCount = optFunctionNode.getVarCount();
        this.itsUseBeforeDefSet = new BitSet(varCount);
        this.itsNotDefSet = new BitSet(varCount);
        this.itsLiveOnEntrySet = new BitSet(varCount);
        this.itsLiveOnExitSet = new BitSet(varCount);
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            lookForVariableAccess(optFunctionNode, nodeArr[i]);
        }
        this.itsNotDefSet.flip(0, varCount);
    }

    private boolean doReachedUseDataFlow() {
        this.itsLiveOnExitSet.clear();
        if (this.itsSuccessors != null) {
            int i = 0;
            while (true) {
                Block[] blockArr = this.itsSuccessors;
                if (i >= blockArr.length) {
                    break;
                }
                this.itsLiveOnExitSet.or(blockArr[i].itsLiveOnEntrySet);
                i++;
            }
        }
        return updateEntrySet(this.itsLiveOnEntrySet, this.itsLiveOnExitSet, this.itsUseBeforeDefSet, this.itsNotDefSet);
    }

    private boolean updateEntrySet(BitSet bitSet, BitSet bitSet2, BitSet bitSet3, BitSet bitSet4) {
        int iCardinality = bitSet.cardinality();
        bitSet.or(bitSet2);
        bitSet.and(bitSet4);
        bitSet.or(bitSet3);
        return bitSet.cardinality() != iCardinality;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057 A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int findExpressionType(org.mozilla.javascript.optimizer.OptFunctionNode r3, org.mozilla.javascript.Node r4, int[] r5) {
        /*
            int r0 = r4.getType()
            r1 = 35
            if (r0 == r1) goto L76
            r1 = 37
            if (r0 == r1) goto L76
            r1 = 40
            r2 = 1
            if (r0 == r1) goto L75
            r1 = 90
            if (r0 == r1) goto L76
            r1 = 103(0x67, float:1.44E-43)
            if (r0 == r1) goto L5f
            r1 = 157(0x9d, float:2.2E-43)
            if (r0 == r1) goto L76
            r1 = 55
            if (r0 == r1) goto L58
            r1 = 56
            if (r0 == r1) goto L76
            switch(r0) {
                case 8: goto L76;
                case 9: goto L57;
                case 10: goto L57;
                case 11: goto L57;
                default: goto L28;
            }
        L28:
            switch(r0) {
                case 18: goto L57;
                case 19: goto L57;
                case 20: goto L57;
                case 21: goto L45;
                case 22: goto L57;
                case 23: goto L57;
                case 24: goto L57;
                case 25: goto L57;
                default: goto L2b;
            }
        L2b:
            switch(r0) {
                case 27: goto L57;
                case 28: goto L57;
                case 29: goto L57;
                default: goto L2e;
            }
        L2e:
            switch(r0) {
                case 105: goto L33;
                case 106: goto L33;
                case 107: goto L57;
                case 108: goto L57;
                default: goto L31;
            }
        L31:
            r3 = 3
            return r3
        L33:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            int r0 = findExpressionType(r3, r4, r5)
            org.mozilla.javascript.Node r4 = r4.getNext()
            int r3 = findExpressionType(r3, r4, r5)
            r3 = r3 | r0
            return r3
        L45:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            int r0 = findExpressionType(r3, r4, r5)
            org.mozilla.javascript.Node r4 = r4.getNext()
            int r3 = findExpressionType(r3, r4, r5)
            r3 = r3 | r0
            return r3
        L57:
            return r2
        L58:
            int r3 = r3.getVarIndex(r4)
            r3 = r5[r3]
            return r3
        L5f:
            org.mozilla.javascript.Node r4 = r4.getFirstChild()
            org.mozilla.javascript.Node r4 = r4.getNext()
            org.mozilla.javascript.Node r0 = r4.getNext()
            int r4 = findExpressionType(r3, r4, r5)
            int r3 = findExpressionType(r3, r0, r5)
            r3 = r3 | r4
            return r3
        L75:
            return r2
        L76:
            org.mozilla.javascript.Node r4 = r4.getLastChild()
            int r3 = findExpressionType(r3, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.Block.findExpressionType(org.mozilla.javascript.optimizer.OptFunctionNode, org.mozilla.javascript.Node, int[]):int");
    }

    private static boolean findDefPoints(OptFunctionNode optFunctionNode, Node node, int[] iArr) {
        boolean zAssignType;
        Node firstChild = node.getFirstChild();
        boolean zFindDefPoints = false;
        for (Node next = firstChild; next != null; next = next.getNext()) {
            zFindDefPoints |= findDefPoints(optFunctionNode, next, iArr);
        }
        int type = node.getType();
        if (type != 56 && type != 157) {
            if ((type == 107 || type == 108) && firstChild.getType() == 55) {
                int varIndex = optFunctionNode.getVarIndex(firstChild);
                if (!optFunctionNode.fnode.getParamAndVarConst()[varIndex]) {
                    zAssignType = assignType(iArr, varIndex, 1);
                    return zAssignType | zFindDefPoints;
                }
            }
            return zFindDefPoints;
        }
        int iFindExpressionType = findExpressionType(optFunctionNode, firstChild.getNext(), iArr);
        int varIndex2 = optFunctionNode.getVarIndex(node);
        if (node.getType() != 56 || !optFunctionNode.fnode.getParamAndVarConst()[varIndex2]) {
            zAssignType = assignType(iArr, varIndex2, iFindExpressionType);
            return zAssignType | zFindDefPoints;
        }
        return zFindDefPoints;
    }

    private boolean doTypeFlow(OptFunctionNode optFunctionNode, Node[] nodeArr, int[] iArr) {
        boolean zFindDefPoints = false;
        for (int i = this.itsStartNodeIndex; i <= this.itsEndNodeIndex; i++) {
            Node node = nodeArr[i];
            if (node != null) {
                zFindDefPoints |= findDefPoints(optFunctionNode, node, iArr);
            }
        }
        return zFindDefPoints;
    }
}
