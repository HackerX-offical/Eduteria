package org.jivesoftware.smackx.jingle;

import org.jxmpp.jid.FullJid;

/* JADX INFO: loaded from: classes10.dex */
public class FullJidAndSessionId {
    private final FullJid fullJid;
    private final String sessionId;

    public FullJidAndSessionId(FullJid fullJid, String str) {
        this.fullJid = fullJid;
        this.sessionId = str;
    }

    public FullJid getFullJid() {
        return this.fullJid;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (this.fullJid.hashCode() * 961) + this.sessionId.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FullJidAndSessionId)) {
            return false;
        }
        FullJidAndSessionId fullJidAndSessionId = (FullJidAndSessionId) obj;
        return this.fullJid.equals((CharSequence) fullJidAndSessionId.fullJid) && this.sessionId.equals(fullJidAndSessionId.sessionId);
    }
}
