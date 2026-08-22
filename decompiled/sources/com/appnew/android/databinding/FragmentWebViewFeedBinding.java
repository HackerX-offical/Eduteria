package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentWebViewFeedBinding implements ViewBinding {
    public final ImageView backBtn;
    private final RelativeLayout rootView;
    public final RelativeLayout toolbar;
    public final WebView webView;

    private FragmentWebViewFeedBinding(RelativeLayout rootView, ImageView backBtn, RelativeLayout toolbar, WebView webView) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.toolbar = toolbar;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWebViewFeedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentWebViewFeedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_web_view_feed, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentWebViewFeedBinding bind(View rootView) {
        int i = R.id.backBtn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (imageView != null) {
            i = R.id.toolbar;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.toolbar);
            if (relativeLayout != null) {
                i = R.id.webView;
                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webView);
                if (webView != null) {
                    return new FragmentWebViewFeedBinding((RelativeLayout) rootView, imageView, relativeLayout, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
