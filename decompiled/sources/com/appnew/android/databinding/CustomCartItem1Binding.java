package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomCartItem1Binding implements ViewBinding {
    public final ShapeableImageView cartItemImage;
    public final TextView cartItemTittle;
    public final TextView cartItemType;
    public final TextView cartRatingTextView;
    public final TextView cartRatingUserTextView;
    public final TextView courseTax;
    public final TextView courseValidity;
    public final ImageView deleteItem;
    public final RatingBar ratingBarIndicator;
    private final RelativeLayout rootView;
    public final TextView totalPriceId;

    private CustomCartItem1Binding(RelativeLayout rootView, ShapeableImageView cartItemImage, TextView cartItemTittle, TextView cartItemType, TextView cartRatingTextView, TextView cartRatingUserTextView, TextView courseTax, TextView courseValidity, ImageView deleteItem, RatingBar ratingBarIndicator, TextView totalPriceId) {
        this.rootView = rootView;
        this.cartItemImage = cartItemImage;
        this.cartItemTittle = cartItemTittle;
        this.cartItemType = cartItemType;
        this.cartRatingTextView = cartRatingTextView;
        this.cartRatingUserTextView = cartRatingUserTextView;
        this.courseTax = courseTax;
        this.courseValidity = courseValidity;
        this.deleteItem = deleteItem;
        this.ratingBarIndicator = ratingBarIndicator;
        this.totalPriceId = totalPriceId;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomCartItem1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomCartItem1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_cart_item1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomCartItem1Binding bind(View rootView) {
        int i = R.id.cartItem_image;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.cartItem_image);
        if (shapeableImageView != null) {
            i = R.id.cartItem_tittle;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_tittle);
            if (textView != null) {
                i = R.id.cartItem_type;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_type);
                if (textView2 != null) {
                    i = R.id.cartRating_textView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartRating_textView);
                    if (textView3 != null) {
                        i = R.id.cartRatingUser_textView;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartRatingUser_textView);
                        if (textView4 != null) {
                            i = R.id.courseTax;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTax);
                            if (textView5 != null) {
                                i = R.id.courseValidity;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseValidity);
                                if (textView6 != null) {
                                    i = R.id.deleteItem;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteItem);
                                    if (imageView != null) {
                                        i = R.id.rating_bar_indicator;
                                        RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.rating_bar_indicator);
                                        if (ratingBar != null) {
                                            i = R.id.totalPriceId;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalPriceId);
                                            if (textView7 != null) {
                                                return new CustomCartItem1Binding((RelativeLayout) rootView, shapeableImageView, textView, textView2, textView3, textView4, textView5, textView6, imageView, ratingBar, textView7);
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
