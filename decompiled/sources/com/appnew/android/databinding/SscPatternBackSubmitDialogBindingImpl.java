package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class SscPatternBackSubmitDialogBindingImpl extends SscPatternBackSubmitDialogBinding {
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
        sparseIntArray.put(R.id.iconTime, 1);
        sparseIntArray.put(R.id.tvTimeLabel, 2);
        sparseIntArray.put(R.id.tvTimeValue, 3);
        sparseIntArray.put(R.id.divider1, 4);
        sparseIntArray.put(R.id.iconAttempted, 5);
        sparseIntArray.put(R.id.tvAttemptedLabel, 6);
        sparseIntArray.put(R.id.tvAttemptedValue, 7);
        sparseIntArray.put(R.id.divider2, 8);
        sparseIntArray.put(R.id.iconUnattempted, 9);
        sparseIntArray.put(R.id.tvUnattemptedLabel, 10);
        sparseIntArray.put(R.id.tvUnattemptedValue, 11);
        sparseIntArray.put(R.id.divider3, 12);
        sparseIntArray.put(R.id.iconMarked, 13);
        sparseIntArray.put(R.id.tvMarkedLabel, 14);
        sparseIntArray.put(R.id.tvMarkedValue, 15);
        sparseIntArray.put(R.id.divider4, 16);
        sparseIntArray.put(R.id.tvQuestion, 17);
        sparseIntArray.put(R.id.btnYes, 18);
        sparseIntArray.put(R.id.btnNo, 19);
        sparseIntArray.put(R.id.groupStats, 20);
    }

    public SscPatternBackSubmitDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private SscPatternBackSubmitDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[19], (Button) bindings[18], (View) bindings[4], (View) bindings[8], (View) bindings[12], (View) bindings[16], (Group) bindings[20], (ImageView) bindings[5], (ImageView) bindings[13], (ImageView) bindings[1], (ImageView) bindings[9], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[17], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[10], (TextView) bindings[11]);
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
