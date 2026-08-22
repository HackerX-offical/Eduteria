package org.jivesoftware.smack.c2s;

import com.csvreader.CsvReader;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackFuture;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.ConnectionStateEvent;
import org.jivesoftware.smack.fsm.ConnectionStateMachineListener;
import org.jivesoftware.smack.fsm.LoginContext;
import org.jivesoftware.smack.fsm.NoOpState;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.fsm.StateMachineException;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.internal.AbstractStats;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StreamClose;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown;
import org.jivesoftware.smack.util.ExtendedAppendable;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.Supplier;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public final class ModularXmppClientToServerConnection extends AbstractXMPPConnection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(ModularXmppClientToServerConnectionConfiguration.class.getName());
    private XmppClientToServerTransport activeTransport;
    private boolean compressionEnabled;
    private final ModularXmppClientToServerConnectionConfiguration configuration;
    private final ModularXmppClientToServerConnectionInternal connectionInternal;
    private final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor>> connectionModules;
    private final List<ConnectionStateMachineListener> connectionStateMachineListeners;
    private StateDescriptorGraph.GraphVertex<State> currentStateVertex;
    private boolean featuresReceived;
    private final List<XmppInputOutputFilter> inputOutputFilters;
    private final ArrayBlockingQueueWithShutdown<TopLevelStreamElement> outgoingElementsQueue;
    private List<XmppInputOutputFilter> previousInputOutputFilters;
    protected boolean streamResumed;
    private final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport> transports;
    private List<State> walkFromDisconnectToAuthenticated;

    public ModularXmppClientToServerConnection(ModularXmppClientToServerConnectionConfiguration modularXmppClientToServerConnectionConfiguration) {
        super(modularXmppClientToServerConnectionConfiguration);
        ArrayBlockingQueueWithShutdown<TopLevelStreamElement> arrayBlockingQueueWithShutdown = new ArrayBlockingQueueWithShutdown<>(100, true);
        this.outgoingElementsQueue = arrayBlockingQueueWithShutdown;
        this.connectionStateMachineListeners = new CopyOnWriteArrayList();
        this.connectionModules = new HashMap();
        this.transports = new HashMap();
        this.inputOutputFilters = new CopyOnWriteArrayList();
        this.configuration = modularXmppClientToServerConnectionConfiguration;
        this.connectionInternal = new ModularXmppClientToServerConnectionInternal(this, getReactor(), this.debugger, arrayBlockingQueueWithShutdown) { // from class: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection.1
            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void parseAndProcessElement(String str) {
                ModularXmppClientToServerConnection.this.parseAndProcessElement(str);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void notifyConnectionError(Exception exc) {
                ModularXmppClientToServerConnection.this.notifyConnectionError(exc);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void onStreamOpen(XmlPullParser xmlPullParser) {
                ModularXmppClientToServerConnection.this.onStreamOpen(xmlPullParser);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void onStreamClosed() {
                ModularXmppClientToServerConnection.this.closingStreamReceived = true;
                notifyWaitingThreads();
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void fireFirstLevelElementSendListeners(TopLevelStreamElement topLevelStreamElement) {
                ModularXmppClientToServerConnection.this.firePacketSendingListeners(topLevelStreamElement);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void invokeConnectionStateMachineListener(ConnectionStateEvent connectionStateEvent) {
                ModularXmppClientToServerConnection.this.invokeConnectionStateMachineListener(connectionStateEvent);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public XmlEnvironment getOutgoingStreamXmlEnvironment() {
                return ModularXmppClientToServerConnection.this.outgoingStreamXmlEnvironment;
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void addXmppInputOutputFilter(XmppInputOutputFilter xmppInputOutputFilter) {
                ModularXmppClientToServerConnection.this.inputOutputFilters.add(0, xmppInputOutputFilter);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterBeginIterator() {
                return ModularXmppClientToServerConnection.this.inputOutputFilters.listIterator();
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public ListIterator<XmppInputOutputFilter> getXmppInputOutputFilterEndIterator() {
                return ModularXmppClientToServerConnection.this.inputOutputFilters.listIterator(ModularXmppClientToServerConnection.this.inputOutputFilters.size());
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void newStreamOpenWaitForFeaturesSequence(String str) throws SmackException, InterruptedException, XMPPException {
                ModularXmppClientToServerConnection.this.newStreamOpenWaitForFeaturesSequence(str);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public SmackTlsContext getSmackTlsContext() {
                return ModularXmppClientToServerConnection.this.getSmackTlsContext();
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.FailedNonzaException {
                return (SN) ModularXmppClientToServerConnection.this.sendAndWaitForResponse(nonza, cls, cls2);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void asyncGo(Runnable runnable) {
                ModularXmppClientToServerConnection.asyncGo(runnable);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void waitForConditionOrThrowConnectionException(Supplier<Boolean> supplier, String str) throws SmackException, InterruptedException, XMPPException {
                ModularXmppClientToServerConnection.this.waitForConditionOrThrowConnectionException(supplier, str);
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void notifyWaitingThreads() {
                ModularXmppClientToServerConnection.this.notifyWaitingThreads();
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void setCompressionEnabled(boolean z) {
                ModularXmppClientToServerConnection.this.compressionEnabled = z;
            }

            @Override // org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal
            public void setTransport(XmppClientToServerTransport xmppClientToServerTransport) {
                ModularXmppClientToServerConnection.this.activeTransport = xmppClientToServerTransport;
                ModularXmppClientToServerConnection.this.connected = true;
            }
        };
        for (ModularXmppClientToServerConnectionModuleDescriptor modularXmppClientToServerConnectionModuleDescriptor : modularXmppClientToServerConnectionConfiguration.moduleDescriptors) {
            Class<?> cls = modularXmppClientToServerConnectionModuleDescriptor.getClass();
            ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor> modularXmppClientToServerConnectionModuleConstructXmppConnectionModule = modularXmppClientToServerConnectionModuleDescriptor.constructXmppConnectionModule(this.connectionInternal);
            this.connectionModules.put((Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>) cls, modularXmppClientToServerConnectionModuleConstructXmppConnectionModule);
            XmppClientToServerTransport transport = modularXmppClientToServerConnectionModuleConstructXmppConnectionModule.getTransport();
            if (transport != null) {
                this.transports.put((Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>) cls, transport);
            }
        }
        this.currentStateVertex = StateDescriptorGraph.convertToStateGraph(modularXmppClientToServerConnectionConfiguration.initialStateDescriptorVertex, this.connectionInternal);
    }

    public <CM extends ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor>> CM getConnectionModuleFor(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
        return (CM) this.connectionModules.get(cls);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void loginInternal(String str, String str2, Resourcepart resourcepart) throws SmackException, InterruptedException, IOException, XMPPException {
        walkStateGraph(buildNewWalkTo(AuthenticatedAndResourceBoundStateDescriptor.class).withLoginContext(str, str2, resourcepart).build());
    }

    protected WalkStateGraphContext.Builder buildNewWalkTo(Class<? extends StateDescriptor> cls) {
        return WalkStateGraphContext.builder(this.currentStateVertex.getElement().getStateDescriptor().getClass(), cls);
    }

    private void unwindState(State state) {
        invokeConnectionStateMachineListener(new ConnectionStateEvent.StateRevertBackwardsWalk(state));
        state.resetState();
    }

    protected void walkStateGraph(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
        StateDescriptorGraph.GraphVertex<State> graphVertex = this.currentStateVertex;
        try {
            walkStateGraphInternal(walkStateGraphContext);
        } catch (IOException | InterruptedException | SmackException | XMPPException e2) {
            this.currentStateVertex = graphVertex;
            unwindState(graphVertex.getElement());
            throw e2;
        }
    }

    private void walkStateGraphInternal(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
        StateDescriptorGraph.GraphVertex<State> graphVertex = this.currentStateVertex;
        State element = graphVertex.getElement();
        StateDescriptor stateDescriptor = element.getStateDescriptor();
        walkStateGraphContext.recordWalkTo(element);
        if (walkStateGraphContext.isWalksFinalState(stateDescriptor)) {
            invokeConnectionStateMachineListener(new ConnectionStateEvent.FinalStateReached(element));
            return;
        }
        List<StateDescriptorGraph.GraphVertex<State>> outgoingEdges = graphVertex.getOutgoingEdges();
        StateDescriptorGraph.GraphVertex<State> graphVertexMaybeReturnMandatoryImmediateState = walkStateGraphContext.maybeReturnMandatoryImmediateState(outgoingEdges);
        if (graphVertexMaybeReturnMandatoryImmediateState != null) {
            StateTransitionResult stateTransitionResultAttemptEnterState = attemptEnterState(graphVertexMaybeReturnMandatoryImmediateState, walkStateGraphContext);
            if (stateTransitionResultAttemptEnterState instanceof StateTransitionResult.Success) {
                walkStateGraph(walkStateGraphContext);
                return;
            }
            throw new StateMachineException.SmackMandatoryStateFailedException(graphVertexMaybeReturnMandatoryImmediateState.getElement(), stateTransitionResultAttemptEnterState);
        }
        Iterator<StateDescriptorGraph.GraphVertex<State>> it = outgoingEdges.iterator();
        while (it.hasNext()) {
            StateDescriptorGraph.GraphVertex<State> next = it.next();
            State element2 = next.getElement();
            if (walkStateGraphContext.wouldCauseCycle(next)) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionIgnoredDueCycle(graphVertex, next));
            } else {
                StateTransitionResult stateTransitionResultAttemptEnterState2 = attemptEnterState(next, walkStateGraphContext);
                if (stateTransitionResultAttemptEnterState2 instanceof StateTransitionResult.Success) {
                    break;
                } else if (stateTransitionResultAttemptEnterState2 != null) {
                    walkStateGraphContext.recordFailedState(element2, stateTransitionResultAttemptEnterState2);
                }
            }
            if (!it.hasNext()) {
                throw StateMachineException.SmackStateGraphDeadEndException.from(walkStateGraphContext, graphVertex);
            }
        }
        walkStateGraph(walkStateGraphContext);
    }

    private StateTransitionResult attemptEnterState(StateDescriptorGraph.GraphVertex<State> graphVertex, WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
        State element = this.currentStateVertex.getElement();
        State element2 = graphVertex.getElement();
        StateDescriptor stateDescriptor = element2.getStateDescriptor();
        if (!stateDescriptor.isMultiVisitState() && walkStateGraphContext.stateAlreadyVisited(element2)) {
            return null;
        }
        if (stateDescriptor.isNotImplemented()) {
            StateTransitionResult.TransitionImpossibleBecauseNotImplemented transitionImpossibleBecauseNotImplemented = new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(stateDescriptor);
            invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionNotPossible(element, element2, transitionImpossibleBecauseNotImplemented));
            return transitionImpossibleBecauseNotImplemented;
        }
        try {
            StateTransitionResult.TransitionImpossible transitionImpossibleIsTransitionToPossible = element2.isTransitionToPossible(walkStateGraphContext);
            if (transitionImpossibleIsTransitionToPossible != null) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionNotPossible(element, element2, transitionImpossibleIsTransitionToPossible));
                return transitionImpossibleIsTransitionToPossible;
            }
            invokeConnectionStateMachineListener(new ConnectionStateEvent.AboutToTransitionInto(element, element2));
            StateTransitionResult.AttemptResult attemptResultTransitionInto = element2.transitionInto(walkStateGraphContext);
            if (attemptResultTransitionInto instanceof StateTransitionResult.Failure) {
                invokeConnectionStateMachineListener(new ConnectionStateEvent.TransitionFailed(element, element2, (StateTransitionResult.Failure) attemptResultTransitionInto));
                return attemptResultTransitionInto;
            }
            StateTransitionResult.Success success = (StateTransitionResult.Success) attemptResultTransitionInto;
            this.currentStateVertex = graphVertex;
            invokeConnectionStateMachineListener(new ConnectionStateEvent.SuccessfullyTransitionedInto(element2, success));
            return success;
        } catch (IOException | InterruptedException | SmackException | XMPPException e2) {
            unwindState(element2);
            throw e2;
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        sendTopLevelStreamElement(stanza);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException {
        sendTopLevelStreamElement(nonza);
    }

    private void sendTopLevelStreamElement(TopLevelStreamElement topLevelStreamElement) throws SmackException.NotConnectedException, InterruptedException {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport == null) {
            throw new SmackException.NotConnectedException();
        }
        this.outgoingElementsQueue.put(topLevelStreamElement);
        xmppClientToServerTransport.notifyAboutNewOutgoingElements();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void shutdown() {
        shutdown(false);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public synchronized void instantShutdown() {
        shutdown(true);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public ModularXmppClientToServerConnectionConfiguration getConfiguration() {
        return this.configuration;
    }

    private void shutdown(boolean z) {
        Class<? extends StateDescriptor> cls;
        if (z) {
            cls = InstantShutdownStateDescriptor.class;
        } else {
            cls = ShutdownStateDescriptor.class;
        }
        try {
            walkStateGraph(buildNewWalkTo(DisconnectedStateDescriptor.class).withMandatoryIntermediateState(cls).build());
        } catch (IOException | InterruptedException | SmackException | XMPPException e2) {
            throw new IllegalStateException("A walk to disconnected state should never throw", e2);
        }
    }

    protected SSLSession getSSLSession() {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport == null) {
            return null;
        }
        return xmppClientToServerTransport.getSslSession();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void afterFeaturesReceived() {
        this.featuresReceived = true;
        notifyWaitingThreads();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[Catch: SmackParsingException -> 0x0075, StreamErrorException -> 0x0077, InterruptedException -> 0x0079, IOException -> 0x007b, IOException | InterruptedException | StreamErrorException | SmackParsingException | XmlPullParserException -> 0x007d, TryCatch #2 {IOException | InterruptedException | StreamErrorException | SmackParsingException | XmlPullParserException -> 0x007d, blocks: (B:2:0x0000, B:3:0x000b, B:30:0x0070, B:9:0x001b, B:10:0x0023, B:29:0x006d, B:12:0x0027, B:28:0x0069, B:15:0x0030, B:18:0x0039, B:19:0x0048, B:20:0x0049, B:23:0x0052, B:25:0x005a, B:26:0x0061), top: B:43:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void parseAndProcessElement(java.lang.String r3) {
        /*
            r2 = this;
            org.jivesoftware.smack.xml.XmlPullParser r3 = org.jivesoftware.smack.util.PacketParserUtils.getParserFor(r3)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r3.next()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r3.getEventType()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
        Lb:
            int[] r1 = org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection.AnonymousClass2.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            int r0 = r0.ordinal()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r0 = r1[r0]     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r1 = 1
            if (r0 == r1) goto L1b
            r1 = 2
            if (r0 == r1) goto L1a
            goto L70
        L1a:
            return
        L1b:
            java.lang.String r0 = r3.getName()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            int r1 = r0.hashCode()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            switch(r1) {
                case -1276666629: goto L61;
                case -290659267: goto L52;
                case 3368: goto L49;
                case 96784904: goto L30;
                case 954925063: goto L27;
                default: goto L26;
            }     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
        L26:
            goto L6d
        L27:
            java.lang.String r1 = "message"
            boolean r0 = r0.equals(r1)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            if (r0 == 0) goto L6d
            goto L69
        L30:
            java.lang.String r1 = "error"
            boolean r0 = r0.equals(r1)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            if (r0 != 0) goto L39
            goto L6d
        L39:
            r0 = 0
            org.jivesoftware.smack.packet.StreamError r3 = org.jivesoftware.smack.util.PacketParserUtils.parseStreamError(r3, r0)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            org.jivesoftware.smack.XMPPException$StreamErrorException r0 = new org.jivesoftware.smack.XMPPException$StreamErrorException     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r0.<init>(r3)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r2.currentXmppException = r0     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r2.notifyWaitingThreads()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            throw r0     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
        L49:
            java.lang.String r1 = "iq"
            boolean r0 = r0.equals(r1)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            if (r0 == 0) goto L6d
            goto L69
        L52:
            java.lang.String r1 = "features"
            boolean r0 = r0.equals(r1)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            if (r0 == 0) goto L6d
            r2.parseFeatures(r3)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            r2.afterFeaturesReceived()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            goto L70
        L61:
            java.lang.String r1 = "presence"
            boolean r0 = r0.equals(r1)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            if (r0 == 0) goto L6d
        L69:
            r2.parseAndProcessStanza(r3)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            goto L70
        L6d:
            r2.parseAndProcessNonza(r3)     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
        L70:
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r3.next()     // Catch: org.jivesoftware.smack.parsing.SmackParsingException -> L75 org.jivesoftware.smack.XMPPException.StreamErrorException -> L77 java.lang.InterruptedException -> L79 java.io.IOException -> L7b org.jivesoftware.smack.xml.XmlPullParserException -> L7d
            goto Lb
        L75:
            r3 = move-exception
            goto L7e
        L77:
            r3 = move-exception
            goto L7e
        L79:
            r3 = move-exception
            goto L7e
        L7b:
            r3 = move-exception
            goto L7e
        L7d:
            r3 = move-exception
        L7e:
            r2.notifyConnectionError(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection.parseAndProcessElement(java.lang.String):void");
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected synchronized void prepareToWaitForFeaturesReceived() {
        this.featuresReceived = false;
    }

    /* JADX INFO: renamed from: lambda$waitForFeaturesReceived$0$org-jivesoftware-smack-c2s-ModularXmppClientToServerConnection, reason: not valid java name */
    /* synthetic */ Boolean m14193x842603d3() {
        return Boolean.valueOf(this.featuresReceived);
    }

    protected void waitForFeaturesReceived(String str) throws SmackException, InterruptedException, XMPPException {
        waitForConditionOrThrowConnectionException(new Supplier() { // from class: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Supplier
            public final Object get() {
                return this.f$0.m14193x842603d3();
            }
        }, str);
    }

    protected void newStreamOpenWaitForFeaturesSequence(String str) throws SmackException, InterruptedException, XMPPException {
        prepareToWaitForFeaturesReceived();
        sendStreamOpen();
        waitForFeaturesReceived(str);
    }

    public static class DisconnectedStateDescriptor extends StateDescriptor {
        protected DisconnectedStateDescriptor() {
            super((Class<? extends State>) DisconnectedState.class, StateDescriptor.Property.finalState);
            addSuccessor(LookupRemoteConnectionEndpointsStateDescriptor.class);
        }
    }

    private final class DisconnectedState extends State {
        private DisconnectedState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            synchronized (ModularXmppClientToServerConnection.this) {
                if (ModularXmppClientToServerConnection.this.inputOutputFilters.isEmpty()) {
                    ModularXmppClientToServerConnection.this.previousInputOutputFilters = null;
                } else {
                    ModularXmppClientToServerConnection.this.previousInputOutputFilters = new ArrayList(ModularXmppClientToServerConnection.this.inputOutputFilters.size());
                    ModularXmppClientToServerConnection.this.previousInputOutputFilters.addAll(ModularXmppClientToServerConnection.this.inputOutputFilters);
                    ModularXmppClientToServerConnection.this.inputOutputFilters.clear();
                }
            }
            ListIterator listIterator = ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.listIterator(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.size());
            while (listIterator.hasPrevious()) {
                ((State) listIterator.previous()).resetState();
            }
            ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = null;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    public static final class LookupRemoteConnectionEndpointsStateDescriptor extends StateDescriptor {
        private LookupRemoteConnectionEndpointsStateDescriptor() {
            super((Class<? extends State>) LookupRemoteConnectionEndpointsState.class);
        }
    }

    private final class LookupRemoteConnectionEndpointsState extends State {
        boolean outgoingElementsQueueWasShutdown;

        private LookupRemoteConnectionEndpointsState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, SASLErrorException, IOException, XMPPException.XMPPErrorException, XMPPException.FailedNonzaException {
            HashMap map = new HashMap(ModularXmppClientToServerConnection.this.transports.size());
            ArrayList arrayList = new ArrayList();
            for (XmppClientToServerTransport xmppClientToServerTransport : ModularXmppClientToServerConnection.this.transports.values()) {
                xmppClientToServerTransport.resetDiscoveredConnectionEndpoints();
                List<SmackFuture<XmppClientToServerTransport.LookupConnectionEndpointsResult, Exception>> listLookupConnectionEndpoints = xmppClientToServerTransport.lookupConnectionEndpoints();
                map.put(xmppClientToServerTransport, listLookupConnectionEndpoints);
                arrayList.addAll(listLookupConnectionEndpoints);
            }
            int size = arrayList.size();
            SmackFuture.await(arrayList, ModularXmppClientToServerConnection.this.getReplyTimeout(), TimeUnit.MILLISECONDS);
            ArrayList arrayList2 = new ArrayList(size);
            boolean z = false;
            for (Map.Entry entry : map.entrySet()) {
                XmppClientToServerTransport xmppClientToServerTransport2 = (XmppClientToServerTransport) entry.getKey();
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    XmppClientToServerTransport.LookupConnectionEndpointsResult lookupConnectionEndpointsResult = (XmppClientToServerTransport.LookupConnectionEndpointsResult) ((SmackFuture) it.next()).getIfAvailable();
                    if (lookupConnectionEndpointsResult != null) {
                        if (lookupConnectionEndpointsResult instanceof XmppClientToServerTransport.LookupConnectionEndpointsFailed) {
                            arrayList2.add((XmppClientToServerTransport.LookupConnectionEndpointsFailed) lookupConnectionEndpointsResult);
                        } else {
                            xmppClientToServerTransport2.loadConnectionEndpoints((XmppClientToServerTransport.LookupConnectionEndpointsSuccess) lookupConnectionEndpointsResult);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                this.outgoingElementsQueueWasShutdown = ModularXmppClientToServerConnection.this.outgoingElementsQueue.start();
                return StateTransitionResult.Success.EMPTY_INSTANCE;
            }
            throw SmackException.NoEndpointsDiscoveredException.from(arrayList2);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            Iterator it = ModularXmppClientToServerConnection.this.transports.values().iterator();
            while (it.hasNext()) {
                ((XmppClientToServerTransport) it.next()).resetDiscoveredConnectionEndpoints();
            }
            if (this.outgoingElementsQueueWasShutdown) {
                ModularXmppClientToServerConnection.this.outgoingElementsQueue.shutdown();
            }
        }
    }

    public static final class ConnectedButUnauthenticatedStateDescriptor extends StateDescriptor {
        private ConnectedButUnauthenticatedStateDescriptor() {
            super((Class<? extends State>) ConnectedButUnauthenticatedState.class, StateDescriptor.Property.finalState);
            addSuccessor(SaslAuthenticationStateDescriptor.class);
            addSuccessor(InstantShutdownStateDescriptor.class);
            addSuccessor(ShutdownStateDescriptor.class);
        }
    }

    private final class ConnectedButUnauthenticatedState extends State {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private ConnectedButUnauthenticatedState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            if (walkStateGraphContext.isWalksFinalState(getStateDescriptor())) {
                ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = walkStateGraphContext.getWalk();
            }
            ModularXmppClientToServerConnection.this.connected = true;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            ModularXmppClientToServerConnection.this.connected = false;
        }
    }

    public static final class SaslAuthenticationStateDescriptor extends StateDescriptor {
        private SaslAuthenticationStateDescriptor() {
            super((Class<? extends State>) SaslAuthenticationState.class, "RFC 6120 § 6");
            addSuccessor(AuthenticatedButUnboundStateDescriptor.class);
        }
    }

    private final class SaslAuthenticationState extends State {
        private SaslAuthenticationState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
            ModularXmppClientToServerConnection.this.prepareToWaitForFeaturesReceived();
            LoginContext loginContext = walkStateGraphContext.getLoginContext();
            SASLMechanism sASLMechanismAuthenticate = ModularXmppClientToServerConnection.this.authenticate(loginContext.username, loginContext.password, ModularXmppClientToServerConnection.this.config.getAuthzid(), ModularXmppClientToServerConnection.this.getSSLSession());
            ModularXmppClientToServerConnection.this.waitForFeaturesReceived("server stream features after SASL authentication");
            return new SaslAuthenticationSuccessResult(sASLMechanismAuthenticate);
        }
    }

    public static final class SaslAuthenticationSuccessResult extends StateTransitionResult.Success {
        private final String saslMechanismName;

        private SaslAuthenticationSuccessResult(SASLMechanism sASLMechanism) {
            super("SASL authentication successfull using " + sASLMechanism.getName());
            this.saslMechanismName = sASLMechanism.getName();
        }

        public String getSaslMechanismName() {
            return this.saslMechanismName;
        }
    }

    public static final class AuthenticatedButUnboundStateDescriptor extends StateDescriptor {
        private AuthenticatedButUnboundStateDescriptor() {
            super(StateDescriptor.Property.multiVisitState);
            addSuccessor(ResourceBindingStateDescriptor.class);
        }
    }

    public static final class ResourceBindingStateDescriptor extends StateDescriptor {
        private ResourceBindingStateDescriptor() {
            super((Class<? extends State>) ResourceBindingState.class, "RFC 6120 § 7");
            addSuccessor(AuthenticatedAndResourceBoundStateDescriptor.class);
        }
    }

    private final class ResourceBindingState extends State {
        private ResourceBindingState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException {
            ModularXmppClientToServerConnection.this.lastFeaturesReceived = true;
            ModularXmppClientToServerConnection.this.notifyWaitingThreads();
            LoginContext loginContext = walkStateGraphContext.getLoginContext();
            Resourcepart resourcepartBindResourceAndEstablishSession = ModularXmppClientToServerConnection.this.bindResourceAndEstablishSession(loginContext.resource);
            ModularXmppClientToServerConnection.this.streamResumed = false;
            return new ResourceBoundResult(resourcepartBindResourceAndEstablishSession, loginContext.resource);
        }
    }

    public static final class ResourceBoundResult extends StateTransitionResult.Success {
        private final Resourcepart resource;

        private ResourceBoundResult(Resourcepart resourcepart, Resourcepart resourcepart2) {
            super("Resource '" + ((Object) resourcepart) + "' bound (requested: '" + ((Object) resourcepart2) + "')");
            this.resource = resourcepart;
        }

        public Resourcepart getResource() {
            return this.resource;
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isUsingCompression() {
        return this.compressionEnabled;
    }

    public static final class AuthenticatedAndResourceBoundStateDescriptor extends StateDescriptor {
        private AuthenticatedAndResourceBoundStateDescriptor() {
            super((Class<? extends State>) AuthenticatedAndResourceBoundState.class, StateDescriptor.Property.finalState);
            addSuccessor(InstantShutdownStateDescriptor.class);
            addSuccessor(ShutdownStateDescriptor.class);
        }
    }

    private final class AuthenticatedAndResourceBoundState extends State {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private AuthenticatedAndResourceBoundState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException.NotConnectedException, InterruptedException {
            if (ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated != null) {
                walkStateGraphContext.appendWalkTo(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated);
            } else {
                ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated = new ArrayList(walkStateGraphContext.getWalkLength() + 1);
                walkStateGraphContext.appendWalkTo(ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated);
            }
            ModularXmppClientToServerConnection.this.walkFromDisconnectToAuthenticated.add(this);
            ModularXmppClientToServerConnection modularXmppClientToServerConnection = ModularXmppClientToServerConnection.this;
            modularXmppClientToServerConnection.afterSuccessfulLogin(modularXmppClientToServerConnection.streamResumed);
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            ModularXmppClientToServerConnection.this.authenticated = false;
        }
    }

    static final class ShutdownStateDescriptor extends StateDescriptor {
        private ShutdownStateDescriptor() {
            super((Class<? extends State>) ShutdownState.class);
            addSuccessor(CloseConnectionStateDescriptor.class);
        }
    }

    private final class ShutdownState extends State {
        private ShutdownState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ensureNotOnOurWayToAuthenticatedAndResourceBound(walkStateGraphContext);
            return null;
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            ModularXmppClientToServerConnection.this.closingStreamReceived = false;
            if (ModularXmppClientToServerConnection.this.outgoingElementsQueue.offerAndShutdown(StreamClose.INSTANCE)) {
                ModularXmppClientToServerConnection.this.activeTransport.notifyAboutNewOutgoingElements();
                if (ModularXmppClientToServerConnection.this.waitForClosingStreamTagFromServer()) {
                    ListIterator<XmppInputOutputFilter> xmppInputOutputFilterBeginIterator = this.connectionInternal.getXmppInputOutputFilterBeginIterator();
                    while (xmppInputOutputFilterBeginIterator.hasNext()) {
                        xmppInputOutputFilterBeginIterator.next().closeInputOutput();
                    }
                    ModularXmppClientToServerConnection.this.activeTransport.afterFiltersClosed();
                    ListIterator<XmppInputOutputFilter> xmppInputOutputFilterBeginIterator2 = this.connectionInternal.getXmppInputOutputFilterBeginIterator();
                    while (xmppInputOutputFilterBeginIterator2.hasNext()) {
                        try {
                            xmppInputOutputFilterBeginIterator2.next().waitUntilInputOutputClosed();
                        } catch (IOException | InterruptedException | CertificateException | SmackException | XMPPException e2) {
                            ModularXmppClientToServerConnection.LOGGER.log(Level.WARNING, "waitUntilInputOutputClosed() threw", e2);
                        }
                    }
                    ModularXmppClientToServerConnection.this.authenticated = false;
                }
            }
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    static final class InstantShutdownStateDescriptor extends StateDescriptor {
        private InstantShutdownStateDescriptor() {
            super((Class<? extends State>) InstantShutdownState.class);
            addSuccessor(CloseConnectionStateDescriptor.class);
        }
    }

    private static final class InstantShutdownState extends NoOpState {
        private InstantShutdownState(ModularXmppClientToServerConnection modularXmppClientToServerConnection, StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(modularXmppClientToServerConnection, stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ensureNotOnOurWayToAuthenticatedAndResourceBound(walkStateGraphContext);
            return null;
        }
    }

    private static final class CloseConnectionStateDescriptor extends StateDescriptor {
        private CloseConnectionStateDescriptor() {
            super((Class<? extends State>) CloseConnectionState.class);
            addSuccessor(DisconnectedStateDescriptor.class);
        }
    }

    private final class CloseConnectionState extends State {
        private CloseConnectionState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            ModularXmppClientToServerConnection.this.activeTransport.disconnect();
            ModularXmppClientToServerConnection.this.activeTransport = null;
            ModularXmppClientToServerConnection modularXmppClientToServerConnection = ModularXmppClientToServerConnection.this;
            modularXmppClientToServerConnection.authenticated = modularXmppClientToServerConnection.connected = false;
            return StateTransitionResult.Success.EMPTY_INSTANCE;
        }
    }

    public void addConnectionStateMachineListener(ConnectionStateMachineListener connectionStateMachineListener) {
        this.connectionStateMachineListeners.add(connectionStateMachineListener);
    }

    public boolean removeConnectionStateMachineListener(ConnectionStateMachineListener connectionStateMachineListener) {
        return this.connectionStateMachineListeners.remove(connectionStateMachineListener);
    }

    protected void invokeConnectionStateMachineListener(final ConnectionStateEvent connectionStateEvent) {
        if (this.connectionStateMachineListeners.isEmpty()) {
            return;
        }
        ASYNC_BUT_ORDERED.performAsyncButOrdered(this, new Runnable() { // from class: org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14192x3ea6bcaa(connectionStateEvent);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$invokeConnectionStateMachineListener$1$org-jivesoftware-smack-c2s-ModularXmppClientToServerConnection, reason: not valid java name */
    /* synthetic */ void m14192x3ea6bcaa(ConnectionStateEvent connectionStateEvent) {
        Iterator<ConnectionStateMachineListener> it = this.connectionStateMachineListeners.iterator();
        while (it.hasNext()) {
            it.next().onConnectionStateEvent(connectionStateEvent, this);
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isSecureConnection() {
        XmppClientToServerTransport xmppClientToServerTransport = this.activeTransport;
        if (xmppClientToServerTransport == null) {
            return false;
        }
        return xmppClientToServerTransport.isTransportSecured();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    protected void connectInternal() throws SmackException, InterruptedException, IOException, XMPPException {
        walkStateGraph(buildNewWalkTo(ConnectedButUnauthenticatedStateDescriptor.class).build());
    }

    protected Map<String, Object> getFilterStats() {
        List<XmppInputOutputFilter> list;
        synchronized (this) {
            if (!this.inputOutputFilters.isEmpty() || (list = this.previousInputOutputFilters) == null) {
                list = this.inputOutputFilters;
            }
        }
        HashMap map = new HashMap(list.size());
        for (XmppInputOutputFilter xmppInputOutputFilter : list) {
            map.put(xmppInputOutputFilter.getFilterName(), xmppInputOutputFilter.getStats());
        }
        return map;
    }

    public Stats getStats() {
        HashMap map = new HashMap(this.transports.size());
        for (Map.Entry<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport> entry : this.transports.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getStats());
        }
        return new Stats(map, getFilterStats());
    }

    public static final class Stats extends AbstractStats {
        public final Map<String, Object> filtersStats;
        public final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport.Stats> transportsStats;

        private Stats(Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport.Stats> map, Map<String, Object> map2) {
            this.transportsStats = Collections.unmodifiableMap(map);
            this.filtersStats = Collections.unmodifiableMap(map2);
        }

        @Override // org.jivesoftware.smack.internal.AbstractStats
        public void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException {
            StringUtils.appendHeading(extendedAppendable, "Connection stats", CsvReader.Letters.POUND).append('\n');
            for (Map.Entry<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, XmppClientToServerTransport.Stats> entry : this.transportsStats.entrySet()) {
                Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> key = entry.getKey();
                XmppClientToServerTransport.Stats value = entry.getValue();
                StringUtils.appendHeading(extendedAppendable, key.getName());
                extendedAppendable.append((CharSequence) value.toString()).append('\n');
            }
            for (Map.Entry<String, Object> entry2 : this.filtersStats.entrySet()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();
                StringUtils.appendHeading(extendedAppendable, key2);
                extendedAppendable.append((CharSequence) value2.toString()).append('\n');
            }
        }
    }
}
