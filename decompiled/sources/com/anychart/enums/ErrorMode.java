package com.anychart.enums;

import java.util.Locale;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

/* JADX INFO: loaded from: classes5.dex */
public enum ErrorMode {
    BOTH(PrivacyItem.SUBSCRIPTION_BOTH),
    NONE("none"),
    VALUE("value"),
    X("x");

    private final String value;

    ErrorMode(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
