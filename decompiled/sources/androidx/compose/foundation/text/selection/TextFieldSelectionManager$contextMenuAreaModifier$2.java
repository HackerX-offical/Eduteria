package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$2", f = "TextFieldSelectionManager.kt", i = {}, l = {241, 243}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextFieldSelectionManager$contextMenuAreaModifier$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$contextMenuAreaModifier$2(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$contextMenuAreaModifier$2> continuation) {
        super(1, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TextFieldSelectionManager$contextMenuAreaModifier$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$contextMenuAreaModifier$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r8.mo2283onShowSelectionToolbarSbBc2M(r4, r5, r7) == r0) goto L19;
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L2f
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r8 = r7.this$0
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r3
            java.lang.Object r8 = r8.updateClipboardEntry$foundation(r1)
            if (r8 != r0) goto L2f
            goto L59
        L2f:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r8 = r7.this$0
            kotlin.Pair r8 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getContextTextAndSelection(r8)
            if (r8 == 0) goto L5a
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = r7.this$0
            java.lang.Object r4 = r8.component1()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r8.component2()
            androidx.compose.ui.text.TextRange r8 = (androidx.compose.ui.text.TextRange) r8
            long r5 = r8.getPackedValue()
            androidx.compose.foundation.text.selection.PlatformSelectionBehaviors r8 = r1.getPlatformSelectionBehaviors()
            if (r8 == 0) goto L5a
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7.label = r2
            java.lang.Object r8 = r8.mo2283onShowSelectionToolbarSbBc2M(r4, r5, r7)
            if (r8 != r0) goto L5a
        L59:
            return r0
        L5a:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r8 = r7.this$0
            r8.setTextToolbarShownViaProvider$foundation(r3)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
