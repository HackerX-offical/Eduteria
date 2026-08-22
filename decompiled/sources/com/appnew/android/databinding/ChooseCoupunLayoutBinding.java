package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.AnimatedRecyclerView;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ChooseCoupunLayoutBinding implements ViewBinding {
    public final TextView applyCoupon;
    public final RelativeLayout calcpagerl;
    public final ImageView cancelCoupon;
    public final TextView cname;
    public final EditText couponEdt;
    public final RelativeLayout editCouponRl;
    public final ShapeableImageView ibtSingleVdIv;
    public final AnimatedRecyclerView recyclerViewValidy;
    private final RelativeLayout rootView;
    public final LinearLayout titleDesc;
    public final TextView view2;
    public final TextView view3;

    private ChooseCoupunLayoutBinding(RelativeLayout rootView, TextView applyCoupon, RelativeLayout calcpagerl, ImageView cancelCoupon, TextView cname, EditText couponEdt, RelativeLayout editCouponRl, ShapeableImageView ibtSingleVdIv, AnimatedRecyclerView recyclerViewValidy, LinearLayout titleDesc, TextView view2, TextView view3) {
        this.rootView = rootView;
        this.applyCoupon = applyCoupon;
        this.calcpagerl = calcpagerl;
        this.cancelCoupon = cancelCoupon;
        this.cname = cname;
        this.couponEdt = couponEdt;
        this.editCouponRl = editCouponRl;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.recyclerViewValidy = recyclerViewValidy;
        this.titleDesc = titleDesc;
        this.view2 = view2;
        this.view3 = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseCoupunLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChooseCoupunLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.choose_coupun_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChooseCoupunLayoutBinding bind(View rootView) {
        int i = R.id.apply_coupon;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.apply_coupon);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.cancel_coupon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_coupon);
            if (imageView != null) {
                i = R.id.cname;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cname);
                if (textView2 != null) {
                    i = R.id.coupon_edt;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.coupon_edt);
                    if (editText != null) {
                        i = R.id.editCouponRl;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editCouponRl);
                        if (relativeLayout2 != null) {
                            i = R.id.ibt_single_vd_iv;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                            if (shapeableImageView != null) {
                                i = R.id.recycler_view_validy;
                                AnimatedRecyclerView animatedRecyclerView = (AnimatedRecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view_validy);
                                if (animatedRecyclerView != null) {
                                    i = R.id.titleDesc;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.titleDesc);
                                    if (linearLayout != null) {
                                        i = R.id.view2;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view2);
                                        if (textView3 != null) {
                                            i = R.id.view3;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view3);
                                            if (textView4 != null) {
                                                return new ChooseCoupunLayoutBinding(relativeLayout, textView, relativeLayout, imageView, textView2, editText, relativeLayout2, shapeableImageView, animatedRecyclerView, linearLayout, textView3, textView4);
                                            }
                                        }
                                    }
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
