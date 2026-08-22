package com.appnew.android.Model.UserAttendanceModel;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class UserAttendanceMain implements Serializable {
    List<UserAttendance> data;
    String message;
    boolean status;

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

    public List<UserAttendance> getData() {
        return this.data;
    }

    public void setData(List<UserAttendance> data) {
        this.data = data;
    }
}
