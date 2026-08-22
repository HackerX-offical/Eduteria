package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SscPatternDrawerLayoutBinding extends ViewDataBinding {
    public final TextView answeredQuesCount;
    public final AppCompatButton btnSectionSwitch;
    public final LinearLayout btnSubmitContainer;
    public final AppCompatButton btnSubmitTest;
    public final View divHeader;
    public final LinearLayout headerContainer;
    public final LinearLayout instructionText;
    public final TextView markedQuesCount;
    public final RecyclerView rvQuestionGrid;
    public final RecyclerView sectionAsPart;
    public final TextView selectedSectionName;
    public final LinearLayout symbolText;
    public final TextView unansweredQuesCount;

    protected SscPatternDrawerLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView answeredQuesCount, AppCompatButton btnSectionSwitch, LinearLayout btnSubmitContainer, AppCompatButton btnSubmitTest, View divHeader, LinearLayout headerContainer, LinearLayout instructionText, TextView markedQuesCount, RecyclerView rvQuestionGrid, RecyclerView sectionAsPart, TextView selectedSectionName, LinearLayout symbolText, TextView unansweredQuesCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.answeredQuesCount = answeredQuesCount;
        this.btnSectionSwitch = btnSectionSwitch;
        this.btnSubmitContainer = btnSubmitContainer;
        this.btnSubmitTest = btnSubmitTest;
        this.divHeader = divHeader;
        this.headerContainer = headerContainer;
        this.instructionText = instructionText;
        this.markedQuesCount = markedQuesCount;
        this.rvQuestionGrid = rvQuestionGrid;
        this.sectionAsPart = sectionAsPart;
        this.selectedSectionName = selectedSectionName;
        this.symbolText = symbolText;
        this.unansweredQuesCount = unansweredQuesCount;
    }

    public static SscPatternDrawerLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternDrawerLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SscPatternDrawerLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_drawer_layout, root, attachToRoot, component);
    }

    public static SscPatternDrawerLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternDrawerLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (SscPatternDrawerLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ssc_pattern_drawer_layout, null, false, component);
    }

    public static SscPatternDrawerLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SscPatternDrawerLayoutBinding bind(View view, Object component) {
        return (SscPatternDrawerLayoutBinding) bind(component, view, R.layout.ssc_pattern_drawer_layout);
    }
}
