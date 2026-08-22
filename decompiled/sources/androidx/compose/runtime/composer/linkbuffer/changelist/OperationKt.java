package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.InvalidationResult;
import androidx.compose.runtime.MovableContent;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.ScopeInvalidated;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilder;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0002\u001a,\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\r\u001a\u00060\nj\u0002`\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0010H\u0002\u001a4\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002\u001a5\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\n\u0010\u001c\u001a\u00060\nj\u0002`\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0082\b\u001a*\u0010\u001f\u001a\u00020 *\u00020 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006!"}, d2 = {"IntParameter", "", "positionToParentOf", "", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "applier", "Landroidx/compose/runtime/Applier;", "", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "positionToInsert", "destination", "nodeIndex", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "releaseMovableGroup", "composition", "Landroidx/compose/runtime/ControlledComposition;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", ReferenceElement.ELEMENT, "Landroidx/compose/runtime/MovableContentStateReference;", "withCurrentStackTrace", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "editor", "location", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "attachComposeStackTrace", "", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OperationKt {
    private static final void positionToParentOf(SlotTableEditor slotTableEditor, Applier<Object> applier, long j) {
        if (slotTableEditor.getParent() >= 0) {
            MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
            SlotTable table = slotTableEditor.getTable();
            int iParentOf = slotTableEditor.parentOf(GroupHandleKt.getGroup(j));
            int[] groups = table.getAddressSpace().getGroups();
            int i = iParentOf;
            while (i > 0) {
                mutableIntSetMutableIntSetOf.add(i);
                i = groups[i + 2];
            }
            if (!(i != 0)) {
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + iParentOf);
            }
            while (slotTableEditor.getParent() >= 0 && !mutableIntSetMutableIntSetOf.contains(slotTableEditor.getParent())) {
                if (slotTableEditor.isParentGroupANode()) {
                    applier.up();
                }
                slotTableEditor.endGroup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int positionToInsert(SlotTableEditor slotTableEditor, long j, Applier<Object> applier) {
        positionToParentOf(slotTableEditor, applier, j);
        int parent = slotTableEditor.getParent();
        int group = GroupHandleKt.getGroup(j);
        IntStack intStack = new IntStack();
        int[] groups = slotTableEditor.getTable().getAddressSpace().getGroups();
        int i = group;
        while (true) {
            if (i <= 0) {
                if (!(i != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                }
            } else {
                if (i == parent) {
                    break;
                }
                intStack.push(i);
                i = groups[i + 2];
            }
        }
        if (!(slotTableEditor.getParent() == parent)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure when inserting movable content");
        }
        int current = slotTableEditor.getCurrent();
        int iSkipGroup = 0;
        boolean z = false;
        while (slotTableEditor.getCurrent() != group) {
            if (intStack.tos != 0 && slotTableEditor.getCurrent() == intStack.peek()) {
                if (slotTableEditor.isNode()) {
                    applier.down(slotTableEditor.getNode());
                    z = true;
                    iSkipGroup = 0;
                }
                slotTableEditor.startGroup();
                intStack.pop();
            } else {
                iSkipGroup += slotTableEditor.skipGroup();
            }
        }
        return iSkipGroup + (z ? 0 : nodeIndex(slotTableEditor, current));
    }

    private static final int nodeIndex(SlotTableEditor slotTableEditor, int i) {
        int iFirstChildOf;
        if (i < 0) {
            return 0;
        }
        SlotTable table = slotTableEditor.getTable();
        int[] groups = table.getAddressSpace().getGroups();
        int i2 = i;
        int i3 = i2;
        int iNodeCountOf = 0;
        while (true) {
            if (i2 <= 0) {
                if (!(i2 != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
                }
            } else {
                if (slotTableEditor.isNode(i2)) {
                    break;
                }
                int iParentOf = slotTableEditor.parentOf(i2);
                if (iParentOf < 0) {
                    iFirstChildOf = table.getRoot();
                } else {
                    iFirstChildOf = slotTableEditor.firstChildOf(iParentOf);
                }
                int[] groups2 = table.getAddressSpace().getGroups();
                while (iFirstChildOf >= 0 && iFirstChildOf != i3) {
                    iNodeCountOf += slotTableEditor.nodeCountOf(iFirstChildOf);
                    iFirstChildOf = groups2[iFirstChildOf + 1];
                }
                i2 = groups[i2 + 2];
                i3 = iParentOf;
            }
        }
        return iNodeCountOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseMovableGroup(final ControlledComposition controlledComposition, CompositionContext compositionContext, final MovableContentStateReference movableContentStateReference, SlotTableEditor slotTableEditor, Applier<?> applier) {
        SlotTable table = slotTableEditor.getTable();
        SlotTable.Companion companion = SlotTable.INSTANCE;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(table.getAddressSpace(), false, false);
        slotTableBuilder.buildStart();
        MovableContent<Object> content$runtime = movableContentStateReference.getContent$runtime();
        slotTableBuilder.startNewGroup(MovableContentKt.movableContentKey, content$runtime == Composer.INSTANCE.getEmpty() ? 0 : 16777216, content$runtime, null, null);
        slotTableBuilder.addFlags(268435456);
        slotTableBuilder.append(movableContentStateReference.getParameter());
        slotTableBuilder.moveFrom(slotTableEditor, (((long) 0) << 32) | (((long) UInt.m12488constructorimpl(slotTableEditor.getTable().getAddressSpace().getGroups()[LinkAnchorKt.asLinkAnchor(movableContentStateReference.getAnchor()).getAddress() + 3])) & 4294967295L));
        slotTableBuilder.endGroup();
        SlotTable slotTableBuild = slotTableBuilder.build();
        MovableContentState movableContentState = new MovableContentState(slotTableBuild);
        if (slotTableBuild.hasRecomposeScopes(slotTableBuild.getRoot())) {
            SlotTableKt.adoptScopesInGroupToNewParent(slotTableBuild, slotTableBuild.getRoot(), new RecomposeScopeOwner() { // from class: androidx.compose.runtime.composer.linkbuffer.changelist.OperationKt$releaseMovableGroup$movableContentRecomposeScopeOwner$1
                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void recomposeScopeReleased(RecomposeScopeImpl scope) {
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void recordReadOf(Object value) {
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
                    InvalidationResult invalidationResultInvalidate;
                    ControlledComposition controlledComposition2 = controlledComposition;
                    RecomposeScopeOwner recomposeScopeOwner = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                    if (recomposeScopeOwner == null || (invalidationResultInvalidate = recomposeScopeOwner.invalidate(scope, instance)) == null) {
                        invalidationResultInvalidate = InvalidationResult.IGNORED;
                    }
                    if (invalidationResultInvalidate != InvalidationResult.IGNORED) {
                        return invalidationResultInvalidate;
                    }
                    MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                    List<Pair<RecomposeScopeImpl, Object>> invalidations$runtime = movableContentStateReference2.getInvalidations$runtime();
                    if (instance == null) {
                        instance = ScopeInvalidated.INSTANCE;
                    }
                    movableContentStateReference2.setInvalidations$runtime(CollectionsKt.plus((Collection<? extends Pair>) invalidations$runtime, TuplesKt.to(scope, instance)));
                    return InvalidationResult.SCHEDULED;
                }
            });
        }
        compositionContext.movableContentStateReleased$runtime(movableContentStateReference, movableContentState, applier);
    }

    private static final void withCurrentStackTrace(OperationErrorContext operationErrorContext, SlotTableEditor slotTableEditor, long j, Function0<Unit> function0) throws Throwable {
        try {
            function0.invoke();
        } catch (Throwable th) {
            throw attachComposeStackTrace(th, operationErrorContext, slotTableEditor, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable attachComposeStackTrace(Throwable th, final OperationErrorContext operationErrorContext, final SlotTableEditor slotTableEditor, final long j) {
        return operationErrorContext == null ? th : ComposeStackTraceKt.attachComposeStackTrace(th, new Function0() { // from class: androidx.compose.runtime.composer.linkbuffer.changelist.OperationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OperationKt.attachComposeStackTrace$lambda$0(j, slotTableEditor, operationErrorContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComposeStackTrace attachComposeStackTrace$lambda$0(long j, SlotTableEditor slotTableEditor, OperationErrorContext operationErrorContext) {
        if (j != -1) {
            slotTableEditor.seek(j);
        }
        List listBuildTrace$default = SlotTableEditorKt.buildTrace$default(slotTableEditor, null, 0, 3, null);
        ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) CollectionsKt.lastOrNull(listBuildTrace$default);
        Integer groupOffset = composeStackTraceFrame != null ? composeStackTraceFrame.getGroupOffset() : null;
        List<ComposeStackTraceFrame> listBuildStackTrace = operationErrorContext.buildStackTrace(groupOffset);
        if (groupOffset != null && !listBuildStackTrace.isEmpty()) {
            listBuildStackTrace = CollectionsKt.plus((Collection) CollectionsKt.listOf(ComposeStackTraceFrame.copy$default((ComposeStackTraceFrame) CollectionsKt.first((List) listBuildStackTrace), 0, null, groupOffset, 3, null)), (Iterable) CollectionsKt.drop(listBuildStackTrace, 1));
        }
        return new ComposeStackTrace(CollectionsKt.plus((Collection) listBuildTrace$default, (Iterable) listBuildStackTrace), operationErrorContext.getSourceInformationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OperationErrorContext withCurrentStackTrace(final OperationErrorContext operationErrorContext, final SlotTableEditor slotTableEditor) {
        return new OperationErrorContext() { // from class: androidx.compose.runtime.composer.linkbuffer.changelist.OperationKt.withCurrentStackTrace.1
            @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
            public List<ComposeStackTraceFrame> buildStackTrace(Integer currentOffset) {
                List<ComposeStackTraceFrame> listBuildStackTrace = operationErrorContext.buildStackTrace(null);
                int parent = slotTableEditor.getParent();
                return parent < 0 ? listBuildStackTrace : CollectionsKt.plus((Collection) SlotTableEditorKt.buildTrace(slotTableEditor, currentOffset, parent), (Iterable) listBuildStackTrace);
            }

            @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
            public boolean getSourceInformationEnabled() {
                return operationErrorContext.getSourceInformationEnabled();
            }
        };
    }
}
