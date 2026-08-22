package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Title implements Serializable {
    private String simpleText;

    public String getSimpleText() {
        return this.simpleText;
    }

    public void setSimpleText(String str) {
        this.simpleText = str;
    }

    public String toString() {
        return "Title{simpleText = '" + this.simpleText + "'}";
    }
}
