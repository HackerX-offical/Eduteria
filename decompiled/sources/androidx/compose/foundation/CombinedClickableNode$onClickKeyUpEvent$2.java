package androidx.compose.foundation;

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
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2", f = "Clickable.kt", i = {0, 0}, l = {1628, 1632}, m = "invokeSuspend", n = {"minTime", "timeout"}, s = {"J$0", "J$1"}, v = 1)
final class CombinedClickableNode$onClickKeyUpEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $keyCode;
    long J$0;
    long J$1;
    int label;
    final /* synthetic */ CombinedClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombinedClickableNode$onClickKeyUpEvent$2(CombinedClickableNode combinedClickableNode, long j, Continuation<? super CombinedClickableNode$onClickKeyUpEvent$2> continuation) {
        super(2, continuation);
        this.this$0 = combinedClickableNode;
        this.$keyCode = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CombinedClickableNode$onClickKeyUpEvent$2(this.this$0, this.$keyCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombinedClickableNode$onClickKeyUpEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4 - r6, r10) == r0) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6d
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1a:
            long r4 = r10.J$1
            long r6 = r10.J$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L4d
        L22:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.CombinedClickableNode r11 = r10.this$0
            androidx.compose.ui.node.CompositionLocalConsumerModifierNode r11 = (androidx.compose.ui.node.CompositionLocalConsumerModifierNode) r11
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            java.lang.Object r11 = androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt.currentValueOf(r11, r1)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            long r6 = r11.getDoubleTapMinTimeMillis()
            long r4 = r11.getDoubleTapTimeoutMillis()
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.J$0 = r6
            r10.J$1 = r4
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r11)
            if (r11 != r0) goto L4d
            goto L6c
        L4d:
            androidx.compose.foundation.CombinedClickableNode r11 = r10.this$0
            androidx.collection.MutableLongObjectMap r11 = androidx.compose.foundation.CombinedClickableNode.access$getDoubleKeyClickStates$p(r11)
            long r8 = r10.$keyCode
            java.lang.Object r11 = r11.get(r8)
            androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState r11 = (androidx.compose.foundation.CombinedClickableNode.DoubleKeyClickState) r11
            if (r11 == 0) goto L60
            r11.setDoubleTapMinTimeMillisElapsed(r3)
        L60:
            long r4 = r4 - r6
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.label = r2
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r4, r11)
            if (r11 != r0) goto L6d
        L6c:
            return r0
        L6d:
            androidx.compose.foundation.CombinedClickableNode r11 = r10.this$0
            kotlin.jvm.functions.Function0 r11 = r11.getOnClick()
            r11.invoke()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
