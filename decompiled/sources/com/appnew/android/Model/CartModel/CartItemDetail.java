package com.appnew.android.Model.CartModel;

import com.clevertap.android.sdk.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CartItemDetail implements Serializable {

    @SerializedName("cd_time")
    @Expose
    private Long cdTime;

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("interval")
    @Expose
    private Integer interval;

    @SerializedName(Constants.KEY_LIMIT)
    @Expose
    private Integer limit;

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

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCdTime() {
        return this.cdTime;
    }

    public void setCdTime(Long cdTime) {
        this.cdTime = cdTime;
    }
}
