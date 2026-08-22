package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BottomSheetPaymentLayoutBinding extends ViewDataBinding {
    public final RecyclerView paymentGatewaysId;
    public final TextView tvBottomSheetHeading;

    protected BottomSheetPaymentLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView paymentGatewaysId, TextView tvBottomSheetHeading) {
        super(_bindingComponent, _root, _localFieldCount);
        this.paymentGatewaysId = paymentGatewaysId;
        this.tvBottomSheetHeading = tvBottomSheetHeading;
    }

    public static BottomSheetPaymentLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetPaymentLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BottomSheetPaymentLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_payment_layout, root, attachToRoot, component);
    }

    public static BottomSheetPaymentLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetPaymentLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (BottomSheetPaymentLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_payment_layout, null, false, component);
    }

    public static BottomSheetPaymentLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetPaymentLayoutBinding bind(View view, Object component) {
        return (BottomSheetPaymentLayoutBinding) bind(component, view, R.layout.bottom_sheet_payment_layout);
    }
}
