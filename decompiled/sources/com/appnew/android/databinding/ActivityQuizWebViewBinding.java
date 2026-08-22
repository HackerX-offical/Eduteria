package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityQuizWebViewBinding implements ViewBinding {
    public final TextView errorTV;
    private final RelativeLayout rootView;
    public final MainAppbarBinding toolbar0;
    public final WebView webView;

    private ActivityQuizWebViewBinding(RelativeLayout rootView, TextView errorTV, MainAppbarBinding toolbar0, WebView webView) {
        this.rootView = rootView;
        this.errorTV = errorTV;
        this.toolbar0 = toolbar0;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQuizWebViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityQuizWebViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_quiz_web_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityQuizWebViewBinding bind(View rootView) {
        int i = R.id.errorTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTV);
        if (textView != null) {
            i = R.id.toolbar0;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.toolbar0);
            if (viewFindChildViewById != null) {
                MainAppbarBinding mainAppbarBindingBind = MainAppbarBinding.bind(viewFindChildViewById);
                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webView);
                if (webView != null) {
                    return new ActivityQuizWebViewBinding((RelativeLayout) rootView, textView, mainAppbarBindingBind, webView);
                }
                i = R.id.webView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
