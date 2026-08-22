package com.appnew.android.helpChat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ChatQuery implements Serializable {

    @SerializedName("create_date")
    @Expose
    private String createDate;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
