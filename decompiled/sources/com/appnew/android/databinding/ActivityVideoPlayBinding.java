package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityVideoPlayBinding implements ViewBinding {
    public final ImageView backimag;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;
    public final VideoView videoPlay;
    public final AppCompatTextView videoTitle;

    private ActivityVideoPlayBinding(RelativeLayout rootView, ImageView backimag, Toolbar toolbar, VideoView videoPlay, AppCompatTextView videoTitle) {
        this.rootView = rootView;
        this.backimag = backimag;
        this.toolbar = toolbar;
        this.videoPlay = videoPlay;
        this.videoTitle = videoTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVideoPlayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityVideoPlayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_video_play, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityVideoPlayBinding bind(View rootView) {
        int i = R.id.backimag;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backimag);
        if (imageView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
            if (toolbar != null) {
                i = R.id.video_play;
                VideoView videoView = (VideoView) ViewBindings.findChildViewById(rootView, R.id.video_play);
                if (videoView != null) {
                    i = R.id.video_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, R.id.video_title);
                    if (appCompatTextView != null) {
                        return new ActivityVideoPlayBinding((RelativeLayout) rootView, imageView, toolbar, videoView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
