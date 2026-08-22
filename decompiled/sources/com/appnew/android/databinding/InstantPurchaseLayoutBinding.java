package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.AnimatedRecyclerView;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class InstantPurchaseLayoutBinding implements ViewBinding {
    public final TextView addAddressBtn;
    public final LinearLayout addedAddressLL;
    public final TextView addedAddressTV;
    public final RelativeLayout addressCV;
    public final TextView applyCoupon;
    public final ImageView cancelBox;
    public final CheckBox checkBoxAddress;
    public final RelativeLayout checkTncRL;
    public final CardView couponAppliedCV;
    public final TextView couponCodeApplied;
    public final EditText couponEdt;
    public final ImageView couponIV;
    public final TextView deliveringToText;
    public final LinearLayout detailLL;
    public final ImageView editAddressIV;
    public final RelativeLayout editCouponRl;
    public final RelativeLayout grandTotalLayout;
    public final TextView gstCoursePrice;
    public final TextView gstFinalPrice;
    public final TextView haveCouponTV;
    public final ShapeableImageView imageView;
    public final NestedScrollView mainNSV;
    public final TextView mobileNumber;
    public final TextView mobileNumberAlternate;
    public final TextView nameAddressTv;
    public final TextView openQR;
    public final TextView payOnline;
    public final AnimatedRecyclerView recyclerCoupons;
    public final ImageView remove;
    private final RelativeLayout rootView;
    public final RelativeLayout taxLayout1;
    public final TextView taxValue1;
    public final TextView termCondTV;
    public final AppCompatCheckBox termsCheck;
    public final TextView title;
    public final TextView totalPriceValue1;
    public final TextView txtGrandTotalValue1;
    public final TextView view3;
    public final RelativeLayout viewAllCouponRL;
    public final ImageView viewTop;

    private InstantPurchaseLayoutBinding(RelativeLayout rootView, TextView addAddressBtn, LinearLayout addedAddressLL, TextView addedAddressTV, RelativeLayout addressCV, TextView applyCoupon, ImageView cancelBox, CheckBox checkBoxAddress, RelativeLayout checkTncRL, CardView couponAppliedCV, TextView couponCodeApplied, EditText couponEdt, ImageView couponIV, TextView deliveringToText, LinearLayout detailLL, ImageView editAddressIV, RelativeLayout editCouponRl, RelativeLayout grandTotalLayout, TextView gstCoursePrice, TextView gstFinalPrice, TextView haveCouponTV, ShapeableImageView imageView, NestedScrollView mainNSV, TextView mobileNumber, TextView mobileNumberAlternate, TextView nameAddressTv, TextView openQR, TextView payOnline, AnimatedRecyclerView recyclerCoupons, ImageView remove, RelativeLayout taxLayout1, TextView taxValue1, TextView termCondTV, AppCompatCheckBox termsCheck, TextView title, TextView totalPriceValue1, TextView txtGrandTotalValue1, TextView view3, RelativeLayout viewAllCouponRL, ImageView viewTop) {
        this.rootView = rootView;
        this.addAddressBtn = addAddressBtn;
        this.addedAddressLL = addedAddressLL;
        this.addedAddressTV = addedAddressTV;
        this.addressCV = addressCV;
        this.applyCoupon = applyCoupon;
        this.cancelBox = cancelBox;
        this.checkBoxAddress = checkBoxAddress;
        this.checkTncRL = checkTncRL;
        this.couponAppliedCV = couponAppliedCV;
        this.couponCodeApplied = couponCodeApplied;
        this.couponEdt = couponEdt;
        this.couponIV = couponIV;
        this.deliveringToText = deliveringToText;
        this.detailLL = detailLL;
        this.editAddressIV = editAddressIV;
        this.editCouponRl = editCouponRl;
        this.grandTotalLayout = grandTotalLayout;
        this.gstCoursePrice = gstCoursePrice;
        this.gstFinalPrice = gstFinalPrice;
        this.haveCouponTV = haveCouponTV;
        this.imageView = imageView;
        this.mainNSV = mainNSV;
        this.mobileNumber = mobileNumber;
        this.mobileNumberAlternate = mobileNumberAlternate;
        this.nameAddressTv = nameAddressTv;
        this.openQR = openQR;
        this.payOnline = payOnline;
        this.recyclerCoupons = recyclerCoupons;
        this.remove = remove;
        this.taxLayout1 = taxLayout1;
        this.taxValue1 = taxValue1;
        this.termCondTV = termCondTV;
        this.termsCheck = termsCheck;
        this.title = title;
        this.totalPriceValue1 = totalPriceValue1;
        this.txtGrandTotalValue1 = txtGrandTotalValue1;
        this.view3 = view3;
        this.viewAllCouponRL = viewAllCouponRL;
        this.viewTop = viewTop;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static InstantPurchaseLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InstantPurchaseLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.instant_purchase_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static InstantPurchaseLayoutBinding bind(View rootView) {
        int i = R.id.addAddressBtn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addAddressBtn);
        if (textView != null) {
            i = R.id.addedAddressLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.addedAddressLL);
            if (linearLayout != null) {
                i = R.id.addedAddressTV;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addedAddressTV);
                if (textView2 != null) {
                    i = R.id.addressCV;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addressCV);
                    if (relativeLayout != null) {
                        i = R.id.apply_coupon;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.apply_coupon);
                        if (textView3 != null) {
                            i = R.id.cancelBox;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelBox);
                            if (imageView != null) {
                                i = R.id.checkBoxAddress;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkBoxAddress);
                                if (checkBox != null) {
                                    i = R.id.checkTncRL;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.checkTncRL);
                                    if (relativeLayout2 != null) {
                                        i = R.id.couponAppliedCV;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.couponAppliedCV);
                                        if (cardView != null) {
                                            i = R.id.coupon_code_applied;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coupon_code_applied);
                                            if (textView4 != null) {
                                                i = R.id.coupon_edt;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.coupon_edt);
                                                if (editText != null) {
                                                    i = R.id.couponIV;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.couponIV);
                                                    if (imageView2 != null) {
                                                        i = R.id.deliveringToText;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deliveringToText);
                                                        if (textView5 != null) {
                                                            i = R.id.detailLL;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.detailLL);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.editAddressIV;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.editAddressIV);
                                                                if (imageView3 != null) {
                                                                    i = R.id.editCouponRl;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editCouponRl);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.grand_total_layout;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.grand_total_layout);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.gstCoursePrice;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gstCoursePrice);
                                                                            if (textView6 != null) {
                                                                                i = R.id.gstFinalPrice;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gstFinalPrice);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.haveCouponTV;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.haveCouponTV);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.imageView;
                                                                                        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
                                                                                        if (shapeableImageView != null) {
                                                                                            i = R.id.mainNSV;
                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.mainNSV);
                                                                                            if (nestedScrollView != null) {
                                                                                                i = R.id.mobileNumber;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.mobileNumberAlternate;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumberAlternate);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.nameAddressTv;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameAddressTv);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.openQR;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.openQR);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.payOnline;
                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.payOnline);
                                                                                                                if (textView13 != null) {
                                                                                                                    i = R.id.recyclerCoupons;
                                                                                                                    AnimatedRecyclerView animatedRecyclerView = (AnimatedRecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerCoupons);
                                                                                                                    if (animatedRecyclerView != null) {
                                                                                                                        i = R.id.remove;
                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.remove);
                                                                                                                        if (imageView4 != null) {
                                                                                                                            i = R.id.tax_layout1;
                                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tax_layout1);
                                                                                                                            if (relativeLayout5 != null) {
                                                                                                                                i = R.id.tax_value1;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tax_value1);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i = R.id.termCondTV;
                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.termCondTV);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        i = R.id.terms_check;
                                                                                                                                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(rootView, R.id.terms_check);
                                                                                                                                        if (appCompatCheckBox != null) {
                                                                                                                                            i = R.id.title;
                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                            if (textView16 != null) {
                                                                                                                                                i = R.id.totalPriceValue1;
                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalPriceValue1);
                                                                                                                                                if (textView17 != null) {
                                                                                                                                                    i = R.id.txtGrandTotalValue1;
                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtGrandTotalValue1);
                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                        i = R.id.view3;
                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view3);
                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                            i = R.id.viewAllCouponRL;
                                                                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewAllCouponRL);
                                                                                                                                                            if (relativeLayout6 != null) {
                                                                                                                                                                i = R.id.viewTop;
                                                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.viewTop);
                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                    return new InstantPurchaseLayoutBinding((RelativeLayout) rootView, textView, linearLayout, textView2, relativeLayout, textView3, imageView, checkBox, relativeLayout2, cardView, textView4, editText, imageView2, textView5, linearLayout2, imageView3, relativeLayout3, relativeLayout4, textView6, textView7, textView8, shapeableImageView, nestedScrollView, textView9, textView10, textView11, textView12, textView13, animatedRecyclerView, imageView4, relativeLayout5, textView14, textView15, appCompatCheckBox, textView16, textView17, textView18, textView19, relativeLayout6, imageView5);
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
