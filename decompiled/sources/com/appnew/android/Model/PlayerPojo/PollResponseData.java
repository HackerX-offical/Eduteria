package com.appnew.android.Model.PlayerPojo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PollResponseData implements Serializable {
    String course_id;
    String date;
    String id;
    String is_active;
    Polldata message;
    String name;
    String pin;
    String platform;
    String profile_picture;
    String type;
    String user_id;

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIs_active() {
        return this.is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Polldata getMessage() {
        return this.message;
    }

    public void setMessage(Polldata message) {
        this.message = message;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
