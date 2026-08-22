package org.jivesoftware.smack.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;

/* JADX INFO: loaded from: classes10.dex */
public class TLSUtils {
    private static final int JKS_MAGIC = -17957139;
    private static final int JKS_VERSION_1 = 1;
    private static final int JKS_VERSION_2 = 2;
    public static final String PROTO_SSL3 = "SSLv3";
    public static final String PROTO_TLSV1 = "TLSv1";
    public static final String PROTO_TLSV1_1 = "TLSv1.1";
    public static final String PROTO_TLSV1_2 = "TLSv1.2";
    public static final String PROTO_TLSV1_3 = "TLSv1.3";
    public static final String SSL = "SSL";
    public static final String TLS = "TLS";
    private static final Logger LOGGER = Logger.getLogger(TLSUtils.class.getName());
    private static final File DEFAULT_TRUSTSTORE_PATH = new File(System.getProperty("java.home") + File.separator + "lib" + File.separator + "security" + File.separator + "cacerts");

    enum DefaultTrustStoreType {
        jks,
        unknown,
        no_default
    }

    static /* synthetic */ boolean lambda$disableHostnameVerificationForTlsCertificates$0(String str, SSLSession sSLSession) {
        return true;
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setEnabledTlsProtocolsToRecommended(B b2) {
        b2.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_3, PROTO_TLSV1_2});
        return b2;
    }

    @Deprecated
    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setTLSOnly(B b2) {
        b2.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_2, PROTO_TLSV1_1, PROTO_TLSV1});
        return b2;
    }

    @Deprecated
    public static <B extends ConnectionConfiguration.Builder<B, ?>> B setSSLv3AndTLSOnly(B b2) {
        b2.setEnabledSSLProtocols(new String[]{PROTO_TLSV1_2, PROTO_TLSV1_1, PROTO_TLSV1, PROTO_SSL3});
        return b2;
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B acceptAllCertificates(B b2) {
        b2.setCustomX509TrustManager(new AcceptAllTrustManager());
        return b2;
    }

    public static <B extends ConnectionConfiguration.Builder<B, ?>> B disableHostnameVerificationForTlsCertificates(B b2) {
        b2.setHostnameVerifier(new HostnameVerifier() { // from class: org.jivesoftware.smack.util.TLSUtils$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return TLSUtils.lambda$disableHostnameVerificationForTlsCertificates$0(str, sSLSession);
            }
        });
        return b2;
    }

    public static void setEnabledProtocolsAndCiphers(SSLSocket sSLSocket, String[] strArr, String[] strArr2) throws SmackException.SecurityNotPossibleException {
        if (strArr != null) {
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            HashSet hashSet2 = new HashSet(Arrays.asList(sSLSocket.getSupportedProtocols()));
            HashSet hashSet3 = new HashSet(hashSet2);
            hashSet3.retainAll(hashSet);
            if (hashSet3.isEmpty()) {
                throw new SmackException.SecurityNotPossibleException("Request to enable SSL/TLS protocols '" + StringUtils.collectionToString(hashSet) + "', but only '" + StringUtils.collectionToString(hashSet2) + "' are supported.");
            }
            sSLSocket.setEnabledProtocols((String[]) hashSet3.toArray(new String[hashSet3.size()]));
        }
        if (strArr2 != null) {
            HashSet hashSet4 = new HashSet(Arrays.asList(strArr2));
            HashSet hashSet5 = new HashSet(Arrays.asList(sSLSocket.getEnabledCipherSuites()));
            HashSet hashSet6 = new HashSet(hashSet5);
            hashSet6.retainAll(hashSet4);
            if (hashSet6.isEmpty()) {
                throw new SmackException.SecurityNotPossibleException("Request to enable SSL/TLS ciphers '" + StringUtils.collectionToString(hashSet4) + "', but only '" + StringUtils.collectionToString(hashSet5) + "' are supported.");
            }
            sSLSocket.setEnabledCipherSuites((String[]) hashSet6.toArray(new String[hashSet6.size()]));
        }
    }

    public static byte[] getChannelBindingTlsServerEndPoint(SSLSession sSLSession) throws NoSuchAlgorithmException, SSLPeerUnverifiedException, CertificateEncodingException {
        Certificate certificate = sSLSession.getPeerCertificates()[0];
        String algorithm = certificate.getPublicKey().getAlgorithm();
        algorithm.hashCode();
        if (algorithm.equals(StringUtils.MD5) || algorithm.equals("SHA-1")) {
            algorithm = "SHA-256";
        }
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(certificate.getEncoded());
        return messageDigest.digest();
    }

    public static class AcceptAllTrustManager implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static FileInputStream getDefaultTruststoreStreamIfPossible() {
        try {
            return new FileInputStream(DEFAULT_TRUSTSTORE_PATH);
        } catch (FileNotFoundException e2) {
            LOGGER.log(Level.WARNING, "Could not open default truststore at " + DEFAULT_TRUSTSTORE_PATH, (Throwable) e2);
            return null;
        }
    }

    public static DefaultTrustStoreType getDefaultTruststoreType() throws IOException {
        FileInputStream defaultTruststoreStreamIfPossible = getDefaultTruststoreStreamIfPossible();
        try {
            if (defaultTruststoreStreamIfPossible == null) {
                DefaultTrustStoreType defaultTrustStoreType = DefaultTrustStoreType.no_default;
                if (defaultTruststoreStreamIfPossible != null) {
                    defaultTruststoreStreamIfPossible.close();
                }
                return defaultTrustStoreType;
            }
            DataInputStream dataInputStream = new DataInputStream(defaultTruststoreStreamIfPossible);
            int i = dataInputStream.readInt();
            int i2 = dataInputStream.readInt();
            if (i == JKS_MAGIC && (i2 == 1 || i2 == 2)) {
                DefaultTrustStoreType defaultTrustStoreType2 = DefaultTrustStoreType.jks;
                if (defaultTruststoreStreamIfPossible != null) {
                    defaultTruststoreStreamIfPossible.close();
                }
                return defaultTrustStoreType2;
            }
            if (defaultTruststoreStreamIfPossible != null) {
                defaultTruststoreStreamIfPossible.close();
            }
            return DefaultTrustStoreType.unknown;
        } catch (Throwable th) {
            if (defaultTruststoreStreamIfPossible != null) {
                try {
                    defaultTruststoreStreamIfPossible.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void setDefaultTrustStoreTypeToJksIfRequired() {
        try {
            if (getDefaultTruststoreType() == DefaultTrustStoreType.jks) {
                System.setProperty(SSLSocketFactoryFactory.SYSTRUSTSTORETYPE, "JKS");
            }
        } catch (IOException e2) {
            LOGGER.log(Level.WARNING, "Could not set keystore type to jks if required", (Throwable) e2);
        }
    }
}
