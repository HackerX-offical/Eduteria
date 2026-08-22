package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CouponPurchaseAdapterBinding implements ViewBinding {
    public final TextView applyButton;
    public final RelativeLayout cardRL;
    public final RelativeLayout codeLL;
    public final ImageView couponIcon;
    public final TextView days;
    public final TextView descCoupon;
    public final TextView price;
    private final RelativeLayout rootView;

    private CouponPurchaseAdapterBinding(RelativeLayout rootView, TextView applyButton, RelativeLayout cardRL, RelativeLayout codeLL, ImageView couponIcon, TextView days, TextView descCoupon, TextView price) {
        this.rootView = rootView;
        this.applyButton = applyButton;
        this.cardRL = cardRL;
        this.codeLL = codeLL;
        this.couponIcon = couponIcon;
        this.days = days;
        this.descCoupon = descCoupon;
        this.price = price;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CouponPurchaseAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CouponPurchaseAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.coupon_purchase_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CouponPurchaseAdapterBinding bind(View rootView) {
        int i = R.id.applyButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.applyButton);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.codeLL;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.codeLL);
            if (relativeLayout2 != null) {
                i = R.id.couponIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.couponIcon);
                if (imageView != null) {
                    i = R.id.days;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.days);
                    if (textView2 != null) {
                        i = R.id.descCoupon;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.descCoupon);
                        if (textView3 != null) {
                            i = R.id.price;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.price);
                            if (textView4 != null) {
                                return new CouponPurchaseAdapterBinding(relativeLayout, textView, relativeLayout, relativeLayout2, imageView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
