package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public final class ActivityCustomMediaPlayerBinding implements ViewBinding {
    public final TextView addBookmark;
    public final TextView bookmarkBtn;
    public final LinearLayout bottomlayout;
    public final ImageView chatAddButton;
    public final TextView chatBtn;
    public final EditText etMessage;
    public final TextView floatingTextNew;
    public final TextView indexBtn;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    public final LinearLayout llll;
    public final TextView notes;
    public final PlayerView playerViewNew;
    public final TextView poll;
    public final ProgressBar progressBar;
    public final ImageView quality;
    public final RecyclerView recyclerView;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final RelativeLayout videoLayout;
    public final TextView videoName;

    private ActivityCustomMediaPlayerBinding(RelativeLayout rootView, TextView addBookmark, TextView bookmarkBtn, LinearLayout bottomlayout, ImageView chatAddButton, TextView chatBtn, EditText etMessage, TextView floatingTextNew, TextView indexBtn, ImageView ivSend, LinearLayout linearLayout, LinearLayout llll, TextView notes, PlayerView playerViewNew, TextView poll, ProgressBar progressBar, ImageView quality, RecyclerView recyclerView, RelativeLayout rootNew, RelativeLayout videoLayout, TextView videoName) {
        this.rootView = rootView;
        this.addBookmark = addBookmark;
        this.bookmarkBtn = bookmarkBtn;
        this.bottomlayout = bottomlayout;
        this.chatAddButton = chatAddButton;
        this.chatBtn = chatBtn;
        this.etMessage = etMessage;
        this.floatingTextNew = floatingTextNew;
        this.indexBtn = indexBtn;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
        this.llll = llll;
        this.notes = notes;
        this.playerViewNew = playerViewNew;
        this.poll = poll;
        this.progressBar = progressBar;
        this.quality = quality;
        this.recyclerView = recyclerView;
        this.rootNew = rootNew;
        this.videoLayout = videoLayout;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCustomMediaPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCustomMediaPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_custom_media_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCustomMediaPlayerBinding bind(View rootView) {
        int i = R.id.add_bookmark;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_bookmark);
        if (textView != null) {
            i = R.id.bookmark_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_btn);
            if (textView2 != null) {
                i = R.id.bottomlayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomlayout);
                if (linearLayout != null) {
                    i = R.id.chatAddButton;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatAddButton);
                    if (imageView != null) {
                        i = R.id.chat_btn;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.chat_btn);
                        if (textView3 != null) {
                            i = R.id.et_message;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                            if (editText != null) {
                                i = R.id.floatingText_new;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
                                if (textView4 != null) {
                                    i = R.id.index_btn;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.index_btn);
                                    if (textView5 != null) {
                                        i = R.id.iv_send;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                                        if (imageView2 != null) {
                                            i = R.id.linearLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                                            if (linearLayout2 != null) {
                                                i = R.id.llll;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llll);
                                                if (linearLayout3 != null) {
                                                    i = R.id.notes;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notes);
                                                    if (textView6 != null) {
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
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.recycler_view;
                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view);
                                                                        if (recyclerView != null) {
                                                                            i = R.id.root_new;
                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                                                                            if (relativeLayout != null) {
                                                                                i = R.id.video_layout;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.video_layout);
                                                                                if (relativeLayout2 != null) {
                                                                                    i = R.id.video_name;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                                                                    if (textView8 != null) {
                                                                                        return new ActivityCustomMediaPlayerBinding((RelativeLayout) rootView, textView, textView2, linearLayout, imageView, textView3, editText, textView4, textView5, imageView2, linearLayout2, linearLayout3, textView6, playerView, textView7, progressBar, imageView3, recyclerView, relativeLayout, relativeLayout2, textView8);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
