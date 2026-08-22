package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum PointInTimeRecoveryStatus {
    ENABLED("ENABLED"),
    DISABLED("DISABLED");

    private static final Map<String, PointInTimeRecoveryStatus> enumMap;
    private String value;

    static {
        PointInTimeRecoveryStatus pointInTimeRecoveryStatus = ENABLED;
        PointInTimeRecoveryStatus pointInTimeRecoveryStatus2 = DISABLED;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ENABLED", pointInTimeRecoveryStatus);
        map.put("DISABLED", pointInTimeRecoveryStatus2);
    }

    PointInTimeRecoveryStatus(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static PointInTimeRecoveryStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, PointInTimeRecoveryStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
