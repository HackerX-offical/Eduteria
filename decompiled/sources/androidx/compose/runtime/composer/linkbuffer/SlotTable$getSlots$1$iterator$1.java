package androidx.compose.runtime.composer.linkbuffer;

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
@DebugMetadata(c = "androidx.compose.runtime.composer.linkbuffer.SlotTable$getSlots$1$iterator$1", f = "SlotTable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {580}, m = "invokeSuspend", n = {"$this$iterator", "this_$iv", "toVisit$iv$iv$iv", "groups$iv$iv$iv", "this_$iv$iv", "start$iv$iv$iv", "includeSiblingsOfStartGroup$iv$iv$iv", "group$iv$iv$iv", "size$iv$iv", "address$iv$iv", "index$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"}, v = 1)
final class SlotTable$getSlots$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Object>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ SlotTable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlotTable$getSlots$1$iterator$1(SlotTable slotTable, Continuation<? super SlotTable$getSlots$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = slotTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlotTable$getSlots$1$iterator$1 slotTable$getSlots$1$iterator$1 = new SlotTable$getSlots$1$iterator$1(this.this$0, continuation);
        slotTable$getSlots$1$iterator$1.L$0 = obj;
        return slotTable$getSlots$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Object> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<Object>) sequenceScope, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlotTable$getSlots$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:29:0x00cf, B:30:0x00d1], limit reached: 41 */
    /* JADX WARN: Path cross not found for [B:30:0x00d1, B:29:0x00cf], limit reached: 41 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x006b -> B:28:0x00cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c1 -> B:26:0x00c4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.composer.linkbuffer.SlotTable$getSlots$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
