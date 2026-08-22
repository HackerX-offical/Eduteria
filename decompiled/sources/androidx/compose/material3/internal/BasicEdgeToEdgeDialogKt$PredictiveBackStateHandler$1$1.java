package androidx.compose.material3.internal;

import androidx.activity.BackEventCompat;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.runtime.State;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BasicEdgeToEdgeDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.internal.BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1", f = "BasicEdgeToEdgeDialog.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnBack$delegate;
    final /* synthetic */ PredictiveBackState $state;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1(PredictiveBackState predictiveBackState, State<? extends Function0<Unit>> state, Continuation<? super BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1> continuation) {
        super(2, continuation);
        this.$state = predictiveBackState;
        this.$currentOnBack$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1 basicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1 = new BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1(this.$state, this.$currentOnBack$delegate, continuation);
        basicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1.L$0 = obj;
        return basicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Flow<? extends BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return invoke2((Flow<BackEventCompat>) flow, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = (Flow) this.L$0;
                final PredictiveBackState predictiveBackState = this.$state;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((BackEventCompat) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                        SwipeEdge swipeEdge;
                        PredictiveBackStateImpl predictiveBackStateImpl = (PredictiveBackStateImpl) predictiveBackState;
                        float touchX = backEventCompat.getTouchX();
                        float touchY = backEventCompat.getTouchY();
                        float progress = backEventCompat.getProgress();
                        int swipeEdge2 = backEventCompat.getSwipeEdge();
                        if (swipeEdge2 == 0) {
                            swipeEdge = SwipeEdge.Left;
                        } else if (swipeEdge2 == 1) {
                            swipeEdge = SwipeEdge.Right;
                        } else {
                            swipeEdge = SwipeEdge.None;
                        }
                        predictiveBackStateImpl.setValue(new BackEventProgress.InProgress(touchX, touchY, progress, swipeEdge));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ((PredictiveBackStateImpl) this.$state).setValue(BackEventProgress.Completed.INSTANCE);
            BasicEdgeToEdgeDialogKt.PredictiveBackStateHandler$lambda$1(this.$currentOnBack$delegate).invoke();
            return Unit.INSTANCE;
        } catch (CancellationException e2) {
            ((PredictiveBackStateImpl) this.$state).setValue(BackEventProgress.NotRunning.INSTANCE);
            throw e2;
        }
    }
}
