package com.appnew.android.Model.UserAttendanceModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class UserAttendance implements Serializable {
    String creation_time;
    String date;
    String email;
    String in_time;
    String mobile;
    String name;
    String out_time;
    String remarks;
    String status;

    public void setDate(String date) {
    }

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIn_time() {
        return this.in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOut_time() {
        return this.out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
