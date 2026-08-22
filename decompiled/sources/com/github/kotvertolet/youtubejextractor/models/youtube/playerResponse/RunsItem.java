package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class RunsItem implements Serializable {
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "RunsItem{text = '" + this.text + "'}";
    }
}
