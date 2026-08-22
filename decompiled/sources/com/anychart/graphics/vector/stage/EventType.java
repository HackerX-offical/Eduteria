package com.anychart.graphics.vector.stage;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum EventType {
    RENDER_FINISH("renderfinish"),
    RENDER_START("renderstart"),
    STAGE_RENDERED("stagerendered"),
    STAGE_RESIZE("stageresize");

    private final String value;

    EventType(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
