package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: NonTouchScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u001f\u001a\u00020\u000b*\u00020\u001cH\u0000¢\u0006\u0002\b J9\u0010&\u001a\u00020\u000b2'\u0010'\u001a#\b\u0001\u0012\u0004\u0012\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b)H\u0080@¢\u0006\u0004\b*\u0010+J'\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:H&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RA\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0084\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010,\u001a\u00020-X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006;"}, d2 = {"Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "getOnScrollStopped", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "updateDensity", "isConsumed", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isConsumed$foundation", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "consume", "consume$foundation", "isScrolling", "isScrolling$foundation", "()Z", "setScrolling$foundation", "(Z)V", "userScroll", BlockContactsIQ.ELEMENT, "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/ExtensionFunctionType;", "userScroll$foundation", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocityTracker", "Landroidx/compose/foundation/gestures/DifferentialVelocityTracker;", "getVelocityTracker$foundation", "()Landroidx/compose/foundation/gestures/DifferentialVelocityTracker;", "onPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NonTouchScrollingLogic {
    public static final int $stable = 8;
    private Density density;
    private boolean isScrolling;
    private final Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped;
    private final ScrollingLogic scrollingLogic;
    private final DifferentialVelocityTracker velocityTracker = new DifferentialVelocityTracker();

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public abstract void mo627onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds);

    public abstract void startReceivingEvents(CoroutineScope coroutineScope);

    /* JADX WARN: Multi-variable type inference failed */
    public NonTouchScrollingLogic(ScrollingLogic scrollingLogic, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        this.scrollingLogic = scrollingLogic;
        this.onScrollStopped = function2;
        this.density = density;
    }

    protected final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    protected final Function2<Velocity, Continuation<? super Unit>, Object> getOnScrollStopped() {
        return this.onScrollStopped;
    }

    protected final Density getDensity() {
        return this.density;
    }

    protected final void setDensity(Density density) {
        this.density = density;
    }

    public final void updateDensity(Density density) {
        this.density = density;
    }

    public final boolean isConsumed$foundation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).isConsumed()) {
                return true;
            }
        }
        return false;
    }

    public final void consume$foundation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            changes.get(i).consume();
        }
    }

    /* JADX INFO: renamed from: isScrolling$foundation, reason: from getter */
    public final boolean getIsScrolling() {
        return this.isScrolling;
    }

    public final void setScrolling$foundation(boolean z) {
        this.isScrolling = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object userScroll$foundation(kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.NestedScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1 r0 = (androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1 r0 = new androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r4.isScrolling = r3
            androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$2 r6 = new androidx.compose.foundation.gestures.NonTouchScrollingLogic$userScroll$2
            r2 = 0
            r6.<init>(r4, r5, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.SupervisorKt.supervisorScope(r6, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            r5 = 0
            r4.isScrolling = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.NonTouchScrollingLogic.userScroll$foundation(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: getVelocityTracker$foundation, reason: from getter */
    public final DifferentialVelocityTracker getVelocityTracker() {
        return this.velocityTracker;
    }
}
