package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDoubtsBinding implements ViewBinding {
    public final DynamicBottomBarBinding bottomMenu;
    public final ImageView doubtImageBack;
    public final TabLayout doubtTabs;
    public final ViewPager doubtViewPager;
    public final Toolbar mainToolbar;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final RelativeLayout tabRelativeLayout;
    public final TextView toolbarTitleTV;

    private ActivityDoubtsBinding(ConstraintLayout rootView_, DynamicBottomBarBinding bottomMenu, ImageView doubtImageBack, TabLayout doubtTabs, ViewPager doubtViewPager, Toolbar mainToolbar, ConstraintLayout rootView, RelativeLayout tabRelativeLayout, TextView toolbarTitleTV) {
        this.rootView_ = rootView_;
        this.bottomMenu = bottomMenu;
        this.doubtImageBack = doubtImageBack;
        this.doubtTabs = doubtTabs;
        this.doubtViewPager = doubtViewPager;
        this.mainToolbar = mainToolbar;
        this.rootView = rootView;
        this.tabRelativeLayout = tabRelativeLayout;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityDoubtsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDoubtsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_doubts, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoubtsBinding bind(View rootView) {
        int i = R.id.bottom_menu;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
        if (viewFindChildViewById != null) {
            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
            i = R.id.doubt_image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubt_image_back);
            if (imageView != null) {
                i = R.id.doubt_tabs;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.doubt_tabs);
                if (tabLayout != null) {
                    i = R.id.doubt_view_pager;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.doubt_view_pager);
                    if (viewPager != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = R.id.tab_relative_layout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tab_relative_layout);
                            if (relativeLayout != null) {
                                i = R.id.toolbarTitleTV;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                if (textView != null) {
                                    return new ActivityDoubtsBinding(constraintLayout, dynamicBottomBarBindingBind, imageView, tabLayout, viewPager, toolbar, constraintLayout, relativeLayout, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
