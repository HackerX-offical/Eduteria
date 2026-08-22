package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Total implements Serializable {

    @SerializedName("count")
    @Expose
    private String count;
    private String end_date;

    @SerializedName("id")
    @Expose
    private String id;
    private String start_date;
    private String test_image;

    @SerializedName("text")
    @Expose
    private String text;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getTest_image() {
        return this.test_image;
    }

    public void setTest_image(String test_image) {
        this.test_image = test_image;
    }
}
