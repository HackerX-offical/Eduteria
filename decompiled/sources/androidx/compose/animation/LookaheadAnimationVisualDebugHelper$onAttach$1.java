package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LookaheadAnimationVisualDebugHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.LookaheadAnimationVisualDebugHelper$onAttach$1", f = "LookaheadAnimationVisualDebugHelper.kt", i = {}, l = {101, 102}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LookaheadAnimationVisualDebugHelper$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LookaheadAnimationVisualDebugHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LookaheadAnimationVisualDebugHelper$onAttach$1(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper, Continuation<? super LookaheadAnimationVisualDebugHelper$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = lookaheadAnimationVisualDebugHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LookaheadAnimationVisualDebugHelper$onAttach$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LookaheadAnimationVisualDebugHelper$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.this$0.reverseProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(androidx.compose.animation.core.AnimationSpecKt.tween$default(500, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, null), androidx.compose.animation.core.RepeatMode.Reverse, 0, 4, null), null, null, r12, 12, null) == r0) goto L15;
     */
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
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L1e
            if (r1 == r2) goto L1a
            if (r1 != r3) goto L12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L70
        L12:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L38
        L1e:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.compose.animation.LookaheadAnimationVisualDebugHelper r13 = r12.this$0
            androidx.compose.animation.core.Animatable r13 = androidx.compose.animation.LookaheadAnimationVisualDebugHelper.access$getReverseProgress$p(r13)
            r1 = 0
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r12.label = r2
            java.lang.Object r13 = r13.snapTo(r1, r4)
            if (r13 != r0) goto L38
            goto L6f
        L38:
            androidx.compose.animation.LookaheadAnimationVisualDebugHelper r13 = r12.this$0
            androidx.compose.animation.core.Animatable r4 = androidx.compose.animation.LookaheadAnimationVisualDebugHelper.access$getReverseProgress$p(r13)
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.compose.animation.core.Easing r13 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r1 = 0
            r2 = 500(0x1f4, float:7.0E-43)
            r6 = 0
            androidx.compose.animation.core.TweenSpec r13 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r6, r13, r3, r1)
            r6 = r13
            androidx.compose.animation.core.DurationBasedAnimationSpec r6 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r6
            androidx.compose.animation.core.RepeatMode r7 = androidx.compose.animation.core.RepeatMode.Reverse
            r10 = 4
            r11 = 0
            r8 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r13 = androidx.compose.animation.core.AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(r6, r7, r8, r10, r11)
            r6 = r13
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.label = r3
            r7 = 0
            r8 = 0
            r10 = 12
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L70
        L6f:
            return r0
        L70:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.LookaheadAnimationVisualDebugHelper$onAttach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
