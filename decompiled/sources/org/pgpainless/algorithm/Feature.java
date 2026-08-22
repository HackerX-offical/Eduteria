package org.pgpainless.algorithm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public enum Feature {
    MODIFICATION_DETECTION((byte) 1);

    private static final Map<Byte, Feature> MAP = new ConcurrentHashMap();
    private final byte featureId;

    static {
        for (Feature feature : values()) {
            MAP.put(Byte.valueOf(feature.featureId), feature);
        }
    }

    public static Feature fromId(byte b2) {
        return MAP.get(Byte.valueOf(b2));
    }

    Feature(byte b2) {
        this.featureId = b2;
    }

    public byte getFeatureId() {
        return this.featureId;
    }
}
