package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum EventMarkerDirection {
    AUTO("auto"),
    DOWN("down"),
    UP("up");

    private final String value;

    EventMarkerDirection(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
