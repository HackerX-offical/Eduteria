package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002JM\u0010#\u001a\u00020\u001e2=\u0010$\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001e0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0+\u0012\u0006\u0012\u0004\u0018\u00010,0%H\u0096@¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0082@¢\u0006\u0002\u00109J\b\u0010\u000e\u001a\u00020\bH\u0016J[\u0010:\u001a\u00020\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0013\u0010;\u001a\u000200*\u000207H\u0002¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\u00020?*\u000207H\u0002¢\u0006\u0004\b@\u0010=J\u0013\u0010A\u001a\u000207*\u00020?H\u0002¢\u0006\u0004\bB\u0010CJ\u0013\u0010A\u001a\u000207*\u000200H\u0002¢\u0006\u0004\bD\u0010CJ\u0013\u0010E\u001a\u00020?*\u00020?H\u0002¢\u0006\u0004\bF\u0010GJ\u0013\u0010E\u001a\u000200*\u000200H\u0002¢\u0006\u0004\bH\u0010GR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006I"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", StreamManagement.Enabled.ELEMENT, "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Ljava/lang/Boolean;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "resolvedFlingBehavior", "getResolvedFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setResolvedFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "density", "Landroidx/compose/ui/unit/Density;", "isReverseDirection", "()Z", "onAttach", "", "onDensityChange", "updateDensity", "updateFlingBehavior", "newFlingBehavior", "drag", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "fling", "", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat", "toFloat-TH1AsA0", "(J)F", "toFloat-k-4lQ0M", "reverseIfNeeded", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Density density;
    private FlingBehavior flingBehavior;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    public FlingBehavior resolvedFlingBehavior;
    private Boolean reverseDirection;
    private Boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode", f = "AnchoredDraggable.kt", i = {1}, l = {459, 462}, m = "fling", n = {"leftoverVelocity"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fling(0.0f, this);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo509onDragStartedk4lQ0M(long startedPosition) {
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, Boolean bool2, FlingBehavior flingBehavior) {
        super(AnchoredDraggableKt.AlwaysDrag, z, mutableInteractionSource, orientation);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = bool;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = bool2;
        this.flingBehavior = flingBehavior;
    }

    public final FlingBehavior getResolvedFlingBehavior() {
        FlingBehavior flingBehavior = this.resolvedFlingBehavior;
        if (flingBehavior != null) {
            return flingBehavior;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
        return null;
    }

    public final void setResolvedFlingBehavior(FlingBehavior flingBehavior) {
        this.resolvedFlingBehavior = flingBehavior;
    }

    private final boolean isReverseDirection() {
        Boolean bool = this.reverseDirection;
        if (bool == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateFlingBehavior(this.flingBehavior);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        onCancelPointerInput();
        if (getIsAttached()) {
            updateDensity();
        }
    }

    private final void updateDensity() {
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        Density density = this.density;
        if (density == null || !Intrinsics.areEqual(density, densityRequireDensity)) {
            this.density = densityRequireDensity;
            updateFlingBehavior(this.flingBehavior);
        }
    }

    private final void updateFlingBehavior(FlingBehavior newFlingBehavior) {
        if (newFlingBehavior == null) {
            AnimationSpec<Float> snapAnimationSpec = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
            Function1<Float, Float> positionalThreshold = AnchoredDraggableDefaults.INSTANCE.getPositionalThreshold();
            Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            this.density = densityRequireDensity;
            newFlingBehavior = AnchoredDraggableKt.anchoredDraggableFlingBehavior(this.state, densityRequireDensity, positionalThreshold, snapAnimationSpec);
        }
        setResolvedFlingBehavior(newFlingBehavior);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$forEachDelta = function2;
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$forEachDelta, this.this$0, continuation);
            anonymousClass2.L$0 = anchoredDragScope;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                Function1<? super DragEvent.DragDelta, Unit> function1 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AnchoredDraggableNode.AnonymousClass2.invokeSuspend$lambda$0(anchoredDraggableNode, anchoredDragScope, (DragEvent.DragDelta) obj2);
                    }
                };
                this.label = 1;
                if (function2.invoke(function1, this) == coroutine_suspended) {
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
        public static final Unit invokeSuspend$lambda$0(final AnchoredDraggableNode anchoredDraggableNode, final AnchoredDragScope anchoredDragScope, DragEvent.DragDelta dragDelta) {
            float fM506toFloatk4lQ0M = anchoredDraggableNode.m506toFloatk4lQ0M(anchoredDraggableNode.m504reverseIfNeededMKHz9U(dragDelta.getDelta()));
            if (anchoredDraggableNode.overscrollEffect == null) {
                AnchoredDragScope.dragTo$default(anchoredDragScope, anchoredDraggableNode.state.newOffsetForDelta$foundation(fM506toFloatk4lQ0M), 0.0f, 2, null);
            } else {
                OverscrollEffect overscrollEffect = anchoredDraggableNode.overscrollEffect;
                Intrinsics.checkNotNull(overscrollEffect);
                Offset.m5712boximpl(overscrollEffect.mo289applyToScrollRhakbz0(anchoredDraggableNode.m507toOffsettuRUvjQ(fM506toFloatk4lQ0M), NestedScrollSource.INSTANCE.m7181getUserInputWNlRxjI(), new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AnchoredDraggableNode.AnonymousClass2.invokeSuspend$lambda$0$0(anchoredDraggableNode, anchoredDragScope, (Offset) obj);
                    }
                }));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Offset invokeSuspend$lambda$0$0(AnchoredDraggableNode anchoredDraggableNode, AnchoredDragScope anchoredDragScope, Offset offset) {
            float fNewOffsetForDelta$foundation = anchoredDraggableNode.state.newOffsetForDelta$foundation(anchoredDraggableNode.m506toFloatk4lQ0M(offset.m5733unboximpl()));
            long jM507toOffsettuRUvjQ = anchoredDraggableNode.m507toOffsettuRUvjQ(fNewOffsetForDelta$foundation - anchoredDraggableNode.state.requireOffset());
            AnchoredDragScope.dragTo$default(anchoredDragScope, fNewOffsetForDelta$foundation, 0.0f, 2, null);
            return Offset.m5712boximpl(jM507toOffsettuRUvjQ);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, null, new AnonymousClass2(function2, this, null), continuation, 1, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {438, 440}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DragEvent.DragStopped $event;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02861(AnchoredDraggableNode<T> anchoredDraggableNode, DragEvent.DragStopped dragStopped, Continuation<? super C02861> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
            this.$event = dragStopped;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02861(this.this$0, this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        
            if (r7.this$0.fling(r8, r7) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        
            if (r1.mo288applyToFlingBMRW4eQ(r7.this$0.m508toVelocityadjELrA(r8), new androidx.compose.foundation.gestures.AnchoredDraggableNode.C02861.C00161(r7.this$0, null), r7) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r8)
                goto L6c
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L6e
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r8 = r7.this$0
                androidx.compose.foundation.gestures.DragEvent$DragStopped r1 = r7.$event
                long r4 = r1.getVelocity()
                long r4 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m497access$reverseIfNeededAH228Gc(r8, r4)
                float r8 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m499access$toFloatTH1AsA0(r8, r4)
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r7.this$0
                androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r1)
                if (r1 != 0) goto L47
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r7.this$0
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.label = r3
                java.lang.Object r8 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$fling(r1, r8, r2)
                if (r8 != r0) goto L6e
                goto L6b
            L47:
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r7.this$0
                androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r3 = r7.this$0
                long r3 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m502access$toVelocityadjELrA(r3, r8)
                androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 r8 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1
                androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r5 = r7.this$0
                r6 = 0
                r8.<init>(r5, r6)
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r7.label = r2
                java.lang.Object r8 = r1.mo288applyToFlingBMRW4eQ(r3, r8, r5)
                if (r8 != r0) goto L6c
            L6b:
                return r0
            L6c:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
            L6e:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode.C02861.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "availableVelocity"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {442}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"}, v = 1)
        static final class C00161 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
            /* synthetic */ long J$0;
            int label;
            final /* synthetic */ AnchoredDraggableNode<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00161(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C00161> continuation) {
                super(2, continuation);
                this.this$0 = anchoredDraggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00161 c00161 = new C00161(this.this$0, continuation);
                c00161.J$0 = ((Velocity) obj).getPackedValue();
                return c00161;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
                return m512invokesFctU(velocity.getPackedValue(), continuation);
            }

            /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
            public final Object m512invokesFctU(long j, Continuation<? super Velocity> continuation) {
                return ((C00161) create(Velocity.m9059boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                long jM508toVelocityadjELrA;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.J$0;
                    AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                    this.J$0 = j;
                    this.label = 1;
                    obj = anchoredDraggableNode.fling(anchoredDraggableNode.m505toFloatTH1AsA0(j), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jM508toVelocityadjELrA = j;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jM508toVelocityadjELrA = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                float fFloatValue = ((Number) obj).floatValue();
                float fRequireOffset = ((AnchoredDraggableNode) this.this$0).state.requireOffset();
                float fMinPosition = ((AnchoredDraggableNode) this.this$0).state.getAnchors().minPosition();
                if (fRequireOffset >= ((AnchoredDraggableNode) this.this$0).state.getAnchors().maxPosition() || fRequireOffset <= fMinPosition) {
                    jM508toVelocityadjELrA = this.this$0.m508toVelocityadjELrA(fFloatValue);
                }
                return Velocity.m9059boximpl(jM508toVelocityadjELrA);
            }
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped(DragEvent.DragStopped event) {
        if (getIsAttached()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02861(this, event, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fling(float r8, kotlin.coroutines.Continuation<? super java.lang.Float> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableNode.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableNode.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1
            r0.<init>(r7, r9)
        L19:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r8 = r4.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L75
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            return r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r9 = r7.state
            boolean r9 = r9.getUsePreModifierChangeBehavior$foundation()
            if (r9 == 0) goto L55
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r9 = r7.state
            r4.label = r3
            java.lang.Object r8 = r9.settle(r8, r4)
            if (r8 != r0) goto L54
            goto L73
        L54:
            return r8
        L55:
            kotlin.jvm.internal.Ref$FloatRef r9 = new kotlin.jvm.internal.Ref$FloatRef
            r9.<init>()
            r9.element = r8
            androidx.compose.foundation.gestures.AnchoredDraggableState<T> r1 = r7.state
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2 r3 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2
            r5 = 0
            r3.<init>(r7, r9, r8, r5)
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r4.L$0 = r9
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L74
        L73:
            return r0
        L74:
            r8 = r9
        L75:
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode.fling(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2", f = "AnchoredDraggable.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02852 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $leftoverVelocity;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02852(AnchoredDraggableNode<T> anchoredDraggableNode, Ref.FloatRef floatRef, float f2, Continuation<? super C02852> continuation) {
            super(3, continuation);
            this.this$0 = anchoredDraggableNode;
            this.$leftoverVelocity = floatRef;
            this.$velocity = f2;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            C02852 c02852 = new C02852(this.this$0, this.$leftoverVelocity, this.$velocity, continuation);
            c02852.L$0 = anchoredDragScope;
            return c02852.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.FloatRef floatRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2$scrollScope$1
                    @Override // androidx.compose.foundation.gestures.ScrollScope
                    public float scrollBy(float pixels) {
                        float fNewOffsetForDelta$foundation = ((AnchoredDraggableNode) anchoredDraggableNode).state.newOffsetForDelta$foundation(pixels);
                        float offset = fNewOffsetForDelta$foundation - ((AnchoredDraggableNode) anchoredDraggableNode).state.getOffset();
                        AnchoredDragScope.dragTo$default(anchoredDragScope, fNewOffsetForDelta$foundation, 0.0f, 2, null);
                        return offset;
                    }
                };
                FlingBehavior resolvedFlingBehavior = this.this$0.getResolvedFlingBehavior();
                Ref.FloatRef floatRef2 = this.$leftoverVelocity;
                float f2 = this.$velocity;
                this.L$0 = floatRef2;
                this.label = 1;
                obj = resolvedFlingBehavior.performFling(scrollScope, f2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                floatRef = floatRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                floatRef = (Ref.FloatRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            floatRef.element = ((Number) obj).floatValue();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        Boolean bool = this.startDragImmediately;
        return bool != null ? bool.booleanValue() : this.state.isAnimationRunning();
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, Boolean startDragImmediately, FlingBehavior flingBehavior) {
        boolean z;
        this.flingBehavior = flingBehavior;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.state, state)) {
            z = false;
        } else {
            this.state = state;
            updateFlingBehavior(flingBehavior);
            z = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (Intrinsics.areEqual(this.reverseDirection, reverseDirection)) {
            z2 = z;
        } else {
            this.reverseDirection = reverseDirection;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default(this, null, enabled, interactionSource, orientation, z2, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m507toOffsettuRUvjQ(float f2) {
        float f3 = this.orientation == Orientation.Horizontal ? f2 : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f2 = 0.0f;
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m508toVelocityadjELrA(float f2) {
        float f3 = this.orientation == Orientation.Horizontal ? f2 : 0.0f;
        if (this.orientation != Orientation.Vertical) {
            f2 = 0.0f;
        }
        return VelocityKt.Velocity(f3, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m505toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Vertical ? Velocity.m9069getYimpl(j) : Velocity.m9068getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m506toFloatk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Vertical ? j & 4294967295L : j >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m503reverseIfNeededAH228Gc(long j) {
        return Velocity.m9074timesadjELrA(j, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m504reverseIfNeededMKHz9U(long j) {
        return Offset.m5730timestuRUvjQ(j, isReverseDirection() ? -1.0f : 1.0f);
    }
}
