package org.jivesoftware.smack;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageOrPresence;
import org.jivesoftware.smack.packet.MessageOrPresenceBuilder;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.StreamOpen;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.NonzaProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.core.SASLAnonymous;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractXMPPConnection implements XMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final AsyncButOrdered<AbstractXMPPConnection> ASYNC_BUT_ORDERED;
    private static final ExecutorService CACHED_EXECUTOR_SERVICE;
    private static final Logger LOGGER = Logger.getLogger(AbstractXMPPConnection.class.getName());
    protected static final SmackReactor SMACK_REACTOR = SmackReactor.getInstance();
    private static final AtomicInteger connectionCounter = new AtomicInteger(0);
    protected long authenticatedConnectionInitiallyEstablishedTimestamp;
    protected boolean closingStreamReceived;
    protected XMPPInputOutputStream compressionHandler;
    protected final ConnectionConfiguration config;
    private int currentAsyncRunnables;
    protected SmackException currentSmackException;
    protected XMPPException currentXmppException;
    protected final SmackDebugger debugger;
    private int deferredAsyncRunnablesCount;
    private int deferredAsyncRunnablesCountPrevious;
    protected String host;
    private XmlEnvironment incomingStreamXmlEnvironment;
    protected boolean lastFeaturesReceived;
    private long lastStanzaReceived;
    protected XmlEnvironment outgoingStreamXmlEnvironment;
    protected UInt16 port;
    protected Reader reader;
    private final SASLAuthentication saslAuthentication;
    protected boolean saslFeatureReceived;
    private final StanzaFactory stanzaFactory;
    protected String streamId;
    protected boolean tlsHandled;
    private String usedPassword;
    private Resourcepart usedResource;
    private String usedUsername;
    protected EntityFullJid user;
    protected Writer writer;
    private DomainBareJid xmppServiceDomain;
    protected final Set<ConnectionListener> connectionListeners = new CopyOnWriteArraySet();
    private final Collection<StanzaCollector> collectors = new ConcurrentLinkedQueue();
    private final Map<StanzaListener, ListenerWrapper> recvListeners = new LinkedHashMap();
    private final Map<StanzaListener, ListenerWrapper> syncRecvListeners = new LinkedHashMap();
    private final Map<StanzaListener, ListenerWrapper> asyncRecvListeners = new LinkedHashMap();
    private final Map<StanzaListener, ListenerWrapper> sendListeners = new HashMap();
    private final Map<StanzaListener, InterceptorWrapper> interceptors = new HashMap();
    private final Map<Consumer<MessageBuilder>, GenericInterceptorWrapper<MessageBuilder, Message>> messageInterceptors = new HashMap();
    private final Map<Consumer<PresenceBuilder>, GenericInterceptorWrapper<PresenceBuilder, Presence>> presenceInterceptors = new HashMap();
    final MultiMap<QName, NonzaCallback> nonzaCallbacksMap = new MultiMap<>();
    protected final Lock connectionLock = new ReentrantLock();
    protected final Map<QName, FullyQualifiedElement> streamFeatures = new HashMap();
    protected boolean connected = false;
    private long replyTimeout = SmackConfiguration.getDefaultReplyTimeout();
    protected final int connectionCounterValue = connectionCounter.getAndIncrement();
    private XMPPConnection.FromMode fromMode = XMPPConnection.FromMode.OMITTED;
    private ParsingExceptionCallback parsingExceptionCallback = SmackConfiguration.getDefaultParsingExceptionCallback();
    protected final AsyncButOrdered<StanzaListener> inOrderListeners = new AsyncButOrdered<>();
    protected boolean authenticated = false;
    protected boolean wasAuthenticated = false;
    private final Map<QName, IQRequestHandler> setIqRequestHandler = new HashMap();
    private final Map<QName, IQRequestHandler> getIqRequestHandler = new HashMap();
    private final Object internalMonitor = new Object();
    private final Object notifyConnectionErrorMonitor = new Object();
    private SmackConfiguration.UnknownIqRequestReplyMode unknownIqRequestReplyMode = SmackConfiguration.getUnknownIqRequestReplyMode();
    private final Queue<Runnable> deferredAsyncRunnables = new LinkedList();
    private int maxAsyncRunnables = SmackConfiguration.getDefaultConcurrencyLevelLimit();

    /* JADX INFO: Access modifiers changed from: protected */
    public enum SyncPointState {
        initial,
        request_sent,
        successful
    }

    protected void afterFeaturesReceived() throws SmackException.NotConnectedException, InterruptedException, SmackException.SecurityRequiredException {
    }

    protected abstract void connectInternal() throws SmackException, InterruptedException, IOException, XMPPException;

    public abstract void instantShutdown();

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract boolean isSecureConnection();

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract boolean isUsingCompression();

    protected abstract void loginInternal(String str, String str2, Resourcepart resourcepart) throws SmackException, InterruptedException, IOException, XMPPException;

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException;

    protected abstract void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException;

    protected abstract void shutdown();

    static /* synthetic */ int access$510(AbstractXMPPConnection abstractXMPPConnection) {
        int i = abstractXMPPConnection.currentAsyncRunnables;
        abstractXMPPConnection.currentAsyncRunnables = i - 1;
        return i;
    }

    static /* synthetic */ int access$610(AbstractXMPPConnection abstractXMPPConnection) {
        int i = abstractXMPPConnection.deferredAsyncRunnablesCount;
        abstractXMPPConnection.deferredAsyncRunnablesCount = i - 1;
        return i;
    }

    static {
        Smack.ensureInitialized();
        CACHED_EXECUTOR_SERVICE = Executors.newCachedThreadPool(new ThreadFactory() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("Smack Cached Executor");
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        AbstractXMPPConnection.LOGGER.log(Level.WARNING, thread2 + " encountered uncaught exception", th);
                    }
                });
                return thread;
            }
        });
        ASYNC_BUT_ORDERED = new AsyncButOrdered<>();
    }

    protected AbstractXMPPConnection(ConnectionConfiguration connectionConfiguration) {
        this.saslAuthentication = new SASLAuthentication(this, connectionConfiguration);
        this.config = connectionConfiguration;
        buildNonzaCallback().listenFor(SaslNonza.Challenge.class, new NonzaCallback.NonzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
            public final void accept(Nonza nonza) throws IOException {
                this.f$0.m14185lambda$new$0$orgjivesoftwaresmackAbstractXMPPConnection((SaslNonza.Challenge) nonza);
            }
        }).listenFor(SaslNonza.Success.class, new NonzaCallback.NonzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
            public final void accept(Nonza nonza) throws IOException {
                this.f$0.m14186lambda$new$1$orgjivesoftwaresmackAbstractXMPPConnection((SaslNonza.Success) nonza);
            }
        }).listenFor(SaslNonza.SASLFailure.class, new NonzaCallback.NonzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda2
            @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
            public final void accept(Nonza nonza) throws IOException {
                this.f$0.m14187lambda$new$2$orgjivesoftwaresmackAbstractXMPPConnection((SaslNonza.SASLFailure) nonza);
            }
        }).install();
        SmackDebuggerFactory debuggerFactory = connectionConfiguration.getDebuggerFactory();
        if (debuggerFactory != null) {
            this.debugger = debuggerFactory.create(this);
        } else {
            this.debugger = null;
        }
        Iterator<ConnectionCreationListener> it = XMPPConnectionRegistry.getConnectionCreationListeners().iterator();
        while (it.hasNext()) {
            it.next().connectionCreated(this);
        }
        this.stanzaFactory = new StanzaFactory(connectionConfiguration.constructStanzaIdSource());
    }

    /* JADX INFO: renamed from: lambda$new$0$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ void m14185lambda$new$0$orgjivesoftwaresmackAbstractXMPPConnection(SaslNonza.Challenge challenge) throws IOException {
        try {
            this.saslAuthentication.challengeReceived(challenge);
        } catch (InterruptedException | SmackException e2) {
            this.saslAuthentication.authenticationFailed(e2);
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ void m14186lambda$new$1$orgjivesoftwaresmackAbstractXMPPConnection(SaslNonza.Success success) throws IOException {
        try {
            this.saslAuthentication.authenticated(success);
        } catch (InterruptedException | SmackException.NotConnectedException | SmackException.SmackSaslException e2) {
            this.saslAuthentication.authenticationFailed(e2);
        }
    }

    /* JADX INFO: renamed from: lambda$new$2$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ void m14187lambda$new$2$orgjivesoftwaresmackAbstractXMPPConnection(SaslNonza.SASLFailure sASLFailure) throws IOException {
        this.saslAuthentication.authenticationFailed(sASLFailure);
    }

    public ConnectionConfiguration getConfiguration() {
        return this.config;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public DomainBareJid getXMPPServiceDomain() {
        DomainBareJid domainBareJid = this.xmppServiceDomain;
        return domainBareJid != null ? domainBareJid : this.config.getXMPPServiceDomain();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public String getHost() {
        return this.host;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public int getPort() {
        UInt16 uInt16 = this.port;
        if (uInt16 == null) {
            return -1;
        }
        return uInt16.intValue();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean trySendStanza(Stanza stanza) throws SmackException.NotConnectedException {
        try {
            sendStanza(stanza);
            return true;
        } catch (InterruptedException e2) {
            LOGGER.log(Level.FINER, "Thread blocked in fallback implementation of trySendStanza(Stanza) was interrupted", (Throwable) e2);
            return false;
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean trySendStanza(Stanza stanza, long j, TimeUnit timeUnit) throws SmackException.NotConnectedException, InterruptedException {
        sendStanza(stanza);
        return true;
    }

    protected void initState() {
        this.currentSmackException = null;
        this.currentXmppException = null;
        this.tlsHandled = false;
        this.lastFeaturesReceived = false;
        this.saslFeatureReceived = false;
    }

    public synchronized AbstractXMPPConnection connect() throws SmackException, InterruptedException, IOException, XMPPException {
        throwAlreadyConnectedExceptionIfAppropriate();
        callConnectionConnectingListener();
        initState();
        this.closingStreamReceived = false;
        this.streamId = null;
        try {
            connectInternal();
            if (!isSecureConnection() && getConfiguration().getSecurityMode() == ConnectionConfiguration.SecurityMode.required) {
                throw new SmackException.SecurityRequiredByClientException();
            }
            callConnectionConnectedListener();
        } catch (IOException | InterruptedException | SmackException | XMPPException e2) {
            instantShutdown();
            throw e2;
        }
        return this;
    }

    public synchronized void login() throws SmackException, InterruptedException, IOException, XMPPException {
        CharSequence username = this.usedUsername;
        if (username == null) {
            username = this.config.getUsername();
        }
        String password = this.usedPassword;
        if (password == null) {
            password = this.config.getPassword();
        }
        Resourcepart resource = this.usedResource;
        if (resource == null) {
            resource = this.config.getResource();
        }
        login(username, password, resource);
    }

    public synchronized void login(CharSequence charSequence, String str) throws SmackException, InterruptedException, IOException, XMPPException {
        login(charSequence, str, this.config.getResource());
    }

    public synchronized void login(CharSequence charSequence, String str, Resourcepart resourcepart) throws SmackException, InterruptedException, IOException, XMPPException {
        if (!this.config.allowNullOrEmptyUsername) {
            StringUtils.requireNotNullNorEmpty(charSequence, "Username must not be null nor empty");
        }
        throwNotConnectedExceptionIfAppropriate("Did you call connect() before login()?");
        throwAlreadyLoggedInExceptionIfAppropriate();
        String string = charSequence != null ? charSequence.toString() : null;
        this.usedUsername = string;
        this.usedPassword = str;
        this.usedResource = resourcepart;
        loginInternal(string, str, resourcepart);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isConnected() {
        return this.connected;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final EntityFullJid getUser() {
        return this.user;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public String getStreamId() {
        if (isConnected()) {
            return this.streamId;
        }
        return null;
    }

    protected final void throwCurrentConnectionException() throws SmackException, XMPPException {
        SmackException smackException = this.currentSmackException;
        if (smackException != null) {
            throw smackException;
        }
        XMPPException xMPPException = this.currentXmppException;
        if (xMPPException != null) {
            throw xMPPException;
        }
        throw new AssertionError("No current connection exception set, although throwCurrentException() was called");
    }

    protected final boolean hasCurrentConnectionException() {
        return (this.currentSmackException == null && this.currentXmppException == null) ? false : true;
    }

    protected final void setCurrentConnectionExceptionAndNotify(Exception exc) {
        if (exc instanceof SmackException) {
            this.currentSmackException = (SmackException) exc;
        } else if (exc instanceof XMPPException) {
            this.currentXmppException = (XMPPException) exc;
        } else {
            this.currentSmackException = new SmackException.SmackWrappedException(exc);
        }
        notifyWaitingThreads();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyWaitingThreads() {
        synchronized (this.internalMonitor) {
            this.internalMonitor.notifyAll();
        }
    }

    protected final boolean waitFor(Supplier<Boolean> supplier) throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis() + getReplyTimeout();
        synchronized (this.internalMonitor) {
            while (!supplier.get().booleanValue()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 >= jCurrentTimeMillis) {
                    return false;
                }
                this.internalMonitor.wait(jCurrentTimeMillis - jCurrentTimeMillis2);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: lambda$waitForConditionOrConnectionException$3$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14190x13ba33b7(Supplier supplier) {
        return Boolean.valueOf(((Boolean) supplier.get()).booleanValue() || hasCurrentConnectionException());
    }

    protected final boolean waitForConditionOrConnectionException(final Supplier<Boolean> supplier) throws InterruptedException {
        return waitFor(new Supplier() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda3
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14190x13ba33b7(supplier);
            }
        });
    }

    protected final void waitForConditionOrConnectionException(Supplier<Boolean> supplier, String str) throws SmackException.NoResponseException, InterruptedException {
        if (!waitForConditionOrConnectionException(supplier)) {
            throw SmackException.NoResponseException.newWith(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void waitForConditionOrThrowConnectionException(Supplier<Boolean> supplier, String str) throws SmackException, InterruptedException, XMPPException {
        waitForConditionOrConnectionException(supplier, str);
        if (hasCurrentConnectionException()) {
            throwCurrentConnectionException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Resourcepart bindResourceAndEstablishSession(Resourcepart resourcepart) throws SmackException, InterruptedException, XMPPException {
        LOGGER.finer("Waiting for last features to be received before continuing with resource binding");
        waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda5
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14183x30f49bda();
            }
        }, "last stream features received from server");
        if (!hasFeature(Bind.ELEMENT, Bind.NAMESPACE)) {
            throw new SmackException.ResourceBindingNotOfferedException();
        }
        Bind bindNewSet = Bind.newSet(resourcepart);
        Bind bind = (Bind) createStanzaCollectorAndSend(new StanzaIdFilter(bindNewSet), bindNewSet).nextResultOrThrow();
        EntityFullJid jid = bind.getJid();
        this.user = jid;
        this.xmppServiceDomain = jid.asDomainBareJid();
        Session.Feature feature = (Session.Feature) getFeature(Session.Feature.class);
        if (feature != null && !feature.isOptional()) {
            Session session = new Session();
            createStanzaCollectorAndSend(new StanzaIdFilter(session), session).nextResultOrThrow();
        }
        return bind.getJid().getResourcepart();
    }

    /* JADX INFO: renamed from: lambda$bindResourceAndEstablishSession$4$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14183x30f49bda() {
        return Boolean.valueOf(this.lastFeaturesReceived);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterSuccessfulLogin(boolean z) throws SmackException.NotConnectedException, InterruptedException {
        if (!z) {
            this.authenticatedConnectionInitiallyEstablishedTimestamp = System.currentTimeMillis();
        }
        this.authenticated = true;
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.userHasLogged(this.user);
        }
        callConnectionAuthenticatedListener(z);
        if (!this.config.isSendPresence() || z) {
            return;
        }
        sendStanza(getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.available).build());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isAnonymous() {
        return isAuthenticated() && SASLAnonymous.NAME.equals(getUsedSaslMechansism());
    }

    public final String getUsedSaslMechansism() {
        return this.saslAuthentication.getNameOfLastUsedSaslMechansism();
    }

    protected Lock getConnectionLock() {
        return this.connectionLock;
    }

    protected void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        throwNotConnectedExceptionIfAppropriate(null);
    }

    protected void throwNotConnectedExceptionIfAppropriate(String str) throws SmackException.NotConnectedException {
        if (!isConnected()) {
            throw new SmackException.NotConnectedException(str);
        }
    }

    protected void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected()) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    protected void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated()) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final StanzaFactory getStanzaFactory() {
        return this.stanzaFactory;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final void sendStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        Objects.requireNonNull(stanza, "Stanza must not be null");
        throwNotConnectedExceptionIfAppropriate();
        int i = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[this.fromMode.ordinal()];
        if (i == 1) {
            stanza.setFrom(null);
        } else if (i == 2) {
            stanza.setFrom(getUser());
        }
        sendStanzaInternal(firePacketInterceptors(stanza));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SASLMechanism authenticate(String str, String str2, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, SmackException.SmackSaslException, SASLErrorException, IOException, SmackException.SmackWrappedException, XMPPException.XMPPErrorException {
        SASLMechanism sASLMechanismAuthenticate = this.saslAuthentication.authenticate(str, str2, entityBareJid, sSLSession);
        afterSaslAuthenticationSuccess();
        return sASLMechanismAuthenticate;
    }

    protected void afterSaslAuthenticationSuccess() throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackWrappedException {
        sendStreamOpen();
    }

    protected final boolean isSaslAuthenticated() {
        return this.saslAuthentication.authenticationSuccessful();
    }

    public void disconnect() {
        try {
            disconnect(isAuthenticated() ? getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unavailable).build() : null);
        } catch (SmackException.NotConnectedException e2) {
            LOGGER.log(Level.FINEST, "Connection is already disconnected", (Throwable) e2);
        }
    }

    public synchronized void disconnect(Presence presence) throws SmackException.NotConnectedException {
        if (presence != null) {
            try {
                sendStanza(presence);
            } catch (InterruptedException e2) {
                LOGGER.log(Level.FINE, "Was interrupted while sending unavailable presence. Continuing to disconnect the connection", (Throwable) e2);
            }
            shutdown();
            callConnectionClosedListener();
        } else {
            shutdown();
            callConnectionClosedListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyConnectionError(final Exception exc) {
        synchronized (this.notifyConnectionErrorMonitor) {
            if (!isConnected()) {
                LOGGER.log(Level.INFO, "Connection was already disconnected when attempting to handle " + exc, (Throwable) exc);
                return;
            }
            setCurrentConnectionExceptionAndNotify(exc);
            instantShutdown();
            Iterator<StanzaCollector> it = this.collectors.iterator();
            while (it.hasNext()) {
                it.next().notifyConnectionError(exc);
            }
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14188x48ac5b73(exc);
                }
            }, this + " callConnectionClosedOnErrorListener()");
        }
    }

    /* JADX INFO: renamed from: lambda$waitForClosingStreamTagFromServer$6$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14189x26cb7e59() {
        return Boolean.valueOf(this.closingStreamReceived);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean waitForClosingStreamTagFromServer() {
        try {
            waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda6
                @Override // org.jivesoftware.smack.util.Supplier
                public final Object get() {
                    return this.f$0.m14189x26cb7e59();
                }
            }, "closing stream tag from the server");
            return true;
        } catch (InterruptedException | SmackException | XMPPException e2) {
            LOGGER.log(Level.INFO, "Exception while waiting for closing stream element from the server " + this, e2);
            return false;
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener == null) {
            return;
        }
        this.connectionListeners.add(connectionListener);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removeConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.remove(connectionListener);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public <I extends IQ> I sendIqRequestAndWaitForResponse(IQ iq) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return (I) createStanzaCollectorAndSend(iq).nextResultOrThrow();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public StanzaCollector createStanzaCollectorAndSend(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        return createStanzaCollectorAndSend(new IQReplyFilter(iq, this), iq);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public StanzaCollector createStanzaCollectorAndSend(StanzaFilter stanzaFilter, Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        StanzaCollector stanzaCollectorCreateStanzaCollector = createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(stanzaFilter).setRequest(stanza));
        try {
            sendStanza(stanza);
            return stanzaCollectorCreateStanzaCollector;
        } catch (InterruptedException | RuntimeException | SmackException.NotConnectedException e2) {
            stanzaCollectorCreateStanzaCollector.cancel();
            throw e2;
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public StanzaCollector createStanzaCollector(StanzaFilter stanzaFilter) {
        return createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(stanzaFilter));
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public StanzaCollector createStanzaCollector(StanzaCollector.Configuration configuration) {
        StanzaCollector stanzaCollector = new StanzaCollector(this, configuration);
        this.collectors.add(stanzaCollector);
        return stanzaCollector;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removeStanzaCollector(StanzaCollector stanzaCollector) {
        this.collectors.remove(stanzaCollector);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final void addStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener == null) {
            throw new NullPointerException("Given stanza listener must not be null");
        }
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.recvListeners) {
            this.recvListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean removeStanzaListener(StanzaListener stanzaListener) {
        boolean z;
        synchronized (this.recvListeners) {
            z = this.recvListeners.remove(stanzaListener) != null;
        }
        return z;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addSyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.syncRecvListeners) {
            this.syncRecvListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean removeSyncStanzaListener(StanzaListener stanzaListener) {
        boolean z;
        synchronized (this.syncRecvListeners) {
            z = this.syncRecvListeners.remove(stanzaListener) != null;
        }
        return z;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addAsyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.asyncRecvListeners) {
            this.asyncRecvListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean removeAsyncStanzaListener(StanzaListener stanzaListener) {
        boolean z;
        synchronized (this.asyncRecvListeners) {
            z = this.asyncRecvListeners.remove(stanzaListener) != null;
        }
        return z;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addStanzaSendingListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.sendListeners) {
            this.sendListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removeStanzaSendingListener(StanzaListener stanzaListener) {
        synchronized (this.sendListeners) {
            this.sendListeners.remove(stanzaListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void firePacketSendingListeners(TopLevelStreamElement topLevelStreamElement) {
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.onOutgoingStreamElement(topLevelStreamElement);
        }
        if (topLevelStreamElement instanceof Stanza) {
            final Stanza stanza = (Stanza) topLevelStreamElement;
            final LinkedList linkedList = new LinkedList();
            synchronized (this.sendListeners) {
                for (ListenerWrapper listenerWrapper : this.sendListeners.values()) {
                    if (listenerWrapper.filterMatches(stanza)) {
                        linkedList.add(listenerWrapper.getListener());
                    }
                }
            }
            if (linkedList.isEmpty()) {
                return;
            }
            asyncGo(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        try {
                            ((StanzaListener) it.next()).processStanza(stanza);
                        } catch (Exception e2) {
                            AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Sending listener threw exception", (Throwable) e2);
                        }
                    }
                }
            });
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    @Deprecated
    public void addStanzaInterceptor(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        if (stanzaListener == null) {
            throw new NullPointerException("Packet interceptor is null.");
        }
        InterceptorWrapper interceptorWrapper = new InterceptorWrapper(stanzaListener, stanzaFilter);
        synchronized (this.interceptors) {
            this.interceptors.put(stanzaListener, interceptorWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    @Deprecated
    public void removeStanzaInterceptor(StanzaListener stanzaListener) {
        synchronized (this.interceptors) {
            this.interceptors.remove(stanzaListener);
        }
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> void addInterceptor(Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map, Consumer<MPB> consumer, Predicate<MP> predicate) {
        Objects.requireNonNull(consumer, "Interceptor must not be null");
        GenericInterceptorWrapper<MPB, MP> genericInterceptorWrapper = new GenericInterceptorWrapper<>(consumer, predicate);
        synchronized (map) {
            map.put(consumer, genericInterceptorWrapper);
        }
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> void removeInterceptor(Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map, Consumer<MPB> consumer) {
        synchronized (map) {
            map.remove(consumer);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addMessageInterceptor(Consumer<MessageBuilder> consumer, Predicate<Message> predicate) {
        addInterceptor(this.messageInterceptors, consumer, predicate);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removeMessageInterceptor(Consumer<MessageBuilder> consumer) {
        removeInterceptor(this.messageInterceptors, consumer);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addPresenceInterceptor(Consumer<PresenceBuilder> consumer, Predicate<Presence> predicate) {
        addInterceptor(this.presenceInterceptors, consumer, predicate);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removePresenceInterceptor(Consumer<PresenceBuilder> consumer) {
        removeInterceptor(this.presenceInterceptors, consumer);
    }

    private static <MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> MP fireMessageOrPresenceInterceptors(MP mp, Map<Consumer<MPB>, GenericInterceptorWrapper<MPB, MP>> map) {
        LinkedList linkedList = new LinkedList();
        synchronized (map) {
            for (GenericInterceptorWrapper<MPB, MP> genericInterceptorWrapper : map.values()) {
                if (genericInterceptorWrapper.filterMatches(mp)) {
                    linkedList.add(genericInterceptorWrapper.getInterceptor());
                }
            }
        }
        if (linkedList.isEmpty()) {
            return mp;
        }
        MessageOrPresenceBuilder messageOrPresenceBuilderAsBuilder = mp.asBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(messageOrPresenceBuilderAsBuilder);
        }
        return (MP) messageOrPresenceBuilderAsBuilder.build();
    }

    private Stanza firePacketInterceptors(Stanza stanza) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.interceptors) {
            for (InterceptorWrapper interceptorWrapper : this.interceptors.values()) {
                if (interceptorWrapper.filterMatches(stanza)) {
                    linkedList.add(interceptorWrapper.getInterceptor());
                }
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            try {
                ((StanzaListener) it.next()).processStanza(stanza);
            } catch (Exception e2) {
                LOGGER.log(Level.SEVERE, "Packet interceptor threw exception", (Throwable) e2);
            }
        }
        if (stanza instanceof Message) {
            return fireMessageOrPresenceInterceptors((Message) stanza, this.messageInterceptors);
        }
        return stanza instanceof Presence ? fireMessageOrPresenceInterceptors((Presence) stanza, this.presenceInterceptors) : stanza;
    }

    protected void initDebugger() {
        Reader reader = this.reader;
        if (reader == null || this.writer == null) {
            throw new NullPointerException("Reader or writer isn't initialized.");
        }
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            this.reader = smackDebugger.newConnectionReader(reader);
            this.writer = this.debugger.newConnectionWriter(this.writer);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public long getReplyTimeout() {
        return this.replyTimeout;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void setReplyTimeout(long j) {
        if (Long.MAX_VALUE - System.currentTimeMillis() < j) {
            throw new IllegalArgumentException("Extremely long reply timeout");
        }
        this.replyTimeout = j;
    }

    public void setUnknownIqRequestReplyMode(SmackConfiguration.UnknownIqRequestReplyMode unknownIqRequestReplyMode) {
        this.unknownIqRequestReplyMode = (SmackConfiguration.UnknownIqRequestReplyMode) Objects.requireNonNull(unknownIqRequestReplyMode, "Mode must not be null");
    }

    protected final NonzaCallback.Builder buildNonzaCallback() {
        return new NonzaCallback.Builder(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.FailedNonzaException {
        return (SN) NonzaCallback.sendAndWaitForResponse(buildNonzaCallback(), nonza, cls, cls2);
    }

    private void maybeNotifyDebuggerAboutIncoming(TopLevelStreamElement topLevelStreamElement) {
        SmackDebugger smackDebugger = this.debugger;
        if (smackDebugger != null) {
            smackDebugger.onIncomingStreamElement(topLevelStreamElement);
        }
    }

    protected final void parseAndProcessNonza(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        ArrayList arrayListNewListWith;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        QName qName = new QName(xmlPullParser.getNamespace(), xmlPullParser.getName());
        NonzaProvider<? extends Nonza> nonzaProvider = ProviderManager.getNonzaProvider(qName);
        if (nonzaProvider == null) {
            LOGGER.severe("Unknown nonza: " + qName);
            ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
            return;
        }
        synchronized (this.nonzaCallbacksMap) {
            arrayListNewListWith = CollectionUtil.newListWith(this.nonzaCallbacksMap.getAll(qName));
        }
        if (arrayListNewListWith == null) {
            LOGGER.info("No nonza callback for " + qName);
            ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
            return;
        }
        Nonza nonza = nonzaProvider.parse(xmlPullParser, this.incomingStreamXmlEnvironment);
        maybeNotifyDebuggerAboutIncoming(nonza);
        Iterator it = arrayListNewListWith.iterator();
        while (it.hasNext()) {
            ((NonzaCallback) it.next()).onNonzaReceived(nonza);
        }
    }

    protected void parseAndProcessStanza(XmlPullParser xmlPullParser) throws XmlPullParserException, InterruptedException, IOException {
        Stanza stanza;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        try {
            stanza = PacketParserUtils.parseStanza(xmlPullParser, this.incomingStreamXmlEnvironment);
        } catch (IOException | IllegalArgumentException | SmackParsingException | XmlPullParserException e2) {
            UnparseableStanza unparseableStanza = new UnparseableStanza(PacketParserUtils.parseContentDepth(xmlPullParser, depth), e2);
            ParsingExceptionCallback parsingExceptionCallback = getParsingExceptionCallback();
            if (parsingExceptionCallback != null) {
                parsingExceptionCallback.handleUnparsableStanza(unparseableStanza);
            }
            stanza = null;
        }
        ParserUtils.assertAtEndTag(xmlPullParser);
        if (stanza != null) {
            processStanza(stanza);
        }
    }

    protected void processStanza(Stanza stanza) throws InterruptedException {
        maybeNotifyDebuggerAboutIncoming(stanza);
        this.lastStanzaReceived = System.currentTimeMillis();
        invokeStanzaCollectorsAndNotifyRecvListeners(stanza);
    }

    protected void invokeStanzaCollectorsAndNotifyRecvListeners(final Stanza stanza) {
        final IQRequestHandler iQRequestHandler;
        Executor executorAsExecutorFor;
        StanzaError.Condition condition;
        if (stanza instanceof IQ) {
            final IQ iq = (IQ) stanza;
            if (iq.isRequestIQ()) {
                QName childElementQName = iq.getChildElementQName();
                int i = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[iq.getType().ordinal()];
                if (i == 1) {
                    synchronized (this.setIqRequestHandler) {
                        iQRequestHandler = this.setIqRequestHandler.get(childElementQName);
                    }
                } else if (i == 2) {
                    synchronized (this.getIqRequestHandler) {
                        iQRequestHandler = this.getIqRequestHandler.get(childElementQName);
                    }
                } else {
                    throw new IllegalStateException("Should only encounter IQ type 'get' or 'set'");
                }
                if (iQRequestHandler == null) {
                    int i2 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode[this.unknownIqRequestReplyMode.ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            condition = StanzaError.Condition.feature_not_implemented;
                        } else if (i2 == 3) {
                            condition = StanzaError.Condition.service_unavailable;
                        } else {
                            throw new AssertionError();
                        }
                        final ErrorIQ errorIQCreateErrorResponse = IQ.createErrorResponse(iq, StanzaError.getBuilder(condition).build());
                        asyncGo(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda7
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m14184x8b92e63a(errorIQCreateErrorResponse);
                            }
                        });
                        return;
                    }
                    return;
                }
                int i3 = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode[iQRequestHandler.getMode().ordinal()];
                if (i3 == 1) {
                    executorAsExecutorFor = ASYNC_BUT_ORDERED.asExecutorFor(this);
                } else {
                    executorAsExecutorFor = i3 != 2 ? null : new Executor() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda8
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            this.f$0.asyncGoLimited(runnable);
                        }
                    };
                }
                executorAsExecutorFor.execute(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.3
                    static final /* synthetic */ boolean $assertionsDisabled = false;

                    @Override // java.lang.Runnable
                    public void run() {
                        IQ iqHandleIQRequest = iQRequestHandler.handleIQRequest(iq);
                        if (iqHandleIQRequest == null) {
                            return;
                        }
                        iqHandleIQRequest.setTo(iq.getFrom());
                        iqHandleIQRequest.setStanzaId(iq.getStanzaId());
                        try {
                            AbstractXMPPConnection.this.sendStanza(iqHandleIQRequest);
                        } catch (InterruptedException | SmackException.NotConnectedException e2) {
                            AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Exception while sending response to IQ request", e2);
                        }
                    }
                });
                return;
            }
        }
        final LinkedList<StanzaListener> linkedList = new LinkedList();
        extractMatchingListeners(stanza, this.asyncRecvListeners, linkedList);
        for (final StanzaListener stanzaListener : linkedList) {
            asyncGoLimited(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        stanzaListener.processStanza(stanza);
                    } catch (Exception e2) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in async packet listener", (Throwable) e2);
                    }
                }
            });
        }
        Iterator<StanzaCollector> it = this.collectors.iterator();
        while (it.hasNext()) {
            it.next().processStanza(stanza);
        }
        linkedList.clear();
        extractMatchingListeners(stanza, this.recvListeners, linkedList);
        for (final StanzaListener stanzaListener2 : linkedList) {
            this.inOrderListeners.performAsyncButOrdered(stanzaListener2, new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractXMPPConnection.lambda$invokeStanzaCollectorsAndNotifyRecvListeners$8(stanzaListener2, stanza);
                }
            });
        }
        linkedList.clear();
        extractMatchingListeners(stanza, this.syncRecvListeners, linkedList);
        ASYNC_BUT_ORDERED.performAsyncButOrdered(this, new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = linkedList.iterator();
                synchronized (AbstractXMPPConnection.this.syncRecvListeners) {
                    while (it2.hasNext()) {
                        if (!AbstractXMPPConnection.this.syncRecvListeners.containsKey((StanzaListener) it2.next())) {
                            it2.remove();
                        }
                    }
                }
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    try {
                        ((StanzaListener) it3.next()).processStanza(stanza);
                    } catch (SmackException.NotConnectedException e2) {
                        AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Got not connected exception, aborting", (Throwable) e2);
                        return;
                    } catch (Exception e3) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in packet listener", (Throwable) e3);
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$invokeStanzaCollectorsAndNotifyRecvListeners$7$org-jivesoftware-smack-AbstractXMPPConnection, reason: not valid java name */
    /* synthetic */ void m14184x8b92e63a(ErrorIQ errorIQ) {
        try {
            sendStanza(errorIQ);
        } catch (InterruptedException | SmackException.NotConnectedException e2) {
            LOGGER.log(Level.WARNING, "Exception while sending error IQ to unkown IQ request", e2);
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.AbstractXMPPConnection$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQRequestHandler.Mode.values().length];
            $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode = iArr;
            try {
                iArr[IQRequestHandler.Mode.sync.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode[IQRequestHandler.Mode.async.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SmackConfiguration.UnknownIqRequestReplyMode.values().length];
            $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode = iArr2;
            try {
                iArr2[SmackConfiguration.UnknownIqRequestReplyMode.doNotReply.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode[SmackConfiguration.UnknownIqRequestReplyMode.replyFeatureNotImplemented.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$SmackConfiguration$UnknownIqRequestReplyMode[SmackConfiguration.UnknownIqRequestReplyMode.replyServiceUnavailable.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr3;
            try {
                iArr3[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.get.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[XMPPConnection.FromMode.values().length];
            $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode = iArr4;
            try {
                iArr4[XMPPConnection.FromMode.OMITTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[XMPPConnection.FromMode.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[XMPPConnection.FromMode.UNCHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static /* synthetic */ void lambda$invokeStanzaCollectorsAndNotifyRecvListeners$8(StanzaListener stanzaListener, Stanza stanza) {
        try {
            stanzaListener.processStanza(stanza);
        } catch (SmackException.NotConnectedException e2) {
            LOGGER.log(Level.WARNING, "Got not connected exception, aborting", (Throwable) e2);
        } catch (Exception e3) {
            LOGGER.log(Level.SEVERE, "Exception in packet listener", (Throwable) e3);
        }
    }

    private static void extractMatchingListeners(Stanza stanza, Map<StanzaListener, ListenerWrapper> map, Collection<StanzaListener> collection) {
        synchronized (map) {
            for (ListenerWrapper listenerWrapper : map.values()) {
                if (listenerWrapper.filterMatches(stanza)) {
                    collection.add(listenerWrapper.getListener());
                }
            }
        }
    }

    protected void setWasAuthenticated() {
        if (this.wasAuthenticated) {
            return;
        }
        this.wasAuthenticated = this.authenticated;
    }

    protected void callConnectionConnectingListener() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            it.next().connecting(this);
        }
    }

    protected void callConnectionConnectedListener() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            it.next().connected(this);
        }
    }

    protected void callConnectionAuthenticatedListener(boolean z) {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().authenticated(this, z);
            } catch (Exception e2) {
                LOGGER.log(Level.SEVERE, "Exception in authenticated listener", (Throwable) e2);
            }
        }
    }

    void callConnectionClosedListener() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().connectionClosed();
            } catch (Exception e2) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", (Throwable) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: callConnectionClosedOnErrorListener, reason: merged with bridge method [inline-methods] */
    public void m14188x48ac5b73(Exception exc) {
        if ((exc instanceof XMPPException.StreamErrorException) && ((XMPPException.StreamErrorException) exc).getStreamError().getCondition() == StreamError.Condition.not_authorized && this.wasAuthenticated) {
            LOGGER.log(Level.FINE, "Connection closed with not-authorized stream error after it was already authenticated. The account was likely deleted/unregistered on the server");
        } else {
            LOGGER.log(Level.WARNING, "Connection " + this + " closed with error", (Throwable) exc);
        }
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().connectionClosedOnError(exc);
            } catch (Exception e2) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", (Throwable) e2);
            }
        }
    }

    protected static class ListenerWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetListener;

        public ListenerWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetListener = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getListener() {
            return this.packetListener;
        }
    }

    @Deprecated
    protected static class InterceptorWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetInterceptor;

        public InterceptorWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetInterceptor = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getInterceptor() {
            return this.packetInterceptor;
        }
    }

    private static final class GenericInterceptorWrapper<MPB extends MessageOrPresenceBuilder<MP, MPB>, MP extends MessageOrPresence<MPB>> {
        private final Predicate<MP> stanzaFilter;
        private final Consumer<MPB> stanzaInterceptor;

        private GenericInterceptorWrapper(Consumer<MPB> consumer, Predicate<MP> predicate) {
            this.stanzaInterceptor = consumer;
            this.stanzaFilter = predicate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean filterMatches(MP mp) {
            Predicate<MP> predicate = this.stanzaFilter;
            return predicate == null || predicate.test(mp);
        }

        public Consumer<MPB> getInterceptor() {
            return this.stanzaInterceptor;
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public int getConnectionCounter() {
        return this.connectionCounterValue;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void setFromMode(XMPPConnection.FromMode fromMode) {
        this.fromMode = fromMode;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public XMPPConnection.FromMode getFromMode() {
        return this.fromMode;
    }

    protected final void parseFeatures(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        String name;
        String namespace;
        ExtensionElement mechanisms;
        this.streamFeatures.clear();
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getDepth() == depth + 1) {
                name = xmlPullParser.getName();
                namespace = xmlPullParser.getNamespace();
                name.hashCode();
                switch (name) {
                    case "mechanisms":
                        mechanisms = new Mechanisms(PacketParserUtils.parseMechanisms(xmlPullParser));
                        break;
                    case "bind":
                        mechanisms = Bind.Feature.INSTANCE;
                        break;
                    case "starttls":
                        mechanisms = PacketParserUtils.parseStartTlsFeature(xmlPullParser);
                        break;
                    case "compression":
                        mechanisms = PacketParserUtils.parseCompressionFeature(xmlPullParser);
                        break;
                    case "session":
                        mechanisms = PacketParserUtils.parseSessionFeature(xmlPullParser);
                        break;
                    default:
                        ExtensionElementProvider<ExtensionElement> streamFeatureProvider = ProviderManager.getStreamFeatureProvider(name, namespace);
                        if (streamFeatureProvider == null) {
                            mechanisms = null;
                            break;
                        } else {
                            mechanisms = streamFeatureProvider.parse(xmlPullParser, this.incomingStreamXmlEnvironment);
                            break;
                        }
                        break;
                }
                if (mechanisms != null) {
                    addStreamFeature(mechanisms);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    protected final void parseFeaturesAndNotify(XmlPullParser xmlPullParser) throws Exception {
        parseFeatures(xmlPullParser);
        if (hasFeature(Mechanisms.ELEMENT, "urn:ietf:params:xml:ns:xmpp-sasl") && (!hasFeature(StartTls.ELEMENT, "urn:ietf:params:xml:ns:xmpp-tls") || this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled)) {
            this.saslFeatureReceived = true;
            this.tlsHandled = true;
            notifyWaitingThreads();
        }
        if (hasFeature(Bind.ELEMENT, Bind.NAMESPACE) && (!hasFeature(Compress.Feature.ELEMENT, "http://jabber.org/protocol/compress") || !this.config.isCompressionEnabled())) {
            this.lastFeaturesReceived = true;
            notifyWaitingThreads();
        }
        afterFeaturesReceived();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public <F extends FullyQualifiedElement> F getFeature(QName qName) {
        return (F) this.streamFeatures.get(qName);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean hasFeature(QName qName) {
        return this.streamFeatures.containsKey(qName);
    }

    protected void addStreamFeature(FullyQualifiedElement fullyQualifiedElement) {
        this.streamFeatures.put(fullyQualifiedElement.getQName(), fullyQualifiedElement);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq) {
        return sendIqRequestAsync(iq, getReplyTimeout());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq, long j) {
        return sendAsync(iq, new IQReplyFilter(iq, this), j);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s, StanzaFilter stanzaFilter) {
        return sendAsync(s, stanzaFilter, getReplyTimeout());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s, final StanzaFilter stanzaFilter, long j) {
        Objects.requireNonNull(s, "stanza must not be null");
        Objects.requireNonNull(stanzaFilter, "replyFilter must not be null");
        final SmackFuture.InternalSmackFuture internalSmackFuture = new SmackFuture.InternalSmackFuture();
        final StanzaListener stanzaListener = new StanzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.6
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                if (AbstractXMPPConnection.this.removeAsyncStanzaListener(this)) {
                    try {
                        XMPPException.XMPPErrorException.ifHasErrorThenThrow(stanza);
                        internalSmackFuture.setResult(stanza);
                    } catch (XMPPException.XMPPErrorException e2) {
                        internalSmackFuture.setException(e2);
                    }
                }
            }
        };
        schedule(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.7
            @Override // java.lang.Runnable
            public void run() {
                SmackException smackExceptionNewWith;
                if (AbstractXMPPConnection.this.removeAsyncStanzaListener(stanzaListener)) {
                    if (!AbstractXMPPConnection.this.isConnected()) {
                        smackExceptionNewWith = new SmackException.NotConnectedException(AbstractXMPPConnection.this, stanzaFilter);
                    } else {
                        smackExceptionNewWith = SmackException.NoResponseException.newWith(AbstractXMPPConnection.this, stanzaFilter);
                    }
                    internalSmackFuture.setException(smackExceptionNewWith);
                }
            }
        }, j, TimeUnit.MILLISECONDS);
        addAsyncStanzaListener(stanzaListener, stanzaFilter);
        try {
            sendStanza(s);
            return internalSmackFuture;
        } catch (InterruptedException | SmackException.NotConnectedException e2) {
            internalSmackFuture.setException(e2);
            return internalSmackFuture;
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addOneTimeSyncCallback(final StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        final StanzaListener stanzaListener2 = new StanzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.8
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                try {
                    stanzaListener.processStanza(stanza);
                } finally {
                    AbstractXMPPConnection.this.removeSyncStanzaListener(this);
                }
            }
        };
        addSyncStanzaListener(stanzaListener2, stanzaFilter);
        schedule(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.9
            @Override // java.lang.Runnable
            public void run() {
                AbstractXMPPConnection.this.removeSyncStanzaListener(stanzaListener2);
            }
        }, getReplyTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public IQRequestHandler registerIQRequestHandler(IQRequestHandler iQRequestHandler) {
        IQRequestHandler iQRequestHandlerPut;
        IQRequestHandler iQRequestHandlerPut2;
        QName qName = iQRequestHandler.getQName();
        int i = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[iQRequestHandler.getType().ordinal()];
        if (i == 1) {
            synchronized (this.setIqRequestHandler) {
                iQRequestHandlerPut = this.setIqRequestHandler.put(qName, iQRequestHandler);
            }
            return iQRequestHandlerPut;
        }
        if (i == 2) {
            synchronized (this.getIqRequestHandler) {
                iQRequestHandlerPut2 = this.getIqRequestHandler.put(qName, iQRequestHandler);
            }
            return iQRequestHandlerPut2;
        }
        throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final IQRequestHandler unregisterIQRequestHandler(IQRequestHandler iQRequestHandler) {
        return unregisterIQRequestHandler(iQRequestHandler.getElement(), iQRequestHandler.getNamespace(), iQRequestHandler.getType());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public IQRequestHandler unregisterIQRequestHandler(String str, String str2, IQ.Type type) {
        IQRequestHandler iQRequestHandlerRemove;
        IQRequestHandler iQRequestHandlerRemove2;
        QName qName = new QName(str2, str);
        int i = AnonymousClass11.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type.ordinal()];
        if (i == 1) {
            synchronized (this.setIqRequestHandler) {
                iQRequestHandlerRemove = this.setIqRequestHandler.remove(qName);
            }
            return iQRequestHandlerRemove;
        }
        if (i == 2) {
            synchronized (this.getIqRequestHandler) {
                iQRequestHandlerRemove2 = this.getIqRequestHandler.remove(qName);
            }
            return iQRequestHandlerRemove2;
        }
        throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public long getLastStanzaReceived() {
        return this.lastStanzaReceived;
    }

    public final long getAuthenticatedConnectionInitiallyEstablishedTimestamp() {
        return this.authenticatedConnectionInitiallyEstablishedTimestamp;
    }

    public void setParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback) {
        this.parsingExceptionCallback = parsingExceptionCallback;
    }

    public ParsingExceptionCallback getParsingExceptionCallback() {
        return this.parsingExceptionCallback;
    }

    public final String toString() {
        EntityFullJid user = getUser();
        return getClass().getSimpleName() + '[' + (user == null ? "not-authenticated" : user.toString()) + "] (" + getConnectionCounter() + ')';
    }

    protected void asyncGoLimited(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.10
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                synchronized (AbstractXMPPConnection.this.deferredAsyncRunnables) {
                    Runnable runnable3 = (Runnable) AbstractXMPPConnection.this.deferredAsyncRunnables.poll();
                    if (runnable3 == null) {
                        AbstractXMPPConnection.access$510(AbstractXMPPConnection.this);
                    } else {
                        AbstractXMPPConnection.access$610(AbstractXMPPConnection.this);
                        AbstractXMPPConnection.asyncGo(runnable3);
                    }
                }
            }
        };
        synchronized (this.deferredAsyncRunnables) {
            int i = this.currentAsyncRunnables;
            if (i < this.maxAsyncRunnables) {
                this.currentAsyncRunnables = i + 1;
                asyncGo(runnable2);
            } else {
                this.deferredAsyncRunnablesCount++;
                this.deferredAsyncRunnables.add(runnable2);
            }
            int i2 = this.deferredAsyncRunnablesCount;
            if (i2 >= 100 && this.deferredAsyncRunnablesCountPrevious < 100) {
                LOGGER.log(Level.WARNING, "High watermark of 100 simultaneous executing runnables reached");
            } else if (i2 >= 20 && this.deferredAsyncRunnablesCountPrevious < 20) {
                LOGGER.log(Level.INFO, "20 simultaneous executing runnables reached");
            }
            this.deferredAsyncRunnablesCountPrevious = i2;
        }
    }

    public void setMaxAsyncOperations(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Max async operations must be greater than 0");
        }
        synchronized (this.deferredAsyncRunnables) {
            this.maxAsyncRunnables = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void asyncGo(Runnable runnable) {
        CACHED_EXECUTOR_SERVICE.execute(runnable);
    }

    protected final SmackReactor getReactor() {
        return SMACK_REACTOR;
    }

    protected static ScheduledAction schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return SMACK_REACTOR.schedule(runnable, j, timeUnit, ScheduledAction.Kind.NonBlocking);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStreamOpen(XmlPullParser xmlPullParser) {
        if ("jabber:client".equals(xmlPullParser.getNamespace(null))) {
            this.streamId = xmlPullParser.getAttributeValue("", "id");
            this.incomingStreamXmlEnvironment = XmlEnvironment.from(xmlPullParser);
            String attributeValue = xmlPullParser.getAttributeValue("", "from");
            if (attributeValue == null) {
                return;
            }
            try {
                DomainBareJid domainBareJidDomainBareFrom = JidCreate.domainBareFrom(attributeValue);
                DomainBareJid xMPPServiceDomain = this.config.getXMPPServiceDomain();
                if (xMPPServiceDomain.equals((CharSequence) domainBareJidDomainBareFrom)) {
                    return;
                }
                LOGGER.warning("Domain reported by server '" + ((Object) domainBareJidDomainBareFrom) + "' does not match configured domain '" + ((Object) xMPPServiceDomain) + "'");
            } catch (XmppStringprepException e2) {
                LOGGER.log(Level.WARNING, "XMPP service domain '" + attributeValue + "' as reported by server could not be transformed to a valid JID", (Throwable) e2);
            }
        }
    }

    protected void sendStreamOpen() throws SmackException.NotConnectedException, InterruptedException {
        DomainBareJid xMPPServiceDomain = getXMPPServiceDomain();
        CharSequence username = this.config.getUsername();
        StreamOpen streamOpen = new StreamOpen(xMPPServiceDomain, username != null ? XmppStringUtils.completeJidFrom(username, xMPPServiceDomain) : null, getStreamId(), this.config.getXmlLang(), StreamOpen.StreamContentNamespace.client);
        sendNonza(streamOpen);
        XmlEnvironment.Builder builder = XmlEnvironment.builder();
        builder.with(streamOpen);
        this.outgoingStreamXmlEnvironment = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmackTlsContext getSmackTlsContext() {
        return this.config.smackTlsContext;
    }
}
