package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class NewCourseVmBindingSw720dpImpl extends NewCourseVmBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.new_course_txt, 2);
        sparseIntArray.put(R.id.view_all, 3);
        sparseIntArray.put(R.id.view1, 4);
    }

    public NewCourseVmBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private NewCourseVmBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[1], (TextView) bindings[2], (View) bindings[4], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.newCourseRecycler.setTag(null);
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
        if (6 != variableId) {
            return false;
        }
        setCoursedata((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.NewCourseVmBinding
    public void setCoursedata(Data Coursedata) {
        this.mCoursedata = Coursedata;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mCoursedata;
        long j2 = j & 3;
        List<NewCourseData> newCourseData = (j2 == 0 || data == null) ? null : data.getNewCourseData();
        if (j2 != 0) {
            ExtensionFucationKt.courseadapter(this.newCourseRecycler, newCourseData);
        }
    }
}
