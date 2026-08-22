package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class UiActions implements Serializable {
    private boolean hideEnclosingContainer;

    public boolean isHideEnclosingContainer() {
        return this.hideEnclosingContainer;
    }

    public void setHideEnclosingContainer(boolean z) {
        this.hideEnclosingContainer = z;
    }

    public String toString() {
        return "UiActions{hideEnclosingContainer = '" + this.hideEnclosingContainer + "'}";
    }
}
