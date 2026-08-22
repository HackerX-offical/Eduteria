package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: UpdatableAnimationState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006JJ\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastFrameTime", "", "lastVelocity", "isRunning", "", "value", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdatableAnimationState {

    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdatableAnimationState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.UpdatableAnimationState", f = "UpdatableAnimationState.kt", i = {0, 0, 0, 1}, l = {100, 151}, m = "animateToZero", n = {"beforeFrame", "afterFrame", "durationScale", "afterFrame"}, s = {"L$0", "L$1", "F$0", "L$0"}, v = 1)
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
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f2) {
        this.value = f2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r14, r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a A[Catch: all -> 0x004e, PHI: r12 r13 r14
      0x007a: PHI (r12v4 float) = (r12v2 float), (r12v5 float) binds: [B:29:0x0074, B:36:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x007a: PHI (r13v6 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>) = 
      (r13v2 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
      (r13v7 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
     binds: [B:29:0x0074, B:36:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x007a: PHI (r14v16 kotlin.jvm.functions.Function0<kotlin.Unit>) = (r14v8 kotlin.jvm.functions.Function0<kotlin.Unit>), (r14v17 kotlin.jvm.functions.Function0<kotlin.Unit>) binds: [B:29:0x0074, B:36:0x009d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x004e, blocks: (B:13:0x0031, B:43:0x00be, B:18:0x0048, B:35:0x0098, B:30:0x007a, B:32:0x0084, B:37:0x009f, B:40:0x00ab), top: B:48:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:13:0x0031, B:43:0x00be, B:18:0x0048, B:35:0x0098, B:30:0x007a, B:32:0x0084, B:37:0x009f, B:40:0x00ab), top: B:48:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f A[Catch: all -> 0x004e, PHI: r13 r14
      0x009f: PHI (r13v3 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>) = 
      (r13v6 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
      (r13v7 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
     binds: [B:31:0x0082, B:36:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x009f: PHI (r14v11 kotlin.jvm.functions.Function0<kotlin.Unit>) = (r14v16 kotlin.jvm.functions.Function0<kotlin.Unit>), (r14v17 kotlin.jvm.functions.Function0<kotlin.Unit>) binds: [B:31:0x0082, B:36:0x009d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x004e, blocks: (B:13:0x0031, B:43:0x00be, B:18:0x0048, B:35:0x0098, B:30:0x007a, B:32:0x0084, B:37:0x009f, B:40:0x00ab), top: B:48:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0095 -> B:35:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToZero(kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r12, kotlin.jvm.functions.Function0<kotlin.Unit> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateToZero$lambda$1(UpdatableAnimationState updatableAnimationState, float f2, Function1 function1, long j) {
        long jRoundToLong;
        if (updatableAnimationState.lastFrameTime == Long.MIN_VALUE) {
            updatableAnimationState.lastFrameTime = j;
        }
        AnimationVector1D animationVector1D = new AnimationVector1D(updatableAnimationState.value);
        if (f2 == 0.0f) {
            jRoundToLong = updatableAnimationState.vectorizedSpec.getDurationNanos(new AnimationVector1D(updatableAnimationState.value), ZeroVector, updatableAnimationState.lastVelocity);
        } else {
            jRoundToLong = MathKt.roundToLong((j - updatableAnimationState.lastFrameTime) / f2);
        }
        long j2 = jRoundToLong;
        VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec = updatableAnimationState.vectorizedSpec;
        AnimationVector1D animationVector1D2 = animationVector1D;
        AnimationVector1D animationVector1D3 = ZeroVector;
        float value = ((AnimationVector1D) vectorizedAnimationSpec.getValueFromNanos(j2, animationVector1D2, animationVector1D3, updatableAnimationState.lastVelocity)).getValue();
        updatableAnimationState.lastVelocity = (AnimationVector1D) updatableAnimationState.vectorizedSpec.getVelocityFromNanos(j2, animationVector1D2, animationVector1D3, updatableAnimationState.lastVelocity);
        updatableAnimationState.lastFrameTime = j;
        float f3 = updatableAnimationState.value - value;
        updatableAnimationState.value = value;
        function1.invoke(Float.valueOf(f3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateToZero$lambda$2(UpdatableAnimationState updatableAnimationState, Function1 function1, long j) {
        float f2 = updatableAnimationState.value;
        updatableAnimationState.value = 0.0f;
        function1.invoke(Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: UpdatableAnimationState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "<init>", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f2) {
            return Math.abs(f2) < 0.01f;
        }
    }
}
