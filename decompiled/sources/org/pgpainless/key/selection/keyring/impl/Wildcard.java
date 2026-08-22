package org.pgpainless.key.selection.keyring.impl;

import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class Wildcard {

    public static class PubRingSelectionStrategy<O> extends PublicKeyRingSelectionStrategy<O> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(O o, PGPPublicKeyRing pGPPublicKeyRing) {
            return true;
        }
    }

    public static class SecRingSelectionStrategy<O> extends SecretKeyRingSelectionStrategy<O> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(O o, PGPSecretKeyRing pGPSecretKeyRing) {
            return true;
        }
    }
}
