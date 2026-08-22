package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class AudioConfig implements Serializable {
    private boolean enablePerFormatLoudness;
    private double loudnessDb;
    private double perceptualLoudnessDb;

    public double getPerceptualLoudnessDb() {
        return this.perceptualLoudnessDb;
    }

    public void setPerceptualLoudnessDb(double d2) {
        this.perceptualLoudnessDb = d2;
    }

    public double getLoudnessDb() {
        return this.loudnessDb;
    }

    public void setLoudnessDb(double d2) {
        this.loudnessDb = d2;
    }

    public boolean isEnablePerFormatLoudness() {
        return this.enablePerFormatLoudness;
    }

    public void setEnablePerFormatLoudness(boolean z) {
        this.enablePerFormatLoudness = z;
    }

    public String toString() {
        return "AudioConfig{perceptualLoudnessDb = '" + this.perceptualLoudnessDb + "',loudnessDb = '" + this.loudnessDb + "',enablePerFormatLoudness = '" + this.enablePerFormatLoudness + "'}";
    }
}
