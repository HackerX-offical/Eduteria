package org.pgpainless.key.selection.keyring.impl;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.pgpainless.key.selection.keyring.impl.PartialUserId;

/* JADX INFO: loaded from: classes10.dex */
public class Email {

    public static class PubRingSelectionStrategy extends PartialUserId.PubRingSelectionStrategy {
        @Override // org.pgpainless.key.selection.keyring.impl.PartialUserId.PubRingSelectionStrategy, org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(@Nonnull String str, @Nonnull PGPPublicKey pGPPublicKey) {
            if (!str.matches("^<.+>$")) {
                str = "<" + str + ">";
            }
            return super.accept(str, pGPPublicKey);
        }
    }

    public static class SecRingSelectionStrategy extends PartialUserId.SecRingSelectionStrategy {
        @Override // org.pgpainless.key.selection.keyring.impl.PartialUserId.SecRingSelectionStrategy, org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(String str, PGPSecretKey pGPSecretKey) {
            if (!str.matches("^<.+>$")) {
                str = "<" + str + ">";
            }
            return super.accept(str, pGPSecretKey);
        }
    }
}
