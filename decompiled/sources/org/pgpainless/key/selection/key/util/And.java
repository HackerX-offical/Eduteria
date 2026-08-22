package org.pgpainless.key.selection.key.util;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;
import org.pgpainless.key.selection.key.SecretKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class And {

    public static class PubKeySelectionStrategy<O> extends PublicKeySelectionStrategy<O> {
        private final PublicKeySelectionStrategy<O> left;
        private final PublicKeySelectionStrategy<O> right;

        public PubKeySelectionStrategy(@Nonnull PublicKeySelectionStrategy<O> publicKeySelectionStrategy, @Nonnull PublicKeySelectionStrategy<O> publicKeySelectionStrategy2) {
            this.left = publicKeySelectionStrategy;
            this.right = publicKeySelectionStrategy2;
        }

        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(O o, PGPPublicKey pGPPublicKey) {
            return this.left.accept(o, pGPPublicKey) && this.right.accept(o, pGPPublicKey);
        }
    }

    public static class SecKeySelectionStrategy<O> extends SecretKeySelectionStrategy<O> {
        private final SecretKeySelectionStrategy<O> left;
        private final SecretKeySelectionStrategy<O> right;

        public SecKeySelectionStrategy(@Nonnull SecretKeySelectionStrategy<O> secretKeySelectionStrategy, @Nonnull SecretKeySelectionStrategy<O> secretKeySelectionStrategy2) {
            this.left = secretKeySelectionStrategy;
            this.right = secretKeySelectionStrategy2;
        }

        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(O o, PGPSecretKey pGPSecretKey) {
            return this.left.accept(o, pGPSecretKey) && this.right.accept(o, pGPSecretKey);
        }
    }
}
