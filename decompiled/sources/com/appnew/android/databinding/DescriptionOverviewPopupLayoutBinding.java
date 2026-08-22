package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DescriptionOverviewPopupLayoutBinding implements ViewBinding {
    public final WebView descWebView;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final LinearLayout rootView;
    public final TextView toolbarTitleTV;

    private DescriptionOverviewPopupLayoutBinding(LinearLayout rootView, WebView descWebView, ImageView imageBack, Toolbar mainToolbar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.descWebView = descWebView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DescriptionOverviewPopupLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DescriptionOverviewPopupLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.description_overview_popup_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DescriptionOverviewPopupLayoutBinding bind(View rootView) {
        int i = R.id.desc_webView;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.desc_webView);
        if (webView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new DescriptionOverviewPopupLayoutBinding((LinearLayout) rootView, webView, imageView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
