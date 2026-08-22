package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ItemSscPatternQuestionViewpagerBindingSw720dpImpl extends ItemSscPatternQuestionViewpagerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

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
        sparseIntArray.put(R.id.timeNegPosContainer, 1);
        sparseIntArray.put(R.id.timeContainer, 2);
        sparseIntArray.put(R.id.iconTimer, 3);
        sparseIntArray.put(R.id.tvTimer, 4);
        sparseIntArray.put(R.id.negPosContainer, 5);
        sparseIntArray.put(R.id.positiveText, 6);
        sparseIntArray.put(R.id.negativeText, 7);
        sparseIntArray.put(R.id.mandatoryText, 8);
        sparseIntArray.put(R.id.tvQNumber, 9);
        sparseIntArray.put(R.id.vDiv, 10);
        sparseIntArray.put(R.id.llRightActions, 11);
        sparseIntArray.put(R.id.tv_report_error, 12);
        sparseIntArray.put(R.id.img_bookmark, 13);
        sparseIntArray.put(R.id.mark_for_review, 14);
        sparseIntArray.put(R.id.tvQuestionTextContainer, 15);
        sparseIntArray.put(R.id.pgText, 16);
        sparseIntArray.put(R.id.tvQuestionText, 17);
        sparseIntArray.put(R.id.rvOptions, 18);
    }

    public ItemSscPatternQuestionViewpagerBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    private ItemSscPatternQuestionViewpagerBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (ImageView) bindings[13], (LinearLayout) bindings[11], (TextView) bindings[8], (ImageView) bindings[14], (LinearLayout) bindings[5], (TextView) bindings[7], (TextView) bindings[16], (TextView) bindings[6], (RecyclerView) bindings[18], (LinearLayout) bindings[2], (LinearLayout) bindings[1], (TextView) bindings[9], (ClickableWebView) bindings[17], (LinearLayout) bindings[15], (ImageView) bindings[12], (TextView) bindings[4], (View) bindings[10]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
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
