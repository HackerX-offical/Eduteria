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
public abstract class NewCourseVmBinding extends ViewDataBinding {

    @Bindable
    protected Data mCoursedata;
    public final RecyclerView newCourseRecycler;
    public final TextView newCourseTxt;
    public final View view1;
    public final TextView viewAll;

    public abstract void setCoursedata(Data coursedata);

    protected NewCourseVmBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView newCourseRecycler, TextView newCourseTxt, View view1, TextView viewAll) {
        super(_bindingComponent, _root, _localFieldCount);
        this.newCourseRecycler = newCourseRecycler;
        this.newCourseTxt = newCourseTxt;
        this.view1 = view1;
        this.viewAll = viewAll;
    }

    public Data getCoursedata() {
        return this.mCoursedata;
    }

    public static NewCourseVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewCourseVmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NewCourseVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_course_vm, root, attachToRoot, component);
    }

    public static NewCourseVmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewCourseVmBinding inflate(LayoutInflater inflater, Object component) {
        return (NewCourseVmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_course_vm, null, false, component);
    }

    public static NewCourseVmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewCourseVmBinding bind(View view, Object component) {
        return (NewCourseVmBinding) bind(component, view, R.layout.new_course_vm);
    }
}
