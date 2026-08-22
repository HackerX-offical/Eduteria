package org.jivesoftware.smack.util.dns;

import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes10.dex */
public interface SmackDaneVerifier {
    void finish(SSLSession sSLSession) throws CertificateException;

    void init(SSLContext sSLContext, KeyManager[] keyManagerArr, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws KeyManagementException;
}
