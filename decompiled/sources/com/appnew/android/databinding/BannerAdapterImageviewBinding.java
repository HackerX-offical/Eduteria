package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.adapters.Banner_ViewPager;
import com.appnew.android.feeds.dataclass.BannerData;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BannerAdapterImageviewBinding extends ViewDataBinding {
    public final RoundedImageView imgeView;

    @Bindable
    protected BannerData mBannerdata;

    @Bindable
    protected Banner_ViewPager mBannerviewadapter;

    public abstract void setBannerdata(BannerData bannerdata);

    public abstract void setBannerviewadapter(Banner_ViewPager bannerviewadapter);

    protected BannerAdapterImageviewBinding(Object _bindingComponent, View _root, int _localFieldCount, RoundedImageView imgeView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgeView = imgeView;
    }

    public BannerData getBannerdata() {
        return this.mBannerdata;
    }

    public Banner_ViewPager getBannerviewadapter() {
        return this.mBannerviewadapter;
    }

    public static BannerAdapterImageviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerAdapterImageviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BannerAdapterImageviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.banner_adapter_imageview, root, attachToRoot, component);
    }

    public static BannerAdapterImageviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerAdapterImageviewBinding inflate(LayoutInflater inflater, Object component) {
        return (BannerAdapterImageviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.banner_adapter_imageview, null, false, component);
    }

    public static BannerAdapterImageviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerAdapterImageviewBinding bind(View view, Object component) {
        return (BannerAdapterImageviewBinding) bind(component, view, R.layout.banner_adapter_imageview);
    }
}
