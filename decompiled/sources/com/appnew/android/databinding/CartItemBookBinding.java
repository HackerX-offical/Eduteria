package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.book_theme_2.models.Cartdata;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CartItemBookBinding extends ViewDataBinding {
    public final ImageView cartImage;
    public final TextView cartOffPrice;
    public final TextView cartPrice;
    public final TextView cartRating;
    public final TextView cartSubTitle;
    public final TextView cartTitle;
    public final ImageView deleteId;
    public final ImageView heartIcon;

    @Bindable
    protected Cartdata mData;
    public final TextView offPrice;

    public abstract void setData(Cartdata data);

    protected CartItemBookBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView cartImage, TextView cartOffPrice, TextView cartPrice, TextView cartRating, TextView cartSubTitle, TextView cartTitle, ImageView deleteId, ImageView heartIcon, TextView offPrice) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cartImage = cartImage;
        this.cartOffPrice = cartOffPrice;
        this.cartPrice = cartPrice;
        this.cartRating = cartRating;
        this.cartSubTitle = cartSubTitle;
        this.cartTitle = cartTitle;
        this.deleteId = deleteId;
        this.heartIcon = heartIcon;
        this.offPrice = offPrice;
    }

    public Cartdata getData() {
        return this.mData;
    }

    public static CartItemBookBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CartItemBookBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cart_item_book, root, attachToRoot, component);
    }

    public static CartItemBookBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookBinding inflate(LayoutInflater inflater, Object component) {
        return (CartItemBookBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cart_item_book, null, false, component);
    }

    public static CartItemBookBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CartItemBookBinding bind(View view, Object component) {
        return (CartItemBookBinding) bind(component, view, R.layout.cart_item_book);
    }
}
