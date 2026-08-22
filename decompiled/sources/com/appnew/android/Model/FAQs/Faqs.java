package com.appnew.android.Model.FAQs;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Faqs {
    private ArrayList<FaqData> data = new ArrayList<>();
    private String message;
    private Boolean status;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FaqData> getData() {
        return this.data;
    }

    public void setData(ArrayList<FaqData> data) {
        this.data = data;
    }
}
