package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ItemViewConversatiuonBindingSw720dpImpl extends ItemViewConversatiuonBinding {
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
        sparseIntArray.put(R.id.leftMessage_relative, 1);
        sparseIntArray.put(R.id.leftMessage_Card, 2);
        sparseIntArray.put(R.id.message, 3);
        sparseIntArray.put(R.id.mobile, 4);
        sparseIntArray.put(R.id.email, 5);
        sparseIntArray.put(R.id.issue, 6);
        sparseIntArray.put(R.id.dateLeftMessage, 7);
        sparseIntArray.put(R.id.rightMessage_relative, 8);
        sparseIntArray.put(R.id.rightMessage_Card, 9);
        sparseIntArray.put(R.id.message1, 10);
        sparseIntArray.put(R.id.mobile1, 11);
        sparseIntArray.put(R.id.email1, 12);
        sparseIntArray.put(R.id.issue1, 13);
        sparseIntArray.put(R.id.dateRightMessage, 14);
    }

    public ItemViewConversatiuonBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private ItemViewConversatiuonBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[7], (TextView) bindings[14], (TextView) bindings[5], (TextView) bindings[12], (TextView) bindings[6], (TextView) bindings[13], (CardView) bindings[2], (RelativeLayout) bindings[1], (ConstraintLayout) bindings[0], (TextView) bindings[3], (TextView) bindings[10], (TextView) bindings[4], (TextView) bindings[11], (CardView) bindings[9], (RelativeLayout) bindings[8]);
        this.mDirtyFlags = -1L;
        this.mainLLConversation.setTag(null);
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
