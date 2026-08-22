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
public final class HomeTrendingClassItemBinding implements ViewBinding {
    public final TextView buyNowIdTC;
    public final ImageView courseBannerTC;
    public final TextView courseTitleTC;
    public final RelativeLayout discountRLTC;
    public final TextView discountTC;
    public final View divider;
    public final TextView exploreIdTC;
    public final TextView freeCourseTextTC;
    public final ImageView liveIV;
    public final ImageView newCourse;
    public final TextView originalPriceTC;
    public final LinearLayout paidCourseLayTC;
    public final LinearLayout priceLinear;
    public final TextView priceTC;
    public final RelativeLayout relativeBlink;
    private final CardView rootView;
    public final FrameLayout soldOutImgTC;
    public final LinearLayout validityRowIdTC;
    public final TextView validityTC;

    private HomeTrendingClassItemBinding(CardView rootView, TextView buyNowIdTC, ImageView courseBannerTC, TextView courseTitleTC, RelativeLayout discountRLTC, TextView discountTC, View divider, TextView exploreIdTC, TextView freeCourseTextTC, ImageView liveIV, ImageView newCourse, TextView originalPriceTC, LinearLayout paidCourseLayTC, LinearLayout priceLinear, TextView priceTC, RelativeLayout relativeBlink, FrameLayout soldOutImgTC, LinearLayout validityRowIdTC, TextView validityTC) {
        this.rootView = rootView;
        this.buyNowIdTC = buyNowIdTC;
        this.courseBannerTC = courseBannerTC;
        this.courseTitleTC = courseTitleTC;
        this.discountRLTC = discountRLTC;
        this.discountTC = discountTC;
        this.divider = divider;
        this.exploreIdTC = exploreIdTC;
        this.freeCourseTextTC = freeCourseTextTC;
        this.liveIV = liveIV;
        this.newCourse = newCourse;
        this.originalPriceTC = originalPriceTC;
        this.paidCourseLayTC = paidCourseLayTC;
        this.priceLinear = priceLinear;
        this.priceTC = priceTC;
        this.relativeBlink = relativeBlink;
        this.soldOutImgTC = soldOutImgTC;
        this.validityRowIdTC = validityRowIdTC;
        this.validityTC = validityTC;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static HomeTrendingClassItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HomeTrendingClassItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.home_trending_class_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HomeTrendingClassItemBinding bind(View rootView) {
        int i = R.id.buyNowIdTC;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNowIdTC);
        if (textView != null) {
            i = R.id.courseBannerTC;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseBannerTC);
            if (imageView != null) {
                i = R.id.courseTitleTC;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTitleTC);
                if (textView2 != null) {
                    i = R.id.discountRLTC;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.discountRLTC);
                    if (relativeLayout != null) {
                        i = R.id.discountTC;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.discountTC);
                        if (textView3 != null) {
                            i = R.id.divider;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider);
                            if (viewFindChildViewById != null) {
                                i = R.id.exploreIdTC;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exploreIdTC);
                                if (textView4 != null) {
                                    i = R.id.freeCourseTextTC;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.freeCourseTextTC);
                                    if (textView5 != null) {
                                        i = R.id.liveIV;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                        if (imageView2 != null) {
                                            i = R.id.new_course;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                                            if (imageView3 != null) {
                                                i = R.id.originalPriceTC;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.originalPriceTC);
                                                if (textView6 != null) {
                                                    i = R.id.paidCourseLayTC;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.paidCourseLayTC);
                                                    if (linearLayout != null) {
                                                        i = R.id.price_linear;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.price_linear);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.priceTC;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTC);
                                                            if (textView7 != null) {
                                                                i = R.id.relative_blink;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_blink);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.soldOutImgTC;
                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.soldOutImgTC);
                                                                    if (frameLayout != null) {
                                                                        i = R.id.validityRowIdTC;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.validityRowIdTC);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.validityTC;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTC);
                                                                            if (textView8 != null) {
                                                                                return new HomeTrendingClassItemBinding((CardView) rootView, textView, imageView, textView2, relativeLayout, textView3, viewFindChildViewById, textView4, textView5, imageView2, imageView3, textView6, linearLayout, linearLayout2, textView7, relativeLayout2, frameLayout, linearLayout3, textView8);
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
