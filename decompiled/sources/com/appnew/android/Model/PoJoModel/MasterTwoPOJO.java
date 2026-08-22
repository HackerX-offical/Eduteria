package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MasterTwoPOJO implements Serializable {
    private String id;
    private String layer;
    private String main_id;
    private String revert_api;
    private String tile_id;
    private String type;

    public MasterTwoPOJO(String id, String layer, String main_id, String type, String tile_id, String revert_api) {
        this.id = id;
        this.layer = layer;
        this.main_id = main_id;
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

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getMain_id() {
        return this.main_id;
    }

    public void setMain_id(String main_id) {
        this.main_id = main_id;
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
