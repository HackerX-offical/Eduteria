package com.appnew.android.testmodule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TestseriesBase implements Serializable {

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("error")
    @Expose
    private List<Object> error = null;
    private int lastanswerPosition;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

    public int getLastanswerPosition() {
        return this.lastanswerPosition;
    }

    public void setLastanswerPosition(int lastanswerPosition) {
        this.lastanswerPosition = lastanswerPosition;
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

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Object> getError() {
        return this.error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }
}
