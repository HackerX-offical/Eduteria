package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Assets implements Serializable {

    @SerializedName("css")
    private String css;

    @SerializedName("js")
    private String js;

    public String getCss() {
        return this.css;
    }

    public void setCss(String str) {
        this.css = str;
    }

    public String getJs() {
        return this.js;
    }

    public void setJs(String str) {
        this.js = str;
    }

    public String toString() {
        return "Assets{css = '" + this.css + "',js = '" + this.js + "'}";
    }
}
