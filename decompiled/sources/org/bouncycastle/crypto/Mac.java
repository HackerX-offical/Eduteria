package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes10.dex */
public interface Mac {
    int doFinal(byte[] bArr, int i) throws IllegalStateException, DataLengthException;

    String getAlgorithmName();

    int getMacSize();

    void init(CipherParameters cipherParameters) throws IllegalArgumentException;

    void reset();

    void update(byte b2) throws IllegalStateException;

    void update(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException;
}
