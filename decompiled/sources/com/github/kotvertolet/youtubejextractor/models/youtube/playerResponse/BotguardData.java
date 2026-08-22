package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class BotguardData implements Serializable {
    private String interpreterUrl;
    private String program;

    public String getInterpreterUrl() {
        return this.interpreterUrl;
    }

    public void setInterpreterUrl(String str) {
        this.interpreterUrl = str;
    }

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public String toString() {
        return "BotguardData{interpreterUrl = '" + this.interpreterUrl + "',program = '" + this.program + "'}";
    }
}
