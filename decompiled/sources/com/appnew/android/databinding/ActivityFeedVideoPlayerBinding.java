package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.player.YTubePlayerView;
import com.appnew.android.player.YTubePlayerViewShorts;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFeedVideoPlayerBinding implements ViewBinding {
    public final RelativeLayout dataLayout;
    public final TextView descritption;
    public final PlayerView exoplayer;
    public final ProgressBar progressBar;
    public final TextView readMore;
    public final ConstraintLayout rootNew;
    public final NestedScrollView rootView;
    private final NestedScrollView rootView_;
    public final YTubePlayerView youtubePlayerView;
    public final YTubePlayerViewShorts youtubeShortPlayerView;

    private ActivityFeedVideoPlayerBinding(NestedScrollView rootView_, RelativeLayout dataLayout, TextView descritption, PlayerView exoplayer, ProgressBar progressBar, TextView readMore, ConstraintLayout rootNew, NestedScrollView rootView, YTubePlayerView youtubePlayerView, YTubePlayerViewShorts youtubeShortPlayerView) {
        this.rootView_ = rootView_;
        this.dataLayout = dataLayout;
        this.descritption = descritption;
        this.exoplayer = exoplayer;
        this.progressBar = progressBar;
        this.readMore = readMore;
        this.rootNew = rootNew;
        this.rootView = rootView;
        this.youtubePlayerView = youtubePlayerView;
        this.youtubeShortPlayerView = youtubeShortPlayerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static ActivityFeedVideoPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFeedVideoPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_feed_video_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFeedVideoPlayerBinding bind(View rootView) {
        int i = R.id.data_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.data_layout);
        if (relativeLayout != null) {
            i = R.id.descritption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.descritption);
            if (textView != null) {
                i = R.id.exoplayer;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.exoplayer);
                if (playerView != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                    if (progressBar != null) {
                        i = R.id.read_more;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_more);
                        if (textView2 != null) {
                            i = R.id.root_new;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                            if (constraintLayout != null) {
                                NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                                i = R.id.youtube_player_view;
                                YTubePlayerView yTubePlayerView = (YTubePlayerView) ViewBindings.findChildViewById(rootView, R.id.youtube_player_view);
                                if (yTubePlayerView != null) {
                                    i = R.id.youtube_short_player_view;
                                    YTubePlayerViewShorts yTubePlayerViewShorts = (YTubePlayerViewShorts) ViewBindings.findChildViewById(rootView, R.id.youtube_short_player_view);
                                    if (yTubePlayerViewShorts != null) {
                                        return new ActivityFeedVideoPlayerBinding(nestedScrollView, relativeLayout, textView, playerView, progressBar, textView2, constraintLayout, nestedScrollView, yTubePlayerView, yTubePlayerViewShorts);
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
