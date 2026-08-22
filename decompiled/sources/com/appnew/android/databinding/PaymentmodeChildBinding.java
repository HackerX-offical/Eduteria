package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PaymentmodeChildBinding implements ViewBinding {
    public final RadioButton rbMode;
    private final ConstraintLayout rootView;

    private PaymentmodeChildBinding(ConstraintLayout rootView, RadioButton rbMode) {
        this.rootView = rootView;
        this.rbMode = rbMode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PaymentmodeChildBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PaymentmodeChildBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.paymentmode_child, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PaymentmodeChildBinding bind(View rootView) {
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_mode);
        if (radioButton != null) {
            return new PaymentmodeChildBinding((ConstraintLayout) rootView, radioButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.rb_mode)));
    }
}
