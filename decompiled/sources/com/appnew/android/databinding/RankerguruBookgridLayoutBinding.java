package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RankerguruBookgridLayoutBinding implements ViewBinding {
    public final CardView buyNow;
    public final ImageView cartIv;
    public final LinearLayout cartLinear;
    public final TextView cartText;
    public final TextView courseDescription;
    public final LinearLayout currentAffairRL;
    public final ImageView ivTick;
    public final LinearLayout linearCourseCart;
    public final LinearLayout linearRating;
    public final ImageView liveIV;
    public final LinearLayout maiView;
    public final TextView mrpCutTV;
    public final LinearLayout priceLinear;
    public final TextView priceTV;
    public final RatingBar ratingBarIndicator;
    public final RelativeLayout rlLayer;
    private final LinearLayout rootView;
    public final TextView titleCourse;
    public final TextView userRateCount;
    public final ImageView videoImageVIEW;
    public final RelativeLayout videoplayerRL;
    public final CardView viewDemo;
    public final CardView viewDetails;

    private RankerguruBookgridLayoutBinding(LinearLayout rootView, CardView buyNow, ImageView cartIv, LinearLayout cartLinear, TextView cartText, TextView courseDescription, LinearLayout currentAffairRL, ImageView ivTick, LinearLayout linearCourseCart, LinearLayout linearRating, ImageView liveIV, LinearLayout maiView, TextView mrpCutTV, LinearLayout priceLinear, TextView priceTV, RatingBar ratingBarIndicator, RelativeLayout rlLayer, TextView titleCourse, TextView userRateCount, ImageView videoImageVIEW, RelativeLayout videoplayerRL, CardView viewDemo, CardView viewDetails) {
        this.rootView = rootView;
        this.buyNow = buyNow;
        this.cartIv = cartIv;
        this.cartLinear = cartLinear;
        this.cartText = cartText;
        this.courseDescription = courseDescription;
        this.currentAffairRL = currentAffairRL;
        this.ivTick = ivTick;
        this.linearCourseCart = linearCourseCart;
        this.linearRating = linearRating;
        this.liveIV = liveIV;
        this.maiView = maiView;
        this.mrpCutTV = mrpCutTV;
        this.priceLinear = priceLinear;
        this.priceTV = priceTV;
        this.ratingBarIndicator = ratingBarIndicator;
        this.rlLayer = rlLayer;
        this.titleCourse = titleCourse;
        this.userRateCount = userRateCount;
        this.videoImageVIEW = videoImageVIEW;
        this.videoplayerRL = videoplayerRL;
        this.viewDemo = viewDemo;
        this.viewDetails = viewDetails;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RankerguruBookgridLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RankerguruBookgridLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.rankerguru_bookgrid_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RankerguruBookgridLayoutBinding bind(View rootView) {
        int i = R.id.buyNow;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.buyNow);
        if (cardView != null) {
            i = R.id.cart_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cart_iv);
            if (imageView != null) {
                i = R.id.cartLinear;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLinear);
                if (linearLayout != null) {
                    i = R.id.cart_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cart_text);
                    if (textView != null) {
                        i = R.id.courseDescription;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseDescription);
                        if (textView2 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) rootView;
                            i = R.id.iv_tick;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_tick);
                            if (imageView2 != null) {
                                i = R.id.linear_courseCart;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_courseCart);
                                if (linearLayout3 != null) {
                                    i = R.id.linear_rating;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_rating);
                                    if (linearLayout4 != null) {
                                        i = R.id.liveIV;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                        if (imageView3 != null) {
                                            i = R.id.maiView;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                            if (linearLayout5 != null) {
                                                i = R.id.mrpCutTV;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                if (textView3 != null) {
                                                    i = R.id.price_linear;
                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.price_linear);
                                                    if (linearLayout6 != null) {
                                                        i = R.id.priceTV;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                        if (textView4 != null) {
                                                            i = R.id.rating_bar_indicator;
                                                            RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.rating_bar_indicator);
                                                            if (ratingBar != null) {
                                                                i = R.id.rl_layer;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_layer);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.titleCourse;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleCourse);
                                                                    if (textView5 != null) {
                                                                        i = R.id.userRate_count;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userRate_count);
                                                                        if (textView6 != null) {
                                                                            i = R.id.videoImageVIEW;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.videoImageVIEW);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.videoplayerRL;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                                                if (relativeLayout2 != null) {
                                                                                    i = R.id.viewDemo;
                                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.viewDemo);
                                                                                    if (cardView2 != null) {
                                                                                        i = R.id.viewDetails;
                                                                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.viewDetails);
                                                                                        if (cardView3 != null) {
                                                                                            return new RankerguruBookgridLayoutBinding(linearLayout2, cardView, imageView, linearLayout, textView, textView2, linearLayout2, imageView2, linearLayout3, linearLayout4, imageView3, linearLayout5, textView3, linearLayout6, textView4, ratingBar, relativeLayout, textView5, textView6, imageView4, relativeLayout2, cardView2, cardView3);
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
