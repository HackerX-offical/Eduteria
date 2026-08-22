package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public class PendingPurchaseBannerItemBindingSw720dpImpl extends PendingPurchaseBannerItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

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
        sparseIntArray.put(R.id.imageSlider, 1);
        sparseIntArray.put(R.id.btnClose, 2);
        sparseIntArray.put(R.id.courseTitleTV, 3);
        sparseIntArray.put(R.id.price_linear, 4);
        sparseIntArray.put(R.id.priceTV, 5);
        sparseIntArray.put(R.id.mrpCutTV, 6);
        sparseIntArray.put(R.id.btnBuyNow, 7);
    }

    public PendingPurchaseBannerItemBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private PendingPurchaseBannerItemBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[7], (ImageView) bindings[2], (TextView) bindings[3], (ShapeableImageView) bindings[1], (TextView) bindings[6], (RelativeLayout) bindings[4], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
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
