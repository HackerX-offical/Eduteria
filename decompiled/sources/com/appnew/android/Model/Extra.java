package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Extra implements Serializable {
    private String course_id;
    private String file_id;
    private String revert_api;
    private String tile_id;
    private String tile_type;
    private String topic_id;

    public String getFile_id() {
        return this.file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTile_type() {
        return this.tile_type;
    }

    public void setTile_type(String tile_type) {
        this.tile_type = tile_type;
    }

    public String getRevert_api() {
        return this.revert_api;
    }

    public void setRevert_api(String revert_api) {
        this.revert_api = revert_api;
    }
}
