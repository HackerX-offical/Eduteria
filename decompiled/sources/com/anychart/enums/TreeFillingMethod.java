package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum TreeFillingMethod {
    AS_TABLE("as-table"),
    AS_TREE("as-tree");

    private final String value;

    TreeFillingMethod(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
