package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EduCourseAdapterBinding implements ViewBinding {
    public final TextView addToLib;
    public final TextView buyNowId;
    public final TextView courseTitle;
    public final TextView discount;
    public final RelativeLayout discountRL;
    public final View divider;
    public final TextView exploreId;
    public final TextView freeCourseText;
    public final ImageView imageBanner;
    public final LinearLayout maiView;
    public final TextView originalPrice;
    public final LinearLayout paidCourseLay;
    public final TextView price;
    public final LinearLayout priceLinear;
    private final CardView rootView;
    public final FrameLayout soldOutImg;
    public final TextView validity;
    public final LinearLayout validityRowId;

    private EduCourseAdapterBinding(CardView rootView, TextView addToLib, TextView buyNowId, TextView courseTitle, TextView discount, RelativeLayout discountRL, View divider, TextView exploreId, TextView freeCourseText, ImageView imageBanner, LinearLayout maiView, TextView originalPrice, LinearLayout paidCourseLay, TextView price, LinearLayout priceLinear, FrameLayout soldOutImg, TextView validity, LinearLayout validityRowId) {
        this.rootView = rootView;
        this.addToLib = addToLib;
        this.buyNowId = buyNowId;
        this.courseTitle = courseTitle;
        this.discount = discount;
        this.discountRL = discountRL;
        this.divider = divider;
        this.exploreId = exploreId;
        this.freeCourseText = freeCourseText;
        this.imageBanner = imageBanner;
        this.maiView = maiView;
        this.originalPrice = originalPrice;
        this.paidCourseLay = paidCourseLay;
        this.price = price;
        this.priceLinear = priceLinear;
        this.soldOutImg = soldOutImg;
        this.validity = validity;
        this.validityRowId = validityRowId;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static EduCourseAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EduCourseAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.edu_course_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EduCourseAdapterBinding bind(View rootView) {
        int i = R.id.addToLib;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addToLib);
        if (textView != null) {
            i = R.id.buyNowId;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNowId);
            if (textView2 != null) {
                i = R.id.courseTitle;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTitle);
                if (textView3 != null) {
                    i = R.id.discount;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.discount);
                    if (textView4 != null) {
                        i = R.id.discountRL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.discountRL);
                        if (relativeLayout != null) {
                            i = R.id.divider;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider);
                            if (viewFindChildViewById != null) {
                                i = R.id.exploreId;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exploreId);
                                if (textView5 != null) {
                                    i = R.id.freeCourseText;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.freeCourseText);
                                    if (textView6 != null) {
                                        i = R.id.imageBanner;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageBanner);
                                        if (imageView != null) {
                                            i = R.id.maiView;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                            if (linearLayout != null) {
                                                i = R.id.originalPrice;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.originalPrice);
                                                if (textView7 != null) {
                                                    i = R.id.paidCourseLay;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.paidCourseLay);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.price;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.price);
                                                        if (textView8 != null) {
                                                            i = R.id.price_linear;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.price_linear);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.soldOutImg;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.soldOutImg);
                                                                if (frameLayout != null) {
                                                                    i = R.id.validity;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validity);
                                                                    if (textView9 != null) {
                                                                        i = R.id.validityRowId;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.validityRowId);
                                                                        if (linearLayout4 != null) {
                                                                            return new EduCourseAdapterBinding((CardView) rootView, textView, textView2, textView3, textView4, relativeLayout, viewFindChildViewById, textView5, textView6, imageView, linearLayout, textView7, linearLayout2, textView8, linearLayout3, frameLayout, textView9, linearLayout4);
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
