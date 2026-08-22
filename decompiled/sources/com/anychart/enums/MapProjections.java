package com.anychart.enums;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum MapProjections {
    AITOFF("aitoff"),
    AUGUST("august"),
    BONNE("bonne"),
    ECKERT1("eckert1"),
    ECKERT3("eckert3"),
    EQUIRECTANGULAR("equirectangular"),
    FAHEY("fahey"),
    HAMMER("hammer"),
    MERCATOR("mercator"),
    ORTHOGRAPHIC("orthographic"),
    ROBINSON("robinson"),
    WAGNER6("wagner6"),
    WSG84("wsg84");

    private final String value;

    MapProjections(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
