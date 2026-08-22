package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public class PGPPad {
    private PGPPad() {
    }

    public static byte[] padSessionData(byte[] bArr) {
        byte[] bArr2 = new byte[40];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte length = (byte) (40 - bArr.length);
        for (int length2 = bArr.length; length2 != 40; length2++) {
            bArr2[length2] = length;
        }
        return bArr2;
    }

    public static byte[] unpadSessionData(byte[] bArr) throws PGPException {
        int i = bArr[bArr.length - 1];
        for (int length = bArr.length - i; length != bArr.length; length++) {
            if (bArr[length] != i) {
                throw new PGPException("bad padding found in session data");
            }
        }
        int length2 = bArr.length - i;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, length2);
        return bArr2;
    }
}
