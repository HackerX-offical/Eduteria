package org.jivesoftware.smack.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.text.Typography;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.SmackReactor;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.TlsFailure;
import org.jivesoftware.smack.packet.TlsProceed;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;
import org.jxmpp.xml.splitter.Utf8ByteXmppXmlSplitter;
import org.jxmpp.xml.splitter.XmlPrettyPrinter;
import org.jxmpp.xml.splitter.XmppElementCallback;
import org.jxmpp.xml.splitter.XmppXmlSplitter;

/* JADX INFO: loaded from: classes10.dex */
public class XmppTcpTransportModule extends ModularXmppClientToServerConnectionModule<XmppTcpTransportModuleDescriptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CALLBACK_MAX_BYTES_READ = 10485760;
    private static final int CALLBACK_MAX_BYTES_WRITEN = 10485760;
    private static final int MAX_ELEMENT_SIZE = 65536;
    private final AtomicLong afterOutgoingElementsQueueModifiedSetInterestOps;
    private final Map<ByteBuffer, List<TopLevelStreamElement>> bufferToElementMap;
    private long callbackPreemtBecauseBytesRead;
    private long callbackPreemtBecauseBytesWritten;
    private final ReentrantLock channelSelectedCallbackLock;
    private final List<TopLevelStreamElement> currentlyOutgoingElements;
    XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredTcpEndpoints;
    private ByteBuffer filteredOutgoingBuffer;
    private long handledChannelSelectedCallbacks;
    private final ByteBuffer incomingBuffer;
    private Jid lastDestinationAddress;
    private int maxPendingSslEngineDelegatedTasks;
    private final List<ByteBuffer> networkOutgoingBuffers;
    private long networkOutgoingBuffersBytes;
    private ByteBuffer outgoingBuffer;
    private Iterator<CharSequence> outgoingCharSequenceIterator;
    private XmppXmlSplitter outputDebugSplitter;
    private boolean pendingInputFilterData;
    private boolean pendingOutputFilterData;
    private boolean pendingWriteInterestAfterRead;
    private final AtomicLong reactorThreadAlreadyRacing;
    private final AtomicLong rejectedChannelSelectedCallbacks;
    private InetSocketAddress remoteAddress;
    private SelectionKey selectionKey;
    private SmackReactor.SelectionKeyAttachment selectionKeyAttachment;
    private final AtomicLong setWriteInterestAfterChannelSelectedCallback;
    private SocketChannel socketChannel;
    private Utf8ByteXmppXmlSplitter splitter;
    private int sslEngineDelegatedTasks;
    private final XmppTcpNioTransport tcpNioTransport;
    private TlsState tlsState;
    private long totalBytesRead;
    private long totalBytesReadAfterFilter;
    private long totalBytesWritten;
    private long totalBytesWrittenBeforeFilter;
    private final XmppElementCallback xmppElementCallback;
    private static final Logger LOGGER = Logger.getLogger(XmppTcpTransportModule.class.getName());
    private static final Level STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL = Level.FINER;
    private static final Level SSL_ENGINE_DEBUG_LOG_LEVEL = Level.FINEST;

    private enum TlsHandshakeStatus {
        initial,
        initiated,
        successful,
        failed
    }

    static /* synthetic */ int access$3308(XmppTcpTransportModule xmppTcpTransportModule) {
        int i = xmppTcpTransportModule.sslEngineDelegatedTasks;
        xmppTcpTransportModule.sslEngineDelegatedTasks = i + 1;
        return i;
    }

    XmppTcpTransportModule(XmppTcpTransportModuleDescriptor xmppTcpTransportModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        XmlPrettyPrinter xmlPrettyPrinterBuild;
        super(xmppTcpTransportModuleDescriptor, modularXmppClientToServerConnectionInternal);
        this.currentlyOutgoingElements = new ArrayList();
        this.bufferToElementMap = new IdentityHashMap();
        this.networkOutgoingBuffers = new ArrayList();
        this.incomingBuffer = ByteBuffer.allocateDirect(8192);
        this.channelSelectedCallbackLock = new ReentrantLock();
        this.setWriteInterestAfterChannelSelectedCallback = new AtomicLong();
        this.reactorThreadAlreadyRacing = new AtomicLong();
        this.afterOutgoingElementsQueueModifiedSetInterestOps = new AtomicLong();
        this.rejectedChannelSelectedCallbacks = new AtomicLong();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.xmppElementCallback = anonymousClass1;
        this.tcpNioTransport = new XmppTcpNioTransport(modularXmppClientToServerConnectionInternal);
        final SmackDebugger smackDebugger = modularXmppClientToServerConnectionInternal.smackDebugger;
        if (smackDebugger != null) {
            xmlPrettyPrinterBuild = XmlPrettyPrinter.builder().setPrettyWriter(new XmlPrettyPrinter.PrettyPrintedXmlChunkSink() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$$ExternalSyntheticLambda0
                @Override // org.jxmpp.xml.splitter.XmlPrettyPrinter.PrettyPrintedXmlChunkSink
                public final void sink(StringBuilder sb) {
                    smackDebugger.m14195x4a9ebbdd(sb);
                }
            }).build();
            this.outputDebugSplitter = new XmppXmlSplitter(XmlPrettyPrinter.builder().setPrettyWriter(new XmlPrettyPrinter.PrettyPrintedXmlChunkSink() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$$ExternalSyntheticLambda1
                @Override // org.jxmpp.xml.splitter.XmlPrettyPrinter.PrettyPrintedXmlChunkSink
                public final void sink(StringBuilder sb) {
                    smackDebugger.m14197x8b8e340f(sb);
                }
            }).build());
        } else {
            xmlPrettyPrinterBuild = null;
        }
        this.splitter = new Utf8ByteXmppXmlSplitter(new XmppXmlSplitter(65536, anonymousClass1, xmlPrettyPrinterBuild));
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.tcp.XmppTcpTransportModule$1, reason: invalid class name */
    class AnonymousClass1 implements XmppElementCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private String streamClose;
        private String streamOpen;

        AnonymousClass1() {
        }

        @Override // org.jxmpp.xml.splitter.CompleteElementCallback
        public void onCompleteElement(String str) {
            XmppTcpTransportModule.this.connectionInternal.withSmackDebugger(new Consumer() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$1$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.Consumer
                public final void accept(Object obj) {
                    ((SmackDebugger) obj).onIncomingElementCompleted();
                }
            });
            XmppTcpTransportModule.this.connectionInternal.parseAndProcessElement(this.streamOpen + str + this.streamClose);
        }

        @Override // org.jxmpp.xml.splitter.XmppElementCallback
        public void streamOpened(String str, Map<String, String> map) {
            String key;
            String value;
            if (XmppTcpTransportModule.LOGGER.isLoggable(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL)) {
                XmppTcpTransportModule.LOGGER.log(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL, "Stream of " + this + " opened. prefix=" + str + " attributes=" + map);
            }
            String str2 = "xmlns:" + str;
            StringBuilder sb = new StringBuilder(32);
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append(Typography.less);
            sb.append("</");
            if (StringUtils.isNotEmpty(str)) {
                sb2.append(str).append(':');
                sb.append(str).append(':');
            }
            sb2.append("stream");
            sb.append("stream>");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                key.hashCode();
                switch (key) {
                    case "xml:lang":
                        sb2.append(" xml:lang='").append(value).append('\'');
                        break;
                    case "id":
                    case "to":
                    case "from":
                    case "version":
                        break;
                    case "xmlns":
                        sb2.append(" xmlns='").append(value).append('\'');
                        break;
                    default:
                        if (!key.equals(str2)) {
                            XmppTcpTransportModule.LOGGER.info("Unknown <stream/> attribute: " + key);
                            break;
                        } else {
                            sb2.append(' ').append(str2).append("='").append(value).append('\'');
                            break;
                        }
                        break;
                }
            }
            sb2.append(Typography.greater);
            this.streamOpen = sb2.toString();
            this.streamClose = sb.toString();
            try {
                XmppTcpTransportModule.this.connectionInternal.onStreamOpen(PacketParserUtils.getParserFor(this.streamOpen));
            } catch (IOException | XmlPullParserException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // org.jxmpp.xml.splitter.XmppElementCallback
        public void streamClosed() {
            if (XmppTcpTransportModule.LOGGER.isLoggable(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL)) {
                XmppTcpTransportModule.LOGGER.log(XmppTcpTransportModule.STREAM_OPEN_CLOSE_DEBUG_LOG_LEVEL, "Stream of " + this + " closed");
            }
            XmppTcpTransportModule.this.connectionInternal.onStreamClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01b1 A[EDGE_INSN: B:189:0x01b1->B:102:0x01b1 BREAK  A[LOOP:0: B:7:0x0024->B:97:0x0196], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055 A[Catch: all -> 0x0036, TryCatch #3 {all -> 0x0036, blocks: (B:10:0x0029, B:18:0x003e, B:20:0x0047, B:23:0x0051, B:25:0x0055, B:57:0x00f4, B:59:0x00f8, B:61:0x0106, B:63:0x010e, B:64:0x0118, B:66:0x011e, B:68:0x0126, B:69:0x012a, B:71:0x0131, B:74:0x0138, B:119:0x0200, B:77:0x0143, B:79:0x0149, B:81:0x014e, B:84:0x0154, B:87:0x015a, B:80:0x014c, B:28:0x005d, B:30:0x0061, B:32:0x0075, B:34:0x0079, B:37:0x0081, B:38:0x0086, B:40:0x008b, B:41:0x0090, B:43:0x0096, B:44:0x009b, B:46:0x009f, B:48:0x00a9, B:50:0x00b7, B:51:0x00c8, B:53:0x00d2, B:54:0x00e5, B:90:0x016f, B:92:0x0176, B:98:0x019b, B:99:0x01a9, B:104:0x01b5, B:105:0x01c4, B:107:0x01ca, B:110:0x01db, B:111:0x01df, B:113:0x01e5, B:116:0x01f5, B:118:0x01fd), top: B:180:0x0029, inners: #0, #1, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8 A[Catch: all -> 0x0036, TryCatch #3 {all -> 0x0036, blocks: (B:10:0x0029, B:18:0x003e, B:20:0x0047, B:23:0x0051, B:25:0x0055, B:57:0x00f4, B:59:0x00f8, B:61:0x0106, B:63:0x010e, B:64:0x0118, B:66:0x011e, B:68:0x0126, B:69:0x012a, B:71:0x0131, B:74:0x0138, B:119:0x0200, B:77:0x0143, B:79:0x0149, B:81:0x014e, B:84:0x0154, B:87:0x015a, B:80:0x014c, B:28:0x005d, B:30:0x0061, B:32:0x0075, B:34:0x0079, B:37:0x0081, B:38:0x0086, B:40:0x008b, B:41:0x0090, B:43:0x0096, B:44:0x009b, B:46:0x009f, B:48:0x00a9, B:50:0x00b7, B:51:0x00c8, B:53:0x00d2, B:54:0x00e5, B:90:0x016f, B:92:0x0176, B:98:0x019b, B:99:0x01a9, B:104:0x01b5, B:105:0x01c4, B:107:0x01ca, B:110:0x01db, B:111:0x01df, B:113:0x01e5, B:116:0x01f5, B:118:0x01fd), top: B:180:0x0029, inners: #0, #1, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #3 {all -> 0x0036, blocks: (B:10:0x0029, B:18:0x003e, B:20:0x0047, B:23:0x0051, B:25:0x0055, B:57:0x00f4, B:59:0x00f8, B:61:0x0106, B:63:0x010e, B:64:0x0118, B:66:0x011e, B:68:0x0126, B:69:0x012a, B:71:0x0131, B:74:0x0138, B:119:0x0200, B:77:0x0143, B:79:0x0149, B:81:0x014e, B:84:0x0154, B:87:0x015a, B:80:0x014c, B:28:0x005d, B:30:0x0061, B:32:0x0075, B:34:0x0079, B:37:0x0081, B:38:0x0086, B:40:0x008b, B:41:0x0090, B:43:0x0096, B:44:0x009b, B:46:0x009f, B:48:0x00a9, B:50:0x00b7, B:51:0x00c8, B:53:0x00d2, B:54:0x00e5, B:90:0x016f, B:92:0x0176, B:98:0x019b, B:99:0x01a9, B:104:0x01b5, B:105:0x01c4, B:107:0x01ca, B:110:0x01db, B:111:0x01df, B:113:0x01e5, B:116:0x01f5, B:118:0x01fd), top: B:180:0x0029, inners: #0, #1, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014c A[Catch: all -> 0x0036, TryCatch #3 {all -> 0x0036, blocks: (B:10:0x0029, B:18:0x003e, B:20:0x0047, B:23:0x0051, B:25:0x0055, B:57:0x00f4, B:59:0x00f8, B:61:0x0106, B:63:0x010e, B:64:0x0118, B:66:0x011e, B:68:0x0126, B:69:0x012a, B:71:0x0131, B:74:0x0138, B:119:0x0200, B:77:0x0143, B:79:0x0149, B:81:0x014e, B:84:0x0154, B:87:0x015a, B:80:0x014c, B:28:0x005d, B:30:0x0061, B:32:0x0075, B:34:0x0079, B:37:0x0081, B:38:0x0086, B:40:0x008b, B:41:0x0090, B:43:0x0096, B:44:0x009b, B:46:0x009f, B:48:0x00a9, B:50:0x00b7, B:51:0x00c8, B:53:0x00d2, B:54:0x00e5, B:90:0x016f, B:92:0x0176, B:98:0x019b, B:99:0x01a9, B:104:0x01b5, B:105:0x01c4, B:107:0x01ca, B:110:0x01db, B:111:0x01df, B:113:0x01e5, B:116:0x01f5, B:118:0x01fd), top: B:180:0x0029, inners: #0, #1, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0176 A[Catch: all -> 0x0036, TryCatch #3 {all -> 0x0036, blocks: (B:10:0x0029, B:18:0x003e, B:20:0x0047, B:23:0x0051, B:25:0x0055, B:57:0x00f4, B:59:0x00f8, B:61:0x0106, B:63:0x010e, B:64:0x0118, B:66:0x011e, B:68:0x0126, B:69:0x012a, B:71:0x0131, B:74:0x0138, B:119:0x0200, B:77:0x0143, B:79:0x0149, B:81:0x014e, B:84:0x0154, B:87:0x015a, B:80:0x014c, B:28:0x005d, B:30:0x0061, B:32:0x0075, B:34:0x0079, B:37:0x0081, B:38:0x0086, B:40:0x008b, B:41:0x0090, B:43:0x0096, B:44:0x009b, B:46:0x009f, B:48:0x00a9, B:50:0x00b7, B:51:0x00c8, B:53:0x00d2, B:54:0x00e5, B:90:0x016f, B:92:0x0176, B:98:0x019b, B:99:0x01a9, B:104:0x01b5, B:105:0x01c4, B:107:0x01ca, B:110:0x01db, B:111:0x01df, B:113:0x01e5, B:116:0x01f5, B:118:0x01fd), top: B:180:0x0029, inners: #0, #1, #7 }] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onChannelSelected(java.nio.channels.SelectableChannel r25, java.nio.channels.SelectionKey r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XmppTcpTransportModule.onChannelSelected(java.nio.channels.SelectableChannel, java.nio.channels.SelectionKey):void");
    }

    private void handleReadWriteIoException(IOException iOException) {
        if (!(iOException instanceof ClosedChannelException) || this.tcpNioTransport.isConnected()) {
            this.connectionInternal.notifyConnectionError(iOException);
        }
    }

    final class XmppTcpNioTransport extends XmppClientToServerTransport {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        protected XmppTcpNioTransport(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected void resetDiscoveredConnectionEndpoints() {
            XmppTcpTransportModule.this.discoveredTcpEndpoints = null;
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected List<SmackFuture<XmppClientToServerTransport.LookupConnectionEndpointsResult, Exception>> lookupConnectionEndpoints() {
            ArrayList arrayList = new ArrayList(2);
            final SmackFuture.InternalSmackFuture internalSmackFuture = new SmackFuture.InternalSmackFuture();
            this.connectionInternal.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$XmppTcpNioTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14224x1d6efdd0(internalSmackFuture);
                }
            });
            arrayList.add(internalSmackFuture);
            if (((XmppTcpTransportModuleDescriptor) XmppTcpTransportModule.this.moduleDescriptor).isDirectTlsEnabled()) {
                throw new IllegalArgumentException("DirectTLS is not implemented yet");
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: lambda$lookupConnectionEndpoints$0$org-jivesoftware-smack-tcp-XmppTcpTransportModule$XmppTcpNioTransport, reason: not valid java name */
        /* synthetic */ void m14224x1d6efdd0(SmackFuture.InternalSmackFuture internalSmackFuture) {
            Object discoveredTcpEndpoints;
            RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> resultLookup = RemoteXmppTcpConnectionEndpoints.lookup(this.connectionInternal.connection.getConfiguration());
            if (resultLookup.discoveredRemoteConnectionEndpoints.isEmpty()) {
                discoveredTcpEndpoints = new TcpEndpointDiscoveryFailed(resultLookup);
            } else {
                discoveredTcpEndpoints = new DiscoveredTcpEndpoints(resultLookup);
            }
            internalSmackFuture.setResult(discoveredTcpEndpoints);
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected void loadConnectionEndpoints(XmppClientToServerTransport.LookupConnectionEndpointsSuccess lookupConnectionEndpointsSuccess) {
            XmppTcpTransportModule.this.discoveredTcpEndpoints = (DiscoveredTcpEndpoints) lookupConnectionEndpointsSuccess;
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected void afterFiltersClosed() {
            XmppTcpTransportModule xmppTcpTransportModule = XmppTcpTransportModule.this;
            xmppTcpTransportModule.pendingInputFilterData = xmppTcpTransportModule.pendingOutputFilterData = true;
            XmppTcpTransportModule.this.afterOutgoingElementsQueueModified();
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected void disconnect() {
            XmppTcpTransportModule.this.closeSocketAndCleanup();
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        protected void notifyAboutNewOutgoingElements() {
            XmppTcpTransportModule.this.afterOutgoingElementsQueueModified();
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        public SSLSession getSslSession() {
            TlsState tlsState = XmppTcpTransportModule.this.tlsState;
            if (tlsState == null) {
                return null;
            }
            return tlsState.engine.getSession();
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        public boolean isConnected() {
            SocketChannel socketChannel = XmppTcpTransportModule.this.socketChannel;
            if (socketChannel == null) {
                return false;
            }
            return socketChannel.isConnected();
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        public boolean isTransportSecured() {
            TlsState tlsState = XmppTcpTransportModule.this.tlsState;
            return tlsState != null && tlsState.handshakeStatus == TlsHandshakeStatus.successful;
        }

        @Override // org.jivesoftware.smack.c2s.XmppClientToServerTransport
        public Stats getStats() {
            return XmppTcpTransportModule.this.getStats();
        }

        final class DiscoveredTcpEndpoints implements XmppClientToServerTransport.LookupConnectionEndpointsSuccess {
            final RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result;

            DiscoveredTcpEndpoints(RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result) {
                this.result = result;
            }
        }

        final class TcpEndpointDiscoveryFailed implements XmppClientToServerTransport.LookupConnectionEndpointsFailed {
            final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

            TcpEndpointDiscoveryFailed(RemoteXmppTcpConnectionEndpoints.Result<Rfc6120TcpRemoteConnectionEndpoint> result) {
                this.lookupFailures = result.lookupFailures;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterOutgoingElementsQueueModified() {
        SmackReactor.SelectionKeyAttachment selectionKeyAttachment = this.selectionKeyAttachment;
        if (selectionKeyAttachment != null && selectionKeyAttachment.isReactorThreadRacing()) {
            this.reactorThreadAlreadyRacing.incrementAndGet();
        } else {
            this.afterOutgoingElementsQueueModifiedSetInterestOps.incrementAndGet();
            this.connectionInternal.setInterestOps(this.selectionKey, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule
    public XmppTcpNioTransport getTransport() {
        return this.tcpNioTransport;
    }

    static final class EstablishingTcpConnectionStateDescriptor extends StateDescriptor {
        private EstablishingTcpConnectionStateDescriptor() {
            super((Class<? extends State>) EstablishingTcpConnectionState.class);
            addPredeccessor(ModularXmppClientToServerConnection.LookupRemoteConnectionEndpointsStateDescriptor.class);
            addSuccessor(EstablishTlsStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public EstablishingTcpConnectionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((XmppTcpTransportModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(XmppTcpTransportModuleDescriptor.class)).constructEstablishingTcpConnectionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EstablishingTcpConnectionState constructEstablishingTcpConnectionState(EstablishingTcpConnectionStateDescriptor establishingTcpConnectionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EstablishingTcpConnectionState(this, establishingTcpConnectionStateDescriptor, modularXmppClientToServerConnectionInternal, null);
    }

    final class EstablishingTcpConnectionState extends State {
        /* synthetic */ EstablishingTcpConnectionState(XmppTcpTransportModule xmppTcpTransportModule, EstablishingTcpConnectionStateDescriptor establishingTcpConnectionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, AnonymousClass1 anonymousClass1) {
            this(establishingTcpConnectionStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        private EstablishingTcpConnectionState(EstablishingTcpConnectionStateDescriptor establishingTcpConnectionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(establishingTcpConnectionStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
            ConnectionAttemptState connectionAttemptState = new ConnectionAttemptState(this.connectionInternal, XmppTcpTransportModule.this.discoveredTcpEndpoints, this);
            StateTransitionResult.Failure failureEstablishTcpConnection = connectionAttemptState.establishTcpConnection();
            if (failureEstablishTcpConnection != null) {
                return failureEstablishTcpConnection;
            }
            XmppTcpTransportModule.this.socketChannel = connectionAttemptState.socketChannel;
            XmppTcpTransportModule xmppTcpTransportModule = XmppTcpTransportModule.this;
            xmppTcpTransportModule.remoteAddress = (InetSocketAddress) xmppTcpTransportModule.socketChannel.socket().getRemoteSocketAddress();
            XmppTcpTransportModule xmppTcpTransportModule2 = XmppTcpTransportModule.this;
            ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal = this.connectionInternal;
            SocketChannel socketChannel = XmppTcpTransportModule.this.socketChannel;
            final XmppTcpTransportModule xmppTcpTransportModule3 = XmppTcpTransportModule.this;
            xmppTcpTransportModule2.selectionKey = modularXmppClientToServerConnectionInternal.registerWithSelector(socketChannel, 1, new SmackReactor.ChannelSelectedCallback() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$EstablishingTcpConnectionState$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.SmackReactor.ChannelSelectedCallback
                public final void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey) throws Throwable {
                    xmppTcpTransportModule3.onChannelSelected(selectableChannel, selectionKey);
                }
            });
            XmppTcpTransportModule xmppTcpTransportModule4 = XmppTcpTransportModule.this;
            xmppTcpTransportModule4.selectionKeyAttachment = (SmackReactor.SelectionKeyAttachment) xmppTcpTransportModule4.selectionKey.attachment();
            this.connectionInternal.setTransport(XmppTcpTransportModule.this.tcpNioTransport);
            this.connectionInternal.newStreamOpenWaitForFeaturesSequence("stream features after initial connection");
            return new TcpSocketConnectedResult(XmppTcpTransportModule.this.remoteAddress, null);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            XmppTcpTransportModule.this.closeSocketAndCleanup();
        }
    }

    public static final class TcpSocketConnectedResult extends StateTransitionResult.Success {
        private final InetSocketAddress remoteAddress;

        /* synthetic */ TcpSocketConnectedResult(InetSocketAddress inetSocketAddress, AnonymousClass1 anonymousClass1) {
            this(inetSocketAddress);
        }

        private TcpSocketConnectedResult(InetSocketAddress inetSocketAddress) {
            super("TCP connection established to " + inetSocketAddress);
            this.remoteAddress = inetSocketAddress;
        }

        public InetSocketAddress getRemoteAddress() {
            return this.remoteAddress;
        }
    }

    public static final class TlsEstablishedResult extends StateTransitionResult.Success {
        /* synthetic */ TlsEstablishedResult(SSLEngine sSLEngine, AnonymousClass1 anonymousClass1) {
            this(sSLEngine);
        }

        private TlsEstablishedResult(SSLEngine sSLEngine) {
            super("TLS established: " + sSLEngine.getSession());
        }
    }

    static final class EstablishTlsStateDescriptor extends StateDescriptor {
        private EstablishTlsStateDescriptor() {
            super((Class<? extends State>) EstablishTlsState.class, "RFC 6120 § 5");
            addSuccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public EstablishTlsState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((XmppTcpTransportModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(XmppTcpTransportModuleDescriptor.class)).constructEstablishingTlsState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EstablishTlsState constructEstablishingTlsState(EstablishTlsStateDescriptor establishTlsStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EstablishTlsState(this, establishTlsStateDescriptor, modularXmppClientToServerConnectionInternal, null);
    }

    private final class EstablishTlsState extends State {
        /* synthetic */ EstablishTlsState(XmppTcpTransportModule xmppTcpTransportModule, EstablishTlsStateDescriptor establishTlsStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, AnonymousClass1 anonymousClass1) {
            this(establishTlsStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        private EstablishTlsState(EstablishTlsStateDescriptor establishTlsStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(establishTlsStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) throws SmackException.SecurityRequiredByServerException, SmackException.SecurityRequiredByClientException {
            StartTls startTls = (StartTls) this.connectionInternal.connection.getFeature(StartTls.class);
            ConnectionConfiguration.SecurityMode securityMode = this.connectionInternal.connection.getConfiguration().getSecurityMode();
            int i = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode[securityMode.ordinal()];
            if (i == 1 || i == 2) {
                if (startTls != null) {
                    return null;
                }
                if (securityMode == ConnectionConfiguration.SecurityMode.ifpossible) {
                    return new StateTransitionResult.TransitionImpossibleReason("Server does not announce support for TLS and we do not required it");
                }
                throw new SmackException.SecurityRequiredByClientException();
            }
            if (i == 3) {
                if (startTls != null && startTls.required()) {
                    throw new SmackException.SecurityRequiredByServerException();
                }
                return new StateTransitionResult.TransitionImpossibleReason("TLS disabled in client settings and server does not require it");
            }
            throw new AssertionError("Unknown security mode: " + securityMode);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
            this.connectionInternal.sendAndWaitForResponse(StartTls.INSTANCE, TlsProceed.class, TlsFailure.class);
            SmackTlsContext smackTlsContext = this.connectionInternal.getSmackTlsContext();
            AnonymousClass1 anonymousClass1 = null;
            XmppTcpTransportModule.this.tlsState = new TlsState(XmppTcpTransportModule.this, smackTlsContext, anonymousClass1);
            this.connectionInternal.addXmppInputOutputFilter(XmppTcpTransportModule.this.tlsState);
            XmppTcpTransportModule.this.channelSelectedCallbackLock.lock();
            try {
                XmppTcpTransportModule.this.pendingOutputFilterData = true;
                XmppTcpTransportModule.this.tlsState.engine.beginHandshake();
                XmppTcpTransportModule.this.tlsState.handshakeStatus = TlsHandshakeStatus.initiated;
                XmppTcpTransportModule.this.channelSelectedCallbackLock.unlock();
                this.connectionInternal.setInterestOps(XmppTcpTransportModule.this.selectionKey, 5);
                try {
                    XmppTcpTransportModule.this.tlsState.waitForHandshakeFinished();
                    this.connectionInternal.newStreamOpenWaitForFeaturesSequence("stream features after TLS established");
                    return new TlsEstablishedResult(XmppTcpTransportModule.this.tlsState.engine, anonymousClass1);
                } catch (CertificateException e2) {
                    throw new SmackException.SmackCertificateException(e2);
                }
            } catch (Throwable th) {
                XmppTcpTransportModule.this.channelSelectedCallbackLock.unlock();
                throw th;
            }
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            XmppTcpTransportModule.this.tlsState = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debugLogSslEngineResult(String str, SSLEngineResult sSLEngineResult) {
        Logger logger = LOGGER;
        Level level = SSL_ENGINE_DEBUG_LOG_LEVEL;
        if (logger.isLoggable(level)) {
            logger.log(level, "SSLEngineResult of " + str + "(): " + sSLEngineResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class TlsState implements XmppInputOutputFilter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MAX_PENDING_OUTPUT_BYTES = 8096;
        private final SSLEngine engine;
        private SSLException handshakeException;
        private TlsHandshakeStatus handshakeStatus;
        private ByteBuffer myNetData;
        private ByteBuffer peerAppData;
        private final AtomicInteger pendingDelegatedTasks;
        private ByteBuffer pendingInputData;
        private int pendingOutputBytes;
        private final List<ByteBuffer> pendingOutputData;
        private final SmackTlsContext smackTlsContext;
        private long unwrapInBytes;
        private long unwrapOutBytes;
        private long wrapInBytes;
        private long wrapOutBytes;

        /* synthetic */ TlsState(XmppTcpTransportModule xmppTcpTransportModule, SmackTlsContext smackTlsContext, AnonymousClass1 anonymousClass1) throws IOException {
            this(smackTlsContext);
        }

        private TlsState(SmackTlsContext smackTlsContext) throws IOException {
            this.handshakeStatus = TlsHandshakeStatus.initial;
            this.pendingOutputData = new ArrayList();
            this.pendingDelegatedTasks = new AtomicInteger();
            this.smackTlsContext = smackTlsContext;
            SSLEngine sSLEngineCreateSSLEngine = smackTlsContext.sslContext.createSSLEngine(XmppTcpTransportModule.this.connectionInternal.connection.getConfiguration().getXMPPServiceDomain().toString(), XmppTcpTransportModule.this.remoteAddress.getPort());
            this.engine = sSLEngineCreateSSLEngine;
            sSLEngineCreateSSLEngine.setUseClientMode(true);
            SSLSession session = sSLEngineCreateSSLEngine.getSession();
            int applicationBufferSize = session.getApplicationBufferSize();
            this.myNetData = ByteBuffer.allocateDirect(session.getPacketBufferSize());
            this.peerAppData = ByteBuffer.allocate(applicationBufferSize);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
        
            return new org.jivesoftware.smack.XmppInputOutputFilter.OutputResult(true, r8.myNetData);
         */
        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public org.jivesoftware.smack.XmppInputOutputFilter.OutputResult output(java.nio.ByteBuffer r9, boolean r10, boolean r11, boolean r12) throws javax.net.ssl.SSLException {
            /*
                Method dump skipped, instruction units count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XmppTcpTransportModule.TlsState.output(java.nio.ByteBuffer, boolean, boolean, boolean):org.jivesoftware.smack.XmppInputOutputFilter$OutputResult");
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public ByteBuffer input(ByteBuffer byteBuffer) throws SSLException {
            ByteBuffer byteBuffer2 = this.pendingInputData;
            if (byteBuffer2 != null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer2.remaining() + byteBuffer.remaining());
                byteBufferAllocate.put(this.pendingInputData).put(byteBuffer).flip();
                this.pendingInputData = null;
                byteBuffer = byteBufferAllocate;
            }
            this.peerAppData.clear();
            while (true) {
                try {
                    SSLEngineResult sSLEngineResultUnwrap = this.engine.unwrap(byteBuffer, this.peerAppData);
                    XmppTcpTransportModule.debugLogSslEngineResult("unwrap", sSLEngineResultUnwrap);
                    SSLEngineResult.Status status = sSLEngineResultUnwrap.getStatus();
                    if (status == SSLEngineResult.Status.OK) {
                        this.unwrapInBytes += (long) sSLEngineResultUnwrap.bytesConsumed();
                        this.unwrapOutBytes += (long) sSLEngineResultUnwrap.bytesProduced();
                        int i = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handleHandshakeStatus(sSLEngineResultUnwrap).ordinal()];
                        if (i == 1) {
                            continue;
                        } else {
                            if (i == 2) {
                                addAsPendingInputData(byteBuffer);
                                XmppTcpTransportModule.this.connectionInternal.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$TlsState$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.m14222x63a12303();
                                    }
                                });
                                return null;
                            }
                            if (i == 3) {
                                addAsPendingInputData(byteBuffer);
                                return null;
                            }
                        }
                    }
                    int i2 = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[status.ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            return null;
                        }
                        if (i2 == 3) {
                            this.peerAppData = ByteBuffer.allocate(this.engine.getSession().getApplicationBufferSize());
                        } else if (i2 == 4) {
                            addAsPendingInputData(byteBuffer);
                            return null;
                        }
                    } else if (!byteBuffer.hasRemaining()) {
                        return this.peerAppData;
                    }
                } catch (SSLException e2) {
                    handleSslException(e2);
                    throw e2;
                }
            }
        }

        /* JADX INFO: renamed from: lambda$input$0$org-jivesoftware-smack-tcp-XmppTcpTransportModule$TlsState, reason: not valid java name */
        /* synthetic */ void m14222x63a12303() {
            XmppTcpTransportModule.this.callChannelSelectedCallback(false, true);
        }

        private void addAsPendingInputData(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            this.pendingInputData = byteBufferAllocate;
            byteBufferAllocate.put(byteBuffer).flip();
            XmppTcpTransportModule.this.pendingInputFilterData = this.pendingInputData.hasRemaining();
        }

        private SSLEngineResult.HandshakeStatus handleHandshakeStatus(SSLEngineResult sSLEngineResult) {
            int i = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResult.getHandshakeStatus().ordinal()];
            if (i == 3) {
                while (true) {
                    final Runnable delegatedTask = this.engine.getDelegatedTask();
                    if (delegatedTask == null) {
                        break;
                    }
                    XmppTcpTransportModule.access$3308(XmppTcpTransportModule.this);
                    int iIncrementAndGet = this.pendingDelegatedTasks.incrementAndGet();
                    if (iIncrementAndGet > XmppTcpTransportModule.this.maxPendingSslEngineDelegatedTasks) {
                        XmppTcpTransportModule.this.maxPendingSslEngineDelegatedTasks = iIncrementAndGet;
                    }
                    XmppTcpTransportModule.this.connectionInternal.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$TlsState$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m14221xa71b800b(delegatedTask);
                        }
                    });
                }
            } else if (i == 4) {
                onHandshakeFinished();
            }
            return this.engine.getHandshakeStatus();
        }

        /* JADX INFO: renamed from: lambda$handleHandshakeStatus$1$org-jivesoftware-smack-tcp-XmppTcpTransportModule$TlsState, reason: not valid java name */
        /* synthetic */ void m14221xa71b800b(Runnable runnable) {
            runnable.run();
            if (this.pendingDelegatedTasks.decrementAndGet() == 0) {
                XmppTcpTransportModule.this.callChannelSelectedCallback(true, true);
            }
        }

        private void handleSslException(SSLException sSLException) {
            this.handshakeException = sSLException;
            this.handshakeStatus = TlsHandshakeStatus.failed;
            XmppTcpTransportModule.this.connectionInternal.notifyWaitingThreads();
        }

        private void onHandshakeFinished() {
            this.handshakeStatus = TlsHandshakeStatus.successful;
            XmppTcpTransportModule.this.connectionInternal.notifyWaitingThreads();
        }

        private boolean isHandshakeFinished() {
            return this.handshakeStatus == TlsHandshakeStatus.successful || this.handshakeStatus == TlsHandshakeStatus.failed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void waitForHandshakeFinished() throws SmackException, SSLException, InterruptedException, CertificateException, XMPPException {
            XmppTcpTransportModule.this.connectionInternal.waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$TlsState$$ExternalSyntheticLambda2
                @Override // org.jivesoftware.smack.util.Supplier
                public final Object get() {
                    return this.f$0.m14223x82e1057c();
                }
            }, "TLS handshake to finish");
            if (this.handshakeStatus == TlsHandshakeStatus.failed) {
                throw this.handshakeException;
            }
            if (this.smackTlsContext.daneVerifier != null) {
                this.smackTlsContext.daneVerifier.finish(this.engine.getSession());
            }
        }

        /* JADX INFO: renamed from: lambda$waitForHandshakeFinished$2$org-jivesoftware-smack-tcp-XmppTcpTransportModule$TlsState, reason: not valid java name */
        /* synthetic */ Boolean m14223x82e1057c() {
            return Boolean.valueOf(isHandshakeFinished());
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public Object getStats() {
            return new TlsStateStats(this, null);
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public void closeInputOutput() {
            this.engine.closeOutbound();
            try {
                this.engine.closeInbound();
            } catch (SSLException e2) {
                XmppTcpTransportModule.LOGGER.log(Level.FINEST, "SSLException when closing inbound TLS session. This can likely be ignored if a possible truncation attack is suggested. You may want to ask your XMPP server vendor to implement a clean TLS session shutdown sending close_notify after </stream>", (Throwable) e2);
            }
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public void waitUntilInputOutputClosed() throws SmackException, InterruptedException, IOException, CertificateException, XMPPException {
            waitForHandshakeFinished();
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public String getFilterName() {
            return "TLS (" + this.engine + ')';
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.tcp.XmppTcpTransportModule$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[ConnectionConfiguration.SecurityMode.values().length];
            $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode = iArr3;
            try {
                iArr3[ConnectionConfiguration.SecurityMode.required.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode[ConnectionConfiguration.SecurityMode.ifpossible.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$SecurityMode[ConnectionConfiguration.SecurityMode.disabled.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static final class TlsStateStats {
        private transient String toStringCache;
        public final long unwrapInBytes;
        public final long unwrapOutBytes;
        public final double unwrapRatio;
        public final long wrapInBytes;
        public final long wrapOutBytes;
        public final double wrapRatio;

        /* synthetic */ TlsStateStats(TlsState tlsState, AnonymousClass1 anonymousClass1) {
            this(tlsState);
        }

        private TlsStateStats(TlsState tlsState) {
            long j = tlsState.wrapOutBytes;
            this.wrapOutBytes = j;
            long j2 = tlsState.wrapInBytes;
            this.wrapInBytes = j2;
            this.wrapRatio = j / j2;
            long j3 = tlsState.unwrapOutBytes;
            this.unwrapOutBytes = j3;
            long j4 = tlsState.unwrapInBytes;
            this.unwrapInBytes = j4;
            this.unwrapRatio = j4 / j3;
        }

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "wrap-in-bytes: " + this.wrapInBytes + "\nwrap-out-bytes: " + this.wrapOutBytes + "\nwrap-ratio: " + this.wrapRatio + "\nunwrap-in-bytes: " + this.unwrapInBytes + "\nunwrap-out-bytes: " + this.unwrapOutBytes + "\nunwrap-ratio: " + this.unwrapRatio + '\n';
            this.toStringCache = str2;
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callChannelSelectedCallback(boolean z, boolean z2) {
        SocketChannel socketChannel = this.socketChannel;
        SelectionKey selectionKey = this.selectionKey;
        if (socketChannel == null || selectionKey == null) {
            LOGGER.info("Not calling channel selected callback because the connection was eventually disconnected");
            return;
        }
        this.channelSelectedCallbackLock.lock();
        if (z) {
            try {
                this.pendingInputFilterData = true;
            } catch (Throwable th) {
                this.channelSelectedCallbackLock.unlock();
                throw th;
            }
        }
        if (z2) {
            this.pendingOutputFilterData = true;
        }
        onChannelSelected(socketChannel, selectionKey);
        this.channelSelectedCallbackLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocketAndCleanup() {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException unused) {
            }
        }
        this.selectionKey = null;
        this.socketChannel = null;
        this.selectionKeyAttachment = null;
        this.remoteAddress = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<? extends Buffer> pruneBufferList(Collection<? extends Buffer> collection) {
        return CollectionUtil.removeUntil(collection, new CollectionUtil.Predicate() { // from class: org.jivesoftware.smack.tcp.XmppTcpTransportModule$$ExternalSyntheticLambda2
            @Override // org.jivesoftware.smack.util.CollectionUtil.Predicate
            public final boolean test(Object obj) {
                return ((Buffer) obj).hasRemaining();
            }
        });
    }

    public Stats getStats() {
        return new Stats(this, null);
    }

    public static final class Stats extends XmppClientToServerTransport.Stats {
        public final long afterOutgoingElementsQueueModifiedSetInterestOps;
        public final long callbackPreemtBecauseBytesRead;
        public final long callbackPreemtBecauseBytesWritten;
        public final long handledChannelSelectedCallbacks;
        public final int maxPendingSslEngineDelegatedTasks;
        public final long reactorThreadAlreadyRacing;
        public final double readRatio;
        public final long rejectedChannelSelectedCallbacks;
        public final long setWriteInterestAfterChannelSelectedCallback;
        public final int sslEngineDelegatedTasks;
        private transient String toStringCache;
        public final long totalBytesRead;
        public final long totalBytesReadAfterFilter;
        public final long totalBytesWritten;
        public final long totalBytesWrittenBeforeFilter;
        public final long totalCallbackRequests;
        public final double writeRatio;

        /* synthetic */ Stats(XmppTcpTransportModule xmppTcpTransportModule, AnonymousClass1 anonymousClass1) {
            this(xmppTcpTransportModule);
        }

        private Stats(XmppTcpTransportModule xmppTcpTransportModule) {
            long j = xmppTcpTransportModule.totalBytesWritten;
            this.totalBytesWritten = j;
            long j2 = xmppTcpTransportModule.totalBytesWrittenBeforeFilter;
            this.totalBytesWrittenBeforeFilter = j2;
            this.writeRatio = j / j2;
            long j3 = xmppTcpTransportModule.totalBytesReadAfterFilter;
            this.totalBytesReadAfterFilter = j3;
            long j4 = xmppTcpTransportModule.totalBytesRead;
            this.totalBytesRead = j4;
            this.readRatio = j4 / j3;
            long j5 = xmppTcpTransportModule.handledChannelSelectedCallbacks;
            this.handledChannelSelectedCallbacks = j5;
            this.setWriteInterestAfterChannelSelectedCallback = xmppTcpTransportModule.setWriteInterestAfterChannelSelectedCallback.get();
            this.reactorThreadAlreadyRacing = xmppTcpTransportModule.reactorThreadAlreadyRacing.get();
            this.afterOutgoingElementsQueueModifiedSetInterestOps = xmppTcpTransportModule.afterOutgoingElementsQueueModifiedSetInterestOps.get();
            long j6 = xmppTcpTransportModule.rejectedChannelSelectedCallbacks.get();
            this.rejectedChannelSelectedCallbacks = j6;
            this.totalCallbackRequests = j5 + j6;
            this.callbackPreemtBecauseBytesRead = xmppTcpTransportModule.callbackPreemtBecauseBytesRead;
            this.callbackPreemtBecauseBytesWritten = xmppTcpTransportModule.callbackPreemtBecauseBytesWritten;
            this.sslEngineDelegatedTasks = xmppTcpTransportModule.sslEngineDelegatedTasks;
            this.maxPendingSslEngineDelegatedTasks = xmppTcpTransportModule.maxPendingSslEngineDelegatedTasks;
        }

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "Total bytes\nrecv: " + this.totalBytesRead + "\nsend: " + this.totalBytesWritten + "\nrecv-aft-filter: " + this.totalBytesReadAfterFilter + "\nsend-bef-filter: " + this.totalBytesWrittenBeforeFilter + "\nread-ratio: " + this.readRatio + "\nwrite-ratio: " + this.writeRatio + "\nEvents\ntotal-callback-requests: " + this.totalCallbackRequests + "\nhandled-channel-selected-callbacks: " + this.handledChannelSelectedCallbacks + "\nrejected-channel-selected-callbacks: " + this.rejectedChannelSelectedCallbacks + "\nset-write-interest-after-callback: " + this.setWriteInterestAfterChannelSelectedCallback + "\nreactor-thread-already-racing: " + this.reactorThreadAlreadyRacing + "\nafter-queue-modified-set-interest-ops: " + this.afterOutgoingElementsQueueModifiedSetInterestOps + "\ncallback-preemt-because-bytes-read: " + this.callbackPreemtBecauseBytesRead + "\ncallback-preemt-because-bytes-written: " + this.callbackPreemtBecauseBytesWritten + "\nssl-engine-delegated-tasks: " + this.sslEngineDelegatedTasks + "\nmax-pending-ssl-engine-delegated-tasks: " + this.maxPendingSslEngineDelegatedTasks + '\n';
            this.toStringCache = str2;
            return str2;
        }
    }
}
