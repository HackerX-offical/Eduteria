package org.jivesoftware.smack.internal;

import javax.net.ssl.SSLContext;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;

/* JADX INFO: loaded from: classes10.dex */
public final class SmackTlsContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final SmackDaneVerifier daneVerifier;
    public final SSLContext sslContext;

    public SmackTlsContext(SSLContext sSLContext, SmackDaneVerifier smackDaneVerifier) {
        this.sslContext = sSLContext;
        this.daneVerifier = smackDaneVerifier;
    }
}
