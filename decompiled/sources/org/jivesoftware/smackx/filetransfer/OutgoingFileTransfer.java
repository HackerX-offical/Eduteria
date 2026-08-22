package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smackx.filetransfer.FileTransfer;
import org.joda.time.DateTimeConstants;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class OutgoingFileTransfer extends FileTransfer {
    private static final Logger LOGGER = Logger.getLogger(OutgoingFileTransfer.class.getName());
    private static int RESPONSE_TIMEOUT = DateTimeConstants.MILLIS_PER_MINUTE;
    private NegotiationProgress callback;
    private Jid initiator;
    private OutputStream outputStream;
    private Thread transferThread;

    public interface NegotiationProgress {
        void errorEstablishingStream(Exception exc);

        void outputStreamEstablished(OutputStream outputStream);

        void statusUpdated(FileTransfer.Status status, FileTransfer.Status status2);
    }

    public static int getResponseTimeout() {
        return RESPONSE_TIMEOUT;
    }

    public static void setResponseTimeout(int i) {
        RESPONSE_TIMEOUT = i;
    }

    protected OutgoingFileTransfer(Jid jid, Jid jid2, String str, FileTransferNegotiator fileTransferNegotiator) {
        super(jid2, str, fileTransferNegotiator);
        this.initiator = jid;
    }

    protected void setOutputStream(OutputStream outputStream) {
        if (this.outputStream == null) {
            this.outputStream = outputStream;
        }
    }

    protected OutputStream getOutputStream() {
        if (getStatus().equals(FileTransfer.Status.negotiated)) {
            return this.outputStream;
        }
        return null;
    }

    public synchronized OutputStream sendFile(String str, long j, String str2) throws SmackException, InterruptedException, XMPPException {
        OutputStream outputStreamNegotiateStream;
        if (isDone() || this.outputStream != null) {
            throw new IllegalStateException("The negotiation process has already been attempted on this file transfer");
        }
        try {
            setFileInfo(str, j);
            outputStreamNegotiateStream = negotiateStream(str, j, str2);
            this.outputStream = outputStreamNegotiateStream;
        } catch (XMPPException.XMPPErrorException e2) {
            handleXMPPException(e2);
            throw e2;
        }
        return outputStreamNegotiateStream;
    }

    public synchronized void sendFile(final String str, final long j, final String str2, final NegotiationProgress negotiationProgress) throws Throwable {
        try {
            if (negotiationProgress == null) {
                throw new IllegalArgumentException("Callback progress cannot be null.");
            }
            try {
                checkTransferThread();
                if (isDone() || this.outputStream != null) {
                    throw new IllegalStateException("The negotiation process has already been attempted for this file transfer");
                }
                setFileInfo(str, j);
                this.callback = negotiationProgress;
                Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                            outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(str, j, str2);
                            negotiationProgress.outputStreamEstablished(OutgoingFileTransfer.this.outputStream);
                        } catch (XMPPException.XMPPErrorException e2) {
                            OutgoingFileTransfer.this.handleXMPPException(e2);
                        } catch (Exception e3) {
                            OutgoingFileTransfer.this.setException(e3);
                        }
                    }
                }, "File Transfer Negotiation " + this.streamID);
                this.transferThread = thread;
                thread.start();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void checkTransferThread() {
        Thread thread = this.transferThread;
        if ((thread != null && thread.isAlive()) || isDone()) {
            throw new IllegalStateException("File transfer in progress or has already completed.");
        }
    }

    public synchronized void sendFile(final File file, final String str) throws SmackException {
        checkTransferThread();
        if (file == null || !file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("Could not read file");
        }
        setFileInfo(file.getAbsolutePath(), file.getName(), file.length());
        Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer] */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v16, types: [java.util.logging.Logger] */
            /* JADX WARN: Type inference failed for: r1v2, types: [org.jivesoftware.smackx.filetransfer.FileTransfer$Status] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Throwable th;
                FileInputStream fileInputStream;
                IOException e2;
                FileNotFoundException e3;
                try {
                    OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                    outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(file.getName(), file.length(), str);
                } catch (XMPPException.XMPPErrorException e4) {
                    OutgoingFileTransfer.this.handleXMPPException(e4);
                    return;
                } catch (Exception e5) {
                    OutgoingFileTransfer.this.setException(e5);
                }
                if (OutgoingFileTransfer.this.outputStream == null) {
                    return;
                }
                ?? r0 = OutgoingFileTransfer.this;
                ?? r1 = FileTransfer.Status.negotiated;
                if (r0.updateStatus(r1, FileTransfer.Status.in_progress)) {
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                OutgoingFileTransfer outgoingFileTransfer2 = OutgoingFileTransfer.this;
                                outgoingFileTransfer2.writeToStream(fileInputStream, outgoingFileTransfer2.outputStream);
                            } catch (FileNotFoundException e6) {
                                e3 = e6;
                                OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                                OutgoingFileTransfer.this.setError(FileTransfer.Error.bad_file);
                                OutgoingFileTransfer.this.setException(e3);
                            } catch (IOException e7) {
                                e2 = e7;
                                OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                                OutgoingFileTransfer.this.setException(e2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            CloseableUtil.maybeClose(r1, OutgoingFileTransfer.LOGGER);
                            CloseableUtil.maybeClose(OutgoingFileTransfer.this.outputStream, OutgoingFileTransfer.LOGGER);
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        fileInputStream = null;
                        e3 = e8;
                    } catch (IOException e9) {
                        fileInputStream = null;
                        e2 = e9;
                    } catch (Throwable th3) {
                        r1 = 0;
                        th = th3;
                        CloseableUtil.maybeClose(r1, OutgoingFileTransfer.LOGGER);
                        CloseableUtil.maybeClose(OutgoingFileTransfer.this.outputStream, OutgoingFileTransfer.LOGGER);
                        throw th;
                    }
                    CloseableUtil.maybeClose(fileInputStream, OutgoingFileTransfer.LOGGER);
                    OutputStream outputStream = OutgoingFileTransfer.this.outputStream;
                    r1 = OutgoingFileTransfer.LOGGER;
                    CloseableUtil.maybeClose(outputStream, r1);
                    OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.in_progress, FileTransfer.Status.complete);
                }
            }
        }, "File Transfer " + this.streamID);
        this.transferThread = thread;
        thread.start();
    }

    public synchronized void sendStream(final InputStream inputStream, final String str, final long j, final String str2) throws Throwable {
        try {
            try {
                checkTransferThread();
                setFileInfo(str, j);
                Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                            outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(str, j, str2);
                        } catch (XMPPException.XMPPErrorException e2) {
                            OutgoingFileTransfer.this.handleXMPPException(e2);
                            return;
                        } catch (Exception e3) {
                            OutgoingFileTransfer.this.setException(e3);
                        }
                        if (OutgoingFileTransfer.this.outputStream != null && OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.negotiated, FileTransfer.Status.in_progress)) {
                            try {
                                try {
                                    OutgoingFileTransfer outgoingFileTransfer2 = OutgoingFileTransfer.this;
                                    outgoingFileTransfer2.writeToStream(inputStream, outgoingFileTransfer2.outputStream);
                                } catch (IOException e4) {
                                    OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                                    OutgoingFileTransfer.this.setException(e4);
                                }
                                OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.in_progress, FileTransfer.Status.complete);
                            } finally {
                                CloseableUtil.maybeClose(inputStream, OutgoingFileTransfer.LOGGER);
                                CloseableUtil.maybeClose(OutgoingFileTransfer.this.outputStream, OutgoingFileTransfer.LOGGER);
                            }
                        }
                    }
                }, "File Transfer " + this.streamID);
                this.transferThread = thread;
                thread.start();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public void setCallback(NegotiationProgress negotiationProgress) {
        this.callback = negotiationProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleXMPPException(XMPPException.XMPPErrorException xMPPErrorException) {
        StanzaError stanzaError = xMPPErrorException.getStanzaError();
        if (stanzaError != null) {
            int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[stanzaError.getCondition().ordinal()];
            if (i == 1) {
                setStatus(FileTransfer.Status.refused);
                return;
            } else if (i == 2) {
                setStatus(FileTransfer.Status.error);
                setError(FileTransfer.Error.not_acceptable);
            } else {
                setStatus(FileTransfer.Status.error);
            }
        }
        setException(xMPPErrorException);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition;

        static {
            int[] iArr = new int[StanzaError.Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition = iArr;
            try {
                iArr[StanzaError.Condition.forbidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[StanzaError.Condition.bad_request.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public long getBytesSent() {
        return this.amountWritten;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputStream negotiateStream(String str, long j, String str2) throws SmackException, InterruptedException, XMPPException {
        if (!updateStatus(FileTransfer.Status.initial, FileTransfer.Status.negotiating_transfer)) {
            throw new SmackException.IllegalStateChangeException();
        }
        StreamNegotiator streamNegotiatorNegotiateOutgoingTransfer = this.negotiator.negotiateOutgoingTransfer(getPeer(), this.streamID, str, j, str2, RESPONSE_TIMEOUT);
        if (!updateStatus(FileTransfer.Status.negotiating_transfer, FileTransfer.Status.negotiating_stream)) {
            throw new SmackException.IllegalStateChangeException();
        }
        this.outputStream = streamNegotiatorNegotiateOutgoingTransfer.createOutgoingStream(this.streamID, this.initiator, getPeer());
        if (!updateStatus(FileTransfer.Status.negotiating_stream, FileTransfer.Status.negotiated)) {
            throw new SmackException.IllegalStateChangeException();
        }
        return this.outputStream;
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    protected boolean updateStatus(FileTransfer.Status status, FileTransfer.Status status2) {
        boolean zUpdateStatus = super.updateStatus(status, status2);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null && zUpdateStatus) {
            negotiationProgress.statusUpdated(status, status2);
        }
        return zUpdateStatus;
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    protected void setStatus(FileTransfer.Status status) {
        FileTransfer.Status status2 = getStatus();
        super.setStatus(status);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.statusUpdated(status2, status);
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    protected void setException(Exception exc) {
        super.setException(exc);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.errorEstablishingStream(exc);
        }
    }
}
