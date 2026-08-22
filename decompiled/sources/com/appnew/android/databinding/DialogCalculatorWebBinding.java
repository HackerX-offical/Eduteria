package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCalculatorWebBinding implements ViewBinding {
    public final AppCompatButton btnClose;
    public final RelativeLayout calcpagerl;
    public final WebView calcwebView;
    private final RelativeLayout rootView;

    private DialogCalculatorWebBinding(RelativeLayout rootView, AppCompatButton btnClose, RelativeLayout calcpagerl, WebView calcwebView) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.calcpagerl = calcpagerl;
        this.calcwebView = calcwebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogCalculatorWebBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogCalculatorWebBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_calculator_web, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogCalculatorWebBinding bind(View rootView) {
        int i = R.id.btn_close;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, R.id.btn_close);
        if (appCompatButton != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.calcwebView);
            if (webView != null) {
                return new DialogCalculatorWebBinding(relativeLayout, appCompatButton, relativeLayout, webView);
            }
            i = R.id.calcwebView;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
