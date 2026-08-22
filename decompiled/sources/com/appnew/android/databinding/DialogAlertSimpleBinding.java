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
public abstract class DialogAlertSimpleBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final TextView msgDialog;
    public final TextView titleDialog;

    protected DialogAlertSimpleBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnCancel, Button btnSubmit, TextView msgDialog, TextView titleDialog) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.msgDialog = msgDialog;
        this.titleDialog = titleDialog;
    }

    public static DialogAlertSimpleBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlertSimpleBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAlertSimpleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_alert_simple, root, attachToRoot, component);
    }

    public static DialogAlertSimpleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlertSimpleBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAlertSimpleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_alert_simple, null, false, component);
    }

    public static DialogAlertSimpleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlertSimpleBinding bind(View view, Object component) {
        return (DialogAlertSimpleBinding) bind(component, view, R.layout.dialog_alert_simple);
    }
}
