package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001ABR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00121\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u001f\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u0004\u0018\u00010\u001e*\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001b\u0010)\u001a\u00020%*\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001eH\u0002J*\u0010/\u001a\u00020\r*\u00020\u00032\u0006\u0010*\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0082@¢\u0006\u0002\u00103JY\u00104\u001a\u00020\r*\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020%0=H\u0082@¢\u0006\u0002\u0010?J\u0014\u0010/\u001a\u000201*\u0002052\u0006\u0010@\u001a\u000201H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "receivingMouseWheelEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onMouseWheel", "", "onMouseWheel-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "sumOrNull", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "trackVelocity", "dispatchMouseWheelScroll", "threshold", "", TransferTable.COLUMN_SPEED, "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateMouseWheelScroll", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "animationState", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "targetValue", "durationMillis", "", "shouldCancelAnimation", "Lkotlin/Function1;", "lastValue", "(Landroidx/compose/foundation/gestures/NestedScrollScope;Landroidx/compose/animation/core/AnimationState;FILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "MouseWheelScrollDelta", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MouseWheelScrollingLogic extends NonTouchScrollingLogic {
    public static final int $stable = 8;
    private final Channel<MouseWheelScrollDelta> channel;
    private final ScrollConfig mouseWheelScrollConfig;
    private Job receivingMouseWheelEventsJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic", f = "MouseWheelScrollingLogic.kt", i = {0, 0, 0}, l = {219, 273}, m = "dispatchMouseWheelScroll", n = {"$this$dispatchMouseWheelScroll", "targetValue", TransferTable.COLUMN_SPEED}, s = {"L$0", "L$1", "F$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MouseWheelScrollingLogic.this.dispatchMouseWheelScroll(null, null, 0.0f, 0.0f, this);
        }
    }

    public MouseWheelScrollingLogic(ScrollingLogic scrollingLogic, ScrollConfig scrollConfig, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        super(scrollingLogic, function2, density);
        this.mouseWheelScrollConfig = scrollConfig;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo627onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7267getScroll7fucELk())) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (changes.get(i).isConsumed()) {
                    return;
                }
            }
            if (pass == PointerEventPass.Initial && getIsScrolling()) {
                m626onMouseWheelO0kMr_c(pointerEvent, bounds);
                consume$foundation(pointerEvent);
            }
            if (pass == PointerEventPass.Main && !getIsScrolling() && m626onMouseWheelO0kMr_c(pointerEvent, bounds)) {
                consume$foundation(pointerEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "shouldApplyImmediately", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "getShouldApplyImmediately", "()Z", "plus", "other", "component1", "component1-F1C5BW0", "component2", "component3", Constants.COPY_TYPE, "copy-9KIMszo", "(JJZ)Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "equals", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class MouseWheelScrollDelta {
        private final boolean shouldApplyImmediately;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ MouseWheelScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        /* JADX INFO: renamed from: copy-9KIMszo$default, reason: not valid java name */
        public static /* synthetic */ MouseWheelScrollDelta m628copy9KIMszo$default(MouseWheelScrollDelta mouseWheelScrollDelta, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = mouseWheelScrollDelta.value;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = mouseWheelScrollDelta.timeMillis;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                z = mouseWheelScrollDelta.shouldApplyImmediately;
            }
            return mouseWheelScrollDelta.m630copy9KIMszo(j3, j4, z);
        }

        /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        /* JADX INFO: renamed from: copy-9KIMszo, reason: not valid java name */
        public final MouseWheelScrollDelta m630copy9KIMszo(long value, long timeMillis, boolean shouldApplyImmediately) {
            return new MouseWheelScrollDelta(value, timeMillis, shouldApplyImmediately, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) other;
            return Offset.m5720equalsimpl0(this.value, mouseWheelScrollDelta.value) && this.timeMillis == mouseWheelScrollDelta.timeMillis && this.shouldApplyImmediately == mouseWheelScrollDelta.shouldApplyImmediately;
        }

        public int hashCode() {
            return (((Offset.m5725hashCodeimpl(this.value) * 31) + Long.hashCode(this.timeMillis)) * 31) + Boolean.hashCode(this.shouldApplyImmediately);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) Offset.m5731toStringimpl(this.value)) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }

        private MouseWheelScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.shouldApplyImmediately = z;
        }

        /* JADX INFO: renamed from: getValue-F1C5BW0, reason: not valid java name */
        public final long m631getValueF1C5BW0() {
            return this.value;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta other) {
            return new MouseWheelScrollDelta(Offset.m5728plusMKHz9U(this.value, other.value), Math.max(this.timeMillis, other.timeMillis), this.shouldApplyImmediately, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    public void startReceivingEvents(CoroutineScope coroutineScope) {
        if (this.receivingMouseWheelEventsJob == null) {
            this.receivingMouseWheelEventsJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C02941(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingEvents$1", f = "MouseWheelScrollingLogic.kt", i = {0, 1}, l = {109, 112}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
    static final class C02941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C02941(Continuation<? super C02941> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02941 c02941 = MouseWheelScrollingLogic.this.new C02941(continuation);
            c02941.L$0 = obj;
            return c02941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
        
            if (r5.dispatchMouseWheelScroll(r5.getScrollingLogic(), r7, r8, r9, r12) != r0) goto L8;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:7:0x0013, B:17:0x0032, B:19:0x003c, B:23:0x0053, B:12:0x0024), top: B:30:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:8:0x0016). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r1 = r12.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L28
            L16:
                r13 = r1
                goto L32
            L18:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L20:
                java.lang.Object r1 = r12.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L28
                goto L53
            L28:
                r0 = move-exception
                r13 = r0
                goto L8e
            L2b:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            L32:
                kotlin.coroutines.CoroutineContext r1 = r13.getCoroutineContext()     // Catch: java.lang.Throwable -> L28
                boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)     // Catch: java.lang.Throwable -> L28
                if (r1 == 0) goto L86
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r1 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this     // Catch: java.lang.Throwable -> L28
                kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$getChannel$p(r1)     // Catch: java.lang.Throwable -> L28
                r5 = r12
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L28
                r12.L$0 = r13     // Catch: java.lang.Throwable -> L28
                r12.label = r4     // Catch: java.lang.Throwable -> L28
                java.lang.Object r1 = r1.receive(r5)     // Catch: java.lang.Throwable -> L28
                if (r1 != r0) goto L50
                goto L85
            L50:
                r11 = r1
                r1 = r13
                r13 = r11
            L53:
                r7 = r13
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta r7 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta) r7     // Catch: java.lang.Throwable -> L28
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this     // Catch: java.lang.Throwable -> L28
                androidx.compose.ui.unit.Density r13 = r13.getDensity()     // Catch: java.lang.Throwable -> L28
                float r5 = androidx.compose.foundation.gestures.MouseWheelScrollingLogicKt.access$getAnimationThreshold$p()     // Catch: java.lang.Throwable -> L28
                float r8 = r13.mo488toPx0680j_4(r5)     // Catch: java.lang.Throwable -> L28
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this     // Catch: java.lang.Throwable -> L28
                androidx.compose.ui.unit.Density r13 = r13.getDensity()     // Catch: java.lang.Throwable -> L28
                float r5 = androidx.compose.foundation.gestures.MouseWheelScrollingLogicKt.access$getAnimationSpeed$p()     // Catch: java.lang.Throwable -> L28
                float r9 = r13.mo488toPx0680j_4(r5)     // Catch: java.lang.Throwable -> L28
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r5 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this     // Catch: java.lang.Throwable -> L28
                androidx.compose.foundation.gestures.ScrollingLogic r6 = r5.getScrollingLogic()     // Catch: java.lang.Throwable -> L28
                r10 = r12
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> L28
                r12.L$0 = r1     // Catch: java.lang.Throwable -> L28
                r12.label = r3     // Catch: java.lang.Throwable -> L28
                java.lang.Object r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L28
                if (r13 != r0) goto L16
            L85:
                return r0
            L86:
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r13, r2)
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L8e:
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic r0 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.this
                androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r0, r2)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.C02941.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: onMouseWheel-O0kMr_c, reason: not valid java name */
    private final boolean m626onMouseWheelO0kMr_c(PointerEvent pointerEvent, long bounds) {
        long jMo517calculateMouseWheelScroll8xgXZGE = this.mouseWheelScrollConfig.mo517calculateMouseWheelScroll8xgXZGE(getDensity(), pointerEvent, bounds);
        if (m625canConsumeDeltaUv8p0NA(getScrollingLogic(), jMo517calculateMouseWheelScroll8xgXZGE)) {
            return ChannelResult.m13920isSuccessimpl(this.channel.mo13895trySendJP2dKIU(new MouseWheelScrollDelta(jMo517calculateMouseWheelScroll8xgXZGE, ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getUptimeMillis(), !this.mouseWheelScrollConfig.isSmoothScrollingEnabled() || this.mouseWheelScrollConfig.isPreciseWheelScroll(pointerEvent), null)));
        }
        return getIsScrolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MouseWheelScrollDelta sumOrNull(final Channel<MouseWheelScrollDelta> channel) {
        MouseWheelScrollDelta mouseWheelScrollDeltaPlus = null;
        for (MouseWheelScrollDelta mouseWheelScrollDelta : NonTouchScrollingLogicKt.untilNull(new Function0() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MouseWheelScrollingLogic.sumOrNull$lambda$0(channel);
            }
        })) {
            mouseWheelScrollDeltaPlus = mouseWheelScrollDeltaPlus == null ? mouseWheelScrollDelta : mouseWheelScrollDeltaPlus.plus(mouseWheelScrollDelta);
        }
        return mouseWheelScrollDeltaPlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MouseWheelScrollDelta sumOrNull$lambda$0(Channel channel) {
        return (MouseWheelScrollDelta) ChannelResult.m13915getOrNullimpl(channel.mo13903tryReceivePtdJZtk());
    }

    /* JADX INFO: renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m625canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        float fM697toSingleAxisDeltaFromAnglek4lQ0M = scrollingLogic.m697toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m693reverseIfNeededMKHz9U(j));
        if (fM697toSingleAxisDeltaFromAnglek4lQ0M == 0.0f) {
            return false;
        }
        if (fM697toSingleAxisDeltaFromAnglek4lQ0M > 0.0f) {
            return scrollingLogic.getScrollableState().getCanScrollForward();
        }
        return scrollingLogic.getScrollableState().getCanScrollBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(MouseWheelScrollDelta scrollDelta) {
        getVelocityTracker().m543addDeltaUv8p0NA(scrollDelta.getTimeMillis(), scrollDelta.m631getValueF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010f, code lost:
    
        if (r0.invoke(r1, r9) == r10) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, androidx.compose.animation.core.AnimationState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object dispatchMouseWheelScroll(androidx.compose.foundation.gestures.ScrollingLogic r23, androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta r24, float r25, float r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.dispatchMouseWheelScroll(androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object dispatchMouseWheelScroll$waitNextScrollDelta(androidx.compose.foundation.gestures.MouseWheelScrollingLogic r21, kotlin.jvm.internal.Ref.ObjectRef<androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta> r22, kotlin.jvm.internal.Ref.FloatRef r23, androidx.compose.foundation.gestures.ScrollingLogic r24, kotlin.jvm.internal.Ref.ObjectRef<androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r25, long r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(androidx.compose.foundation.gestures.MouseWheelScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$FloatRef, androidx.compose.foundation.gestures.ScrollingLogic, kotlin.jvm.internal.Ref$ObjectRef, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3, reason: invalid class name */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollingLogic.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {228, 241, 261}, m = "invokeSuspend", n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
        final /* synthetic */ float $speed;
        final /* synthetic */ Ref.ObjectRef<MouseWheelScrollDelta> $targetScrollDelta;
        final /* synthetic */ Ref.FloatRef $targetValue;
        final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
        final /* synthetic */ float $threshold;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.FloatRef floatRef, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef, Ref.ObjectRef<MouseWheelScrollDelta> objectRef2, float f2, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f3, ScrollingLogic scrollingLogic, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$targetValue = floatRef;
            this.$animationState = objectRef;
            this.$targetScrollDelta = objectRef2;
            this.$threshold = f2;
            this.this$0 = mouseWheelScrollingLogic;
            this.$speed = f3;
            this.$this_dispatchMouseWheelScroll = scrollingLogic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[PHI: r8 r14
          0x0066: PHI (r8v2 androidx.compose.foundation.gestures.NestedScrollScope) = 
          (r8v1 androidx.compose.foundation.gestures.NestedScrollScope)
          (r8v3 androidx.compose.foundation.gestures.NestedScrollScope)
         binds: [B:26:0x012c, B:13:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x0066: PHI (r14v1 kotlin.jvm.internal.Ref$BooleanRef) = (r14v0 kotlin.jvm.internal.Ref$BooleanRef), (r14v2 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:26:0x012c, B:13:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x019a  */
        /* JADX WARN: Type inference failed for: r2v16, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x012c -> B:14:0x0066). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0158 -> B:31:0x0159). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 413
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
        public static final boolean invokeSuspend$lambda$0(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref.ObjectRef objectRef, Ref.FloatRef floatRef, ScrollingLogic scrollingLogic, Ref.BooleanRef booleanRef, float f2) {
            MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = mouseWheelScrollingLogic.sumOrNull(mouseWheelScrollingLogic.channel);
            if (mouseWheelScrollDeltaSumOrNull != null) {
                mouseWheelScrollingLogic.trackVelocity(mouseWheelScrollDeltaSumOrNull);
                objectRef.element = ((MouseWheelScrollDelta) objectRef.element).plus(mouseWheelScrollDeltaSumOrNull);
                floatRef.element = scrollingLogic.m697toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m693reverseIfNeededMKHz9U(((MouseWheelScrollDelta) objectRef.element).m631getValueF1C5BW0()));
                booleanRef.element = !MouseWheelScrollingLogicKt.isLowScrollingDelta(floatRef.element - f2);
            }
            return mouseWheelScrollDeltaSumOrNull != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateMouseWheelScroll(final NestedScrollScope nestedScrollScope, AnimationState<Float, AnimationVector1D> animationState, float f2, int i, final Function1<? super Float, Boolean> function1, Continuation<? super Unit> continuation) {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = animationState.getValue().floatValue();
        Object objAnimateTo = SuspendAnimationKt.animateTo(animationState, Boxing.boxFloat(f2), AnimationSpecKt.tween$default(i, 0, EasingKt.getLinearEasing(), 2, null), true, new Function1() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MouseWheelScrollingLogic.animateMouseWheelScroll$lambda$0(floatRef, this, nestedScrollScope, function1, (AnimationScope) obj);
            }
        }, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateMouseWheelScroll$lambda$0(Ref.FloatRef floatRef, MouseWheelScrollingLogic mouseWheelScrollingLogic, NestedScrollScope nestedScrollScope, Function1 function1, AnimationScope animationScope) {
        float fFloatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        if (!MouseWheelScrollingLogicKt.isLowScrollingDelta(fFloatValue)) {
            if (!MouseWheelScrollingLogicKt.isLowScrollingDelta(fFloatValue - mouseWheelScrollingLogic.dispatchMouseWheelScroll(nestedScrollScope, fFloatValue))) {
                animationScope.cancelAnimation();
                return Unit.INSTANCE;
            }
            floatRef.element += fFloatValue;
        }
        if (((Boolean) function1.invoke(Float.valueOf(floatRef.element))).booleanValue()) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchMouseWheelScroll(NestedScrollScope nestedScrollScope, float f2) {
        ScrollingLogic scrollingLogic = getScrollingLogic();
        return scrollingLogic.m695toFloatk4lQ0M(scrollingLogic.m693reverseIfNeededMKHz9U(nestedScrollScope.mo632scrollByOzD1aCk(scrollingLogic.m696toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f2)), NestedScrollSource.INSTANCE.m7181getUserInputWNlRxjI())));
    }
}
