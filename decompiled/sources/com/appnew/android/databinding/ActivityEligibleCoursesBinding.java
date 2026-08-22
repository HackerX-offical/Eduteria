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
public final class ActivityEligibleCoursesBinding implements ViewBinding {
    public final RecyclerView eligibleRecyclerView;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityEligibleCoursesBinding(RelativeLayout rootView, RecyclerView eligibleRecyclerView, ImageView imageBack, Toolbar mainToolbar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.eligibleRecyclerView = eligibleRecyclerView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEligibleCoursesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityEligibleCoursesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_eligible_courses, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityEligibleCoursesBinding bind(View rootView) {
        int i = R.id.eligible_recyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.eligible_recyclerView);
        if (recyclerView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new ActivityEligibleCoursesBinding((RelativeLayout) rootView, recyclerView, imageView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
