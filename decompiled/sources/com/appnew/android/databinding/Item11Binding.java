package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Item11Binding extends ViewDataBinding {
    public final LinearLayout main;
    public final LinearLayout relativeLayout3;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;

    protected Item11Binding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout main, LinearLayout relativeLayout3, TextView text1, TextView text2, TextView text3, TextView text4) {
        super(_bindingComponent, _root, _localFieldCount);
        this.main = main;
        this.relativeLayout3 = relativeLayout3;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public static Item11Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Item11Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Item11Binding) ViewDataBinding.inflateInternal(inflater, R.layout.item11, root, attachToRoot, component);
    }

    public static Item11Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Item11Binding inflate(LayoutInflater inflater, Object component) {
        return (Item11Binding) ViewDataBinding.inflateInternal(inflater, R.layout.item11, null, false, component);
    }

    public static Item11Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Item11Binding bind(View view, Object component) {
        return (Item11Binding) bind(component, view, R.layout.item11);
    }
}
