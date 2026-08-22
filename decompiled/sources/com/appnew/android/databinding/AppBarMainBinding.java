package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarMainBinding implements ViewBinding {
    public final TextView cartCount;
    public final LinearLayout cvrNotificationCount1;
    public final ImageView filterIV;
    public final RelativeLayout fragmentContainer;
    public final ImageView gotoCart;
    public final ImageView imageBack;
    public final ImageView ivWhatsapp;
    public final RelativeLayout layout;
    public final LinearLayout linearGotoCart;
    public final Toolbar mainToolbar;
    public final LinearLayout maincontrolLL;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final ImageView rate;
    public final RelativeLayout relativeGotoCart;
    private final CoordinatorLayout rootView;
    public final ImageView searchIV;
    public final SearchView searchSV;
    public final ImageView shareIV;
    public final SearchView svSearch;
    public final TextView toolbarTitleTV;
    public final TextView tvNotification;

    private AppBarMainBinding(CoordinatorLayout rootView, TextView cartCount, LinearLayout cvrNotificationCount1, ImageView filterIV, RelativeLayout fragmentContainer, ImageView gotoCart, ImageView imageBack, ImageView ivWhatsapp, RelativeLayout layout, LinearLayout linearGotoCart, Toolbar mainToolbar, LinearLayout maincontrolLL, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ImageView rate, RelativeLayout relativeGotoCart, ImageView searchIV, SearchView searchSV, ImageView shareIV, SearchView svSearch, TextView toolbarTitleTV, TextView tvNotification) {
        this.rootView = rootView;
        this.cartCount = cartCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.filterIV = filterIV;
        this.fragmentContainer = fragmentContainer;
        this.gotoCart = gotoCart;
        this.imageBack = imageBack;
        this.ivWhatsapp = ivWhatsapp;
        this.layout = layout;
        this.linearGotoCart = linearGotoCart;
        this.mainToolbar = mainToolbar;
        this.maincontrolLL = maincontrolLL;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.rate = rate;
        this.relativeGotoCart = relativeGotoCart;
        this.searchIV = searchIV;
        this.searchSV = searchSV;
        this.shareIV = shareIV;
        this.svSearch = svSearch;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvNotification = tvNotification;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static AppBarMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarMainBinding bind(View rootView) {
        int i = R.id.cart_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cart_count);
        if (textView != null) {
            i = R.id.cvrNotificationCount1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
            if (linearLayout != null) {
                i = R.id.filterIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.filterIV);
                if (imageView != null) {
                    i = R.id.fragment_container;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.fragment_container);
                    if (relativeLayout != null) {
                        i = R.id.gotoCart;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.gotoCart);
                        if (imageView2 != null) {
                            i = R.id.image_back;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                            if (imageView3 != null) {
                                i = R.id.iv_whatsapp;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_whatsapp);
                                if (imageView4 != null) {
                                    i = R.id.layout;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                                    if (relativeLayout2 != null) {
                                        i = R.id.linear_gotoCart;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_gotoCart);
                                        if (linearLayout2 != null) {
                                            i = R.id.main_toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                            if (toolbar != null) {
                                                i = R.id.maincontrolLL;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maincontrolLL);
                                                if (linearLayout3 != null) {
                                                    i = R.id.notificaionCount1;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                                    if (textView2 != null) {
                                                        i = R.id.notificationIV;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                                        if (imageView5 != null) {
                                                            i = R.id.notificationLL;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.rate;
                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.rate);
                                                                if (imageView6 != null) {
                                                                    i = R.id.relative_gotoCart;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_gotoCart);
                                                                    if (relativeLayout4 != null) {
                                                                        i = R.id.searchIV;
                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                        if (imageView7 != null) {
                                                                            i = R.id.searchSV;
                                                                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchSV);
                                                                            if (searchView != null) {
                                                                                i = R.id.shareIV;
                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareIV);
                                                                                if (imageView8 != null) {
                                                                                    i = R.id.sv_search;
                                                                                    SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                                                                    if (searchView2 != null) {
                                                                                        i = R.id.toolbarTitleTV;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tv_notification;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_notification);
                                                                                            if (textView4 != null) {
                                                                                                return new AppBarMainBinding((CoordinatorLayout) rootView, textView, linearLayout, imageView, relativeLayout, imageView2, imageView3, imageView4, relativeLayout2, linearLayout2, toolbar, linearLayout3, textView2, imageView5, relativeLayout3, imageView6, relativeLayout4, imageView7, searchView, imageView8, searchView2, textView3, textView4);
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
