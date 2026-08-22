package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.TestResult;
import com.appnew.android.generated.callback.OnClickListener;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class NewTestResultAdapterBindingSw600dpImpl extends NewTestResultAdapterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback14;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public NewTestResultAdapterBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private NewTestResultAdapterBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RelativeLayout) bindings[0], (TextView) bindings[3], (CircleImageView) bindings[1], (TextView) bindings[2], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        this.parentLayout.setTag(null);
        this.testAttempts.setTag(null);
        this.testImage.setTag(null);
        this.testName.setTag(null);
        this.testResult.setTag(null);
        setRootTag(root);
        this.mCallback14 = new OnClickListener(this, 1);
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
        setLivetestresult((TestResult) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.NewTestResultAdapterBinding
    public void setLivetestresult(TestResult Livetestresult) {
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
        String test_series_name;
        String attempts;
        String image;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TestResult testResult = this.mLivetestresult;
        long j2 = 3 & j;
        if (j2 == 0 || testResult == null) {
            test_series_name = null;
            attempts = null;
            image = null;
        } else {
            test_series_name = testResult.getTest_series_name();
            image = testResult.getImage();
            attempts = testResult.getAttempts();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.testAttempts, attempts);
            DataKt.loadImage(this.testImage, image);
            TextViewBindingAdapter.setText(this.testName, test_series_name);
        }
        if ((j & 2) != 0) {
            this.testResult.setOnClickListener(this.mCallback14);
        }
    }

    @Override // com.appnew.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        TestResult testResult = this.mLivetestresult;
        if (testResult != null) {
            testResult.click(callbackArg_0, testResult);
        }
    }
}
