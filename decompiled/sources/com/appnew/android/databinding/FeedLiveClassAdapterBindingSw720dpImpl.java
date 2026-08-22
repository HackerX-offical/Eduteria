package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.Datum;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class FeedLiveClassAdapterBindingSw720dpImpl extends FeedLiveClassAdapterBinding {
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

    public FeedLiveClassAdapterBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private FeedLiveClassAdapterBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
        if (16 != variableId) {
            return false;
        }
        setLiveclassdata((Datum) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.FeedLiveClassAdapterBinding
    public void setLiveclassdata(Datum Liveclassdata) {
        this.mLiveclassdata = Liveclassdata;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String title;
        String course_name;
        String thumbnailUrl;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Datum datum = this.mLiveclassdata;
        long j2 = j & 3;
        if (j2 == 0 || datum == null) {
            title = null;
            course_name = null;
            thumbnailUrl = null;
        } else {
            title = datum.getTitle();
            course_name = datum.getCourse_name();
            thumbnailUrl = datum.getThumbnailUrl();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.courseName, course_name);
            DataKt.loadImage(this.imageTest, thumbnailUrl);
            TextViewBindingAdapter.setText(this.testName, title);
            Datum.time(this.time, datum);
        }
    }
}
