package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Attestation implements Serializable {
    private PlayerAttestationRenderer playerAttestationRenderer;

    public PlayerAttestationRenderer getPlayerAttestationRenderer() {
        return this.playerAttestationRenderer;
    }

    public void setPlayerAttestationRenderer(PlayerAttestationRenderer playerAttestationRenderer) {
        this.playerAttestationRenderer = playerAttestationRenderer;
    }

    public String toString() {
        return "Attestation{playerAttestationRenderer = '" + this.playerAttestationRenderer + "'}";
    }
}
