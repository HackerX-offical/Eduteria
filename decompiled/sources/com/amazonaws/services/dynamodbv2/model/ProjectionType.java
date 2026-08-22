package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ProjectionType {
    ALL("ALL"),
    KEYS_ONLY("KEYS_ONLY"),
    INCLUDE("INCLUDE");

    private static final Map<String, ProjectionType> enumMap;
    private String value;

    static {
        ProjectionType projectionType = ALL;
        ProjectionType projectionType2 = KEYS_ONLY;
        ProjectionType projectionType3 = INCLUDE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ALL", projectionType);
        map.put("KEYS_ONLY", projectionType2);
        map.put("INCLUDE", projectionType3);
    }

    ProjectionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ProjectionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ProjectionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
