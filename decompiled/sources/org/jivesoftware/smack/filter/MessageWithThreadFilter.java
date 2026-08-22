package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class MessageWithThreadFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter INSTANCE = new MessageWithThreadFilter();

    private MessageWithThreadFilter() {
        super(Message.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return StringUtils.isNotEmpty(message.getThread());
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName();
    }
}
