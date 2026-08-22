package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscPatternTimeOutDialogBinding extends ViewDataBinding {
    public final AppCompatButton btnOk;
    public final TextView tvTimeoutDesc;
    public final TextView tvTimeoutTitle;

    protected SscPatternTimeOutDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton btnOk, TextView tvTimeoutDesc, TextView tvTimeoutTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnOk = btnOk;
        this.tvTimeoutDesc = tvTimeoutDesc;
        this.tvTimeoutTitle = tvTimeoutTitle;
    }

    public static SscPatternTimeOutDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternTimeOutDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscPatternTimeOutDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_time_out_dialog, root, attachToRoot, component);
    }

    public static SscPatternTimeOutDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternTimeOutDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscPatternTimeOutDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_time_out_dialog, null, false, component);
    }

    public static SscPatternTimeOutDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternTimeOutDialogBinding bind(View view, Object component) {
        return (SscPatternTimeOutDialogBinding) bind(component, view, R.layout.ssc_pattern_time_out_dialog);
    }
}
