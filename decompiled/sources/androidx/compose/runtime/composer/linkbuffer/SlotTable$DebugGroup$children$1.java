package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\f\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugGroup;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup$children$1", f = "SlotTable.kt", i = {0, 0, 0}, l = {592}, m = "invokeSuspend", n = {"$this$sequence", "groups$iv$iv", "current$iv$iv"}, s = {"L$0", "L$2", "I$0"}, v = 1)
final class SlotTable$DebugGroup$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super SlotTable.DebugGroup>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SlotTable this$0;
    final /* synthetic */ SlotTable.DebugGroup this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlotTable$DebugGroup$children$1(SlotTable slotTable, SlotTable.DebugGroup debugGroup, Continuation<? super SlotTable$DebugGroup$children$1> continuation) {
        super(2, continuation);
        this.this$0 = slotTable;
        this.this$1 = debugGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$DebugGroup$children$1 slotTable$DebugGroup$children$1 = new SlotTable$DebugGroup$children$1(this.this$0, this.this$1, continuation);
        slotTable$DebugGroup$children$1.L$0 = obj;
        return slotTable$DebugGroup$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super SlotTable.DebugGroup> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$DebugGroup$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005b -> B:13:0x005e). Please report as a decompilation issue!!! */
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
            r2 = 1
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            int r1 = r6.I$0
            java.lang.Object r3 = r6.L$2
            int[] r3 = (int[]) r3
            java.lang.Object r4 = r6.L$1
            androidx.compose.runtime.composer.linkbuffer.SlotTable r4 = (androidx.compose.runtime.composer.linkbuffer.SlotTable) r4
            java.lang.Object r5 = r6.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5e
        L1d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L25:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            androidx.compose.runtime.composer.linkbuffer.SlotTable r1 = r6.this$0
            androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup r3 = r6.this$1
            int r3 = r3.getAddress()
            androidx.compose.runtime.composer.linkbuffer.SlotTable r4 = r6.this$0
            androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace r1 = r1.getAddressSpace()
            int[] r1 = r1.getGroups()
            int r3 = r3 + 3
            r3 = r1[r3]
            r5 = r3
            r3 = r1
            r1 = r5
            r5 = r7
        L46:
            if (r1 <= 0) goto L62
            androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup r7 = new androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup
            r7.<init>(r1)
            r6.L$0 = r5
            r6.L$1 = r4
            r6.L$2 = r3
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r7 = r5.yield(r7, r6)
            if (r7 != r0) goto L5e
            return r0
        L5e:
            int r1 = r1 + r2
            r1 = r3[r1]
            goto L46
        L62:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
