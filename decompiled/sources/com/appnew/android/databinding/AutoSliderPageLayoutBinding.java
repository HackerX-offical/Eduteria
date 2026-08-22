package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.Theme.InfiniteBannerIndicator;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AutoSliderPageLayoutBinding implements ViewBinding {
    public final InfiniteBannerIndicator bannerIndicator;
    public final ConstraintLayout parentCL;
    private final ConstraintLayout rootView;
    public final ViewPager2 viewPager2;

    private AutoSliderPageLayoutBinding(ConstraintLayout rootView, InfiniteBannerIndicator bannerIndicator, ConstraintLayout parentCL, ViewPager2 viewPager2) {
        this.rootView = rootView;
        this.bannerIndicator = bannerIndicator;
        this.parentCL = parentCL;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AutoSliderPageLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AutoSliderPageLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.auto_slider_page_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AutoSliderPageLayoutBinding bind(View rootView) {
        int i = R.id.bannerIndicator;
        InfiniteBannerIndicator infiniteBannerIndicator = (InfiniteBannerIndicator) ViewBindings.findChildViewById(rootView, R.id.bannerIndicator);
        if (infiniteBannerIndicator != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, R.id.viewPager2);
            if (viewPager2 != null) {
                return new AutoSliderPageLayoutBinding(constraintLayout, infiniteBannerIndicator, constraintLayout, viewPager2);
            }
            i = R.id.viewPager2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
