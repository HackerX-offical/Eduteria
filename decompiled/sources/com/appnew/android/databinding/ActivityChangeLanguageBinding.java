package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityChangeLanguageBinding extends ViewDataBinding {
    public final Button continueBtn;
    public final RadioButton engRadio;
    public final LinearLayout englishRL;
    public final LinearLayout hindiRL;
    public final RadioButton hindiRadio;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final TextView toolbarTitleTV;

    protected ActivityChangeLanguageBinding(Object _bindingComponent, View _root, int _localFieldCount, Button continueBtn, RadioButton engRadio, LinearLayout englishRL, LinearLayout hindiRL, RadioButton hindiRadio, ImageView imageBack, Toolbar mainToolbar, TextView toolbarTitleTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.continueBtn = continueBtn;
        this.engRadio = engRadio;
        this.englishRL = englishRL;
        this.hindiRL = hindiRL;
        this.hindiRadio = hindiRadio;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    public static ActivityChangeLanguageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeLanguageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityChangeLanguageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_change_language, root, attachToRoot, component);
    }

    public static ActivityChangeLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeLanguageBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityChangeLanguageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_change_language, null, false, component);
    }

    public static ActivityChangeLanguageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeLanguageBinding bind(View view, Object component) {
        return (ActivityChangeLanguageBinding) bind(component, view, R.layout.activity_change_language);
    }
}
