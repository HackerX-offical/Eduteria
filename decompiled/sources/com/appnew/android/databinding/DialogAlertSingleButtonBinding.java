package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogAlertSingleButtonBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final WebView msgDialog;
    private final RelativeLayout rootView;
    public final TextView titleDialog;

    private DialogAlertSingleButtonBinding(RelativeLayout rootView, Button btnCancel, Button btnSubmit, WebView msgDialog, TextView titleDialog) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.msgDialog = msgDialog;
        this.titleDialog = titleDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogAlertSingleButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogAlertSingleButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_alert_single_button, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogAlertSingleButtonBinding bind(View rootView) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_submit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
            if (button2 != null) {
                i = R.id.msgDialog;
                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.msgDialog);
                if (webView != null) {
                    i = R.id.titleDialog;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                    if (textView != null) {
                        return new DialogAlertSingleButtonBinding((RelativeLayout) rootView, button, button2, webView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
