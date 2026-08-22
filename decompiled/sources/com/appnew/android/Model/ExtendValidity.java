package com.appnew.android.Model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExtendValidity implements Serializable {

    @SerializedName("course_id")
    @Expose
    private String course_id;

    @SerializedName("id")
    @Expose
    private String id;
    private boolean is_select = false;

    @SerializedName(FirebaseAnalytics.Param.PRICE)
    @Expose
    private String price;

    @SerializedName("validity")
    @Expose
    private String validity;

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public boolean isIs_select() {
        return this.is_select;
    }

    public void setIs_select(boolean is_select) {
        this.is_select = is_select;
    }
}
