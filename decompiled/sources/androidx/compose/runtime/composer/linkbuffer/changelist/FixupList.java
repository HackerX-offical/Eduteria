package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.composer.DebugStringFormattable;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.changelist.Operation;
import androidx.compose.runtime.composer.linkbuffer.changelist.Operations;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: FixupList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ,\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J*\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\b2\n\u0010\u001e\u001a\u00060\u001fj\u0002` J&\u0010!\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u000fJ>\u0010%\u001a\u00020\u000f\"\u0004\b\u0000\u0010&\"\u0004\b\u0001\u0010'2\u0006\u0010(\u001a\u0002H&2\u001d\u0010)\u001a\u0019\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u000f0*¢\u0006\u0002\b+¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u00060"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "Landroidx/compose/runtime/composer/DebugStringFormattable;", "<init>", "()V", "operations", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "pendingOperations", "size", "", "getSize", "()I", "isEmpty", "", "isNotEmpty", FasteningElement.ATTR_CLEAR, "", "executeAndFlushAllPendingFixups", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "createAndInsertNode", "factory", "Lkotlin/Function0;", "", "insertIndex", "groupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "createAndInsertNodeByAnchor", ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "endNodeInsert", "updateNode", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "value", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "toDebugString", "", "linePrefix", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixupList extends DebugStringFormattable {
    public static final int $stable = 8;
    private final Operations operations = new Operations();
    private final Operations pendingOperations = new Operations();

    public final int getSize() {
        return this.operations.getOpCodesSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingFixups(Applier<?> applier, SlotTableEditor slots, RememberManager rememberManager, OperationErrorContext errorContext) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager, errorContext);
    }

    public final void createAndInsertNode(Function0<? extends Object> factory, int insertIndex, long groupHandle) {
        Operations operations = this.operations;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        operations.pushOp(insertNodeFixup);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.InsertNodeFixup insertNodeFixup2 = Operation.InsertNodeFixup.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), factory);
        Operation.InsertNodeFixup insertNodeFixup3 = Operation.InsertNodeFixup.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = insertIndex;
        Operation.InsertNodeFixup insertNodeFixup4 = Operation.InsertNodeFixup.INSTANCE;
        Operation.InsertNodeFixup insertNodeFixup5 = Operation.InsertNodeFixup.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl, 1, 2, groupHandle);
        operations.ensureAllArgumentsPushedFor(insertNodeFixup);
        Operations operations2 = this.pendingOperations;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        operations2.pushOp(postInsertNodeFixup);
        Operations operationsM5271constructorimpl2 = Operations.WriteScope.m5271constructorimpl(operations2);
        Operation.PostInsertNodeFixup postInsertNodeFixup2 = Operation.PostInsertNodeFixup.INSTANCE;
        operationsM5271constructorimpl2.intArgs[operationsM5271constructorimpl2.intArgsSize - operationsM5271constructorimpl2.opCodes[operationsM5271constructorimpl2.opCodesSize - 1].getInts()] = insertIndex;
        Operation.PostInsertNodeFixup postInsertNodeFixup3 = Operation.PostInsertNodeFixup.INSTANCE;
        Operation.PostInsertNodeFixup postInsertNodeFixup4 = Operation.PostInsertNodeFixup.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl2, 1, 2, groupHandle);
        operations2.ensureAllArgumentsPushedFor(postInsertNodeFixup);
    }

    public final void createAndInsertNodeByAnchor(Function0<? extends Object> factory, int insertIndex, LinkAnchor anchor) {
        Operations operations = this.operations;
        Operation.InsertNodeFixupByAnchor insertNodeFixupByAnchor = Operation.InsertNodeFixupByAnchor.INSTANCE;
        operations.pushOp(insertNodeFixupByAnchor);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.InsertNodeFixupByAnchor insertNodeFixupByAnchor2 = Operation.InsertNodeFixupByAnchor.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), factory);
        Operation.InsertNodeFixupByAnchor insertNodeFixupByAnchor3 = Operation.InsertNodeFixupByAnchor.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = insertIndex;
        Operation.InsertNodeFixupByAnchor insertNodeFixupByAnchor4 = Operation.InsertNodeFixupByAnchor.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(1), anchor);
        operations.ensureAllArgumentsPushedFor(insertNodeFixupByAnchor);
        Operations operations2 = this.pendingOperations;
        Operation.PostInsertNodeFixupByAnchor postInsertNodeFixupByAnchor = Operation.PostInsertNodeFixupByAnchor.INSTANCE;
        operations2.pushOp(postInsertNodeFixupByAnchor);
        Operations operationsM5271constructorimpl2 = Operations.WriteScope.m5271constructorimpl(operations2);
        Operation.PostInsertNodeFixupByAnchor postInsertNodeFixupByAnchor2 = Operation.PostInsertNodeFixupByAnchor.INSTANCE;
        operationsM5271constructorimpl2.intArgs[operationsM5271constructorimpl2.intArgsSize - operationsM5271constructorimpl2.opCodes[operationsM5271constructorimpl2.opCodesSize - 1].getInts()] = insertIndex;
        Operation.PostInsertNodeFixupByAnchor postInsertNodeFixupByAnchor3 = Operation.PostInsertNodeFixupByAnchor.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl2, Operation.ObjectParameter.m5244constructorimpl(0), anchor);
        operations2.ensureAllArgumentsPushedFor(postInsertNodeFixupByAnchor);
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final <V, T> void updateNode(V value, Function2<? super T, ? super V, Unit> block) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateNode updateNode2 = Operation.UpdateNode.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), value);
        Operation.UpdateNode updateNode3 = Operation.UpdateNode.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(1);
        Intrinsics.checkNotNull(block, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, iM5244constructorimpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2));
        operations.ensureAllArgumentsPushedFor(updateNode);
    }

    @Override // androidx.compose.runtime.composer.DebugStringFormattable
    public String toDebugString(String linePrefix) {
        StringBuilder sb = new StringBuilder();
        sb.append("FixupList instance containing " + getSize() + " operations");
        if (sb.length() > 0) {
            sb.append(":\n" + this.operations.toDebugString(linePrefix));
        }
        return sb.toString();
    }
}
