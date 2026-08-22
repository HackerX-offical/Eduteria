package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.sme.Doubt;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CustomStudentDoubtListBinding extends ViewDataBinding {
    public final ImageView SmeStudentImage;

    @Bindable
    protected Doubt mData;

    public abstract void setData(Doubt data);

    protected CustomStudentDoubtListBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView SmeStudentImage) {
        super(_bindingComponent, _root, _localFieldCount);
        this.SmeStudentImage = SmeStudentImage;
    }

    public Doubt getData() {
        return this.mData;
    }

    public static CustomStudentDoubtListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomStudentDoubtListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomStudentDoubtListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_student_doubt_list, root, attachToRoot, component);
    }

    public static CustomStudentDoubtListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomStudentDoubtListBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomStudentDoubtListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_student_doubt_list, null, false, component);
    }

    public static CustomStudentDoubtListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomStudentDoubtListBinding bind(View view, Object component) {
        return (CustomStudentDoubtListBinding) bind(component, view, R.layout.custom_student_doubt_list);
    }
}
