package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes10.dex */
public interface AsymmetricCipherKeyPairGenerator {
    AsymmetricCipherKeyPair generateKeyPair();

    void init(KeyGenerationParameters keyGenerationParameters);
}
