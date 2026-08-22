package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\fH\u0080\b¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u000e\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u00142\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0015\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"getCompositionService", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Composition;", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/Composition;Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "pausable", "R", "Landroidx/compose/runtime/ControlledComposition;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Composition", "applier", "Landroidx/compose/runtime/Applier;", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroidx/compose/runtime/CompositionContext;", "ReusableComposition", "Landroidx/compose/runtime/ReusableComposition;", "ControlledComposition", "PendingApplyNoModifications", "", "ObservableCompositionServiceKey", "Landroidx/compose/runtime/tooling/ObservableComposition;", "getObservableCompositionServiceKey$annotations", "()V", "getObservableCompositionServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", DebugCoroutineInfoImplKt.RUNNING, "", "DEACTIVATED", "INCONSISTENT", "DISPOSED", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CompositionKt {
    private static final int DEACTIVATED = 1;
    private static final int DISPOSED = 3;
    private static final int INCONSISTENT = 2;
    private static final int RUNNING = 0;
    private static final Object PendingApplyNoModifications = new Object();
    private static final CompositionServiceKey<ObservableComposition> ObservableCompositionServiceKey = new CompositionServiceKey<ObservableComposition>() { // from class: androidx.compose.runtime.CompositionKt$ObservableCompositionServiceKey$1
    };

    public static /* synthetic */ void getObservableCompositionServiceKey$annotations() {
    }

    public static final <T> T getCompositionService(Composition composition, CompositionServiceKey<T> compositionServiceKey) {
        CompositionServices compositionServices = composition instanceof CompositionServices ? (CompositionServices) composition : null;
        if (compositionServices != null) {
            return (T) compositionServices.getCompositionService(compositionServiceKey);
        }
        return null;
    }

    public static final <R> R pausable(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, Function0<? extends R> function0) {
        ShouldPauseCallback andSetShouldPauseCallback = controlledComposition.getAndSetShouldPauseCallback(shouldPauseCallback);
        try {
            return function0.invoke();
        } finally {
            controlledComposition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
        }
    }

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier);
    }

    public static final ReusableComposition ReusableComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier);
    }

    public static final CompositionServiceKey<ObservableComposition> getObservableCompositionServiceKey() {
        return ObservableCompositionServiceKey;
    }
}
