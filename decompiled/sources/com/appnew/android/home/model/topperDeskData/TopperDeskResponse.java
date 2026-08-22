package com.appnew.android.home.model.topperDeskData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopperDeskResponse implements Serializable {

    @SerializedName("data")
    @Expose
    private List<ToppersDeskData> data = null;

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

    public List<ToppersDeskData> getData() {
        return this.data;
    }

    public void setData(List<ToppersDeskData> data) {
        this.data = data;
    }
}
