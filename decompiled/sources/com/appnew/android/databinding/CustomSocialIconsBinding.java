package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.datamodel.IconModel;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CustomSocialIconsBinding extends ViewDataBinding {

    @Bindable
    protected IconModel mSocialItem;
    public final ImageView socialIcons;

    public abstract void setSocialItem(IconModel socialItem);

    protected CustomSocialIconsBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView socialIcons) {
        super(_bindingComponent, _root, _localFieldCount);
        this.socialIcons = socialIcons;
    }

    public IconModel getSocialItem() {
        return this.mSocialItem;
    }

    public static CustomSocialIconsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSocialIconsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSocialIconsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_social_icons, root, attachToRoot, component);
    }

    public static CustomSocialIconsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSocialIconsBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSocialIconsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_social_icons, null, false, component);
    }

    public static CustomSocialIconsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSocialIconsBinding bind(View view, Object component) {
        return (CustomSocialIconsBinding) bind(component, view, R.layout.custom_social_icons);
    }
}
