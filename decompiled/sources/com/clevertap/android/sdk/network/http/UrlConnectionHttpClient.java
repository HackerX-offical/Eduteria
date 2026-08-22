package com.clevertap.android.sdk.network.http;

import android.net.TrafficStats;
import com.clevertap.android.sdk.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: UrlConnectionHttpClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/clevertap/android/sdk/network/http/UrlConnectionHttpClient;", "Lcom/clevertap/android/sdk/network/http/CtHttpClient;", "isSslPinningEnabled", "", "logger", "Lcom/clevertap/android/sdk/Logger;", "logTag", "", "<init>", "(ZLcom/clevertap/android/sdk/Logger;Ljava/lang/String;)V", "()Z", "setSslPinningEnabled", "(Z)V", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "socketFactory$delegate", "Lkotlin/Lazy;", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "sslContext$delegate", "execute", "Lcom/clevertap/android/sdk/network/http/Response;", "request", "Lcom/clevertap/android/sdk/network/http/Request;", "openHttpsURLConnection", "Ljavax/net/ssl/HttpsURLConnection;", "createSslContext", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UrlConnectionHttpClient implements CtHttpClient {
    public static final int CONNECT_TIMEOUT = 10000;
    public static final int NETWORK_TAG_HTTP_REQUESTS = 17;
    public static final int READ_TIMEOUT = 10000;
    private boolean isSslPinningEnabled;
    private final String logTag;
    private final Logger logger;

    /* JADX INFO: renamed from: socketFactory$delegate, reason: from kotlin metadata */
    private final Lazy socketFactory;

    /* JADX INFO: renamed from: sslContext$delegate, reason: from kotlin metadata */
    private final Lazy sslContext;

    public UrlConnectionHttpClient(boolean z, Logger logger, String logTag) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.isSslPinningEnabled = z;
        this.logger = logger;
        this.logTag = logTag;
        this.socketFactory = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.network.http.UrlConnectionHttpClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UrlConnectionHttpClient.socketFactory_delegate$lambda$0(this.f$0);
            }
        });
        this.sslContext = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.network.http.UrlConnectionHttpClient$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UrlConnectionHttpClient.sslContext_delegate$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: isSslPinningEnabled, reason: from getter */
    public final boolean getIsSslPinningEnabled() {
        return this.isSslPinningEnabled;
    }

    public final void setSslPinningEnabled(boolean z) {
        this.isSslPinningEnabled = z;
    }

    private final SSLSocketFactory getSocketFactory() {
        return (SSLSocketFactory) this.socketFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SSLSocketFactory socketFactory_delegate$lambda$0(UrlConnectionHttpClient this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Logger.d("Pinning SSL session to DigiCertGlobalRoot CA certificate");
            SSLContext sslContext = this$0.getSslContext();
            if (sslContext != null) {
                return sslContext.getSocketFactory();
            }
            return null;
        } catch (Exception e2) {
            Logger.d("Issue in pinning SSL,", e2);
            return null;
        }
    }

    private final SSLContext getSslContext() {
        return (SSLContext) this.sslContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SSLContext sslContext_delegate$lambda$1(UrlConnectionHttpClient this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.createSslContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, javax.net.ssl.HttpsURLConnection] */
    @Override // com.clevertap.android.sdk.network.http.CtHttpClient
    public Response execute(Request request) {
        Response response;
        Intrinsics.checkNotNullParameter(request, "request");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            try {
                TrafficStats.setThreadStatsTag(17);
                objectRef.element = openHttpsURLConnection(request);
                this.logger.debug(this.logTag, "Sending request to: " + request.getUrl());
                int responseCode = ((HttpsURLConnection) objectRef.element).getResponseCode();
                Map headerFields = ((HttpsURLConnection) objectRef.element).getHeaderFields();
                Function0 function0 = new Function0() { // from class: com.clevertap.android.sdk.network.http.UrlConnectionHttpClient$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UrlConnectionHttpClient.execute$lambda$2(objectRef);
                    }
                };
                if (responseCode == 200) {
                    Intrinsics.checkNotNull(headerFields);
                    response = new Response(request, responseCode, headerFields, ((HttpsURLConnection) objectRef.element).getInputStream(), function0);
                } else {
                    Intrinsics.checkNotNull(headerFields);
                    response = new Response(request, responseCode, headerFields, ((HttpsURLConnection) objectRef.element).getErrorStream(), function0);
                }
                TrafficStats.clearThreadStatsTag();
                return response;
            } catch (Exception e2) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) objectRef.element;
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                    throw e2;
                }
                throw e2;
            }
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit execute$lambda$2(Ref.ObjectRef connection) {
        Intrinsics.checkNotNullParameter(connection, "$connection");
        ((HttpsURLConnection) connection.element).disconnect();
        return Unit.INSTANCE;
    }

    private final HttpsURLConnection openHttpsURLConnection(Request request) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(request.getUrl().toString()).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpsURLConnection.setInstanceFollowRedirects(false);
        if (this.isSslPinningEnabled && getSslContext() != null) {
            httpsURLConnection.setSSLSocketFactory(getSocketFactory());
        }
        if (request.getBody() == null) {
            return httpsURLConnection;
        }
        httpsURLConnection.setDoOutput(true);
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        try {
            byte[] bytes = request.getBody().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            return httpsURLConnection;
        } finally {
        }
    }

    private final SSLContext createSslContext() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            ClassLoader classLoader = keyStore.getClass().getClassLoader();
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new BufferedInputStream(classLoader != null ? classLoader.getResourceAsStream("com/clevertap/android/sdk/certificates/AmazonRootCA1.cer") : null));
            Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            keyStore.setCertificateEntry("AmazonRootCA1", (X509Certificate) certificateGenerateCertificate);
            trustManagerFactory.init(keyStore);
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            Logger.d("SSL Context built");
            return sSLContext;
        } catch (Exception e2) {
            Logger.i("Error building SSL Context", e2);
            return null;
        }
    }
}
