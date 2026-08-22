package org.pgpainless.key.selection.keyring.impl;

import java.util.Iterator;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;
import org.pgpainless.key.selection.key.SecretKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class PartialUserId {

    public static class PubRingSelectionStrategy extends PublicKeySelectionStrategy<String> {
        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(String str, @Nonnull PGPPublicKey pGPPublicKey) {
            Iterator<String> userIDs = pGPPublicKey.getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SecRingSelectionStrategy extends SecretKeySelectionStrategy<String> {
        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(String str, @Nonnull PGPSecretKey pGPSecretKey) {
            Iterator<String> userIDs = pGPSecretKey.getUserIDs();
            while (userIDs.hasNext()) {
                if (userIDs.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }
    }
}
