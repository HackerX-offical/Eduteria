package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class SignatureTarget extends SignatureSubpacket {
    public SignatureTarget(boolean z, int i, int i2, byte[] bArr) {
        super(31, z, false, Arrays.concatenate(new byte[]{(byte) i, (byte) i2}, bArr));
    }

    public SignatureTarget(boolean z, boolean z2, byte[] bArr) {
        super(31, z, z2, bArr);
    }

    public int getHashAlgorithm() {
        return this.data[1] & 255;
    }

    public byte[] getHashData() {
        return Arrays.copyOfRange(this.data, 2, this.data.length);
    }

    public int getPublicKeyAlgorithm() {
        return this.data[0] & 255;
    }
}
