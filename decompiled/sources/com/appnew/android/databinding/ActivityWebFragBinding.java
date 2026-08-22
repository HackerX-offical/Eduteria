package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;
import com.wang.avi.AVLoadingIndicatorView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityWebFragBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final ImageView imageIV;
    public final ImageView ivBack;
    public final Toolbar myProgressToolbar;
    private final RelativeLayout rootView;
    public final AVLoadingIndicatorView testLoader;
    public final TextView toolbartitleTV;
    public final WebView webView;
    public final FrameLayout webframe;

    private ActivityWebFragBinding(RelativeLayout rootView, AppBarLayout appBarLayout, ImageView imageIV, ImageView ivBack, Toolbar myProgressToolbar, AVLoadingIndicatorView testLoader, TextView toolbartitleTV, WebView webView, FrameLayout webframe) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.imageIV = imageIV;
        this.ivBack = ivBack;
        this.myProgressToolbar = myProgressToolbar;
        this.testLoader = testLoader;
        this.toolbartitleTV = toolbartitleTV;
        this.webView = webView;
        this.webframe = webframe;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWebFragBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityWebFragBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_web_frag, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWebFragBinding bind(View rootView) {
        int i = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i = R.id.imageIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
            if (imageView != null) {
                i = R.id.iv_back;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                if (imageView2 != null) {
                    i = R.id.myProgress_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.myProgress_toolbar);
                    if (toolbar != null) {
                        i = R.id.testLoader;
                        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(rootView, R.id.testLoader);
                        if (aVLoadingIndicatorView != null) {
                            i = R.id.toolbartitleTV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                            if (textView != null) {
                                i = R.id.webView;
                                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webView);
                                if (webView != null) {
                                    i = R.id.webframe;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.webframe);
                                    if (frameLayout != null) {
                                        return new ActivityWebFragBinding((RelativeLayout) rootView, appBarLayout, imageView, imageView2, toolbar, aVLoadingIndicatorView, textView, webView, frameLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
