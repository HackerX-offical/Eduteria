package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Presence;

/* JADX INFO: loaded from: classes10.dex */
public interface PresenceView extends StanzaView {
    Presence.Mode getMode();

    int getPriority();

    byte getPriorityByte();

    String getStatus();

    Presence.Type getType();
}
