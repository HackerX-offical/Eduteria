package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class SscPatternDrawerLayoutBindingImpl extends SscPatternDrawerLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.headerContainer, 1);
        sparseIntArray.put(R.id.symbolText, 2);
        sparseIntArray.put(R.id.instructionText, 3);
        sparseIntArray.put(R.id.divHeader, 4);
        sparseIntArray.put(R.id.sectionAsPart, 5);
        sparseIntArray.put(R.id.selectedSectionName, 6);
        sparseIntArray.put(R.id.answeredQuesCount, 7);
        sparseIntArray.put(R.id.unansweredQuesCount, 8);
        sparseIntArray.put(R.id.markedQuesCount, 9);
        sparseIntArray.put(R.id.rvQuestionGrid, 10);
        sparseIntArray.put(R.id.btnSubmitContainer, 11);
        sparseIntArray.put(R.id.btnSectionSwitch, 12);
        sparseIntArray.put(R.id.btnSubmitTest, 13);
    }

    public SscPatternDrawerLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private SscPatternDrawerLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[7], (AppCompatButton) bindings[12], (LinearLayout) bindings[11], (AppCompatButton) bindings[13], (View) bindings[4], (LinearLayout) bindings[1], (LinearLayout) bindings[3], (TextView) bindings[9], (RecyclerView) bindings[10], (RecyclerView) bindings[5], (TextView) bindings[6], (LinearLayout) bindings[2], (TextView) bindings[8]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
