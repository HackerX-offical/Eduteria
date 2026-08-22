package com.appnew.android.CreateTest.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestData implements Serializable {
    private ArrayList<CreateTestSubject> data;
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

    public ArrayList<CreateTestSubject> getData() {
        return this.data;
    }

    public void setData(ArrayList<CreateTestSubject> data) {
        this.data = data;
    }
}
