package org.jivesoftware.smack.extensions;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* JADX INFO: loaded from: classes10.dex */
public class ExtensionsInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getProvidersUri() {
        return "classpath:org.jivesoftware.smack.extensions/extensions.providers";
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getConfigUri() {
        return "classpath:org.jivesoftware.smack.extensions/extensions.xml";
    }
}
