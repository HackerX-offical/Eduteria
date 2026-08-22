package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class SscPatternToolbarLayoutBindingSw720dpImpl extends SscPatternToolbarLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.pauseTestContainer, 1);
        sparseIntArray.put(R.id.pauseProgress, 2);
        sparseIntArray.put(R.id.pauseTest, 3);
        sparseIntArray.put(R.id.textTimeContainer, 4);
        sparseIntArray.put(R.id.timerText, 5);
        sparseIntArray.put(R.id.testNameNew, 6);
        sparseIntArray.put(R.id.layout_right_icons, 7);
        sparseIntArray.put(R.id.changeLanguage, 8);
        sparseIntArray.put(R.id.icon_menu, 9);
    }

    public SscPatternToolbarLayoutBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private SscPatternToolbarLayoutBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[8], (ImageView) bindings[9], (LinearLayout) bindings[7], (Toolbar) bindings[0], (ProgressBar) bindings[2], (ImageView) bindings[3], (FrameLayout) bindings[1], (TextView) bindings[6], (LinearLayout) bindings[4], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.mainToolbar.setTag(null);
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
