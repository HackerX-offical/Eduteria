package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ReturnConsumedCapacity {
    INDEXES("INDEXES"),
    TOTAL("TOTAL"),
    NONE("NONE");

    private static final Map<String, ReturnConsumedCapacity> enumMap;
    private String value;

    static {
        ReturnConsumedCapacity returnConsumedCapacity = INDEXES;
        ReturnConsumedCapacity returnConsumedCapacity2 = TOTAL;
        ReturnConsumedCapacity returnConsumedCapacity3 = NONE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("INDEXES", returnConsumedCapacity);
        map.put("TOTAL", returnConsumedCapacity2);
        map.put("NONE", returnConsumedCapacity3);
    }

    ReturnConsumedCapacity(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ReturnConsumedCapacity fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReturnConsumedCapacity> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
