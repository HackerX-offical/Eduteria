package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.UnplacedAwareModifierNode;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: OnVisibilityChangedModifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010@\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u0002062\b\u0010B\u001a\u0004\u0018\u000106J\u0006\u0010C\u001a\u00020\rJ\u0006\u0010D\u001a\u00020\rJ\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u00020\rH\u0016J\u0006\u0010G\u001a\u00020\rJ\b\u0010H\u001a\u00020\rH\u0016J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020\rH\u0016J\b\u0010K\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001d\u0010>\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0019¨\u0006L"}, d2 = {"Landroidx/compose/ui/layout/OnVisibilityChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/UnplacedAwareModifierNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function1;", "", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function1;)V", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "getMinFractionVisible", "()F", "setMinFractionVisible", "(F)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "value", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setViewportBounds", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "lastResult", "getLastResult", "()Z", "setLastResult", "(Z)V", "lastReportedResult", "getLastReportedResult", "setLastReportedResult", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "lastViewport", "getLastViewport", "setLastViewport", "rectChanged", "getRectChanged", "checkVisibility", "bounds", "viewport", "triggerCallback", "forceUpdate", "fireExitIfNeeded", "onReset", "updateViewport", "onAttach", "onDetach", "onObservedReadsChanged", "onUnplaced", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnVisibilityChangedNode extends Modifier.Node implements ObserverModifierNode, UnplacedAwareModifierNode {
    public static final int $stable = 8;
    private Function1<? super Boolean, Unit> callback;
    private DelegatableNode.RegistrationHandle handle;
    private Job job;
    private RelativeLayoutBounds lastBounds;
    private boolean lastReportedResult;
    private boolean lastResult;
    private RelativeLayoutBounds lastViewport;
    private long minDurationMs;
    private float minFractionVisible;
    private final Function1<RelativeLayoutBounds, Unit> rectChanged = new Function1<RelativeLayoutBounds, Unit>() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode$rectChanged$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RelativeLayoutBounds relativeLayoutBounds) {
            invoke2(relativeLayoutBounds);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RelativeLayoutBounds relativeLayoutBounds) {
            OnVisibilityChangedNode onVisibilityChangedNode = this.this$0;
            LayoutBoundsHolder viewportBounds = onVisibilityChangedNode.getViewportBounds();
            onVisibilityChangedNode.setLastViewport(viewportBounds != null ? viewportBounds.getBounds() : null);
            OnVisibilityChangedNode onVisibilityChangedNode2 = this.this$0;
            onVisibilityChangedNode2.checkVisibility(onVisibilityChangedNode2.getMinFractionVisible(), relativeLayoutBounds, this.this$0.getLastViewport());
        }
    };
    private LayoutBoundsHolder viewportBounds;

    public OnVisibilityChangedNode(long j, float f2, LayoutBoundsHolder layoutBoundsHolder, Function1<? super Boolean, Unit> function1) {
        this.minDurationMs = j;
        this.minFractionVisible = f2;
        this.callback = function1;
        this.viewportBounds = layoutBoundsHolder;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final void setMinFractionVisible(float f2) {
        this.minFractionVisible = f2;
    }

    public final Function1<Boolean, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super Boolean, Unit> function1) {
        this.callback = function1;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    public final void setViewportBounds(LayoutBoundsHolder layoutBoundsHolder) {
        this.viewportBounds = layoutBoundsHolder;
        updateViewport();
    }

    public final DelegatableNode.RegistrationHandle getHandle() {
        return this.handle;
    }

    public final void setHandle(DelegatableNode.RegistrationHandle registrationHandle) {
        this.handle = registrationHandle;
    }

    public final Job getJob() {
        return this.job;
    }

    public final void setJob(Job job) {
        this.job = job;
    }

    public final boolean getLastResult() {
        return this.lastResult;
    }

    public final void setLastResult(boolean z) {
        this.lastResult = z;
    }

    public final boolean getLastReportedResult() {
        return this.lastReportedResult;
    }

    public final void setLastReportedResult(boolean z) {
        this.lastReportedResult = z;
    }

    public final RelativeLayoutBounds getLastBounds() {
        return this.lastBounds;
    }

    public final void setLastBounds(RelativeLayoutBounds relativeLayoutBounds) {
        this.lastBounds = relativeLayoutBounds;
    }

    public final RelativeLayoutBounds getLastViewport() {
        return this.lastViewport;
    }

    public final void setLastViewport(RelativeLayoutBounds relativeLayoutBounds) {
        this.lastViewport = relativeLayoutBounds;
    }

    public final Function1<RelativeLayoutBounds, Unit> getRectChanged() {
        return this.rectChanged;
    }

    public final void checkVisibility(float minFractionVisible, RelativeLayoutBounds bounds, RelativeLayoutBounds viewport) {
        float fFractionVisibleInWindow;
        this.lastBounds = bounds;
        if (viewport != null || this.viewportBounds == null) {
            if (viewport != null) {
                fFractionVisibleInWindow = bounds.fractionVisibleIn(viewport);
            } else {
                fFractionVisibleInWindow = bounds.fractionVisibleInWindow();
            }
            boolean z = fFractionVisibleInWindow > minFractionVisible || fFractionVisibleInWindow == 1.0f;
            if (z != this.lastResult) {
                this.lastResult = z;
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = null;
                if (z != this.lastReportedResult) {
                    if (z && this.minDurationMs > 0) {
                        this.job = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
                    } else {
                        triggerCallback();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.OnVisibilityChangedNode$checkVisibility$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnVisibilityChangedModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.layout.OnVisibilityChangedNode$checkVisibility$1", f = "OnVisibilityChangedModifier.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OnVisibilityChangedNode.this.new AnonymousClass1(continuation);
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
                if (DelayKt.delay(OnVisibilityChangedNode.this.getMinDurationMs(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            OnVisibilityChangedNode.this.triggerCallback();
            return Unit.INSTANCE;
        }
    }

    public final void triggerCallback() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.callback.invoke(Boolean.valueOf(this.lastResult));
        this.lastReportedResult = this.lastResult;
    }

    public final void forceUpdate() {
        RelativeLayoutBounds relativeLayoutBounds = this.lastBounds;
        if (relativeLayoutBounds != null) {
            checkVisibility(this.minFractionVisible, relativeLayoutBounds, this.lastViewport);
        }
    }

    public final void fireExitIfNeeded() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.lastResult = false;
        if (this.lastReportedResult) {
            triggerCallback();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        fireExitIfNeeded();
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.lastResult = false;
        this.lastBounds = null;
        this.lastViewport = null;
    }

    public final void updateViewport() {
        if (this.viewportBounds == null) {
            if (this.lastViewport != null) {
                this.lastViewport = null;
                forceUpdate();
                return;
            }
            return;
        }
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode.updateViewport.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LayoutBoundsHolder viewportBounds = OnVisibilityChangedNode.this.getViewportBounds();
                RelativeLayoutBounds bounds = viewportBounds != null ? viewportBounds.getBounds() : null;
                if (Intrinsics.areEqual(OnVisibilityChangedNode.this.getLastViewport(), bounds)) {
                    return;
                }
                OnVisibilityChangedNode.this.setLastViewport(bounds);
                OnVisibilityChangedNode.this.forceUpdate();
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0L, 0L, this.rectChanged);
        updateViewport();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
        fireExitIfNeeded();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateViewport();
    }

    @Override // androidx.compose.ui.node.UnplacedAwareModifierNode
    public void onUnplaced() {
        fireExitIfNeeded();
    }
}
