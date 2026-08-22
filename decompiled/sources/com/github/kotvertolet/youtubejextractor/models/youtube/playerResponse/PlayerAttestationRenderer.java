package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class PlayerAttestationRenderer implements Serializable {
    private BotguardData botguardData;
    private String challenge;

    public BotguardData getBotguardData() {
        return this.botguardData;
    }

    public void setBotguardData(BotguardData botguardData) {
        this.botguardData = botguardData;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public void setChallenge(String str) {
        this.challenge = str;
    }

    public String toString() {
        return "PlayerAttestationRenderer{botguardData = '" + this.botguardData + "',challenge = '" + this.challenge + "'}";
    }
}
