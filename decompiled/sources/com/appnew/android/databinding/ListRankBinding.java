package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ListRankBinding extends ViewDataBinding {
    public final ImageView img;
    public final RelativeLayout mainRL;
    public final TextView name;
    public final TextView rank;
    public final TextView time;
    public final ImageView view1;
    public final ImageView view2;

    protected ListRankBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView img, RelativeLayout mainRL, TextView name, TextView rank, TextView time, ImageView view1, ImageView view2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.img = img;
        this.mainRL = mainRL;
        this.name = name;
        this.rank = rank;
        this.time = time;
        this.view1 = view1;
        this.view2 = view2;
    }

    public static ListRankBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListRankBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ListRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.list_rank, root, attachToRoot, component);
    }

    public static ListRankBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListRankBinding inflate(LayoutInflater inflater, Object component) {
        return (ListRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.list_rank, null, false, component);
    }

    public static ListRankBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ListRankBinding bind(View view, Object component) {
        return (ListRankBinding) bind(component, view, R.layout.list_rank);
    }
}
