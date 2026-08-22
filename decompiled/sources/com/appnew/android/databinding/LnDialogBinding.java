package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LnDialogBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final WebView webkitWebView1;

    private LnDialogBinding(RelativeLayout rootView, ProgressBar progressBar, WebView webkitWebView1) {
        this.rootView = rootView;
        this.progressBar = progressBar;
        this.webkitWebView1 = webkitWebView1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LnDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LnDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ln_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LnDialogBinding bind(View rootView) {
        int i = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
        if (progressBar != null) {
            i = R.id.webkitWebView1;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webkitWebView1);
            if (webView != null) {
                return new LnDialogBinding((RelativeLayout) rootView, progressBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
