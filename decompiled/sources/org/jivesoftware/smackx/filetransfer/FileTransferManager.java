package org.jivesoftware.smackx.filetransfer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.EntityFullJid;

/* JADX INFO: loaded from: classes10.dex */
public final class FileTransferManager extends Manager {
    private static final Map<XMPPConnection, FileTransferManager> INSTANCES = new WeakHashMap();
    private final FileTransferNegotiator fileTransferNegotiator;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final List<FileTransferListener> f1496listeners;

    public static synchronized FileTransferManager getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferManager fileTransferManager;
        Map<XMPPConnection, FileTransferManager> map = INSTANCES;
        fileTransferManager = map.get(xMPPConnection);
        if (fileTransferManager == null) {
            fileTransferManager = new FileTransferManager(xMPPConnection);
            map.put(xMPPConnection, fileTransferManager);
        }
        return fileTransferManager;
    }

    private FileTransferManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.f1496listeners = new CopyOnWriteArrayList();
        this.fileTransferNegotiator = FileTransferNegotiator.getInstanceFor(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("si", "http://jabber.org/protocol/si", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.filetransfer.FileTransferManager.1
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                FileTransferRequest fileTransferRequest = new FileTransferRequest(FileTransferManager.this, (StreamInitiation) iq);
                Iterator it = FileTransferManager.this.f1496listeners.iterator();
                while (it.hasNext()) {
                    ((FileTransferListener) it.next()).fileTransferRequest(fileTransferRequest);
                }
                return null;
            }
        });
    }

    public void addFileTransferListener(FileTransferListener fileTransferListener) {
        this.f1496listeners.add(fileTransferListener);
    }

    public void removeFileTransferListener(FileTransferListener fileTransferListener) {
        this.f1496listeners.remove(fileTransferListener);
    }

    public OutgoingFileTransfer createOutgoingFileTransfer(EntityFullJid entityFullJid) {
        if (entityFullJid == null) {
            throw new IllegalArgumentException("userID was null");
        }
        return new OutgoingFileTransfer(connection().getUser(), entityFullJid, FileTransferNegotiator.getNextStreamID(), this.fileTransferNegotiator);
    }

    protected IncomingFileTransfer createIncomingFileTransfer(FileTransferRequest fileTransferRequest) {
        if (fileTransferRequest == null) {
            throw new NullPointerException("ReceiveRequest cannot be null");
        }
        IncomingFileTransfer incomingFileTransfer = new IncomingFileTransfer(fileTransferRequest, this.fileTransferNegotiator);
        incomingFileTransfer.setFileInfo(fileTransferRequest.getFileName(), fileTransferRequest.getFileSize());
        return incomingFileTransfer;
    }

    protected void rejectIncomingFileTransfer(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(fileTransferRequest.getStreamInitiation(), StanzaError.getBuilder(StanzaError.Condition.forbidden).build()));
    }
}
