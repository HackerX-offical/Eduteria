package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ReplicaStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");

    private static final Map<String, ReplicaStatus> enumMap;
    private String value;

    static {
        ReplicaStatus replicaStatus = CREATING;
        ReplicaStatus replicaStatus2 = UPDATING;
        ReplicaStatus replicaStatus3 = DELETING;
        ReplicaStatus replicaStatus4 = ACTIVE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CREATING", replicaStatus);
        map.put("UPDATING", replicaStatus2);
        map.put("DELETING", replicaStatus3);
        map.put("ACTIVE", replicaStatus4);
    }

    ReplicaStatus(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ReplicaStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReplicaStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
