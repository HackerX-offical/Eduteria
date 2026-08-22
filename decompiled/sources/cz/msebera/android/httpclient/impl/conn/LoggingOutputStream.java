package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes9.dex */
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream outputStream, Wire wire) {
        this.out = outputStream;
        this.wire = wire;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.wire.output(i);
        } catch (IOException e2) {
            this.wire.output("[write] I/O error: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.wire.output(bArr);
            this.out.write(bArr);
        } catch (IOException e2) {
            this.wire.output("[write] I/O error: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.wire.output(bArr, i, i2);
            this.out.write(bArr, i, i2);
        } catch (IOException e2) {
            this.wire.output("[write] I/O error: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.out.flush();
        } catch (IOException e2) {
            this.wire.output("[flush] I/O error: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } catch (IOException e2) {
            this.wire.output("[close] I/O error: " + e2.getMessage());
            throw e2;
        }
    }
}
