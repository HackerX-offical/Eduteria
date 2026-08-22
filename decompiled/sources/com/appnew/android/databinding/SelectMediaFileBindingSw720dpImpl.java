package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.generated.callback.OnClickListener;
import com.appnew.android.player.music_player.Utils;

/* JADX INFO: loaded from: classes6.dex */
public class SelectMediaFileBindingSw720dpImpl extends SelectMediaFileBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayoutCompat mboundView2;
    private final LinearLayoutCompat mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    public SelectMediaFileBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private SelectMediaFileBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.closeButton.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[2];
        this.mboundView2 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) bindings[3];
        this.mboundView3 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        setRootTag(root);
        this.mCallback7 = new OnClickListener(this, 2);
        this.mCallback8 = new OnClickListener(this, 3);
        this.mCallback6 = new OnClickListener(this, 1);
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
        if (20 != variableId) {
            return false;
        }
        setMediaListener((Utils.ChooseMediaFileBottomSheetDialog.MediaListener) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.SelectMediaFileBinding
    public void setMediaListener(Utils.ChooseMediaFileBottomSheetDialog.MediaListener MediaListener) {
        this.mMediaListener = MediaListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Utils.ChooseMediaFileBottomSheetDialog.MediaListener mediaListener = this.mMediaListener;
        if ((j & 2) != 0) {
            this.closeButton.setOnClickListener(this.mCallback6);
            this.mboundView2.setOnClickListener(this.mCallback7);
            this.mboundView3.setOnClickListener(this.mCallback8);
        }
    }

    @Override // com.appnew.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Utils.ChooseMediaFileBottomSheetDialog.MediaListener mediaListener;
        if (sourceId == 1) {
            Utils.ChooseMediaFileBottomSheetDialog.MediaListener mediaListener2 = this.mMediaListener;
            if (mediaListener2 != null) {
                mediaListener2.onClose();
                return;
            }
            return;
        }
        if (sourceId != 2) {
            if (sourceId == 3 && (mediaListener = this.mMediaListener) != null) {
                mediaListener.onFileClick();
                return;
            }
            return;
        }
        Utils.ChooseMediaFileBottomSheetDialog.MediaListener mediaListener3 = this.mMediaListener;
        if (mediaListener3 != null) {
            mediaListener3.onImageClick();
        }
    }
}
