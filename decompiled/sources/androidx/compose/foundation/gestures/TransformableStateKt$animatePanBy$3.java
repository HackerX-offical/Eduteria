package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$3", f = "TransformableState.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TransformableStateKt$animatePanBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Offset> $animationSpec;
    final /* synthetic */ long $centroid;
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.LongRef $previous;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animatePanBy$3(Ref.LongRef longRef, long j, AnimationSpec<Offset> animationSpec, long j2, Continuation<? super TransformableStateKt$animatePanBy$3> continuation) {
        super(2, continuation);
        this.$previous = longRef;
        this.$offset = j;
        this.$animationSpec = animationSpec;
        this.$centroid = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableStateKt$animatePanBy$3 transformableStateKt$animatePanBy$3 = new TransformableStateKt$animatePanBy$3(this.$previous, this.$offset, this.$animationSpec, this.$centroid, continuation);
        transformableStateKt$animatePanBy$3.L$0 = obj;
        return transformableStateKt$animatePanBy$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animatePanBy$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(Offset.INSTANCE), Offset.m5712boximpl(this.$previous.element), null, 0L, 0L, false, 60, null);
            Offset offsetM5712boximpl = Offset.m5712boximpl(this.$offset);
            AnimationSpec<Offset> animationSpec = this.$animationSpec;
            final Ref.LongRef longRef = this.$previous;
            final long j = this.$centroid;
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, offsetM5712boximpl, animationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TransformableStateKt$animatePanBy$3.invokeSuspend$lambda$0(longRef, transformScope, j, (AnimationScope) obj2);
                }
            }, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Ref.LongRef longRef, TransformScope transformScope, long j, AnimationScope animationScope) {
        TransformScope.m725transformByWithCentroidIEwrmTk$default(transformScope, j, 0.0f, Offset.m5727minusMKHz9U(((Offset) animationScope.getValue()).m5733unboximpl(), longRef.element), 0.0f, 10, null);
        longRef.element = ((Offset) animationScope.getValue()).m5733unboximpl();
        return Unit.INSTANCE;
    }
}
