package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.DefaultTimeBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExoPlaybackControlView1Binding implements ViewBinding {
    public final ImageView audiocaetimage;
    public final TextView exoDuration;
    public final ImageButton exoForward;
    public final FrameLayout exoFullscreenButton;
    public final ImageView exoFullscreenIcon;
    public final ImageButton exoPause;
    public final ImageButton exoPlay;
    public final TextView exoPosition;
    public final DefaultTimeBar exoProgress;
    public final ImageButton exoRewind;
    public final ImageView icon;
    public final LinearLayout l1;
    public final LinearLayout llVideoController;
    public final ImageView quality;
    private final RelativeLayout rootView;
    public final TextView speedTV;
    public final TextView tvGoLive;

    private ExoPlaybackControlView1Binding(RelativeLayout rootView, ImageView audiocaetimage, TextView exoDuration, ImageButton exoForward, FrameLayout exoFullscreenButton, ImageView exoFullscreenIcon, ImageButton exoPause, ImageButton exoPlay, TextView exoPosition, DefaultTimeBar exoProgress, ImageButton exoRewind, ImageView icon, LinearLayout l1, LinearLayout llVideoController, ImageView quality, TextView speedTV, TextView tvGoLive) {
        this.rootView = rootView;
        this.audiocaetimage = audiocaetimage;
        this.exoDuration = exoDuration;
        this.exoForward = exoForward;
        this.exoFullscreenButton = exoFullscreenButton;
        this.exoFullscreenIcon = exoFullscreenIcon;
        this.exoPause = exoPause;
        this.exoPlay = exoPlay;
        this.exoPosition = exoPosition;
        this.exoProgress = exoProgress;
        this.exoRewind = exoRewind;
        this.icon = icon;
        this.l1 = l1;
        this.llVideoController = llVideoController;
        this.quality = quality;
        this.speedTV = speedTV;
        this.tvGoLive = tvGoLive;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExoPlaybackControlView1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExoPlaybackControlView1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exo_playback_control_view_1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExoPlaybackControlView1Binding bind(View rootView) {
        int i = R.id.audiocaetimage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.audiocaetimage);
        if (imageView != null) {
            i = R.id.exo_duration;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_duration);
            if (textView != null) {
                i = R.id.exo_forward;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_forward);
                if (imageButton != null) {
                    i = R.id.exo_fullscreen_button;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.exo_fullscreen_button);
                    if (frameLayout != null) {
                        i = R.id.exo_fullscreen_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.exo_fullscreen_icon);
                        if (imageView2 != null) {
                            i = R.id.exo_pause;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_pause);
                            if (imageButton2 != null) {
                                i = R.id.exo_play;
                                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_play);
                                if (imageButton3 != null) {
                                    i = R.id.exo_position;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_position);
                                    if (textView2 != null) {
                                        i = R.id.exo_progress;
                                        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(rootView, R.id.exo_progress);
                                        if (defaultTimeBar != null) {
                                            i = R.id.exo_rewind;
                                            ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_rewind);
                                            if (imageButton4 != null) {
                                                i = R.id.icon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.icon);
                                                if (imageView3 != null) {
                                                    i = R.id.l1;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.l1);
                                                    if (linearLayout != null) {
                                                        i = R.id.ll_video_controller;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_video_controller);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.quality;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                            if (imageView4 != null) {
                                                                i = R.id.speedTV;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.speedTV);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_go_live;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_go_live);
                                                                    if (textView4 != null) {
                                                                        return new ExoPlaybackControlView1Binding((RelativeLayout) rootView, imageView, textView, imageButton, frameLayout, imageView2, imageButton2, imageButton3, textView2, defaultTimeBar, imageButton4, imageView3, linearLayout, linearLayout2, imageView4, textView3, textView4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
