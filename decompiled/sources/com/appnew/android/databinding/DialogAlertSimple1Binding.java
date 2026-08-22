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
public final class DialogAlertSimple1Binding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final TextView msgDialog;
    private final RelativeLayout rootView;
    public final TextView titleDialog;

    private DialogAlertSimple1Binding(RelativeLayout rootView, Button btnCancel, Button btnSubmit, TextView msgDialog, TextView titleDialog) {
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

    public static DialogAlertSimple1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogAlertSimple1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_alert_simple_1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogAlertSimple1Binding bind(View rootView) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_submit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
            if (button2 != null) {
                i = R.id.msgDialog;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.msgDialog);
                if (textView != null) {
                    i = R.id.titleDialog;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                    if (textView2 != null) {
                        return new DialogAlertSimple1Binding((RelativeLayout) rootView, button, button2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
