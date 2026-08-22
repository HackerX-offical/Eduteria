package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
abstract class ContentCryptoScheme {
    private static final int BYTE_SIZE = 4;
    private static final int CBC_SHIFT_VALUE = 48;
    private static final int DEFAULT_BIT_COUNTER = 16;
    private static final int DEFAULT_RIGHTMOST_BIT_START = 12;
    private static final int GCM_SHIFT_VALUE = 32;
    private static final int LONG_BYTE_SIZE = 8;
    private static final long LONG_VALUE = 1;
    static final long MAX_CBC_BYTES = 4503599627370496L;
    static final long MAX_CTR_BYTES = -1;
    static final long MAX_GCM_BLOCKS = 4294967294L;
    static final long MAX_GCM_BYTES = 68719476704L;
    static final ContentCryptoScheme AES_CBC = new AesCbc();
    static final ContentCryptoScheme AES_GCM = new AesGcm();
    static final ContentCryptoScheme AES_CTR = new AesCtr();

    byte[] adjustIV(byte[] bArr, long j) {
        return bArr;
    }

    CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int i, Provider provider, long j) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return null;
    }

    abstract int getBlockSizeInBytes();

    abstract String getCipherAlgorithm();

    abstract int getIVLengthInBytes();

    abstract String getKeyGeneratorAlgorithm();

    abstract int getKeyLengthInBits();

    abstract long getMaxPlaintextSize();

    String getSpecificCipherProvider() {
        return null;
    }

    int getTagLengthInBits() {
        return 0;
    }

    ContentCryptoScheme() {
    }

    public String toString() {
        return "cipherAlgo=" + getCipherAlgorithm() + ", blockSizeInBytes=" + getBlockSizeInBytes() + ", ivLengthInBytes=" + getIVLengthInBytes() + ", keyGenAlgo=" + getKeyGeneratorAlgorithm() + ", keyLengthInBits=" + getKeyLengthInBits() + ", specificProvider=" + getSpecificCipherProvider() + ", tagLengthInBits=" + getTagLengthInBits();
    }

    static byte[] incrementBlocks(byte[] bArr, long j) {
        if (j != 0) {
            if (bArr == null || bArr.length != 16) {
                throw new IllegalArgumentException();
            }
            if (j > MAX_GCM_BLOCKS) {
                throw new IllegalStateException();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            for (int i = 12; i <= 15; i++) {
                byteBufferAllocate.put(i - 8, bArr[i]);
            }
            long j2 = byteBufferAllocate.getLong() + j;
            if (j2 > MAX_GCM_BLOCKS) {
                throw new IllegalStateException();
            }
            byteBufferAllocate.rewind();
            byte[] bArrArray = byteBufferAllocate.putLong(j2).array();
            for (int i2 = 12; i2 <= 15; i2++) {
                bArr[i2] = bArrArray[i2 - 8];
            }
        }
        return bArr;
    }

    static ContentCryptoScheme fromCEKAlgo(String str) {
        return fromCEKAlgo(str, false);
    }

    static ContentCryptoScheme fromCEKAlgo(String str, boolean z) {
        ContentCryptoScheme contentCryptoScheme = AES_GCM;
        if (contentCryptoScheme.getCipherAlgorithm().equals(str)) {
            return z ? AES_CTR : contentCryptoScheme;
        }
        if (str == null || AES_CBC.getCipherAlgorithm().equals(str)) {
            return AES_CBC;
        }
        throw new UnsupportedOperationException("Unsupported content encryption scheme: " + str);
    }

    CipherLite createCipherLite(SecretKey secretKey, byte[] bArr, int i, Provider provider) {
        Cipher cipher;
        String specificCipherProvider = getSpecificCipherProvider();
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(getCipherAlgorithm(), provider);
            } else if (specificCipherProvider != null) {
                cipher = Cipher.getInstance(getCipherAlgorithm(), specificCipherProvider);
            } else {
                cipher = Cipher.getInstance(getCipherAlgorithm());
            }
            cipher.init(i, secretKey, new IvParameterSpec(bArr));
            return newCipherLite(cipher, secretKey, i);
        } catch (Exception e2) {
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            }
            throw new AmazonClientException("Unable to build cipher: " + e2.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM", e2);
        }
    }

    protected CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        return new CipherLite(cipher, this, secretKey, i);
    }

    CipherLite createCipherLite(SecretKey secretKey, byte[] bArr, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return createCipherLite(secretKey, bArr, i, null);
    }

    final String getKeySpec() {
        return getKeyGeneratorAlgorithm() + "_" + getKeyLengthInBits();
    }
}
