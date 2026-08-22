package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityJwVideoPlayerBinding implements ViewBinding {
    public final TextView MarqueeText;
    public final TextView addBookmark;
    public final TextView bookmarkBtn;
    public final TextView chatBtn;
    public final TextView indexBtn;
    public final LinearLayout llll;
    public final TextView notes;
    public final RelativeLayout parentLayout;
    public final PlayerView playerViewNew;
    public final TextView poll;
    public final ProgressBar progressBar;
    public final ImageView quality;
    public final RecyclerView recyclerView;
    public final Button retry;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final RelativeLayout videoLayout;
    public final TextView videoName;

    private ActivityJwVideoPlayerBinding(RelativeLayout rootView, TextView MarqueeText, TextView addBookmark, TextView bookmarkBtn, TextView chatBtn, TextView indexBtn, LinearLayout llll, TextView notes, RelativeLayout parentLayout, PlayerView playerViewNew, TextView poll, ProgressBar progressBar, ImageView quality, RecyclerView recyclerView, Button retry, RelativeLayout rootNew, RelativeLayout videoLayout, TextView videoName) {
        this.rootView = rootView;
        this.MarqueeText = MarqueeText;
        this.addBookmark = addBookmark;
        this.bookmarkBtn = bookmarkBtn;
        this.chatBtn = chatBtn;
        this.indexBtn = indexBtn;
        this.llll = llll;
        this.notes = notes;
        this.parentLayout = parentLayout;
        this.playerViewNew = playerViewNew;
        this.poll = poll;
        this.progressBar = progressBar;
        this.quality = quality;
        this.recyclerView = recyclerView;
        this.retry = retry;
        this.rootNew = rootNew;
        this.videoLayout = videoLayout;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityJwVideoPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityJwVideoPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_jw_video_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityJwVideoPlayerBinding bind(View rootView) {
        int i = R.id.MarqueeText;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.MarqueeText);
        if (textView != null) {
            i = R.id.add_bookmark;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_bookmark);
            if (textView2 != null) {
                i = R.id.bookmark_btn;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_btn);
                if (textView3 != null) {
                    i = R.id.chat_btn;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.chat_btn);
                    if (textView4 != null) {
                        i = R.id.index_btn;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.index_btn);
                        if (textView5 != null) {
                            i = R.id.llll;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llll);
                            if (linearLayout != null) {
                                i = R.id.notes;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notes);
                                if (textView6 != null) {
                                    i = R.id.parent_layout;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
                                    if (relativeLayout != null) {
                                        i = R.id.player_view_new;
                                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
                                        if (playerView != null) {
                                            i = R.id.poll;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.poll);
                                            if (textView7 != null) {
                                                i = R.id.progress_bar;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                                                if (progressBar != null) {
                                                    i = R.id.quality;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                    if (imageView != null) {
                                                        i = R.id.recycler_view;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view);
                                                        if (recyclerView != null) {
                                                            i = R.id.retry;
                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.retry);
                                                            if (button != null) {
                                                                i = R.id.root_new;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.video_layout;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.video_layout);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.video_name;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                                                        if (textView8 != null) {
                                                                            return new ActivityJwVideoPlayerBinding((RelativeLayout) rootView, textView, textView2, textView3, textView4, textView5, linearLayout, textView6, relativeLayout, playerView, textView7, progressBar, imageView, recyclerView, button, relativeLayout2, relativeLayout3, textView8);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
