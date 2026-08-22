package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ConnectionStateType {
    CONNECTED("CONNECTED"),
    CONNECTING("CONNECTING"),
    FAILED("FAILED"),
    DISCONNECTED("DISCONNECTED"),
    DISCONNECTING("DISCONNECTING");

    private static final Map<String, ConnectionStateType> enumMap;
    private String value;

    static {
        ConnectionStateType connectionStateType = CONNECTED;
        ConnectionStateType connectionStateType2 = CONNECTING;
        ConnectionStateType connectionStateType3 = FAILED;
        ConnectionStateType connectionStateType4 = DISCONNECTED;
        ConnectionStateType connectionStateType5 = DISCONNECTING;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("CONNECTED", connectionStateType);
        map.put("CONNECTING", connectionStateType2);
        map.put("FAILED", connectionStateType3);
        map.put("DISCONNECTED", connectionStateType4);
        map.put("DISCONNECTING", connectionStateType5);
    }

    ConnectionStateType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ConnectionStateType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ConnectionStateType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
