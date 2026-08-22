package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Categoryinfo implements Serializable {
    private String color;
    private String creation_time;
    private String font_color;
    private String id;
    private String image;
    private String last_updated;
    private String name;
    private String name_2;
    private String parent_id;
    private String status;
    private String stream_color;
    private String type;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor_font() {
        return this.font_color;
    }

    public void setColor_font(String font_color) {
        this.font_color = font_color;
    }

    public String getStream_color() {
        return this.stream_color;
    }

    public void setStream_color(String stream_color) {
        this.stream_color = stream_color;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName_2() {
        return this.name_2;
    }

    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLast_updated() {
        return this.last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Categoryinfo(String name) {
        this.name = name;
    }

    public String toString() {
        return "ClassPojo [id = " + this.id + ", color = " + this.color + ", status = " + this.status + ", name_2 = " + this.name_2 + ", name = " + this.name + ", creation_time = " + this.creation_time + ", image = " + this.image + ", last_updated = " + this.last_updated + ", type = " + this.type + ", parent_id = " + this.parent_id + Constants.AES_SUFFIX;
    }
}
