package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum KeyUsageType {
    ENCRYPT_DECRYPT("ENCRYPT_DECRYPT");

    private static final Map<String, KeyUsageType> enumMap;
    private String value;

    static {
        KeyUsageType keyUsageType = ENCRYPT_DECRYPT;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ENCRYPT_DECRYPT", keyUsageType);
    }

    KeyUsageType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static KeyUsageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyUsageType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
