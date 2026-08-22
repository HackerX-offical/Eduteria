package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityEncVideoPlayerBinding implements ViewBinding {
    public final TextView floatingTextNew;
    public final LinearLayout lLayoutVideoValidity;
    public final PlayerView playerViewNew;
    private final RelativeLayout rootView;
    public final TextView tvVideoValidityCounter;

    private ActivityEncVideoPlayerBinding(RelativeLayout rootView, TextView floatingTextNew, LinearLayout lLayoutVideoValidity, PlayerView playerViewNew, TextView tvVideoValidityCounter) {
        this.rootView = rootView;
        this.floatingTextNew = floatingTextNew;
        this.lLayoutVideoValidity = lLayoutVideoValidity;
        this.playerViewNew = playerViewNew;
        this.tvVideoValidityCounter = tvVideoValidityCounter;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEncVideoPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityEncVideoPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_enc_video_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityEncVideoPlayerBinding bind(View rootView) {
        int i = R.id.floatingText_new;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
        if (textView != null) {
            i = R.id.l_layout_VideoValidity;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.l_layout_VideoValidity);
            if (linearLayout != null) {
                i = R.id.player_view_new;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
                if (playerView != null) {
                    i = R.id.tv_videoValidityCounter;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_videoValidityCounter);
                    if (textView2 != null) {
                        return new ActivityEncVideoPlayerBinding((RelativeLayout) rootView, textView, linearLayout, playerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
