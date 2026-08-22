package com.appnew.android.Model.COURSEDETAIL;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TilesItem implements Serializable {
    private boolean activate;
    private String id;

    @SerializedName("isvisible")
    private String isvisible = "false";

    @SerializedName("meta")
    private String meta;

    @SerializedName(Const.REVERT_API)
    private String revertApi;

    @SerializedName("set_as_demo")
    private String set_as_demo;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("tile_name")
    private String tileName;
    private String type;

    public String getSet_as_demo() {
        return this.set_as_demo;
    }

    public void setSet_as_demo(String set_as_demo) {
        this.set_as_demo = set_as_demo;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isActivate() {
        return this.activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public String getMeta() {
        return this.meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public TilesItem(String revertApi, String tileName, String id, String type, String meta, String set_as_demo, String thumbnail) {
        this.revertApi = revertApi;
        this.tileName = tileName;
        this.id = id;
        this.type = type;
        this.meta = meta;
        this.set_as_demo = set_as_demo;
        this.thumbnail = thumbnail;
    }

    public String getRevertApi() {
        return this.revertApi;
    }

    public String getTileName() {
        return this.tileName;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public void setRevertApi(String revertApi) {
        this.revertApi = revertApi;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsvisible() {
        return this.isvisible;
    }

    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible;
    }
}
