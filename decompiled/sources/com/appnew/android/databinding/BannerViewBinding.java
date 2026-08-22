package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BannerViewBinding extends ViewDataBinding {

    @Bindable
    protected Data mBannerdata;
    public final ViewPager viewPager;

    public abstract void setBannerdata(Data bannerdata);

    protected BannerViewBinding(Object _bindingComponent, View _root, int _localFieldCount, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.viewPager = viewPager;
    }

    public Data getBannerdata() {
        return this.mBannerdata;
    }

    public static BannerViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BannerViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.banner_view, root, attachToRoot, component);
    }

    public static BannerViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerViewBinding inflate(LayoutInflater inflater, Object component) {
        return (BannerViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.banner_view, null, false, component);
    }

    public static BannerViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BannerViewBinding bind(View view, Object component) {
        return (BannerViewBinding) bind(component, view, R.layout.banner_view);
    }
}
