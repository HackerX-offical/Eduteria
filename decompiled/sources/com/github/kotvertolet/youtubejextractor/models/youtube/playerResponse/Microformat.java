package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Microformat implements Serializable {
    private PlayerMicroformatRenderer playerMicroformatRenderer;

    public PlayerMicroformatRenderer getPlayerMicroformatRenderer() {
        return this.playerMicroformatRenderer;
    }

    public void setPlayerMicroformatRenderer(PlayerMicroformatRenderer playerMicroformatRenderer) {
        this.playerMicroformatRenderer = playerMicroformatRenderer;
    }

    public String toString() {
        return "Microformat{playerMicroformatRenderer = '" + this.playerMicroformatRenderer + "'}";
    }
}
