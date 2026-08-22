package androidx.compose.foundation.text.input.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CursorAnimationState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "animate", "", "<init>", "(Z)V", "getAnimate", "()Z", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "snapToVisibleAndAnimate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelAndHide", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CursorAnimationState {
    public static final int $stable = 8;
    private final boolean animate;
    private AtomicReference<Job> animationJob = new AtomicReference<>(null);

    /* JADX INFO: renamed from: cursorAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState cursorAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    public CursorAnimationState(boolean z) {
        this.animate = z;
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCursorAlpha(float f2) {
        this.cursorAlpha.setFloatValue(f2);
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha.getFloatValue();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2, reason: invalid class name */
    /* JADX INFO: compiled from: CursorAnimationState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = CursorAnimationState.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(CursorAnimationState.this.animationJob, null, BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1((Job) CursorAnimationState.this.animationJob.getAndSet(null), CursorAnimationState.this, null), 3, null)));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CursorAnimationState.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {72, 77, 79, 81}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $oldJob;
            int label;
            final /* synthetic */ CursorAnimationState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Job job, CursorAnimationState cursorAnimationState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$oldJob = job;
                this.this$0 = cursorAnimationState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$oldJob, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
            
                if (kotlinx.coroutines.DelayKt.delay(500, r10) != r0) goto L36;
             */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:8:0x0019, B:36:0x0082, B:30:0x0065, B:33:0x0071, B:12:0x0025, B:13:0x0029, B:28:0x005f, B:29:0x0064, B:23:0x0046, B:25:0x0053), top: B:40:0x000f }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x007f -> B:36:0x0082). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r10.label
                    r2 = 500(0x1f4, double:2.47E-321)
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 0
                    r6 = 4
                    r7 = 3
                    r8 = 2
                    r9 = 1
                    if (r1 == 0) goto L33
                    if (r1 == r9) goto L2f
                    if (r1 == r8) goto L29
                    if (r1 == r7) goto L25
                    if (r1 != r6) goto L1d
                    kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2d
                    goto L82
                L1d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L25:
                    kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2d
                    goto L71
                L29:
                    kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2d
                    goto L5f
                L2d:
                    r11 = move-exception
                    goto L88
                L2f:
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L46
                L33:
                    kotlin.ResultKt.throwOnFailure(r11)
                    kotlinx.coroutines.Job r11 = r10.$oldJob
                    if (r11 == 0) goto L46
                    r1 = r10
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r10.label = r9
                    java.lang.Object r11 = kotlinx.coroutines.JobKt.cancelAndJoin(r11, r1)
                    if (r11 != r0) goto L46
                    goto L81
                L46:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2d
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r4)     // Catch: java.lang.Throwable -> L2d
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2d
                    boolean r11 = r11.getAnimate()     // Catch: java.lang.Throwable -> L2d
                    if (r11 != 0) goto L65
                    r11 = r10
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2d
                    r10.label = r8     // Catch: java.lang.Throwable -> L2d
                    java.lang.Object r11 = kotlinx.coroutines.DelayKt.awaitCancellation(r11)     // Catch: java.lang.Throwable -> L2d
                    if (r11 != r0) goto L5f
                    goto L81
                L5f:
                    kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L2d
                    r11.<init>()     // Catch: java.lang.Throwable -> L2d
                    throw r11     // Catch: java.lang.Throwable -> L2d
                L65:
                    r11 = r10
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2d
                    r10.label = r7     // Catch: java.lang.Throwable -> L2d
                    java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r2, r11)     // Catch: java.lang.Throwable -> L2d
                    if (r11 != r0) goto L71
                    goto L81
                L71:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2d
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r5)     // Catch: java.lang.Throwable -> L2d
                    r11 = r10
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2d
                    r10.label = r6     // Catch: java.lang.Throwable -> L2d
                    java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r2, r11)     // Catch: java.lang.Throwable -> L2d
                    if (r11 != r0) goto L82
                L81:
                    return r0
                L82:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2d
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r4)     // Catch: java.lang.Throwable -> L2d
                    goto L65
                L88:
                    androidx.compose.foundation.text.input.internal.CursorAnimationState r0 = r10.this$0
                    androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r0, r5)
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2(null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final void cancelAndHide() {
        Job andSet = this.animationJob.getAndSet(null);
        if (andSet != null) {
            Job.DefaultImpls.cancel$default(andSet, (CancellationException) null, 1, (Object) null);
        }
    }
}
