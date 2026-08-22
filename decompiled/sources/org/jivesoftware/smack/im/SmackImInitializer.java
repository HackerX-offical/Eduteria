package org.jivesoftware.smack.im;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* JADX INFO: loaded from: classes10.dex */
public class SmackImInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getProvidersUri() {
        return "classpath:org.jivesoftware.smack.im/smackim.providers";
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getConfigUri() {
        return "classpath:org.jivesoftware.smack.im/smackim.xml";
    }
}
