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
import com.appnew.android.Utils.CustomViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityLivetestBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final RelativeLayout tabRelativeLayout;
    public final TabLayout tabs;
    public final TextView toolbarTitleTV;
    public final CustomViewPager viewPager;

    private ActivityLivetestBinding(RelativeLayout rootView, ImageView imageBack, Toolbar mainToolbar, RelativeLayout root, RelativeLayout tabRelativeLayout, TabLayout tabs, TextView toolbarTitleTV, CustomViewPager viewPager) {
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

    public static ActivityLivetestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLivetestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_livetest, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLivetestBinding bind(View rootView) {
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
                            CustomViewPager customViewPager = (CustomViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager);
                            if (customViewPager != null) {
                                return new ActivityLivetestBinding(relativeLayout, imageView, toolbar, relativeLayout, relativeLayout2, tabLayout, textView, customViewPager);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
