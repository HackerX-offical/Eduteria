package com.google.firebase.database.core;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class Context {
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    protected AuthTokenProvider authTokenProvider;
    protected EventTarget eventTarget;
    protected FirebaseApp firebaseApp;
    private PersistenceManager forcedPersistenceManager;
    protected List<String> loggedComponents;
    protected Logger logger;
    protected boolean persistenceEnabled;
    protected String persistenceKey;
    private Platform platform;
    protected RunLoop runLoop;
    protected String userAgent;
    protected Logger.Level logLevel = Logger.Level.INFO;
    protected long cacheSize = 10485760;
    private boolean frozen = false;
    private boolean stopped = false;

    private Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private synchronized void initializeAndroidPlatform() {
        this.platform = new AndroidPlatform(this.firebaseApp);
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    synchronized void freeze() {
        if (!this.frozen) {
            this.frozen = true;
            initServices();
        }
    }

    public void requireStarted() {
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
    }

    private void restartServices() {
        this.eventTarget.restart();
        this.runLoop.restart();
    }

    void stop() {
        this.stopped = true;
        this.eventTarget.shutdown();
        this.runLoop.shutdown();
    }

    protected void assertUnfrozen() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public List<String> getOptDebugLogComponents() {
        return this.loggedComponents;
    }

    public Logger.Level getLogLevel() {
        return this.logLevel;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public LogWrapper getLogger(String str) {
        return new LogWrapper(this.logger, str);
    }

    public LogWrapper getLogger(String str, String str2) {
        return new LogWrapper(this.logger, str, str2);
    }

    public ConnectionContext getConnectionContext() {
        return new ConnectionContext(getLogger(), wrapAuthTokenProvider(getAuthTokenProvider(), getExecutorService()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), getSSLCacheDirectory().getAbsolutePath());
    }

    PersistenceManager getPersistenceManager(String str) {
        PersistenceManager persistenceManager = this.forcedPersistenceManager;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (this.persistenceEnabled) {
            PersistenceManager persistenceManagerCreatePersistenceManager = this.platform.createPersistenceManager(this, str);
            if (persistenceManagerCreatePersistenceManager != null) {
                return persistenceManagerCreatePersistenceManager;
            }
            throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
        }
        return new NoopPersistenceManager();
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.cacheSize;
    }

    void forcePersistenceManager(PersistenceManager persistenceManager) {
        this.forcedPersistenceManager = persistenceManager;
    }

    public EventTarget getEventTarget() {
        return this.eventTarget;
    }

    public RunLoop getRunLoop() {
        return this.runLoop;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public String getSessionPersistenceKey() {
        return this.persistenceKey;
    }

    public AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public PersistentConnection newPersistentConnection(HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), hostInfo, delegate);
    }

    private ScheduledExecutorService getExecutorService() {
        RunLoop runLoop = getRunLoop();
        if (!(runLoop instanceof DefaultRunLoop)) {
            throw new RuntimeException("Custom run loops are not supported!");
        }
        return ((DefaultRunLoop) runLoop).getExecutorService();
    }

    private void ensureLogger() {
        if (this.logger == null) {
            this.logger = getPlatform().newLogger(this, this.logLevel, this.loggedComponents);
        }
    }

    private void ensureRunLoop() {
        if (this.runLoop == null) {
            this.runLoop = this.platform.newRunLoop(this);
        }
    }

    private void ensureEventTarget() {
        if (this.eventTarget == null) {
            this.eventTarget = getPlatform().newEventTarget(this);
        }
    }

    private void ensureUserAgent() {
        if (this.userAgent == null) {
            this.userAgent = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private void ensureAuthTokenProvider() {
        Preconditions.checkNotNull(this.authTokenProvider, "You must register an authTokenProvider before initializing Context.");
    }

    private void ensureSessionIdentifier() {
        if (this.persistenceKey == null) {
            this.persistenceKey = CookieSpecs.DEFAULT;
        }
    }

    private String buildUserAgent(String str) {
        return "Firebase/5/" + FirebaseDatabase.getSdkVersion() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    private static ConnectionAuthTokenProvider wrapAuthTokenProvider(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        return Context$$Lambda$1.lambdaFactory$(authTokenProvider, scheduledExecutorService);
    }

    static /* synthetic */ void lambda$wrapAuthTokenProvider$0(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService, boolean z, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
        authTokenProvider.getToken(z, new AnonymousClass1(scheduledExecutorService, getTokenCallback));
    }

    /* JADX INFO: renamed from: com.google.firebase.database.core.Context$1, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    class AnonymousClass1 implements AuthTokenProvider.GetTokenCompletionListener {
        final /* synthetic */ ConnectionAuthTokenProvider.GetTokenCallback val$callback;
        final /* synthetic */ ScheduledExecutorService val$executorService;

        AnonymousClass1(ScheduledExecutorService scheduledExecutorService, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
            this.val$executorService = scheduledExecutorService;
            this.val$callback = getTokenCallback;
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
        public void onSuccess(String str) {
            this.val$executorService.execute(Context$1$$Lambda$1.lambdaFactory$(this.val$callback, str));
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
        public void onError(String str) {
            this.val$executorService.execute(Context$1$$Lambda$4.lambdaFactory$(this.val$callback, str));
        }
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }
}
