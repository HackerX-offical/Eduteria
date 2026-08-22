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
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ExpiredCouponItemsBinding implements ViewBinding {
    public final TextView couponDiscount;
    public final TextView couponExpired;
    public final TextView couponName;
    public final RoundedImageView ibtSingleVdIv;
    public final RelativeLayout imageContainer;
    public final CardView maincard;
    private final RelativeLayout rootView;

    private ExpiredCouponItemsBinding(RelativeLayout rootView, TextView couponDiscount, TextView couponExpired, TextView couponName, RoundedImageView ibtSingleVdIv, RelativeLayout imageContainer, CardView maincard) {
        this.rootView = rootView;
        this.couponDiscount = couponDiscount;
        this.couponExpired = couponExpired;
        this.couponName = couponName;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.imageContainer = imageContainer;
        this.maincard = maincard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExpiredCouponItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExpiredCouponItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.expired_coupon_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExpiredCouponItemsBinding bind(View rootView) {
        int i = R.id.coupon_discount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.coupon_discount);
        if (textView != null) {
            i = R.id.coupon_expired;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coupon_expired);
            if (textView2 != null) {
                i = R.id.coupon_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coupon_name);
                if (textView3 != null) {
                    i = R.id.ibt_single_vd_iv;
                    RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                    if (roundedImageView != null) {
                        i = R.id.imageContainer;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageContainer);
                        if (relativeLayout != null) {
                            i = R.id.maincard;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.maincard);
                            if (cardView != null) {
                                return new ExpiredCouponItemsBinding((RelativeLayout) rootView, textView, textView2, textView3, roundedImageView, relativeLayout, cardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
