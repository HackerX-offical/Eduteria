package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.book_theme_2.models.Cartdata;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class CartItemBookBindingSw600dpImpl extends CartItemBookBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cartSubTitle, 4);
        sparseIntArray.put(R.id.cartPrice, 5);
        sparseIntArray.put(R.id.cartOffPrice, 6);
        sparseIntArray.put(R.id.offPrice, 7);
        sparseIntArray.put(R.id.heartIcon, 8);
        sparseIntArray.put(R.id.deleteId, 9);
    }

    public CartItemBookBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private CartItemBookBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[2], (ImageView) bindings[9], (ImageView) bindings[8], (TextView) bindings[7]);
        this.mDirtyFlags = -1L;
        this.cartImage.setTag(null);
        this.cartRating.setTag(null);
        this.cartTitle.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
    public boolean setVariable(int variableId, Object variable) {
        if (7 != variableId) {
            return false;
        }
        setData((Cartdata) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.CartItemBookBinding
    public void setData(Cartdata Data) {
        this.mData = Data;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String avgRating;
        String coverImage;
        String courseName;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Cartdata cartdata = this.mData;
        long j2 = j & 3;
        if (j2 == 0 || cartdata == null) {
            avgRating = null;
            coverImage = null;
            courseName = null;
        } else {
            avgRating = cartdata.getAvgRating();
            coverImage = cartdata.getCoverImage();
            courseName = cartdata.getCourseName();
        }
        if (j2 != 0) {
            XtensionFunctionKt.loadImage(this.cartImage, coverImage);
            TextViewBindingAdapter.setText(this.cartRating, avgRating);
            TextViewBindingAdapter.setText(this.cartTitle, courseName);
        }
    }
}
