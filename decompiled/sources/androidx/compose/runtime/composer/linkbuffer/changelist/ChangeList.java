package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Changes;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.LinkRememberObserverHolder;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.Operation;
import androidx.compose.runtime.composer.linkbuffer.changelist.Operations;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: ChangeList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J,\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010+J\u001c\u0010,\u001a\u00020\u000e2\n\u0010-\u001a\u00060\u0007j\u0002`.2\b\u0010\u001d\u001a\u0004\u0018\u00010+J\u0010\u0010/\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010+J\u001a\u00100\u001a\u00020\u000e2\n\u00101\u001a\u00060\u0007j\u0002`22\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\u000eJ\u0006\u00105\u001a\u00020\u000eJ\u0010\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u00010+J\u0006\u00108\u001a\u00020\u000eJ\u001a\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\n\u0010<\u001a\u00060=j\u0002`>J\"\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\n\u0010<\u001a\u00060=j\u0002`>2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020\u000eJ\"\u0010D\u001a\u00020\u000e2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000e0F2\u0006\u0010H\u001a\u00020GJ\u0010\u0010I\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010+J>\u0010K\u001a\u00020\u000e\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M2\u0006\u0010\u001d\u001a\u0002HM2\u001d\u0010N\u001a\u0019\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020\u000e0O¢\u0006\u0002\bP¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007J\u001e\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u0012\u0010X\u001a\u00020\u000e2\n\u0010Y\u001a\u00060=j\u0002`>J\u001a\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\\2\n\u0010Y\u001a\u00060=j\u0002`>J\u0006\u0010]\u001a\u00020\u000eJ\u0006\u0010^\u001a\u00020\u000eJ\u000e\u0010_\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0007J\u001b\u0010`\u001a\u00020\u000e2\u000e\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0b¢\u0006\u0002\u0010cJ\u0014\u0010d\u001a\u00020\u000e2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000e0fJ\u001a\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020i2\n\u0010j\u001a\u00060=j\u0002`>J\u001e\u0010k\u001a\u00020\u000e2\u000e\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0l2\u0006\u0010m\u001a\u00020iJ(\u0010n\u001a\u00020\u000e2\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u00020r2\u0006\u0010W\u001a\u00020s2\u0006\u0010V\u001a\u00020sJ\u001e\u0010t\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020u2\u0006\u0010q\u001a\u00020r2\u0006\u0010v\u001a\u00020sJ\u0006\u0010w\u001a\u00020\u000eJ\u000e\u0010x\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020pJ\u001a\u0010y\u001a\u00020\u000e2\u0006\u0010z\u001a\u00020\u00002\n\b\u0002\u0010m\u001a\u0004\u0018\u00010iJ\u0010\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020|H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006~"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "Landroidx/compose/runtime/Changes;", "<init>", "()V", "operations", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "size", "", "getSize", "()I", "isEmpty", "", "hasChangesRequiringApplication", FasteningElement.ATTR_CLEAR, "", "execute", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "executeAndFlushAllPendingChanges", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "pushRemember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "pushRememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "pushStartResumingScope", "pushEndResumingScope", "pushUpdateRememberObserverHolderOrdering", "holder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "after", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "pushUpdateRelativeValue", "slotIndex", "", "pushUpdateValue", "groupSlotAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "pushAppendValue", "pushRemoveTailGroupsAndValues", "firstTailGroupToRemove", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "count", "pushResetSlots", "pushDeactivateGroup", "pushUpdateAuxData", "data", "pushRemoveGroup", "pushInsertSlots", "sourceTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "source", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "fixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "pushMoveGroup", "offset", "pushClearAllRecompositionRequiredGroups", "pushEndCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "pushUseNode", NodeElement.ELEMENT, "pushUpdateNode", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pushRemoveNode", "nodeIndex", "removeCount", "pushMoveNode", "to", "from", "pushSeekToGroupHandle", "handle", "pushSeekToAnchor", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "pushStartGroup", "pushSkipGroup", "pushUps", "pushDowns", "nodes", "", "([Ljava/lang/Object;)V", "pushSideEffect", "effect", "Lkotlin/Function0;", "pushDetermineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "groupHandle", "pushCopyNodesToNewAnchorLocation", "", "effectiveNodeIndex", "pushCopySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "pushReleaseMovableGroup", "Landroidx/compose/runtime/ControlledComposition;", ReferenceElement.ELEMENT, "pushEndMovableContentPlacement", "pushDisposeDisposeMovableContentState", "pushExecuteOperationsIn", "changeList", "toDebugString", "", "linePrefix", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChangeList extends Changes {
    public static final int $stable = 8;
    private final Operations operations = new Operations();

    public final int getSize() {
        return this.operations.getOpCodesSize();
    }

    @Override // androidx.compose.runtime.Changes
    public boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean hasChangesRequiringApplication() {
        return this.operations.getRequiresApplication();
    }

    @Override // androidx.compose.runtime.Changes
    public void clear() {
        this.operations.clear();
    }

    @Override // androidx.compose.runtime.Changes
    public void execute(SlotStorage slotStorage, Applier<?> applier, RememberManager rememberManager, CompositionErrorContextImpl errorContext) {
        SlotTableEditor slotTableEditorOpenEditor = SlotTableKt.asLinkBufferSlotTable(slotStorage).openEditor();
        try {
            executeAndFlushAllPendingChanges(applier, slotTableEditorOpenEditor, rememberManager, errorContext);
            Unit unit = Unit.INSTANCE;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    public final void executeAndFlushAllPendingChanges(Applier<?> applier, SlotTableEditor slots, RememberManager rememberManager, OperationErrorContext errorContext) {
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager, errorContext);
    }

    public final void pushRemember(RememberObserverHolder value) {
        Operations operations = this.operations;
        Operation.Remember remember = Operation.Remember.INSTANCE;
        operations.pushOp(remember);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.Remember remember2 = Operation.Remember.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), value);
        operations.ensureAllArgumentsPushedFor(remember);
    }

    public final void pushRememberPausingScope(RecomposeScopeImpl scope) {
        Operations operations = this.operations;
        Operation.RememberPausingScope rememberPausingScope = Operation.RememberPausingScope.INSTANCE;
        operations.pushOp(rememberPausingScope);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.RememberPausingScope rememberPausingScope2 = Operation.RememberPausingScope.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), scope);
        operations.ensureAllArgumentsPushedFor(rememberPausingScope);
    }

    public final void pushStartResumingScope(RecomposeScopeImpl scope) {
        Operations operations = this.operations;
        Operation.StartResumingScope startResumingScope = Operation.StartResumingScope.INSTANCE;
        operations.pushOp(startResumingScope);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.StartResumingScope startResumingScope2 = Operation.StartResumingScope.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), scope);
        operations.ensureAllArgumentsPushedFor(startResumingScope);
    }

    public final void pushEndResumingScope(RecomposeScopeImpl scope) {
        Operations operations = this.operations;
        Operation.EndResumingScope endResumingScope = Operation.EndResumingScope.INSTANCE;
        operations.pushOp(endResumingScope);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.EndResumingScope endResumingScope2 = Operation.EndResumingScope.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), scope);
        operations.ensureAllArgumentsPushedFor(endResumingScope);
    }

    public final void pushUpdateRememberObserverHolderOrdering(LinkRememberObserverHolder holder, LinkAnchor after) {
        Operations operations = this.operations;
        Operation.UpdateRememberObserverHolderOrdering updateRememberObserverHolderOrdering = Operation.UpdateRememberObserverHolderOrdering.INSTANCE;
        operations.pushOp(updateRememberObserverHolderOrdering);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateRememberObserverHolderOrdering updateRememberObserverHolderOrdering2 = Operation.UpdateRememberObserverHolderOrdering.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(1), holder);
        Operation.UpdateRememberObserverHolderOrdering updateRememberObserverHolderOrdering3 = Operation.UpdateRememberObserverHolderOrdering.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), after);
        operations.ensureAllArgumentsPushedFor(updateRememberObserverHolderOrdering);
    }

    public final void pushUpdateRelativeValue(int slotIndex, Object value) {
        Operations operations = this.operations;
        Operation.UpdateValueRelative updateValueRelative = Operation.UpdateValueRelative.INSTANCE;
        operations.pushOp(updateValueRelative);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateValueRelative updateValueRelative2 = Operation.UpdateValueRelative.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = slotIndex;
        Operation.UpdateValueRelative updateValueRelative3 = Operation.UpdateValueRelative.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), value);
        operations.ensureAllArgumentsPushedFor(updateValueRelative);
    }

    public final void pushUpdateValue(int groupSlotAddress, Object value) {
        Operations operations = this.operations;
        Operation.UpdateValue updateValue = Operation.UpdateValue.INSTANCE;
        operations.pushOp(updateValue);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateValue updateValue2 = Operation.UpdateValue.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), value);
        Operation.UpdateValue updateValue3 = Operation.UpdateValue.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = groupSlotAddress;
        operations.ensureAllArgumentsPushedFor(updateValue);
    }

    public final void pushAppendValue(Object value) {
        Operations operations = this.operations;
        Operation.AppendValue appendValue = Operation.AppendValue.INSTANCE;
        operations.pushOp(appendValue);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.AppendValue appendValue2 = Operation.AppendValue.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), value);
        operations.ensureAllArgumentsPushedFor(appendValue);
    }

    public final void pushRemoveTailGroupsAndValues(int firstTailGroupToRemove, int count) {
        Operations operations = this.operations;
        Operation.RemoveTailGroupsAndValues removeTailGroupsAndValues = Operation.RemoveTailGroupsAndValues.INSTANCE;
        operations.pushOp(removeTailGroupsAndValues);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.RemoveTailGroupsAndValues removeTailGroupsAndValues2 = Operation.RemoveTailGroupsAndValues.INSTANCE;
        Operation.RemoveTailGroupsAndValues removeTailGroupsAndValues3 = Operation.RemoveTailGroupsAndValues.INSTANCE;
        int ints = operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts();
        int[] iArr = operationsM5271constructorimpl.intArgs;
        iArr[ints] = firstTailGroupToRemove;
        iArr[ints + 1] = count;
        operations.ensureAllArgumentsPushedFor(removeTailGroupsAndValues);
    }

    public final void pushResetSlots() {
        this.operations.push(Operation.ResetSlots.INSTANCE);
    }

    public final void pushDeactivateGroup() {
        this.operations.push(Operation.DeactivateGroup.INSTANCE);
    }

    public final void pushUpdateAuxData(Object data) {
        Operations operations = this.operations;
        Operation.UpdateAuxData updateAuxData = Operation.UpdateAuxData.INSTANCE;
        operations.pushOp(updateAuxData);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateAuxData updateAuxData2 = Operation.UpdateAuxData.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), data);
        operations.ensureAllArgumentsPushedFor(updateAuxData);
    }

    public final void pushRemoveGroup() {
        this.operations.push(Operation.RemoveGroup.INSTANCE);
    }

    public final void pushInsertSlots(SlotTable sourceTable, long source) {
        Operations operations = this.operations;
        Operation.InsertSlots insertSlots = Operation.InsertSlots.INSTANCE;
        operations.pushOp(insertSlots);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.InsertSlots insertSlots2 = Operation.InsertSlots.INSTANCE;
        Operation.InsertSlots insertSlots3 = Operation.InsertSlots.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl, 0, 1, source);
        Operation.InsertSlots insertSlots4 = Operation.InsertSlots.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), sourceTable);
        operations.ensureAllArgumentsPushedFor(insertSlots);
    }

    public final void pushInsertSlots(SlotTable sourceTable, long source, FixupList fixups) {
        Operations operations = this.operations;
        Operation.InsertSlotsWithFixups insertSlotsWithFixups = Operation.InsertSlotsWithFixups.INSTANCE;
        operations.pushOp(insertSlotsWithFixups);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups2 = Operation.InsertSlotsWithFixups.INSTANCE;
        Operation.InsertSlotsWithFixups insertSlotsWithFixups3 = Operation.InsertSlotsWithFixups.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl, 0, 1, source);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups4 = Operation.InsertSlotsWithFixups.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
        Operation.InsertSlotsWithFixups insertSlotsWithFixups5 = Operation.InsertSlotsWithFixups.INSTANCE;
        Operations.WriteScope.m5282setObjectsEykTJF8(operationsM5271constructorimpl, iM5244constructorimpl, sourceTable, Operation.ObjectParameter.m5244constructorimpl(1), fixups);
        operations.ensureAllArgumentsPushedFor(insertSlotsWithFixups);
    }

    public final void pushMoveGroup(int offset) {
        Operations operations = this.operations;
        Operation.MoveGroup moveGroup = Operation.MoveGroup.INSTANCE;
        operations.pushOp(moveGroup);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.MoveGroup moveGroup2 = Operation.MoveGroup.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = offset;
        operations.ensureAllArgumentsPushedFor(moveGroup);
    }

    public final void pushClearAllRecompositionRequiredGroups() {
        this.operations.push(Operation.ClearAllRecompositionRequired.INSTANCE);
    }

    public final void pushEndCompositionScope(Function1<? super Composition, Unit> action, Composition composition) {
        Operations operations = this.operations;
        Operation.EndCompositionScope endCompositionScope = Operation.EndCompositionScope.INSTANCE;
        operations.pushOp(endCompositionScope);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.EndCompositionScope endCompositionScope2 = Operation.EndCompositionScope.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
        Operation.EndCompositionScope endCompositionScope3 = Operation.EndCompositionScope.INSTANCE;
        Operations.WriteScope.m5282setObjectsEykTJF8(operationsM5271constructorimpl, iM5244constructorimpl, action, Operation.ObjectParameter.m5244constructorimpl(1), composition);
        operations.ensureAllArgumentsPushedFor(endCompositionScope);
    }

    public final void pushUseNode(Object node) {
        if (node instanceof ComposeNodeLifecycleCallback) {
            this.operations.push(Operation.UseCurrentNode.INSTANCE);
        }
    }

    public final <T, V> void pushUpdateNode(V value, Function2<? super T, ? super V, Unit> block) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.UpdateNode updateNode2 = Operation.UpdateNode.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
        Operation.UpdateNode updateNode3 = Operation.UpdateNode.INSTANCE;
        int iM5244constructorimpl2 = Operation.ObjectParameter.m5244constructorimpl(1);
        Intrinsics.checkNotNull(block, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m5282setObjectsEykTJF8(operationsM5271constructorimpl, iM5244constructorimpl, value, iM5244constructorimpl2, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2));
        operations.ensureAllArgumentsPushedFor(updateNode);
    }

    public final void pushRemoveNode(int nodeIndex, int removeCount) {
        Operations operations = this.operations;
        Operation.RemoveNode removeNode = Operation.RemoveNode.INSTANCE;
        operations.pushOp(removeNode);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.RemoveNode removeNode2 = Operation.RemoveNode.INSTANCE;
        Operation.RemoveNode removeNode3 = Operation.RemoveNode.INSTANCE;
        int ints = operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts();
        int[] iArr = operationsM5271constructorimpl.intArgs;
        iArr[ints] = nodeIndex;
        iArr[ints + 1] = removeCount;
        operations.ensureAllArgumentsPushedFor(removeNode);
    }

    public final void pushMoveNode(int to, int from, int count) {
        Operations operations = this.operations;
        Operation.MoveNode moveNode = Operation.MoveNode.INSTANCE;
        operations.pushOp(moveNode);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.MoveNode moveNode2 = Operation.MoveNode.INSTANCE;
        Operation.MoveNode moveNode3 = Operation.MoveNode.INSTANCE;
        Operation.MoveNode moveNode4 = Operation.MoveNode.INSTANCE;
        int ints = operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts();
        int[] iArr = operationsM5271constructorimpl.intArgs;
        iArr[ints + 1] = to;
        iArr[ints] = from;
        iArr[ints + 2] = count;
        operations.ensureAllArgumentsPushedFor(moveNode);
    }

    public final void pushSeekToGroupHandle(long handle) {
        Operations operations = this.operations;
        Operation.SeekToGroupHandle seekToGroupHandle = Operation.SeekToGroupHandle.INSTANCE;
        operations.pushOp(seekToGroupHandle);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.SeekToGroupHandle seekToGroupHandle2 = Operation.SeekToGroupHandle.INSTANCE;
        Operation.SeekToGroupHandle seekToGroupHandle3 = Operation.SeekToGroupHandle.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl, 0, 1, handle);
        operations.ensureAllArgumentsPushedFor(seekToGroupHandle);
    }

    public final void pushSeekToAnchor(SlotTableAddressSpace addressSpace, long handle) {
        Operations operations = this.operations;
        Operation.SeekToAnchor seekToAnchor = Operation.SeekToAnchor.INSTANCE;
        operations.pushOp(seekToAnchor);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.SeekToAnchor seekToAnchor2 = Operation.SeekToAnchor.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), LinkAnchorKt.anchorHandle(addressSpace, handle));
        operations.ensureAllArgumentsPushedFor(seekToAnchor);
    }

    public final void pushStartGroup() {
        this.operations.push(Operation.StartGroup.INSTANCE);
    }

    public final void pushSkipGroup() {
        this.operations.push(Operation.SkipGroup.INSTANCE);
    }

    public final void pushUps(int count) {
        Operations operations = this.operations;
        Operation.Ups ups = Operation.Ups.INSTANCE;
        operations.pushOp(ups);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.Ups ups2 = Operation.Ups.INSTANCE;
        operationsM5271constructorimpl.intArgs[operationsM5271constructorimpl.intArgsSize - operationsM5271constructorimpl.opCodes[operationsM5271constructorimpl.opCodesSize - 1].getInts()] = count;
        operations.ensureAllArgumentsPushedFor(ups);
    }

    public final void pushDowns(Object[] nodes) {
        if (nodes.length == 0) {
            return;
        }
        Operations operations = this.operations;
        Operation.Downs downs = Operation.Downs.INSTANCE;
        operations.pushOp(downs);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.Downs downs2 = Operation.Downs.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), nodes);
        operations.ensureAllArgumentsPushedFor(downs);
    }

    public final void pushSideEffect(Function0<Unit> effect) {
        Operations operations = this.operations;
        Operation.SideEffect sideEffect = Operation.SideEffect.INSTANCE;
        operations.pushOp(sideEffect);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.SideEffect sideEffect2 = Operation.SideEffect.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), effect);
        operations.ensureAllArgumentsPushedFor(sideEffect);
    }

    public final void pushDetermineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, long groupHandle) {
        Operations operations = this.operations;
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        operations.pushOp(determineMovableContentNodeIndex);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex2 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), effectiveNodeIndexOut);
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex3 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex4 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        Operations.WriteScope.m5280setLongimpl(operationsM5271constructorimpl, 1, 0, groupHandle);
        operations.ensureAllArgumentsPushedFor(determineMovableContentNodeIndex);
    }

    public final void pushCopyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        if (nodes.isEmpty()) {
            return;
        }
        Operations operations = this.operations;
        Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
        operations.pushOp(copyNodesToNewAnchorLocation);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation2 = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(1);
        Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation3 = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
        Operations.WriteScope.m5282setObjectsEykTJF8(operationsM5271constructorimpl, iM5244constructorimpl, nodes, Operation.ObjectParameter.m5244constructorimpl(0), effectiveNodeIndex);
        operations.ensureAllArgumentsPushedFor(copyNodesToNewAnchorLocation);
    }

    public final void pushCopySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        Operations operations = this.operations;
        Operation.CopySlotTableToHandleLocation copySlotTableToHandleLocation = Operation.CopySlotTableToHandleLocation.INSTANCE;
        operations.pushOp(copySlotTableToHandleLocation);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.CopySlotTableToHandleLocation copySlotTableToHandleLocation2 = Operation.CopySlotTableToHandleLocation.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
        Operation.CopySlotTableToHandleLocation copySlotTableToHandleLocation3 = Operation.CopySlotTableToHandleLocation.INSTANCE;
        int iM5244constructorimpl2 = Operation.ObjectParameter.m5244constructorimpl(1);
        Operation.CopySlotTableToHandleLocation copySlotTableToHandleLocation4 = Operation.CopySlotTableToHandleLocation.INSTANCE;
        int iM5244constructorimpl3 = Operation.ObjectParameter.m5244constructorimpl(3);
        Operation.CopySlotTableToHandleLocation copySlotTableToHandleLocation5 = Operation.CopySlotTableToHandleLocation.INSTANCE;
        Operations.WriteScope.m5284setObjectsUOUgNZM(operationsM5271constructorimpl, iM5244constructorimpl, resolvedState, iM5244constructorimpl2, parentContext, iM5244constructorimpl3, to, Operation.ObjectParameter.m5244constructorimpl(2), from);
        operations.ensureAllArgumentsPushedFor(copySlotTableToHandleLocation);
    }

    public final void pushReleaseMovableGroup(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference) {
        Operations operations = this.operations;
        Operation.ReleaseMovableGroup releaseMovableGroup = Operation.ReleaseMovableGroup.INSTANCE;
        operations.pushOp(releaseMovableGroup);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.ReleaseMovableGroup releaseMovableGroup2 = Operation.ReleaseMovableGroup.INSTANCE;
        int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
        Operation.ReleaseMovableGroup releaseMovableGroup3 = Operation.ReleaseMovableGroup.INSTANCE;
        int iM5244constructorimpl2 = Operation.ObjectParameter.m5244constructorimpl(1);
        Operation.ReleaseMovableGroup releaseMovableGroup4 = Operation.ReleaseMovableGroup.INSTANCE;
        Operations.WriteScope.m5283setObjectsGn0XI2A(operationsM5271constructorimpl, iM5244constructorimpl, composition, iM5244constructorimpl2, parentContext, Operation.ObjectParameter.m5244constructorimpl(2), reference);
        operations.ensureAllArgumentsPushedFor(releaseMovableGroup);
    }

    public final void pushEndMovableContentPlacement() {
        this.operations.push(Operation.EndMovableContentPlacement.INSTANCE);
    }

    public final void pushDisposeDisposeMovableContentState(MovableContentState resolvedState) {
        Operations operations = this.operations;
        Operation.DisposeMovableContentState disposeMovableContentState = Operation.DisposeMovableContentState.INSTANCE;
        operations.pushOp(disposeMovableContentState);
        Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
        Operation.DisposeMovableContentState disposeMovableContentState2 = Operation.DisposeMovableContentState.INSTANCE;
        Operations.WriteScope.m5281setObjectaWHcuVo(operationsM5271constructorimpl, Operation.ObjectParameter.m5244constructorimpl(0), resolvedState);
        operations.ensureAllArgumentsPushedFor(disposeMovableContentState);
    }

    public static /* synthetic */ void pushExecuteOperationsIn$default(ChangeList changeList, ChangeList changeList2, IntRef intRef, int i, Object obj) {
        if ((i & 2) != 0) {
            intRef = null;
        }
        changeList.pushExecuteOperationsIn(changeList2, intRef);
    }

    public final void pushExecuteOperationsIn(ChangeList changeList, IntRef effectiveNodeIndex) {
        if (changeList.isNotEmpty()) {
            Operations operations = this.operations;
            Operation.ApplyChangeList applyChangeList = Operation.ApplyChangeList.INSTANCE;
            operations.pushOp(applyChangeList);
            Operations operationsM5271constructorimpl = Operations.WriteScope.m5271constructorimpl(operations);
            Operation.ApplyChangeList applyChangeList2 = Operation.ApplyChangeList.INSTANCE;
            int iM5244constructorimpl = Operation.ObjectParameter.m5244constructorimpl(0);
            Operation.ApplyChangeList applyChangeList3 = Operation.ApplyChangeList.INSTANCE;
            Operations.WriteScope.m5282setObjectsEykTJF8(operationsM5271constructorimpl, iM5244constructorimpl, changeList, Operation.ObjectParameter.m5244constructorimpl(1), effectiveNodeIndex);
            if (changeList.operations.getRequiresApplication()) {
                Operations.WriteScope.m5276requireApplicationimpl(operationsM5271constructorimpl);
            }
            operations.ensureAllArgumentsPushedFor(applyChangeList);
        }
    }

    @Override // androidx.compose.runtime.composer.DebugStringFormattable
    public String toDebugString(String linePrefix) {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeList instance containing ");
        sb.append(getSize());
        sb.append(" operations");
        if (sb.length() > 0) {
            sb.append(":\n");
            sb.append(this.operations.toDebugString(linePrefix));
        }
        return sb.toString();
    }
}
