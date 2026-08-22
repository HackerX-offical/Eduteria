package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IBBTransferNegotiator extends StreamNegotiator {
    private final InBandBytestreamManager manager;

    protected IBBTransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.manager = InBandBytestreamManager.getByteStreamManager(xMPPConnection);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public OutputStream createOutgoingStream(String str, Jid jid, Jid jid2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        InBandBytestreamSession inBandBytestreamSessionEstablishSession = this.manager.establishSession(jid2, str);
        inBandBytestreamSessionEstablishSession.setCloseBothStreamsEnabled(true);
        return inBandBytestreamSessionEstablishSession.getOutputStream();
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.manager.ignoreBytestreamRequestOnce(streamInitiation.getSessionID());
        return negotiateIncomingStream(initiateIncomingStream(connection(), streamInitiation));
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public void newStreamInitiation(Jid jid, String str) {
        this.manager.ignoreBytestreamRequestOnce(str);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public String getNamespace() {
        return "http://jabber.org/protocol/ibb";
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    InputStream negotiateIncomingStream(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        InBandBytestreamSession inBandBytestreamSessionAccept = new ByteStreamRequest(this.manager, (Open) stanza).accept();
        inBandBytestreamSessionAccept.setCloseBothStreamsEnabled(true);
        return inBandBytestreamSessionAccept.getInputStream();
    }

    private static final class ByteStreamRequest extends InBandBytestreamRequest {
        private ByteStreamRequest(InBandBytestreamManager inBandBytestreamManager, Open open) {
            super(inBandBytestreamManager, open);
        }
    }
}
