package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CommonContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "clickLocation", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1", f = "CommonContextMenuArea.kt", i = {0}, l = {82, 83}, m = "invokeSuspend", n = {"clickLocation"}, s = {"J$0"}, v = 1)
final class CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 extends SuspendLambda implements Function2<Offset, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    /* synthetic */ long J$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1> continuation) {
        super(2, continuation);
        this.$selectionState = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 = new CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(this.$selectionState, continuation);
        commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1.J$0 = ((Offset) obj).m5733unboximpl();
        return commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Unit> continuation) {
        return m1677invoke3MmeM6k(offset.m5733unboximpl(), continuation);
    }

    /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m1677invoke3MmeM6k(long j, Continuation<? super Unit> continuation) {
        return ((CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1) create(Offset.m5712boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        if (r5.mo2282onShowContextMenu_2OEclM(r11.$selectionState.getTextFieldState().getVisualText().getText(), r11.$selectionState.getTextFieldState().getVisualText().getSelection(), androidx.compose.ui.geometry.Offset.m5712boximpl(r3), r11) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6a
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            long r3 = r11.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L36
        L20:
            kotlin.ResultKt.throwOnFailure(r12)
            long r4 = r11.J$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r11.$selectionState
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.J$0 = r4
            r11.label = r3
            java.lang.Object r12 = r12.updateClipboardEntry(r1)
            if (r12 != r0) goto L35
            goto L69
        L35:
            r3 = r4
        L36:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r11.$selectionState
            androidx.compose.foundation.text.selection.PlatformSelectionBehaviors r5 = r12.getPlatformSelectionBehaviors()
            if (r5 == 0) goto L6a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r11.$selectionState
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r12 = r12.getTextFieldState()
            androidx.compose.foundation.text.input.TextFieldCharSequence r12 = r12.getVisualText()
            java.lang.CharSequence r6 = r12.getText()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r12 = r11.$selectionState
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r12 = r12.getTextFieldState()
            androidx.compose.foundation.text.input.TextFieldCharSequence r12 = r12.getVisualText()
            long r7 = r12.getSelection()
            androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m5712boximpl(r3)
            r10 = r11
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11.label = r2
            java.lang.Object r12 = r5.mo2282onShowContextMenu_2OEclM(r6, r7, r9, r10)
            if (r12 != r0) goto L6a
        L69:
            return r0
        L6a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
