package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Storyboards implements Serializable {
    private PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer;

    public PlayerStoryboardSpecRenderer getPlayerStoryboardSpecRenderer() {
        return this.playerStoryboardSpecRenderer;
    }

    public void setPlayerStoryboardSpecRenderer(PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer) {
        this.playerStoryboardSpecRenderer = playerStoryboardSpecRenderer;
    }

    public String toString() {
        return "Storyboards{playerStoryboardSpecRenderer = '" + this.playerStoryboardSpecRenderer + "'}";
    }
}
