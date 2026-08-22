package com.anychart.enums;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum DataField {
    DEPENDS_ON("dependsOn"),
    DURATION(TypedValues.TransitionType.S_DURATION),
    EXPECTED("expected"),
    FROM("from"),
    ID("id"),
    MOST_LIKELY("mostLikely"),
    NAME("name"),
    OPTIMISTIC("optimistic"),
    PESSIMISTIC("pessimistic"),
    TO("to");

    private final String value;

    DataField(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
