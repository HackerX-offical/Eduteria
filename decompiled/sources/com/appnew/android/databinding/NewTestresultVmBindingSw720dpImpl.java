package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.TestResult;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class NewTestresultVmBindingSw720dpImpl extends NewTestresultVmBinding {
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

    public NewTestresultVmBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private NewTestresultVmBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[1], (TextView) bindings[2], (View) bindings[4], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.liveTestRecycler.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
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
        if (19 != variableId) {
            return false;
        }
        setLivetestresult((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.NewTestresultVmBinding
    public void setLivetestresult(Data Livetestresult) {
        this.mLivetestresult = Livetestresult;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mLivetestresult;
        long j2 = j & 3;
        List<TestResult> testResult = (j2 == 0 || data == null) ? null : data.getTestResult();
        if (j2 != 0) {
            DataKt.setAdapter(this.liveTestRecycler, testResult);
        }
    }
}
