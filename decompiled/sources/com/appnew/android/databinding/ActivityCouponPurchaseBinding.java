package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCouponPurchaseBinding implements ViewBinding {
    public final TextView couponApplied;
    public final TextView coursenameTV;
    public final TextView delete;
    public final RelativeLayout grandTotalLayout;
    public final ImageView imageBack;
    public final RoundedImageView imageIV;
    public final RelativeLayout layoutCourse;
    public final Toolbar mainToolbar;
    public final RelativeLayout priceLayout;
    public final RelativeLayout pricesLayout;
    public final Button procceed;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView summaryTxt;
    public final RelativeLayout taxLayout;
    public final TextView taxValue;
    public final RelativeLayout taxesLayout;
    public final TextView toolbarTitleTV;
    public final RelativeLayout totalAmountLayout;
    public final TextView txtAmountValue;
    public final TextView txtGrandTotalValue;
    public final TextView txtPriceValue;
    public final TextView txtPricesValue;
    public final TextView txtTaxValue;
    public final TextView validityTV;
    public final View view1;
    public final View view2;
    public final View view3;
    public final View view4;

    private ActivityCouponPurchaseBinding(RelativeLayout rootView, TextView couponApplied, TextView coursenameTV, TextView delete, RelativeLayout grandTotalLayout, ImageView imageBack, RoundedImageView imageIV, RelativeLayout layoutCourse, Toolbar mainToolbar, RelativeLayout priceLayout, RelativeLayout pricesLayout, Button procceed, RelativeLayout root, CheckBox selectAllDelete, TextView summaryTxt, RelativeLayout taxLayout, TextView taxValue, RelativeLayout taxesLayout, TextView toolbarTitleTV, RelativeLayout totalAmountLayout, TextView txtAmountValue, TextView txtGrandTotalValue, TextView txtPriceValue, TextView txtPricesValue, TextView txtTaxValue, TextView validityTV, View view1, View view2, View view3, View view4) {
        this.rootView = rootView;
        this.couponApplied = couponApplied;
        this.coursenameTV = coursenameTV;
        this.delete = delete;
        this.grandTotalLayout = grandTotalLayout;
        this.imageBack = imageBack;
        this.imageIV = imageIV;
        this.layoutCourse = layoutCourse;
        this.mainToolbar = mainToolbar;
        this.priceLayout = priceLayout;
        this.pricesLayout = pricesLayout;
        this.procceed = procceed;
        this.root = root;
        this.selectAllDelete = selectAllDelete;
        this.summaryTxt = summaryTxt;
        this.taxLayout = taxLayout;
        this.taxValue = taxValue;
        this.taxesLayout = taxesLayout;
        this.toolbarTitleTV = toolbarTitleTV;
        this.totalAmountLayout = totalAmountLayout;
        this.txtAmountValue = txtAmountValue;
        this.txtGrandTotalValue = txtGrandTotalValue;
        this.txtPriceValue = txtPriceValue;
        this.txtPricesValue = txtPricesValue;
        this.txtTaxValue = txtTaxValue;
        this.validityTV = validityTV;
        this.view1 = view1;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCouponPurchaseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCouponPurchaseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_coupon_purchase, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCouponPurchaseBinding bind(View rootView) {
        int i = R.id.coupon_applied;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.coupon_applied);
        if (textView != null) {
            i = R.id.coursenameTV;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coursenameTV);
            if (textView2 != null) {
                i = R.id.delete;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView3 != null) {
                    i = R.id.grand_total_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.grand_total_layout);
                    if (relativeLayout != null) {
                        i = R.id.image_back;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                        if (imageView != null) {
                            i = R.id.imageIV;
                            RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                            if (roundedImageView != null) {
                                i = R.id.layout_course;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_course);
                                if (relativeLayout2 != null) {
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.price_layout;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.price_layout);
                                        if (relativeLayout3 != null) {
                                            i = R.id.prices_layout;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.prices_layout);
                                            if (relativeLayout4 != null) {
                                                i = R.id.procceed;
                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.procceed);
                                                if (button != null) {
                                                    RelativeLayout relativeLayout5 = (RelativeLayout) rootView;
                                                    i = R.id.select_all_delete;
                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                    if (checkBox != null) {
                                                        i = R.id.summary_txt;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.summary_txt);
                                                        if (textView4 != null) {
                                                            i = R.id.tax_layout;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tax_layout);
                                                            if (relativeLayout6 != null) {
                                                                i = R.id.tax_value;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tax_value);
                                                                if (textView5 != null) {
                                                                    i = R.id.taxes_layout;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.taxes_layout);
                                                                    if (relativeLayout7 != null) {
                                                                        i = R.id.toolbarTitleTV;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                        if (textView6 != null) {
                                                                            i = R.id.total_amount_layout;
                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.total_amount_layout);
                                                                            if (relativeLayout8 != null) {
                                                                                i = R.id.txtAmountValue;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtAmountValue);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.txtGrandTotalValue;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtGrandTotalValue);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.txtPriceValue;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPriceValue);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.txtPricesValue;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPricesValue);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.txtTaxValue;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTaxValue);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.validityTV;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.view1;
                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                                                        if (viewFindChildViewById != null) {
                                                                                                            i = R.id.view2;
                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                i = R.id.view3;
                                                                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view3);
                                                                                                                if (viewFindChildViewById3 != null) {
                                                                                                                    i = R.id.view4;
                                                                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view4);
                                                                                                                    if (viewFindChildViewById4 != null) {
                                                                                                                        return new ActivityCouponPurchaseBinding(relativeLayout5, textView, textView2, textView3, relativeLayout, imageView, roundedImageView, relativeLayout2, toolbar, relativeLayout3, relativeLayout4, button, relativeLayout5, checkBox, textView4, relativeLayout6, textView5, relativeLayout7, textView6, relativeLayout8, textView7, textView8, textView9, textView10, textView11, textView12, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4);
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
