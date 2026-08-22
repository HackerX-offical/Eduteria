package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum StreamViewType {
    NEW_IMAGE("NEW_IMAGE"),
    OLD_IMAGE("OLD_IMAGE"),
    NEW_AND_OLD_IMAGES("NEW_AND_OLD_IMAGES"),
    KEYS_ONLY("KEYS_ONLY");

    private static final Map<String, StreamViewType> enumMap;
    private String value;

    static {
        StreamViewType streamViewType = NEW_IMAGE;
        StreamViewType streamViewType2 = OLD_IMAGE;
        StreamViewType streamViewType3 = NEW_AND_OLD_IMAGES;
        StreamViewType streamViewType4 = KEYS_ONLY;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("NEW_IMAGE", streamViewType);
        map.put("OLD_IMAGE", streamViewType2);
        map.put("NEW_AND_OLD_IMAGES", streamViewType3);
        map.put("KEYS_ONLY", streamViewType4);
    }

    StreamViewType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static StreamViewType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, StreamViewType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
