package com.anychart.enums;

import java.util.Locale;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: loaded from: classes5.dex */
public enum GanttDataFields {
    ACTUAL("actual"),
    ACTUAL_END("actualEnd"),
    ACTUAL_START("actualStart"),
    BASELINE("baseLine"),
    BASELINE_END("baseLineEnd"),
    BASELINE_START("baseLineStart"),
    CHILDREN("children"),
    COLLAPSED("collapsed"),
    CONNECTOR("connector"),
    CONNECTOR_TYPE("connectorType"),
    CONNECT_TO("connectTo"),
    END("end"),
    END_MARKER("endMarker"),
    FILL("fill"),
    HOVER_FILL("hoverFill"),
    HOVER_STROKE("hoverStroke"),
    ID("id"),
    LABEL("label"),
    MARKERS("markers"),
    MILESTONE("milestone"),
    NAME("name"),
    PARENT(Message.Thread.PARENT_ATTRIBUTE_NAME),
    PERIODS("periods"),
    PROGRESS("progress"),
    PROGRESS_VALUE("progressValue"),
    ROW_HEIGHT("rowHeight"),
    START("start"),
    START_MARKER("startMarker"),
    STROKE("stroke");

    private final String value;

    GanttDataFields(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
