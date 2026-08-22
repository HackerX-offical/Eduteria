package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class WebviewHtmlActivityBinding implements ViewBinding {
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;
    public final WebView webresourcewebview;

    private WebviewHtmlActivityBinding(RelativeLayout rootView, TextView delete, ImageView imageBack, Toolbar mainToolbar, RelativeLayout root, CheckBox selectAllDelete, TextView toolbarTitleTV, WebView webresourcewebview) {
        this.rootView = rootView;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.root = root;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
        this.webresourcewebview = webresourcewebview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WebviewHtmlActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WebviewHtmlActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.webview_html_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WebviewHtmlActivityBinding bind(View rootView) {
        int i = R.id.delete;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
        if (textView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.select_all_delete;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                    if (checkBox != null) {
                        i = R.id.toolbarTitleTV;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                        if (textView2 != null) {
                            i = R.id.webresourcewebview;
                            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webresourcewebview);
                            if (webView != null) {
                                return new WebviewHtmlActivityBinding(relativeLayout, textView, imageView, toolbar, relativeLayout, checkBox, textView2, webView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
