package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.home.livetest.LiveTestData;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class FeedLiveTestAdapterBindingSw600dpImpl extends FeedLiveTestAdapterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_test_info, 5);
    }

    public FeedLiveTestAdapterBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private FeedLiveTestAdapterBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (RoundedImageView) bindings[1], (RelativeLayout) bindings[5], (RelativeLayout) bindings[0], (TextView) bindings[3], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        this.courseName.setTag(null);
        this.imageTest.setTag(null);
        this.parentLayout.setTag(null);
        this.testName.setTag(null);
        this.time.setTag(null);
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
        if (18 != variableId) {
            return false;
        }
        setLivetestdata((LiveTestData) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.FeedLiveTestAdapterBinding
    public void setLivetestdata(LiveTestData Livetestdata) {
        this.mLivetestdata = Livetestdata;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String course_name;
        String testSeriesName;
        String image;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LiveTestData liveTestData = this.mLivetestdata;
        long j2 = j & 3;
        if (j2 == 0 || liveTestData == null) {
            course_name = null;
            testSeriesName = null;
            image = null;
        } else {
            course_name = liveTestData.getCourse_name();
            testSeriesName = liveTestData.getTestSeriesName();
            image = liveTestData.getImage();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.courseName, course_name);
            DataKt.loadImage(this.imageTest, image);
            TextViewBindingAdapter.setText(this.testName, testSeriesName);
            LiveTestData.time(this.time, liveTestData);
        }
    }
}
