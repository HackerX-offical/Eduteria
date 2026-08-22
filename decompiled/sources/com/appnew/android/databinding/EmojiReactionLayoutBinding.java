package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EmojiReactionLayoutBinding implements ViewBinding {
    public final TextView angryText;
    public final TextView laughText;
    public final TextView likeText;
    public final TextView loveText;
    private final RelativeLayout rootView;
    public final TextView sadText;
    public final TextView wowText;

    private EmojiReactionLayoutBinding(RelativeLayout rootView, TextView angryText, TextView laughText, TextView likeText, TextView loveText, TextView sadText, TextView wowText) {
        this.rootView = rootView;
        this.angryText = angryText;
        this.laughText = laughText;
        this.likeText = likeText;
        this.loveText = loveText;
        this.sadText = sadText;
        this.wowText = wowText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EmojiReactionLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EmojiReactionLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.emoji_reaction_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EmojiReactionLayoutBinding bind(View rootView) {
        int i = R.id.angry_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.angry_text);
        if (textView != null) {
            i = R.id.laugh_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.laugh_text);
            if (textView2 != null) {
                i = R.id.like_text;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.like_text);
                if (textView3 != null) {
                    i = R.id.love_text;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.love_text);
                    if (textView4 != null) {
                        i = R.id.sad_text;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sad_text);
                        if (textView5 != null) {
                            i = R.id.wow_text;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.wow_text);
                            if (textView6 != null) {
                                return new EmojiReactionLayoutBinding((RelativeLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
