package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentUpcomingBinding implements ViewBinding {
    public final NestedScrollView nestedScroll;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    private final FrameLayout rootView;
    public final NonScrollRecyclerView upcomingrecycler;

    private FragmentUpcomingBinding(FrameLayout rootView, NestedScrollView nestedScroll, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, NonScrollRecyclerView upcomingrecycler) {
        this.rootView = rootView;
        this.nestedScroll = nestedScroll;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.upcomingrecycler = upcomingrecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUpcomingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentUpcomingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_upcoming, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUpcomingBinding bind(View rootView) {
        int i = R.id.nested_scroll;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
        if (nestedScrollView != null) {
            i = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
            if (progressBar != null) {
                i = R.id.pullto_referesh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                if (swipeRefreshLayout != null) {
                    i = R.id.upcomingrecycler;
                    NonScrollRecyclerView nonScrollRecyclerView = (NonScrollRecyclerView) ViewBindings.findChildViewById(rootView, R.id.upcomingrecycler);
                    if (nonScrollRecyclerView != null) {
                        return new FragmentUpcomingBinding((FrameLayout) rootView, nestedScrollView, progressBar, swipeRefreshLayout, nonScrollRecyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
