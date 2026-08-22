package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCartItemsBinding implements ViewBinding {
    public final Button backBtn;
    public final CardView cartItemCoupon;
    public final TextView cartItemGst;
    public final TextView cartItemPrice;
    public final TextView cartItemQuantity;
    public final ImageView cartItemsImageBack;
    public final RecyclerView cartItemsRecycler;
    public final RelativeLayout checkTncRL;
    public final EditText couponCode;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final TextView payNowText;
    private final ConstraintLayout rootView;
    public final CardView selectAddressCard;
    public final TextView termCondTV;
    public final AppCompatCheckBox termsCheck;
    public final TextView toolbarTitleTV;

    private ActivityCartItemsBinding(ConstraintLayout rootView, Button backBtn, CardView cartItemCoupon, TextView cartItemGst, TextView cartItemPrice, TextView cartItemQuantity, ImageView cartItemsImageBack, RecyclerView cartItemsRecycler, RelativeLayout checkTncRL, EditText couponCode, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, TextView payNowText, CardView selectAddressCard, TextView termCondTV, AppCompatCheckBox termsCheck, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.cartItemCoupon = cartItemCoupon;
        this.cartItemGst = cartItemGst;
        this.cartItemPrice = cartItemPrice;
        this.cartItemQuantity = cartItemQuantity;
        this.cartItemsImageBack = cartItemsImageBack;
        this.cartItemsRecycler = cartItemsRecycler;
        this.checkTncRL = checkTncRL;
        this.couponCode = couponCode;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.payNowText = payNowText;
        this.selectAddressCard = selectAddressCard;
        this.termCondTV = termCondTV;
        this.termsCheck = termsCheck;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCartItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCartItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_cart_items, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCartItemsBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.cartItem_coupon;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cartItem_coupon);
            if (cardView != null) {
                i = R.id.cartItem_gst;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_gst);
                if (textView != null) {
                    i = R.id.cartItem_price;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_price);
                    if (textView2 != null) {
                        i = R.id.cartItem_quantity;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartItem_quantity);
                        if (textView3 != null) {
                            i = R.id.cartItems_image_back;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cartItems_image_back);
                            if (imageView != null) {
                                i = R.id.cartItems_recycler;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.cartItems_recycler);
                                if (recyclerView != null) {
                                    i = R.id.checkTncRL;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.checkTncRL);
                                    if (relativeLayout != null) {
                                        i = R.id.coupon_code;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.coupon_code);
                                        if (editText != null) {
                                            i = R.id.image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                            if (imageView2 != null) {
                                                i = R.id.main_toolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                if (toolbar != null) {
                                                    i = R.id.no_data;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                                    if (textView4 != null) {
                                                        i = R.id.no_data_found_RL;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.payNow_text;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.payNow_text);
                                                            if (textView5 != null) {
                                                                i = R.id.selectAddress_card;
                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.selectAddress_card);
                                                                if (cardView2 != null) {
                                                                    i = R.id.termCondTV;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.termCondTV);
                                                                    if (textView6 != null) {
                                                                        i = R.id.terms_check;
                                                                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(rootView, R.id.terms_check);
                                                                        if (appCompatCheckBox != null) {
                                                                            i = R.id.toolbarTitleTV;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                            if (textView7 != null) {
                                                                                return new ActivityCartItemsBinding((ConstraintLayout) rootView, button, cardView, textView, textView2, textView3, imageView, recyclerView, relativeLayout, editText, imageView2, toolbar, textView4, relativeLayout2, textView5, cardView2, textView6, appCompatCheckBox, textView7);
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
