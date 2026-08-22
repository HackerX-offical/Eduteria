package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
class AesCbc extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 16;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int getBlockSizeInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int getIVLengthInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int getKeyLengthInBits() {
        return 256;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    long getMaxPlaintextSize() {
        return 4503599627370496L;
    }

    AesCbc() {
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String getKeyGeneratorAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String getCipherAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD;
    }
}
