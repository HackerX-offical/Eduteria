package com.appnew.android.Model.Overview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Description implements Serializable {

    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("heading")
    @Expose
    private String heading;

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
