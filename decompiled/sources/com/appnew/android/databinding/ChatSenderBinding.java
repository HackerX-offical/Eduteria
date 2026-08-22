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
public final class ChatSenderBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView senderChat;
    public final TextView senderChatTime;

    private ChatSenderBinding(RelativeLayout rootView, TextView senderChat, TextView senderChatTime) {
        this.rootView = rootView;
        this.senderChat = senderChat;
        this.senderChatTime = senderChatTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChatSenderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChatSenderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.chat_sender, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChatSenderBinding bind(View rootView) {
        int i = R.id.sender_chat;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.sender_chat);
        if (textView != null) {
            i = R.id.sender_chat_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sender_chat_time);
            if (textView2 != null) {
                return new ChatSenderBinding((RelativeLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
