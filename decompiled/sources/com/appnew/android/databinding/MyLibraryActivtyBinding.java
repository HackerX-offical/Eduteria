package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class MyLibraryActivtyBinding implements ViewBinding {
    public final DynamicBottomBarBinding bottomMenu;
    public final ImageView imageBack;
    public final RelativeLayout layout;
    public final RelativeLayout mainCover;
    public final Toolbar mainToolbar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final ImageView seracImage;
    public final SearchView svSearch;
    public final RelativeLayout tabRelativeLayout;
    public final TabLayout tabs;
    public final TextView toolbarTitleTV;
    public final ViewPager viewPager;

    private MyLibraryActivtyBinding(RelativeLayout rootView_, DynamicBottomBarBinding bottomMenu, ImageView imageBack, RelativeLayout layout, RelativeLayout mainCover, Toolbar mainToolbar, SwipeRefreshLayout pulltoReferesh, RelativeLayout rootView, ImageView seracImage, SearchView svSearch, RelativeLayout tabRelativeLayout, TabLayout tabs, TextView toolbarTitleTV, ViewPager viewPager) {
        this.rootView_ = rootView_;
        this.bottomMenu = bottomMenu;
        this.imageBack = imageBack;
        this.layout = layout;
        this.mainCover = mainCover;
        this.mainToolbar = mainToolbar;
        this.pulltoReferesh = pulltoReferesh;
        this.rootView = rootView;
        this.seracImage = seracImage;
        this.svSearch = svSearch;
        this.tabRelativeLayout = tabRelativeLayout;
        this.tabs = tabs;
        this.toolbarTitleTV = toolbarTitleTV;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static MyLibraryActivtyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MyLibraryActivtyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.my_library_activty, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MyLibraryActivtyBinding bind(View rootView) {
        int i = R.id.bottom_menu;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
        if (viewFindChildViewById != null) {
            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.layout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                if (relativeLayout != null) {
                    i = R.id.mainCover;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainCover);
                    if (relativeLayout2 != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.pullto_referesh;
                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                            if (swipeRefreshLayout != null) {
                                RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                i = R.id.serac_image;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.serac_image);
                                if (imageView2 != null) {
                                    i = R.id.sv_search;
                                    SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                    if (searchView != null) {
                                        i = R.id.tab_relative_layout;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tab_relative_layout);
                                        if (relativeLayout4 != null) {
                                            i = R.id.tabs;
                                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.tabs);
                                            if (tabLayout != null) {
                                                i = R.id.toolbarTitleTV;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                if (textView != null) {
                                                    i = R.id.view_pager;
                                                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager);
                                                    if (viewPager != null) {
                                                        return new MyLibraryActivtyBinding(relativeLayout3, dynamicBottomBarBindingBind, imageView, relativeLayout, relativeLayout2, toolbar, swipeRefreshLayout, relativeLayout3, imageView2, searchView, relativeLayout4, tabLayout, textView, viewPager);
                                                    }
                                                }
                                            }
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
