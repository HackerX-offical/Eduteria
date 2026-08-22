package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpProcessor, "Proxy HTTP processor");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.proxyHttpProcessor = httpProcessor;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, new ImmutableHttpProcessor(new RequestTargetHost()), authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r1v18, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v2, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3, types: [cz.msebera.android.httpclient.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r26v0, types: [cz.msebera.android.httpclient.client.methods.HttpExecutionAware] */
    /* JADX WARN: Type inference failed for: r4v40, types: [cz.msebera.android.httpclient.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v44, types: [cz.msebera.android.httpclient.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v7, types: [cz.msebera.android.httpclient.protocol.HttpRequestExecutor] */
    /* JADX WARN: Type inference failed for: r5v1, types: [cz.msebera.android.httpclient.HttpRequest] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        AuthState authState;
        HttpClientConnection httpClientConnection;
        ?? r14;
        Object obj;
        ?? r1;
        HttpResponse response;
        Object userToken;
        ?? r12;
        HttpClientConnection httpClientConnection2;
        AuthState authState2;
        HttpResponse httpResponse;
        String str;
        MainClientExec mainClientExec = this;
        HttpRoute httpRoute2 = httpRoute;
        Object obj2 = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(obj2, "HTTP request");
        Args.notNull(httpClientContext2, "HTTP context");
        AuthState targetAuthState = httpClientContext2.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState3 = targetAuthState;
        AuthState proxyAuthState = httpClientContext2.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (obj2 instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) obj2);
        }
        Object userToken2 = httpClientContext2.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec.connManager.requestConnection(httpRoute2, userToken2);
        if (httpExecutionAware != 0) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext2.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection3 = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext2.setAttribute("http.connection", httpClientConnection3);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection3.isOpen()) {
                mainClientExec.log.debug("Stale connection check");
                if (httpClientConnection3.isStale()) {
                    mainClientExec.log.debug("Stale connection detected");
                    httpClientConnection3.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec.log, mainClientExec.connManager, httpClientConnection3);
            if (httpExecutionAware != 0) {
                try {
                    httpExecutionAware.setCancellable(connectionHolder);
                } catch (HttpException e2) {
                    e = e2;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (ConnectionShutdownException e3) {
                    e = e3;
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e);
                    throw interruptedIOException;
                } catch (IOException e4) {
                    e = e4;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (RuntimeException e5) {
                    e = e5;
                    connectionHolder.abortConnection();
                    throw e;
                }
            }
            int i = 1;
            int i2 = 1;
            MainClientExec mainClientExec2 = mainClientExec;
            ?? r5 = obj2;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(r5)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (httpClientConnection3.isOpen()) {
                    HttpClientConnection httpClientConnection4 = httpClientConnection3;
                    authState = proxyAuthState;
                    httpClientConnection = httpClientConnection4;
                    r14 = r5;
                    r12 = mainClientExec2;
                } else {
                    try {
                        AuthState authState4 = proxyAuthState;
                        mainClientExec2.log.debug("Opening connection " + httpRoute2);
                        ?? r13 = this;
                        try {
                            r13.establishRoute(authState4, httpClientConnection3, httpRoute2, r5, httpClientContext2);
                            HttpClientConnection httpClientConnection5 = httpClientConnection3;
                            authState = authState4;
                            httpClientConnection = httpClientConnection5;
                            r14 = r5;
                            r12 = r13;
                        } catch (TunnelRefusedException e6) {
                            if (r13.log.isDebugEnabled()) {
                                r13.log.debug(e6.getMessage());
                            }
                            response = e6.getResponse();
                            obj = userToken2;
                            r1 = r13;
                        }
                    } catch (HttpException e7) {
                        e = e7;
                        connectionHolder.abortConnection();
                        throw e;
                    } catch (ConnectionShutdownException e8) {
                        e = e8;
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException2.initCause(e);
                        throw interruptedIOException2;
                    } catch (IOException e9) {
                        e = e9;
                        connectionHolder.abortConnection();
                        throw e;
                    } catch (RuntimeException e10) {
                        e = e10;
                        connectionHolder.abortConnection();
                        throw e;
                    }
                }
                int socketTimeout = requestConfig.getSocketTimeout();
                if (socketTimeout >= 0) {
                    httpClientConnection.setSocketTimeout(socketTimeout);
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (r12.log.isDebugEnabled()) {
                    obj = userToken2;
                    r12.log.debug("Executing request " + r14.getRequestLine());
                } else {
                    obj = userToken2;
                }
                if (!r14.containsHeader("Authorization")) {
                    if (r12.log.isDebugEnabled()) {
                        r12.log.debug("Target auth state: " + authState3.getState());
                    }
                    r12.authenticator.generateAuthResponse(r14, authState3, httpClientContext2);
                }
                if (!r14.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                    if (r12.log.isDebugEnabled()) {
                        r12.log.debug("Proxy auth state: " + authState.getState());
                    }
                    r12.authenticator.generateAuthResponse(r14, authState, httpClientContext2);
                }
                HttpResponse httpResponseExecute = r12.requestExecutor.execute(r14, httpClientConnection, httpClientContext2);
                if (r12.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    long keepAliveDuration = r12.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, httpClientContext2);
                    if (r12.log.isDebugEnabled()) {
                        if (keepAliveDuration > 0) {
                            httpResponse = httpResponseExecute;
                            str = "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS;
                        } else {
                            httpResponse = httpResponseExecute;
                            str = "indefinitely";
                        }
                        r12.log.debug("Connection can be kept alive " + str);
                    } else {
                        httpResponse = httpResponseExecute;
                    }
                    connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                    connectionHolder.markReusable();
                } else {
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    httpResponse = httpResponseExecute;
                    connectionHolder.markNonReusable();
                }
                MainClientExec mainClientExec3 = this;
                httpClientContext2 = httpClientContext;
                AuthState authState5 = authState3;
                AuthState authState6 = authState2;
                HttpResponse httpResponse2 = httpResponse;
                if (!mainClientExec3.needAuthentication(authState5, authState6, httpRoute, httpResponse2, httpClientContext2)) {
                    response = httpResponse2;
                    r1 = mainClientExec3;
                    break;
                }
                HttpEntity entity = httpResponse2.getEntity();
                if (connectionHolder.isReusable()) {
                    EntityUtils.consume(entity);
                } else {
                    httpClientConnection2.close();
                    if (authState6.getState() == AuthProtocolState.SUCCESS && authState6.getAuthScheme() != null && authState6.getAuthScheme().isConnectionBased()) {
                        mainClientExec3.log.debug("Resetting proxy auth state");
                        authState6.reset();
                    }
                    if (authState5.getState() == AuthProtocolState.SUCCESS && authState5.getAuthScheme() != null && authState5.getAuthScheme().isConnectionBased()) {
                        mainClientExec3.log.debug("Resetting target auth state");
                        authState5.reset();
                    }
                }
                HttpRequest original = r14.getOriginal();
                if (!original.containsHeader("Authorization")) {
                    r14.removeHeaders("Authorization");
                }
                if (!original.containsHeader("Proxy-Authorization")) {
                    r14.removeHeaders("Proxy-Authorization");
                }
                i2++;
                httpRoute2 = httpRoute;
                authState3 = authState5;
                proxyAuthState = authState6;
                httpClientConnection3 = httpClientConnection2;
                r5 = r14;
                userToken2 = obj;
                i = 1;
                mainClientExec2 = mainClientExec3;
            }
            if (obj == null) {
                userToken = r1.userTokenHandler.getUserToken(httpClientContext2);
                httpClientContext2.setAttribute("http.user-token", userToken);
            } else {
                userToken = obj;
            }
            if (userToken != null) {
                connectionHolder.setState(userToken);
            }
            HttpEntity entity2 = response.getEntity();
            if (entity2 != null && entity2.isStreaming()) {
                return new HttpResponseProxy(response, connectionHolder);
            }
            connectionHolder.releaseConnection();
            return new HttpResponseProxy(response, null);
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e11);
        } catch (ExecutionException e12) {
            e = e12;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5 A[LOOP:0: B:3:0x000d->B:23:0x00b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void establishRoute(cz.msebera.android.httpclient.auth.AuthState r8, cz.msebera.android.httpclient.HttpClientConnection r9, cz.msebera.android.httpclient.conn.routing.HttpRoute r10, cz.msebera.android.httpclient.HttpRequest r11, cz.msebera.android.httpclient.client.protocol.HttpClientContext r12) throws java.io.IOException, cz.msebera.android.httpclient.HttpException {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.execchain.MainClientExec.establishRoute(cz.msebera.android.httpclient.auth.AuthState, cz.msebera.android.httpclient.HttpClientConnection, cz.msebera.android.httpclient.conn.routing.HttpRoute, cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.client.protocol.HttpClientContext):void");
    }

    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        AuthState authState2;
        HttpClientContext httpClientContext2;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int connectTimeout = requestConfig.getConnectTimeout();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        HttpResponse httpResponse = null;
        while (true) {
            if (httpResponse == null) {
                if (!httpClientConnection.isOpen()) {
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
                this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
                HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
                if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                    throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
                }
                if (requestConfig.isAuthenticationEnabled()) {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                    if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2)) {
                        if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                            this.log.debug("Connection kept alive");
                            EntityUtils.consume(httpResponseExecute.getEntity());
                        } else {
                            httpClientConnection.close();
                        }
                        httpResponse = null;
                    }
                    authState = authState2;
                    httpClientContext = httpClientContext2;
                } else {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                }
                httpResponse = httpResponseExecute;
                authState = authState2;
                httpClientContext = httpClientContext2;
            } else {
                if (httpResponse.getStatusLine().getStatusCode() <= 299) {
                    return false;
                }
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    httpResponse.setEntity(new BufferedHttpEntity(entity));
                }
                httpClientConnection.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
            }
        }
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost = targetHost.getPort() < 0 ? new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName()) : targetHost;
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost httpHost2 = httpHost;
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost3 = proxyHost;
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        }
        if (zIsAuthenticationRequested2) {
            return this.authenticator.handleAuthChallenge(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        }
        return false;
    }
}
