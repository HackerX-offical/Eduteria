package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.adapters.Banner_ViewPager;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.generated.callback.OnClickListener;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class BannerAdapterImageviewBindingSw720dpImpl extends BannerAdapterImageviewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback13;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public BannerAdapterImageviewBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }

    private BannerAdapterImageviewBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RoundedImageView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.imgeView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        this.mCallback13 = new OnClickListener(this, 1);
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
        if (3 == variableId) {
            setBannerdata((BannerData) variable);
            return true;
        }
        if (4 != variableId) {
            return false;
        }
        setBannerviewadapter((Banner_ViewPager) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.BannerAdapterImageviewBinding
    public void setBannerdata(BannerData Bannerdata) {
        this.mBannerdata = Bannerdata;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.appnew.android.databinding.BannerAdapterImageviewBinding
    public void setBannerviewadapter(Banner_ViewPager Bannerviewadapter) {
        this.mBannerviewadapter = Bannerviewadapter;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BannerData bannerData = this.mBannerdata;
        Banner_ViewPager banner_ViewPager = this.mBannerviewadapter;
        long j2 = 5 & j;
        String url = (j2 == 0 || bannerData == null) ? null : bannerData.getUrl();
        if ((j & 4) != 0) {
            this.imgeView.setOnClickListener(this.mCallback13);
        }
        if (j2 != 0) {
            DataKt.loadImage(this.imgeView, url);
        }
    }

    @Override // com.appnew.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        BannerData bannerData = this.mBannerdata;
        Banner_ViewPager banner_ViewPager = this.mBannerviewadapter;
        if (banner_ViewPager == null || bannerData == null) {
            return;
        }
        banner_ViewPager.clickBanner(bannerData.getTarget_meta());
    }
}
