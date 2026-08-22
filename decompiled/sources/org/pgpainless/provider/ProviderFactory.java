package org.pgpainless.provider;

import java.security.Provider;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ProviderFactory {
    private static ProviderFactory FACTORY = new BouncyCastleProviderFactory();

    protected abstract Provider _getProvider();

    protected abstract String _getProviderName();

    public static void setFactory(ProviderFactory providerFactory) {
        FACTORY = providerFactory;
    }

    public static Provider getProvider() {
        return FACTORY._getProvider();
    }

    public static String getProviderName() {
        return FACTORY._getProviderName();
    }
}
