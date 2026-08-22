package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class MetaVideo {

    @SerializedName("extra_params")
    @Expose
    private Extra_params extra_params;

    @SerializedName("multiplayer")
    @Expose
    private String multiplayer;

    @SerializedName(Const.remaining_time)
    @Expose
    private String remaining_time;

    @SerializedName("video_length")
    @Expose
    private String video_length;

    public String getVideo_length() {
        return this.video_length;
    }

    public void setVideo_length(String video_length) {
        this.video_length = video_length;
    }

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public void setRemaining_time(String remaining_time) {
        this.remaining_time = remaining_time;
    }

    public String getMultiplayer() {
        return this.multiplayer;
    }

    public void setMultiplayer(String multiplayer) {
        this.multiplayer = multiplayer;
    }

    public Extra_params getExtra_params() {
        return this.extra_params;
    }

    public void setExtra_params(Extra_params extra_params) {
        this.extra_params = extra_params;
    }
}
