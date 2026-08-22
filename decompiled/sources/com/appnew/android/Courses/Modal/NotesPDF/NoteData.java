package com.appnew.android.Courses.Modal.NotesPDF;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class NoteData implements Serializable {
    String conceptId;
    int end;
    private boolean isSelect = false;
    String queryData;
    int start;
    String title;
    String type;
    String userId;

    public NoteData() {
    }

    public NoteData(String userId, String conceptId, String queryData, String title, String type, int start, int end) {
        this.userId = userId;
        this.conceptId = conceptId;
        this.queryData = queryData;
        this.title = title;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConceptId() {
        return this.conceptId;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    public String getQueryData() {
        return this.queryData;
    }

    public void setQueryData(String queryData) {
        this.queryData = queryData;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
