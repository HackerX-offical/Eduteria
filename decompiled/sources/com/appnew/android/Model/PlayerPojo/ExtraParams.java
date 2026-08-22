package com.appnew.android.Model.PlayerPojo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExtraParams implements Serializable {
    String demo_percent;
    String feedback_video;
    String floating_number;
    String is_limited;
    String public_chat;
    String video_type_file;
    String videotoken;
    String vod_chat;

    public String getDemo_percent() {
        return this.demo_percent;
    }

    public void setDemo_percent(String demo_percent) {
        this.demo_percent = demo_percent;
    }

    public String getVideo_type_file() {
        return this.video_type_file;
    }

    public void setVideo_type_file(String video_type_file) {
        this.video_type_file = video_type_file;
    }

    public String getVideotoken() {
        return this.videotoken;
    }

    public void setVideotoken(String videotoken) {
        this.videotoken = videotoken;
    }

    public String getFeedback_video() {
        return this.feedback_video;
    }

    public String getPublic_chat() {
        return this.public_chat;
    }

    public void setPublic_chat(String public_chat) {
        this.public_chat = public_chat;
    }

    public void setFeedback_video(String feedback_video) {
        this.feedback_video = feedback_video;
    }

    public String getFloating_number() {
        return this.floating_number;
    }

    public void setFloating_number(String floating_number) {
        this.floating_number = floating_number;
    }

    public String getVod_chat() {
        return this.vod_chat;
    }

    public void setVod_chat(String vod_chat) {
        this.vod_chat = vod_chat;
    }

    public String getIs_limited() {
        return this.is_limited;
    }

    public void setIs_limited(String is_limited) {
        this.is_limited = is_limited;
    }
}
