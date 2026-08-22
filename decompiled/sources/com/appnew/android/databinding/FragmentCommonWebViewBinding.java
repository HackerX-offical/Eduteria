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
public final class FragmentCommonWebViewBinding implements ViewBinding {
    public final ImageView ivBack;
    private final RelativeLayout rootView;
    public final WebView webView;

    private FragmentCommonWebViewBinding(RelativeLayout rootView, ImageView ivBack, WebView webView) {
        this.rootView = rootView;
        this.ivBack = ivBack;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCommonWebViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCommonWebViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_common_web_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCommonWebViewBinding bind(View rootView) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
        if (imageView != null) {
            i = R.id.web_view;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.web_view);
            if (webView != null) {
                return new FragmentCommonWebViewBinding((RelativeLayout) rootView, imageView, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
