package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.customview.TouchImageView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageLayoutNewBinding implements ViewBinding {
    public final ImageView cancel;
    public final TouchImageView image;
    private final RelativeLayout rootView;

    private ImageLayoutNewBinding(RelativeLayout rootView, ImageView cancel, TouchImageView image) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.image = image;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ImageLayoutNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ImageLayoutNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.image_layout_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ImageLayoutNewBinding bind(View rootView) {
        int i = R.id.cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
        if (imageView != null) {
            i = R.id.image;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (touchImageView != null) {
                return new ImageLayoutNewBinding((RelativeLayout) rootView, imageView, touchImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
