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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FeedsActivityBinding implements ViewBinding {
    public final ImageView calender;
    public final TextView date;
    public final ImageView filterIV;
    public final ImageView imageBack;
    public final RelativeLayout layout;
    public final Toolbar mainToolbar;
    public final LinearLayout maincontrolLL;
    public final RecyclerView recycler;
    private final LinearLayout rootView;
    public final ImageView searchIV;
    public final SearchView searchSV;
    public final ImageView shareIV;
    public final SearchView svSearch;
    public final TextView toolbarTitleTV;
    public final TextView tvNotification;

    private FeedsActivityBinding(LinearLayout rootView, ImageView calender, TextView date, ImageView filterIV, ImageView imageBack, RelativeLayout layout, Toolbar mainToolbar, LinearLayout maincontrolLL, RecyclerView recycler, ImageView searchIV, SearchView searchSV, ImageView shareIV, SearchView svSearch, TextView toolbarTitleTV, TextView tvNotification) {
        this.rootView = rootView;
        this.calender = calender;
        this.date = date;
        this.filterIV = filterIV;
        this.imageBack = imageBack;
        this.layout = layout;
        this.mainToolbar = mainToolbar;
        this.maincontrolLL = maincontrolLL;
        this.recycler = recycler;
        this.searchIV = searchIV;
        this.searchSV = searchSV;
        this.shareIV = shareIV;
        this.svSearch = svSearch;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvNotification = tvNotification;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FeedsActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FeedsActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.feeds_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FeedsActivityBinding bind(View rootView) {
        int i = R.id.calender;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.calender);
        if (imageView != null) {
            i = R.id.date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date);
            if (textView != null) {
                i = R.id.filterIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.filterIV);
                if (imageView2 != null) {
                    i = R.id.image_back;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                    if (imageView3 != null) {
                        i = R.id.layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                        if (relativeLayout != null) {
                            i = R.id.main_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                            if (toolbar != null) {
                                i = R.id.maincontrolLL;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maincontrolLL);
                                if (linearLayout != null) {
                                    i = R.id.recycler;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler);
                                    if (recyclerView != null) {
                                        i = R.id.searchIV;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                        if (imageView4 != null) {
                                            i = R.id.searchSV;
                                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchSV);
                                            if (searchView != null) {
                                                i = R.id.shareIV;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareIV);
                                                if (imageView5 != null) {
                                                    i = R.id.sv_search;
                                                    SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                                    if (searchView2 != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_notification;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_notification);
                                                            if (textView3 != null) {
                                                                return new FeedsActivityBinding((LinearLayout) rootView, imageView, textView, imageView2, imageView3, relativeLayout, toolbar, linearLayout, recyclerView, imageView4, searchView, imageView5, searchView2, textView2, textView3);
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
