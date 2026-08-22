package com.appnew.android.Model.PlayerPojo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PollResponse implements Serializable {
    PollResponseData data;
    String message;
    String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PollResponseData getData() {
        return this.data;
    }

    public void setData(PollResponseData data) {
        this.data = data;
    }
}
