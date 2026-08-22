package com.appnew.android.Model.Courses;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Reviews implements Serializable {
    private String course_fk_id;
    private String creation_time;
    private String id;
    private String name;
    private String profile_picture;
    private String rating;
    private String text;
    private String user_id;

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

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCourse_fk_id() {
        return this.course_fk_id;
    }

    public void setCourse_fk_id(String course_fk_id) {
        this.course_fk_id = course_fk_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
