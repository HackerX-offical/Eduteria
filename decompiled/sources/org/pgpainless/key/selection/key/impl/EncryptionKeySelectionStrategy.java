package org.pgpainless.key.selection.key.impl;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class EncryptionKeySelectionStrategy<O> extends PublicKeySelectionStrategy<O> {
    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public boolean accept(O o, @Nonnull PGPPublicKey pGPPublicKey) {
        return pGPPublicKey.isEncryptionKey();
    }
}
