package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public enum SymmetricKeyAlgorithm {
    NULL(0),
    IDEA(1),
    TRIPLE_DES(2),
    CAST5(3),
    BLOWFISH(4),
    SAFER(5),
    DES(6),
    AES_128(7),
    AES_192(8),
    AES_256(9),
    TWOFISH(10),
    CAMELLIA_128(11),
    CAMELLIA_192(12),
    CAMELLIA_256(13);

    private static final Map<Integer, SymmetricKeyAlgorithm> MAP = new ConcurrentHashMap();
    private final int algorithmId;

    static {
        for (SymmetricKeyAlgorithm symmetricKeyAlgorithm : values()) {
            MAP.put(Integer.valueOf(symmetricKeyAlgorithm.algorithmId), symmetricKeyAlgorithm);
        }
    }

    public static SymmetricKeyAlgorithm fromId(int i) {
        return MAP.get(Integer.valueOf(i));
    }

    SymmetricKeyAlgorithm(int i) {
        this.algorithmId = i;
    }

    public int getAlgorithmId() {
        return this.algorithmId;
    }
}
