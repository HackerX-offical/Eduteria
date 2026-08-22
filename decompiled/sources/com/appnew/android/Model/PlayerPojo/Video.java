package com.appnew.android.Model.PlayerPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Video implements Serializable {
    String content_flag;

    @SerializedName("extra_params")
    @Expose
    private ExtraParams extra_params;
    String multiplayer;
    String p_chat_user;
    String remaining_time;

    @SerializedName("video_length")
    @Expose
    String video_length;

    public String getContent_flag() {
        return this.content_flag;
    }

    public void setContent_flag(String content_flag) {
        this.content_flag = content_flag;
    }

    public String getP_chat_user() {
        return this.p_chat_user;
    }

    public void setP_chat_user(String p_chat_user) {
        this.p_chat_user = p_chat_user;
    }

    public String getVideo_length() {
        return this.video_length;
    }

    public void setVideo_length(String video_length) {
        this.video_length = video_length;
    }

    public String getMultiplayer() {
        return this.multiplayer;
    }

    public void setMultiplayer(String multiplayer) {
        this.multiplayer = multiplayer;
    }

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public void setRemaining_time(String remaining_time) {
        this.remaining_time = remaining_time;
    }

    public ExtraParams getData() {
        return this.extra_params;
    }

    public void setData(ExtraParams data) {
        this.extra_params = data;
    }
}
