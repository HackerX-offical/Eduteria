package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCurrentAffairBinding implements ViewBinding {
    public final Button backBtn;
    public final RecyclerView currentAffairCategoryRecycler;
    public final ImageView currentAffairImageBack;
    public final RecyclerView currentAffairListRecycler;
    public final ImageView dateFilter;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final NestedScrollView nestedScroll;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final ProgressBar paginationLoader;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityCurrentAffairBinding(ConstraintLayout rootView, Button backBtn, RecyclerView currentAffairCategoryRecycler, ImageView currentAffairImageBack, RecyclerView currentAffairListRecycler, ImageView dateFilter, ImageView image, Toolbar mainToolbar, NestedScrollView nestedScroll, TextView noData, RelativeLayout noDataFoundRL, ProgressBar paginationLoader, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.currentAffairCategoryRecycler = currentAffairCategoryRecycler;
        this.currentAffairImageBack = currentAffairImageBack;
        this.currentAffairListRecycler = currentAffairListRecycler;
        this.dateFilter = dateFilter;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.nestedScroll = nestedScroll;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.paginationLoader = paginationLoader;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCurrentAffairBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCurrentAffairBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_current_affair, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCurrentAffairBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.currentAffair_category_recycler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_category_recycler);
            if (recyclerView != null) {
                i = R.id.currentAffair_image_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_image_back);
                if (imageView != null) {
                    i = R.id.currentAffair_list_recycler;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_list_recycler);
                    if (recyclerView2 != null) {
                        i = R.id.dateFilter;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dateFilter);
                        if (imageView2 != null) {
                            i = R.id.image;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                            if (imageView3 != null) {
                                i = R.id.main_toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                if (toolbar != null) {
                                    i = R.id.nested_scroll;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
                                    if (nestedScrollView != null) {
                                        i = R.id.no_data;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                        if (textView != null) {
                                            i = R.id.no_data_found_RL;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                            if (relativeLayout != null) {
                                                i = R.id.paginationLoader;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.paginationLoader);
                                                if (progressBar != null) {
                                                    i = R.id.toolbarTitleTV;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                    if (textView2 != null) {
                                                        return new ActivityCurrentAffairBinding((ConstraintLayout) rootView, button, recyclerView, imageView, recyclerView2, imageView2, imageView3, toolbar, nestedScrollView, textView, relativeLayout, progressBar, textView2);
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
