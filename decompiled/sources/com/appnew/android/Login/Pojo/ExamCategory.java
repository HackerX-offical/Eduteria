package com.appnew.android.Login.Pojo;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExamCategory implements Serializable {
    private String description;
    private String id;
    private String image_url;
    private String parent_id;
    private String position;
    private String title;

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "ClassPojo [position = " + this.position + ", id = " + this.id + ", description = " + this.description + ", title = " + this.title + ", image_url = " + this.image_url + ", parent_id = " + this.parent_id + Constants.AES_SUFFIX;
    }
}
