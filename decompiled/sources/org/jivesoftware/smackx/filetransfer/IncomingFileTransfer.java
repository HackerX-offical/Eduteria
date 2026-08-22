package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smackx.filetransfer.FileTransfer;

/* JADX INFO: loaded from: classes10.dex */
public class IncomingFileTransfer extends FileTransfer {
    private static final Logger LOGGER = Logger.getLogger(IncomingFileTransfer.class.getName());
    private InputStream inputStream;
    private FileTransferRequest receiveRequest;

    protected IncomingFileTransfer(FileTransferRequest fileTransferRequest, FileTransferNegotiator fileTransferNegotiator) {
        super(fileTransferRequest.getRequestor(), fileTransferRequest.getStreamID(), fileTransferNegotiator);
        this.receiveRequest = fileTransferRequest;
    }

    public InputStream receiveFile() throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.inputStream != null) {
            throw new IllegalStateException("Transfer already negotiated!");
        }
        try {
            InputStream inputStreamNegotiateStream = negotiateStream();
            this.inputStream = inputStreamNegotiateStream;
            return inputStreamNegotiateStream;
        } catch (XMPPException.XMPPErrorException e2) {
            setException(e2);
            throw e2;
        }
    }

    public void receiveFile(final File file) throws SmackException, IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file.canWrite()) {
            throw new IllegalArgumentException("Cannot write to provided file");
        }
        new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.1
            @Override // java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                IOException e2;
                FileNotFoundException e3;
                try {
                    IncomingFileTransfer incomingFileTransfer = IncomingFileTransfer.this;
                    incomingFileTransfer.inputStream = incomingFileTransfer.negotiateStream();
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException e4) {
                        fileOutputStream = null;
                        e3 = e4;
                    } catch (IOException e5) {
                        fileOutputStream = null;
                        e2 = e5;
                    }
                    try {
                        IncomingFileTransfer.this.setStatus(FileTransfer.Status.in_progress);
                        IncomingFileTransfer incomingFileTransfer2 = IncomingFileTransfer.this;
                        incomingFileTransfer2.writeToStream(incomingFileTransfer2.inputStream, fileOutputStream);
                    } catch (FileNotFoundException e6) {
                        e3 = e6;
                        IncomingFileTransfer.this.setStatus(FileTransfer.Status.error);
                        IncomingFileTransfer.this.setError(FileTransfer.Error.bad_file);
                        IncomingFileTransfer.this.setException(e3);
                    } catch (IOException e7) {
                        e2 = e7;
                        IncomingFileTransfer.this.setStatus(FileTransfer.Status.error);
                        IncomingFileTransfer.this.setError(FileTransfer.Error.stream);
                        IncomingFileTransfer.this.setException(e2);
                    }
                    if (IncomingFileTransfer.this.getStatus().equals(FileTransfer.Status.in_progress)) {
                        IncomingFileTransfer.this.setStatus(FileTransfer.Status.complete);
                    }
                    CloseableUtil.maybeClose(IncomingFileTransfer.this.inputStream, IncomingFileTransfer.LOGGER);
                    CloseableUtil.maybeClose(fileOutputStream, IncomingFileTransfer.LOGGER);
                } catch (Exception e8) {
                    IncomingFileTransfer.this.setStatus(FileTransfer.Status.error);
                    IncomingFileTransfer.this.setException(e8);
                }
            }
        }, "File Transfer " + this.streamID).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream negotiateStream() throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        setStatus(FileTransfer.Status.negotiating_transfer);
        final StreamNegotiator streamNegotiatorSelectStreamNegotiator = this.negotiator.selectStreamNegotiator(this.receiveRequest);
        setStatus(FileTransfer.Status.negotiating_stream);
        FutureTask futureTask = new FutureTask(new Callable<InputStream>() { // from class: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public InputStream call() throws Exception {
                return streamNegotiatorSelectStreamNegotiator.createIncomingStream(IncomingFileTransfer.this.receiveRequest.getStreamInitiation());
            }
        });
        futureTask.run();
        try {
            try {
                try {
                    InputStream inputStream = (InputStream) futureTask.get(15L, TimeUnit.SECONDS);
                    futureTask.cancel(true);
                    setStatus(FileTransfer.Status.negotiated);
                    return inputStream;
                } catch (TimeoutException e2) {
                    throw new SmackException.SmackWrappedException("Request timed out", e2);
                }
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof XMPPException.XMPPErrorException) {
                    throw ((XMPPException.XMPPErrorException) cause);
                }
                if (cause instanceof InterruptedException) {
                    throw ((InterruptedException) cause);
                }
                if (cause instanceof SmackException.NoResponseException) {
                    throw ((SmackException.NoResponseException) cause);
                }
                if (cause instanceof SmackException) {
                    throw ((SmackException) cause);
                }
                throw new SmackException.SmackWrappedException("Error in execution", e3);
            }
        } catch (Throwable th) {
            futureTask.cancel(true);
            throw th;
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }
}
