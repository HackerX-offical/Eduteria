package org.jivesoftware.smack.roster;

import org.jivesoftware.smack.packet.Presence;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface SubscribeListener {

    public enum SubscribeAnswer {
        Approve,
        ApproveAndAlsoRequestIfRequired,
        Deny
    }

    SubscribeAnswer processSubscribe(Jid jid, Presence presence);
}
