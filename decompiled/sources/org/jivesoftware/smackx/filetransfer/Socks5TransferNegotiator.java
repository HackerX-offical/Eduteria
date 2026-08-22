package org.jivesoftware.smackx.filetransfer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5TransferNegotiator extends StreamNegotiator {
    private final Socks5BytestreamManager manager;

    Socks5TransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.manager = Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public OutputStream createOutgoingStream(String str, Jid jid, Jid jid2) throws SmackException, XMPPException {
        try {
            return this.manager.establishSession(jid2, str).getOutputStream();
        } catch (IOException e2) {
            throw new SmackException.SmackWrappedException("error establishing SOCKS5 Bytestream", e2);
        } catch (InterruptedException e3) {
            throw new SmackException.SmackWrappedException("error establishing SOCKS5 Bytestream", e3);
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        this.manager.ignoreBytestreamRequestOnce(streamInitiation.getSessionID());
        return negotiateIncomingStream(initiateIncomingStream(connection(), streamInitiation));
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public void newStreamInitiation(Jid jid, String str) {
        this.manager.ignoreBytestreamRequestOnce(str);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public String getNamespace() {
        return Bytestream.NAMESPACE;
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    InputStream negotiateIncomingStream(Stanza stanza) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            PushbackInputStream pushbackInputStream = new PushbackInputStream(new ByteStreamRequest(this.manager, (Bytestream) stanza).accept().getInputStream());
            pushbackInputStream.unread(pushbackInputStream.read());
            return pushbackInputStream;
        } catch (IOException e2) {
            throw new SmackException.SmackWrappedException("Error establishing input stream", e2);
        }
    }

    private static final class ByteStreamRequest extends Socks5BytestreamRequest {
        private ByteStreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
            super(socks5BytestreamManager, bytestream);
        }
    }
}
