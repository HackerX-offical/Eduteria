package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.Owner;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: ComposeView.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fJ\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\r\u00107\u001a\u00020 H'¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020 J\u0010\u00109\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010;\u001a\u00020 H\u0002J\f\u0010>\u001a\u00020\f*\u00020\fH\u0002J\b\u0010?\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020\u0017H\u0002J\u0018\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0006\u0010F\u001a\u00020 J\b\u0010I\u001a\u00020 H\u0014J\b\u0010J\u001a\u00020 H\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0004J\u001d\u0010N\u001a\u00020 2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0010¢\u0006\u0002\bOJ0\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0004J5\u0010V\u001a\u00020 2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\u0007H\u0016J\b\u0010[\u001a\u00020)H\u0016J\u0010\u0010\\\u001a\u00020 2\u0006\u0010[\u001a\u00020)H\u0016J\u0012\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u0007H\u0016J\"\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0016J\u001c\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J$\u0010]\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J$\u0010d\u001a\u00020)2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0014J,\u0010d\u001a\u00020)2\b\u0010^\u001a\u0004\u0018\u00010D2\u0006\u0010_\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010e\u001a\u00020)H\u0014J\b\u0010f\u001a\u00020)H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R0\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u00178\u0000@@X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001aR\u0014\u0010(\u001a\u00020)8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R,\u0010,\u001a\u00020)2\u0006\u0010\r\u001a\u00020)8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010+\"\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010\r\u001a\u0002018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010:\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010<\u001a\u00020)*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010G\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bH\u0010+R\u000e\u0010Z\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "value", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "composition", "Landroidx/compose/runtime/Composition;", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroidx/compose/ui/platform/ComposeViewContext;", "composeViewContext", "getComposeViewContext$ui$annotations", "()V", "getComposeViewContext$ui", "()Landroidx/compose/ui/platform/ComposeViewContext;", "setComposeViewContext$ui", "(Landroidx/compose/ui/platform/ComposeViewContext;)V", "setParentCompositionContext", "", Message.Thread.PARENT_ATTRIBUTE_NAME, "disposeViewCompositionStrategy", "Lkotlin/Function0;", "getDisposeViewCompositionStrategy$annotations", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "autoClearFocusBehavior", "getAutoClearFocusBehavior-4UtRPd4", "()I", "setAutoClearFocusBehavior-17tfJxM", "(I)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createComposition", "creatingComposition", "checkAddView", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "cacheIfAlive", "resolveParentCompositionContext", "ensureCompositionCreated", "resolveComposeViewContext", "updateAutoCreatedComposeViewContext", "contextView", "Landroid/view/View;", "existingContext", "disposeComposition", "hasComposition", "getHasComposition", "onAttachedToWindow", "attachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure", "internalOnMeasure$ui", "onLayout", "changed", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "internalOnLayout", "internalOnLayout$ui", "onRtlPropertiesChanged", "layoutDirection", "isTransitionGroupSet", "isTransitionGroup", "setTransitionGroup", "addView", "child", FirebaseAnalytics.Param.INDEX, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "addViewInLayout", "preventRequestLayout", "shouldDelayChildPressedState", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private ComposeViewContext composeViewContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    public AbstractComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static /* synthetic */ void getComposeViewContext$ui$annotations() {
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public abstract void Content(Composer composer, int i);

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.INSTANCE.getDefault().installFor(this);
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    /* JADX INFO: renamed from: getComposeViewContext$ui, reason: from getter */
    public final ComposeViewContext getComposeViewContext() {
        return this.composeViewContext;
    }

    public final void setComposeViewContext$ui(ComposeViewContext composeViewContext) {
        if (this.composeViewContext != composeViewContext) {
            if (composeViewContext == null) {
                disposeComposition();
            } else if (getChildCount() != 0) {
                View childAt = getChildAt(0);
                AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
                if (androidComposeView != null) {
                    if (androidComposeView.getCoroutineContext() != composeViewContext.getCompositionContext().getEffectCoroutineContext()) {
                        disposeComposition();
                    }
                    androidComposeView.setComposeViewContext(composeViewContext);
                }
            }
            this.composeViewContext = composeViewContext;
        }
    }

    public final void setParentCompositionContext(CompositionContext parent) {
        setParentContext(parent);
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy strategy) {
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z);
        }
    }

    /* JADX INFO: renamed from: getAutoClearFocusBehavior-4UtRPd4, reason: not valid java name */
    public final int m7867getAutoClearFocusBehavior4UtRPd4() {
        Object tag = getTag(R.id.auto_clear_focus_behavior_tag);
        AutoClearFocusBehavior autoClearFocusBehavior = tag instanceof AutoClearFocusBehavior ? (AutoClearFocusBehavior) tag : null;
        return autoClearFocusBehavior != null ? autoClearFocusBehavior.getValue() : AutoClearFocusBehavior.INSTANCE.m7910getDefault4UtRPd4();
    }

    /* JADX INFO: renamed from: setAutoClearFocusBehavior-17tfJxM, reason: not valid java name */
    public final void m7868setAutoClearFocusBehavior17tfJxM(int i) {
        setTag(R.id.auto_clear_focus_behavior_tag, AutoClearFocusBehavior.m7902boximpl(i));
    }

    public final void createComposition() {
        ComposeViewContext composeViewContext;
        View view;
        if (this.parentContext == null && !isAttachedToWindow() && ((composeViewContext = this.composeViewContext) == null || composeViewContext == null || (view = composeViewContext.getView()) == null || !view.isAttachedToWindow())) {
            throw new IllegalStateException("createComposition requires a previous call to createComposition(ComposeViewContext), a parent reference, or the View to be attached to a window. Attach the View or call setParentCompositionReference.".toString());
        }
        ensureCompositionCreated();
    }

    public final void createComposition(ComposeViewContext composeViewContext) {
        if (!composeViewContext.getView().isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires the ComposeViewContext's view to be attached to a window.".toString());
        }
        setComposeViewContext$ui(composeViewContext);
        ensureCompositionCreated();
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
            throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    private final boolean isAlive(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer) compositionContext).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext cacheIfAlive(CompositionContext compositionContext) {
        CompositionContext compositionContext2 = isAlive(compositionContext) ? compositionContext : null;
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        CompositionContext compositionContext2 = this.parentContext;
        if (compositionContext2 != null) {
            return compositionContext2;
        }
        AbstractComposeView abstractComposeView = this;
        CompositionContext compositionContextFindViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(abstractComposeView);
        CompositionContext compositionContext3 = null;
        CompositionContext compositionContextCacheIfAlive = compositionContextFindViewTreeCompositionContext != null ? cacheIfAlive(compositionContextFindViewTreeCompositionContext) : null;
        if (compositionContextCacheIfAlive != null) {
            return compositionContextCacheIfAlive;
        }
        WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
        if (weakReference != null && (compositionContext = weakReference.get()) != null && isAlive(compositionContext)) {
            compositionContext3 = compositionContext;
        }
        return compositionContext3 == null ? cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(abstractComposeView)) : compositionContext3;
    }

    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                Trace.beginSection("Compose:initializeView");
                try {
                    ComposeViewContext composeViewContextResolveComposeViewContext = this.composeViewContext;
                    if (composeViewContextResolveComposeViewContext == null) {
                        composeViewContextResolveComposeViewContext = resolveComposeViewContext();
                    }
                    this.composition = Wrapper_androidKt.setContent(this, composeViewContextResolveComposeViewContext, ComposableLambdaKt.composableLambdaInstance(1003123809, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C340@15415L9:ComposeView.android.kt#itgzvw");
                            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1003123809, i, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous>.<anonymous> (ComposeView.android.kt:340)");
                            }
                            this.this$0.Content(composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.platform.ComposeViewContext resolveComposeViewContext() {
        /*
            r9 = this;
            r0 = r9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r0 = r0.getChildCount()
            r1 = 0
            if (r0 != 0) goto Lc
        La:
            r0 = r1
            goto L1f
        Lc:
            r0 = 0
            android.view.View r0 = r9.getChildAt(r0)
            boolean r2 = r0 instanceof androidx.compose.ui.platform.AndroidComposeView
            if (r2 == 0) goto L18
            androidx.compose.ui.platform.AndroidComposeView r0 = (androidx.compose.ui.platform.AndroidComposeView) r0
            goto L19
        L18:
            r0 = r1
        L19:
            if (r0 == 0) goto La
            androidx.compose.ui.platform.ComposeViewContext r0 = r0.getComposeViewContext()
        L1f:
            r2 = r9
            android.view.View r2 = (android.view.View) r2
            android.view.View r4 = androidx.compose.ui.platform.ComposeView_androidKt.access$findViewTreeComposeViewRoot(r2)
            androidx.compose.ui.platform.ComposeViewContext r2 = androidx.compose.ui.platform.ComposeView_androidKt.getComposeViewContext(r4)
            if (r2 != 0) goto L7c
            androidx.compose.runtime.CompositionContext r5 = r9.resolveParentCompositionContext()
            androidx.lifecycle.LifecycleOwner r2 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r4)
            if (r2 != 0) goto L49
            if (r0 == 0) goto L3d
            androidx.lifecycle.LifecycleOwner r2 = r0.getLifecycleOwner()
            goto L3e
        L3d:
            r2 = r1
        L3e:
            if (r2 == 0) goto L41
            goto L49
        L41:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Composed into the View which doesn't propagate ViewTreeLifecycleOwner!"
            r0.<init>(r1)
            throw r0
        L49:
            r6 = r2
            androidx.savedstate.SavedStateRegistryOwner r2 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r4)
            if (r2 != 0) goto L63
            if (r0 == 0) goto L57
            androidx.savedstate.SavedStateRegistryOwner r2 = r0.getSavedStateRegistryOwner()
            goto L58
        L57:
            r2 = r1
        L58:
            if (r2 == 0) goto L5b
            goto L63
        L5b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Composed into the View which doesn't propagate ViewTreeSavedStateRegistryOwner!"
            r0.<init>(r1)
            throw r0
        L63:
            r7 = r2
            androidx.lifecycle.ViewModelStoreOwner r2 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r4)
            if (r2 != 0) goto L72
            if (r0 == 0) goto L70
            androidx.lifecycle.ViewModelStoreOwner r1 = r0.getViewModelStoreOwner()
        L70:
            r8 = r1
            goto L73
        L72:
            r8 = r2
        L73:
            androidx.compose.ui.platform.ComposeViewContext r3 = new androidx.compose.ui.platform.ComposeViewContext
            r3.<init>(r4, r5, r6, r7, r8)
            androidx.compose.ui.platform.ComposeView_androidKt.setComposeViewContext(r4, r3)
            return r3
        L7c:
            androidx.compose.ui.platform.ComposeViewContext r0 = r9.updateAutoCreatedComposeViewContext(r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AbstractComposeView.resolveComposeViewContext():androidx.compose.ui.platform.ComposeViewContext");
    }

    private final ComposeViewContext updateAutoCreatedComposeViewContext(View contextView, ComposeViewContext existingContext) {
        CompositionContext compositionContextResolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(contextView);
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(contextView);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(contextView);
        if (compositionContextResolveParentCompositionContext == existingContext.getCompositionContext() && lifecycleOwner == existingContext.getLifecycleOwner() && viewModelStoreOwner == existingContext.getViewModelStoreOwner() && savedStateRegistryOwner == existingContext.getSavedStateRegistryOwner()) {
            return existingContext;
        }
        if (compositionContextResolveParentCompositionContext.getEffectCoroutineContext() != existingContext.getCompositionContext().getEffectCoroutineContext()) {
            disposeComposition();
        }
        if (lifecycleOwner == null) {
            lifecycleOwner = existingContext.getLifecycleOwner();
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (savedStateRegistryOwner == null) {
            savedStateRegistryOwner = existingContext.getSavedStateRegistryOwner();
        }
        ComposeViewContext composeViewContextCopy = existingContext.copy(contextView, compositionContextResolveParentCompositionContext, lifecycleOwner2, savedStateRegistryOwner, viewModelStoreOwner);
        ComposeView_androidKt.setComposeViewContext(contextView, composeViewContextCopy);
        return composeViewContextCopy;
    }

    public final void disposeComposition() {
        View childAt = getChildAt(0);
        AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
        if (androidComposeView != null) {
            androidComposeView.removeConnectionToComposeViewContext();
        }
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (WindowRecomposer_androidKt.getContentChild(this).getParent() == null) {
            getHandler().postAtFrontOfQueue(new Runnable() { // from class: androidx.compose.ui.platform.AbstractComposeView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.attachedToWindow();
                }
            });
        } else {
            attachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachedToWindow() {
        if (isAttachedToWindow()) {
            setPreviousAttachedWindowToken(getWindowToken());
            if (this.composeViewContext == null) {
                AndroidComposeView androidComposeView = null;
                if (getChildCount() != 0) {
                    View childAt = getChildAt(0);
                    if (childAt instanceof AndroidComposeView) {
                        androidComposeView = (AndroidComposeView) childAt;
                    }
                }
                if (androidComposeView != null) {
                    androidComposeView.setComposeViewContext(updateAutoCreatedComposeViewContext(ComposeView_androidKt.findViewTreeComposeViewRoot(this), androidComposeView.getComposeViewContext()));
                }
            }
            if (getShouldCreateCompositionOnAttachedToWindow()) {
                ensureCompositionCreated();
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureCompositionCreated();
        internalOnMeasure$ui(widthMeasureSpec, heightMeasureSpec);
    }

    public void internalOnMeasure$ui(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        internalOnLayout$ui(changed, left, top, right, bottom);
    }

    public void internalOnLayout$ui(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        checkAddView();
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        checkAddView();
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        checkAddView();
        super.addView(child, width, height);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        return super.addViewInLayout(child, index, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkAddView();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }
}
