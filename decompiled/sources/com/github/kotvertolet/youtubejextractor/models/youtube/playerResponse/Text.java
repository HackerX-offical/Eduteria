package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class Text implements Serializable {
    private List<RunsItem> runs;

    public List<RunsItem> getRuns() {
        return this.runs;
    }

    public void setRuns(List<RunsItem> list) {
        this.runs = list;
    }

    public String toString() {
        return "Text{runs = '" + this.runs + "'}";
    }
}
