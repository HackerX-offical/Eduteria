package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityLoggedOutUserBinding extends ViewDataBinding {
    public final ConstraintLayout main;

    protected ActivityLoggedOutUserBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout main) {
        super(_bindingComponent, _root, _localFieldCount);
        this.main = main;
    }

    public static ActivityLoggedOutUserBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoggedOutUserBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityLoggedOutUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_logged_out_user, root, attachToRoot, component);
    }

    public static ActivityLoggedOutUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoggedOutUserBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityLoggedOutUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_logged_out_user, null, false, component);
    }

    public static ActivityLoggedOutUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoggedOutUserBinding bind(View view, Object component) {
        return (ActivityLoggedOutUserBinding) bind(component, view, R.layout.activity_logged_out_user);
    }
}
