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
public abstract class EnterFibLayoutBinding extends ViewDataBinding {
    public final Button btnSubmit;
    public final EditText message;

    protected EnterFibLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnSubmit, EditText message) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnSubmit = btnSubmit;
        this.message = message;
    }

    public static EnterFibLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EnterFibLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EnterFibLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.enter_fib_layout, root, attachToRoot, component);
    }

    public static EnterFibLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EnterFibLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (EnterFibLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.enter_fib_layout, null, false, component);
    }

    public static EnterFibLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EnterFibLayoutBinding bind(View view, Object component) {
        return (EnterFibLayoutBinding) bind(component, view, R.layout.enter_fib_layout);
    }
}
