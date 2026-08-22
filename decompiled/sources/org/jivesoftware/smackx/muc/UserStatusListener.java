package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface UserStatusListener {
    default void adminGranted() {
    }

    default void adminRevoked() {
    }

    default void banned(Jid jid, String str) {
    }

    default void kicked(Jid jid, String str) {
    }

    default void membershipGranted() {
    }

    default void membershipRevoked() {
    }

    default void moderatorGranted() {
    }

    default void moderatorRevoked() {
    }

    default void ownershipGranted() {
    }

    default void ownershipRevoked() {
    }

    default void removed(MUCUser mUCUser, Presence presence) {
    }

    default void roomDestroyed(MultiUserChat multiUserChat, String str) {
    }

    default void voiceGranted() {
    }

    default void voiceRevoked() {
    }
}
