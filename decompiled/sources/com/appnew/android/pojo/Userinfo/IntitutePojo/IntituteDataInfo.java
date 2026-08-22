package com.appnew.android.pojo.Userinfo.IntitutePojo;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IntituteDataInfo implements Serializable {
    private ArrayList<IntituteData> data;
    private String message;
    private boolean status;

    public void setData(ArrayList<IntituteData> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<IntituteData> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isStatus() {
        return this.status;
    }
}
