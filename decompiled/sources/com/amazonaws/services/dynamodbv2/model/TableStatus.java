package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum TableStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");

    private static final Map<String, TableStatus> enumMap;
    private String value;

    static {
        TableStatus tableStatus = CREATING;
        TableStatus tableStatus2 = UPDATING;
        TableStatus tableStatus3 = DELETING;
        TableStatus tableStatus4 = ACTIVE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CREATING", tableStatus);
        map.put("UPDATING", tableStatus2);
        map.put("DELETING", tableStatus3);
        map.put("ACTIVE", tableStatus4);
    }

    TableStatus(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static TableStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, TableStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
