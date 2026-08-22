package org.pgpainless.key.selection.keyring.impl;

import java.util.Iterator;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class ExactUserId {

    public static class PubRingSelectionStrategy extends PublicKeyRingSelectionStrategy<String> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(String str, PGPPublicKeyRing pGPPublicKeyRing) {
            Iterator<String> userIDs = pGPPublicKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SecRingSelectionStrategy extends SecretKeyRingSelectionStrategy<String> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(String str, PGPSecretKeyRing pGPSecretKeyRing) {
            Iterator<String> userIDs = pGPSecretKeyRing.getPublicKey().getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }
}
