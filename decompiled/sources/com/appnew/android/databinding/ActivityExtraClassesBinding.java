package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityExtraClassesBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final ConstraintLayout rootView;
    public final TabLayout tabLayoutEC;
    public final TextView toolbarTitleTV;
    public final ViewPager viewPagerEC;

    private ActivityExtraClassesBinding(ConstraintLayout rootView, ImageView imageBack, Toolbar mainToolbar, TabLayout tabLayoutEC, TextView toolbarTitleTV, ViewPager viewPagerEC) {
        this.rootView = rootView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.tabLayoutEC = tabLayoutEC;
        this.toolbarTitleTV = toolbarTitleTV;
        this.viewPagerEC = viewPagerEC;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityExtraClassesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityExtraClassesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_extra_classes, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityExtraClassesBinding bind(View rootView) {
        int i = R.id.image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
        if (imageView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                i = R.id.tabLayout_EC;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.tabLayout_EC);
                if (tabLayout != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        i = R.id.viewPager_EC;
                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.viewPager_EC);
                        if (viewPager != null) {
                            return new ActivityExtraClassesBinding((ConstraintLayout) rootView, imageView, toolbar, tabLayout, textView, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
