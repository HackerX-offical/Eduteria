package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscPatternBackSubmitDialogBinding extends ViewDataBinding {
    public final Button btnNo;
    public final Button btnYes;
    public final View divider1;
    public final View divider2;
    public final View divider3;
    public final View divider4;
    public final Group groupStats;
    public final ImageView iconAttempted;
    public final ImageView iconMarked;
    public final ImageView iconTime;
    public final ImageView iconUnattempted;
    public final TextView tvAttemptedLabel;
    public final TextView tvAttemptedValue;
    public final TextView tvMarkedLabel;
    public final TextView tvMarkedValue;
    public final TextView tvQuestion;
    public final TextView tvTimeLabel;
    public final TextView tvTimeValue;
    public final TextView tvUnattemptedLabel;
    public final TextView tvUnattemptedValue;

    protected SscPatternBackSubmitDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnNo, Button btnYes, View divider1, View divider2, View divider3, View divider4, Group groupStats, ImageView iconAttempted, ImageView iconMarked, ImageView iconTime, ImageView iconUnattempted, TextView tvAttemptedLabel, TextView tvAttemptedValue, TextView tvMarkedLabel, TextView tvMarkedValue, TextView tvQuestion, TextView tvTimeLabel, TextView tvTimeValue, TextView tvUnattemptedLabel, TextView tvUnattemptedValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnNo = btnNo;
        this.btnYes = btnYes;
        this.divider1 = divider1;
        this.divider2 = divider2;
        this.divider3 = divider3;
        this.divider4 = divider4;
        this.groupStats = groupStats;
        this.iconAttempted = iconAttempted;
        this.iconMarked = iconMarked;
        this.iconTime = iconTime;
        this.iconUnattempted = iconUnattempted;
        this.tvAttemptedLabel = tvAttemptedLabel;
        this.tvAttemptedValue = tvAttemptedValue;
        this.tvMarkedLabel = tvMarkedLabel;
        this.tvMarkedValue = tvMarkedValue;
        this.tvQuestion = tvQuestion;
        this.tvTimeLabel = tvTimeLabel;
        this.tvTimeValue = tvTimeValue;
        this.tvUnattemptedLabel = tvUnattemptedLabel;
        this.tvUnattemptedValue = tvUnattemptedValue;
    }

    public static SscPatternBackSubmitDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternBackSubmitDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscPatternBackSubmitDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_back_submit_dialog, root, attachToRoot, component);
    }

    public static SscPatternBackSubmitDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternBackSubmitDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (SscPatternBackSubmitDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_back_submit_dialog, null, false, component);
    }

    public static SscPatternBackSubmitDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternBackSubmitDialogBinding bind(View view, Object component) {
        return (SscPatternBackSubmitDialogBinding) bind(component, view, R.layout.ssc_pattern_back_submit_dialog);
    }
}
