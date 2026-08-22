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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityPdfviewerJsBinding implements ViewBinding {
    public final TextView delete;
    public final ImageView imageBack;
    public final ConstraintLayout main;
    public final Toolbar mainToolbar;
    public final Button procceedBtn;
    public final RelativeLayout relativeLayout2;
    private final ConstraintLayout rootView;
    public final CheckBox selectAllDelete;
    public final FloatingActionButton shareFloatingActionButton;
    public final TextView toolbarTitleTV;
    public final WebView webView;

    private ActivityPdfviewerJsBinding(ConstraintLayout rootView, TextView delete, ImageView imageBack, ConstraintLayout main, Toolbar mainToolbar, Button procceedBtn, RelativeLayout relativeLayout2, CheckBox selectAllDelete, FloatingActionButton shareFloatingActionButton, TextView toolbarTitleTV, WebView webView) {
        this.rootView = rootView;
        this.delete = delete;
        this.imageBack = imageBack;
        this.main = main;
        this.mainToolbar = mainToolbar;
        this.procceedBtn = procceedBtn;
        this.relativeLayout2 = relativeLayout2;
        this.selectAllDelete = selectAllDelete;
        this.shareFloatingActionButton = shareFloatingActionButton;
        this.toolbarTitleTV = toolbarTitleTV;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPdfviewerJsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPdfviewerJsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pdfviewer_js, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPdfviewerJsBinding bind(View rootView) {
        int i = R.id.delete;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
        if (textView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.procceed_btn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.procceed_btn);
                    if (button != null) {
                        i = R.id.relativeLayout2;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout2);
                        if (relativeLayout != null) {
                            i = R.id.select_all_delete;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                            if (checkBox != null) {
                                i = R.id.shareFloatingActionButton;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.shareFloatingActionButton);
                                if (floatingActionButton != null) {
                                    i = R.id.toolbarTitleTV;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                    if (textView2 != null) {
                                        i = R.id.webView;
                                        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webView);
                                        if (webView != null) {
                                            return new ActivityPdfviewerJsBinding(constraintLayout, textView, imageView, constraintLayout, toolbar, button, relativeLayout, checkBox, floatingActionButton, textView2, webView);
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
