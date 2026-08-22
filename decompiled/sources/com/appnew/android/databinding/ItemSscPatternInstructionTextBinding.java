package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternInstructionTextBinding extends ViewDataBinding {
    public final TextView instructionText;

    protected ItemSscPatternInstructionTextBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView instructionText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.instructionText = instructionText;
    }

    public static ItemSscPatternInstructionTextBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternInstructionTextBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternInstructionTextBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_instruction_text, root, attachToRoot, component);
    }

    public static ItemSscPatternInstructionTextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternInstructionTextBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternInstructionTextBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_instruction_text, null, false, component);
    }

    public static ItemSscPatternInstructionTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternInstructionTextBinding bind(View view, Object component) {
        return (ItemSscPatternInstructionTextBinding) bind(component, view, R.layout.item_ssc_pattern_instruction_text);
    }
}
