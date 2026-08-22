package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LayoutOptionSectionListViewBinding extends ViewDataBinding {
    public final TextView markPerQuesTV;
    public final TextView maxMarksTV;
    public final TextView negMarkPerQuesTV;
    public final TextView secNameTV;
    public final TextView totNoAttmtsTV;
    public final TextView totQuesTV;
    public final TextView totTimeTV;

    protected LayoutOptionSectionListViewBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView markPerQuesTV, TextView maxMarksTV, TextView negMarkPerQuesTV, TextView secNameTV, TextView totNoAttmtsTV, TextView totQuesTV, TextView totTimeTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.markPerQuesTV = markPerQuesTV;
        this.maxMarksTV = maxMarksTV;
        this.negMarkPerQuesTV = negMarkPerQuesTV;
        this.secNameTV = secNameTV;
        this.totNoAttmtsTV = totNoAttmtsTV;
        this.totQuesTV = totQuesTV;
        this.totTimeTV = totTimeTV;
    }

    public static LayoutOptionSectionListViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOptionSectionListViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LayoutOptionSectionListViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_option_section_list_view, root, attachToRoot, component);
    }

    public static LayoutOptionSectionListViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOptionSectionListViewBinding inflate(LayoutInflater inflater, Object component) {
        return (LayoutOptionSectionListViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_option_section_list_view, null, false, component);
    }

    public static LayoutOptionSectionListViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutOptionSectionListViewBinding bind(View view, Object component) {
        return (LayoutOptionSectionListViewBinding) bind(component, view, R.layout.layout_option_section_list_view);
    }
}
