package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCustomAudioPlayerBinding implements ViewBinding {
    public final TextView floatingTextNew;
    public final RelativeLayout parentLayout;
    public final PlayerView playerViewNew;
    public final ProgressBar progressBar;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final TextView videoName;

    private ActivityCustomAudioPlayerBinding(RelativeLayout rootView, TextView floatingTextNew, RelativeLayout parentLayout, PlayerView playerViewNew, ProgressBar progressBar, RelativeLayout rootNew, TextView videoName) {
        this.rootView = rootView;
        this.floatingTextNew = floatingTextNew;
        this.parentLayout = parentLayout;
        this.playerViewNew = playerViewNew;
        this.progressBar = progressBar;
        this.rootNew = rootNew;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCustomAudioPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCustomAudioPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_custom_audio_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCustomAudioPlayerBinding bind(View rootView) {
        int i = R.id.floatingText_new;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
        if (textView != null) {
            i = R.id.parent_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
            if (relativeLayout != null) {
                i = R.id.player_view_new;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
                if (playerView != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                    if (progressBar != null) {
                        i = R.id.root_new;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                        if (relativeLayout2 != null) {
                            i = R.id.video_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                            if (textView2 != null) {
                                return new ActivityCustomAudioPlayerBinding((RelativeLayout) rootView, textView, relativeLayout, playerView, progressBar, relativeLayout2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
