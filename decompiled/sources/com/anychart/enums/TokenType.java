package com.anychart.enums;

import com.clevertap.android.sdk.variables.CTVariableUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TokenType {
    DATE_TIME("date-time"),
    NUMBER(CTVariableUtils.NUMBER),
    PERCENT("percent"),
    STRING("string"),
    UNKNOWN("");

    private final String value;

    TokenType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
