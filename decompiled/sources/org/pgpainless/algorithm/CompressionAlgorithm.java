package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public enum CompressionAlgorithm {
    UNCOMPRESSED(0),
    ZIP(1),
    ZLIB(2),
    BZIP2(3);

    private static final Map<Integer, CompressionAlgorithm> MAP = new ConcurrentHashMap();
    private final int algorithmId;

    static {
        for (CompressionAlgorithm compressionAlgorithm : values()) {
            MAP.put(Integer.valueOf(compressionAlgorithm.algorithmId), compressionAlgorithm);
        }
    }

    public static CompressionAlgorithm fromId(int i) {
        return MAP.get(Integer.valueOf(i));
    }

    CompressionAlgorithm(int i) {
        this.algorithmId = i;
    }

    public int getAlgorithmId() {
        return this.algorithmId;
    }
}
