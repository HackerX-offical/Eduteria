package com.appnew.android.Model.PoJoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CourseNotiJSON implements Serializable {

    @SerializedName("course_id")
    @Expose
    private List<String> courseId = null;

    @SerializedName("image")
    @Expose
    private String image;

    public List<String> getCourseId() {
        return this.courseId;
    }

    public void setCourseId(List<String> courseId) {
        this.courseId = courseId;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
