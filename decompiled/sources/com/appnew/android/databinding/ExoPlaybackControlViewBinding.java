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
public final class ExoPlaybackControlViewBinding implements ViewBinding {
    public final ImageView audiocaetimage;
    public final TextView exoDuration;
    public final ImageButton exoFfwd;
    public final FrameLayout exoFullscreenButton;
    public final ImageView exoFullscreenIcon;
    public final ImageButton exoPause;
    public final ImageButton exoPlay;
    public final TextView exoPlaybackSpeed;
    public final TextView exoPosition;
    public final DefaultTimeBar exoProgress;
    public final ImageButton exoRew;
    public final LinearLayout l1;
    public final RelativeLayout layoutControl;
    public final LinearLayout llVideoController;
    public final ImageView quality;
    private final RelativeLayout rootView;
    public final TextView tvGoLive;

    private ExoPlaybackControlViewBinding(RelativeLayout rootView, ImageView audiocaetimage, TextView exoDuration, ImageButton exoFfwd, FrameLayout exoFullscreenButton, ImageView exoFullscreenIcon, ImageButton exoPause, ImageButton exoPlay, TextView exoPlaybackSpeed, TextView exoPosition, DefaultTimeBar exoProgress, ImageButton exoRew, LinearLayout l1, RelativeLayout layoutControl, LinearLayout llVideoController, ImageView quality, TextView tvGoLive) {
        this.rootView = rootView;
        this.audiocaetimage = audiocaetimage;
        this.exoDuration = exoDuration;
        this.exoFfwd = exoFfwd;
        this.exoFullscreenButton = exoFullscreenButton;
        this.exoFullscreenIcon = exoFullscreenIcon;
        this.exoPause = exoPause;
        this.exoPlay = exoPlay;
        this.exoPlaybackSpeed = exoPlaybackSpeed;
        this.exoPosition = exoPosition;
        this.exoProgress = exoProgress;
        this.exoRew = exoRew;
        this.l1 = l1;
        this.layoutControl = layoutControl;
        this.llVideoController = llVideoController;
        this.quality = quality;
        this.tvGoLive = tvGoLive;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExoPlaybackControlViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExoPlaybackControlViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exo_playback_control_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExoPlaybackControlViewBinding bind(View rootView) {
        int i = R.id.audiocaetimage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.audiocaetimage);
        if (imageView != null) {
            i = R.id.exo_duration;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_duration);
            if (textView != null) {
                i = R.id.exo_ffwd;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_ffwd);
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
                                    i = R.id.exo_playback_speed;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_playback_speed);
                                    if (textView2 != null) {
                                        i = R.id.exo_position;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_position);
                                        if (textView3 != null) {
                                            i = R.id.exo_progress;
                                            DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(rootView, R.id.exo_progress);
                                            if (defaultTimeBar != null) {
                                                i = R.id.exo_rew;
                                                ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_rew);
                                                if (imageButton4 != null) {
                                                    i = R.id.l1;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.l1);
                                                    if (linearLayout != null) {
                                                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                                        i = R.id.ll_video_controller;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_video_controller);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.quality;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                            if (imageView3 != null) {
                                                                i = R.id.tv_go_live;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_go_live);
                                                                if (textView4 != null) {
                                                                    return new ExoPlaybackControlViewBinding(relativeLayout, imageView, textView, imageButton, frameLayout, imageView2, imageButton2, imageButton3, textView2, textView3, defaultTimeBar, imageButton4, linearLayout, relativeLayout, linearLayout2, imageView3, textView4);
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
