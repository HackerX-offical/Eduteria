package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public enum HashAlgorithm {
    MD5(1),
    SHA1(2),
    RIPEMD160(3),
    DOUBLE_SHA(4),
    MD2(5),
    TIGER_192(6),
    HAVAL_5_160(7),
    SHA256(8),
    SHA384(9),
    SHA512(10),
    SHA224(11);

    private static final Map<Integer, HashAlgorithm> MAP = new ConcurrentHashMap();
    private final int algorithmId;

    static {
        for (HashAlgorithm hashAlgorithm : values()) {
            MAP.put(Integer.valueOf(hashAlgorithm.algorithmId), hashAlgorithm);
        }
    }

    public static HashAlgorithm fromId(int i) {
        return MAP.get(Integer.valueOf(i));
    }

    HashAlgorithm(int i) {
        this.algorithmId = i;
    }

    public int getAlgorithmId() {
        return this.algorithmId;
    }
}
