package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentExpiredCouponBinding implements ViewBinding {
    public final RecyclerView Liveclassesrecycler;
    public final NestedScrollView nestedScroll;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    private final FrameLayout rootView;

    private FragmentExpiredCouponBinding(FrameLayout rootView, RecyclerView Liveclassesrecycler, NestedScrollView nestedScroll, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh) {
        this.rootView = rootView;
        this.Liveclassesrecycler = Liveclassesrecycler;
        this.nestedScroll = nestedScroll;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExpiredCouponBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentExpiredCouponBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_expired_coupon, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExpiredCouponBinding bind(View rootView) {
        int i = R.id.Liveclassesrecycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.Liveclassesrecycler);
        if (recyclerView != null) {
            i = R.id.nested_scroll;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
            if (nestedScrollView != null) {
                i = R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                if (progressBar != null) {
                    i = R.id.pullto_referesh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                    if (swipeRefreshLayout != null) {
                        return new FragmentExpiredCouponBinding((FrameLayout) rootView, recyclerView, nestedScrollView, progressBar, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
