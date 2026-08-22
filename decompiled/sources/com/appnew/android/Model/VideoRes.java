package com.appnew.android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VideoRes {

    @SerializedName("data")
    @Expose
    private VideoResData data;

    @SerializedName("error")
    @Expose
    private List<Object> error = null;

    @SerializedName("is_ios_price")
    @Expose
    private Integer isIosPrice;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

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

    public VideoResData getData() {
        return this.data;
    }

    public void setData(VideoResData data) {
        this.data = data;
    }

    public Integer getIsIosPrice() {
        return this.isIosPrice;
    }

    public void setIsIosPrice(Integer isIosPrice) {
        this.isIosPrice = isIosPrice;
    }

    public List<Object> getError() {
        return this.error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }
}
