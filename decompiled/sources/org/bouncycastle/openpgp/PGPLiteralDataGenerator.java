package org.bouncycastle.openpgp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes10.dex */
public class PGPLiteralDataGenerator implements StreamGenerator {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = PGPLiteralData.NOW;
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    private boolean oldFormat;
    private BCPGOutputStream pkOut;

    public PGPLiteralDataGenerator() {
        this.oldFormat = false;
    }

    public PGPLiteralDataGenerator(boolean z) {
        this.oldFormat = z;
    }

    private void writeHeader(OutputStream outputStream, char c2, byte[] bArr, long j) throws IOException {
        outputStream.write(c2);
        outputStream.write((byte) bArr.length);
        for (int i = 0; i != bArr.length; i++) {
            outputStream.write(bArr[i]);
        }
        outputStream.write((byte) (r5 >> 24));
        outputStream.write((byte) (r5 >> 16));
        outputStream.write((byte) (r5 >> 8));
        outputStream.write((byte) (j / 1000));
    }

    @Override // org.bouncycastle.openpgp.StreamGenerator
    public void close() throws IOException {
        BCPGOutputStream bCPGOutputStream = this.pkOut;
        if (bCPGOutputStream != null) {
            bCPGOutputStream.finish();
            this.pkOut.flush();
            this.pkOut = null;
        }
    }

    public OutputStream open(OutputStream outputStream, char c2, File file) throws IOException {
        return open(outputStream, c2, file.getName(), file.length(), new Date(file.lastModified()));
    }

    public OutputStream open(OutputStream outputStream, char c2, String str, long j, Date date) throws IOException {
        if (this.pkOut != null) {
            throw new IllegalStateException("generator already in open state");
        }
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 11, j + 2 + ((long) uTF8ByteArray.length) + 4, this.oldFormat);
        this.pkOut = bCPGOutputStream;
        writeHeader(bCPGOutputStream, c2, uTF8ByteArray, date.getTime());
        return new WrappedGeneratorStream(this.pkOut, this);
    }

    public OutputStream open(OutputStream outputStream, char c2, String str, Date date, byte[] bArr) throws IOException {
        if (this.pkOut != null) {
            throw new IllegalStateException("generator already in open state");
        }
        this.pkOut = new BCPGOutputStream(outputStream, 11, bArr);
        writeHeader(this.pkOut, c2, Strings.toUTF8ByteArray(str), date.getTime());
        return new WrappedGeneratorStream(this.pkOut, this);
    }
}
