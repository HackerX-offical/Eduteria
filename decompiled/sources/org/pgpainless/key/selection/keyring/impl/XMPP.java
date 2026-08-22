package org.pgpainless.key.selection.keyring.impl;

import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.selection.keyring.impl.ExactUserId;

/* JADX INFO: loaded from: classes10.dex */
public class XMPP {

    public static class PubRingSelectionStrategy extends ExactUserId.PubRingSelectionStrategy {
        @Override // org.pgpainless.key.selection.keyring.impl.ExactUserId.PubRingSelectionStrategy, org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(String str, PGPPublicKeyRing pGPPublicKeyRing) {
            if (!str.matches("^xmpp:.+$")) {
                str = "xmpp:" + str;
            }
            return super.accept(str, pGPPublicKeyRing);
        }
    }

    public static class SecRingSelectionStrategy extends ExactUserId.SecRingSelectionStrategy {
        @Override // org.pgpainless.key.selection.keyring.impl.ExactUserId.SecRingSelectionStrategy, org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(String str, PGPSecretKeyRing pGPSecretKeyRing) {
            if (!str.matches("^xmpp:.+$")) {
                str = "xmpp:" + str;
            }
            return super.accept(str, pGPSecretKeyRing);
        }
    }
}
