package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableRememberObserverHolder;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SlotTableEditor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"removeGroupAndForgetSlots", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateGroup", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "child", "", "group", "", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotTableEditorKt {
    public static final void removeGroupAndForgetSlots(SlotTableEditor slotTableEditor, final RememberManager rememberManager) {
        slotTableEditor.visitSlotsInRememberOrder(slotTableEditor.getCurrent(), new SlotTableEditor.VisitSlotsInRememberOrderCallback() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableEditorKt$$ExternalSyntheticLambda1
            @Override // androidx.compose.runtime.composer.linkbuffer.SlotTableEditor.VisitSlotsInRememberOrderCallback
            public final boolean visit(int i, int i2, Object obj) {
                return SlotTableEditorKt.removeGroupAndForgetSlots$lambda$0(rememberManager, i, i2, obj);
            }
        });
        SlotTableEditor.removeGroup$default(slotTableEditor, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeGroupAndForgetSlots$lambda$0(RememberManager rememberManager, int i, int i2, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.releasing((ComposeNodeLifecycleCallback) obj);
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            return false;
        }
        ((RecomposeScopeImpl) obj).release();
        return false;
    }

    public static final void deactivateGroup(final SlotTableEditor slotTableEditor, final RememberManager rememberManager) {
        slotTableEditor.visitSlotsInRememberOrder(slotTableEditor.getCurrent(), new SlotTableEditor.VisitSlotsInRememberOrderCallback() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableEditorKt$$ExternalSyntheticLambda0
            @Override // androidx.compose.runtime.composer.linkbuffer.SlotTableEditor.VisitSlotsInRememberOrderCallback
            public final boolean visit(int i, int i2, Object obj) {
                return SlotTableEditorKt.deactivateGroup$lambda$0(slotTableEditor, rememberManager, i, i2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deactivateGroup$lambda$0(SlotTableEditor slotTableEditor, RememberManager rememberManager, int i, int i2, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            slotTableEditor.flagsOf(i);
            if (i2 != 0) {
                return false;
            }
            rememberManager.deactivating((ComposeNodeLifecycleCallback) obj);
            return false;
        }
        if (obj instanceof ReusableRememberObserverHolder) {
            return false;
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
            return true;
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            return false;
        }
        ((RecomposeScopeImpl) obj).release();
        return true;
    }

    public static /* synthetic */ List buildTrace$default(SlotTableEditor slotTableEditor, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if ((i2 & 2) != 0) {
            i = slotTableEditor.getCurrent();
        }
        return buildTrace(slotTableEditor, obj, i);
    }

    public static final List<ComposeStackTraceFrame> buildTrace(SlotTableEditor slotTableEditor, Object obj, int i) {
        if (!slotTableEditor.getIsClosed() && !slotTableEditor.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(slotTableEditor.getTable().getAddressSpace(), i, obj, new EditorTraceBuilder(slotTableEditor));
        }
        return CollectionsKt.emptyList();
    }
}
