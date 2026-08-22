package org.jivesoftware.smackx.filetransfer;

import com.facebook.internal.AnalyticsEvents;
import com.paytm.pgsdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FileTransfer {
    private static final int BUFFER_SIZE = 8192;
    private Error error;
    private Exception exception;
    private String fileName;
    private String filePath;
    private long fileSize;
    protected FileTransferNegotiator negotiator;
    private Jid peer;
    protected String streamID;
    private Status status = Status.initial;
    private final Object statusMonitor = new Object();
    protected long amountWritten = -1;

    public abstract void cancel();

    protected FileTransfer(Jid jid, String str, FileTransferNegotiator fileTransferNegotiator) {
        this.peer = jid;
        this.streamID = str;
        this.negotiator = fileTransferNegotiator;
    }

    protected void setFileInfo(String str, long j) {
        this.fileName = str;
        this.fileSize = j;
    }

    protected void setFileInfo(String str, String str2, long j) {
        this.filePath = str;
        this.fileName = str2;
        this.fileSize = j;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Jid getPeer() {
        return this.peer;
    }

    public double getProgress() {
        long j = this.amountWritten;
        if (j <= 0) {
            return 0.0d;
        }
        long j2 = this.fileSize;
        if (j2 <= 0) {
            return 0.0d;
        }
        return j / j2;
    }

    public boolean isDone() {
        return this.status == Status.cancelled || this.status == Status.error || this.status == Status.complete || this.status == Status.refused;
    }

    public Status getStatus() {
        return this.status;
    }

    protected void setError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return this.error;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getStreamID() {
        return this.streamID;
    }

    protected void setException(Exception exc) {
        this.exception = exc;
        Status status = getStatus();
        if (status != Status.error) {
            updateStatus(status, Status.error);
        }
    }

    protected void setStatus(Status status) {
        synchronized (this.statusMonitor) {
            this.status = status;
        }
    }

    protected boolean updateStatus(Status status, Status status2) {
        synchronized (this.statusMonitor) {
            if (status != this.status) {
                return false;
            }
            this.status = status2;
            return true;
        }
    }

    protected void writeToStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.amountWritten = 0L;
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0 || getStatus().equals(Status.cancelled)) {
                break;
            }
            outputStream.write(bArr, 0, i);
            this.amountWritten += (long) i;
        }
        if (getStatus().equals(Status.cancelled) || getError() != null || this.amountWritten == this.fileSize) {
            return;
        }
        setStatus(Status.error);
        this.error = Error.connection;
    }

    public enum Status {
        error(Constants.EVENT_ACTION_ERROR),
        initial("Initial"),
        negotiating_transfer("Negotiating Transfer"),
        refused("Refused"),
        negotiating_stream("Negotiating Stream"),
        negotiated("Negotiated"),
        in_progress("In Progress"),
        complete("Complete"),
        cancelled(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);

        private final String status;

        Status(String str) {
            this.status = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.status;
        }
    }

    public long getAmountWritten() {
        return this.amountWritten;
    }

    public enum Error {
        not_acceptable("The peer did not find any of the provided stream mechanisms acceptable."),
        bad_file("The provided file to transfer does not exist or could not be read."),
        no_response("The remote user did not respond or the connection timed out."),
        connection("An error occurred over the socket connected to send the file."),
        stream("An error occurred while sending or receiving the file.");

        private final String msg;

        Error(String str) {
            this.msg = str;
        }

        public String getMessage() {
            return this.msg;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.msg;
        }
    }
}
