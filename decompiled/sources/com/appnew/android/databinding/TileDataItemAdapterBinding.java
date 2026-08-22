package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TileDataItemAdapterBinding implements ViewBinding {
    public final ImageView cartIv;
    public final LinearLayout cartLinear;
    public final TextView cartText;
    public final LinearLayout currentAffairRL;
    public final TextView ibtCurrentAffairTitle;
    public final ImageView ibtSingleVdIv;
    public final ImageView ivTick;
    public final LinearLayout linearCourseCart;
    public final LinearLayout linearRating;
    public final ImageView liveIV;
    public final LinearLayout llScholorshipDiscount;
    public final LinearLayout maiView;
    public final TextView mrpCutTV;
    public final ImageView newCourse;
    public final LinearLayout priceLinear;
    public final TextView priceTV;
    public final RatingBar ratingBarIndicator;
    public final RelativeLayout rlLayer;
    private final LinearLayout rootView;
    public final TextView scholarshipCouponTV;
    public final LinearLayout titleLl;
    public final TextView userRateCount;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private TileDataItemAdapterBinding(LinearLayout rootView, ImageView cartIv, LinearLayout cartLinear, TextView cartText, LinearLayout currentAffairRL, TextView ibtCurrentAffairTitle, ImageView ibtSingleVdIv, ImageView ivTick, LinearLayout linearCourseCart, LinearLayout linearRating, ImageView liveIV, LinearLayout llScholorshipDiscount, LinearLayout maiView, TextView mrpCutTV, ImageView newCourse, LinearLayout priceLinear, TextView priceTV, RatingBar ratingBarIndicator, RelativeLayout rlLayer, TextView scholarshipCouponTV, LinearLayout titleLl, TextView userRateCount, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.cartIv = cartIv;
        this.cartLinear = cartLinear;
        this.cartText = cartText;
        this.currentAffairRL = currentAffairRL;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ivTick = ivTick;
        this.linearCourseCart = linearCourseCart;
        this.linearRating = linearRating;
        this.liveIV = liveIV;
        this.llScholorshipDiscount = llScholorshipDiscount;
        this.maiView = maiView;
        this.mrpCutTV = mrpCutTV;
        this.newCourse = newCourse;
        this.priceLinear = priceLinear;
        this.priceTV = priceTV;
        this.ratingBarIndicator = ratingBarIndicator;
        this.rlLayer = rlLayer;
        this.scholarshipCouponTV = scholarshipCouponTV;
        this.titleLl = titleLl;
        this.userRateCount = userRateCount;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TileDataItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TileDataItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.tile_data_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TileDataItemAdapterBinding bind(View rootView) {
        int i = R.id.cart_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cart_iv);
        if (imageView != null) {
            i = R.id.cartLinear;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLinear);
            if (linearLayout != null) {
                i = R.id.cart_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cart_text);
                if (textView != null) {
                    LinearLayout linearLayout2 = (LinearLayout) rootView;
                    i = R.id.ibt_current_affair_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
                    if (textView2 != null) {
                        i = R.id.ibt_single_vd_iv;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                        if (imageView2 != null) {
                            i = R.id.iv_tick;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_tick);
                            if (imageView3 != null) {
                                i = R.id.linear_courseCart;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_courseCart);
                                if (linearLayout3 != null) {
                                    i = R.id.linear_rating;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_rating);
                                    if (linearLayout4 != null) {
                                        i = R.id.liveIV;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                        if (imageView4 != null) {
                                            i = R.id.ll_scholorship_discount;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_scholorship_discount);
                                            if (linearLayout5 != null) {
                                                i = R.id.maiView;
                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                                if (linearLayout6 != null) {
                                                    i = R.id.mrpCutTV;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                    if (textView3 != null) {
                                                        i = R.id.new_course;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                                                        if (imageView5 != null) {
                                                            i = R.id.price_linear;
                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.price_linear);
                                                            if (linearLayout7 != null) {
                                                                i = R.id.priceTV;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                if (textView4 != null) {
                                                                    i = R.id.rating_bar_indicator;
                                                                    RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.rating_bar_indicator);
                                                                    if (ratingBar != null) {
                                                                        i = R.id.rl_layer;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_layer);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.scholarshipCouponTV;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.scholarshipCouponTV);
                                                                            if (textView5 != null) {
                                                                                i = R.id.title_ll;
                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                                                if (linearLayout8 != null) {
                                                                                    i = R.id.userRate_count;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userRate_count);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.validityTextTV;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.videoplayerRL;
                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                                                            if (relativeLayout2 != null) {
                                                                                                return new TileDataItemAdapterBinding(linearLayout2, imageView, linearLayout, textView, linearLayout2, textView2, imageView2, imageView3, linearLayout3, linearLayout4, imageView4, linearLayout5, linearLayout6, textView3, imageView5, linearLayout7, textView4, ratingBar, relativeLayout, textView5, linearLayout8, textView6, textView7, relativeLayout2);
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
