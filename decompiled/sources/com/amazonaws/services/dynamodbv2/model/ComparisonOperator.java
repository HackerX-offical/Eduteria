package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum ComparisonOperator {
    EQ("EQ"),
    NE("NE"),
    IN("IN"),
    LE("LE"),
    LT("LT"),
    GE("GE"),
    GT("GT"),
    BETWEEN("BETWEEN"),
    NOT_NULL("NOT_NULL"),
    NULL("NULL"),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    BEGINS_WITH("BEGINS_WITH");

    private static final Map<String, ComparisonOperator> enumMap;
    private String value;

    static {
        ComparisonOperator comparisonOperator = EQ;
        ComparisonOperator comparisonOperator2 = NE;
        ComparisonOperator comparisonOperator3 = IN;
        ComparisonOperator comparisonOperator4 = LE;
        ComparisonOperator comparisonOperator5 = LT;
        ComparisonOperator comparisonOperator6 = GE;
        ComparisonOperator comparisonOperator7 = GT;
        ComparisonOperator comparisonOperator8 = BETWEEN;
        ComparisonOperator comparisonOperator9 = NOT_NULL;
        ComparisonOperator comparisonOperator10 = NULL;
        ComparisonOperator comparisonOperator11 = CONTAINS;
        ComparisonOperator comparisonOperator12 = NOT_CONTAINS;
        ComparisonOperator comparisonOperator13 = BEGINS_WITH;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("EQ", comparisonOperator);
        map.put("NE", comparisonOperator2);
        map.put("IN", comparisonOperator3);
        map.put("LE", comparisonOperator4);
        map.put("LT", comparisonOperator5);
        map.put("GE", comparisonOperator6);
        map.put("GT", comparisonOperator7);
        map.put("BETWEEN", comparisonOperator8);
        map.put("NOT_NULL", comparisonOperator9);
        map.put("NULL", comparisonOperator10);
        map.put("CONTAINS", comparisonOperator11);
        map.put("NOT_CONTAINS", comparisonOperator12);
        map.put("BEGINS_WITH", comparisonOperator13);
    }

    ComparisonOperator(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ComparisonOperator fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ComparisonOperator> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
