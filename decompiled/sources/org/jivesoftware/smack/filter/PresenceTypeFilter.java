package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class PresenceTypeFilter extends FlexibleStanzaTypeFilter<Presence> {
    public static final PresenceTypeFilter AVAILABLE;
    public static final PresenceTypeFilter ERROR;
    public static final StanzaFilter OUTGOING_PRESENCE_BROADCAST;
    public static final PresenceTypeFilter PROBE;
    public static final PresenceTypeFilter SUBSCRIBE;
    public static final PresenceTypeFilter SUBSCRIBED;
    public static final PresenceTypeFilter UNAVAILABLE;
    public static final PresenceTypeFilter UNSUBSCRIBE;
    public static final PresenceTypeFilter UNSUBSCRIBED;
    private final Presence.Type type;

    static {
        PresenceTypeFilter presenceTypeFilter = new PresenceTypeFilter(Presence.Type.available);
        AVAILABLE = presenceTypeFilter;
        UNAVAILABLE = new PresenceTypeFilter(Presence.Type.unavailable);
        SUBSCRIBE = new PresenceTypeFilter(Presence.Type.subscribe);
        SUBSCRIBED = new PresenceTypeFilter(Presence.Type.subscribed);
        UNSUBSCRIBE = new PresenceTypeFilter(Presence.Type.unsubscribe);
        UNSUBSCRIBED = new PresenceTypeFilter(Presence.Type.unsubscribed);
        ERROR = new PresenceTypeFilter(Presence.Type.error);
        PROBE = new PresenceTypeFilter(Presence.Type.probe);
        OUTGOING_PRESENCE_BROADCAST = new AndFilter(presenceTypeFilter, EmptyToMatcher.INSTANCE);
    }

    private PresenceTypeFilter(Presence.Type type) {
        super(Presence.class);
        this.type = (Presence.Type) Objects.requireNonNull(type, "type must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Presence presence) {
        return presence.getType() == this.type;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName() + ": type=" + this.type;
    }
}
