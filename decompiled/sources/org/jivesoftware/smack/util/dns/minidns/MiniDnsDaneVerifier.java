package org.jivesoftware.smack.util.dns.minidns;

import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.minidns.dane.DaneVerifier;
import org.minidns.dane.ExpectingTrustManager;

/* JADX INFO: loaded from: classes10.dex */
public class MiniDnsDaneVerifier implements SmackDaneVerifier {
    private static final DaneVerifier VERIFIER = new DaneVerifier();
    private ExpectingTrustManager expectingTrustManager;

    MiniDnsDaneVerifier() {
    }

    @Override // org.jivesoftware.smack.util.dns.SmackDaneVerifier
    public void init(SSLContext sSLContext, KeyManager[] keyManagerArr, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException {
        if (this.expectingTrustManager != null) {
            throw new IllegalStateException("DaneProvider was initialized before. Use newInstance() instead.");
        }
        ExpectingTrustManager expectingTrustManager = new ExpectingTrustManager(x509TrustManager);
        this.expectingTrustManager = expectingTrustManager;
        sSLContext.init(keyManagerArr, new TrustManager[]{expectingTrustManager}, secureRandom);
    }

    @Override // org.jivesoftware.smack.util.dns.SmackDaneVerifier
    public void finish(SSLSession sSLSession) throws CertificateException {
        if (!VERIFIER.verify(sSLSession) && this.expectingTrustManager.hasException()) {
            throw this.expectingTrustManager.getException();
        }
    }
}
