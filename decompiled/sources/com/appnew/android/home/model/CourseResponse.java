package com.appnew.android.home.model;

import com.appnew.android.Model.Courselist;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CourseResponse implements Serializable {
    private ArrayList<Courselist> data = new ArrayList<>();
    private int limit;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Courselist> getData() {
        return this.data;
    }

    public void setData(ArrayList<Courselist> data) {
        this.data = data;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
