package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCustomDialogPlayerBinding implements ViewBinding {
    public final ImageView cross;
    public final PlayerView playerViewNew;
    public final ProgressBar progressBar;
    public final ImageView quality;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;

    private ActivityCustomDialogPlayerBinding(RelativeLayout rootView, ImageView cross, PlayerView playerViewNew, ProgressBar progressBar, ImageView quality, RelativeLayout rootNew) {
        this.rootView = rootView;
        this.cross = cross;
        this.playerViewNew = playerViewNew;
        this.progressBar = progressBar;
        this.quality = quality;
        this.rootNew = rootNew;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCustomDialogPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCustomDialogPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_custom_dialog_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCustomDialogPlayerBinding bind(View rootView) {
        int i = R.id.cross;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
        if (imageView != null) {
            i = R.id.player_view_new;
            PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
            if (playerView != null) {
                i = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                if (progressBar != null) {
                    i = R.id.quality;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                    if (imageView2 != null) {
                        i = R.id.root_new;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                        if (relativeLayout != null) {
                            return new ActivityCustomDialogPlayerBinding((RelativeLayout) rootView, imageView, playerView, progressBar, imageView2, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
