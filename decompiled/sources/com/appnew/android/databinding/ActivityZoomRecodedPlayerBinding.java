package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityZoomRecodedPlayerBinding implements ViewBinding {
    public final PlayerView ExoPlayer;
    public final TextView floatingTextNew;
    public final ProgressBar progressBar;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final ImageView screen;
    public final ImageView videoBookmark;

    private ActivityZoomRecodedPlayerBinding(RelativeLayout rootView, PlayerView ExoPlayer, TextView floatingTextNew, ProgressBar progressBar, RelativeLayout rootNew, ImageView screen, ImageView videoBookmark) {
        this.rootView = rootView;
        this.ExoPlayer = ExoPlayer;
        this.floatingTextNew = floatingTextNew;
        this.progressBar = progressBar;
        this.rootNew = rootNew;
        this.screen = screen;
        this.videoBookmark = videoBookmark;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityZoomRecodedPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityZoomRecodedPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_zoom_recoded_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityZoomRecodedPlayerBinding bind(View rootView) {
        int i = R.id.ExoPlayer;
        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.ExoPlayer);
        if (playerView != null) {
            i = R.id.floatingText_new;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
            if (textView != null) {
                i = R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                if (progressBar != null) {
                    i = R.id.root_new;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                    if (relativeLayout != null) {
                        i = R.id.screen;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.screen);
                        if (imageView != null) {
                            i = R.id.video_bookmark;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.video_bookmark);
                            if (imageView2 != null) {
                                return new ActivityZoomRecodedPlayerBinding((RelativeLayout) rootView, playerView, textView, progressBar, relativeLayout, imageView, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
