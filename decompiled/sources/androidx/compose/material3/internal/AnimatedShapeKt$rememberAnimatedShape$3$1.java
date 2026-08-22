package androidx.compose.material3.internal;

import androidx.compose.foundation.shape.RoundedCornerShape;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: AnimatedShape.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1", f = "AnimatedShape.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
final class AnimatedShapeKt$rememberAnimatedShape$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<RoundedCornerShape> $channel;
    final /* synthetic */ AnimatedShapeState $state;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedShapeKt$rememberAnimatedShape$3$1(Channel<RoundedCornerShape> channel, AnimatedShapeState animatedShapeState, Continuation<? super AnimatedShapeKt$rememberAnimatedShape$3$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$state = animatedShapeState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimatedShapeKt$rememberAnimatedShape$3$1 animatedShapeKt$rememberAnimatedShape$3$1 = new AnimatedShapeKt$rememberAnimatedShape$3$1(this.$channel, this.$state, continuation);
        animatedShapeKt$rememberAnimatedShape$3$1.L$0 = obj;
        return animatedShapeKt$rememberAnimatedShape$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimatedShapeKt$rememberAnimatedShape$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003a -> B:12:0x003d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r9.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3d
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.shape.RoundedCornerShape> r1 = r9.$channel
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r3 = r10
        L2d:
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r9.L$0 = r3
            r9.L$1 = r1
            r9.label = r2
            java.lang.Object r10 = r1.hasNext(r10)
            if (r10 != r0) goto L3d
            return r0
        L3d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L6e
            java.lang.Object r10 = r1.next()
            androidx.compose.foundation.shape.RoundedCornerShape r10 = (androidx.compose.foundation.shape.RoundedCornerShape) r10
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.shape.RoundedCornerShape> r4 = r9.$channel
            java.lang.Object r4 = r4.mo13903tryReceivePtdJZtk()
            java.lang.Object r4 = kotlinx.coroutines.channels.ChannelResult.m13915getOrNullimpl(r4)
            androidx.compose.foundation.shape.RoundedCornerShape r4 = (androidx.compose.foundation.shape.RoundedCornerShape) r4
            if (r4 != 0) goto L5a
            goto L5b
        L5a:
            r10 = r4
        L5b:
            androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1$1 r4 = new androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1$1
            androidx.compose.material3.internal.AnimatedShapeState r5 = r9.$state
            r6 = 0
            r4.<init>(r5, r10, r6)
            r6 = r4
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
            goto L2d
        L6e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedShape.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$3$1$1", f = "AnimatedShape.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RoundedCornerShape $newTarget;
        final /* synthetic */ AnimatedShapeState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnimatedShapeState animatedShapeState, RoundedCornerShape roundedCornerShape, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = animatedShapeState;
            this.$newTarget = roundedCornerShape;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$newTarget, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$state.animateToShape(this.$newTarget, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
