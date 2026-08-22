package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJM\u0010(\u001a\u00020)2=\u0010*\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(-\u0012\u0004\u0012\u00020)0+\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0%\u0012\u0006\u0012\u0004\u0018\u00010&0\u001dH\u0096@¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020$H\u0016¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\nH\u0016J4\u00107\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u00108\u001a\u00020)H\u0016J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0016J'\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\f\u0010D\u001a\u00020)*\u00020EH\u0016J\b\u0010F\u001a\u00020)H\u0002J\b\u0010G\u001a\u00020)H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010#\u001a \b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0%\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'¨\u0006H"}, d2 = {"Landroidx/compose/foundation/gestures/Scrollable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", StreamManagement.Enabled.ELEMENT, "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "drag", "", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", DiscoverItems.Item.UPDATE_ACTION, "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scrollable2DNode extends DragGestureNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic2D scrollingLogic;
    private final boolean shouldAutoInvalidate;

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public void mo509onDragStartedk4lQ0M(long startedPosition) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Scrollable2DNode(Scrollable2DState scrollable2DState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(ScrollableKt.getCanDragCalculation(), z, mutableInteractionSource, null);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.getUnityDensity()), null, 2, 0 == true ? 1 : 0);
        this.defaultFlingBehavior = defaultFlingBehavior;
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        DefaultFlingBehavior defaultFlingBehavior2 = this.flingBehavior;
        ScrollingLogic2D scrollingLogic2D = new ScrollingLogic2D(scrollable2DState, overscrollEffect2, defaultFlingBehavior2 == null ? defaultFlingBehavior : defaultFlingBehavior2, nestedScrollDispatcher, new Function0() { // from class: androidx.compose.foundation.gestures.Scrollable2DNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.getIsAttached());
            }
        });
        this.scrollingLogic = scrollingLogic2D;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic2D, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(scrollableNestedScrollConnection, nestedScrollDispatcher));
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
            return;
        }
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollingLogic.scroll(MutatePriority.UserInput, new Scrollable2DNode$drag$2$1(function2, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.Scrollable2DNode$onDragStopped$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable2D.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$onDragStopped$1", f = "Scrollable2D.kt", i = {}, l = {HttpStatus.SC_RESET_CONTENT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DragEvent.DragStopped $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DragEvent.DragStopped dragStopped, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = dragStopped;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Scrollable2DNode.this.new AnonymousClass1(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Scrollable2DNode.this.scrollingLogic.m704onScrollStoppedsFctU(this.$event.getVelocity(), this) == coroutine_suspended) {
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
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped(DragEvent.DragStopped event) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new AnonymousClass1(event, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(Scrollable2DState state, OverscrollEffect overscrollEffect, boolean enabled, FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        boolean z;
        if (getEnabled() != enabled) {
            this.nestedScrollConnection.setEnabled(enabled);
            ScrollableContainerNode scrollableContainerNode = this.scrollableContainerNode;
            if (scrollableContainerNode != null) {
                scrollableContainerNode.update(enabled);
            }
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        boolean zUpdate = this.scrollingLogic.update(state, overscrollEffect, flingBehavior == null ? this.defaultFlingBehavior : flingBehavior, this.nestedScrollDispatcher);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        DragGestureNode.update$default(this, ScrollableKt.getCanDragCalculation(), enabled, interactionSource, null, zUpdate, 8, null);
        if (z2) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDefaultFlingBehavior();
    }

    private final void updateDefaultFlingBehavior() {
        if (getIsAttached()) {
            this.defaultFlingBehavior.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        onCancelPointerInput();
        updateDefaultFlingBehavior();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo280onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (getCanDrag().invoke(PointerType.m7382boximpl(changes.get(i).getType())).booleanValue()) {
                super.mo280onPointerEventH0pRuoY(pointerEvent, pass, bounds);
                return;
            }
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (getEnabled() && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            setScrollSemanticsActions();
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, null, function2, 1, null);
        }
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function22 = this.scrollByOffsetAction;
        if (function22 != null) {
            SemanticsPropertiesKt.scrollByOffset(semanticsPropertyReceiver, function22);
        }
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new Function2() { // from class: androidx.compose.foundation.gestures.Scrollable2DNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(Scrollable2DNode.setScrollSemanticsActions$lambda$0(this.f$0, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        };
        this.scrollByOffsetAction = new AnonymousClass2(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setScrollSemanticsActions$lambda$0(Scrollable2DNode scrollable2DNode, float f2, float f3) {
        BuildersKt__Builders_commonKt.launch$default(scrollable2DNode.getCoroutineScope(), null, null, new Scrollable2DNode$setScrollSemanticsActions$1$1(scrollable2DNode, f2, f3, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.Scrollable2DNode$setScrollSemanticsActions$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable2D.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$setScrollSemanticsActions$2", f = "Scrollable2D.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = Scrollable2DNode.this.new AnonymousClass2(continuation);
            anonymousClass2.J$0 = ((Offset) obj).m5733unboximpl();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
            return m672invoke3MmeM6k(offset.m5733unboximpl(), continuation);
        }

        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m672invoke3MmeM6k(long j, Continuation<? super Offset> continuation) {
            return ((AnonymousClass2) create(Offset.m5712boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            long j = this.J$0;
            this.label = 1;
            Object objM670semanticsScrollByd4ec7I = Scrollable2DKt.m670semanticsScrollByd4ec7I(Scrollable2DNode.this.scrollingLogic, j, this);
            return objM670semanticsScrollByd4ec7I == coroutine_suspended ? coroutine_suspended : objM670semanticsScrollByd4ec7I;
        }
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }
}
