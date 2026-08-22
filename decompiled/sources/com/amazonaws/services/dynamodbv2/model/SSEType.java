package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum SSEType {
    AES256("AES256"),
    KMS("KMS");

    private static final Map<String, SSEType> enumMap;
    private String value;

    static {
        SSEType sSEType = AES256;
        SSEType sSEType2 = KMS;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("AES256", sSEType);
        map.put("KMS", sSEType2);
    }

    SSEType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static SSEType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, SSEType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
