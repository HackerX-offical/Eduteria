package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

/* JADX INFO: loaded from: classes9.dex */
public class AsynchronousValidationRequest implements Runnable {
    private final HttpCacheEntry cacheEntry;
    private final CachingExec cachingExec;
    private final int consecutiveFailedAttempts;
    private final HttpClientContext context;
    private final HttpExecutionAware execAware;
    private final String identifier;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final AsynchronousValidator parent;
    private final HttpRequestWrapper request;
    private final HttpRoute route;

    private boolean isNotServerError(int i) {
        return i < 500;
    }

    AsynchronousValidationRequest(AsynchronousValidator asynchronousValidator, CachingExec cachingExec, HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry, String str, int i) {
        this.parent = asynchronousValidator;
        this.cachingExec = cachingExec;
        this.route = httpRoute;
        this.request = httpRequestWrapper;
        this.context = httpClientContext;
        this.execAware = httpExecutionAware;
        this.cacheEntry = httpCacheEntry;
        this.identifier = str;
        this.consecutiveFailedAttempts = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (revalidateCacheEntry()) {
                this.parent.jobSuccessful(this.identifier);
            } else {
                this.parent.jobFailed(this.identifier);
            }
        } finally {
            this.parent.markComplete(this.identifier);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean revalidateCacheEntry() {
        /*
            r8 = this;
            r1 = 0
            cz.msebera.android.httpclient.impl.client.cache.CachingExec r2 = r8.cachingExec     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.conn.routing.HttpRoute r3 = r8.route     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.client.methods.HttpRequestWrapper r4 = r8.request     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.client.protocol.HttpClientContext r5 = r8.context     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.client.methods.HttpExecutionAware r6 = r8.execAware     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.client.cache.HttpCacheEntry r7 = r8.cacheEntry     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.client.methods.CloseableHttpResponse r2 = r2.revalidateCacheEntry(r3, r4, r5, r6, r7)     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            cz.msebera.android.httpclient.StatusLine r0 = r2.getStatusLine()     // Catch: java.lang.Throwable -> L2c
            int r0 = r0.getStatusCode()     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r8.isNotServerError(r0)     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L27
            boolean r0 = r8.isNotStale(r2)     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = r1
        L28:
            r2.close()     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            return r0
        L2c:
            r0 = move-exception
            r2.close()     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
            throw r0     // Catch: java.lang.RuntimeException -> L31 cz.msebera.android.httpclient.HttpException -> L47 java.io.IOException -> L50
        L31:
            r0 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r8.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "RuntimeException thrown during asynchronous revalidation: "
            r3.<init>(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r2.error(r0)
            return r1
        L47:
            r0 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r8.log
            java.lang.String r3 = "HTTP protocol exception during asynchronous revalidation"
            r2.error(r3, r0)
            return r1
        L50:
            r0 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r8.log
            java.lang.String r3 = "Asynchronous revalidation failed due to I/O error"
            r2.debug(r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.client.cache.AsynchronousValidationRequest.revalidateCacheEntry():boolean");
    }

    private boolean isNotStale(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("Warning");
        if (headers == null) {
            return true;
        }
        for (Header header : headers) {
            String value = header.getValue();
            if (value.startsWith("110") || value.startsWith("111")) {
                return false;
            }
        }
        return true;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getConsecutiveFailedAttempts() {
        return this.consecutiveFailedAttempts;
    }
}
