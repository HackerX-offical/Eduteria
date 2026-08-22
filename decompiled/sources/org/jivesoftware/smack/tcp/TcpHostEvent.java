package org.jivesoftware.smack.tcp;

import java.io.IOException;
import org.jivesoftware.smack.fsm.ConnectionStateEvent;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.tcp.rce.Rfc6120TcpRemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

/* JADX INFO: loaded from: classes10.dex */
public abstract class TcpHostEvent extends ConnectionStateEvent.DetailedTransitionIntoInformation {
    protected final RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> address;

    protected TcpHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
        super(state);
        this.address = inetSocketAddressCoupling;
    }

    public RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> getAddress() {
        return this.address;
    }

    @Override // org.jivesoftware.smack.fsm.ConnectionStateEvent
    public String toString() {
        return super.toString() + ": " + this.address;
    }

    public static final class ConnectingToHostEvent extends TcpHostEvent {
        ConnectingToHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling) {
            super(state, inetSocketAddressCoupling);
        }
    }

    public static final class ConnectedToHostEvent extends TcpHostEvent {
        private final boolean connectionEstablishedImmediately;

        ConnectedToHostEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling, boolean z) {
            super(state, inetSocketAddressCoupling);
            this.connectionEstablishedImmediately = z;
        }

        @Override // org.jivesoftware.smack.tcp.TcpHostEvent, org.jivesoftware.smack.fsm.ConnectionStateEvent
        public String toString() {
            return super.toString() + (this.connectionEstablishedImmediately ? "" : " not") + " connected immediately";
        }
    }

    public static final class ConnectionToHostFailedEvent extends TcpHostEvent {
        private final IOException ioException;

        ConnectionToHostFailedEvent(State state, RemoteConnectionEndpoint.InetSocketAddressCoupling<Rfc6120TcpRemoteConnectionEndpoint> inetSocketAddressCoupling, IOException iOException) {
            super(state, inetSocketAddressCoupling);
            this.ioException = iOException;
        }

        @Override // org.jivesoftware.smack.tcp.TcpHostEvent, org.jivesoftware.smack.fsm.ConnectionStateEvent
        public String toString() {
            return super.toString() + this.ioException;
        }
    }
}
