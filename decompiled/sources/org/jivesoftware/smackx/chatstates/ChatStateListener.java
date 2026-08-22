package org.jivesoftware.smackx.chatstates;

import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: loaded from: classes10.dex */
public interface ChatStateListener {
    void stateChanged(Chat chat, ChatState chatState, Message message);
}
