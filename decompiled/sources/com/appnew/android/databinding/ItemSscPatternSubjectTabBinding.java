package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternSubjectTabBinding extends ViewDataBinding {
    public final TextView tvSubjectName;
    public final View viewIndicator;

    protected ItemSscPatternSubjectTabBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvSubjectName, View viewIndicator) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvSubjectName = tvSubjectName;
        this.viewIndicator = viewIndicator;
    }

    public static ItemSscPatternSubjectTabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectTabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternSubjectTabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_subject_tab, root, attachToRoot, component);
    }

    public static ItemSscPatternSubjectTabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectTabBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternSubjectTabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_subject_tab, null, false, component);
    }

    public static ItemSscPatternSubjectTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectTabBinding bind(View view, Object component) {
        return (ItemSscPatternSubjectTabBinding) bind(component, view, R.layout.item_ssc_pattern_subject_tab);
    }
}
