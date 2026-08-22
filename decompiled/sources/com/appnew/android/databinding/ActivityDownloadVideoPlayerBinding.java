package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.player.music_player.ZoomableVideoView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDownloadVideoPlayerBinding implements ViewBinding {
    public final TextView MarqueeText;
    public final LinearLayout llMain;
    public final RelativeLayout mainRoot;
    public final PlayerView playerViewNew;
    public final ProgressBar progressBar;
    public final ImageView quality;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final TextView txtTimer;
    public final TextView videoName;
    public final ZoomableVideoView zoomableVideoView;

    private ActivityDownloadVideoPlayerBinding(RelativeLayout rootView, TextView MarqueeText, LinearLayout llMain, RelativeLayout mainRoot, PlayerView playerViewNew, ProgressBar progressBar, ImageView quality, RelativeLayout rootNew, TextView txtTimer, TextView videoName, ZoomableVideoView zoomableVideoView) {
        this.rootView = rootView;
        this.MarqueeText = MarqueeText;
        this.llMain = llMain;
        this.mainRoot = mainRoot;
        this.playerViewNew = playerViewNew;
        this.progressBar = progressBar;
        this.quality = quality;
        this.rootNew = rootNew;
        this.txtTimer = txtTimer;
        this.videoName = videoName;
        this.zoomableVideoView = zoomableVideoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDownloadVideoPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDownloadVideoPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_download_video_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDownloadVideoPlayerBinding bind(View rootView) {
        int i = R.id.MarqueeText;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.MarqueeText);
        if (textView != null) {
            i = R.id.ll_main;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_main);
            if (linearLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                i = R.id.player_view_new;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
                if (playerView != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                    if (progressBar != null) {
                        i = R.id.quality;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                        if (imageView != null) {
                            i = R.id.root_new;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                            if (relativeLayout2 != null) {
                                i = R.id.txt_timer;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_timer);
                                if (textView2 != null) {
                                    i = R.id.video_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                    if (textView3 != null) {
                                        i = R.id.zoomableVideoView;
                                        ZoomableVideoView zoomableVideoView = (ZoomableVideoView) ViewBindings.findChildViewById(rootView, R.id.zoomableVideoView);
                                        if (zoomableVideoView != null) {
                                            return new ActivityDownloadVideoPlayerBinding(relativeLayout, textView, linearLayout, relativeLayout, playerView, progressBar, imageView, relativeLayout2, textView2, textView3, zoomableVideoView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
