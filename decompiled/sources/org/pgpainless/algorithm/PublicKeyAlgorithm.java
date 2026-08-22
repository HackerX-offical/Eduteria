package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public enum PublicKeyAlgorithm {
    RSA_GENERAL(1),
    RSA_ENCRYPT(2),
    RSA_SIGN(3),
    ELGAMAL_ENCRYPT(16),
    DSA(17),
    EC(18),
    ECDH(18),
    ECDSA(19),
    ELGAMAL_GENERAL(20),
    DIFFIE_HELLMAN(21);

    private static final Map<Integer, PublicKeyAlgorithm> MAP = new ConcurrentHashMap();
    private final int algorithmId;

    static {
        for (PublicKeyAlgorithm publicKeyAlgorithm : values()) {
            MAP.put(Integer.valueOf(publicKeyAlgorithm.algorithmId), publicKeyAlgorithm);
        }
    }

    public static PublicKeyAlgorithm fromId(int i) {
        return MAP.get(Integer.valueOf(i));
    }

    PublicKeyAlgorithm(int i) {
        this.algorithmId = i;
    }

    public int getAlgorithmId() {
        return this.algorithmId;
    }
}
