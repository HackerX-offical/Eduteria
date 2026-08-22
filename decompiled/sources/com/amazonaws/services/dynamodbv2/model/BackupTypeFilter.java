package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.DocumentType;

/* JADX INFO: loaded from: classes4.dex */
public enum BackupTypeFilter {
    USER("USER"),
    SYSTEM(DocumentType.SYSTEM_KEY),
    ALL("ALL");

    private static final Map<String, BackupTypeFilter> enumMap;
    private String value;

    static {
        BackupTypeFilter backupTypeFilter = USER;
        BackupTypeFilter backupTypeFilter2 = SYSTEM;
        BackupTypeFilter backupTypeFilter3 = ALL;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("USER", backupTypeFilter);
        map.put(DocumentType.SYSTEM_KEY, backupTypeFilter2);
        map.put("ALL", backupTypeFilter3);
    }

    BackupTypeFilter(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static BackupTypeFilter fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, BackupTypeFilter> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
