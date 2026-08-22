package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.dataclass.Datum;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FeedLiveClassAdapterBinding extends ViewDataBinding {
    public final TextView courseName;
    public final RoundedImageView imageTest;
    public final RelativeLayout layoutTestInfo;

    @Bindable
    protected Datum mLiveclassdata;
    public final RelativeLayout parentLayout;
    public final TextView testName;
    public final TextView time;

    public abstract void setLiveclassdata(Datum liveclassdata);

    protected FeedLiveClassAdapterBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView courseName, RoundedImageView imageTest, RelativeLayout layoutTestInfo, RelativeLayout parentLayout, TextView testName, TextView time) {
        super(_bindingComponent, _root, _localFieldCount);
        this.courseName = courseName;
        this.imageTest = imageTest;
        this.layoutTestInfo = layoutTestInfo;
        this.parentLayout = parentLayout;
        this.testName = testName;
        this.time = time;
    }

    public Datum getLiveclassdata() {
        return this.mLiveclassdata;
    }

    public static FeedLiveClassAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveClassAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FeedLiveClassAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.feed_live_class_adapter, root, attachToRoot, component);
    }

    public static FeedLiveClassAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveClassAdapterBinding inflate(LayoutInflater inflater, Object component) {
        return (FeedLiveClassAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.feed_live_class_adapter, null, false, component);
    }

    public static FeedLiveClassAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveClassAdapterBinding bind(View view, Object component) {
        return (FeedLiveClassAdapterBinding) bind(component, view, R.layout.feed_live_class_adapter);
    }
}
