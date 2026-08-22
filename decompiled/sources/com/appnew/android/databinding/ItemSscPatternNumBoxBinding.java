package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternNumBoxBinding extends ViewDataBinding {
    public final TextView tvGridNumber;

    protected ItemSscPatternNumBoxBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvGridNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvGridNumber = tvGridNumber;
    }

    public static ItemSscPatternNumBoxBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternNumBoxBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternNumBoxBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_num_box, root, attachToRoot, component);
    }

    public static ItemSscPatternNumBoxBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternNumBoxBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternNumBoxBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_num_box, null, false, component);
    }

    public static ItemSscPatternNumBoxBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternNumBoxBinding bind(View view, Object component) {
        return (ItemSscPatternNumBoxBinding) bind(component, view, R.layout.item_ssc_pattern_num_box);
    }
}
