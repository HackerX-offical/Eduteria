package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.customview.TouchImageView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityZoomFeedImageBinding implements ViewBinding {
    public final TextView closeButton;
    private final RelativeLayout rootView;
    public final TouchImageView zoomImage;

    private ActivityZoomFeedImageBinding(RelativeLayout rootView, TextView closeButton, TouchImageView zoomImage) {
        this.rootView = rootView;
        this.closeButton = closeButton;
        this.zoomImage = zoomImage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZoomFeedImageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityZoomFeedImageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_zoom_feed_image, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityZoomFeedImageBinding bind(View rootView) {
        int i = R.id.closeButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.closeButton);
        if (textView != null) {
            i = R.id.zoomImage;
            TouchImageView touchImageView = (TouchImageView) ViewBindings.findChildViewById(rootView, R.id.zoomImage);
            if (touchImageView != null) {
                return new ActivityZoomFeedImageBinding((RelativeLayout) rootView, textView, touchImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
