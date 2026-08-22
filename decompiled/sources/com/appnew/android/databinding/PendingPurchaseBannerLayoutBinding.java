package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PendingPurchaseBannerLayoutBinding extends ViewDataBinding {
    public final FrameLayout sliderRoot;
    public final ViewPager2 sliderViewPager;

    protected PendingPurchaseBannerLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout sliderRoot, ViewPager2 sliderViewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.sliderRoot = sliderRoot;
        this.sliderViewPager = sliderViewPager;
    }

    public static PendingPurchaseBannerLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PendingPurchaseBannerLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.pending_purchase_banner_layout, root, attachToRoot, component);
    }

    public static PendingPurchaseBannerLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (PendingPurchaseBannerLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.pending_purchase_banner_layout, null, false, component);
    }

    public static PendingPurchaseBannerLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PendingPurchaseBannerLayoutBinding bind(View view, Object component) {
        return (PendingPurchaseBannerLayoutBinding) bind(component, view, R.layout.pending_purchase_banner_layout);
    }
}
