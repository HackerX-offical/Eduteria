package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogChoosePaymentGatewayBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    private final RelativeLayout rootView;
    public final RecyclerView rvPaymentMode;

    private DialogChoosePaymentGatewayBinding(RelativeLayout rootView, Button btnCancel, Button btnSubmit, RecyclerView rvPaymentMode) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.rvPaymentMode = rvPaymentMode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogChoosePaymentGatewayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogChoosePaymentGatewayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_choose_payment_gateway, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogChoosePaymentGatewayBinding bind(View rootView) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_submit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
            if (button2 != null) {
                i = R.id.rv_paymentMode;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rv_paymentMode);
                if (recyclerView != null) {
                    return new DialogChoosePaymentGatewayBinding((RelativeLayout) rootView, button, button2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
