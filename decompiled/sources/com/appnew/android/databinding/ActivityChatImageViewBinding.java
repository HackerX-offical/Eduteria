package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.customview.TouchImageView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityChatImageViewBinding implements ViewBinding {
    public final ImageView backBtn;
    public final TouchImageView image;
    public final ConstraintLayout main;
    public final RelativeLayout mainToolbar;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityChatImageViewBinding(ConstraintLayout rootView, ImageView backBtn, TouchImageView image, ConstraintLayout main, RelativeLayout mainToolbar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.main = main;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChatImageViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityChatImageViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_chat_image_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChatImageViewBinding bind(View rootView) {
        int i = R.id.backBtn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (imageView != null) {
            i = R.id.image;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (touchImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.main_toolbar;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (relativeLayout != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new ActivityChatImageViewBinding(constraintLayout, imageView, touchImageView, constraintLayout, relativeLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
