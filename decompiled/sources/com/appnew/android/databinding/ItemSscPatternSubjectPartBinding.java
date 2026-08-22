package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternSubjectPartBinding extends ViewDataBinding {
    public final TextView sectionPartTxt;

    protected ItemSscPatternSubjectPartBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView sectionPartTxt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.sectionPartTxt = sectionPartTxt;
    }

    public static ItemSscPatternSubjectPartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectPartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternSubjectPartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_subject_part, root, attachToRoot, component);
    }

    public static ItemSscPatternSubjectPartBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectPartBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternSubjectPartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_subject_part, null, false, component);
    }

    public static ItemSscPatternSubjectPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternSubjectPartBinding bind(View view, Object component) {
        return (ItemSscPatternSubjectPartBinding) bind(component, view, R.layout.item_ssc_pattern_subject_part);
    }
}
