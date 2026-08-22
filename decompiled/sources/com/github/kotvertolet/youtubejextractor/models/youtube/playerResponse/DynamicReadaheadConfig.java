package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class DynamicReadaheadConfig implements Serializable {
    private int maxReadAheadMediaTimeMs;
    private int minReadAheadMediaTimeMs;
    private int readAheadGrowthRateMs;

    public int getReadAheadGrowthRateMs() {
        return this.readAheadGrowthRateMs;
    }

    public void setReadAheadGrowthRateMs(int i) {
        this.readAheadGrowthRateMs = i;
    }

    public int getMaxReadAheadMediaTimeMs() {
        return this.maxReadAheadMediaTimeMs;
    }

    public void setMaxReadAheadMediaTimeMs(int i) {
        this.maxReadAheadMediaTimeMs = i;
    }

    public int getMinReadAheadMediaTimeMs() {
        return this.minReadAheadMediaTimeMs;
    }

    public void setMinReadAheadMediaTimeMs(int i) {
        this.minReadAheadMediaTimeMs = i;
    }

    public String toString() {
        return "DynamicReadaheadConfig{readAheadGrowthRateMs = '" + this.readAheadGrowthRateMs + "',maxReadAheadMediaTimeMs = '" + this.maxReadAheadMediaTimeMs + "',minReadAheadMediaTimeMs = '" + this.minReadAheadMediaTimeMs + "'}";
    }
}
