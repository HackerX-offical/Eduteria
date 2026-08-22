package com.appnew.android.Model.PlayerPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Addindex {

    @SerializedName("data")
    @Expose
    private VideoTimeFramePojo data;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("time")
    @Expose
    private Integer time;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VideoTimeFramePojo getData() {
        return this.data;
    }

    public void setData(VideoTimeFramePojo data) {
        this.data = data;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
