package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.FullScreenVideoView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySplashDemoBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final ImageView splashGif;
    public final ImageView splashImage;
    public final RelativeLayout splashRelative;
    public final FullScreenVideoView splashVideo;

    private ActivitySplashDemoBinding(RelativeLayout rootView, ProgressBar progressBar, ImageView splashGif, ImageView splashImage, RelativeLayout splashRelative, FullScreenVideoView splashVideo) {
        this.rootView = rootView;
        this.progressBar = progressBar;
        this.splashGif = splashGif;
        this.splashImage = splashImage;
        this.splashRelative = splashRelative;
        this.splashVideo = splashVideo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashDemoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySplashDemoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_splash_demo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySplashDemoBinding bind(View rootView) {
        int i = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
        if (progressBar != null) {
            i = R.id.splash_gif;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.splash_gif);
            if (imageView != null) {
                i = R.id.splash_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.splash_image);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.splash_video;
                    FullScreenVideoView fullScreenVideoView = (FullScreenVideoView) ViewBindings.findChildViewById(rootView, R.id.splash_video);
                    if (fullScreenVideoView != null) {
                        return new ActivitySplashDemoBinding(relativeLayout, progressBar, imageView, imageView2, relativeLayout, fullScreenVideoView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
