package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    public HttpClientAndroidLog log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit) {
        this(schemeRegistry, j, timeUnit, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit, ConnPerRouteBean connPerRouteBean) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = connPerRouteBean;
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute connPoolByRouteCreateConnectionPool = createConnectionPool(j, timeUnit);
        this.pool = connPoolByRouteCreateConnectionPool;
        this.connectionPool = connPoolByRouteCreateConnectionPool;
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = new ConnPerRouteBean();
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute connPoolByRoute = (ConnPoolByRoute) createConnectionPool(httpParams);
        this.pool = connPoolByRoute;
        this.connectionPool = connPoolByRoute;
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    @Deprecated
    protected AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return new ConnPoolByRoute(this.connOperator, httpParams);
    }

    protected ConnPoolByRoute createConnectionPool(long j, TimeUnit timeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, j, timeUnit);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(final HttpRoute httpRoute, Object obj) {
        final PoolEntryRequest poolEntryRequestRequestPoolEntry = this.pool.requestPoolEntry(httpRoute, obj);
        return new ClientConnectionRequest() { // from class: cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager.1
            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public void abortRequest() {
                poolEntryRequestRequestPoolEntry.abortRequest();
            }

            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                Args.notNull(httpRoute, "Route");
                if (ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
                    ThreadSafeClientConnManager.this.log.debug("Get connection: " + httpRoute + ", timeout = " + j);
                }
                return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, poolEntryRequestRequestPoolEntry.getPoolEntry(j, timeUnit));
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void releaseConnection(cz.msebera.android.httpclient.conn.ManagedClientConnection r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.msebera.android.httpclient.impl.conn.tsccm.BasicPooledConnAdapter
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            cz.msebera.android.httpclient.util.Args.check(r0, r1)
            cz.msebera.android.httpclient.impl.conn.tsccm.BasicPooledConnAdapter r8 = (cz.msebera.android.httpclient.impl.conn.tsccm.BasicPooledConnAdapter) r8
            cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry r0 = r8.getPoolEntry()
            if (r0 == 0) goto L1d
            cz.msebera.android.httpclient.conn.ClientConnectionManager r0 = r8.getManager()
            if (r0 != r7) goto L17
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            java.lang.String r1 = "Connection not obtained from this manager"
            cz.msebera.android.httpclient.util.Asserts.check(r0, r1)
        L1d:
            monitor-enter(r8)
            cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry r0 = r8.getPoolEntry()     // Catch: java.lang.Throwable -> Lc2
            r2 = r0
            cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry r2 = (cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry) r2     // Catch: java.lang.Throwable -> Lc2
            if (r2 != 0) goto L29
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc2
            return
        L29:
            boolean r0 = r8.isOpen()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L64
            if (r0 == 0) goto L38
            boolean r0 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L64
            if (r0 != 0) goto L38
            r8.shutdown()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L64
        L38:
            boolean r3 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r7.log     // Catch: java.lang.Throwable -> Lc2
            boolean r0 = r0.isDebugEnabled()     // Catch: java.lang.Throwable -> Lc2
            if (r0 == 0) goto L55
            if (r3 == 0) goto L4e
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = "Released connection is reusable."
            r0.debug(r1)     // Catch: java.lang.Throwable -> Lc2
            goto L55
        L4e:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = "Released connection is not reusable."
            r0.debug(r1)     // Catch: java.lang.Throwable -> Lc2
        L55:
            r8.detach()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch: java.lang.Throwable -> Lc2
            r4 = r9
            r6 = r11
        L5c:
            r1.freeEntry(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> Lc2
            goto L99
        L60:
            r0 = move-exception
            r4 = r9
            r6 = r11
            goto L9c
        L64:
            r0 = move-exception
            r4 = r9
            r6 = r11
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> L9b
            boolean r9 = r9.isDebugEnabled()     // Catch: java.lang.Throwable -> L9b
            if (r9 == 0) goto L76
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> L9b
            java.lang.String r10 = "Exception shutting down released connection."
            r9.debug(r10, r0)     // Catch: java.lang.Throwable -> L9b
        L76:
            boolean r3 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            boolean r9 = r9.isDebugEnabled()     // Catch: java.lang.Throwable -> Lc2
            if (r9 == 0) goto L93
            if (r3 == 0) goto L8c
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r10 = "Released connection is reusable."
            r9.debug(r10)     // Catch: java.lang.Throwable -> Lc2
            goto L93
        L8c:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r10 = "Released connection is not reusable."
            r9.debug(r10)     // Catch: java.lang.Throwable -> Lc2
        L93:
            r8.detach()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch: java.lang.Throwable -> Lc2
            goto L5c
        L99:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc2
            return
        L9b:
            r0 = move-exception
        L9c:
            boolean r3 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            boolean r9 = r9.isDebugEnabled()     // Catch: java.lang.Throwable -> Lc2
            if (r9 == 0) goto Lb9
            if (r3 == 0) goto Lb2
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r10 = "Released connection is reusable."
            r9.debug(r10)     // Catch: java.lang.Throwable -> Lc2
            goto Lb9
        Lb2:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r10 = "Released connection is not reusable."
            r9.debug(r10)     // Catch: java.lang.Throwable -> Lc2
        Lb9:
            r8.detach()     // Catch: java.lang.Throwable -> Lc2
            cz.msebera.android.httpclient.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch: java.lang.Throwable -> Lc2
            r1.freeEntry(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> Lc2
            throw r0     // Catch: java.lang.Throwable -> Lc2
        Lc2:
            r0 = move-exception
            r9 = r0
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc2
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager.releaseConnection(cz.msebera.android.httpclient.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        return this.pool.getConnectionsInPool(httpRoute);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.pool.closeIdleConnections(j, timeUnit);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotalConnections(i);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int i) {
        this.connPerRoute.setDefaultMaxPerRoute(i);
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.connPerRoute.getMaxForRoute(httpRoute);
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        this.connPerRoute.setMaxForRoute(httpRoute, i);
    }
}
