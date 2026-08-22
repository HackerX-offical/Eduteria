package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteractionStart$3$1", f = "Clickable.kt", i = {}, l = {2112, 2113}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AbstractClickableNode$handlePressInteractionStart$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $indirectPointer;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ PressInteraction.Press $press;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteractionStart$3$1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, boolean z, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteractionStart$3$1> continuation) {
        super(2, continuation);
        this.$interactionSource = mutableInteractionSource;
        this.$press = press;
        this.$indirectPointer = z;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteractionStart$3$1(this.$interactionSource, this.$press, this.$indirectPointer, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteractionStart$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r6.$interactionSource.emit(r6.$press, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L43
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L31
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            long r4 = androidx.compose.foundation.Clickable_androidKt.getTapIndicationDelay()
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L31
            goto L42
        L31:
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r6.$interactionSource
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = r6.$press
            androidx.compose.foundation.interaction.Interaction r1 = (androidx.compose.foundation.interaction.Interaction) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r7 = r7.emit(r1, r3)
            if (r7 != r0) goto L43
        L42:
            return r0
        L43:
            boolean r7 = r6.$indirectPointer
            if (r7 == 0) goto L4f
            androidx.compose.foundation.AbstractClickableNode r7 = r6.this$0
            androidx.compose.foundation.interaction.PressInteraction$Press r0 = r6.$press
            androidx.compose.foundation.AbstractClickableNode.access$setIndirectPointerPressInteraction$p(r7, r0)
            goto L56
        L4f:
            androidx.compose.foundation.AbstractClickableNode r7 = r6.this$0
            androidx.compose.foundation.interaction.PressInteraction$Press r0 = r6.$press
            androidx.compose.foundation.AbstractClickableNode.access$setPressInteraction$p(r7, r0)
        L56:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode$handlePressInteractionStart$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
