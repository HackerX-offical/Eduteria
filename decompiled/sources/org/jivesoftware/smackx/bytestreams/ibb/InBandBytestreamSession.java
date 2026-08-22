package org.jivesoftware.smackx.bytestreams.ibb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.bytestreams.BytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class InBandBytestreamSession implements BytestreamSession {
    private static final Logger LOGGER = Logger.getLogger(InBandBytestreamSession.class.getName());
    static final String UNEXPECTED_IBB_SEQUENCE = "Unexpected IBB sequence";
    private final Open byteStreamRequest;
    private final XMPPConnection connection;
    private IBBInputStream inputStream;
    private IBBOutputStream outputStream;
    private Jid remoteJID;
    private boolean closeBothStreamsEnabled = false;
    private boolean isClosed = false;

    protected InBandBytestreamSession(XMPPConnection xMPPConnection, Open open, Jid jid) {
        this.connection = xMPPConnection;
        this.byteStreamRequest = open;
        this.remoteJID = jid;
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType[open.getStanza().ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        if (i == 1) {
            this.inputStream = new IQIBBInputStream(this, anonymousClass1);
            this.outputStream = new IQIBBOutputStream(this, anonymousClass1);
        } else {
            if (i != 2) {
                return;
            }
            this.inputStream = new MessageIBBInputStream(this, anonymousClass1);
            this.outputStream = new MessageIBBOutputStream(this, anonymousClass1);
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType;

        static {
            int[] iArr = new int[InBandBytestreamManager.StanzaType.values().length];
            $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType = iArr;
            try {
                iArr[InBandBytestreamManager.StanzaType.IQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType[InBandBytestreamManager.StanzaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public int getReadTimeout() {
        return this.inputStream.readTimeout;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Timeout must be >= 0");
        }
        this.inputStream.readTimeout = i;
    }

    public boolean isCloseBothStreamsEnabled() {
        return this.closeBothStreamsEnabled;
    }

    public void setCloseBothStreamsEnabled(boolean z) {
        this.closeBothStreamsEnabled = z;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public void close() throws IOException {
        closeByLocal(true);
        closeByLocal(false);
    }

    protected void closeByPeer(Close close) throws SmackException.NotConnectedException, InterruptedException {
        this.inputStream.closeInternal();
        this.inputStream.cleanup();
        this.outputStream.closeInternal(false);
        this.connection.sendStanza(IQ.createResultIQ(close));
    }

    protected synchronized void closeByLocal(boolean z) throws IOException {
        if (this.isClosed) {
            return;
        }
        if (this.closeBothStreamsEnabled) {
            this.inputStream.closeInternal();
            this.outputStream.closeInternal(true);
        } else if (!z) {
            this.outputStream.closeInternal(true);
        } else {
            this.inputStream.closeInternal();
        }
        if (this.inputStream.isClosed && this.outputStream.isClosed) {
            this.isClosed = true;
            Close close = new Close(this.byteStreamRequest.getSessionID());
            close.setTo(this.remoteJID);
            try {
                this.connection.createStanzaCollectorAndSend(close).nextResultOrThrow();
                this.inputStream.cleanup();
                InBandBytestreamManager.getByteStreamManager(this.connection).getSessions().remove(this.byteStreamRequest.getSessionID());
            } catch (Exception e2) {
                IOException iOException = new IOException();
                iOException.initCause(e2);
                throw iOException;
            }
        }
    }

    private abstract class IBBInputStream extends InputStream {
        private byte[] buffer;
        private final StanzaListener dataPacketListener;
        protected final BlockingQueue<DataPacketExtension> dataQueue = new LinkedBlockingQueue();
        private int bufferPointer = -1;
        private UInt16 expectedSeq = UInt16.MIN_VALUE;
        private boolean isClosed = false;
        private boolean closeInvoked = false;
        private int readTimeout = 0;

        protected abstract StanzaFilter getDataPacketFilter();

        protected abstract StanzaListener getDataPacketListener();

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        protected IBBInputStream() {
            StanzaListener dataPacketListener = getDataPacketListener();
            this.dataPacketListener = dataPacketListener;
            InBandBytestreamSession.this.connection.addSyncStanzaListener(dataPacketListener, getDataPacketFilter());
        }

        @Override // java.io.InputStream
        public synchronized int read() throws IOException {
            checkClosed();
            int i = this.bufferPointer;
            if ((i == -1 || i >= this.buffer.length) && !loadBuffer()) {
                return -1;
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPointer;
            this.bufferPointer = i2 + 1;
            return bArr[i2] & 255;
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            checkClosed();
            int i4 = this.bufferPointer;
            if ((i4 == -1 || i4 >= this.buffer.length) && !loadBuffer()) {
                return -1;
            }
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i5 = this.bufferPointer;
            int i6 = length - i5;
            if (i2 > i6) {
                i2 = i6;
            }
            System.arraycopy(bArr2, i5, bArr, i, i2);
            this.bufferPointer += i2;
            return i2;
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        private synchronized boolean loadBuffer() throws IOException {
            DataPacketExtension dataPacketExtensionPoll;
            try {
                int i = this.readTimeout;
                if (i == 0) {
                    dataPacketExtensionPoll = null;
                    while (dataPacketExtensionPoll == null) {
                        if (this.isClosed && this.dataQueue.isEmpty()) {
                            return false;
                        }
                        dataPacketExtensionPoll = this.dataQueue.poll(1000L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    dataPacketExtensionPoll = this.dataQueue.poll(i, TimeUnit.MILLISECONDS);
                    if (dataPacketExtensionPoll == null) {
                        throw new SocketTimeoutException();
                    }
                }
                UInt16 seq = dataPacketExtensionPoll.getSeq();
                if (!this.expectedSeq.equals(seq)) {
                    InBandBytestreamSession.this.close();
                    throw new IOException("Unexpected IBB sequence " + ((Object) seq) + " received, expected " + ((Object) this.expectedSeq));
                }
                this.expectedSeq = seq.incrementedByOne();
                this.buffer = dataPacketExtensionPoll.getDecodedData();
                this.bufferPointer = 0;
                return true;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        private void checkClosed() throws IOException {
            if (this.closeInvoked) {
                this.dataQueue.clear();
                throw new IOException("Stream is closed");
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closeInvoked) {
                return;
            }
            this.closeInvoked = true;
            InBandBytestreamSession.this.closeByLocal(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeInternal() {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanup() {
            InBandBytestreamSession.this.connection.removeSyncStanzaListener(this.dataPacketListener);
        }
    }

    private class IQIBBInputStream extends IBBInputStream {
        private IQIBBInputStream() {
            super();
        }

        /* synthetic */ IQIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        protected StanzaListener getDataPacketListener() {
            return new StanzaListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IQIBBInputStream.1
                private UInt16 expectedSequence = UInt16.MIN_VALUE;

                @Override // org.jivesoftware.smack.StanzaListener
                public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                    Data data = (Data) stanza;
                    DataPacketExtension dataPacketExtension = data.getDataPacketExtension();
                    UInt16 seq = dataPacketExtension.getSeq();
                    if (!this.expectedSequence.equals(seq)) {
                        String str = "Unexpected IBB sequence " + ((Object) seq) + " received, expected " + ((Object) this.expectedSequence);
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse(data, StanzaError.getBuilder().setCondition(StanzaError.Condition.unexpected_request).setDescriptiveEnText(str).build()));
                        try {
                            IQIBBInputStream.this.close();
                            return;
                        } catch (IOException unused) {
                            InBandBytestreamSession.LOGGER.log(Level.FINER, "Could not close session, because of IOException. Close reason: " + str);
                            return;
                        }
                    }
                    if (dataPacketExtension.getDecodedData() == null) {
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse((IQ) stanza, StanzaError.Condition.bad_request));
                    } else {
                        this.expectedSequence = seq.incrementedByOne();
                        IQIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createResultIQ((IQ) stanza));
                    }
                }
            };
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        protected StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Data.class), new IBBDataPacketFilter(InBandBytestreamSession.this, null));
        }
    }

    private class MessageIBBInputStream extends IBBInputStream {
        private MessageIBBInputStream() {
            super();
        }

        /* synthetic */ MessageIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        protected StanzaListener getDataPacketListener() {
            return new StanzaListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.MessageIBBInputStream.1
                @Override // org.jivesoftware.smack.StanzaListener
                public void processStanza(Stanza stanza) {
                    DataPacketExtension dataPacketExtension = (DataPacketExtension) stanza.getExtension(DataPacketExtension.class);
                    if (dataPacketExtension.getDecodedData() == null) {
                        return;
                    }
                    MessageIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                }
            };
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        protected StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Message.class), new IBBDataPacketFilter(InBandBytestreamSession.this, null));
        }
    }

    private class IBBDataPacketFilter implements StanzaFilter {
        private IBBDataPacketFilter() {
        }

        /* synthetic */ IBBDataPacketFilter(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.jivesoftware.smack.filter.StanzaFilter
        public boolean accept(Stanza stanza) {
            DataPacketExtension dataPacketExtension;
            if (!stanza.getFrom().equals((CharSequence) InBandBytestreamSession.this.remoteJID)) {
                return false;
            }
            if (stanza instanceof Data) {
                dataPacketExtension = ((Data) stanza).getDataPacketExtension();
            } else {
                dataPacketExtension = (DataPacketExtension) stanza.getExtension(DataPacketExtension.class);
                if (dataPacketExtension == null) {
                    return false;
                }
            }
            return dataPacketExtension.getSessionID().equals(InBandBytestreamSession.this.byteStreamRequest.getSessionID());
        }
    }

    private abstract class IBBOutputStream extends OutputStream {
        protected final byte[] buffer;
        protected int bufferPointer;
        protected boolean isClosed;
        protected UInt16 seq;

        protected abstract void writeToXML(DataPacketExtension dataPacketExtension) throws SmackException.NotConnectedException, InterruptedException, IOException;

        /* synthetic */ IBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        private IBBOutputStream() {
            this.bufferPointer = 0;
            this.seq = UInt16.from(0);
            this.isClosed = false;
            this.buffer = new byte[InBandBytestreamSession.this.byteStreamRequest.getBlockSize()];
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) throws IOException {
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            if (this.bufferPointer >= this.buffer.length) {
                flushBuffer();
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPointer;
            this.bufferPointer = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            byte[] bArr2 = this.buffer;
            if (i2 >= bArr2.length) {
                writeOut(bArr, i, bArr2.length);
                byte[] bArr3 = this.buffer;
                write(bArr, i + bArr3.length, i2 - bArr3.length);
            } else {
                writeOut(bArr, i, i2);
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        private synchronized void writeOut(byte[] bArr, int i, int i2) throws IOException {
            int length;
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            byte[] bArr2 = this.buffer;
            int length2 = bArr2.length;
            int i3 = this.bufferPointer;
            if (i2 > length2 - i3) {
                length = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length);
                this.bufferPointer += length;
                flushBuffer();
            } else {
                length = 0;
            }
            int i4 = i2 - length;
            System.arraycopy(bArr, i + length, this.buffer, this.bufferPointer, i4);
            this.bufferPointer += i4;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            flushBuffer();
        }

        private synchronized void flushBuffer() throws IOException {
            int i = this.bufferPointer;
            if (i == 0) {
                return;
            }
            try {
                writeToXML(new DataPacketExtension(InBandBytestreamSession.this.byteStreamRequest.getSessionID(), this.seq, Base64.encodeToString(this.buffer, 0, i)));
                this.bufferPointer = 0;
                this.seq = this.seq.incrementedByOne();
            } catch (InterruptedException | SmackException.NotConnectedException e2) {
                IOException iOException = new IOException();
                iOException.initCause(e2);
                throw iOException;
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.isClosed) {
                return;
            }
            InBandBytestreamSession.this.closeByLocal(false);
        }

        protected void closeInternal(boolean z) {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
            if (z) {
                try {
                    flushBuffer();
                } catch (IOException unused) {
                }
            }
        }
    }

    private class IQIBBOutputStream extends IBBOutputStream {
        private IQIBBOutputStream() {
            super(InBandBytestreamSession.this, null);
        }

        /* synthetic */ IQIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBOutputStream
        protected synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws IOException {
            Data data = new Data(dataPacketExtension);
            data.setTo(InBandBytestreamSession.this.remoteJID);
            try {
                InBandBytestreamSession.this.connection.createStanzaCollectorAndSend(data).nextResultOrThrow();
            } catch (Exception e2) {
                if (!this.isClosed) {
                    InBandBytestreamSession.this.close();
                    IOException iOException = new IOException();
                    iOException.initCause(e2);
                    throw iOException;
                }
            }
        }
    }

    private class MessageIBBOutputStream extends IBBOutputStream {
        private MessageIBBOutputStream() {
            super(InBandBytestreamSession.this, null);
        }

        /* synthetic */ MessageIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBOutputStream
        protected synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws SmackException.NotConnectedException, InterruptedException {
            InBandBytestreamSession.this.connection.sendStanza(((MessageBuilder) ((MessageBuilder) StanzaBuilder.buildMessage().to(InBandBytestreamSession.this.remoteJID)).addExtension(dataPacketExtension)).build());
        }
    }

    public void processIQPacket(Data data) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        this.inputStream.dataPacketListener.processStanza(data);
    }
}
