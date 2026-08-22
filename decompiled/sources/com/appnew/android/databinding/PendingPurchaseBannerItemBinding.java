package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PendingPurchaseBannerItemBinding extends ViewDataBinding {
    public final Button btnBuyNow;
    public final ImageView btnClose;
    public final TextView courseTitleTV;
    public final ShapeableImageView imageSlider;
    public final TextView mrpCutTV;
    public final RelativeLayout priceLinear;
    public final TextView priceTV;

    protected PendingPurchaseBannerItemBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnBuyNow, ImageView btnClose, TextView courseTitleTV, ShapeableImageView imageSlider, TextView mrpCutTV, RelativeLayout priceLinear, TextView priceTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBuyNow = btnBuyNow;
        this.btnClose = btnClose;
        this.courseTitleTV = courseTitleTV;
        this.imageSlider = imageSlider;
        this.mrpCutTV = mrpCutTV;
        this.priceLinear = priceLinear;
        this.priceTV = priceTV;
    }

    public static PendingPurchaseBannerItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PendingPurchaseBannerItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.pending_purchase_banner_item, root, attachToRoot, component);
    }

    public static PendingPurchaseBannerItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerItemBinding inflate(LayoutInflater inflater, Object component) {
        return (PendingPurchaseBannerItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.pending_purchase_banner_item, null, false, component);
    }

    public static PendingPurchaseBannerItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerItemBinding bind(View view, Object component) {
        return (PendingPurchaseBannerItemBinding) bind(component, view, R.layout.pending_purchase_banner_item);
    }
}
