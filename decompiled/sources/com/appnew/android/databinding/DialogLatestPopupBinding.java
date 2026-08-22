package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogLatestPopupBinding implements ViewBinding {
    public final ImageView ivClose;
    public final RoundedImageView ivLatestImage;
    public final ImageView popUpGif;
    public final RelativeLayout rlDialogLatestPopup;
    private final RelativeLayout rootView;

    private DialogLatestPopupBinding(RelativeLayout rootView, ImageView ivClose, RoundedImageView ivLatestImage, ImageView popUpGif, RelativeLayout rlDialogLatestPopup) {
        this.rootView = rootView;
        this.ivClose = ivClose;
        this.ivLatestImage = ivLatestImage;
        this.popUpGif = popUpGif;
        this.rlDialogLatestPopup = rlDialogLatestPopup;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogLatestPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogLatestPopupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_latest_popup, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogLatestPopupBinding bind(View rootView) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_close);
        if (imageView != null) {
            i = R.id.iv_latest_image;
            RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.iv_latest_image);
            if (roundedImageView != null) {
                i = R.id.popUp_gif;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.popUp_gif);
                if (imageView2 != null) {
                    i = R.id.rl_dialog_latest_popup;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_dialog_latest_popup);
                    if (relativeLayout != null) {
                        return new DialogLatestPopupBinding((RelativeLayout) rootView, imageView, roundedImageView, imageView2, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
