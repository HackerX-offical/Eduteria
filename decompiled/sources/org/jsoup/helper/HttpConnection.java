package org.jsoup.helper;

import com.google.firebase.analytics.FirebaseAnalytics;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Typography;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jsoup.Connection;
import org.jsoup.UncheckedIOException;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

/* JADX INFO: loaded from: classes10.dex */
public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
    private static final String DefaultUploadType = "application/octet-stream";
    public static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    private static final int HTTP_TEMP_REDIR = 307;
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String USER_AGENT = "User-Agent";
    private Request req;

    @Nullable
    private Connection.Response res;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    public HttpConnection() {
        this.req = new Request();
    }

    HttpConnection(Request request) {
        this.req = new Request(request);
    }

    private static String encodeUrl(String str) {
        try {
            return encodeUrl(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    static URL encodeUrl(URL url) {
        URL urlPunyUrl = punyUrl(url);
        try {
            return new URL(new URI(urlPunyUrl.toExternalForm().replace(" ", "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return urlPunyUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URL punyUrl(URL url) {
        if (StringUtil.isAscii(url.getHost())) {
            return url;
        }
        try {
            return new URL(url.getProtocol(), IDN.toASCII(url.getHost()), url.getPort(), url.getFile());
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encodeMimeName(String str) {
        return str.replace("\"", "%22");
    }

    @Override // org.jsoup.Connection
    public Connection newRequest() {
        return new HttpConnection(this.req);
    }

    private HttpConnection(Request request, Response response) {
        this.req = request;
        this.res = response;
    }

    @Override // org.jsoup.Connection
    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(String str) {
        Validate.notEmptyParam(str, "url");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(String.format("The supplied URL, '%s', is malformed. Make sure it is an absolute URL, and starts with 'http://' or 'https://'. See https://jsoup.org/cookbook/extracting-data/working-with-urls", str), e2);
        }
    }

    @Override // org.jsoup.Connection
    public Connection proxy(@Nullable Proxy proxy) {
        this.req.proxy(proxy);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(String str, int i) {
        this.req.proxy(str, i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection userAgent(String str) {
        Validate.notNullParam(str, "userAgent");
        this.req.header("User-Agent", str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection timeout(int i) {
        this.req.timeout(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection maxBodySize(int i) {
        this.req.maxBodySize(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection referrer(String str) {
        Validate.notNullParam(str, "referrer");
        this.req.header("Referer", str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2) {
        this.req.data((Connection.KeyVal) KeyVal.create(str, str2));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.req.sslSocketFactory(sSLSocketFactory);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.data((Connection.KeyVal) KeyVal.create(str, str2, inputStream));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream, String str3) {
        this.req.data(KeyVal.create(str, str2, inputStream).contentType(str3));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Map<String, String> map) {
        Validate.notNullParam(map, "data");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.data((Connection.KeyVal) KeyVal.create(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String... strArr) {
        Validate.notNullParam(strArr, "keyvals");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.data((Connection.KeyVal) KeyVal.create(str, str2));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNullParam(collection, "data");
        Iterator<Connection.KeyVal> it = collection.iterator();
        while (it.hasNext()) {
            this.req.data(it.next());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.KeyVal data(String str) {
        Validate.notEmptyParam(str, "key");
        for (Connection.KeyVal keyVal : request().data()) {
            if (keyVal.key().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }

    @Override // org.jsoup.Connection
    public Connection requestBody(String str) {
        this.req.requestBody(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection headers(Map<String, String> map) {
        Validate.notNullParam(map, HeadersExtension.ELEMENT);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.header(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookies(Map<String, String> map) {
        Validate.notNullParam(map, "cookies");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.cookie(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookieStore(CookieStore cookieStore) {
        this.req.cookieManager = new CookieManager(cookieStore, null);
        return this;
    }

    @Override // org.jsoup.Connection
    public CookieStore cookieStore() {
        return this.req.cookieManager.getCookieStore();
    }

    @Override // org.jsoup.Connection
    public Connection parser(Parser parser) {
        this.req.parser(parser);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        Validate.notNull(this.res);
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        Validate.notNull(this.res);
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Connection.Response execute() throws IOException {
        Response responseExecute = Response.execute(this.req);
        this.res = responseExecute;
        return responseExecute;
    }

    @Override // org.jsoup.Connection
    public Connection.Request request() {
        return this.req;
    }

    @Override // org.jsoup.Connection
    public Connection request(Connection.Request request) {
        this.req = (Request) request;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response response() {
        Connection.Response response = this.res;
        if (response != null) {
            return response;
        }
        throw new IllegalArgumentException("You must execute the request before getting a response.");
    }

    @Override // org.jsoup.Connection
    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class Base<T extends Connection.Base<T>> implements Connection.Base<T> {
        private static final URL UnsetUrl;
        Map<String, String> cookies;
        Map<String, List<String>> headers;
        Connection.Method method;
        URL url;

        static {
            try {
                UnsetUrl = new URL("http://undefined/");
            } catch (MalformedURLException e2) {
                throw new IllegalStateException(e2);
            }
        }

        private Base() {
            this.url = UnsetUrl;
            this.method = Connection.Method.GET;
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        private Base(Base<T> base) {
            this.url = UnsetUrl;
            this.method = Connection.Method.GET;
            this.url = base.url;
            this.method = base.method;
            this.headers = new LinkedHashMap();
            for (Map.Entry<String, List<String>> entry : base.headers.entrySet()) {
                this.headers.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.cookies = linkedHashMap;
            linkedHashMap.putAll(base.cookies);
        }

        @Override // org.jsoup.Connection.Base
        public URL url() {
            URL url = this.url;
            if (url != UnsetUrl) {
                return url;
            }
            throw new IllegalArgumentException("URL not set. Make sure to call #url(...) before executing the request.");
        }

        @Override // org.jsoup.Connection.Base
        public T url(URL url) {
            Validate.notNullParam(url, "url");
            this.url = HttpConnection.punyUrl(url);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Connection.Method method() {
            return this.method;
        }

        @Override // org.jsoup.Connection.Base
        public T method(Connection.Method method) {
            Validate.notNullParam(method, FirebaseAnalytics.Param.METHOD);
            this.method = method;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public String header(String str) {
            Validate.notNullParam(str, "name");
            List<String> headersCaseInsensitive = getHeadersCaseInsensitive(str);
            if (headersCaseInsensitive.size() > 0) {
                return StringUtil.join(headersCaseInsensitive, ", ");
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public T addHeader(String str, String str2) {
            Validate.notEmptyParam(str, "name");
            if (str2 == null) {
                str2 = "";
            }
            List<String> listHeaders = headers(str);
            if (listHeaders.isEmpty()) {
                listHeaders = new ArrayList<>();
                this.headers.put(str, listHeaders);
            }
            listHeaders.add(fixHeaderEncoding(str2));
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public List<String> headers(String str) {
            Validate.notEmptyParam(str, "name");
            return getHeadersCaseInsensitive(str);
        }

        private static String fixHeaderEncoding(String str) {
            byte[] bytes = str.getBytes(HttpConnection.ISO_8859_1);
            return !looksLikeUtf8(bytes) ? str : new String(bytes, HttpConnection.UTF_8);
        }

        private static boolean looksLikeUtf8(byte[] bArr) {
            int i;
            int i2 = (bArr.length >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) ? 3 : 0;
            int length = bArr.length;
            while (i2 < length) {
                byte b2 = bArr[i2];
                if ((b2 & 128) != 0) {
                    if ((b2 & 224) == 192) {
                        i = i2 + 1;
                    } else if ((b2 & 240) == 224) {
                        i = i2 + 2;
                    } else {
                        if ((b2 & 248) != 240) {
                            return false;
                        }
                        i = i2 + 3;
                    }
                    if (i >= bArr.length) {
                        return false;
                    }
                    while (i2 < i) {
                        i2++;
                        if ((bArr[i2] & 192) != 128) {
                            return false;
                        }
                    }
                }
                i2++;
            }
            return true;
        }

        @Override // org.jsoup.Connection.Base
        public T header(String str, String str2) {
            Validate.notEmptyParam(str, "name");
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeader(String str) {
            Validate.notEmptyParam(str, "name");
            return !getHeadersCaseInsensitive(str).isEmpty();
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeaderWithValue(String str, String str2) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            Iterator<String> it = headers(str).iterator();
            while (it.hasNext()) {
                if (str2.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.jsoup.Connection.Base
        public T removeHeader(String str) {
            Validate.notEmptyParam(str, "name");
            Map.Entry<String, List<String>> entryScanHeaders = scanHeaders(str);
            if (entryScanHeaders != null) {
                this.headers.remove(entryScanHeaders.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> headers() {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.headers.size());
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value.size() > 0) {
                    linkedHashMap.put(key, value.get(0));
                }
            }
            return linkedHashMap;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, List<String>> multiHeaders() {
            return this.headers;
        }

        private List<String> getHeadersCaseInsensitive(String str) {
            Validate.notNull(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        @Nullable
        private Map.Entry<String, List<String>> scanHeaders(String str) {
            String strLowerCase = Normalizer.lowerCase(str);
            for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
                if (Normalizer.lowerCase(entry.getKey()).equals(strLowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public String cookie(String str) {
            Validate.notEmptyParam(str, "name");
            return this.cookies.get(str);
        }

        @Override // org.jsoup.Connection.Base
        public T cookie(String str, String str2) {
            Validate.notEmptyParam(str, "name");
            Validate.notNullParam(str2, "value");
            this.cookies.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasCookie(String str) {
            Validate.notEmptyParam(str, "name");
            return this.cookies.containsKey(str);
        }

        @Override // org.jsoup.Connection.Base
        public T removeCookie(String str) {
            Validate.notEmptyParam(str, "name");
            this.cookies.remove(str);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> cookies() {
            return this.cookies;
        }
    }

    public static class Request extends Base<Connection.Request> implements Connection.Request {

        @Nullable
        private String body;
        private CookieManager cookieManager;
        private final Collection<Connection.KeyVal> data;
        private volatile boolean executing;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        private boolean parserDefined;
        private String postDataCharset;

        @Nullable
        private Proxy proxy;

        @Nullable
        private SSLSocketFactory sslSocketFactory;
        private int timeoutMilliseconds;

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base addHeader(String str, String str2) {
            return super.addHeader(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base cookie(String str, String str2) {
            return super.cookie(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base header(String str, String str2) {
            return super.header(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base method(Connection.Method method) {
            return super.method(method);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base removeCookie(String str) {
            return super.removeCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base removeHeader(String str) {
            return super.removeHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base url(URL url) {
            return super.url(url);
        }

        static {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        }

        Request() {
            super();
            this.body = null;
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.postDataCharset = DataUtil.defaultCharsetName;
            this.executing = false;
            this.timeoutMilliseconds = 30000;
            this.maxBodySizeBytes = 2097152;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Connection.Method.GET;
            addHeader("Accept-Encoding", "gzip");
            addHeader("User-Agent", HttpConnection.DEFAULT_UA);
            this.parser = Parser.htmlParser();
            this.cookieManager = new CookieManager();
        }

        Request(Request request) {
            super(request);
            this.body = null;
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.postDataCharset = DataUtil.defaultCharsetName;
            this.executing = false;
            this.proxy = request.proxy;
            this.postDataCharset = request.postDataCharset;
            this.timeoutMilliseconds = request.timeoutMilliseconds;
            this.maxBodySizeBytes = request.maxBodySizeBytes;
            this.followRedirects = request.followRedirects;
            ArrayList arrayList = new ArrayList();
            this.data = arrayList;
            arrayList.addAll(request.data());
            this.body = request.body;
            this.ignoreHttpErrors = request.ignoreHttpErrors;
            this.ignoreContentType = request.ignoreContentType;
            this.parser = request.parser.newInstance();
            this.parserDefined = request.parserDefined;
            this.sslSocketFactory = request.sslSocketFactory;
            this.cookieManager = request.cookieManager;
            this.executing = false;
        }

        @Override // org.jsoup.Connection.Request
        public Proxy proxy() {
            return this.proxy;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(@Nullable Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(String str, int i) {
            this.proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public int timeout() {
            return this.timeoutMilliseconds;
        }

        @Override // org.jsoup.Connection.Request
        public Request timeout(int i) {
            Validate.isTrue(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request maxBodySize(int i) {
            Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean followRedirects() {
            return this.followRedirects;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        @Override // org.jsoup.Connection.Request
        public SSLSocketFactory sslSocketFactory() {
            return this.sslSocketFactory;
        }

        @Override // org.jsoup.Connection.Request
        public void sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Request data(Connection.KeyVal keyVal) {
            Validate.notNullParam(keyVal, "keyval");
            this.data.add(keyVal);
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Collection<Connection.KeyVal> data() {
            return this.data;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request requestBody(@Nullable String str) {
            this.body = str;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public String requestBody() {
            return this.body;
        }

        @Override // org.jsoup.Connection.Request
        public Request parser(Parser parser) {
            this.parser = parser;
            this.parserDefined = true;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Parser parser() {
            return this.parser;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request postDataCharset(String str) {
            Validate.notNullParam(str, "charset");
            if (!Charset.isSupported(str)) {
                throw new IllegalCharsetNameException(str);
            }
            this.postDataCharset = str;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public String postDataCharset() {
            return this.postDataCharset;
        }

        CookieManager cookieManager() {
            return this.cookieManager;
        }
    }

    public static class Response extends Base<Connection.Response> implements Connection.Response {
        private static final String LOCATION = "Location";
        private static final int MAX_REDIRECTS = 20;
        private static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        @Nullable
        private InputStream bodyStream;

        @Nullable
        private ByteBuffer byteData;

        @Nullable
        private String charset;

        @Nullable
        private HttpURLConnection conn;

        @Nullable
        private final String contentType;
        private boolean executed;
        private boolean inputStreamRead;
        private int numRedirects;
        private final Request req;
        private final int statusCode;
        private final String statusMessage;

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base addHeader(String str, String str2) {
            return super.addHeader(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base cookie(String str, String str2) {
            return super.cookie(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base header(String str, String str2) {
            return super.header(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base method(Connection.Method method) {
            return super.method(method);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base removeCookie(String str) {
            return super.removeCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base removeHeader(String str) {
            return super.removeHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Base url(URL url) {
            return super.url(url);
        }

        Response() {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
            this.statusCode = HttpStatus.SC_BAD_REQUEST;
            this.statusMessage = "Request not made";
            this.req = new Request();
            this.contentType = null;
        }

        static Response execute(Request request) throws IOException {
            return execute(request, null);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:(13:(10:(1:24)|26|115|112|27|(4:29|117|30|31)|40|116|41|(2:56|(2:97|98)(7:62|(2:71|72)|(1:78)|79|(1:94)(5:83|(1:85)(1:86)|87|(1:89)(2:90|(1:92))|93)|95|96))(7:45|(1:47)|48|(1:52)|53|54|55))(1:22)|116|41|(1:43)|56|(4:58|60|97|98)(3:60|97|98)|62|(5:64|66|68|71|72)|(3:74|76|78)|79|(2:81|94)(0)|95|96)|115|112|27|(0)|40) */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x01f7, code lost:
        
            r9 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[Catch: all -> 0x01f5, IOException -> 0x01f7, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f7, blocks: (B:27:0x0087, B:29:0x0090, B:31:0x0097, B:38:0x00a2, B:39:0x00a5, B:40:0x00a6), top: B:112:0x0087 }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01d6 A[Catch: IOException -> 0x01f2, all -> 0x01f5, TRY_LEAVE, TryCatch #2 {all -> 0x01f5, blocks: (B:27:0x0087, B:29:0x0090, B:31:0x0097, B:38:0x00a2, B:39:0x00a5, B:40:0x00a6, B:41:0x00af, B:43:0x00b7, B:47:0x00c1, B:48:0x00d5, B:50:0x00e6, B:52:0x00ef, B:53:0x00f3, B:62:0x011b, B:64:0x0121, B:66:0x0127, B:68:0x012f, B:71:0x013c, B:72:0x014b, B:74:0x014e, B:76:0x015a, B:78:0x0160, B:79:0x0167, B:81:0x0175, B:83:0x017d, B:85:0x0183, B:87:0x018c, B:89:0x019b, B:93:0x01bd, B:90:0x01a5, B:92:0x01af, B:86:0x0188, B:94:0x01d6, B:60:0x0115, B:97:0x01e2, B:98:0x01f1, B:105:0x01fa, B:106:0x01fd), top: B:115:0x0087 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static org.jsoup.helper.HttpConnection.Response execute(org.jsoup.helper.HttpConnection.Request r8, @javax.annotation.Nullable org.jsoup.helper.HttpConnection.Response r9) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 517
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.execute(org.jsoup.helper.HttpConnection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        @Override // org.jsoup.Connection.Response
        public int statusCode() {
            return this.statusCode;
        }

        @Override // org.jsoup.Connection.Response
        public String statusMessage() {
            return this.statusMessage;
        }

        @Override // org.jsoup.Connection.Response
        public String charset() {
            return this.charset;
        }

        @Override // org.jsoup.Connection.Response
        public Response charset(String str) {
            this.charset = str;
            return this;
        }

        @Override // org.jsoup.Connection.Response
        public String contentType() {
            return this.contentType;
        }

        @Override // org.jsoup.Connection.Response
        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.byteData != null) {
                this.bodyStream = new ByteArrayInputStream(this.byteData.array());
                this.inputStreamRead = false;
            }
            Validate.isFalse(this.inputStreamRead, "Input stream already read and parsed, cannot re-read.");
            Document inputStream = DataUtil.parseInputStream(this.bodyStream, this.charset, this.url.toExternalForm(), this.req.parser());
            inputStream.connection(new HttpConnection(this.req, this));
            this.charset = inputStream.outputSettings().charset().name();
            this.inputStreamRead = true;
            safeClose();
            return inputStream;
        }

        private void prepareByteData() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            if (this.bodyStream == null || this.byteData != null) {
                return;
            }
            Validate.isFalse(this.inputStreamRead, "Request has already been read (with .parse())");
            try {
                try {
                    this.byteData = DataUtil.readToByteBuffer(this.bodyStream, this.req.maxBodySize());
                } catch (IOException e2) {
                    throw new UncheckedIOException(e2);
                }
            } finally {
                this.inputStreamRead = true;
                safeClose();
            }
        }

        @Override // org.jsoup.Connection.Response
        public String body() {
            prepareByteData();
            Validate.notNull(this.byteData);
            String str = this.charset;
            String string = (str == null ? DataUtil.UTF_8 : Charset.forName(str)).decode(this.byteData).toString();
            this.byteData.rewind();
            return string;
        }

        @Override // org.jsoup.Connection.Response
        public byte[] bodyAsBytes() {
            prepareByteData();
            Validate.notNull(this.byteData);
            return this.byteData.array();
        }

        @Override // org.jsoup.Connection.Response
        public Connection.Response bufferUp() {
            prepareByteData();
            return this;
        }

        @Override // org.jsoup.Connection.Response
        public BufferedInputStream bodyStream() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            Validate.isFalse(this.inputStreamRead, "Request has already been read");
            this.inputStreamRead = true;
            return ConstrainableInputStream.wrap(this.bodyStream, 32768, this.req.maxBodySize());
        }

        private static HttpURLConnection createConnection(Request request) throws IOException {
            URLConnection uRLConnectionOpenConnection;
            Proxy proxy = request.proxy();
            if (proxy == null) {
                uRLConnectionOpenConnection = request.url().openConnection();
            } else {
                uRLConnectionOpenConnection = request.url().openConnection(proxy);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout() / 2);
            if (request.sslSocketFactory() != null && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(request.sslSocketFactory());
            }
            if (request.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            CookieUtil.applyCookiesToRequest(request, httpURLConnection);
            for (Map.Entry entry : request.multiHeaders().entrySet()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) it.next());
                }
            }
            return httpURLConnection;
        }

        private void safeClose() {
            InputStream inputStream = this.bodyStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.bodyStream = null;
                    throw th;
                }
                this.bodyStream = null;
            }
            HttpURLConnection httpURLConnection = this.conn;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.conn = null;
            }
        }

        private Response(HttpURLConnection httpURLConnection, Request request, @Nullable Response response) throws IOException {
            super();
            this.executed = false;
            this.inputStreamRead = false;
            this.numRedirects = 0;
            this.conn = httpURLConnection;
            this.req = request;
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            LinkedHashMap<String, List<String>> linkedHashMapCreateHeaderMap = createHeaderMap(httpURLConnection);
            processResponseHeaders(linkedHashMapCreateHeaderMap);
            CookieUtil.storeCookies(request, this.url, linkedHashMapCreateHeaderMap);
            if (response != null) {
                for (Map.Entry entry : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry.getKey())) {
                        cookie((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                response.safeClose();
                int i = response.numRedirects + 1;
                this.numRedirects = i;
                if (i >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", response.url()));
                }
            }
        }

        private static LinkedHashMap<String, List<String>> createHeaderMap(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        void processResponseHeaders(Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    List<String> value = entry.getValue();
                    if (key.equalsIgnoreCase("Set-Cookie")) {
                        for (String str : value) {
                            if (str != null) {
                                TokenQueue tokenQueue = new TokenQueue(str);
                                String strTrim = tokenQueue.chompTo("=").trim();
                                String strTrim2 = tokenQueue.consumeTo(";").trim();
                                if (strTrim.length() > 0 && !this.cookies.containsKey(strTrim)) {
                                    cookie(strTrim, strTrim2);
                                }
                            }
                        }
                    }
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        addHeader(key, it.next());
                    }
                }
            }
        }

        @Nullable
        private static String setOutputContentType(Connection.Request request) {
            String strHeader = request.header("Content-Type");
            if (strHeader == null) {
                if (!HttpConnection.needsMultipart(request)) {
                    request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + request.postDataCharset());
                    return null;
                }
                String strMimeBoundary = DataUtil.mimeBoundary();
                request.header("Content-Type", "multipart/form-data; boundary=" + strMimeBoundary);
                return strMimeBoundary;
            }
            if (!strHeader.contains(HttpConnection.MULTIPART_FORM_DATA) || strHeader.contains("boundary")) {
                return null;
            }
            String strMimeBoundary2 = DataUtil.mimeBoundary();
            request.header("Content-Type", "multipart/form-data; boundary=" + strMimeBoundary2);
            return strMimeBoundary2;
        }

        private static void writePost(Connection.Request request, OutputStream outputStream, @Nullable String str) throws IOException {
            Collection<Connection.KeyVal> collectionData = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName(request.postDataCharset())));
            if (str != null) {
                for (Connection.KeyVal keyVal : collectionData) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.key()));
                    bufferedWriter.write("\"");
                    InputStream inputStream = keyVal.inputStream();
                    if (inputStream != null) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.value()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        String strContentType = keyVal.contentType();
                        if (strContentType == null) {
                            strContentType = "application/octet-stream";
                        }
                        bufferedWriter.write(strContentType);
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(inputStream, outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else {
                String strRequestBody = request.requestBody();
                if (strRequestBody != null) {
                    bufferedWriter.write(strRequestBody);
                } else {
                    boolean z = true;
                    for (Connection.KeyVal keyVal2 : collectionData) {
                        if (z) {
                            z = false;
                        } else {
                            bufferedWriter.append(Typography.amp);
                        }
                        bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                        bufferedWriter.write(61);
                        bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                    }
                }
            }
            bufferedWriter.close();
        }

        private static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
            sbBorrowBuilder.append(url.getProtocol()).append("://").append(url.getAuthority()).append(url.getPath()).append("?");
            if (url.getQuery() != null) {
                sbBorrowBuilder.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal keyVal : request.data()) {
                Validate.isFalse(keyVal.hasInputStream(), "InputStream data not supported in URL query string.");
                if (z) {
                    z = false;
                } else {
                    sbBorrowBuilder.append(Typography.amp);
                }
                sbBorrowBuilder.append(URLEncoder.encode(keyVal.key(), DataUtil.defaultCharsetName)).append('=').append(URLEncoder.encode(keyVal.value(), DataUtil.defaultCharsetName));
            }
            request.url(new URL(StringUtil.releaseBuilder(sbBorrowBuilder)));
            request.data().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needsMultipart(Connection.Request request) {
        Iterator<Connection.KeyVal> it = request.data().iterator();
        while (it.hasNext()) {
            if (it.next().hasInputStream()) {
                return true;
            }
        }
        return false;
    }

    public static class KeyVal implements Connection.KeyVal {

        @Nullable
        private String contentType;
        private String key;

        @Nullable
        private InputStream stream;
        private String value;

        public static KeyVal create(String str, String str2) {
            return new KeyVal(str, str2);
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal(str, str2).inputStream(inputStream);
        }

        private KeyVal(String str, String str2) {
            Validate.notEmptyParam(str, "key");
            Validate.notNullParam(str2, "value");
            this.key = str;
            this.value = str2;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal key(String str) {
            Validate.notEmptyParam(str, "key");
            this.key = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String key() {
            return this.key;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal value(String str) {
            Validate.notNullParam(str, "value");
            this.value = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String value() {
            return this.value;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNullParam(this.value, "inputStream");
            this.stream = inputStream;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public InputStream inputStream() {
            return this.stream;
        }

        @Override // org.jsoup.Connection.KeyVal
        public boolean hasInputStream() {
            return this.stream != null;
        }

        @Override // org.jsoup.Connection.KeyVal
        public Connection.KeyVal contentType(String str) {
            Validate.notEmpty(str);
            this.contentType = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String contentType() {
            return this.contentType;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}
