package com.appnew.android.home.model.myTransactionData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Scan implements Serializable {

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("time")
    @Expose
    private String time;

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
