package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.home.livetest.LiveTestData;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FeedLiveTestAdapterBinding extends ViewDataBinding {
    public final TextView courseName;
    public final RoundedImageView imageTest;
    public final RelativeLayout layoutTestInfo;

    @Bindable
    protected LiveTestData mLivetestdata;
    public final RelativeLayout parentLayout;
    public final TextView testName;
    public final TextView time;

    public abstract void setLivetestdata(LiveTestData livetestdata);

    protected FeedLiveTestAdapterBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView courseName, RoundedImageView imageTest, RelativeLayout layoutTestInfo, RelativeLayout parentLayout, TextView testName, TextView time) {
        super(_bindingComponent, _root, _localFieldCount);
        this.courseName = courseName;
        this.imageTest = imageTest;
        this.layoutTestInfo = layoutTestInfo;
        this.parentLayout = parentLayout;
        this.testName = testName;
        this.time = time;
    }

    public LiveTestData getLivetestdata() {
        return this.mLivetestdata;
    }

    public static FeedLiveTestAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveTestAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FeedLiveTestAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.feed_live_test_adapter, root, attachToRoot, component);
    }

    public static FeedLiveTestAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveTestAdapterBinding inflate(LayoutInflater inflater, Object component) {
        return (FeedLiveTestAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.feed_live_test_adapter, null, false, component);
    }

    public static FeedLiveTestAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedLiveTestAdapterBinding bind(View view, Object component) {
        return (FeedLiveTestAdapterBinding) bind(component, view, R.layout.feed_live_test_adapter);
    }
}
