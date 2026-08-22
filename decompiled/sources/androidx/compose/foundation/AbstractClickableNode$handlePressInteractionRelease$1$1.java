package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1", f = "Clickable.kt", i = {1}, l = {2157, 2162, 2163}, m = "invokeSuspend", n = {"release"}, s = {"L$0"}, v = 1)
final class AbstractClickableNode$handlePressInteractionRelease$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Job $job;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteractionRelease$1$1(Job job, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AbstractClickableNode$handlePressInteractionRelease$1$1> continuation) {
        super(2, continuation);
        this.$job = job;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteractionRelease$1$1(this.$job, this.$offset, this.$interactionSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteractionRelease$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r7.$interactionSource.emit(r1, r7) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2a
            if (r1 == r5) goto L26
            if (r1 == r4) goto L1e
            if (r1 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6b
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            java.lang.Object r1 = r7.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r1 = (androidx.compose.foundation.interaction.PressInteraction.Release) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3b
        L2a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.Job r8 = r7.$job
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r5
            java.lang.Object r8 = r8.join(r1)
            if (r8 != r0) goto L3b
            goto L6a
        L3b:
            androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r5 = r7.$offset
            r8.<init>(r5, r2)
            androidx.compose.foundation.interaction.PressInteraction$Release r1 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r1.<init>(r8)
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r7.$interactionSource
            androidx.compose.foundation.interaction.Interaction r8 = (androidx.compose.foundation.interaction.Interaction) r8
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r5.emit(r8, r6)
            if (r8 != r0) goto L59
            goto L6a
        L59:
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r7.$interactionSource
            androidx.compose.foundation.interaction.Interaction r1 = (androidx.compose.foundation.interaction.Interaction) r1
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r8 = r8.emit(r1, r4)
            if (r8 != r0) goto L6b
        L6a:
            return r0
        L6b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
