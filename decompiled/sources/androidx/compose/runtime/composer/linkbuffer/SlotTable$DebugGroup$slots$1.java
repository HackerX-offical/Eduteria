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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup$slots$1", f = "SlotTable.kt", i = {0, 0}, l = {600}, m = "invokeSuspend", n = {"$this$sequence", "address"}, s = {"L$0", "I$0"}, v = 1)
final class SlotTable$DebugGroup$slots$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Object>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SlotTable.DebugGroup this$0;
    final /* synthetic */ SlotTable this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlotTable$DebugGroup$slots$1(SlotTable.DebugGroup debugGroup, SlotTable slotTable, Continuation<? super SlotTable$DebugGroup$slots$1> continuation) {
        super(2, continuation);
        this.this$0 = debugGroup;
        this.this$1 = slotTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$DebugGroup$slots$1 slotTable$DebugGroup$slots$1 = new SlotTable$DebugGroup$slots$1(this.this$0, this.this$1, continuation);
        slotTable$DebugGroup$slots$1.L$0 = obj;
        return slotTable$DebugGroup$slots$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Object> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<Object>) sequenceScope, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$DebugGroup$slots$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0059 -> B:13:0x005c). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            int r1 = r6.I$1
            int r3 = r6.I$0
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5c
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup r1 = r6.this$0
            androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugSlotRange r1 = r1.getSlotRange()
            int r3 = r1.getAddress()
            androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup r4 = r6.this$0
            int r4 = r4.getFlags()
            int r4 = androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt.utilitySlotsCountForFlags(r4)
            int r3 = r3 + r4
            int r1 = r1.getEnd()
            r4 = r7
        L40:
            if (r3 >= r1) goto L5e
            androidx.compose.runtime.composer.linkbuffer.SlotTable r7 = r6.this$1
            java.lang.Object[] r7 = androidx.compose.runtime.composer.linkbuffer.SlotTable.access$getSlots(r7)
            r7 = r7[r3]
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r4
            r6.I$0 = r3
            r6.I$1 = r1
            r6.label = r2
            java.lang.Object r7 = r4.yield(r7, r5)
            if (r7 != r0) goto L5c
            return r0
        L5c:
            int r3 = r3 + r2
            goto L40
        L5e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.composer.linkbuffer.SlotTable$DebugGroup$slots$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
