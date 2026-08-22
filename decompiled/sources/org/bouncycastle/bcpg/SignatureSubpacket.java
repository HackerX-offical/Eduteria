package org.bouncycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class SignatureSubpacket {
    boolean critical;
    protected byte[] data;
    boolean isLongLength;
    int type;

    protected SignatureSubpacket(int i, boolean z, boolean z2, byte[] bArr) {
        this.type = i;
        this.critical = z;
        this.isLongLength = z2;
        this.data = bArr;
    }

    public void encode(OutputStream outputStream) throws IOException {
        byte b2;
        int length = this.data.length;
        int i = length + 1;
        if (this.isLongLength) {
            outputStream.write(255);
            outputStream.write((byte) (i >> 24));
            outputStream.write((byte) (i >> 16));
            outputStream.write((byte) (i >> 8));
            b2 = (byte) i;
        } else if (i >= 192) {
            if (i <= 8383) {
                int i2 = length - 191;
                outputStream.write((byte) (((i2 >> 8) & 255) + 192));
                b2 = (byte) i2;
            }
            outputStream.write(255);
            outputStream.write((byte) (i >> 24));
            outputStream.write((byte) (i >> 16));
            outputStream.write((byte) (i >> 8));
            b2 = (byte) i;
        } else {
            b2 = (byte) i;
        }
        outputStream.write(b2);
        outputStream.write(this.critical ? this.type | 128 : this.type);
        outputStream.write(this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCritical() {
        return this.critical;
    }

    public boolean isLongLength() {
        return this.isLongLength;
    }
}
