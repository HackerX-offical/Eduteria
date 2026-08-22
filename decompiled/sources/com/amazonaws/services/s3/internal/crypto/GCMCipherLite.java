package com.amazonaws.services.s3.internal.crypto;

import com.clevertap.android.sdk.Constants;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class GCMCipherLite extends CipherLite {
    private static final int BITS = 8;
    private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8;
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    boolean markSupported() {
        return true;
    }

    GCMCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i);
        this.tagLen = i == 1 ? TAG_LENGTH : 0;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    byte[] doFinal() throws BadPaddingException, IllegalBlockSizeException {
        if (this.doneFinal) {
            if (this.securityViolated) {
                throw new SecurityException();
            }
            byte[] bArr = this.finalBytes;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }
        this.doneFinal = true;
        byte[] bArrDoFinal = super.doFinal();
        this.finalBytes = bArrDoFinal;
        if (bArrDoFinal == null) {
            return null;
        }
        this.outputByteCount += (long) checkMax(bArrDoFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    final byte[] doFinal(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        return doFinal0(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    final byte[] doFinal(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        return doFinal0(bArr, i, i2);
    }

    private final byte[] doFinal0(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        if (this.doneFinal) {
            if (this.securityViolated) {
                throw new SecurityException();
            }
            if (2 == getCipherMode()) {
                byte[] bArr2 = this.finalBytes;
                if (bArr2 == null) {
                    return null;
                }
                return (byte[]) bArr2.clone();
            }
            byte[] bArr3 = this.finalBytes;
            int length = bArr3.length;
            int i3 = this.tagLen;
            int i4 = length - i3;
            if (i2 == i4) {
                return (byte[]) bArr3.clone();
            }
            if (i2 < i4 && ((long) i2) + this.currentCount == this.outputByteCount) {
                return Arrays.copyOfRange(bArr3, (bArr3.length - i3) - i2, bArr3.length);
            }
            throw new IllegalStateException("Inconsistent re-rencryption");
        }
        this.doneFinal = true;
        byte[] bArrDoFinal = super.doFinal(bArr, i, i2);
        this.finalBytes = bArrDoFinal;
        if (bArrDoFinal == null) {
            return null;
        }
        this.outputByteCount += (long) checkMax(bArrDoFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    byte[] update(byte[] bArr, int i, int i2) {
        CipherLite cipherLite = this.aux;
        if (cipherLite == null) {
            byte[] bArrUpdate = super.update(bArr, i, i2);
            if (bArrUpdate == null) {
                this.invisiblyProcessed = bArr.length > 0;
                return null;
            }
            this.outputByteCount += (long) checkMax(bArrUpdate.length);
            this.invisiblyProcessed = bArrUpdate.length == 0 && i2 > 0;
            return bArrUpdate;
        }
        byte[] bArrUpdate2 = cipherLite.update(bArr, i, i2);
        if (bArrUpdate2 == null) {
            return null;
        }
        long length = this.currentCount + ((long) bArrUpdate2.length);
        this.currentCount = length;
        long j = this.outputByteCount;
        if (length == j) {
            this.aux = null;
            return bArrUpdate2;
        }
        if (length <= j) {
            return bArrUpdate2;
        }
        if (1 == getCipherMode()) {
            throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
        }
        byte[] bArr2 = this.finalBytes;
        int length2 = bArr2 != null ? bArr2.length : 0;
        long j2 = this.outputByteCount;
        long length3 = j2 - (this.currentCount - ((long) bArrUpdate2.length));
        long j3 = length2;
        this.currentCount = j2 - j3;
        this.aux = null;
        return Arrays.copyOf(bArrUpdate2, (int) (length3 - j3));
    }

    private int checkMax(int i) {
        if (this.outputByteCount + ((long) i) <= 68719476704L) {
            return i;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i + Constants.AES_SUFFIX);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    long mark() {
        long j = this.aux == null ? this.outputByteCount : this.currentCount;
        this.markedCount = j;
        return j;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    void reset() {
        long j = this.markedCount;
        if (j < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(j);
                this.currentCount = this.markedCount;
            } catch (Exception e2) {
                if (!(e2 instanceof RuntimeException)) {
                    throw new IllegalStateException(e2);
                }
            }
        }
    }

    byte[] getFinalBytes() {
        byte[] bArr = this.finalBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    byte[] getTag() {
        byte[] bArr;
        if (getCipherMode() != 1 || (bArr = this.finalBytes) == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, bArr.length - this.tagLen, bArr.length);
    }

    long getOutputByteCount() {
        return this.outputByteCount;
    }

    long getCurrentCount() {
        return this.currentCount;
    }

    long getMarkedCount() {
        return this.markedCount;
    }
}
