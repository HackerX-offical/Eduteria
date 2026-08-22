package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EmailVerifyDialogBinding implements ViewBinding {
    public final EditText OPT1ET;
    public final EditText OPT2ET;
    public final EditText OPT3ET;
    public final EditText OPT4ET;
    public final EditText OPT5ET;
    public final EditText OPT6ET;
    public final Button btnCancel;
    public final Button btnSubmit;
    public final WebView msgDialog;
    private final RelativeLayout rootView;
    public final TextView titleDialog;

    private EmailVerifyDialogBinding(RelativeLayout rootView, EditText OPT1ET, EditText OPT2ET, EditText OPT3ET, EditText OPT4ET, EditText OPT5ET, EditText OPT6ET, Button btnCancel, Button btnSubmit, WebView msgDialog, TextView titleDialog) {
        this.rootView = rootView;
        this.OPT1ET = OPT1ET;
        this.OPT2ET = OPT2ET;
        this.OPT3ET = OPT3ET;
        this.OPT4ET = OPT4ET;
        this.OPT5ET = OPT5ET;
        this.OPT6ET = OPT6ET;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.msgDialog = msgDialog;
        this.titleDialog = titleDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EmailVerifyDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EmailVerifyDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.email_verify_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EmailVerifyDialogBinding bind(View rootView) {
        int i = R.id.OPT1ET;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT1ET);
        if (editText != null) {
            i = R.id.OPT2ET;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT2ET);
            if (editText2 != null) {
                i = R.id.OPT3ET;
                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT3ET);
                if (editText3 != null) {
                    i = R.id.OPT4ET;
                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT4ET);
                    if (editText4 != null) {
                        i = R.id.OPT5ET;
                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT5ET);
                        if (editText5 != null) {
                            i = R.id.OPT6ET;
                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT6ET);
                            if (editText6 != null) {
                                i = R.id.btn_cancel;
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
                                                return new EmailVerifyDialogBinding((RelativeLayout) rootView, editText, editText2, editText3, editText4, editText5, editText6, button, button2, webView, textView);
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
