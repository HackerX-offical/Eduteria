package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogChangePasswordCmpltBinding implements ViewBinding {
    public final Button btnSubmit;
    public final TextView msgDialog;
    private final RelativeLayout rootView;
    public final TextView titleDialog;

    private DialogChangePasswordCmpltBinding(RelativeLayout rootView, Button btnSubmit, TextView msgDialog, TextView titleDialog) {
        this.rootView = rootView;
        this.btnSubmit = btnSubmit;
        this.msgDialog = msgDialog;
        this.titleDialog = titleDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogChangePasswordCmpltBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogChangePasswordCmpltBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_change_password_cmplt, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogChangePasswordCmpltBinding bind(View rootView) {
        int i = R.id.btn_submit;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
        if (button != null) {
            i = R.id.msgDialog;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.msgDialog);
            if (textView != null) {
                i = R.id.titleDialog;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                if (textView2 != null) {
                    return new DialogChangePasswordCmpltBinding((RelativeLayout) rootView, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
