package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.feeds.viewmodel.FeedViewModel;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class FragmentFeedsBindingImpl extends FragmentFeedsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NoDataFoundBinding mboundView0;
    private final RelativeLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.feeds_toolbar, 2);
        sparseIntArray.put(R.id.image_back, 3);
        sparseIntArray.put(R.id.titleinnerRL, 4);
        sparseIntArray.put(R.id.toolbartitleTV, 5);
        sparseIntArray.put(R.id.pined_post, 6);
        sparseIntArray.put(R.id.filter, 7);
        sparseIntArray.put(R.id.pullto_referesh, 8);
        sparseIntArray.put(R.id.nested_scroll, 9);
        sparseIntArray.put(R.id.feed_recyerlview, 10);
        sparseIntArray.put(R.id.progressBar, 11);
    }

    public FragmentFeedsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentFeedsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[10], (Toolbar) bindings[2], (ImageView) bindings[7], (ImageView) bindings[3], (NestedScrollView) bindings[9], (ImageView) bindings[6], (ProgressBar) bindings[11], (SwipeRefreshLayout) bindings[8], (RelativeLayout) bindings[4], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? NoDataFoundBinding.bind((View) obj) : null;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView01 = relativeLayout;
        relativeLayout.setTag(null);
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
        if (9 != variableId) {
            return false;
        }
        setFeedbind((FeedViewModel) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.FragmentFeedsBinding
    public void setFeedbind(FeedViewModel Feedbind) {
        this.mFeedbind = Feedbind;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
