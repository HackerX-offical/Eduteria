package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5ClientForInitiator extends Socks5Client {
    private WeakReference<XMPPConnection> connection;
    private String sessionID;
    private final Jid target;

    public Socks5ClientForInitiator(Bytestream.StreamHost streamHost, String str, XMPPConnection xMPPConnection, String str2, Jid jid) {
        super(streamHost, str);
        this.connection = new WeakReference<>(xMPPConnection);
        this.sessionID = str2;
        this.target = jid;
    }

    @Override // org.jivesoftware.smackx.bytestreams.socks5.Socks5Client
    public Socket getSocket(int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, TimeoutException, IOException, SmackException.SmackMessageException, XMPPException {
        if (this.streamHost.getJID().equals((CharSequence) this.connection.get().getUser())) {
            Socket socketForDigest = Socks5Proxy.getSocketForDigest(this.digest);
            if (socketForDigest != null) {
                return socketForDigest;
            }
            throw new SmackException.SmackMessageException("target is not connected to SOCKS5 proxy");
        }
        Socket socket = super.getSocket(i);
        try {
            activate();
            return socket;
        } catch (SmackException.NoResponseException e2) {
            socket.close();
            throw e2;
        } catch (XMPPException e3) {
            socket.close();
            throw e3;
        }
    }

    private void activate() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.connection.get().createStanzaCollectorAndSend(createStreamHostActivation()).nextResultOrThrow();
    }

    private Bytestream createStreamHostActivation() {
        Bytestream bytestream = new Bytestream(this.sessionID);
        bytestream.setMode(null);
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(this.streamHost.getJID());
        bytestream.setToActivate(this.target);
        return bytestream;
    }
}
