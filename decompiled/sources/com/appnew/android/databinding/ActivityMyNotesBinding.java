package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityMyNotesBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final FloatingActionButton floatingButton;
    public final ImageView imageIV;
    public final ImageView ivBack;
    public final NestedScrollView llMain;
    public final Toolbar myProgressToolbar;
    public final RecyclerView recyclerNotes;
    private final RelativeLayout rootView;
    public final TextView toolbartitleTV;
    public final TextView tvNoDataFound;

    private ActivityMyNotesBinding(RelativeLayout rootView, AppBarLayout appBarLayout, FloatingActionButton floatingButton, ImageView imageIV, ImageView ivBack, NestedScrollView llMain, Toolbar myProgressToolbar, RecyclerView recyclerNotes, TextView toolbartitleTV, TextView tvNoDataFound) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.floatingButton = floatingButton;
        this.imageIV = imageIV;
        this.ivBack = ivBack;
        this.llMain = llMain;
        this.myProgressToolbar = myProgressToolbar;
        this.recyclerNotes = recyclerNotes;
        this.toolbartitleTV = toolbartitleTV;
        this.tvNoDataFound = tvNoDataFound;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMyNotesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMyNotesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_my_notes, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMyNotesBinding bind(View rootView) {
        int i = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i = R.id.floating_button;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.floating_button);
            if (floatingActionButton != null) {
                i = R.id.imageIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                if (imageView != null) {
                    i = R.id.iv_back;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                    if (imageView2 != null) {
                        i = R.id.ll_main;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.ll_main);
                        if (nestedScrollView != null) {
                            i = R.id.myProgress_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.myProgress_toolbar);
                            if (toolbar != null) {
                                i = R.id.recycler_notes;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_notes);
                                if (recyclerView != null) {
                                    i = R.id.toolbartitleTV;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                    if (textView != null) {
                                        i = R.id.tv_no_data_found;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_no_data_found);
                                        if (textView2 != null) {
                                            return new ActivityMyNotesBinding((RelativeLayout) rootView, appBarLayout, floatingActionButton, imageView, imageView2, nestedScrollView, toolbar, recyclerView, textView, textView2);
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
