package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum DataKeySpec {
    AES_256("AES_256"),
    AES_128("AES_128");

    private static final Map<String, DataKeySpec> enumMap;
    private String value;

    static {
        DataKeySpec dataKeySpec = AES_256;
        DataKeySpec dataKeySpec2 = AES_128;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("AES_256", dataKeySpec);
        map.put("AES_128", dataKeySpec2);
    }

    DataKeySpec(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static DataKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DataKeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
