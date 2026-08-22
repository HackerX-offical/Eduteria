package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Embed implements Serializable {
    private String flashSecureUrl;
    private String flashUrl;
    private int height;
    private String iframeUrl;
    private int width;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String getFlashUrl() {
        return this.flashUrl;
    }

    public void setFlashUrl(String str) {
        this.flashUrl = str;
    }

    public String getFlashSecureUrl() {
        return this.flashSecureUrl;
    }

    public void setFlashSecureUrl(String str) {
        this.flashSecureUrl = str;
    }

    public String getIframeUrl() {
        return this.iframeUrl;
    }

    public void setIframeUrl(String str) {
        this.iframeUrl = str;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String toString() {
        return "Embed{width = '" + this.width + "',flashUrl = '" + this.flashUrl + "',flashSecureUrl = '" + this.flashSecureUrl + "',iframeUrl = '" + this.iframeUrl + "',height = '" + this.height + "'}";
    }
}
