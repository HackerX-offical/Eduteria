package com.appnew.android.Response.Registration;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class StreamResponse implements Serializable {
    private String color;
    private String id;
    private String image;
    private String text;
    private String visibilty;

    public StreamResponse() {
    }

    public StreamResponse(String id, String visibilty, String text, String image, String color) {
        this.id = id;
        this.visibilty = visibilty;
        this.text = text;
        this.image = image;
        this.color = color;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisibilty() {
        return this.visibilty;
    }

    public void setVisibilty(String visibilty) {
        this.visibilty = visibilty;
    }

    public String getText_name() {
        return this.text;
    }

    public void setText_name(String text) {
        this.text = text;
    }
}
