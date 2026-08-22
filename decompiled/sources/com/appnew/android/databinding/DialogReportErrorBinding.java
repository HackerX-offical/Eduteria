package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DialogReportErrorBinding extends ViewDataBinding {
    public final Button btnSubmit;
    public final EditText feedbackTV;
    public final ImageView ivClose;
    public final RadioGroup radioError;

    protected DialogReportErrorBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnSubmit, EditText feedbackTV, ImageView ivClose, RadioGroup radioError) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnSubmit = btnSubmit;
        this.feedbackTV = feedbackTV;
        this.ivClose = ivClose;
        this.radioError = radioError;
    }

    public static DialogReportErrorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReportErrorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogReportErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_report_error, root, attachToRoot, component);
    }

    public static DialogReportErrorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReportErrorBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogReportErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_report_error, null, false, component);
    }

    public static DialogReportErrorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReportErrorBinding bind(View view, Object component) {
        return (DialogReportErrorBinding) bind(component, view, R.layout.dialog_report_error);
    }
}
