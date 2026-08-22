package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VideoSolutionResponse implements Serializable {
    private ArrayList<VideoSolutionData> data = null;
    private List<Object> error = null;
    private Integer isIosPrice;
    private String message;
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

    public ArrayList<VideoSolutionData> getData() {
        return this.data;
    }

    public void setData(ArrayList<VideoSolutionData> data) {
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
