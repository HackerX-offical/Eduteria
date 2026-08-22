package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscPatternSectionSwitchDailogBinding extends ViewDataBinding {
    public final Button btnNoSwitch;
    public final Button btnYesSwitch;
    public final TextView sectionSubTitle;
    public final TextView sectionTitle;

    protected SscPatternSectionSwitchDailogBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnNoSwitch, Button btnYesSwitch, TextView sectionSubTitle, TextView sectionTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnNoSwitch = btnNoSwitch;
        this.btnYesSwitch = btnYesSwitch;
        this.sectionSubTitle = sectionSubTitle;
        this.sectionTitle = sectionTitle;
    }

    public static SscPatternSectionSwitchDailogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternSectionSwitchDailogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscPatternSectionSwitchDailogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_section_switch_dailog, root, attachToRoot, component);
    }

    public static SscPatternSectionSwitchDailogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternSectionSwitchDailogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscPatternSectionSwitchDailogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_section_switch_dailog, null, false, component);
    }

    public static SscPatternSectionSwitchDailogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternSectionSwitchDailogBinding bind(View view, Object component) {
        return (SscPatternSectionSwitchDailogBinding) bind(component, view, R.layout.ssc_pattern_section_switch_dailog);
    }
}
