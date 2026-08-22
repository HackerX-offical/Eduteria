package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SubscriptionPlanItemBinding extends ViewDataBinding {
    public final TextView subscriptionDetalis;
    public final TextView subscriptionPercentageOff;
    public final TextView subscriptionPlanType;
    public final TextView subscriptionPrice;
    public final ImageView subscriptionSelect;

    protected SubscriptionPlanItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView subscriptionDetalis, TextView subscriptionPercentageOff, TextView subscriptionPlanType, TextView subscriptionPrice, ImageView subscriptionSelect) {
        super(_bindingComponent, _root, _localFieldCount);
        this.subscriptionDetalis = subscriptionDetalis;
        this.subscriptionPercentageOff = subscriptionPercentageOff;
        this.subscriptionPlanType = subscriptionPlanType;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionSelect = subscriptionSelect;
    }

    public static SubscriptionPlanItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubscriptionPlanItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SubscriptionPlanItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subscription_plan_item, root, attachToRoot, component);
    }

    public static SubscriptionPlanItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubscriptionPlanItemBinding inflate(LayoutInflater inflater, Object component) {
        return (SubscriptionPlanItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.subscription_plan_item, null, false, component);
    }

    public static SubscriptionPlanItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubscriptionPlanItemBinding bind(View view, Object component) {
        return (SubscriptionPlanItemBinding) bind(component, view, R.layout.subscription_plan_item);
    }
}
