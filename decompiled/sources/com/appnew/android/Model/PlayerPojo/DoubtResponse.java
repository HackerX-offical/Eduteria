package com.appnew.android.Model.PlayerPojo;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DoubtResponse implements Serializable {
    List<DoubtItemData> data = null;
    String message;
    String state;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DoubtItemData> getData() {
        return this.data;
    }

    public void setData(List<DoubtItemData> data) {
        this.data = data;
    }
}
