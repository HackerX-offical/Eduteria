package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public interface ParticipantStatusListener {
    default void adminGranted(EntityFullJid entityFullJid) {
    }

    default void adminRevoked(EntityFullJid entityFullJid) {
    }

    default void banned(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    default void joined(EntityFullJid entityFullJid) {
    }

    default void kicked(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    default void left(EntityFullJid entityFullJid) {
    }

    default void membershipGranted(EntityFullJid entityFullJid) {
    }

    default void membershipRevoked(EntityFullJid entityFullJid) {
    }

    default void moderatorGranted(EntityFullJid entityFullJid) {
    }

    default void moderatorRevoked(EntityFullJid entityFullJid) {
    }

    default void nicknameChanged(EntityFullJid entityFullJid, Resourcepart resourcepart) {
    }

    default void ownershipGranted(EntityFullJid entityFullJid) {
    }

    default void ownershipRevoked(EntityFullJid entityFullJid) {
    }

    default void parted(EntityFullJid entityFullJid) {
    }

    default void voiceGranted(EntityFullJid entityFullJid) {
    }

    default void voiceRevoked(EntityFullJid entityFullJid) {
    }
}
