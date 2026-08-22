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
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomCartitemBinding implements ViewBinding {
    public final TextView cartItemGst;
    public final ShapeableImageView cartItemImage;
    public final TextView cartItemPrice;
    public final TextView cartItemTittle;
    public final TextView cartItemType;
    public final TextView cartRatingTextView;
    public final TextView cartRatingUserTextView;
    public final TextView courseTax;
    public final TextView courseValidity;
    public final ImageView deleteItem;
    public final RatingBar ratingBarIndicator;
    public final LinearLayout ratingLinear;
    private final RelativeLayout rootView;

    private CustomCartitemBinding(RelativeLayout rootView, TextView cartItemGst, ShapeableImageView cartItemImage, TextView cartItemPrice, TextView cartItemTittle, TextView cartItemType, TextView cartRatingTextView, TextView cartRatingUserTextView, TextView courseTax, TextView courseValidity, ImageView deleteItem, RatingBar ratingBarIndicator, LinearLayout ratingLinear) {
        this.rootView = rootView;
        this.cartItemGst = cartItemGst;
        this.cartItemImage = cartItemImage;
        this.cartItemPrice = cartItemPrice;
        this.cartItemTittle = cartItemTittle;
        this.cartItemType = cartItemType;
        this.cartRatingTextView = cartRatingTextView;
        this.cartRatingUserTextView = cartRatingUserTextView;
        this.courseTax = courseTax;
        this.courseValidity = courseValidity;
        this.deleteItem = deleteItem;
        this.ratingBarIndicator = ratingBarIndicator;
        this.ratingLinear = ratingLinear;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomCartitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomCartitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_cartitem, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomCartitemBinding bind(View rootView) {
        int i = R.id.cartItem_gst;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_gst);
        if (textView != null) {
            i = R.id.cartItem_image;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.cartItem_image);
            if (shapeableImageView != null) {
                i = R.id.cartItem_price;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_price);
                if (textView2 != null) {
                    i = R.id.cartItem_tittle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_tittle);
                    if (textView3 != null) {
                        i = R.id.cartItem_type;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_type);
                        if (textView4 != null) {
                            i = R.id.cartRating_textView;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartRating_textView);
                            if (textView5 != null) {
                                i = R.id.cartRatingUser_textView;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartRatingUser_textView);
                                if (textView6 != null) {
                                    i = R.id.courseTax;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTax);
                                    if (textView7 != null) {
                                        i = R.id.courseValidity;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseValidity);
                                        if (textView8 != null) {
                                            i = R.id.deleteItem;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteItem);
                                            if (imageView != null) {
                                                i = R.id.rating_bar_indicator;
                                                RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.rating_bar_indicator);
                                                if (ratingBar != null) {
                                                    i = R.id.rating_Linear;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rating_Linear);
                                                    if (linearLayout != null) {
                                                        return new CustomCartitemBinding((RelativeLayout) rootView, textView, shapeableImageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView, ratingBar, linearLayout);
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
