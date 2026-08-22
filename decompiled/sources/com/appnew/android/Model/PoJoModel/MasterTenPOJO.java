package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MasterTenPOJO implements Serializable {
    private String chapter_id;
    private String id;
    private String layer;
    private String revert_api;
    private String sub_id;
    private String sub_topic_id;
    private String tile_id;
    private String topic_id;
    private String type;
    private String unit_id;

    public MasterTenPOJO(String id, String sub_id, String unit_id, String chapter_id, String topic_id, String sub_topic_id, String layer, String type, String tile_id, String revert_api) {
        this.id = id;
        this.sub_id = sub_id;
        this.unit_id = unit_id;
        this.chapter_id = chapter_id;
        this.topic_id = topic_id;
        this.sub_topic_id = sub_topic_id;
        this.layer = layer;
        this.type = type;
        this.tile_id = tile_id;
        this.revert_api = revert_api;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSub_id() {
        return this.sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getUnit_id() {
        return this.unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getChapter_id() {
        return this.chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getSub_topic_id() {
        return this.sub_topic_id;
    }

    public void setSub_topic_id(String sub_topic_id) {
        this.sub_topic_id = sub_topic_id;
    }

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getRevert_api() {
        return this.revert_api;
    }

    public void setRevert_api(String revert_api) {
        this.revert_api = revert_api;
    }
}
