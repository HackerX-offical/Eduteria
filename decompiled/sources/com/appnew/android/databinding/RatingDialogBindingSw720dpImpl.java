package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.generated.callback.OnClickListener;
import com.appnew.android.player.music_player.Utils;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class RatingDialogBindingSw720dpImpl extends RatingDialogBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback26;
    private final View.OnClickListener mCallback27;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tvFeedbackTitle, 3);
        sparseIntArray.put(R.id.tvSubtitle, 4);
        sparseIntArray.put(R.id.ratingBar, 5);
        sparseIntArray.put(R.id.tvWriteFeedback, 6);
        sparseIntArray.put(R.id.subject1, 7);
        sparseIntArray.put(R.id.ratingComment, 8);
    }

    public RatingDialogBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private RatingDialogBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (RatingBar) bindings[5], (EditText) bindings[8], (RelativeLayout) bindings[7], (Button) bindings[2], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        this.closeButton.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.submitRating.setTag(null);
        setRootTag(root);
        this.mCallback27 = new OnClickListener(this, 2);
        this.mCallback26 = new OnClickListener(this, 1);
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
        if (14 != variableId) {
            return false;
        }
        setListener((Utils.FeedbackBottomSheetDialog.Listener) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.RatingDialogBinding
    public void setListener(Utils.FeedbackBottomSheetDialog.Listener Listener) {
        this.mListener = Listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Utils.FeedbackBottomSheetDialog.Listener listener = this.mListener;
        if ((j & 2) != 0) {
            this.closeButton.setOnClickListener(this.mCallback26);
            this.submitRating.setOnClickListener(this.mCallback27);
        }
    }

    @Override // com.appnew.android.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Utils.FeedbackBottomSheetDialog.Listener listener;
        if (sourceId != 1) {
            if (sourceId == 2 && (listener = this.mListener) != null) {
                listener.onSubmit();
                return;
            }
            return;
        }
        Utils.FeedbackBottomSheetDialog.Listener listener2 = this.mListener;
        if (listener2 != null) {
            listener2.onClose();
        }
    }
}
