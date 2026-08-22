package org.jivesoftware.smack.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackReactor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.tcp.TcpHostEvent;
import org.jivesoftware.smack.tcp.XmppTcpTransportModule;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;

/* JADX INFO: loaded from: classes10.dex */
public final class ConnectionAttemptState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean connected;
    Rfc6120TcpRemoteConnectionEndpoint connectionEndpoint;
    final Iterator<Rfc6120TcpRemoteConnectionEndpoint> connectionEndpointIterator;
    SmackException.EndpointConnectionException connectionException;
    final List<RemoteConnectionException<?>> connectionExceptions;
    private final ModularXmppClientToServerConnectionInternal connectionInternal;
    long deadline;
    private final XmppTcpTransportModule.XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredEndpoints;
    private final XmppTcpTransportModule.EstablishingTcpConnectionState establishingTcpConnectionState;
    Iterator<? extends InetAddress> inetAddressIterator;
    final SocketChannel socketChannel;

    ConnectionAttemptState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, XmppTcpTransportModule.XmppTcpNioTransport.DiscoveredTcpEndpoints discoveredTcpEndpoints, XmppTcpTransportModule.EstablishingTcpConnectionState establishingTcpConnectionState) throws IOException {
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
        this.discoveredEndpoints = discoveredTcpEndpoints;
        this.establishingTcpConnectionState = establishingTcpConnectionState;
        SocketChannel socketChannelOpen = SocketChannel.open();
        this.socketChannel = socketChannelOpen;
        socketChannelOpen.configureBlocking(false);
        List<RCE> list = discoveredTcpEndpoints.result.discoveredRemoteConnectionEndpoints;
        this.connectionEndpointIterator = list.iterator();
        this.connectionExceptions = new ArrayList(list.size());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r0 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        return new org.jivesoftware.smack.fsm.StateTransitionResult.FailureCausedByException(r5.connectionException);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    org.jivesoftware.smack.fsm.StateTransitionResult.Failure establishTcpConnection() throws java.lang.InterruptedException {
        /*
            r5 = this;
            org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint$InetSocketAddressCoupling r0 = r5.nextAddress()
            r5.establishTcpConnection(r0)
            monitor-enter(r5)
        L8:
            boolean r0 = r5.connected     // Catch: java.lang.Throwable -> L35
            if (r0 != 0) goto L28
            org.jivesoftware.smack.SmackException$EndpointConnectionException r1 = r5.connectionException     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L28
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L35
            long r2 = r5.deadline     // Catch: java.lang.Throwable -> L35
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L23
            org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByTimeout r0 = new org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByTimeout     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "Timeout waiting to establish connection"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L35
            return r0
        L23:
            long r2 = r2 - r0
            r5.wait(r2)     // Catch: java.lang.Throwable -> L35
            goto L8
        L28:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L2d
            r0 = 0
            return r0
        L2d:
            org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByException r0 = new org.jivesoftware.smack.fsm.StateTransitionResult$FailureCausedByException
            org.jivesoftware.smack.SmackException$EndpointConnectionException r1 = r5.connectionException
            r0.<init>(r1)
            return r0
        L35:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L35
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.ConnectionAttemptState.establishTcpConnection():org.jivesoftware.smack.fsm.StateTransitionResult$Failure");
    }

    private void establishTcpConnection(final RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectingToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling));
        InetSocketAddress inetSocketAddress = inetSocketAddressCoupling.getInetSocketAddress();
        this.deadline = System.currentTimeMillis() + this.connectionInternal.connection.getReplyTimeout();
        try {
            boolean zConnect = this.socketChannel.connect(inetSocketAddress);
            this.connected = zConnect;
            if (zConnect) {
                this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectedToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling, true));
                synchronized (this) {
                    notifyAll();
                }
                return;
            }
            try {
                this.connectionInternal.registerWithSelector(this.socketChannel, 8, new SmackReactor.ChannelSelectedCallback() { // from class: org.jivesoftware.smack.tcp.ConnectionAttemptState$$ExternalSyntheticLambda0
                    @Override // org.jivesoftware.smack.SmackReactor.ChannelSelectedCallback
                    public final void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey) {
                        this.f$0.m14212x67f1cc08(inetSocketAddressCoupling, selectableChannel, selectionKey);
                    }
                });
            } catch (ClosedChannelException e2) {
                m14210xe0db9086(e2, inetSocketAddressCoupling);
            }
        } catch (IOException e3) {
            m14210xe0db9086(e3, inetSocketAddressCoupling);
        }
    }

    /* JADX INFO: renamed from: lambda$establishTcpConnection$2$org-jivesoftware-smack-tcp-ConnectionAttemptState, reason: not valid java name */
    /* synthetic */ void m14212x67f1cc08(final RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling, SelectableChannel selectableChannel, SelectionKey selectionKey) {
        try {
            if (!((SocketChannel) selectableChannel).finishConnect()) {
                Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.ConnectionAttemptState$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m14211x2466ae47(inetSocketAddressCoupling);
                    }
                });
                return;
            }
            this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectedToHostEvent(this.establishingTcpConnectionState, inetSocketAddressCoupling, false));
            this.connected = true;
            synchronized (this) {
                notifyAll();
            }
        } catch (IOException e2) {
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.ConnectionAttemptState$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14210xe0db9086(e2, inetSocketAddressCoupling);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$establishTcpConnection$1$org-jivesoftware-smack-tcp-ConnectionAttemptState, reason: not valid java name */
    /* synthetic */ void m14211x2466ae47(RemoteConnectionEndpoint.InetSocketAddressCoupling inetSocketAddressCoupling) {
        m14210xe0db9086(new IOException("finishConnect() failed"), inetSocketAddressCoupling);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onIOExceptionWhenEstablishingTcpConnection, reason: merged with bridge method [inline-methods] */
    public void m14210xe0db9086(IOException iOException, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCouplingNextAddress = nextAddress();
        if (inetSocketAddressCouplingNextAddress == null) {
            this.connectionException = SmackException.EndpointConnectionException.from(this.discoveredEndpoints.result.lookupFailures, this.connectionExceptions);
            synchronized (this) {
                notifyAll();
            }
        } else {
            this.connectionExceptions.add(new RemoteConnectionException<>(inetSocketAddressCoupling, iOException));
            this.connectionInternal.invokeConnectionStateMachineListener(new TcpHostEvent.ConnectionToHostFailedEvent(this.establishingTcpConnectionState, inetSocketAddressCouplingNextAddress, iOException));
            establishTcpConnection(inetSocketAddressCouplingNextAddress);
        }
    }

    private RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> nextAddress() {
        Iterator<? extends InetAddress> it = this.inetAddressIterator;
        if (it == null || !it.hasNext()) {
            if (!this.connectionEndpointIterator.hasNext()) {
                return null;
            }
            Rfc6120TcpRemoteConnectionEndpoint next = this.connectionEndpointIterator.next();
            this.connectionEndpoint = next;
            this.inetAddressIterator = next.getInetAddresses().iterator();
        }
        return new RemoteConnectionEndpoint.InetSocketAddressCoupling<>(this.connectionEndpoint, this.inetAddressIterator.next());
    }
}
