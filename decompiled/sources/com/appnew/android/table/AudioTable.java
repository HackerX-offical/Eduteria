package com.appnew.android.table;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AudioTable implements Serializable {
    private Long audio_currentpos;
    private String audio_url;
    private int autoid;
    private String course_id;
    private String jw_url;
    private String user_id;
    private String valid_to;
    private String video_id;
    private String video_name;

    public int getAutoid() {
        return this.autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_name() {
        return this.video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAudio_url() {
        return this.audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public Long getAudio_currentpos() {
        return this.audio_currentpos;
    }

    public void setAudio_currentpos(Long audio_currentpos) {
        this.audio_currentpos = audio_currentpos;
    }

    public String getJw_url() {
        return this.jw_url;
    }

    public void setJw_url(String jw_url) {
        this.jw_url = jw_url;
    }

    public String getValid_to() {
        return this.valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
