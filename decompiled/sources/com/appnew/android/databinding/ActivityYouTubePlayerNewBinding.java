package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityYouTubePlayerNewBinding implements ViewBinding {
    public final FrameLayout fullScreenViewContainer;
    public final ImageView refreshUrl;
    public final RelativeLayout relativeLayout;
    public final RelativeLayout relativeLayout0;
    public final RelativeLayout relativeLayout1;
    private final RelativeLayout rootView;
    public final YouTubePlayerView youtubePlayerView;

    private ActivityYouTubePlayerNewBinding(RelativeLayout rootView, FrameLayout fullScreenViewContainer, ImageView refreshUrl, RelativeLayout relativeLayout, RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, YouTubePlayerView youtubePlayerView) {
        this.rootView = rootView;
        this.fullScreenViewContainer = fullScreenViewContainer;
        this.refreshUrl = refreshUrl;
        this.relativeLayout = relativeLayout;
        this.relativeLayout0 = relativeLayout0;
        this.relativeLayout1 = relativeLayout1;
        this.youtubePlayerView = youtubePlayerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityYouTubePlayerNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityYouTubePlayerNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_you_tube_player_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityYouTubePlayerNewBinding bind(View rootView) {
        int i = R.id.full_screen_view_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.full_screen_view_container);
        if (frameLayout != null) {
            i = R.id.refreshUrl;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refreshUrl);
            if (imageView != null) {
                i = R.id.relativeLayout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout);
                if (relativeLayout != null) {
                    i = R.id.relativeLayout0;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout0);
                    if (relativeLayout2 != null) {
                        i = R.id.relativeLayout1;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout1);
                        if (relativeLayout3 != null) {
                            i = R.id.youtube_player_view;
                            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(rootView, R.id.youtube_player_view);
                            if (youTubePlayerView != null) {
                                return new ActivityYouTubePlayerNewBinding((RelativeLayout) rootView, frameLayout, imageView, relativeLayout, relativeLayout2, relativeLayout3, youTubePlayerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
