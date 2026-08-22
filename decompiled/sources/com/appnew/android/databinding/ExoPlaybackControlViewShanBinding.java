package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.DefaultTimeBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExoPlaybackControlViewShanBinding implements ViewBinding {
    public final TextView exoDuration;
    public final ImageView exoFfwd;
    public final ImageView exoPause;
    public final ImageView exoPlay;
    public final TextView exoPosition;
    public final DefaultTimeBar exoProgress;
    public final ImageView exoRew;
    public final LinearLayout playerLl;
    public final RecyclerView recyclerViewChannel;
    private final RelativeLayout rootView;
    public final ImageView speedOption;
    public final LinearLayout timeBarLl;

    private ExoPlaybackControlViewShanBinding(RelativeLayout rootView, TextView exoDuration, ImageView exoFfwd, ImageView exoPause, ImageView exoPlay, TextView exoPosition, DefaultTimeBar exoProgress, ImageView exoRew, LinearLayout playerLl, RecyclerView recyclerViewChannel, ImageView speedOption, LinearLayout timeBarLl) {
        this.rootView = rootView;
        this.exoDuration = exoDuration;
        this.exoFfwd = exoFfwd;
        this.exoPause = exoPause;
        this.exoPlay = exoPlay;
        this.exoPosition = exoPosition;
        this.exoProgress = exoProgress;
        this.exoRew = exoRew;
        this.playerLl = playerLl;
        this.recyclerViewChannel = recyclerViewChannel;
        this.speedOption = speedOption;
        this.timeBarLl = timeBarLl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExoPlaybackControlViewShanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExoPlaybackControlViewShanBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exo_playback_control_view_shan, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExoPlaybackControlViewShanBinding bind(View rootView) {
        int i = R.id.exo_duration;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_duration);
        if (textView != null) {
            i = R.id.exo_ffwd;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.exo_ffwd);
            if (imageView != null) {
                i = R.id.exo_pause;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.exo_pause);
                if (imageView2 != null) {
                    i = R.id.exo_play;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.exo_play);
                    if (imageView3 != null) {
                        i = R.id.exo_position;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_position);
                        if (textView2 != null) {
                            i = R.id.exo_progress;
                            DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(rootView, R.id.exo_progress);
                            if (defaultTimeBar != null) {
                                i = R.id.exo_rew;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.exo_rew);
                                if (imageView4 != null) {
                                    i = R.id.player_ll;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.player_ll);
                                    if (linearLayout != null) {
                                        i = R.id.recyclerViewChannel;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewChannel);
                                        if (recyclerView != null) {
                                            i = R.id.speedOption;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.speedOption);
                                            if (imageView5 != null) {
                                                i = R.id.time_bar_ll;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.time_bar_ll);
                                                if (linearLayout2 != null) {
                                                    return new ExoPlaybackControlViewShanBinding((RelativeLayout) rootView, textView, imageView, imageView2, imageView3, textView2, defaultTimeBar, imageView4, linearLayout, recyclerView, imageView5, linearLayout2);
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
