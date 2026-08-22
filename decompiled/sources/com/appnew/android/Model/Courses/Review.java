package com.appnew.android.Model.Courses;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Review implements Serializable {
    private String rating;
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
