package com.x5.util;

import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface TableData {
    String[] getColumnLabels();

    String[] getRow();

    boolean hasNext();

    Map<String, Object> nextRecord();

    void reset();

    void setColumnLabels(String[] strArr);
}
