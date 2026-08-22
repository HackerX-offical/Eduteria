package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* JADX INFO: loaded from: classes10.dex */
public class KeyExpirationTime extends SignatureSubpacket {
    public KeyExpirationTime(boolean z, long j) {
        super(9, z, false, timeToBytes(j));
    }

    public KeyExpirationTime(boolean z, boolean z2, byte[] bArr) {
        super(9, z, z2, bArr);
    }

    protected static byte[] timeToBytes(long j) {
        return new byte[]{(byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j};
    }

    public long getTime() {
        return (((long) (this.data[0] & 255)) << 24) | ((long) ((this.data[1] & 255) << 16)) | ((long) ((this.data[2] & 255) << 8)) | ((long) (this.data[3] & 255));
    }
}
