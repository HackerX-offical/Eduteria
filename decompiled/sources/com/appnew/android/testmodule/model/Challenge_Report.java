package com.appnew.android.testmodule.model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Challenge_Report implements Serializable {
    private ArrayList<QuestionDumps> data;
    private ArrayList<Errors> error;
    private String is_android_price;
    private String message;
    String status;

    public ArrayList<QuestionDumps> getData() {
        return this.data;
    }

    public void setData(ArrayList<QuestionDumps> data) {
        this.data = data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIs_android_price() {
        return this.is_android_price;
    }

    public void setIs_android_price(String is_android_price) {
        this.is_android_price = is_android_price;
    }

    public ArrayList<Errors> getError() {
        return this.error;
    }

    public void setError(ArrayList<Errors> error) {
        this.error = error;
    }

    public class Errors implements Serializable {
        public Errors() {
        }
    }
}
