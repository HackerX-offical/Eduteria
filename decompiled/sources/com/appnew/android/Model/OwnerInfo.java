package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class OwnerInfo implements Serializable {
    private String id;
    private String is_expert;
    private String is_mentor;
    private String name;
    private String profile_picture;
    private String speciality;

    public String getIs_mentor() {
        return this.is_mentor;
    }

    public void setIs_mentor(String is_mentor) {
        this.is_mentor = is_mentor;
    }

    public String getIs_expert() {
        return this.is_expert;
    }

    public void setIs_expert(String is_expert) {
        this.is_expert = is_expert;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
