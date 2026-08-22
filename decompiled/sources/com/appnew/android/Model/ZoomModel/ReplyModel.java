package com.appnew.android.Model.ZoomModel;

import com.clevertap.android.sdk.db.Column;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ReplyModel implements Serializable {

    @SerializedName(Column.CREATED_AT)
    @Expose
    private String created_at;

    @SerializedName("is_admin")
    @Expose
    private String is_admin;

    @SerializedName("reply")
    @Expose
    private String reply;

    @SerializedName("type")
    @Expose
    private String type;

    public ReplyModel(String is_admin, String reply, String created_at) {
        this.is_admin = is_admin;
        this.reply = reply;
        this.created_at = created_at;
    }

    public ReplyModel() {
    }

    public String getReply() {
        return this.reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getIs_admin() {
        return this.is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
