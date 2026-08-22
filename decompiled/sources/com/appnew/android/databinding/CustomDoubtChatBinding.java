package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomDoubtChatBinding implements ViewBinding {
    public final CardView masterMessageCard;
    public final TextView replayMessage;
    private final RelativeLayout rootView;
    public final TextView userMessage;
    public final CardView userMessageCard;

    private CustomDoubtChatBinding(RelativeLayout rootView, CardView masterMessageCard, TextView replayMessage, TextView userMessage, CardView userMessageCard) {
        this.rootView = rootView;
        this.masterMessageCard = masterMessageCard;
        this.replayMessage = replayMessage;
        this.userMessage = userMessage;
        this.userMessageCard = userMessageCard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomDoubtChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDoubtChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_doubt_chat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDoubtChatBinding bind(View rootView) {
        int i = R.id.masterMessageCard;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.masterMessageCard);
        if (cardView != null) {
            i = R.id.replayMessage;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayMessage);
            if (textView != null) {
                i = R.id.userMessage;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userMessage);
                if (textView2 != null) {
                    i = R.id.userMessageCard;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.userMessageCard);
                    if (cardView2 != null) {
                        return new CustomDoubtChatBinding((RelativeLayout) rootView, cardView, textView, textView2, cardView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
