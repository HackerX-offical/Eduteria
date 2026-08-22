package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum AttributeAction {
    ADD("ADD"),
    PUT("PUT"),
    DELETE("DELETE");

    private static final Map<String, AttributeAction> enumMap;
    private String value;

    static {
        AttributeAction attributeAction = ADD;
        AttributeAction attributeAction2 = PUT;
        AttributeAction attributeAction3 = DELETE;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ADD", attributeAction);
        map.put("PUT", attributeAction2);
        map.put("DELETE", attributeAction3);
    }

    AttributeAction(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AttributeAction fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AttributeAction> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
