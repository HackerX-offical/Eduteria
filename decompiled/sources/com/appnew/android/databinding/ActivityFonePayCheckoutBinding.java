package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFonePayCheckoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final WebView webview;

    private ActivityFonePayCheckoutBinding(ConstraintLayout rootView, WebView webview) {
        this.rootView = rootView;
        this.webview = webview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFonePayCheckoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFonePayCheckoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_fone_pay_checkout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFonePayCheckoutBinding bind(View rootView) {
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webview);
        if (webView != null) {
            return new ActivityFonePayCheckoutBinding((ConstraintLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.webview)));
    }
}
