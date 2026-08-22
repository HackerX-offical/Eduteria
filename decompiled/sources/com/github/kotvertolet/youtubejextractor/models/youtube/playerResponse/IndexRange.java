package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class IndexRange implements Serializable {
    private String end;
    private String start;

    public String getStart() {
        return this.start;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public String toString() {
        return "IndexRange{start = '" + this.start + "',end = '" + this.end + "'}";
    }
}
