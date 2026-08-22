package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class VideostatsWatchtimeUrl implements Serializable {
    private String baseUrl;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public String toString() {
        return "VideostatsWatchtimeUrl{baseUrl = '" + this.baseUrl + "'}";
    }
}
