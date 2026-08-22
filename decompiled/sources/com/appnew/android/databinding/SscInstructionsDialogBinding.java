package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscInstructionsDialogBinding extends ViewDataBinding {
    public final AppCompatButton btnBackToTest;
    public final RelativeLayout btnContainer;
    public final MathView instructionDesc;
    public final RecyclerView instructionTxtRecycler;
    public final TextView testSeriesName;
    public final TextView testTotalDuration;
    public final TextView testTotalMark;

    protected SscInstructionsDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton btnBackToTest, RelativeLayout btnContainer, MathView instructionDesc, RecyclerView instructionTxtRecycler, TextView testSeriesName, TextView testTotalDuration, TextView testTotalMark) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBackToTest = btnBackToTest;
        this.btnContainer = btnContainer;
        this.instructionDesc = instructionDesc;
        this.instructionTxtRecycler = instructionTxtRecycler;
        this.testSeriesName = testSeriesName;
        this.testTotalDuration = testTotalDuration;
        this.testTotalMark = testTotalMark;
    }

    public static SscInstructionsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscInstructionsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscInstructionsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_instructions_dialog, root, attachToRoot, component);
    }

    public static SscInstructionsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscInstructionsDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscInstructionsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_instructions_dialog, null, false, component);
    }

    public static SscInstructionsDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscInstructionsDialogBinding bind(View view, Object component) {
        return (SscInstructionsDialogBinding) bind(component, view, R.layout.ssc_instructions_dialog);
    }
}
