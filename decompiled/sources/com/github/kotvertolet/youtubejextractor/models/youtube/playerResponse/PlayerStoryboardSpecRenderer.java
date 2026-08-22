package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class PlayerStoryboardSpecRenderer implements Serializable {
    private String spec;

    public String getSpec() {
        return this.spec;
    }

    public void setSpec(String str) {
        this.spec = str;
    }

    public String toString() {
        return "PlayerStoryboardSpecRenderer{spec = '" + this.spec + "'}";
    }
}
