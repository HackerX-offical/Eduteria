package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.EventManger;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StreamNegotiator extends Manager {
    protected static final EventManger<String, IQ, SmackException.NotConnectedException> initationSetEvents = new EventManger<>();

    public abstract InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract OutputStream createOutgoingStream(String str, Jid jid, Jid jid2) throws SmackException, InterruptedException, XMPPException;

    public abstract String getNamespace();

    abstract InputStream negotiateIncomingStream(Stanza stanza) throws SmackException, InterruptedException, XMPPException.XMPPErrorException;

    protected abstract void newStreamInitiation(Jid jid, String str);

    protected StreamNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    protected static StreamInitiation createInitiationAccept(StreamInitiation streamInitiation, String str) {
        StreamInitiation streamInitiation2 = new StreamInitiation();
        streamInitiation2.setTo(streamInitiation.getFrom());
        streamInitiation2.setFrom(streamInitiation.getTo());
        streamInitiation2.setType(IQ.Type.result);
        streamInitiation2.setStanzaId(streamInitiation.getStanzaId());
        DataForm.Builder builder = DataForm.builder();
        ListSingleFormField.Builder builderListSingleBuilder = FormField.listSingleBuilder("stream-method");
        builderListSingleBuilder.setValue(str);
        builder.addField(builderListSingleBuilder.build());
        streamInitiation2.setFeatureNegotiationForm(builder.build());
        return streamInitiation2;
    }

    protected final IQ initiateIncomingStream(final XMPPConnection xMPPConnection, StreamInitiation streamInitiation) throws Exception {
        final StreamInitiation streamInitiationCreateInitiationAccept = createInitiationAccept(streamInitiation, getNamespace());
        newStreamInitiation(streamInitiation.getFrom(), streamInitiation.getSessionID());
        try {
            IQ iqPerformActionAndWaitForEvent = initationSetEvents.performActionAndWaitForEvent(streamInitiation.getFrom().toString() + '\t' + streamInitiation.getSessionID(), xMPPConnection.getReplyTimeout(), new EventManger.Callback<SmackException.NotConnectedException>() { // from class: org.jivesoftware.smackx.filetransfer.StreamNegotiator.1
                @Override // org.jivesoftware.smack.util.EventManger.Callback
                public void action() throws SmackException.NotConnectedException {
                    try {
                        xMPPConnection.sendStanza(streamInitiationCreateInitiationAccept);
                    } catch (InterruptedException unused) {
                    }
                }
            });
            if (iqPerformActionAndWaitForEvent == null) {
                throw SmackException.NoResponseException.newWith(xMPPConnection, "stream initiation");
            }
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(iqPerformActionAndWaitForEvent);
            return iqPerformActionAndWaitForEvent;
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void signal(String str, IQ iq) {
        initationSetEvents.signalEvent(str, iq);
    }
}
