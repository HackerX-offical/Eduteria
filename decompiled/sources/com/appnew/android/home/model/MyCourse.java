package com.appnew.android.home.model;

import com.appnew.android.Model.Courselist;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MyCourse implements Serializable {
    private ArrayList<Courselist> batchcourse;
    private ArrayList<Courselist> data;
    private List<Courselist> freecourse;
    private String message;
    private List<Courselist> paid_course;
    private boolean status;
    private int time;

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

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Courselist> getData() {
        return this.data;
    }

    public void setData(ArrayList<Courselist> data) {
        this.data = data;
    }

    public List<Courselist> getPaid_course() {
        return this.paid_course;
    }

    public void setPaid_course(List<Courselist> paid_course) {
        this.paid_course = paid_course;
    }

    public List<Courselist> getFreecourse() {
        return this.freecourse;
    }

    public void setFreecourse(List<Courselist> freecourse) {
        this.freecourse = freecourse;
    }

    public ArrayList<Courselist> getBatchcourse() {
        return this.batchcourse;
    }

    public void setBatchcourse(ArrayList<Courselist> batchcourse) {
        this.batchcourse = batchcourse;
    }
}
