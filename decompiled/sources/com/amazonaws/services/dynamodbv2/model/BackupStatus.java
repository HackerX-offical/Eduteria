package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum BackupStatus {
    CREATING("CREATING"),
    DELETED("DELETED"),
    AVAILABLE("AVAILABLE");

    private static final Map<String, BackupStatus> enumMap;
    private String value;

    static {
        BackupStatus backupStatus = CREATING;
        BackupStatus backupStatus2 = DELETED;
        BackupStatus backupStatus3 = AVAILABLE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CREATING", backupStatus);
        map.put("DELETED", backupStatus2);
        map.put("AVAILABLE", backupStatus3);
    }

    BackupStatus(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static BackupStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, BackupStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
