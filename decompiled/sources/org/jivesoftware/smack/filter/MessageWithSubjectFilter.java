package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;

/* JADX INFO: loaded from: classes10.dex */
public final class MessageWithSubjectFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter INSTANCE = new MessageWithSubjectFilter();

    private MessageWithSubjectFilter() {
        super(Message.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return message.getSubject() != null;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName();
    }
}
