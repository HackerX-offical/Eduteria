package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CartItemBookGridBinding extends ViewDataBinding {
    public final ImageView cartIcon;
    public final ImageView cartImage;
    public final TextView cartOffPrice;
    public final TextView cartPrice;
    public final TextView cartRating;
    public final TextView cartSubTitle;
    public final TextView cartTitle;
    public final TextView offPrice;
    public final Button placeOrderId;

    protected CartItemBookGridBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView cartIcon, ImageView cartImage, TextView cartOffPrice, TextView cartPrice, TextView cartRating, TextView cartSubTitle, TextView cartTitle, TextView offPrice, Button placeOrderId) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cartIcon = cartIcon;
        this.cartImage = cartImage;
        this.cartOffPrice = cartOffPrice;
        this.cartPrice = cartPrice;
        this.cartRating = cartRating;
        this.cartSubTitle = cartSubTitle;
        this.cartTitle = cartTitle;
        this.offPrice = offPrice;
        this.placeOrderId = placeOrderId;
    }

    public static CartItemBookGridBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookGridBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CartItemBookGridBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cart_item_book_grid, root, attachToRoot, component);
    }

    public static CartItemBookGridBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookGridBinding inflate(LayoutInflater inflater, Object component) {
        return (CartItemBookGridBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cart_item_book_grid, null, false, component);
    }

    public static CartItemBookGridBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookGridBinding bind(View view, Object component) {
        return (CartItemBookGridBinding) bind(component, view, R.layout.cart_item_book_grid);
    }
}
