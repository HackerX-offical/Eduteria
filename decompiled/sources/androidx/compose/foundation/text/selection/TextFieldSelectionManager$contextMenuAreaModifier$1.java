package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "clickLocation", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$1", f = "TextFieldSelectionManager.kt", i = {0}, l = {228, 230}, m = "invokeSuspend", n = {"clickLocation"}, s = {"J$0"}, v = 1)
final class TextFieldSelectionManager$contextMenuAreaModifier$1 extends SuspendLambda implements Function2<Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$contextMenuAreaModifier$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$contextMenuAreaModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextFieldSelectionManager$contextMenuAreaModifier$1 textFieldSelectionManager$contextMenuAreaModifier$1 = new TextFieldSelectionManager$contextMenuAreaModifier$1(this.this$0, continuation);
        textFieldSelectionManager$contextMenuAreaModifier$1.J$0 = ((Offset) obj).m5733unboximpl();
        return textFieldSelectionManager$contextMenuAreaModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Unit> continuation) {
        return m2376invoke3MmeM6k(offset.m5733unboximpl(), continuation);
    }

    /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m2376invoke3MmeM6k(long j, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$contextMenuAreaModifier$1) create(Offset.m5712boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r6.mo2282onShowContextMenu_2OEclM(r5, r8, r10, r12) == r0) goto L20;
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L67
        L12:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1a:
            long r3 = r12.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L36
        L20:
            kotlin.ResultKt.throwOnFailure(r13)
            long r4 = r12.J$0
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r13 = r12.this$0
            r1 = r12
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r12.J$0 = r4
            r12.label = r3
            java.lang.Object r13 = r13.updateClipboardEntry$foundation(r1)
            if (r13 != r0) goto L35
            goto L66
        L35:
            r3 = r4
        L36:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r13 = r12.this$0
            kotlin.Pair r13 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getContextTextAndSelection(r13)
            if (r13 == 0) goto L67
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = r12.this$0
            java.lang.Object r5 = r13.component1()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r13 = r13.component2()
            androidx.compose.ui.text.TextRange r13 = (androidx.compose.ui.text.TextRange) r13
            long r8 = r13.getPackedValue()
            androidx.compose.foundation.text.selection.PlatformSelectionBehaviors r6 = r1.getPlatformSelectionBehaviors()
            if (r6 == 0) goto L67
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m5712boximpl(r3)
            r12.label = r2
            r11 = r12
            java.lang.Object r13 = r6.mo2282onShowContextMenu_2OEclM(r7, r8, r10, r11)
            if (r13 != r0) goto L67
        L66:
            return r0
        L67:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
