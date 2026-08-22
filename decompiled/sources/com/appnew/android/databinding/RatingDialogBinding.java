package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.player.music_player.Utils;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RatingDialogBinding extends ViewDataBinding {
    public final ImageView closeButton;

    @Bindable
    protected Utils.FeedbackBottomSheetDialog.Listener mListener;
    public final RatingBar ratingBar;
    public final EditText ratingComment;
    public final RelativeLayout subject1;
    public final Button submitRating;
    public final TextView tvFeedbackTitle;
    public final TextView tvSubtitle;
    public final TextView tvWriteFeedback;

    public abstract void setListener(Utils.FeedbackBottomSheetDialog.Listener listener);

    protected RatingDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView closeButton, RatingBar ratingBar, EditText ratingComment, RelativeLayout subject1, Button submitRating, TextView tvFeedbackTitle, TextView tvSubtitle, TextView tvWriteFeedback) {
        super(_bindingComponent, _root, _localFieldCount);
        this.closeButton = closeButton;
        this.ratingBar = ratingBar;
        this.ratingComment = ratingComment;
        this.subject1 = subject1;
        this.submitRating = submitRating;
        this.tvFeedbackTitle = tvFeedbackTitle;
        this.tvSubtitle = tvSubtitle;
        this.tvWriteFeedback = tvWriteFeedback;
    }

    public Utils.FeedbackBottomSheetDialog.Listener getListener() {
        return this.mListener;
    }

    public static RatingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RatingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RatingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.rating_dialog, root, attachToRoot, component);
    }

    public static RatingDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RatingDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (RatingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.rating_dialog, null, false, component);
    }

    public static RatingDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RatingDialogBinding bind(View view, Object component) {
        return (RatingDialogBinding) bind(component, view, R.layout.rating_dialog);
    }
}
