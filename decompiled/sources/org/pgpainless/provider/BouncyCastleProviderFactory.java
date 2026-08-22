package org.pgpainless.provider;

import java.security.Provider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes10.dex */
public final class BouncyCastleProviderFactory extends ProviderFactory {
    private static final Provider provider = new BouncyCastleProvider();

    @Override // org.pgpainless.provider.ProviderFactory
    public Provider _getProvider() {
        return provider;
    }

    @Override // org.pgpainless.provider.ProviderFactory
    public String _getProviderName() {
        return _getProvider().getName();
    }
}
