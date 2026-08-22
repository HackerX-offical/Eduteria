package com.appnew.android.home.liveclasses;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PayloadData implements Serializable {

    @SerializedName("course_id")
    @Expose
    private String course_id;

    @SerializedName(Const.REVERT_API)
    @Expose
    private String revert_api;

    @SerializedName("tile_id")
    @Expose
    private String tile_id;

    @SerializedName(Const.TILE_TYPE)
    @Expose
    private String tile_type;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topic_id;

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
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

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
