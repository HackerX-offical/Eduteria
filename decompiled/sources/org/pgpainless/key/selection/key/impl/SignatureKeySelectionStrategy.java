package org.pgpainless.key.selection.key.impl;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.pgpainless.key.selection.key.SecretKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class SignatureKeySelectionStrategy<O> extends SecretKeySelectionStrategy<O> {
    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public boolean accept(O o, @Nonnull PGPSecretKey pGPSecretKey) {
        return pGPSecretKey.isSigningKey();
    }
}
