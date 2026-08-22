package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternOptionBinding extends ViewDataBinding {
    public final TextView optionIconTV;
    public final LinearLayout optionRoot;
    public final TextView optionTextFIB;
    public final MathView tvOptionText;

    protected ItemSscPatternOptionBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView optionIconTV, LinearLayout optionRoot, TextView optionTextFIB, MathView tvOptionText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.optionIconTV = optionIconTV;
        this.optionRoot = optionRoot;
        this.optionTextFIB = optionTextFIB;
        this.tvOptionText = tvOptionText;
    }

    public static ItemSscPatternOptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternOptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternOptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_option, root, attachToRoot, component);
    }

    public static ItemSscPatternOptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternOptionBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternOptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_option, null, false, component);
    }

    public static ItemSscPatternOptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternOptionBinding bind(View view, Object component) {
        return (ItemSscPatternOptionBinding) bind(component, view, R.layout.item_ssc_pattern_option);
    }
}
