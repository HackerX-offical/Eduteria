package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MasterSevenPOJO implements Serializable {
    private String id;
    private String layer;
    private int page;
    private String revert_api;
    private String test_filter;
    private String tile_id;
    private String topic_id;
    private String type;

    public MasterSevenPOJO(String id, String layer, String topic_id, String type, String tile_id, String revert_api, String test_filter, int page) {
        this.id = id;
        this.layer = layer;
        this.topic_id = topic_id;
        this.type = type;
        this.tile_id = tile_id;
        this.revert_api = revert_api;
        this.test_filter = test_filter;
        this.page = page;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
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

    public String getTest_filter() {
        return this.test_filter;
    }

    public void setTest_filter(String test_filter) {
        this.test_filter = test_filter;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
