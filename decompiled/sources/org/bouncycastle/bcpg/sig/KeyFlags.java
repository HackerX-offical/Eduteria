package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* JADX INFO: loaded from: classes10.dex */
public class KeyFlags extends SignatureSubpacket {
    public static final int AUTHENTICATION = 32;
    public static final int CERTIFY_OTHER = 1;
    public static final int ENCRYPT_COMMS = 4;
    public static final int ENCRYPT_STORAGE = 8;
    public static final int SHARED = 128;
    public static final int SIGN_DATA = 2;
    public static final int SPLIT = 16;

    public KeyFlags(boolean z, int i) {
        super(27, z, false, intToByteArray(i));
    }

    public KeyFlags(boolean z, boolean z2, byte[] bArr) {
        super(27, z, z2, bArr);
    }

    private static byte[] intToByteArray(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        for (int i3 = 0; i3 != 4; i3++) {
            byte b2 = (byte) (i >> (i3 * 8));
            bArr[i3] = b2;
            if (b2 != 0) {
                i2 = i3;
            }
        }
        int i4 = i2 + 1;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }

    public int getFlags() {
        int i = 0;
        for (int i2 = 0; i2 != this.data.length; i2++) {
            i |= (this.data[i2] & 255) << (i2 * 8);
        }
        return i;
    }
}
