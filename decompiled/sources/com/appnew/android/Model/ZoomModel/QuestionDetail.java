package com.appnew.android.Model.ZoomModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionDetail implements Serializable {

    @SerializedName("data")
    @Expose
    private List<QuestionData> data = null;

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

    public List<QuestionData> getData() {
        return this.data;
    }

    public void setData(List<QuestionData> data) {
        this.data = data;
    }
}
