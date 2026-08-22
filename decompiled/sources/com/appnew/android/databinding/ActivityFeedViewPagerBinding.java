package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFeedViewPagerBinding implements ViewBinding {
    public final RelativeLayout backBtn;
    public final RecyclerView bannerSlider;
    private final RelativeLayout rootView;
    public final RelativeLayout toolbar;

    private ActivityFeedViewPagerBinding(RelativeLayout rootView, RelativeLayout backBtn, RecyclerView bannerSlider, RelativeLayout toolbar) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.bannerSlider = bannerSlider;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFeedViewPagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFeedViewPagerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_feed_view_pager, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFeedViewPagerBinding bind(View rootView) {
        int i = R.id.backBtn;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (relativeLayout != null) {
            i = R.id.bannerSlider;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.bannerSlider);
            if (recyclerView != null) {
                i = R.id.toolbar;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                if (relativeLayout2 != null) {
                    return new ActivityFeedViewPagerBinding((RelativeLayout) rootView, relativeLayout, recyclerView, relativeLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
