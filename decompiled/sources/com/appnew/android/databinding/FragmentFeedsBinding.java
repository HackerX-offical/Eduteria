package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.feeds.viewmodel.FeedViewModel;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FragmentFeedsBinding extends ViewDataBinding {
    public final RecyclerView feedRecyerlview;
    public final Toolbar feedsToolbar;
    public final ImageView filter;
    public final ImageView imageBack;

    @Bindable
    protected FeedViewModel mFeedbind;
    public final NestedScrollView nestedScroll;
    public final ImageView pinedPost;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;

    public abstract void setFeedbind(FeedViewModel feedbind);

    protected FragmentFeedsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView feedRecyerlview, Toolbar feedsToolbar, ImageView filter, ImageView imageBack, NestedScrollView nestedScroll, ImageView pinedPost, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout titleinnerRL, TextView toolbartitleTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.feedRecyerlview = feedRecyerlview;
        this.feedsToolbar = feedsToolbar;
        this.filter = filter;
        this.imageBack = imageBack;
        this.nestedScroll = nestedScroll;
        this.pinedPost = pinedPost;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
    }

    public FeedViewModel getFeedbind() {
        return this.mFeedbind;
    }

    public static FragmentFeedsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeedsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeedsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_feeds, root, attachToRoot, component);
    }

    public static FragmentFeedsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeedsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeedsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_feeds, null, false, component);
    }

    public static FragmentFeedsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeedsBinding bind(View view, Object component) {
        return (FragmentFeedsBinding) bind(component, view, R.layout.fragment_feeds);
    }
}
