package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.sme.SmeStudentModel;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CustomSmeStudentlistBinding extends ViewDataBinding {
    public final CircleImageView SmeStudentImage;

    @Bindable
    protected SmeStudentModel mData;

    public abstract void setData(SmeStudentModel data);

    protected CustomSmeStudentlistBinding(Object _bindingComponent, View _root, int _localFieldCount, CircleImageView SmeStudentImage) {
        super(_bindingComponent, _root, _localFieldCount);
        this.SmeStudentImage = SmeStudentImage;
    }

    public SmeStudentModel getData() {
        return this.mData;
    }

    public static CustomSmeStudentlistBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSmeStudentlistBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSmeStudentlistBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_sme_studentlist, root, attachToRoot, component);
    }

    public static CustomSmeStudentlistBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSmeStudentlistBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSmeStudentlistBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_sme_studentlist, null, false, component);
    }

    public static CustomSmeStudentlistBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSmeStudentlistBinding bind(View view, Object component) {
        return (CustomSmeStudentlistBinding) bind(component, view, R.layout.custom_sme_studentlist);
    }
}
