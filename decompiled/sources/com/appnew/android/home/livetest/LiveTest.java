package com.appnew.android.home.livetest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LiveTest implements Serializable {

    @SerializedName("data")
    @Expose
    private List<LiveTestData> data = null;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("time")
    @Expose
    private Long time;

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

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

    public List<LiveTestData> getData() {
        return this.data;
    }

    public void setData(List<LiveTestData> data) {
        this.data = data;
    }
}
