package org.jivesoftware.smackx.ox.selection_strategy;

import java.util.Iterator;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class BareJidUserId {

    public static class PubRingSelectionStrategy extends PublicKeyRingSelectionStrategy<BareJid> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) {
            Iterator<String> userIDs = pGPPublicKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().equals("xmpp:" + bareJid.toString())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SecRingSelectionStrategy extends SecretKeyRingSelectionStrategy<BareJid> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) {
            Iterator<String> userIDs = pGPSecretKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().equals("xmpp:" + bareJid.toString())) {
                    return true;
                }
            }
            return false;
        }
    }
}
