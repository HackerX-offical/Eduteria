package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityTestBaseSscpatternBindingSw720dpImpl extends ActivityTestBaseSscpatternBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(18);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"ssc_pattern_toolbar_layout"}, new int[]{3}, new int[]{R.layout.ssc_pattern_toolbar_layout});
        includedLayouts.setIncludes(2, new String[]{"ssc_pattern_drawer_layout"}, new int[]{4}, new int[]{R.layout.ssc_pattern_drawer_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.recyclerSectionTabs, 5);
        sparseIntArray.put(R.id.statsContainer, 6);
        sparseIntArray.put(R.id.tvTotalLabel, 7);
        sparseIntArray.put(R.id.tvTotalCount, 8);
        sparseIntArray.put(R.id.timeLeftTxt, 9);
        sparseIntArray.put(R.id.bottomBar, 10);
        sparseIntArray.put(R.id.btnPrevious, 11);
        sparseIntArray.put(R.id.btnMarkReview, 12);
        sparseIntArray.put(R.id.btnSaveNext, 13);
        sparseIntArray.put(R.id.viewPagerQuestions, 14);
        sparseIntArray.put(R.id.submitLoader, 15);
        sparseIntArray.put(R.id.progressBarSubmit, 16);
        sparseIntArray.put(R.id.submitLoaderText, 17);
    }

    public ActivityTestBaseSscpatternBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private ActivityTestBaseSscpatternBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LinearLayout) bindings[10], (AppCompatButton) bindings[12], (AppCompatButton) bindings[11], (AppCompatButton) bindings[13], (DrawerLayout) bindings[0], (SscPatternDrawerLayoutBinding) bindings[4], (SscPatternToolbarLayoutBinding) bindings[3], (ConstraintLayout) bindings[1], (ConstraintLayout) bindings[2], (ProgressBar) bindings[16], (RecyclerView) bindings[5], (ConstraintLayout) bindings[6], (LinearLayout) bindings[15], (TextView) bindings[17], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[7], (ViewPager2) bindings[14]);
        this.mDirtyFlags = -1L;
        this.drawerLayout.setTag(null);
        setContainedBinding(this.includeDrawerContent);
        setContainedBinding(this.includeToolbar);
        this.mainContent.setTag(null);
        this.navDrawerContainer.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.includeToolbar.invalidateAll();
        this.includeDrawerContent.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.includeToolbar.hasPendingBindings() || this.includeDrawerContent.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeToolbar.setLifecycleOwner(lifecycleOwner);
        this.includeDrawerContent.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeIncludeToolbar((SscPatternToolbarLayoutBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return onChangeIncludeDrawerContent((SscPatternDrawerLayoutBinding) object, fieldId);
    }

    private boolean onChangeIncludeToolbar(SscPatternToolbarLayoutBinding IncludeToolbar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeIncludeDrawerContent(SscPatternDrawerLayoutBinding IncludeDrawerContent, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        executeBindingsOn(this.includeToolbar);
        executeBindingsOn(this.includeDrawerContent);
    }
}
