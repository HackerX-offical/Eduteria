package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public enum GrantOperation {
    Decrypt("Decrypt"),
    Encrypt("Encrypt"),
    GenerateDataKey("GenerateDataKey"),
    GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),
    ReEncryptFrom("ReEncryptFrom"),
    ReEncryptTo("ReEncryptTo"),
    CreateGrant("CreateGrant"),
    RetireGrant("RetireGrant"),
    DescribeKey("DescribeKey");

    private static final Map<String, GrantOperation> enumMap;
    private String value;

    static {
        GrantOperation grantOperation = Decrypt;
        GrantOperation grantOperation2 = Encrypt;
        GrantOperation grantOperation3 = GenerateDataKey;
        GrantOperation grantOperation4 = GenerateDataKeyWithoutPlaintext;
        GrantOperation grantOperation5 = ReEncryptFrom;
        GrantOperation grantOperation6 = ReEncryptTo;
        GrantOperation grantOperation7 = CreateGrant;
        GrantOperation grantOperation8 = RetireGrant;
        GrantOperation grantOperation9 = DescribeKey;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("Decrypt", grantOperation);
        map.put("Encrypt", grantOperation2);
        map.put("GenerateDataKey", grantOperation3);
        map.put("GenerateDataKeyWithoutPlaintext", grantOperation4);
        map.put("ReEncryptFrom", grantOperation5);
        map.put("ReEncryptTo", grantOperation6);
        map.put("CreateGrant", grantOperation7);
        map.put("RetireGrant", grantOperation8);
        map.put("DescribeKey", grantOperation9);
    }

    GrantOperation(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static GrantOperation fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, GrantOperation> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
