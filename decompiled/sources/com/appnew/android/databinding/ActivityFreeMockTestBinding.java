package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFreeMockTestBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final RelativeLayout rootView;
    public final RelativeLayout tabRelativeLayout;
    public final RecyclerView tileRv;
    public final TextView toolbarTitleTV;

    private ActivityFreeMockTestBinding(RelativeLayout rootView, ImageView imageBack, Toolbar mainToolbar, RelativeLayout tabRelativeLayout, RecyclerView tileRv, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.tabRelativeLayout = tabRelativeLayout;
        this.tileRv = tileRv;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFreeMockTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFreeMockTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_free_mock_test, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFreeMockTestBinding bind(View rootView) {
        int i = R.id.image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
        if (imageView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                i = R.id.tab_relative_layout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tab_relative_layout);
                if (relativeLayout != null) {
                    i = R.id.tileRv;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                    if (recyclerView != null) {
                        i = R.id.toolbarTitleTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                        if (textView != null) {
                            return new ActivityFreeMockTestBinding((RelativeLayout) rootView, imageView, toolbar, relativeLayout, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
