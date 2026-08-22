package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.DraggableAnchors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SheetState$animateTo$2", f = "SheetDefaults.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
final class SheetState$animateTo$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<SheetValue>, SheetValue, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ SheetState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SheetState$animateTo$2(SheetState sheetState, float f2, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super SheetState$animateTo$2> continuation) {
        super(4, continuation);
        this.this$0 = sheetState;
        this.$velocity = f2;
        this.$animationSpec = finiteAnimationSpec;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<SheetValue> draggableAnchors, SheetValue sheetValue, Continuation<? super Unit> continuation) {
        SheetState$animateTo$2 sheetState$animateTo$2 = new SheetState$animateTo$2(this.this$0, this.$velocity, this.$animationSpec, continuation);
        sheetState$animateTo$2.L$0 = anchoredDragScope;
        sheetState$animateTo$2.L$1 = draggableAnchors;
        sheetState$animateTo$2.L$2 = sheetValue;
        return sheetState$animateTo$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            float fPositionOf = ((DraggableAnchors) this.L$1).positionOf((SheetValue) this.L$2);
            if (!Float.isNaN(fPositionOf)) {
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = Float.isNaN(this.this$0.getOffset$material3()) ? 0.0f : this.this$0.getOffset$material3();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (SuspendAnimationKt.animate(floatRef.element, fPositionOf, this.$velocity, this.$animationSpec, new Function2() { // from class: androidx.compose.material3.SheetState$animateTo$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return SheetState$animateTo$2.invokeSuspend$lambda$0(anchoredDragScope, floatRef, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
    public static final Unit invokeSuspend$lambda$0(AnchoredDragScope anchoredDragScope, Ref.FloatRef floatRef, float f2, float f3) {
        anchoredDragScope.dragTo(f2, f3);
        floatRef.element = f2;
        return Unit.INSTANCE;
    }
}
