package androidx.compose.ui.platform;

import android.view.ViewGroup;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Wrapper.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"createApplier", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "container", "setContent", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/ui/platform/AbstractComposeView;", "composeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/ui/platform/ComposeViewContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final AbstractApplier<LayoutNode> createApplier(LayoutNode layoutNode) {
        return new UiApplier(layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.runtime.Composition setContent(androidx.compose.ui.platform.AbstractComposeView r4, androidx.compose.ui.platform.ComposeViewContext r5, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r6) {
        /*
            androidx.compose.ui.platform.GlobalSnapshotManager r0 = androidx.compose.ui.platform.GlobalSnapshotManager.INSTANCE
            r0.ensureStarted()
            int r0 = r4.getChildCount()
            r1 = 0
            if (r0 <= 0) goto L1f
            r0 = 0
            android.view.View r0 = r4.getChildAt(r0)
            boolean r2 = r0 instanceof androidx.compose.ui.platform.AndroidComposeView
            if (r2 == 0) goto L18
            androidx.compose.ui.platform.AndroidComposeView r0 = (androidx.compose.ui.platform.AndroidComposeView) r0
            goto L19
        L18:
            r0 = r1
        L19:
            if (r0 == 0) goto L22
            r0.setComposeViewContext(r5)
            goto L23
        L1f:
            r4.removeAllViews()
        L22:
            r0 = r1
        L23:
            if (r0 != 0) goto L37
            androidx.compose.ui.platform.AndroidComposeView r0 = new androidx.compose.ui.platform.AndroidComposeView
            android.content.Context r2 = r4.getContext()
            r0.<init>(r2, r5)
            android.view.View r2 = r0.getView()
            android.view.ViewGroup$LayoutParams r3 = androidx.compose.ui.platform.Wrapper_androidKt.DefaultLayoutParams
            r4.addView(r2, r3)
        L37:
            r0.setComposeViewContext(r5)
            androidx.compose.ui.platform.ComposeViewContext r4 = r4.getComposeViewContext()
            if (r4 == 0) goto L47
            r5.incrementViewCount$ui()
            r4 = 1
            r0.setComposeViewContextIncrementedDuringInit$ui(r4)
        L47:
            boolean r4 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r4 == 0) goto L65
            int r4 = androidx.compose.ui.R.id.inspection_slot_table_set
            java.lang.Object r4 = r0.getTag(r4)
            if (r4 != 0) goto L65
            int r4 = androidx.compose.ui.R.id.inspection_slot_table_set
            java.util.WeakHashMap r2 = new java.util.WeakHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r2 = java.util.Collections.newSetFromMap(r2)
            r0.setTag(r4, r2)
        L65:
            int r4 = androidx.compose.ui.R.id.wrapped_composition_tag
            java.lang.Object r4 = r0.getTag(r4)
            boolean r2 = r4 instanceof androidx.compose.ui.platform.WrappedComposition
            if (r2 == 0) goto L72
            r1 = r4
            androidx.compose.ui.platform.WrappedComposition r1 = (androidx.compose.ui.platform.WrappedComposition) r1
        L72:
            if (r1 != 0) goto L91
            androidx.compose.ui.platform.WrappedComposition r1 = new androidx.compose.ui.platform.WrappedComposition
            androidx.compose.ui.node.UiApplier r4 = new androidx.compose.ui.node.UiApplier
            androidx.compose.ui.node.LayoutNode r2 = r0.getRoot()
            r4.<init>(r2)
            androidx.compose.runtime.Applier r4 = (androidx.compose.runtime.Applier) r4
            androidx.compose.runtime.CompositionContext r2 = r5.getCompositionContext()
            androidx.compose.runtime.Composition r4 = androidx.compose.runtime.CompositionKt.Composition(r4, r2)
            r1.<init>(r0, r4)
            int r4 = androidx.compose.ui.R.id.wrapped_composition_tag
            r0.setTag(r4, r1)
        L91:
            r1.setContent(r6)
            androidx.compose.runtime.CompositionContext r4 = r5.getCompositionContext()
            androidx.compose.ui.platform.Wrapper_androidKt$setContent$1 r5 = new androidx.compose.ui.platform.Wrapper_androidKt$setContent$1
            r5.<init>(r4)
            androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner$FrameEndScheduler r5 = (androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner.FrameEndScheduler) r5
            r0.setFrameEndScheduler$ui(r5)
            androidx.compose.runtime.Composition r1 = (androidx.compose.runtime.Composition) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.Wrapper_androidKt.setContent(androidx.compose.ui.platform.AbstractComposeView, androidx.compose.ui.platform.ComposeViewContext, kotlin.jvm.functions.Function2):androidx.compose.runtime.Composition");
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.Wrapper_androidKt$setContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: Wrapper.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 implements LifecycleRetainedValuesStoreOwner.FrameEndScheduler, FunctionAdapter {
        final /* synthetic */ CompositionContext $tmp0;

        AnonymousClass1(CompositionContext compositionContext) {
            this.$tmp0 = compositionContext;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof LifecycleRetainedValuesStoreOwner.FrameEndScheduler) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.$tmp0, CompositionContext.class, "scheduleFrameEndCallback", "scheduleFrameEndCallback(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner.FrameEndScheduler
        public final CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
            return this.$tmp0.scheduleFrameEndCallback(function0);
        }
    }
}
