package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityTestBaseSscpatternBinding extends ViewDataBinding {
    public final LinearLayout bottomBar;
    public final AppCompatButton btnMarkReview;
    public final AppCompatButton btnPrevious;
    public final AppCompatButton btnSaveNext;
    public final DrawerLayout drawerLayout;
    public final SscPatternDrawerLayoutBinding includeDrawerContent;
    public final SscPatternToolbarLayoutBinding includeToolbar;
    public final ConstraintLayout mainContent;
    public final ConstraintLayout navDrawerContainer;
    public final ProgressBar progressBarSubmit;
    public final RecyclerView recyclerSectionTabs;
    public final ConstraintLayout statsContainer;
    public final LinearLayout submitLoader;
    public final TextView submitLoaderText;
    public final TextView timeLeftTxt;
    public final TextView tvTotalCount;
    public final TextView tvTotalLabel;
    public final ViewPager2 viewPagerQuestions;

    protected ActivityTestBaseSscpatternBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout bottomBar, AppCompatButton btnMarkReview, AppCompatButton btnPrevious, AppCompatButton btnSaveNext, DrawerLayout drawerLayout, SscPatternDrawerLayoutBinding includeDrawerContent, SscPatternToolbarLayoutBinding includeToolbar, ConstraintLayout mainContent, ConstraintLayout navDrawerContainer, ProgressBar progressBarSubmit, RecyclerView recyclerSectionTabs, ConstraintLayout statsContainer, LinearLayout submitLoader, TextView submitLoaderText, TextView timeLeftTxt, TextView tvTotalCount, TextView tvTotalLabel, ViewPager2 viewPagerQuestions) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bottomBar = bottomBar;
        this.btnMarkReview = btnMarkReview;
        this.btnPrevious = btnPrevious;
        this.btnSaveNext = btnSaveNext;
        this.drawerLayout = drawerLayout;
        this.includeDrawerContent = includeDrawerContent;
        this.includeToolbar = includeToolbar;
        this.mainContent = mainContent;
        this.navDrawerContainer = navDrawerContainer;
        this.progressBarSubmit = progressBarSubmit;
        this.recyclerSectionTabs = recyclerSectionTabs;
        this.statsContainer = statsContainer;
        this.submitLoader = submitLoader;
        this.submitLoaderText = submitLoaderText;
        this.timeLeftTxt = timeLeftTxt;
        this.tvTotalCount = tvTotalCount;
        this.tvTotalLabel = tvTotalLabel;
        this.viewPagerQuestions = viewPagerQuestions;
    }

    public static ActivityTestBaseSscpatternBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityTestBaseSscpatternBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityTestBaseSscpatternBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_test_base_sscpattern, root, attachToRoot, component);
    }

    public static ActivityTestBaseSscpatternBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityTestBaseSscpatternBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityTestBaseSscpatternBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_test_base_sscpattern, null, false, component);
    }

    public static ActivityTestBaseSscpatternBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityTestBaseSscpatternBinding bind(View view, Object component) {
        return (ActivityTestBaseSscpatternBinding) bind(component, view, R.layout.activity_test_base_sscpattern);
    }
}
