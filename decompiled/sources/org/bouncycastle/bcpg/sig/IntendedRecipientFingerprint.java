package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class IntendedRecipientFingerprint extends SignatureSubpacket {
    public IntendedRecipientFingerprint(boolean z, int i, byte[] bArr) {
        super(35, z, false, Arrays.concatenate(new byte[]{(byte) i}, bArr));
    }

    public IntendedRecipientFingerprint(boolean z, boolean z2, byte[] bArr) {
        super(35, z, z2, bArr);
    }

    public byte[] getFingerprint() {
        return Arrays.copyOfRange(this.data, 1, this.data.length);
    }

    public int getKeyVersion() {
        return this.data[0] & 255;
    }
}
