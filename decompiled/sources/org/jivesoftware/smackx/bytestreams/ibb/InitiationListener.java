package org.jivesoftware.smackx.bytestreams.ibb;

import java.util.Iterator;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.filetransfer.StreamNegotiator;

/* JADX INFO: loaded from: classes10.dex */
class InitiationListener extends AbstractIqRequestHandler {
    private final InBandBytestreamManager manager;

    protected InitiationListener(InBandBytestreamManager inBandBytestreamManager) {
        super("open", "http://jabber.org/protocol/ibb", IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = inBandBytestreamManager;
    }

    @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQ handleIQRequest(IQ iq) {
        Open open = (Open) iq;
        int blockSize = open.getBlockSize();
        int maximumBlockSize = this.manager.getMaximumBlockSize();
        if (blockSize > maximumBlockSize) {
            return IQ.createErrorResponse(iq, StanzaError.getBuilder().setCondition(StanzaError.Condition.resource_constraint).setDescriptiveEnText("Requests block size of " + blockSize + " exceeds maximum block size of " + maximumBlockSize).build());
        }
        StreamNegotiator.signal(open.getFrom().toString() + '\t' + open.getSessionID(), open);
        if (this.manager.getIgnoredBytestreamRequests().remove(open.getSessionID())) {
            return null;
        }
        InBandBytestreamRequest inBandBytestreamRequest = new InBandBytestreamRequest(this.manager, open);
        BytestreamListener userListener = this.manager.getUserListener(open.getFrom());
        if (userListener != null) {
            userListener.incomingBytestreamRequest(inBandBytestreamRequest);
        } else if (!this.manager.getAllRequestListeners().isEmpty()) {
            Iterator<BytestreamListener> it = this.manager.getAllRequestListeners().iterator();
            while (it.hasNext()) {
                it.next().incomingBytestreamRequest(inBandBytestreamRequest);
            }
        } else {
            return IQ.createErrorResponse(iq, StanzaError.getBuilder().setCondition(StanzaError.Condition.not_acceptable).setDescriptiveEnText("No file-transfer listeners registered").build());
        }
        return null;
    }
}
