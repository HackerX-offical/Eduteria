package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.amazonaws.regions.ServiceAbbreviations;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class VideoPlayerConfig implements Serializable {

    @SerializedName("args")
    private Args args;

    @SerializedName("assets")
    private Assets assets;

    @SerializedName("attrs")
    private Attrs attrs;

    @SerializedName(ServiceAbbreviations.STS)
    private int sts;

    public Args getArgs() {
        return this.args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public int getSts() {
        return this.sts;
    }

    public void setSts(int i) {
        this.sts = i;
    }

    public Assets getAssets() {
        return this.assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Attrs getAttrs() {
        return this.attrs;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
    }

    public String toString() {
        return "VideoPlayerConfig{args = '" + this.args + "',sts = '" + this.sts + "',assets = '" + this.assets + "',attrs = '" + this.attrs + "'}";
    }
}
