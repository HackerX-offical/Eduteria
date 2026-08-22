package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommonContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1", f = "CommonContextMenuArea.kt", i = {}, l = {105, 106, 107}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuItems $item;
    final /* synthetic */ TextFieldSelectionState $this_contextMenuBuilder;
    int label;

    /* JADX INFO: compiled from: CommonContextMenuArea.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextContextMenuItems.values().length];
            try {
                iArr[TextContextMenuItems.Cut.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextContextMenuItems.Copy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextContextMenuItems.Paste.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextContextMenuItems.SelectAll.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TextContextMenuItems.Autofill.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1(TextContextMenuItems textContextMenuItems, TextFieldSelectionState textFieldSelectionState, Continuation<? super CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1> continuation) {
        super(2, continuation);
        this.$item = textContextMenuItems;
        this.$this_contextMenuBuilder = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1(this.$item, this.$this_contextMenuBuilder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r5.$this_contextMenuBuilder.paste(r5) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r5.$this_contextMenuBuilder.copy(false, r5) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
    
        if (r5.$this_contextMenuBuilder.cut(r5) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
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
            goto L73
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.TextContextMenuItems r6 = r5.$item
            int[] r1 = androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r4) goto L65
            if (r6 == r3) goto L56
            if (r6 == r2) goto L48
            r0 = 4
            if (r6 == r0) goto L42
            r0 = 5
            if (r6 != r0) goto L3c
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.$this_contextMenuBuilder
            r6.autofill()
            goto L73
        L3c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L42:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.$this_contextMenuBuilder
            r6.selectAll()
            goto L73
        L48:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.$this_contextMenuBuilder
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.paste(r1)
            if (r6 != r0) goto L73
            goto L72
        L56:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.$this_contextMenuBuilder
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r3
            r2 = 0
            java.lang.Object r6 = r6.copy(r2, r1)
            if (r6 != r0) goto L73
            goto L72
        L65:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = r5.$this_contextMenuBuilder
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r4
            java.lang.Object r6 = r6.cut(r1)
            if (r6 != r0) goto L73
        L72:
            return r0
        L73:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
