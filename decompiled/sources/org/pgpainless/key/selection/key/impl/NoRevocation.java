package org.pgpainless.key.selection.key.impl;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;
import org.pgpainless.key.selection.key.SecretKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class NoRevocation {

    public static class PubKeySelectionStrategy<O> extends PublicKeySelectionStrategy<O> {
        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(O o, @Nonnull PGPPublicKey pGPPublicKey) {
            return !pGPPublicKey.hasRevocation();
        }
    }

    public static class SecKeySelectionStrategy<O> extends SecretKeySelectionStrategy<O> {
        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(O o, @Nonnull PGPSecretKey pGPSecretKey) {
            return !pGPSecretKey.getPublicKey().hasRevocation();
        }
    }
}
