package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscEnterFibDialogBinding extends ViewDataBinding {
    public final Button btnSubmit;
    public final EditText message;

    protected SscEnterFibDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnSubmit, EditText message) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnSubmit = btnSubmit;
        this.message = message;
    }

    public static SscEnterFibDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscEnterFibDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscEnterFibDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_enter_fib_dialog, root, attachToRoot, component);
    }

    public static SscEnterFibDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscEnterFibDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscEnterFibDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_enter_fib_dialog, null, false, component);
    }

    public static SscEnterFibDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscEnterFibDialogBinding bind(View view, Object component) {
        return (SscEnterFibDialogBinding) bind(component, view, R.layout.ssc_enter_fib_dialog);
    }
}
