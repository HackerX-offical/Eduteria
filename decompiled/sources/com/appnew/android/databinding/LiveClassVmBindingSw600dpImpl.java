package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.adapters.FeedAdapter;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.Datum;
import com.appnew.android.generated.callback.OnClickListener;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LiveClassVmBindingSw600dpImpl extends LiveClassVmBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback17;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.new_course_txt, 3);
        sparseIntArray.put(R.id.view1, 4);
    }

    public LiveClassVmBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private LiveClassVmBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RecyclerView) bindings[2], (TextView) bindings[3], (View) bindings[4], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.liveClassRecycler.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.viewAll.setTag(null);
        setRootTag(root);
        this.mCallback17 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
        if (8 == variableId) {
            setFeedadapter((FeedAdapter) variable);
            return true;
        }
        if (15 != variableId) {
            return false;
        }
        setLiveclass((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.LiveClassVmBinding
    public void setFeedadapter(FeedAdapter Feedadapter) {
        this.mFeedadapter = Feedadapter;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.appnew.android.databinding.LiveClassVmBinding
    public void setLiveclass(Data Liveclass) {
        this.mLiveclass = Liveclass;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FeedAdapter feedAdapter = this.mFeedadapter;
        Data data = this.mLiveclass;
        long j2 = 6 & j;
        List<Datum> liveclass = (j2 == 0 || data == null) ? null : data.getLiveclass();
        if (j2 != 0) {
            DataKt.setliveclassadapter(this.liveClassRecycler, liveclass);
        }
        if ((j & 4) != 0) {
            this.viewAll.setOnClickListener(this.mCallback17);
        }
    }

    @Override // com.appnew.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        FeedAdapter feedAdapter = this.mFeedadapter;
        if (feedAdapter != null) {
            feedAdapter.viewAllclass(callbackArg_0);
        }
    }
}
