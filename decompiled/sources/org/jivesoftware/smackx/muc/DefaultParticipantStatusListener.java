package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class DefaultParticipantStatusListener implements ParticipantStatusListener {
    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void adminGranted(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void adminRevoked(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void banned(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void joined(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void kicked(EntityFullJid entityFullJid, Jid jid, String str) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void left(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void membershipGranted(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void membershipRevoked(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void moderatorGranted(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void moderatorRevoked(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void nicknameChanged(EntityFullJid entityFullJid, Resourcepart resourcepart) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void ownershipGranted(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void ownershipRevoked(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void voiceGranted(EntityFullJid entityFullJid) {
    }

    @Override // org.jivesoftware.smackx.muc.ParticipantStatusListener
    public void voiceRevoked(EntityFullJid entityFullJid) {
    }
}
