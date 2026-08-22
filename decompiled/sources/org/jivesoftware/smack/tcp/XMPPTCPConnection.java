package org.jivesoftware.smack.tcp;

import androidx.collection.SieveCacheKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.NonzaCallback;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.sm.SMUtils;
import org.jivesoftware.smack.sm.StreamManagementException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.sm.predicates.Predicate;
import org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;
import org.jivesoftware.smack.xml.SmackXmlParser;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.minidns.dnsname.DnsName;

/* JADX INFO: loaded from: classes10.dex */
public class XMPPTCPConnection extends AbstractXMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int QUEUE_SIZE = 500;
    private static BundleAndDeferCallback defaultBundleAndDeferCallback;
    private BundleAndDeferCallback bundleAndDeferCallback;
    private long clientHandledStanzasCount;
    private boolean compressSyncPoint;
    private final XMPPTCPConnectionConfiguration config;
    private boolean disconnectedButResumeable;
    protected final PacketReader packetReader;
    protected final PacketWriter packetWriter;
    private final Set<StanzaFilter> requestAckPredicates;
    private SSLSocket secureSocket;
    private long serverHandledStanzasCount;
    private int smClientMaxResumptionTime;
    private volatile boolean smEnabledSyncPoint;
    private volatile AbstractXMPPConnection.SyncPointState smResumedSyncPoint;
    private StreamManagement.Failed smResumptionFailed;
    private int smServerMaxResumptionTime;
    private String smSessionId;
    private boolean smWasEnabledAtLeastOnce;
    private Socket socket;
    private final Collection<StanzaListener> stanzaAcknowledgedListeners;
    private final Collection<StanzaListener> stanzaDroppedListeners;
    private final Map<String, StanzaListener> stanzaIdAcknowledgedListeners;
    private boolean streamFeaturesAfterAuthenticationReceived;
    private BlockingQueue<Stanza> unacknowledgedStanzas;
    private boolean useSm;
    private boolean useSmResumption;
    private static final Logger LOGGER = Logger.getLogger(XMPPTCPConnection.class.getName());
    private static boolean useSmDefault = true;
    private static boolean useSmResumptionDefault = true;

    public XMPPTCPConnection(XMPPTCPConnectionConfiguration xMPPTCPConnectionConfiguration) {
        super(xMPPTCPConnectionConfiguration);
        this.disconnectedButResumeable = false;
        this.packetWriter = new PacketWriter();
        this.packetReader = new PacketReader();
        this.bundleAndDeferCallback = defaultBundleAndDeferCallback;
        this.smClientMaxResumptionTime = -1;
        this.smServerMaxResumptionTime = -1;
        this.useSm = useSmDefault;
        this.useSmResumption = useSmResumptionDefault;
        this.serverHandledStanzasCount = 0L;
        this.clientHandledStanzasCount = 0L;
        this.smWasEnabledAtLeastOnce = false;
        this.stanzaAcknowledgedListeners = new ConcurrentLinkedQueue();
        this.stanzaDroppedListeners = new ConcurrentLinkedQueue();
        this.stanzaIdAcknowledgedListeners = new ConcurrentHashMap();
        this.requestAckPredicates = new LinkedHashSet();
        this.config = xMPPTCPConnectionConfiguration;
        addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.1
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception exc) {
                if ((exc instanceof XMPPException.StreamErrorException) || (exc instanceof StreamManagementException)) {
                    XMPPTCPConnection.this.dropSmState();
                }
            }
        });
        buildNonzaCallback().listenFor(SaslNonza.Success.class, new NonzaCallback.NonzaListener() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
            public final void accept(Nonza nonza) throws IOException {
                this.f$0.m14219lambda$new$0$orgjivesoftwaresmacktcpXMPPTCPConnection((SaslNonza.Success) nonza);
            }
        }).install();
    }

    /* JADX INFO: renamed from: lambda$new$0$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ void m14219lambda$new$0$orgjivesoftwaresmacktcpXMPPTCPConnection(SaslNonza.Success success) throws IOException {
        resetParser();
    }

    public XMPPTCPConnection(CharSequence charSequence, String str) throws XmppStringprepException {
        this(XMPPTCPConnectionConfiguration.builder().setXmppAddressAndPassword(charSequence, str).build());
    }

    public XMPPTCPConnection(CharSequence charSequence, String str, String str2) throws XmppStringprepException {
        this(XMPPTCPConnectionConfiguration.builder().setUsernameAndPassword(charSequence, str).setXmppDomain(JidCreate.domainBareFrom(str2)).build());
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        PacketWriter packetWriter = this.packetWriter;
        if (packetWriter == null) {
            throw new SmackException.NotConnectedException();
        }
        packetWriter.throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void afterSuccessfulLogin(boolean z) throws SmackException.NotConnectedException, InterruptedException {
        this.disconnectedButResumeable = false;
        super.afterSuccessfulLogin(z);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected synchronized void loginInternal(String str, String str2, Resourcepart resourcepart) throws SmackException, InterruptedException, IOException, XMPPException {
        SSLSocket sSLSocket = this.secureSocket;
        SSLSession session = sSLSocket != null ? sSLSocket.getSession() : null;
        this.streamFeaturesAfterAuthenticationReceived = false;
        authenticate(str, str2, this.config.getAuthzid(), session);
        waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda5
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14215x286f4df();
            }
        }, "compress features from server");
        maybeEnableCompression();
        this.smResumedSyncPoint = AbstractXMPPConnection.SyncPointState.initial;
        this.smResumptionFailed = null;
        if (isSmResumptionPossible()) {
            this.smResumedSyncPoint = AbstractXMPPConnection.SyncPointState.request_sent;
            sendNonza(new StreamManagement.Resume(this.clientHandledStanzasCount, this.smSessionId));
            waitForConditionOrConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda6
                @Override // org.jivesoftware.smack.util.Supplier
                public final Object get() {
                    return this.f$0.m14216xbbfe827e();
                }
            }, "resume previous stream");
            if (this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful) {
                afterSuccessfulLogin(true);
                return;
            }
            LOGGER.fine("Stream resumption failed, continuing with normal stream establishment process: " + this.smResumptionFailed);
        }
        this.smEnabledSyncPoint = false;
        LinkedList<Stanza> linkedList = new LinkedList();
        BlockingQueue<Stanza> blockingQueue = this.unacknowledgedStanzas;
        if (blockingQueue != null) {
            blockingQueue.drainTo(linkedList);
            dropSmState();
        }
        bindResourceAndEstablishSession(resourcepart);
        if (isSmAvailable() && this.useSm) {
            this.serverHandledStanzasCount = 0L;
            sendNonza(new StreamManagement.Enable(this.useSmResumption, this.smClientMaxResumptionTime));
            waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda7
                @Override // org.jivesoftware.smack.util.Supplier
                public final Object get() {
                    return this.f$0.m14217x7576101d();
                }
            }, "enabling stream mangement");
            synchronized (this.requestAckPredicates) {
                if (this.requestAckPredicates.isEmpty()) {
                    this.requestAckPredicates.add(Predicate.forMessagesOrAfter5Stanzas());
                }
            }
        }
        if (!this.stanzaDroppedListeners.isEmpty()) {
            for (Stanza stanza : linkedList) {
                Iterator<StanzaListener> it = this.stanzaDroppedListeners.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().processStanza(stanza);
                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e2) {
                        LOGGER.log(Level.FINER, "StanzaDroppedListener received exception", e2);
                    }
                }
            }
        } else {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                sendStanzaInternal((Stanza) it2.next());
            }
        }
        afterSuccessfulLogin(false);
    }

    /* JADX INFO: renamed from: lambda$loginInternal$1$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14215x286f4df() {
        return Boolean.valueOf(this.streamFeaturesAfterAuthenticationReceived);
    }

    /* JADX INFO: renamed from: lambda$loginInternal$2$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14216xbbfe827e() {
        return Boolean.valueOf(this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful || this.smResumptionFailed != null);
    }

    /* JADX INFO: renamed from: lambda$loginInternal$3$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14217x7576101d() {
        return Boolean.valueOf(this.smEnabledSyncPoint);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isSecureConnection() {
        return this.secureSocket != null;
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void shutdown() {
        if (isSmEnabled()) {
            try {
                sendSmAcknowledgementInternal();
            } catch (InterruptedException | SmackException.NotConnectedException e2) {
                LOGGER.log(Level.FINE, "Can not send final SM ack as connection is not connected", e2);
            }
        }
        shutdown(false);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public synchronized void instantShutdown() {
        shutdown(true);
    }

    private void shutdown(boolean z) {
        if (!this.packetWriter.done()) {
            Logger logger = LOGGER;
            logger.finer(this.packetWriter.threadName + " shutdown()");
            this.packetWriter.shutdown(z);
            logger.finer(this.packetWriter.threadName + " shutdown() returned");
            if (!z) {
                waitForClosingStreamTagFromServer();
            }
        }
        Logger logger2 = LOGGER;
        logger2.finer(this.packetReader.threadName + " shutdown()");
        this.packetReader.shutdown();
        logger2.finer(this.packetReader.threadName + " shutdown() returned");
        CloseableUtil.maybeClose(this.socket, logger2);
        setWasAuthenticated();
        try {
            if (!waitFor(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda4
                @Override // org.jivesoftware.smack.util.Supplier
                public final Object get() {
                    return this.f$0.m14220lambda$shutdown$4$orgjivesoftwaresmacktcpXMPPTCPConnection();
                }
            })) {
                logger2.severe("Reader and/or writer threads did not terminate timely. Writer running: " + this.packetWriter.running + ", Reader running: " + this.packetReader.running);
            } else {
                logger2.fine("Reader and writer threads terminated");
            }
        } catch (InterruptedException e2) {
            LOGGER.log(Level.FINE, "Interrupted while waiting for reader and writer threads to terminate", (Throwable) e2);
        }
        if (this.disconnectedButResumeable) {
            return;
        }
        if (z) {
            boolean zIsSmResumptionPossible = isSmResumptionPossible();
            this.disconnectedButResumeable = zIsSmResumptionPossible;
            if (!zIsSmResumptionPossible) {
                this.smSessionId = null;
            }
        } else {
            this.disconnectedButResumeable = false;
            dropSmState();
        }
        this.authenticated = false;
        this.connected = false;
        this.secureSocket = null;
        this.reader = null;
        this.writer = null;
        initState();
    }

    /* JADX INFO: renamed from: lambda$shutdown$4$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14220lambda$shutdown$4$orgjivesoftwaresmacktcpXMPPTCPConnection() {
        return Boolean.valueOf((this.packetWriter.running || this.packetReader.running) ? false : true);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(nonza);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(stanza);
        if (isSmEnabled()) {
            Iterator<StanzaFilter> it = this.requestAckPredicates.iterator();
            while (it.hasNext()) {
                if (it.next().accept(stanza)) {
                    requestSmAcknowledgementInternal();
                    return;
                }
            }
        }
    }

    private void connectUsingConfiguration() throws SmackException.ConnectionException, InterruptedException, IOException {
        ProxyInfo proxyInfo;
        SocketFactory socketFactory;
        Iterator it;
        RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> resultLookup = RemoteXmppTcpConnectionEndpoints.lookup(this.config);
        ArrayList arrayList = new ArrayList();
        SocketFactory socketFactory2 = this.config.getSocketFactory();
        ProxyInfo proxyInfo2 = this.config.getProxyInfo();
        int connectTimeout = this.config.getConnectTimeout();
        if (socketFactory2 == null) {
            socketFactory2 = SocketFactory.getDefault();
        }
        SocketFactory socketFactory3 = socketFactory2;
        Iterator it2 = resultLookup.discoveredRemoteConnectionEndpoints.iterator();
        while (it2.hasNext()) {
            Rfc6120TcpRemoteConnectionEndpoint rfc6120TcpRemoteConnectionEndpoint = (Rfc6120TcpRemoteConnectionEndpoint) it2.next();
            String string = rfc6120TcpRemoteConnectionEndpoint.getHost().toString();
            UInt16 port = rfc6120TcpRemoteConnectionEndpoint.getPort();
            int iIntValue = port.intValue();
            if (proxyInfo2 == null) {
                Iterator<? extends InetAddress> it3 = rfc6120TcpRemoteConnectionEndpoint.getInetAddresses().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        proxyInfo = proxyInfo2;
                        socketFactory = socketFactory3;
                        it = it2;
                        break;
                    }
                    SmackFuture.SocketFuture socketFuture = new SmackFuture.SocketFuture(socketFactory3);
                    InetAddress next = it3.next();
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(next, iIntValue);
                    proxyInfo = proxyInfo2;
                    Logger logger = LOGGER;
                    socketFactory = socketFactory3;
                    it = it2;
                    logger.finer("Trying to establish TCP connection to " + inetSocketAddress);
                    socketFuture.connectAsync(inetSocketAddress, connectTimeout);
                    try {
                        this.socket = socketFuture.getOrThrow();
                        logger.finer("Established TCP connection to " + inetSocketAddress);
                        this.host = string;
                        this.port = port;
                        return;
                    } catch (IOException e2) {
                        arrayList.add(new RemoteConnectionException(rfc6120TcpRemoteConnectionEndpoint, next, e2));
                        if (it3.hasNext()) {
                            proxyInfo2 = proxyInfo;
                            socketFactory3 = socketFactory;
                            it2 = it;
                        }
                    }
                }
            } else {
                proxyInfo = proxyInfo2;
                socketFactory = socketFactory3;
                it = it2;
                this.socket = socketFactory.createSocket();
                StringUtils.requireNotNullNorEmpty(string, "Host of endpoint " + rfc6120TcpRemoteConnectionEndpoint + " must not be null when using a Proxy");
                String str = string + " at port " + iIntValue;
                Logger logger2 = LOGGER;
                logger2.finer("Trying to establish TCP connection via Proxy to " + str);
                try {
                    proxyInfo.getProxySocketConnection().connect(this.socket, string, iIntValue, connectTimeout);
                    logger2.finer("Established TCP connection to " + str);
                    this.host = string;
                    this.port = port;
                    return;
                } catch (IOException e3) {
                    CloseableUtil.maybeClose(this.socket, LOGGER);
                    arrayList.add(new RemoteConnectionException(rfc6120TcpRemoteConnectionEndpoint, null, e3));
                }
            }
            proxyInfo2 = proxyInfo;
            socketFactory3 = socketFactory;
            it2 = it;
        }
        throw SmackException.EndpointConnectionException.from(resultLookup.lookupFailures, arrayList);
    }

    private void initConnection() throws InterruptedException, IOException {
        this.compressionHandler = null;
        initReaderAndWriter();
        this.packetWriter.init();
        this.packetReader.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReaderAndWriter() throws IOException {
        InputStream inputStream = this.socket.getInputStream();
        OutputStream outputStream = this.socket.getOutputStream();
        if (this.compressionHandler != null) {
            inputStream = this.compressionHandler.getInputStream(inputStream);
            outputStream = this.compressionHandler.getOutputStream(outputStream);
        }
        this.writer = new OutputStreamWriter(outputStream, "UTF-8");
        this.reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        initDebugger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proceedTLSReceived() throws SmackException.SecurityNotPossibleException, IOException, CertificateException {
        String string;
        SmackTlsContext smackTlsContext = getSmackTlsContext();
        Socket socket = this.socket;
        Socket socketCreateSocket = smackTlsContext.sslContext.getSocketFactory().createSocket(socket, this.config.getXMPPServiceDomain().toString(), socket.getPort(), true);
        this.socket = socketCreateSocket;
        SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
        TLSUtils.setEnabledProtocolsAndCiphers(sSLSocket, this.config.getEnabledSSLProtocols(), this.config.getEnabledSSLCiphers());
        initReaderAndWriter();
        sSLSocket.startHandshake();
        if (smackTlsContext.daneVerifier != null) {
            smackTlsContext.daneVerifier.finish(sSLSocket.getSession());
        }
        HostnameVerifier hostnameVerifier = getConfiguration().getHostnameVerifier();
        if (hostnameVerifier == null) {
            throw new IllegalStateException("No HostnameVerifier set. Use connectionConfiguration.setHostnameVerifier() to configure.");
        }
        DnsName xmppServiceDomainAsDnsNameIfPossible = getConfiguration().getXmppServiceDomainAsDnsNameIfPossible();
        if (xmppServiceDomainAsDnsNameIfPossible != null) {
            string = xmppServiceDomainAsDnsNameIfPossible.ace;
        } else {
            LOGGER.log(Level.WARNING, "XMPP service domain name '" + ((Object) getXMPPServiceDomain()) + "' can not be represented as DNS name. TLS X.509 certificate validiation may fail.");
            string = getXMPPServiceDomain().toString();
        }
        if (!hostnameVerifier.verify(string, sSLSocket.getSession())) {
            throw new CertificateException("Hostname verification of certificate failed. Certificate does not authenticate " + ((Object) getXMPPServiceDomain()));
        }
        this.secureSocket = sSLSocket;
    }

    private static XMPPInputOutputStream maybeGetCompressionHandler(Compress.Feature feature) {
        for (XMPPInputOutputStream xMPPInputOutputStream : SmackConfiguration.getCompressionHandlers()) {
            if (feature.getMethods().contains(xMPPInputOutputStream.getCompressionMethod())) {
                return xMPPInputOutputStream;
            }
        }
        return null;
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isUsingCompression() {
        return this.compressionHandler != null && this.compressSyncPoint;
    }

    private void maybeEnableCompression() throws SmackException, InterruptedException, XMPPException {
        Compress.Feature feature;
        if (this.config.isCompressionEnabled() && (feature = (Compress.Feature) getFeature(Compress.Feature.class)) != null) {
            XMPPInputOutputStream xMPPInputOutputStreamMaybeGetCompressionHandler = maybeGetCompressionHandler(feature);
            this.compressionHandler = xMPPInputOutputStreamMaybeGetCompressionHandler;
            if (xMPPInputOutputStreamMaybeGetCompressionHandler != null) {
                this.compressSyncPoint = false;
                sendNonza(new Compress(this.compressionHandler.getCompressionMethod()));
                waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda3
                    @Override // org.jivesoftware.smack.util.Supplier
                    public final Object get() {
                        return this.f$0.m14218xa17cc4cc();
                    }
                }, "establishing stream compression");
                return;
            }
            LOGGER.warning("Could not enable compression because no matching handler/method pair was found");
        }
    }

    /* JADX INFO: renamed from: lambda$maybeEnableCompression$5$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14218xa17cc4cc() {
        return Boolean.valueOf(this.compressSyncPoint);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void connectInternal() throws SmackException, InterruptedException, IOException, XMPPException {
        connectUsingConfiguration();
        this.connected = true;
        initConnection();
        waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14213xae1dd719();
            }
        }, "establishing TLS");
        waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection$$ExternalSyntheticLambda2
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14214x679564b8();
            }
        }, "SASL mechanisms stream feature from server");
    }

    /* JADX INFO: renamed from: lambda$connectInternal$6$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14213xae1dd719() {
        return Boolean.valueOf(this.tlsHandled);
    }

    /* JADX INFO: renamed from: lambda$connectInternal$7$org-jivesoftware-smack-tcp-XMPPTCPConnection, reason: not valid java name */
    /* synthetic */ Boolean m14214x679564b8() {
        return Boolean.valueOf(this.saslFeatureReceived);
    }

    protected void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void afterFeaturesReceived() throws SmackException.NotConnectedException, InterruptedException, SmackException.SecurityRequiredByServerException {
        StartTls startTls = (StartTls) getFeature(StartTls.class);
        if (startTls != null) {
            if (startTls.required() && this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled) {
                SmackException.SecurityRequiredByServerException securityRequiredByServerException = new SmackException.SecurityRequiredByServerException();
                this.currentSmackException = securityRequiredByServerException;
                notifyWaitingThreads();
                throw securityRequiredByServerException;
            }
            if (this.config.getSecurityMode() != ConnectionConfiguration.SecurityMode.disabled) {
                sendNonza(new StartTls());
            } else {
                this.tlsHandled = true;
                notifyWaitingThreads();
            }
        } else {
            this.tlsHandled = true;
            notifyWaitingThreads();
        }
        if (isSaslAuthenticated()) {
            this.streamFeaturesAfterAuthenticationReceived = true;
            notifyWaitingThreads();
        }
    }

    private void resetParser() throws IOException {
        try {
            this.packetReader.parser = SmackXmlParser.newXmlParser(this.reader);
        } catch (XmlPullParserException e2) {
            throw new IOException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStreamAndResetParser() throws SmackException.NotConnectedException, InterruptedException, IOException {
        sendStreamOpen();
        resetParser();
    }

    protected class PacketReader {
        private volatile boolean done;
        XmlPullParser parser;
        private boolean running;
        private final String threadName;

        protected PacketReader() {
            this.threadName = "Smack Reader (" + XMPPTCPConnection.this.getConnectionCounter() + ')';
        }

        void init() {
            this.done = false;
            this.running = true;
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketReader.1
                @Override // java.lang.Runnable
                public void run() {
                    XMPPTCPConnection.LOGGER.finer(PacketReader.this.threadName + " start");
                    try {
                        PacketReader.this.parsePackets();
                    } finally {
                        XMPPTCPConnection.LOGGER.finer(PacketReader.this.threadName + " exit");
                        PacketReader.this.running = false;
                        XMPPTCPConnection.this.notifyWaitingThreads();
                    }
                }
            }, this.threadName);
        }

        void shutdown() {
            this.done = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:113:0x030f A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:3:0x0001, B:4:0x000c, B:6:0x0010, B:14:0x0025, B:15:0x002c, B:114:0x0316, B:16:0x002d, B:18:0x0039, B:20:0x0047, B:21:0x006f, B:24:0x0089, B:25:0x00b5, B:26:0x00bf, B:113:0x030f, B:28:0x00c4, B:30:0x00cc, B:32:0x00e2, B:33:0x010c, B:35:0x0112, B:36:0x011e, B:38:0x0124, B:39:0x0129, B:40:0x0137, B:41:0x0146, B:42:0x0147, B:92:0x0263, B:94:0x0273, B:95:0x0280, B:45:0x0151, B:48:0x015b, B:49:0x0166, B:50:0x0167, B:53:0x0171, B:55:0x0179, B:57:0x0186, B:58:0x018d, B:59:0x0198, B:61:0x01a0, B:62:0x01b1, B:64:0x01b9, B:65:0x01c2, B:67:0x01ca, B:68:0x01d6, B:70:0x01de, B:71:0x01f4, B:73:0x01fa, B:74:0x0203, B:76:0x020b, B:86:0x0243, B:81:0x0220, B:83:0x0228, B:84:0x023b, B:87:0x024c, B:88:0x0253, B:89:0x0254, B:96:0x0281, B:98:0x0289, B:100:0x0299, B:101:0x02a4, B:102:0x02b3, B:104:0x02bb, B:106:0x02c7, B:108:0x02dc, B:112:0x02f8, B:109:0x02e6, B:110:0x02f2, B:111:0x02f3, B:91:0x025c), top: B:129:0x0001, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void parsePackets() {
            /*
                Method dump skipped, instruction units count: 934
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketReader.parsePackets():void");
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.tcp.XMPPTCPConnection$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected class PacketWriter {
        public static final int QUEUE_SIZE = 500;
        public static final int UNACKKNOWLEDGED_STANZAS_QUEUE_SIZE = 1024;
        public static final int UNACKKNOWLEDGED_STANZAS_QUEUE_SIZE_HIGH_WATER_MARK = 307;
        private volatile boolean instantShutdown;
        private boolean running;
        private boolean shouldBundleAndDefer;
        private final String threadName;
        private final ArrayBlockingQueueWithShutdown<Element> queue = new ArrayBlockingQueueWithShutdown<>(500, true);
        protected volatile Long shutdownTimestamp = null;

        protected PacketWriter() {
            this.threadName = "Smack Writer (" + XMPPTCPConnection.this.getConnectionCounter() + ')';
        }

        void init() {
            this.shutdownTimestamp = null;
            if (XMPPTCPConnection.this.unacknowledgedStanzas != null) {
                drainWriterQueueToUnacknowledgedStanzas();
            }
            this.queue.start();
            this.running = true;
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    XMPPTCPConnection.LOGGER.finer(PacketWriter.this.threadName + " start");
                    try {
                        PacketWriter.this.writePackets();
                    } finally {
                        XMPPTCPConnection.LOGGER.finer(PacketWriter.this.threadName + " exit");
                        PacketWriter.this.running = false;
                        XMPPTCPConnection.this.notifyWaitingThreads();
                    }
                }
            }, this.threadName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean done() {
            return this.shutdownTimestamp != null;
        }

        protected void throwNotConnectedExceptionIfDoneAndResumptionNotPossible() throws SmackException.NotConnectedException {
            boolean zIsSmResumptionPossible;
            boolean zDone = done();
            if (zDone && !(zIsSmResumptionPossible = XMPPTCPConnection.this.isSmResumptionPossible())) {
                throw new SmackException.NotConnectedException(XMPPTCPConnection.this, "done=" + zDone + " smResumptionPossible=" + zIsSmResumptionPossible);
            }
        }

        protected void sendStreamElement(Element element) throws SmackException.NotConnectedException, InterruptedException {
            throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
            try {
                this.queue.put(element);
            } catch (InterruptedException e2) {
                throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
                throw e2;
            }
        }

        void shutdown(boolean z) {
            this.instantShutdown = z;
            this.queue.shutdown();
            this.shutdownTimestamp = Long.valueOf(System.currentTimeMillis());
        }

        private Element nextStreamElement() {
            if (this.queue.isEmpty()) {
                this.shouldBundleAndDefer = true;
            }
            try {
                return this.queue.take();
            } catch (InterruptedException e2) {
                if (this.queue.isShutdown()) {
                    return null;
                }
                XMPPTCPConnection.LOGGER.log(Level.WARNING, "Writer thread was interrupted. Don't do that. Use disconnect() instead.", (Throwable) e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writePackets() {
            Stanza stanza;
            while (!done()) {
                try {
                    Element elementNextStreamElement = nextStreamElement();
                    if (elementNextStreamElement != null) {
                        BundleAndDeferCallback bundleAndDeferCallback = XMPPTCPConnection.this.bundleAndDeferCallback;
                        if (bundleAndDeferCallback != null && XMPPTCPConnection.this.isAuthenticated() && this.shouldBundleAndDefer) {
                            this.shouldBundleAndDefer = false;
                            AtomicBoolean atomicBoolean = new AtomicBoolean();
                            int bundleAndDeferMillis = bundleAndDeferCallback.getBundleAndDeferMillis(new BundleAndDefer(atomicBoolean));
                            if (bundleAndDeferMillis > 0) {
                                long j = bundleAndDeferMillis;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                synchronized (atomicBoolean) {
                                    for (long jCurrentTimeMillis2 = j; !atomicBoolean.get() && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j - (System.currentTimeMillis() - jCurrentTimeMillis)) {
                                        atomicBoolean.wait(jCurrentTimeMillis2);
                                    }
                                }
                            }
                        }
                        if (elementNextStreamElement instanceof Stanza) {
                            stanza = (Stanza) elementNextStreamElement;
                        } else {
                            if (elementNextStreamElement instanceof StreamManagement.Enable) {
                                XMPPTCPConnection.this.unacknowledgedStanzas = new ArrayBlockingQueue(1024);
                            }
                            stanza = null;
                        }
                        maybeAddToUnacknowledgedStanzas(stanza);
                        CharSequence xml = elementNextStreamElement.toXML(XMPPTCPConnection.this.outgoingStreamXmlEnvironment);
                        if (xml instanceof XmlStringBuilder) {
                            try {
                                ((XmlStringBuilder) xml).write(XMPPTCPConnection.this.writer, XMPPTCPConnection.this.outgoingStreamXmlEnvironment);
                            } catch (NullPointerException e2) {
                                XMPPTCPConnection.LOGGER.log(Level.FINE, "NPE in XmlStringBuilder of " + elementNextStreamElement.getClass() + ": " + elementNextStreamElement, (Throwable) e2);
                                throw e2;
                            }
                        } else {
                            XMPPTCPConnection.this.writer.write(xml.toString());
                        }
                        if (this.queue.isEmpty()) {
                            XMPPTCPConnection.this.writer.flush();
                        }
                        if (stanza != null) {
                            XMPPTCPConnection.this.firePacketSendingListeners(stanza);
                        }
                    }
                } catch (Exception e3) {
                    if (done() || this.queue.isShutdown()) {
                        XMPPTCPConnection.LOGGER.log(Level.FINE, "Ignoring Exception in writePackets()", (Throwable) e3);
                        return;
                    } else {
                        this.running = false;
                        XMPPTCPConnection.this.notifyConnectionError(e3);
                        return;
                    }
                }
            }
            if (!this.instantShutdown) {
                while (!this.queue.isEmpty()) {
                    try {
                        Element elementRemove = this.queue.remove();
                        if (elementRemove instanceof Stanza) {
                            maybeAddToUnacknowledgedStanzas((Stanza) elementRemove);
                        }
                        XMPPTCPConnection.this.writer.write(elementRemove.toXML().toString());
                    } catch (Exception e4) {
                        XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception flushing queue during shutdown, ignore and continue", (Throwable) e4);
                    }
                }
                try {
                    XMPPTCPConnection.this.writer.write("</stream:stream>");
                    XMPPTCPConnection.this.writer.flush();
                } catch (Exception e5) {
                    XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception writing closing stream element", (Throwable) e5);
                }
                this.queue.clear();
                return;
            }
            if (this.instantShutdown && XMPPTCPConnection.this.isSmEnabled()) {
                drainWriterQueueToUnacknowledgedStanzas();
            }
        }

        private void drainWriterQueueToUnacknowledgedStanzas() {
            ArrayList arrayList = new ArrayList(this.queue.size());
            this.queue.drainTo(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                Element element = (Element) arrayList.get(i);
                if (XMPPTCPConnection.this.unacknowledgedStanzas.remainingCapacity() == 0) {
                    XMPPTCPConnection.LOGGER.log(Level.WARNING, "Some stanzas may be lost as not all could be drained to the unacknowledged stanzas queue", (Throwable) StreamManagementException.UnacknowledgedQueueFullException.newWith(i, arrayList, XMPPTCPConnection.this.unacknowledgedStanzas));
                    return;
                } else {
                    if (element instanceof Stanza) {
                        XMPPTCPConnection.this.unacknowledgedStanzas.add((Stanza) element);
                    }
                }
            }
        }

        private void maybeAddToUnacknowledgedStanzas(Stanza stanza) throws IOException {
            if (XMPPTCPConnection.this.unacknowledgedStanzas == null || stanza == null) {
                return;
            }
            if (XMPPTCPConnection.this.unacknowledgedStanzas.size() == 307) {
                XMPPTCPConnection.this.writer.write(StreamManagement.AckRequest.INSTANCE.toXML().toString());
            }
            try {
                XMPPTCPConnection.this.unacknowledgedStanzas.put(stanza);
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static void setUseStreamManagementDefault(boolean z) {
        useSmDefault = z;
    }

    @Deprecated
    public static void setUseStreamManagementResumptiodDefault(boolean z) {
        setUseStreamManagementResumptionDefault(z);
    }

    public static void setUseStreamManagementResumptionDefault(boolean z) {
        if (z) {
            setUseStreamManagementDefault(z);
        }
        useSmResumptionDefault = z;
    }

    public void setUseStreamManagement(boolean z) {
        this.useSm = z;
    }

    public void setUseStreamManagementResumption(boolean z) {
        if (z) {
            setUseStreamManagement(z);
        }
        this.useSmResumption = z;
    }

    public void setPreferredResumptionTime(int i) {
        this.smClientMaxResumptionTime = i;
    }

    public boolean addRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean zAdd;
        synchronized (this.requestAckPredicates) {
            zAdd = this.requestAckPredicates.add(stanzaFilter);
        }
        return zAdd;
    }

    public boolean removeRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean zRemove;
        synchronized (this.requestAckPredicates) {
            zRemove = this.requestAckPredicates.remove(stanzaFilter);
        }
        return zRemove;
    }

    public void removeAllRequestAckPredicates() {
        synchronized (this.requestAckPredicates) {
            this.requestAckPredicates.clear();
        }
    }

    public void requestSmAcknowledgement() throws SmackException.NotConnectedException, InterruptedException, StreamManagementException.StreamManagementNotEnabledException {
        if (!isSmEnabled()) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        requestSmAcknowledgementInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSmAcknowledgementInternal() throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.sendStreamElement(StreamManagement.AckRequest.INSTANCE);
    }

    public void sendSmAcknowledgement() throws SmackException.NotConnectedException, InterruptedException, StreamManagementException.StreamManagementNotEnabledException {
        if (!isSmEnabled()) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        sendSmAcknowledgementInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSmAcknowledgementInternal() throws SmackException.NotConnectedException, InterruptedException {
        this.packetWriter.queue.putIfNotShutdown(new StreamManagement.AckAnswer(this.clientHandledStanzasCount));
    }

    public void addStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        this.stanzaAcknowledgedListeners.add(stanzaListener);
    }

    public boolean removeStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        return this.stanzaAcknowledgedListeners.remove(stanzaListener);
    }

    public void removeAllStanzaAcknowledgedListeners() {
        this.stanzaAcknowledgedListeners.clear();
    }

    public void addStanzaDroppedListener(StanzaListener stanzaListener) {
        this.stanzaDroppedListeners.add(stanzaListener);
    }

    public boolean removeStanzaDroppedListener(StanzaListener stanzaListener) {
        return this.stanzaDroppedListeners.remove(stanzaListener);
    }

    public StanzaListener addStanzaIdAcknowledgedListener(final String str, StanzaListener stanzaListener) throws StreamManagementException.StreamManagementNotEnabledException {
        if (!this.smWasEnabledAtLeastOnce) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        schedule(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.2
            @Override // java.lang.Runnable
            public void run() {
                XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(str);
            }
        }, Math.min(getMaxSmResumptionTime(), 10800), TimeUnit.SECONDS);
        return this.stanzaIdAcknowledgedListeners.put(str, stanzaListener);
    }

    public StanzaListener removeStanzaIdAcknowledgedListener(String str) {
        return this.stanzaIdAcknowledgedListeners.remove(str);
    }

    public void removeAllStanzaIdAcknowledgedListeners() {
        this.stanzaIdAcknowledgedListeners.clear();
    }

    public boolean isSmAvailable() {
        return hasFeature(StreamManagement.StreamManagementFeature.ELEMENT, StreamManagement.NAMESPACE);
    }

    public boolean isSmEnabled() {
        return this.smEnabledSyncPoint;
    }

    public boolean streamWasResumed() {
        return this.smResumedSyncPoint == AbstractXMPPConnection.SyncPointState.successful;
    }

    public boolean isDisconnectedButSmResumptionPossible() {
        return this.disconnectedButResumeable && isSmResumptionPossible();
    }

    public boolean isSmResumptionPossible() {
        if (this.smSessionId == null) {
            return false;
        }
        Long l = this.packetWriter.shutdownTimestamp;
        if (l == null) {
            return true;
        }
        return System.currentTimeMillis() <= l.longValue() + (((long) getMaxSmResumptionTime()) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dropSmState() {
        this.smSessionId = null;
        this.unacknowledgedStanzas = null;
    }

    public int getMaxSmResumptionTime() {
        int i = this.smClientMaxResumptionTime;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        int i2 = this.smServerMaxResumptionTime;
        return Math.min(i, i2 > 0 ? i2 : Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHandledCount(long j) throws StreamManagementException.StreamManagementCounterError {
        long jCalculateDelta = SMUtils.calculateDelta(j, this.serverHandledStanzasCount);
        final ArrayList arrayList = new ArrayList(jCalculateDelta <= SieveCacheKt.NodeLinkMask ? (int) jCalculateDelta : Integer.MAX_VALUE);
        for (long j2 = 0; j2 < jCalculateDelta; j2++) {
            Stanza stanzaPoll = this.unacknowledgedStanzas.poll();
            if (stanzaPoll == null) {
                throw new StreamManagementException.StreamManagementCounterError(j, this.serverHandledStanzasCount, jCalculateDelta, arrayList);
            }
            arrayList.add(stanzaPoll);
        }
        if (this.stanzaAcknowledgedListeners.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String stanzaId = ((Stanza) it.next()).getStanzaId();
                if (stanzaId != null && this.stanzaIdAcknowledgedListeners.containsKey(stanzaId)) {
                    asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.3
                        @Override // java.lang.Runnable
                        public void run() {
                            StanzaListener stanzaListener;
                            for (Stanza stanza : arrayList) {
                                Iterator it2 = XMPPTCPConnection.this.stanzaAcknowledgedListeners.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        ((StanzaListener) it2.next()).processStanza(stanza);
                                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e2) {
                                        XMPPTCPConnection.LOGGER.log(Level.FINER, "Received exception", e2);
                                    }
                                }
                                String stanzaId2 = stanza.getStanzaId();
                                if (!StringUtils.isNullOrEmpty(stanzaId2) && (stanzaListener = (StanzaListener) XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(stanzaId2)) != null) {
                                    try {
                                        stanzaListener.processStanza(stanza);
                                    } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e3) {
                                        XMPPTCPConnection.LOGGER.log(Level.FINER, "Received exception", e3);
                                    }
                                }
                            }
                        }
                    });
                    break;
                }
            }
        } else {
            asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    StanzaListener stanzaListener;
                    for (Stanza stanza : arrayList) {
                        Iterator it2 = XMPPTCPConnection.this.stanzaAcknowledgedListeners.iterator();
                        while (it2.hasNext()) {
                            try {
                                ((StanzaListener) it2.next()).processStanza(stanza);
                            } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e2) {
                                XMPPTCPConnection.LOGGER.log(Level.FINER, "Received exception", e2);
                            }
                        }
                        String stanzaId2 = stanza.getStanzaId();
                        if (!StringUtils.isNullOrEmpty(stanzaId2) && (stanzaListener = (StanzaListener) XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(stanzaId2)) != null) {
                            try {
                                stanzaListener.processStanza(stanza);
                            } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException e3) {
                                XMPPTCPConnection.LOGGER.log(Level.FINER, "Received exception", e3);
                            }
                        }
                    }
                }
            });
            break;
        }
        this.serverHandledStanzasCount = j;
    }

    public static void setDefaultBundleAndDeferCallback(BundleAndDeferCallback bundleAndDeferCallback) {
        defaultBundleAndDeferCallback = bundleAndDeferCallback;
    }

    public void setBundleandDeferCallback(BundleAndDeferCallback bundleAndDeferCallback) {
        this.bundleAndDeferCallback = bundleAndDeferCallback;
    }
}
