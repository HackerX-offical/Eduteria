package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TestSeriesResult implements Serializable {
    private ArrayList<TestSeriesResultData> data = null;
    private List<Object> error = null;
    private Integer is_ios_price;
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

    public ArrayList<TestSeriesResultData> getData() {
        return this.data;
    }

    public void setData(ArrayList<TestSeriesResultData> data) {
        this.data = data;
    }

    public Integer getIs_ios_price() {
        return this.is_ios_price;
    }

    public void setIs_ios_price(Integer is_ios_price) {
        this.is_ios_price = is_ios_price;
    }

    public List<Object> getError() {
        return this.error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }
}
