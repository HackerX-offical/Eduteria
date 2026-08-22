package fr.maxcom.http;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.webkit.JavascriptInterface;
import androidx.documentfile.provider.DocumentFile;
import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.impl.DefaultBHttpServerConnection;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpProcessorBuilder;
import cz.msebera.android.httpclient.protocol.HttpRequestHandler;
import cz.msebera.android.httpclient.protocol.HttpService;
import cz.msebera.android.httpclient.protocol.ResponseContent;
import cz.msebera.android.httpclient.protocol.UriHttpRequestHandlerMapper;
import fr.maxcom.http.Diagnostic;
import fr.maxcom.http.HttpServer;
import fr.maxcom.libmedia.Licensing;
import fr.maxcom.util.Log;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
abstract class a implements HttpServer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DefaultBHttpServerConnection f1281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HttpService f78a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private DataSource f79a = new FileDataSource();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final b f80a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f81a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ServerSocket f82a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f83a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1283c;

    /* JADX INFO: renamed from: fr.maxcom.http.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0207a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1285b;

        static {
            int[] iArr = new int[Diagnostic.Code.values().length];
            f1285b = iArr;
            try {
                iArr[Diagnostic.Code.PROXY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[e.values().length];
            f1284a = iArr2;
            try {
                iArr2[e.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1284a[e.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class b implements HttpRequestHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AbstractHttpEntity f1286a;

        private b() {
        }

        void a() throws IOException {
            AbstractHttpEntity abstractHttpEntity = this.f1286a;
            if (abstractHttpEntity != null) {
                abstractHttpEntity.getContent().close();
                this.f1286a = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
        @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handle(cz.msebera.android.httpclient.HttpRequest r7, cz.msebera.android.httpclient.HttpResponse r8, cz.msebera.android.httpclient.protocol.HttpContext r9) throws java.io.IOException, cz.msebera.android.httpclient.HttpException {
            /*
                Method dump skipped, instruction units count: 547
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.maxcom.http.a.b.handle(cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.HttpResponse, cz.msebera.android.httpclient.protocol.HttpContext):void");
        }

        /* synthetic */ b(a aVar, C0207a c0207a) {
            this();
        }
    }

    private class c implements Runnable {
        private c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 379
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.maxcom.http.a.c.run():void");
        }

        /* synthetic */ c(a aVar, C0207a c0207a) {
            this();
        }
    }

    private class d implements HttpServer.JsInterface {
        private d() {
        }

        @Override // fr.maxcom.http.HttpServer.JsInterface
        @JavascriptInterface
        public String getURL(String str) {
            return a.this.getURL(str);
        }

        /* synthetic */ d(a aVar, C0207a c0207a) {
            this();
        }

        @Override // fr.maxcom.http.HttpServer.JsInterface
        @JavascriptInterface
        public String getURL(String str, String str2) {
            return a.this.getURL(str, str2);
        }

        @Override // fr.maxcom.http.HttpServer.JsInterface
        @JavascriptInterface
        public String getURL(int i, int i2, String str) {
            return a.this.getURL(i, i2, str);
        }
    }

    enum e {
        LOCAL,
        WIFI
    }

    a(e eVar) throws IOException {
        InetAddress byAddress;
        Context context;
        int ipAddress;
        int i = C0207a.f1284a[eVar.ordinal()];
        C0207a c0207a = null;
        if (i == 1) {
            byAddress = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        } else if (i != 2 || (context = fr.maxcom.libmedia.a.f1292a) == null || (ipAddress = ((WifiManager) context.getSystemService(Constants.CLTAP_CONNECTED_TO_WIFI)).getConnectionInfo().getIpAddress()) == 0) {
            byAddress = null;
        } else {
            byAddress = InetAddress.getByAddress(BigInteger.valueOf(ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? Integer.reverseBytes(ipAddress) : ipAddress).toByteArray());
        }
        if (byAddress == null) {
            throw new UnknownHostException("Unable to get host address");
        }
        this.f82a = new ServerSocket(0, 1, byAddress);
        try {
            HttpProcessor httpProcessorBuild = HttpProcessorBuilder.create().add(new ResponseContent()).build();
            b bVar = new b(this, c0207a);
            this.f80a = bVar;
            UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper = new UriHttpRequestHandlerMapper();
            uriHttpRequestHandlerMapper.register("*", bVar);
            this.f78a = new HttpService(httpProcessorBuild, uriHttpRequestHandlerMapper);
            try {
                Class.forName("com.android.vending.expansion.zipfile.ZipResourceFile");
                this.f83a = true;
            } catch (ClassNotFoundException unused) {
                this.f83a = false;
            }
            try {
                Class.forName("jcifs.smb.SmbFile");
                this.f1282b = true;
            } catch (ClassNotFoundException unused2) {
                this.f1282b = false;
            }
            if (Licensing.getDeveloperMode()) {
                List<Diagnostic> listDiagnose = Diagnostic.diagnose();
                if (!listDiagnose.isEmpty()) {
                    for (Diagnostic diagnostic : listDiagnose) {
                        Log.w("SingleHttpServer", "Diagnostic: " + (C0207a.f1285b[diagnostic.code.ordinal()] != 1 ? "<unspecified>" : "A proxy is set. It may route all local traffic to outside.") + " (" + diagnostic.code + ")");
                    }
                }
            }
            fr.maxcom.libmedia.a.m12381a();
        } catch (NoClassDefFoundError e2) {
            if (!e2.getMessage().contains("HttpProcessorBuilder")) {
                throw e2;
            }
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError("Missing the HttpClient Library. Read the Integration Guidelines.");
            StackTraceElement[] stackTrace = e2.getStackTrace();
            noClassDefFoundError.setStackTrace(stackTrace.length > 2 ? new StackTraceElement[]{stackTrace[0], stackTrace[1], stackTrace[2]} : stackTrace);
            throw noClassDefFoundError;
        }
    }

    private boolean b() {
        if (this.f83a) {
            return true;
        }
        Log.e("SingleHttpServer", "Missing the Google Play APK Expansion Library. Get it with the SDK Manager");
        return false;
    }

    boolean a(InetAddress inetAddress) {
        return true;
    }

    @Override // fr.maxcom.http.HttpServer
    public HttpServer.JsInterface getJsInterfaceObject() {
        return new d(this, null);
    }

    @Override // fr.maxcom.http.HttpServer
    public String getURL(String str) {
        if (!str.startsWith("smb://")) {
            if (str.startsWith("asset://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://")) {
            }
            return a(str, (List<NameValuePair>) null);
        }
        if (!a()) {
            return null;
        }
        str = MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
        return a(str, (List<NameValuePair>) null);
    }

    @Override // fr.maxcom.http.HttpServer
    public HttpServer setCipher(Cipher cipher) {
        this.f79a.setCipher(cipher);
        if (cipher != null) {
            String upperCase = cipher.getAlgorithm().toUpperCase();
            if ("AndroidOpenSSL".equalsIgnoreCase(cipher.getProvider().getName()) && upperCase.endsWith("PADDING") && !upperCase.endsWith("/NOPADDING")) {
                Log.w("SingleHttpServer", "With such a combination (Provider, Algorithm, OS Version), you may encounter dysfunctions. Please consider the providing of a CipherFactory instead.");
            }
        }
        return this;
    }

    @Override // fr.maxcom.http.HttpServer
    public HttpServer setCipherFactory(CipherFactory cipherFactory) {
        this.f79a.setCipherFactory(cipherFactory);
        return this;
    }

    @Override // fr.maxcom.http.HttpServer
    public HttpServer setDataSource(DataSource dataSource) {
        if (dataSource != null) {
            this.f79a = dataSource;
        }
        return this;
    }

    @Override // fr.maxcom.http.HttpServer
    public void start() {
        Thread thread = new Thread(new c(this, null));
        this.f81a = thread;
        thread.start();
    }

    @Override // fr.maxcom.http.HttpServer
    public void stop() {
        this.f1283c = false;
        Thread thread = this.f81a;
        if (thread == null) {
            Log.w("SingleHttpServer", "Server is stopped without being started");
            return;
        }
        thread.interrupt();
        if (this.f81a.isAlive()) {
            DefaultBHttpServerConnection defaultBHttpServerConnection = this.f1281a;
            if (defaultBHttpServerConnection != null && defaultBHttpServerConnection.isOpen()) {
                try {
                    this.f1281a.shutdown();
                } catch (IOException e2) {
                    Log.e("SingleHttpServer", "Error while closing the client connection", e2);
                }
                try {
                    this.f81a.join(100L);
                } catch (InterruptedException unused) {
                    Log.w("SingleHttpServer", "Interrupted while waiting for server stopping");
                }
            }
            if (!this.f82a.isClosed()) {
                try {
                    this.f82a.close();
                } catch (IOException e3) {
                    Log.e("SingleHttpServer", "Error while closing the server socket", e3);
                }
            }
        }
        try {
            this.f81a.join(5000L);
        } catch (InterruptedException unused2) {
            Log.w("SingleHttpServer", "Interrupted while waiting for server stopping");
        }
        if (this.f81a.isAlive()) {
            Log.e("SingleHttpServer", "Server still alive");
        }
        this.f81a = null;
    }

    private boolean a() {
        if (this.f1282b) {
            return true;
        }
        Log.e("SingleHttpServer", "Missing the jCIFS Library. Get it at http://jcifs.samba.org");
        return false;
    }

    @Override // fr.maxcom.http.HttpServer
    public String getURL(DocumentFile documentFile) {
        return a(MqttTopic.TOPIC_LEVEL_SEPARATOR + documentFile.getUri().toString(), (List<NameValuePair>) null);
    }

    private String a(String str, List<NameValuePair> list) {
        try {
            return new URI(HttpHost.DEFAULT_SCHEME_NAME, null, this.f82a.getInetAddress().getHostAddress(), this.f82a.getLocalPort(), str, list != null ? URLEncodedUtils.format(list, "UTF-8") : null, null).toASCIIString();
        } catch (URISyntaxException e2) {
            Log.e("SingleHttpServer", "Unsupported URI syntax: " + e2.getMessage());
            return null;
        }
    }

    @Override // fr.maxcom.http.HttpServer
    public String getURL(String str, String str2) {
        if (!b()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("e", str2));
        return a(str, arrayList);
    }

    @Override // fr.maxcom.http.HttpServer
    public String getURL(int i, int i2, String str) {
        if (!b()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("m", String.valueOf(i)));
        arrayList.add(new BasicNameValuePair("p", String.valueOf(i2)));
        arrayList.add(new BasicNameValuePair("e", str));
        return a("/expansion", arrayList);
    }
}
