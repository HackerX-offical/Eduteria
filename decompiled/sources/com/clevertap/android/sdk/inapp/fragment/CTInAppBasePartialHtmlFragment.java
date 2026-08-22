package com.clevertap.android.sdk.inapp.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.amazonaws.services.s3.util.Mimetypes;
import com.clevertap.android.sdk.CTWebInterface;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inapp.CTInAppAction;
import com.clevertap.android.sdk.inapp.CTInAppWebView;
import com.clevertap.android.sdk.inapp.InAppWebViewClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: CTInAppBasePartialHtmlFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002'(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010!\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0013H\u0002J\u001c\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0003J\b\u0010&\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialHtmlFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialFragment;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnLongClickListener;", "<init>", "()V", "gd", "Landroid/view/GestureDetector;", "webView", "Lcom/clevertap/android/sdk/inapp/CTInAppWebView;", "getLayout", "Landroid/view/ViewGroup;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getView", "inflater", "Landroid/view/LayoutInflater;", "container", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLongClick", "", "v", "onTouch", "event", "Landroid/view/MotionEvent;", "cleanupWebView", "displayHTMLView", "reDrawInApp", "GestureListener", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CTInAppBasePartialHtmlFragment extends CTInAppBasePartialFragment implements View.OnTouchListener, View.OnLongClickListener {
    private static final String CTA_SWIPE_DISMISS = "swipe-dismiss";
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gd;
    private CTInAppWebView webView;

    public abstract ViewGroup getLayout(View view);

    public abstract View getView(LayoutInflater inflater, ViewGroup container);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        return true;
    }

    /* JADX INFO: compiled from: CTInAppBasePartialHtmlFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialHtmlFragment$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialHtmlFragment;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "remove", "ltr", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (e1 != null) {
                if (e1.getX() - e2.getX() > 120.0f && Math.abs(velocityX) > 200.0d) {
                    return remove(false);
                }
                if (e2.getX() - e1.getX() > 120.0f && Math.abs(velocityX) > 200.0d) {
                    return remove(true);
                }
            }
            return false;
        }

        public final boolean remove(boolean ltr) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (ltr) {
                translateAnimation = new TranslateAnimation(0.0f, CTInAppBasePartialHtmlFragment.this.getScaledPixels(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, -CTInAppBasePartialHtmlFragment.this.getScaledPixels(50), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300L);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            final CTInAppBasePartialHtmlFragment cTInAppBasePartialHtmlFragment = CTInAppBasePartialHtmlFragment.this;
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppBasePartialHtmlFragment$GestureListener$remove$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    cTInAppBasePartialHtmlFragment.triggerAction(CTInAppAction.INSTANCE.createCloseAction(), "swipe-dismiss", null);
                }
            });
            CTInAppWebView cTInAppWebView = CTInAppBasePartialHtmlFragment.this.webView;
            if (cTInAppWebView != null) {
                cTInAppWebView.startAnimation(animationSet);
            }
            return true;
        }
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.gd = new GestureDetector(context, new GestureListener());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return displayHTMLView(inflater, container);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        cleanupWebView();
        super.onDestroyView();
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        reDrawInApp();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        reDrawInApp();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GestureDetector gestureDetector = this.gd;
        if (gestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gd");
            gestureDetector = null;
        }
        return gestureDetector.onTouchEvent(event) || event.getAction() == 2;
    }

    private final void cleanupWebView() {
        try {
            CTInAppWebView cTInAppWebView = this.webView;
            if (cTInAppWebView != null) {
                cTInAppWebView.cleanup(getInAppNotification().getIsJsEnabled());
            }
            this.webView = null;
        } catch (Exception e2) {
            getConfig().getLogger().verbose("cleanupWebView -> there was a crash in cleanup", e2);
        }
    }

    private final View displayHTMLView(LayoutInflater inflater, ViewGroup container) {
        try {
            View view = getView(inflater, container);
            ViewGroup layout = getLayout(view);
            Context context = inflater.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            CTInAppWebView cTInAppWebView = new CTInAppWebView(context, getInAppNotification().getWidth(), getInAppNotification().getHeight(), getInAppNotification().getWidthPercentage(), getInAppNotification().getHeightPercentage(), getInAppNotification().getAspectRatio());
            this.webView = cTInAppWebView;
            cTInAppWebView.setWebViewClient(new InAppWebViewClient(this));
            cTInAppWebView.setOnTouchListener(this);
            cTInAppWebView.setOnLongClickListener(this);
            if (getInAppNotification().getIsJsEnabled()) {
                cTInAppWebView.setJavaScriptInterface(new CTWebInterface(CleverTapAPI.instanceWithConfig(getActivity(), getConfig()), this));
            }
            if (layout != null) {
                layout.addView(cTInAppWebView);
            }
            return view;
        } catch (Throwable th) {
            getConfig().getLogger().verbose(getConfig().getAccountId(), "Fragment view not created", th);
            return null;
        }
    }

    private final void reDrawInApp() {
        CTInAppWebView cTInAppWebView = this.webView;
        if (cTInAppWebView == null) {
            return;
        }
        cTInAppWebView.updateDimension();
        int i = cTInAppWebView.dim.y;
        int i2 = cTInAppWebView.dim.x;
        float f2 = getResources().getDisplayMetrics().density;
        int i3 = (int) (i / f2);
        int i4 = (int) (i2 / f2);
        String html = getInAppNotification().getHtml();
        if (html == null) {
            return;
        }
        String strReplaceFirst = new Regex("<head>").replaceFirst(html, "<head>" + ("<style>body{width: " + i4 + "px; height: " + i3 + "px; margin: 0; padding:0;}</style>"));
        Logger.v("Density appears to be " + f2);
        cTInAppWebView.setInitialScale((int) (f2 * 100));
        cTInAppWebView.loadDataWithBaseURL(null, strReplaceFirst, Mimetypes.MIMETYPE_HTML, "utf-8", null);
    }
}
