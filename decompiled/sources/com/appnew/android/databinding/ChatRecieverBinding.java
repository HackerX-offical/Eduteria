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
public final class ChatRecieverBinding implements ViewBinding {
    public final TextView recieverChat;
    public final TextView recieverChatTime;
    private final RelativeLayout rootView;

    private ChatRecieverBinding(RelativeLayout rootView, TextView recieverChat, TextView recieverChatTime) {
        this.rootView = rootView;
        this.recieverChat = recieverChat;
        this.recieverChatTime = recieverChatTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChatRecieverBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChatRecieverBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.chat_reciever, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChatRecieverBinding bind(View rootView) {
        int i = R.id.reciever_chat;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.reciever_chat);
        if (textView != null) {
            i = R.id.reciever_chat_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reciever_chat_time);
            if (textView2 != null) {
                return new ChatRecieverBinding((RelativeLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
