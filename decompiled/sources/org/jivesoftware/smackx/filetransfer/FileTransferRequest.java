package org.jivesoftware.smackx.filetransfer;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class FileTransferRequest {
    private final FileTransferManager manager;
    private final StreamInitiation streamInitiation;

    public FileTransferRequest(FileTransferManager fileTransferManager, StreamInitiation streamInitiation) {
        this.streamInitiation = streamInitiation;
        this.manager = fileTransferManager;
    }

    public String getFileName() {
        return this.streamInitiation.getFile().getName();
    }

    public long getFileSize() {
        return this.streamInitiation.getFile().getSize();
    }

    public String getDescription() {
        return this.streamInitiation.getFile().getDesc();
    }

    public String getMimeType() {
        return this.streamInitiation.getMimeType();
    }

    public Jid getRequestor() {
        return this.streamInitiation.getFrom();
    }

    public String getStreamID() {
        return this.streamInitiation.getSessionID();
    }

    protected StreamInitiation getStreamInitiation() {
        return this.streamInitiation;
    }

    public IncomingFileTransfer accept() {
        return this.manager.createIncomingFileTransfer(this);
    }

    public void reject() throws SmackException.NotConnectedException, InterruptedException {
        this.manager.rejectIncomingFileTransfer(this);
    }
}
