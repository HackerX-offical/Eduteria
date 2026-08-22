package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityLiveClassBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final RelativeLayout tabRelativeLayout;
    public final TabLayout tabs;
    public final TextView toolbarTitleTV;
    public final ViewPager viewPager;

    private ActivityLiveClassBinding(RelativeLayout rootView, ImageView imageBack, Toolbar mainToolbar, RelativeLayout root, RelativeLayout tabRelativeLayout, TabLayout tabs, TextView toolbarTitleTV, ViewPager viewPager) {
        this.rootView = rootView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.root = root;
        this.tabRelativeLayout = tabRelativeLayout;
        this.tabs = tabs;
        this.toolbarTitleTV = toolbarTitleTV;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLiveClassBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLiveClassBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_live_class, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLiveClassBinding bind(View rootView) {
        int i = R.id.image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
        if (imageView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                i = R.id.tab_relative_layout;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tab_relative_layout);
                if (relativeLayout2 != null) {
                    i = R.id.tabs;
                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.tabs);
                    if (tabLayout != null) {
                        i = R.id.toolbarTitleTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                        if (textView != null) {
                            i = R.id.view_pager;
                            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager);
                            if (viewPager != null) {
                                return new ActivityLiveClassBinding(relativeLayout, imageView, toolbar, relativeLayout, relativeLayout2, tabLayout, textView, viewPager);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
