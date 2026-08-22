package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogInstallmentBroucherBinding implements ViewBinding {
    public final ImageView backBtn;
    public final RecyclerView installmentRecyclerView;
    private final LinearLayoutCompat rootView;
    public final TextView titleTxt;

    private DialogInstallmentBroucherBinding(LinearLayoutCompat rootView, ImageView backBtn, RecyclerView installmentRecyclerView, TextView titleTxt) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.installmentRecyclerView = installmentRecyclerView;
        this.titleTxt = titleTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static DialogInstallmentBroucherBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogInstallmentBroucherBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_installment_broucher, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogInstallmentBroucherBinding bind(View rootView) {
        int i = R.id.backBtn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (imageView != null) {
            i = R.id.installmentRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.installmentRecyclerView);
            if (recyclerView != null) {
                i = R.id.titleTxt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleTxt);
                if (textView != null) {
                    return new DialogInstallmentBroucherBinding((LinearLayoutCompat) rootView, imageView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
