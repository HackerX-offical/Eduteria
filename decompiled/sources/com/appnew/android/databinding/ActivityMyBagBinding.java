package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityMyBagBinding extends ViewDataBinding {
    public final ConstraintLayout appBarId;
    public final ImageView backButton;
    public final TextView bagTextId;
    public final CardView cartItemCoupon;
    public final ConstraintLayout constraintLayout2;
    public final EditText couponCode;
    public final TextView deliveryChargeId;
    public final TextView deliveryChargePrice;
    public final TextView grandTotalId;
    public final TextView grandTotalPrice;
    public final ImageView image;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final TextView orderDetails;
    public final ConstraintLayout orderLayout;
    public final Button placeOrderId;
    public final RecyclerView recyclerViewId;
    public final AppCompatEditText searchId;
    public final TextView totalPrice;
    public final TextView totalProductId;
    public final TextView totalProductPrice;

    protected ActivityMyBagBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout appBarId, ImageView backButton, TextView bagTextId, CardView cartItemCoupon, ConstraintLayout constraintLayout2, EditText couponCode, TextView deliveryChargeId, TextView deliveryChargePrice, TextView grandTotalId, TextView grandTotalPrice, ImageView image, TextView noData, RelativeLayout noDataFoundRL, TextView orderDetails, ConstraintLayout orderLayout, Button placeOrderId, RecyclerView recyclerViewId, AppCompatEditText searchId, TextView totalPrice, TextView totalProductId, TextView totalProductPrice) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarId = appBarId;
        this.backButton = backButton;
        this.bagTextId = bagTextId;
        this.cartItemCoupon = cartItemCoupon;
        this.constraintLayout2 = constraintLayout2;
        this.couponCode = couponCode;
        this.deliveryChargeId = deliveryChargeId;
        this.deliveryChargePrice = deliveryChargePrice;
        this.grandTotalId = grandTotalId;
        this.grandTotalPrice = grandTotalPrice;
        this.image = image;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.orderDetails = orderDetails;
        this.orderLayout = orderLayout;
        this.placeOrderId = placeOrderId;
        this.recyclerViewId = recyclerViewId;
        this.searchId = searchId;
        this.totalPrice = totalPrice;
        this.totalProductId = totalProductId;
        this.totalProductPrice = totalProductPrice;
    }

    public static ActivityMyBagBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyBagBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityMyBagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_my_bag, root, attachToRoot, component);
    }

    public static ActivityMyBagBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyBagBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityMyBagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_my_bag, null, false, component);
    }

    public static ActivityMyBagBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyBagBinding bind(View view, Object component) {
        return (ActivityMyBagBinding) bind(component, view, R.layout.activity_my_bag);
    }
}
