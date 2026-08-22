package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"androidx/compose/foundation/text/BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "showTextToolbar", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideTextToolbar", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 implements TextToolbarHandler {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ TextToolbar $currentTextToolbar;

    BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(TextToolbar textToolbar, CoroutineScope coroutineScope) {
        this.$currentTextToolbar = textToolbar;
        this.$coroutineScope = coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object showTextToolbar(final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r9, androidx.compose.ui.geometry.Rect r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 r0 = (androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r9 = r0.L$3
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r9 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r9
            java.lang.Object r10 = r0.L$2
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r1 = r0.L$1
            androidx.compose.ui.platform.TextToolbar r1 = (androidx.compose.ui.platform.TextToolbar) r1
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.geometry.Rect r0 = (androidx.compose.ui.geometry.Rect) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r1
            r1 = r0
            r0 = r7
            goto L60
        L3d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L45:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.ui.platform.TextToolbar r11 = r8.$currentTextToolbar
            kotlinx.coroutines.CoroutineScope r2 = r8.$coroutineScope
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r0 = r9.updateClipboardEntry(r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r1 = r10
            r0 = r11
            r10 = r2
        L60:
            boolean r11 = r9.canShowCopyMenuItem()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            r3 = 0
            if (r11 != 0) goto L6b
            r2 = r3
            goto L73
        L6b:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$1 r11 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$1
            r11.<init>()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r2 = r11
        L73:
            boolean r11 = r9.canShowPasteMenuItem()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r4 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r11 != 0) goto L7d
            r11 = r3
            goto L84
        L7d:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$2 r11 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$2
            r11.<init>()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
        L84:
            boolean r4 = r9.canShowCutMenuItem()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r5 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r4 != 0) goto L8e
            r4 = r3
            goto L95
        L8e:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$3 r4 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$3
            r4.<init>()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
        L95:
            boolean r10 = r9.canShowSelectAllMenuItem()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r5 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Selection
            if (r10 != 0) goto L9f
            r5 = r3
            goto La7
        L9f:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$4 r10 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$4
            r10.<init>()
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r5 = r10
        La7:
            boolean r10 = r9.canShowAutofillMenuItem()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r6 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r10 != 0) goto Lb0
            goto Lb8
        Lb0:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$5 r10 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$0$$inlined$menuItem$5
            r10.<init>()
            r3 = r10
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
        Lb8:
            r6 = r3
            r3 = r11
            r0.showMenu(r1, r2, r3, r4, r5, r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1.showTextToolbar(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public void hideTextToolbar() {
        if (this.$currentTextToolbar.getStatus() == TextToolbarStatus.Shown) {
            this.$currentTextToolbar.hide();
        }
    }
}
