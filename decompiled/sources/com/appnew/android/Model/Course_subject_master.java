package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Course_subject_master implements Serializable {
    private String color_code;
    private String id;
    private String image;
    private String is_live;
    private String name;

    public String getColor() {
        return this.color_code;
    }

    public void setColor(String color) {
        this.color_code = color;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public String toString() {
        return "ClassPojo [id = " + this.id + ", name = " + this.name + ", image = " + this.image + Constants.AES_SUFFIX;
    }
}
