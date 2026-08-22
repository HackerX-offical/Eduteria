package org.jivesoftware.smackx.muc.filter;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.muc.packet.MUCUser;

/* JADX INFO: loaded from: classes10.dex */
public class MUCUserStatusCodeFilter implements StanzaFilter {
    public static final MUCUserStatusCodeFilter STATUS_110_PRESENCE_TO_SELF = new MUCUserStatusCodeFilter(MUCUser.Status.PRESENCE_TO_SELF_110);
    private final MUCUser.Status status;

    public MUCUserStatusCodeFilter(MUCUser.Status status) {
        this.status = status;
    }

    public MUCUserStatusCodeFilter(int i) {
        this(MUCUser.Status.create(Integer.valueOf(i)));
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        MUCUser mUCUserFrom = MUCUser.from(stanza);
        if (mUCUserFrom == null) {
            return false;
        }
        return mUCUserFrom.getStatus().contains(this.status);
    }

    public String toString() {
        return getClass().getSimpleName() + ": status=" + this.status;
    }
}
