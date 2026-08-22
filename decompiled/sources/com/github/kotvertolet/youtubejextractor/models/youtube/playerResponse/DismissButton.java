package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class DismissButton implements Serializable {
    private ButtonRenderer buttonRenderer;

    public ButtonRenderer getButtonRenderer() {
        return this.buttonRenderer;
    }

    public void setButtonRenderer(ButtonRenderer buttonRenderer) {
        this.buttonRenderer = buttonRenderer;
    }

    public String toString() {
        return "DismissButton{buttonRenderer = '" + this.buttonRenderer + "'}";
    }
}
