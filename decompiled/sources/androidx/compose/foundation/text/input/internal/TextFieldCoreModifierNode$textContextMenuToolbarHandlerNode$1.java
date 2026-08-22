package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextFieldCoreModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1", f = "TextFieldCoreModifier.kt", i = {}, l = {209, 210}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1> continuation) {
        super(1, continuation);
        this.this$0 = textFieldCoreModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r8.mo2283onShowSelectionToolbarSbBc2M(r7.this$0.textFieldSelectionState.getTextFieldState().getVisualText().getText(), r7.this$0.textFieldSelectionState.getTextFieldState().getVisualText().getSelection(), r7) == r0) goto L17;
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
            goto L6b
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L33
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r8 = r7.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(r8)
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r3
            java.lang.Object r8 = r8.updateClipboardEntry(r1)
            if (r8 != r0) goto L33
            goto L6a
        L33:
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r8 = r7.this$0
            androidx.compose.foundation.text.selection.PlatformSelectionBehaviors r8 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getPlatformSelectionBehaviors$p(r8)
            if (r8 == 0) goto L6b
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r1 = r7.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(r1)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r1 = r1.getTextFieldState()
            androidx.compose.foundation.text.input.TextFieldCharSequence r1 = r1.getVisualText()
            java.lang.CharSequence r1 = r1.getText()
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r4 = r7.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r4 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(r4)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r4 = r4.getTextFieldState()
            androidx.compose.foundation.text.input.TextFieldCharSequence r4 = r4.getVisualText()
            long r4 = r4.getSelection()
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r2
            java.lang.Object r8 = r8.mo2283onShowSelectionToolbarSbBc2M(r1, r4, r6)
            if (r8 != r0) goto L6b
        L6a:
            return r0
        L6b:
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r8 = r7.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextFieldSelectionState$p(r8)
            r8.setTextToolbarShown$foundation(r3)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
