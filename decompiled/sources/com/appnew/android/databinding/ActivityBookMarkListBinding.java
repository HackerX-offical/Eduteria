package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityBookMarkListBinding implements ViewBinding {
    public final ImageView bookMarkBack;
    public final TabLayout bookMarkTabs;
    public final ViewPager bookMarkViewPager;
    public final RelativeLayout layout;
    public final Toolbar mainToolbar;
    private final ConstraintLayout rootView;
    public final ImageView searchIV;
    public final SearchView svSearch;
    public final RelativeLayout tabRelativeLayout;
    public final TextView toolbarTitleTV;

    private ActivityBookMarkListBinding(ConstraintLayout rootView, ImageView bookMarkBack, TabLayout bookMarkTabs, ViewPager bookMarkViewPager, RelativeLayout layout, Toolbar mainToolbar, ImageView searchIV, SearchView svSearch, RelativeLayout tabRelativeLayout, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.bookMarkBack = bookMarkBack;
        this.bookMarkTabs = bookMarkTabs;
        this.bookMarkViewPager = bookMarkViewPager;
        this.layout = layout;
        this.mainToolbar = mainToolbar;
        this.searchIV = searchIV;
        this.svSearch = svSearch;
        this.tabRelativeLayout = tabRelativeLayout;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBookMarkListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBookMarkListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_book_mark_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBookMarkListBinding bind(View rootView) {
        int i = R.id.bookMark_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookMark_back);
        if (imageView != null) {
            i = R.id.bookMark_tabs;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.bookMark_tabs);
            if (tabLayout != null) {
                i = R.id.bookMark_view_pager;
                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.bookMark_view_pager);
                if (viewPager != null) {
                    i = R.id.layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                    if (relativeLayout != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.searchIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                            if (imageView2 != null) {
                                i = R.id.sv_search;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                if (searchView != null) {
                                    i = R.id.tab_relative_layout;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tab_relative_layout);
                                    if (relativeLayout2 != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView != null) {
                                            return new ActivityBookMarkListBinding((ConstraintLayout) rootView, imageView, tabLayout, viewPager, relativeLayout, toolbar, imageView2, searchView, relativeLayout2, textView);
                                        }
                                    }
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
