package com.billdesk.utils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes6.dex */
public class ConnectionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f477a = true;

    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean z;
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            String str2 = "Connection Session : " + sSLSession.getPeerHost();
            if (defaultHostnameVerifier.verify(str, sSLSession)) {
                Log.e("ConnectionUtil", "Connection Session Inside Verify...");
                z = true;
            } else {
                Log.e("ConnectionUtil", "Connection Session Inside Else...");
                z = false;
            }
            ConnectionUtil.f477a = z;
            return z;
        }
    }

    public static class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v15, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static HttpURLConnection a(Context context, String str) throws IOException {
        ?? r1;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                if (str.startsWith(TournamentShareDialogURIBuilder.scheme)) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(new KeyManager[0], new TrustManager[]{new b()}, new SecureRandom());
                    SSLContext.setDefault(sSLContext);
                    r1 = (HttpsURLConnection) new URL(str).openConnection();
                    try {
                        r1.setHostnameVerifier(new a());
                        r1 = r1;
                        if (!f477a) {
                            r1 = 0;
                        }
                    } catch (KeyManagementException e2) {
                        e = e2;
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                } else {
                    r1 = 0;
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                }
            } catch (MalformedURLException e4) {
                throw e4;
            } catch (IOException e5) {
                throw e5;
            }
        } catch (KeyManagementException e6) {
            e = e6;
            r1 = httpURLConnection;
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            r1 = httpURLConnection;
        }
        return str.startsWith(TournamentShareDialogURIBuilder.scheme) ? r1 : httpURLConnection;
    }

    public static void a(Context context, String str, Exception exc) {
        Handler handler;
        Runnable bVar;
        if (str.contains("?")) {
            String str2 = "connection issue :" + str.split("\\?")[0] + ", err msg:" + exc.getMessage();
            System.err.println("With ?" + str2);
            handler = new Handler(context.getMainLooper());
            bVar = new a.a.d.a(context, str2);
        } else {
            String str3 = "connection issue :" + str + ", err msg:" + exc.getMessage();
            System.err.println("Without ?" + str3);
            handler = new Handler(context.getMainLooper());
            bVar = new a.a.d.b(context, str3);
        }
        handler.post(bVar);
    }
}
