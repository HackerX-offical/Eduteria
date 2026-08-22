package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class PlayabilityStatus implements Serializable {
    private String contextParams;
    private boolean playableInEmbed;
    private String status;

    public boolean isPlayableInEmbed() {
        return this.playableInEmbed;
    }

    public void setPlayableInEmbed(boolean z) {
        this.playableInEmbed = z;
    }

    public String getContextParams() {
        return this.contextParams;
    }

    public void setContextParams(String str) {
        this.contextParams = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "PlayabilityStatus{playableInEmbed = '" + this.playableInEmbed + "',contextParams = '" + this.contextParams + "',status = '" + this.status + "'}";
    }
}
