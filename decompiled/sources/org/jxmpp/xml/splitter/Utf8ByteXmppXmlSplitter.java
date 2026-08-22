package org.jxmpp.xml.splitter;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import okio.Utf8;

/* JADX INFO: loaded from: classes10.dex */
public class Utf8ByteXmppXmlSplitter extends OutputStream {
    private final byte[] buffer;
    private byte count;
    private byte expectedLength;
    private char[] writeBuffer;
    private int writeBufferPos;
    private final XmppXmlSplitter xmppXmlSplitter;

    public Utf8ByteXmppXmlSplitter(XmppElementCallback xmppElementCallback) {
        this(new XmppXmlSplitter(xmppElementCallback));
    }

    public Utf8ByteXmppXmlSplitter(XmppXmlSplitter xmppXmlSplitter) {
        this.buffer = new byte[6];
        this.writeBuffer = new char[1024];
        this.xmppXmlSplitter = xmppXmlSplitter;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write((byte) (i & 255));
    }

    public void write(byte b2) throws IOException {
        process(b2);
        afterInputProcessed();
    }

    public void write(ByteBuffer[] byteBufferArr) throws IOException {
        write(Arrays.asList(byteBufferArr));
    }

    public void write(Collection<? extends ByteBuffer> collection) throws IOException {
        Iterator<? extends ByteBuffer> it = collection.iterator();
        int iRemaining = 0;
        while (it.hasNext()) {
            iRemaining += it.next().remaining();
        }
        ensureWriteBufferHasCapacityFor(iRemaining);
        Iterator<? extends ByteBuffer> it2 = collection.iterator();
        while (it2.hasNext()) {
            writeByteBufferInternal(it2.next());
        }
        afterInputProcessed();
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        ensureWriteBufferHasCapacityFor(byteBuffer.remaining());
        writeByteBufferInternal(byteBuffer);
        afterInputProcessed();
    }

    private void writeByteBufferInternal(ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            writeInternal(byteBuffer.array(), byteBuffer.arrayOffset(), iRemaining);
        } else {
            int iPosition = byteBuffer.position();
            for (int i = 0; i < iRemaining; i++) {
                process(byteBuffer.get(iPosition + i));
            }
        }
        byteBuffer.flip();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ensureWriteBufferHasCapacityFor(i2);
        writeInternal(bArr, i, i2);
        afterInputProcessed();
    }

    private void writeInternal(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            process(bArr[i + i3]);
        }
    }

    public void resetWriteBuffer(int i) {
        this.writeBuffer = new char[i];
        this.writeBufferPos = 0;
    }

    private void process(byte b2) throws IOException {
        int i;
        byte[] bArr = this.buffer;
        byte b3 = this.count;
        bArr[b3] = b2;
        int i2 = 1;
        if (b3 == 0) {
            int i3 = bArr[0] & 255;
            if (i3 < 128) {
                this.expectedLength = (byte) 1;
            } else if (i3 < 224) {
                this.expectedLength = (byte) 2;
            } else if (i3 < 240) {
                this.expectedLength = (byte) 3;
            } else if (i3 < 248) {
                this.expectedLength = (byte) 4;
            } else {
                throw new IOException("Invalid first UTF-8 byte: " + i3);
            }
        }
        byte b4 = (byte) (b3 + 1);
        this.count = b4;
        byte b5 = this.expectedLength;
        if (b4 == b5) {
            if (b5 != 1) {
                if (b5 == 2) {
                    i = (bArr[0] & Ascii.US) << 6;
                } else if (b5 == 3) {
                    i = (bArr[0] & Ascii.SI) << 12;
                } else if (b5 == 4) {
                    i = (bArr[0] & 6) << 18;
                } else {
                    throw new IllegalStateException();
                }
                while (true) {
                    byte b6 = this.expectedLength;
                    if (i2 >= b6) {
                        break;
                    }
                    i |= (this.buffer[i2] & Utf8.REPLACEMENT_BYTE) << (((b6 - 1) - i2) * 6);
                    i2++;
                }
            } else {
                i = bArr[0] & 127;
            }
            ensureWriteBufferHasCapacityFor(2);
            if (i < 65536) {
                appendToWriteBuffer((char) i);
            } else {
                appendToWriteBuffer((char) (((-6291456) & i) + 55296));
                appendToWriteBuffer((char) ((i & 1023) + Utf8.LOG_SURROGATE_HEADER));
            }
            this.count = (byte) 0;
        }
    }

    private void afterInputProcessed() throws IOException {
        this.xmppXmlSplitter.write(this.writeBuffer, 0, this.writeBufferPos);
        this.writeBufferPos = 0;
    }

    private void appendToWriteBuffer(char c2) {
        char[] cArr = this.writeBuffer;
        int i = this.writeBufferPos;
        this.writeBufferPos = i + 1;
        cArr[i] = c2;
    }

    private void ensureWriteBufferHasCapacityFor(int i) {
        int i2 = this.writeBufferPos;
        int i3 = i + i2;
        char[] cArr = this.writeBuffer;
        if (i3 <= cArr.length) {
            return;
        }
        char[] cArr2 = new char[i3];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        this.writeBuffer = cArr2;
    }
}
