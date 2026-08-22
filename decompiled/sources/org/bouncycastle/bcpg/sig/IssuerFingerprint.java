package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class IssuerFingerprint extends SignatureSubpacket {
    public IssuerFingerprint(boolean z, int i, byte[] bArr) {
        super(33, z, false, Arrays.concatenate(new byte[]{(byte) i}, bArr));
    }

    public IssuerFingerprint(boolean z, boolean z2, byte[] bArr) {
        super(33, z, z2, bArr);
    }

    public byte[] getFingerprint() {
        return Arrays.copyOfRange(this.data, 1, this.data.length);
    }

    public int getKeyVersion() {
        return this.data[0] & 255;
    }
}
