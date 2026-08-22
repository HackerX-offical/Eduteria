package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class StreamSelectionConfig implements Serializable {
    private String maxBitrate;

    public String getMaxBitrate() {
        return this.maxBitrate;
    }

    public void setMaxBitrate(String str) {
        this.maxBitrate = str;
    }

    public String toString() {
        return "StreamSelectionConfig{maxBitrate = '" + this.maxBitrate + "'}";
    }
}
