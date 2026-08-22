package com.appnew.android.pojo.Userinfo;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LanguagesData implements Serializable {
    private List<Languages> data;
    private String message;
    private boolean status;

    public List<Languages> getData() {
        return this.data;
    }

    public void setData(List<Languages> data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
