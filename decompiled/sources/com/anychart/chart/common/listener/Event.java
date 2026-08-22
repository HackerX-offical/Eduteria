package com.anychart.chart.common.listener;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Event {
    private Map<String, String> data;

    Event(Map<String, String> map) {
        this.data = map;
    }

    public Map<String, String> getData() {
        return this.data;
    }
}
