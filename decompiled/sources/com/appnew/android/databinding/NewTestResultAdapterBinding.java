package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.dataclass.TestResult;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NewTestResultAdapterBinding extends ViewDataBinding {

    @Bindable
    protected TestResult mLivetestresult;
    public final RelativeLayout parentLayout;
    public final TextView testAttempts;
    public final CircleImageView testImage;
    public final TextView testName;
    public final TextView testResult;

    public abstract void setLivetestresult(TestResult livetestresult);

    protected NewTestResultAdapterBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout parentLayout, TextView testAttempts, CircleImageView testImage, TextView testName, TextView testResult) {
        super(_bindingComponent, _root, _localFieldCount);
        this.parentLayout = parentLayout;
        this.testAttempts = testAttempts;
        this.testImage = testImage;
        this.testName = testName;
        this.testResult = testResult;
    }

    public TestResult getLivetestresult() {
        return this.mLivetestresult;
    }

    public static NewTestResultAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestResultAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (NewTestResultAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_test_result_adapter, root, attachToRoot, component);
    }

    public static NewTestResultAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestResultAdapterBinding inflate(LayoutInflater inflater, Object component) {
        return (NewTestResultAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.new_test_result_adapter, null, false, component);
    }

    public static NewTestResultAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewTestResultAdapterBinding bind(View view, Object component) {
        return (NewTestResultAdapterBinding) bind(component, view, R.layout.new_test_result_adapter);
    }
}
