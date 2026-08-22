package org.jivesoftware.smackx.disco;

import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class DiscoInfoLookupShortcutMechanism implements Comparable<DiscoInfoLookupShortcutMechanism> {
    private final String name;
    private final int priority;

    public abstract DiscoverInfo getDiscoverInfoByUser(ServiceDiscoveryManager serviceDiscoveryManager, Jid jid);

    protected DiscoInfoLookupShortcutMechanism(String str, int i) {
        this.name = str;
        this.priority = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Override // java.lang.Comparable
    public final int compareTo(DiscoInfoLookupShortcutMechanism discoInfoLookupShortcutMechanism) {
        return Integer.compare(getPriority(), discoInfoLookupShortcutMechanism.getPriority());
    }
}
