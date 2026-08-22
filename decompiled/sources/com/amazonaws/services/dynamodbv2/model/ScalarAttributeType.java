package com.amazonaws.services.dynamodbv2.model;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ScalarAttributeType {
    S(ExifInterface.LATITUDE_SOUTH),
    N("N"),
    B("B");

    private static final Map<String, ScalarAttributeType> enumMap;
    private String value;

    static {
        ScalarAttributeType scalarAttributeType = S;
        ScalarAttributeType scalarAttributeType2 = N;
        ScalarAttributeType scalarAttributeType3 = B;
        HashMap map = new HashMap();
        enumMap = map;
        map.put(ExifInterface.LATITUDE_SOUTH, scalarAttributeType);
        map.put("N", scalarAttributeType2);
        map.put("B", scalarAttributeType3);
    }

    ScalarAttributeType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ScalarAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ScalarAttributeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
