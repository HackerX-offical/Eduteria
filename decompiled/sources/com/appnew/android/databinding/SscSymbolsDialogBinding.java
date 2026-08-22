package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscSymbolsDialogBinding extends ViewDataBinding {
    public final AppCompatButton btnBackToTest;
    public final RelativeLayout btnContainer;

    protected SscSymbolsDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton btnBackToTest, RelativeLayout btnContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBackToTest = btnBackToTest;
        this.btnContainer = btnContainer;
    }

    public static SscSymbolsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscSymbolsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscSymbolsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_symbols_dialog, root, attachToRoot, component);
    }

    public static SscSymbolsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscSymbolsDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscSymbolsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_symbols_dialog, null, false, component);
    }

    public static SscSymbolsDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscSymbolsDialogBinding bind(View view, Object component) {
        return (SscSymbolsDialogBinding) bind(component, view, R.layout.ssc_symbols_dialog);
    }
}
