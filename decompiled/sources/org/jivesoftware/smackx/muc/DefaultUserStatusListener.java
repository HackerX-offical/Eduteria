package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class DefaultUserStatusListener implements UserStatusListener {
    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void adminGranted() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void adminRevoked() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void banned(Jid jid, String str) {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void kicked(Jid jid, String str) {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void membershipGranted() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void membershipRevoked() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void moderatorGranted() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void moderatorRevoked() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void ownershipGranted() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void ownershipRevoked() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void roomDestroyed(MultiUserChat multiUserChat, String str) {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void voiceGranted() {
    }

    @Override // org.jivesoftware.smackx.muc.UserStatusListener
    public void voiceRevoked() {
    }
}
