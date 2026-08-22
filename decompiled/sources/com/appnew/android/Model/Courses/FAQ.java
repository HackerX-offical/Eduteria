package com.appnew.android.Model.Courses;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FAQ implements Serializable {
    private String course_id;
    private String description;
    private String id;
    private String position;
    private String question;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
        return "ClassPojo [id = " + this.id + ", description = " + this.description + ", question = " + this.question + ", course_id = " + this.course_id + ", position = " + this.position + Constants.AES_SUFFIX;
    }
}
