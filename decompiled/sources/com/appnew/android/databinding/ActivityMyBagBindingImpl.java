package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityMyBagBindingImpl extends ActivityMyBagBinding {
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
        sparseIntArray.put(R.id.appBarId, 1);
        sparseIntArray.put(R.id.backButton, 2);
        sparseIntArray.put(R.id.bagTextId, 3);
        sparseIntArray.put(R.id.searchId, 4);
        sparseIntArray.put(R.id.recyclerViewId, 5);
        sparseIntArray.put(R.id.cartItem_coupon, 6);
        sparseIntArray.put(R.id.coupon_code, 7);
        sparseIntArray.put(R.id.orderDetails, 8);
        sparseIntArray.put(R.id.orderLayout, 9);
        sparseIntArray.put(R.id.totalProductId, 10);
        sparseIntArray.put(R.id.totalProductPrice, 11);
        sparseIntArray.put(R.id.deliveryChargeId, 12);
        sparseIntArray.put(R.id.deliveryChargePrice, 13);
        sparseIntArray.put(R.id.grandTotalId, 14);
        sparseIntArray.put(R.id.grandTotalPrice, 15);
        sparseIntArray.put(R.id.constraintLayout2, 16);
        sparseIntArray.put(R.id.totalPrice, 17);
        sparseIntArray.put(R.id.placeOrderId, 18);
        sparseIntArray.put(R.id.no_data_found_RL, 19);
        sparseIntArray.put(R.id.image, 20);
        sparseIntArray.put(R.id.no_data, 21);
    }

    public ActivityMyBagBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private ActivityMyBagBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[1], (ImageView) bindings[2], (TextView) bindings[3], (CardView) bindings[6], (ConstraintLayout) bindings[16], (EditText) bindings[7], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[14], (TextView) bindings[15], (ImageView) bindings[20], (TextView) bindings[21], (RelativeLayout) bindings[19], (TextView) bindings[8], (ConstraintLayout) bindings[9], (Button) bindings[18], (RecyclerView) bindings[5], (AppCompatEditText) bindings[4], (TextView) bindings[17], (TextView) bindings[10], (TextView) bindings[11]);
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
