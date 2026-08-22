package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityIntroBinding extends ViewDataBinding {
    public final TextView backText;
    public final FrameLayout container;
    public final RelativeLayout headerLayout;
    public final RelativeLayout layoutParent;
    public final LinearLayout nextBack;
    public final LinearLayout nextLayout;
    public final TextView nextText;
    public final ProgressBar progressBar;
    public final TextView step;

    protected ActivityIntroBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView backText, FrameLayout container, RelativeLayout headerLayout, RelativeLayout layoutParent, LinearLayout nextBack, LinearLayout nextLayout, TextView nextText, ProgressBar progressBar, TextView step) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backText = backText;
        this.container = container;
        this.headerLayout = headerLayout;
        this.layoutParent = layoutParent;
        this.nextBack = nextBack;
        this.nextLayout = nextLayout;
        this.nextText = nextText;
        this.progressBar = progressBar;
        this.step = step;
    }

    public static ActivityIntroBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityIntroBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityIntroBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_intro, root, attachToRoot, component);
    }

    public static ActivityIntroBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityIntroBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityIntroBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_intro, null, false, component);
    }

    public static ActivityIntroBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityIntroBinding bind(View view, Object component) {
        return (ActivityIntroBinding) bind(component, view, R.layout.activity_intro);
    }
}
