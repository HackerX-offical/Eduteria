package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscPatternToolbarLayoutBinding extends ViewDataBinding {
    public final ImageView changeLanguage;
    public final ImageView iconMenu;
    public final LinearLayout layoutRightIcons;
    public final Toolbar mainToolbar;
    public final ProgressBar pauseProgress;
    public final ImageView pauseTest;
    public final FrameLayout pauseTestContainer;
    public final TextView testNameNew;
    public final LinearLayout textTimeContainer;
    public final TextView timerText;

    protected SscPatternToolbarLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView changeLanguage, ImageView iconMenu, LinearLayout layoutRightIcons, Toolbar mainToolbar, ProgressBar pauseProgress, ImageView pauseTest, FrameLayout pauseTestContainer, TextView testNameNew, LinearLayout textTimeContainer, TextView timerText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changeLanguage = changeLanguage;
        this.iconMenu = iconMenu;
        this.layoutRightIcons = layoutRightIcons;
        this.mainToolbar = mainToolbar;
        this.pauseProgress = pauseProgress;
        this.pauseTest = pauseTest;
        this.pauseTestContainer = pauseTestContainer;
        this.testNameNew = testNameNew;
        this.textTimeContainer = textTimeContainer;
        this.timerText = timerText;
    }

    public static SscPatternToolbarLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternToolbarLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscPatternToolbarLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_toolbar_layout, root, attachToRoot, component);
    }

    public static SscPatternToolbarLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternToolbarLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (SscPatternToolbarLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_toolbar_layout, null, false, component);
    }

    public static SscPatternToolbarLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternToolbarLayoutBinding bind(View view, Object component) {
        return (SscPatternToolbarLayoutBinding) bind(component, view, R.layout.ssc_pattern_toolbar_layout);
    }
}
