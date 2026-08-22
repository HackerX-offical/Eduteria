package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NewTestresultVmBinding extends ViewDataBinding {
    public final RecyclerView liveTestRecycler;

    @Bindable
    protected Data mLivetestresult;
    public final TextView newCourseTxt;
    public final View view1;
    public final TextView viewAll;

    public abstract void setLivetestresult(Data livetestresult);

    protected NewTestresultVmBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView liveTestRecycler, TextView newCourseTxt, View view1, TextView viewAll) {
        super(_bindingComponent, _root, _localFieldCount);
        this.liveTestRecycler = liveTestRecycler;
        this.newCourseTxt = newCourseTxt;
        this.view1 = view1;
        this.viewAll = viewAll;
    }

    public Data getLivetestresult() {
        return this.mLivetestresult;
    }

    public static NewTestresultVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestresultVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NewTestresultVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_testresult_vm, root, attachToRoot, component);
    }

    public static NewTestresultVmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestresultVmBinding inflate(LayoutInflater inflater, Object component) {
        return (NewTestresultVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_testresult_vm, null, false, component);
    }

    public static NewTestresultVmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestresultVmBinding bind(View view, Object component) {
        return (NewTestresultVmBinding) bind(component, view, R.layout.new_testresult_vm);
    }
}
