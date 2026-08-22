package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class AtrUrl implements Serializable {
    private String baseUrl;
    private int elapsedMediaTimeSeconds;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public int getElapsedMediaTimeSeconds() {
        return this.elapsedMediaTimeSeconds;
    }

    public void setElapsedMediaTimeSeconds(int i) {
        this.elapsedMediaTimeSeconds = i;
    }

    public String toString() {
        return "AtrUrl{baseUrl = '" + this.baseUrl + "',elapsedMediaTimeSeconds = '" + this.elapsedMediaTimeSeconds + "'}";
    }
}
