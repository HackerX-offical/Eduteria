package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum KeyType {
    HASH("HASH"),
    RANGE("RANGE");

    private static final Map<String, KeyType> enumMap;
    private String value;

    static {
        KeyType keyType = HASH;
        KeyType keyType2 = RANGE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("HASH", keyType);
        map.put("RANGE", keyType2);
    }

    KeyType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static KeyType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
