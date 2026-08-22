package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCommonWebViewNewBinding implements ViewBinding {
    public final ImageView cancelBox;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final ImageView viewTop;
    public final WebView webView;

    private FragmentCommonWebViewNewBinding(RelativeLayout rootView, ImageView cancelBox, ProgressBar progressBar, ImageView viewTop, WebView webView) {
        this.rootView = rootView;
        this.cancelBox = cancelBox;
        this.progressBar = progressBar;
        this.viewTop = viewTop;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCommonWebViewNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCommonWebViewNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_common_web_view_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCommonWebViewNewBinding bind(View rootView) {
        int i = R.id.cancelBox;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelBox);
        if (imageView != null) {
            i = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
            if (progressBar != null) {
                i = R.id.viewTop;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.viewTop);
                if (imageView2 != null) {
                    i = R.id.web_view;
                    WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.web_view);
                    if (webView != null) {
                        return new FragmentCommonWebViewNewBinding((RelativeLayout) rootView, imageView, progressBar, imageView2, webView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
