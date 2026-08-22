package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ViewDialogBinding extends ViewDataBinding {
    public final TextView dismissBtn;
    public final TextView message;
    public final TextView title;

    protected ViewDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView dismissBtn, TextView message, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dismissBtn = dismissBtn;
        this.message = message;
        this.title = title;
    }

    public static ViewDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_dialog, root, attachToRoot, component);
    }

    public static ViewDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_dialog, null, false, component);
    }

    public static ViewDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBinding bind(View view, Object component) {
        return (ViewDialogBinding) bind(component, view, R.layout.view_dialog);
    }
}
