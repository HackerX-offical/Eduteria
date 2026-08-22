package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityAudioPlayerBindingImpl extends ActivityAudioPlayerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.appbar, 1);
        sparseIntArray.put(R.id.ll_banner, 2);
        sparseIntArray.put(R.id.audioImage, 3);
        sparseIntArray.put(R.id.txtSname, 4);
        sparseIntArray.put(R.id.songName, 5);
        sparseIntArray.put(R.id.txtStartTime, 6);
        sparseIntArray.put(R.id.sBar, 7);
        sparseIntArray.put(R.id.txtSongTime, 8);
        sparseIntArray.put(R.id.ll_buttons, 9);
        sparseIntArray.put(R.id.exo_playback_speed, 10);
        sparseIntArray.put(R.id.btnBackward, 11);
        sparseIntArray.put(R.id.btnPlay, 12);
        sparseIntArray.put(R.id.btnForward, 13);
    }

    public ActivityAudioPlayerBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ActivityAudioPlayerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        Object obj = bindings[1];
        super(bindingComponent, root, 0, obj != null ? AppBarMainBinding.bind((View) obj) : null, (ImageView) bindings[3], (ImageView) bindings[11], (ImageView) bindings[13], (ImageView) bindings[12], (TextView) bindings[10], (LinearLayout) bindings[2], (RelativeLayout) bindings[9], (SeekBar) bindings[7], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[8], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
