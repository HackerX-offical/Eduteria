package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextContextMenuGesturesModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode$tryShowContextMenu$1", f = "TextContextMenuGesturesModifier.kt", i = {}, l = {107, 108}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextContextMenuGestureNode$tryShowContextMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuGestureNode.ClickTextContextMenuDataProvider $dataProvider;
    final /* synthetic */ long $localClickOffset;
    final /* synthetic */ TextContextMenuProvider $provider;
    int label;
    final /* synthetic */ TextContextMenuGestureNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextContextMenuGestureNode$tryShowContextMenu$1(TextContextMenuGestureNode textContextMenuGestureNode, long j, TextContextMenuProvider textContextMenuProvider, TextContextMenuGestureNode.ClickTextContextMenuDataProvider clickTextContextMenuDataProvider, Continuation<? super TextContextMenuGestureNode$tryShowContextMenu$1> continuation) {
        super(2, continuation);
        this.this$0 = textContextMenuGestureNode;
        this.$localClickOffset = j;
        this.$provider = textContextMenuProvider;
        this.$dataProvider = clickTextContextMenuDataProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextContextMenuGestureNode$tryShowContextMenu$1(this.this$0, this.$localClickOffset, this.$provider, this.$dataProvider, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextContextMenuGestureNode$tryShowContextMenu$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r6.$provider.showTextContextMenu(r6.$dataProvider, r6) == r0) goto L17;
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
            goto L4a
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L38
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode r7 = r6.this$0
            kotlin.jvm.functions.Function2 r7 = androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode.access$getOnPreShowContextMenu$p(r7)
            if (r7 == 0) goto L38
            long r4 = r6.$localClickOffset
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m5712boximpl(r4)
            r6.label = r3
            java.lang.Object r7 = r7.invoke(r1, r6)
            if (r7 != r0) goto L38
            goto L49
        L38:
            androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider r7 = r6.$provider
            androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode$ClickTextContextMenuDataProvider r1 = r6.$dataProvider
            androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider r1 = (androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r7 = r7.showTextContextMenu(r1, r3)
            if (r7 != r0) goto L4a
        L49:
            return r0
        L4a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode$tryShowContextMenu$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
