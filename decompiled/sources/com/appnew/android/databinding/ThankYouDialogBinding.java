package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ThankYouDialogBinding extends ViewDataBinding {
    public final ImageView dialogImage;

    @Bindable
    protected String mMessage;

    public abstract void setMessage(String message);

    protected ThankYouDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView dialogImage) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dialogImage = dialogImage;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public static ThankYouDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThankYouDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ThankYouDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.thank_you_dialog, root, attachToRoot, component);
    }

    public static ThankYouDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThankYouDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ThankYouDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.thank_you_dialog, null, false, component);
    }

    public static ThankYouDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThankYouDialogBinding bind(View view, Object component) {
        return (ThankYouDialogBinding) bind(component, view, R.layout.thank_you_dialog);
    }
}
