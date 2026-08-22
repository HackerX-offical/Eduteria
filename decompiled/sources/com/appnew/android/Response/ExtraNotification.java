package com.appnew.android.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExtraNotification implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("url")
    @Expose
    private String url;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
