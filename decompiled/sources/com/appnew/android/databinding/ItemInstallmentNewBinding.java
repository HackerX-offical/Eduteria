package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemInstallmentNewBinding implements ViewBinding {
    public final RadioButton radioButton;
    private final LinearLayoutCompat rootView;
    public final TextView viewButton;

    private ItemInstallmentNewBinding(LinearLayoutCompat rootView, RadioButton radioButton, TextView viewButton) {
        this.rootView = rootView;
        this.radioButton = radioButton;
        this.viewButton = viewButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemInstallmentNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemInstallmentNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_installment_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemInstallmentNewBinding bind(View rootView) {
        int i = R.id.radio_button;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.radio_button);
        if (radioButton != null) {
            i = R.id.viewButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewButton);
            if (textView != null) {
                return new ItemInstallmentNewBinding((LinearLayoutCompat) rootView, radioButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
