package org.jivesoftware.smack.experimental;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* JADX INFO: loaded from: classes10.dex */
public class ExperimentalInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getProvidersUri() {
        return "classpath:org.jivesoftware.smack.experimental/experimental.providers";
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getConfigUri() {
        return "classpath:org.jivesoftware.smack.experimental/experimental.xml";
    }
}
