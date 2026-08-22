package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", i = {}, l = {1539}, m = "invokeSuspend", n = {}, s = {})
final class ClockDialNode$pointerInputDragNode$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Offset $dragAmount;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockDialNode$pointerInputDragNode$1$2$1(ClockDialNode clockDialNode, Offset offset, Continuation<? super ClockDialNode$pointerInputDragNode$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = clockDialNode;
        this.$dragAmount = offset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClockDialNode$pointerInputDragNode$1$2$1(this.this$0, this.$dragAmount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClockDialNode$pointerInputDragNode$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.offsetX += Float.intBitsToFloat((int) (this.$dragAmount.m5733unboximpl() >> 32));
            this.this$0.offsetY += Float.intBitsToFloat((int) (this.$dragAmount.m5733unboximpl() & 4294967295L));
            this.label = 1;
            if (AnalogTimePickerState.rotateTo$default(this.this$0.state, TimePickerKt.atan(this.this$0.offsetY - IntOffset.m8959getYimpl(this.this$0.m2600getCenternOccac()), this.this$0.offsetX - IntOffset.m8958getXimpl(this.this$0.m2600getCenternOccac())), this.this$0.animationSpec, false, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TimePickerKt.m3763moveSelectord3b8Pxo(this.this$0.state, this.this$0.offsetX, this.this$0.offsetY, this.this$0.getMaxDist(), this.this$0.m2600getCenternOccac());
        return Unit.INSTANCE;
    }
}
