package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentNotificationBinding implements ViewBinding {
    public final NestedScrollView nestedScroll;
    public final RecyclerView notification;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    private final RelativeLayout rootView;

    private FragmentNotificationBinding(RelativeLayout rootView, NestedScrollView nestedScroll, RecyclerView notification, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh) {
        this.rootView = rootView;
        this.nestedScroll = nestedScroll;
        this.notification = notification;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNotificationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentNotificationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_notification, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNotificationBinding bind(View rootView) {
        int i = R.id.nested_scroll;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
        if (nestedScrollView != null) {
            i = R.id.notification;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.notification);
            if (recyclerView != null) {
                i = R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                if (progressBar != null) {
                    i = R.id.pullto_referesh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                    if (swipeRefreshLayout != null) {
                        return new FragmentNotificationBinding((RelativeLayout) rootView, nestedScrollView, recyclerView, progressBar, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
