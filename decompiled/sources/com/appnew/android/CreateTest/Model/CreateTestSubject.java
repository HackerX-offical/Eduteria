package com.appnew.android.CreateTest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestSubject implements Serializable {

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;
    private boolean isSelect = false;

    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }
}
