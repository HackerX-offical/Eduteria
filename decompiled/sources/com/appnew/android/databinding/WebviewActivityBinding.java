package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class WebviewActivityBinding implements ViewBinding {
    public final RelativeLayout RL;
    public final TextView SavePdf;
    public final TextView delete;
    public final ImageView downloadPdf;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final Button procceedBtn;
    public final ImageView refreshPage;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final ImageView searchPDF;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;
    public final WebView webresourcewebview;

    private WebviewActivityBinding(RelativeLayout rootView, RelativeLayout RL, TextView SavePdf, TextView delete, ImageView downloadPdf, ImageView imageBack, Toolbar mainToolbar, Button procceedBtn, ImageView refreshPage, RelativeLayout root, ImageView searchPDF, CheckBox selectAllDelete, TextView toolbarTitleTV, WebView webresourcewebview) {
        this.rootView = rootView;
        this.RL = RL;
        this.SavePdf = SavePdf;
        this.delete = delete;
        this.downloadPdf = downloadPdf;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.procceedBtn = procceedBtn;
        this.refreshPage = refreshPage;
        this.root = root;
        this.searchPDF = searchPDF;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
        this.webresourcewebview = webresourcewebview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WebviewActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WebviewActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.webview_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WebviewActivityBinding bind(View rootView) {
        int i = R.id.RL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL);
        if (relativeLayout != null) {
            i = R.id.Save_pdf;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Save_pdf);
            if (textView != null) {
                i = R.id.delete;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView2 != null) {
                    i = R.id.download_pdf;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.download_pdf);
                    if (imageView != null) {
                        i = R.id.image_back;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                        if (imageView2 != null) {
                            i = R.id.main_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                            if (toolbar != null) {
                                i = R.id.procceed_btn;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.procceed_btn);
                                if (button != null) {
                                    i = R.id.refresh_page;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refresh_page);
                                    if (imageView3 != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                        i = R.id.searchPDF;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchPDF);
                                        if (imageView4 != null) {
                                            i = R.id.select_all_delete;
                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                            if (checkBox != null) {
                                                i = R.id.toolbarTitleTV;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                if (textView3 != null) {
                                                    i = R.id.webresourcewebview;
                                                    WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webresourcewebview);
                                                    if (webView != null) {
                                                        return new WebviewActivityBinding(relativeLayout2, relativeLayout, textView, textView2, imageView, imageView2, toolbar, button, imageView3, relativeLayout2, imageView4, checkBox, textView3, webView);
                                                    }
                                                }
                                            }
                                        }
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
