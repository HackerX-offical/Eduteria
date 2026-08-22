package org.jivesoftware.smack.provider;

import java.util.Collection;

/* JADX INFO: loaded from: classes10.dex */
public interface ProviderLoader {
    Collection<ExtensionProviderInfo> getExtensionProviderInfo();

    Collection<IQProviderInfo> getIQProviderInfo();

    Collection<StreamFeatureProviderInfo> getStreamFeatureProviderInfo();
}
