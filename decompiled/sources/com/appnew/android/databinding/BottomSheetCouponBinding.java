package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetCouponBinding implements ViewBinding {
    public final TextView apply;
    public final TextView cancel;
    public final EditText couponEdt;
    public final RelativeLayout headerRl;
    private final RelativeLayout rootView;
    public final View view;

    private BottomSheetCouponBinding(RelativeLayout rootView, TextView apply, TextView cancel, EditText couponEdt, RelativeLayout headerRl, View view) {
        this.rootView = rootView;
        this.apply = apply;
        this.cancel = cancel;
        this.couponEdt = couponEdt;
        this.headerRl = headerRl;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetCouponBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetCouponBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_coupon, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetCouponBinding bind(View rootView) {
        int i = R.id.apply;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.apply);
        if (textView != null) {
            i = R.id.cancel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel);
            if (textView2 != null) {
                i = R.id.coupon_edt;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.coupon_edt);
                if (editText != null) {
                    i = R.id.header_rl;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.header_rl);
                    if (relativeLayout != null) {
                        i = R.id.view;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                        if (viewFindChildViewById != null) {
                            return new BottomSheetCouponBinding((RelativeLayout) rootView, textView, textView2, editText, relativeLayout, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
