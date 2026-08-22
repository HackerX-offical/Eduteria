package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.MessageBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface MucMessageInterceptor {
    void intercept(MessageBuilder messageBuilder, MultiUserChat multiUserChat);
}
