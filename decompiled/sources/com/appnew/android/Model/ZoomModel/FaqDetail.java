package com.appnew.android.Model.ZoomModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class FaqDetail implements Serializable {

    @SerializedName("data")
    @Expose
    private List<FaqModel> data = null;

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

    public List<FaqModel> getData() {
        return this.data;
    }

    public void setData(List<FaqModel> data) {
        this.data = data;
    }
}
