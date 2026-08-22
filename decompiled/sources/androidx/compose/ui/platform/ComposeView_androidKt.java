package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.AndroidComposeUiFlags;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.runtime.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeView.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\nH\u0002\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\nH\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"2\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8@@@X\u0080\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"areWindowInsetsRulersEnabled", "", "getAreWindowInsetsRulersEnabled", "()Z", "setAreWindowInsetsRulersEnabled", "(Z)V", "disableWindowInsetsRulers", "", "Landroidx/compose/ui/platform/ComposeView$Companion;", "findViewTreeComposeViewRoot", "Landroid/view/View;", "findDepthToTag", "", "tag", "findViewTreeComposeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", "value", "composeViewContext", "getComposeViewContext$annotations", "(Landroid/view/View;)V", "getComposeViewContext", "(Landroid/view/View;)Landroidx/compose/ui/platform/ComposeViewContext;", "setComposeViewContext", "(Landroid/view/View;Landroidx/compose/ui/platform/ComposeViewContext;)V", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ComposeView_androidKt {
    private static boolean areWindowInsetsRulersEnabled = true;

    public static /* synthetic */ void getComposeViewContext$annotations(View view) {
    }

    public static final boolean getAreWindowInsetsRulersEnabled() {
        return areWindowInsetsRulersEnabled;
    }

    public static final void setAreWindowInsetsRulersEnabled(boolean z) {
        areWindowInsetsRulersEnabled = z;
    }

    public static final void disableWindowInsetsRulers(ComposeView.Companion companion) {
        areWindowInsetsRulersEnabled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View findViewTreeComposeViewRoot(View view) {
        if (!view.isAttachedToWindow() || !AndroidComposeUiFlags.isSharedComposeViewContextEnabled) {
            return view;
        }
        int iMin = Math.min(findDepthToTag(view, R.id.view_tree_lifecycle_owner), findDepthToTag(view, androidx.savedstate.R.id.view_tree_saved_state_registry_owner));
        View view2 = view;
        int i = 0;
        View view3 = view2;
        while (view != null) {
            if (i == iMin) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return view2;
                }
            } else if (getComposeViewContext(view) == null) {
                i++;
                Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
                View view4 = view2;
                view2 = view;
                view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
                view3 = view4;
            }
            return view;
        }
        return view3;
    }

    private static final int findDepthToTag(View view, int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        Object obj = null;
        while (view != null) {
            Object tag = view.getTag(i);
            if (tag != null) {
                if (obj != null) {
                    if (!Intrinsics.areEqual(tag, obj)) {
                        break;
                    }
                } else {
                    obj = tag;
                }
                i3 = i2;
            }
            i2++;
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return i3;
    }

    public static final ComposeViewContext findViewTreeComposeViewContext(View view) {
        return getComposeViewContext(findViewTreeComposeViewRoot(view));
    }

    public static final ComposeViewContext getComposeViewContext(View view) {
        Object tag = view.getTag(androidx.compose.ui.R.id.androidx_compose_ui_view_compose_view_context);
        WeakReference weakReference = tag instanceof WeakReference ? (WeakReference) tag : null;
        if (weakReference != null) {
            return (ComposeViewContext) weakReference.get();
        }
        return null;
    }

    public static final void setComposeViewContext(View view, ComposeViewContext composeViewContext) {
        view.setTag(androidx.compose.ui.R.id.androidx_compose_ui_view_compose_view_context, new WeakReference(composeViewContext));
    }
}
