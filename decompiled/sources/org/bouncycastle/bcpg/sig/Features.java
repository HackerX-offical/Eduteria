package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* JADX INFO: loaded from: classes10.dex */
public class Features extends SignatureSubpacket {
    public static final byte FEATURE_MODIFICATION_DETECTION = 1;

    public Features(boolean z, byte b2) {
        super(30, z, false, featureToByteArray(b2));
    }

    public Features(boolean z, boolean z2, byte[] bArr) {
        super(30, z, z2, bArr);
    }

    private static final byte[] featureToByteArray(byte b2) {
        return new byte[]{b2};
    }

    private void setSupportsFeature(byte b2, boolean z) {
        if (b2 == 0) {
            throw new IllegalArgumentException("feature == 0");
        }
        if (supportsFeature(b2) != z) {
            if (z) {
                byte[] bArr = new byte[this.data.length + 1];
                System.arraycopy(this.data, 0, bArr, 0, this.data.length);
                bArr[this.data.length] = b2;
                this.data = bArr;
                return;
            }
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i] == b2) {
                    int length = this.data.length - 1;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(this.data, 0, bArr2, 0, i);
                    System.arraycopy(this.data, i + 1, bArr2, i, length - i);
                    this.data = bArr2;
                    return;
                }
            }
        }
    }

    public boolean supportsFeature(byte b2) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == b2) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsModificationDetection() {
        return supportsFeature((byte) 1);
    }
}
