package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.jorgecastilloprz.FABProgressCircle;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySearchvideoRevisionBinding implements ViewBinding {
    public final FloatingActionButton addWeblink;
    public final FABProgressCircle fabProgressCircle;
    public final ImageView ivBack;
    private final RelativeLayout rootView;
    public final TextView toolbartitleTV;
    public final ProgressBar webresourceloader;
    public final Toolbar webresourcetoolbar;
    public final RelativeLayout webresourceviewlayout;
    public final WebView webresourcewebview;

    private ActivitySearchvideoRevisionBinding(RelativeLayout rootView, FloatingActionButton addWeblink, FABProgressCircle fabProgressCircle, ImageView ivBack, TextView toolbartitleTV, ProgressBar webresourceloader, Toolbar webresourcetoolbar, RelativeLayout webresourceviewlayout, WebView webresourcewebview) {
        this.rootView = rootView;
        this.addWeblink = addWeblink;
        this.fabProgressCircle = fabProgressCircle;
        this.ivBack = ivBack;
        this.toolbartitleTV = toolbartitleTV;
        this.webresourceloader = webresourceloader;
        this.webresourcetoolbar = webresourcetoolbar;
        this.webresourceviewlayout = webresourceviewlayout;
        this.webresourcewebview = webresourcewebview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchvideoRevisionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySearchvideoRevisionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_searchvideo_revision, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySearchvideoRevisionBinding bind(View rootView) {
        int i = R.id.add_weblink;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.add_weblink);
        if (floatingActionButton != null) {
            i = R.id.fabProgressCircle;
            FABProgressCircle fABProgressCircle = (FABProgressCircle) ViewBindings.findChildViewById(rootView, R.id.fabProgressCircle);
            if (fABProgressCircle != null) {
                i = R.id.iv_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                if (imageView != null) {
                    i = R.id.toolbartitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                    if (textView != null) {
                        i = R.id.webresourceloader;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.webresourceloader);
                        if (progressBar != null) {
                            i = R.id.webresourcetoolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.webresourcetoolbar);
                            if (toolbar != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                i = R.id.webresourcewebview;
                                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webresourcewebview);
                                if (webView != null) {
                                    return new ActivitySearchvideoRevisionBinding(relativeLayout, floatingActionButton, fABProgressCircle, imageView, textView, progressBar, toolbar, relativeLayout, webView);
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
