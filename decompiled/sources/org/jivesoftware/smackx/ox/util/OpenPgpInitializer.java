package org.jivesoftware.smackx.ox.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.util.SecurityUtil;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpInitializer extends UrlInitializer {
    static {
        SecurityUtil.ensureProviderAtFirstPosition(BouncyCastleProvider.class);
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    protected String getProvidersUri() {
        return "classpath:org.jivesoftware.smackx.ox/openpgp.providers";
    }
}
