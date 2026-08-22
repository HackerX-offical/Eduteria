package com.anychart.enums;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum VAlign {
    BOTTOM("bottom"),
    MIDDLE("middle"),
    TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY);

    private final String value;

    VAlign(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
