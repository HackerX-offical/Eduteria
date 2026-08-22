package com.appnew.android.Courses.Modal;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Chapter implements Serializable {

    @SerializedName(Const.COLOR_CODE)
    @Expose
    private String colorCode;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;
    private String is_live;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName(Const.PARENT_ID)
    @Expose
    private String parentId;

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public Chapter(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
