package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutBuyButtonBinding implements ViewBinding {
    public final RelativeLayout buttonLow;
    public final Button buyNowBtn;
    public final LinearLayout linearAddToCart;
    public final TextView mrpCutTV;
    public final Button myLibBtn;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    private final RelativeLayout rootView;
    public final TextView tvGstDesc;

    private LayoutBuyButtonBinding(RelativeLayout rootView, RelativeLayout buttonLow, Button buyNowBtn, LinearLayout linearAddToCart, TextView mrpCutTV, Button myLibBtn, LinearLayout priceLL, TextView priceTV, TextView tvGstDesc) {
        this.rootView = rootView;
        this.buttonLow = buttonLow;
        this.buyNowBtn = buyNowBtn;
        this.linearAddToCart = linearAddToCart;
        this.mrpCutTV = mrpCutTV;
        this.myLibBtn = myLibBtn;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.tvGstDesc = tvGstDesc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutBuyButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutBuyButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_buy_button, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutBuyButtonBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.buyNowBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
        if (button != null) {
            i = R.id.linear_addToCart;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_addToCart);
            if (linearLayout != null) {
                i = R.id.mrpCutTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                if (textView != null) {
                    i = R.id.myLibBtn;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.myLibBtn);
                    if (button2 != null) {
                        i = R.id.priceLL;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                        if (linearLayout2 != null) {
                            i = R.id.priceTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                            if (textView2 != null) {
                                i = R.id.tv_gstDesc;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_gstDesc);
                                if (textView3 != null) {
                                    return new LayoutBuyButtonBinding(relativeLayout, relativeLayout, button, linearLayout, textView, button2, linearLayout2, textView2, textView3);
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
