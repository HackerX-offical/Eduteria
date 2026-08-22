package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.adapters.FeedAdapter;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LiveClassVmBinding extends ViewDataBinding {
    public final RecyclerView liveClassRecycler;

    @Bindable
    protected FeedAdapter mFeedadapter;

    @Bindable
    protected Data mLiveclass;
    public final TextView newCourseTxt;
    public final View view1;
    public final TextView viewAll;

    public abstract void setFeedadapter(FeedAdapter feedadapter);

    public abstract void setLiveclass(Data liveclass);

    protected LiveClassVmBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView liveClassRecycler, TextView newCourseTxt, View view1, TextView viewAll) {
        super(_bindingComponent, _root, _localFieldCount);
        this.liveClassRecycler = liveClassRecycler;
        this.newCourseTxt = newCourseTxt;
        this.view1 = view1;
        this.viewAll = viewAll;
    }

    public Data getLiveclass() {
        return this.mLiveclass;
    }

    public FeedAdapter getFeedadapter() {
        return this.mFeedadapter;
    }

    public static LiveClassVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveClassVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LiveClassVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.live_class_vm, root, attachToRoot, component);
    }

    public static LiveClassVmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveClassVmBinding inflate(LayoutInflater inflater, Object component) {
        return (LiveClassVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.live_class_vm, null, false, component);
    }

    public static LiveClassVmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveClassVmBinding bind(View view, Object component) {
        return (LiveClassVmBinding) bind(component, view, R.layout.live_class_vm);
    }
}
