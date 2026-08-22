package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {392, 393, 394}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KeyCommand $keyCommand;
    int label;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(KeyCommand keyCommand, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation<? super TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1> continuation) {
        super(2, continuation);
        this.$keyCommand = keyCommand;
        this.this$0 = textFieldDecoratorModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(this.$keyCommand, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r5.this$0.getTextFieldSelectionState().paste(r5) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r5.this$0.getTextFieldSelectionState().cut(r5) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
    
        if (r5.this$0.getTextFieldSelectionState().copy(false, r5) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1d
            if (r1 == r4) goto L11
            if (r1 == r3) goto L11
            if (r1 != r2) goto L15
        L11:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L68
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.KeyCommand r6 = r5.$keyCommand
            int[] r1 = androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r4) goto L55
            if (r6 == r3) goto L43
            if (r6 == r2) goto L31
            goto L68
        L31:
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.getTextFieldSelectionState()
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.paste(r1)
            if (r6 != r0) goto L68
            goto L67
        L43:
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.getTextFieldSelectionState()
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r3
            java.lang.Object r6 = r6.cut(r1)
            if (r6 != r0) goto L68
            goto L67
        L55:
            androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r5.this$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r6.getTextFieldSelectionState()
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r4
            r2 = 0
            java.lang.Object r6 = r6.copy(r2, r1)
            if (r6 != r0) goto L68
        L67:
            return r0
        L68:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
