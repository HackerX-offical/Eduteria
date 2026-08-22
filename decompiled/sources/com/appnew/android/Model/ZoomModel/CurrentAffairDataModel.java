package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.db.Column;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CurrentAffairDataModel implements Serializable {

    @SerializedName(Column.CREATED_AT)
    @Expose
    private String created_at;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("file_url")
    @Expose
    private String file_url;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName(Const.POSITION)
    @Expose
    private String position;

    @SerializedName("set_as_new")
    @Expose
    private String set_as_new;

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSet_as_new() {
        return this.set_as_new;
    }

    public void setSet_as_new(String set_as_new) {
        this.set_as_new = set_as_new;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
