package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class ThreadFilter extends FlexibleStanzaTypeFilter<Message> implements StanzaFilter {
    private final String thread;

    public ThreadFilter(String str) {
        StringUtils.requireNotNullNorEmpty(str, "Thread must not be null nor empty.");
        this.thread = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return this.thread.equals(message.getThread());
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName() + ": thread=" + this.thread;
    }
}
