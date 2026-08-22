package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomPdfListBinding implements ViewBinding {
    public final CardView cartItemDetail;
    public final TextView downloadPdfName;
    private final RelativeLayout rootView;

    private CustomPdfListBinding(RelativeLayout rootView, CardView cartItemDetail, TextView downloadPdfName) {
        this.rootView = rootView;
        this.cartItemDetail = cartItemDetail;
        this.downloadPdfName = downloadPdfName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomPdfListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomPdfListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_pdf_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomPdfListBinding bind(View rootView) {
        int i = R.id.cartItem_detail;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cartItem_detail);
        if (cardView != null) {
            i = R.id.download_pdf_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.download_pdf_name);
            if (textView != null) {
                return new CustomPdfListBinding((RelativeLayout) rootView, cardView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
