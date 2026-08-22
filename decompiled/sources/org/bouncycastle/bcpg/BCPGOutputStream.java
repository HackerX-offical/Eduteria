package org.bouncycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class BCPGOutputStream extends OutputStream implements PacketTags, CompressionAlgorithmTags {
    private static final int BUF_SIZE_POWER = 16;
    OutputStream out;
    private byte[] partialBuffer;
    private int partialBufferLength;
    private int partialOffset;
    private int partialPower;

    public BCPGOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public BCPGOutputStream(OutputStream outputStream, int i) throws IOException {
        this.out = outputStream;
        writeHeader(i, true, true, 0L);
    }

    public BCPGOutputStream(OutputStream outputStream, int i, long j) throws IOException {
        this.out = outputStream;
        writeHeader(i, false, false, j);
    }

    public BCPGOutputStream(OutputStream outputStream, int i, long j, boolean z) throws IOException {
        this.out = outputStream;
        if (j <= 4294967295L) {
            writeHeader(i, z, false, j);
            return;
        }
        writeHeader(i, false, true, 0L);
        this.partialBufferLength = 65536;
        this.partialBuffer = new byte[65536];
        this.partialPower = 16;
        this.partialOffset = 0;
    }

    public BCPGOutputStream(OutputStream outputStream, int i, byte[] bArr) throws IOException {
        this.out = outputStream;
        writeHeader(i, false, true, 0L);
        this.partialBuffer = bArr;
        int length = bArr.length;
        this.partialPower = 0;
        while (length != 1) {
            length >>>= 1;
            this.partialPower++;
        }
        int i2 = this.partialPower;
        if (i2 > 30) {
            throw new IOException("Buffer cannot be greater than 2^30 in length.");
        }
        this.partialBufferLength = 1 << i2;
        this.partialOffset = 0;
    }

    private void partialFlush(boolean z) throws IOException {
        if (z) {
            writeNewPacketLength(this.partialOffset);
            this.out.write(this.partialBuffer, 0, this.partialOffset);
        } else {
            this.out.write(this.partialPower | 224);
            this.out.write(this.partialBuffer, 0, this.partialBufferLength);
        }
        this.partialOffset = 0;
    }

    private void writeHeader(int i, boolean z, boolean z2, long j) throws IOException {
        if (this.partialBuffer != null) {
            partialFlush(true);
            this.partialBuffer = null;
        }
        if (!z) {
            write(i | 192);
            if (z2) {
                this.partialOffset = 0;
                return;
            } else {
                writeNewPacketLength(j);
                return;
            }
        }
        int i2 = i << 2;
        int i3 = i2 | 128;
        if (z2) {
            write(i2 | 131);
            return;
        }
        if (j <= 255) {
            write(i3);
            write((byte) j);
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            write(i2 | 129);
            write((byte) (j >> 8));
            write((byte) j);
        } else {
            write(i2 | 130);
            write((byte) (j >> 24));
            write((byte) (j >> 16));
            write((byte) (j >> 8));
            write((byte) j);
        }
    }

    private void writeNewPacketLength(long j) throws IOException {
        if (j >= 192) {
            if (j <= 8383) {
                j -= 192;
                this.out.write((byte) (((j >> 8) & 255) + 192));
            } else {
                this.out.write(255);
                this.out.write((byte) (j >> 24));
                this.out.write((byte) (j >> 16));
                this.out.write((byte) (j >> 8));
            }
        }
        this.out.write((byte) j);
    }

    private void writePartial(byte b2) throws IOException {
        if (this.partialOffset == this.partialBufferLength) {
            partialFlush(false);
        }
        byte[] bArr = this.partialBuffer;
        int i = this.partialOffset;
        this.partialOffset = i + 1;
        bArr[i] = b2;
    }

    private void writePartial(byte[] bArr, int i, int i2) throws IOException {
        if (this.partialOffset == this.partialBufferLength) {
            partialFlush(false);
        }
        int i3 = this.partialBufferLength;
        int i4 = this.partialOffset;
        if (i2 <= i3 - i4) {
            System.arraycopy(bArr, i, this.partialBuffer, i4, i2);
        } else {
            System.arraycopy(bArr, i, this.partialBuffer, i4, i3 - i4);
            int i5 = this.partialBufferLength;
            int i6 = this.partialOffset;
            int i7 = i + (i5 - i6);
            int i8 = i5 - i6;
            while (true) {
                i2 -= i8;
                partialFlush(false);
                int i9 = this.partialBufferLength;
                if (i2 <= i9) {
                    break;
                }
                System.arraycopy(bArr, i7, this.partialBuffer, 0, i9);
                i8 = this.partialBufferLength;
                i7 += i8;
            }
            System.arraycopy(bArr, i7, this.partialBuffer, 0, i2);
        }
        this.partialOffset += i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        this.out.flush();
        this.out.close();
    }

    public void finish() throws IOException {
        if (this.partialBuffer != null) {
            partialFlush(true);
            Arrays.fill(this.partialBuffer, (byte) 0);
            this.partialBuffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.partialBuffer != null) {
            writePartial((byte) i);
        } else {
            this.out.write(i);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.partialBuffer != null) {
            writePartial(bArr, i, i2);
        } else {
            this.out.write(bArr, i, i2);
        }
    }

    public void writeObject(BCPGObject bCPGObject) throws IOException {
        bCPGObject.encode(this);
    }

    void writePacket(int i, byte[] bArr, boolean z) throws IOException {
        writeHeader(i, z, false, bArr.length);
        write(bArr);
    }

    public void writePacket(ContainedPacket containedPacket) throws IOException {
        containedPacket.encode(this);
    }
}
