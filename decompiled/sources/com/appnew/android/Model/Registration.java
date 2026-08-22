package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Registration implements Serializable {
    static Registration registration;
    private String email;
    private String id;
    private String interested_course;
    private String interested_course_text;
    private String master_id;
    private String master_id_level_one;
    private String master_id_level_one_name;
    private String master_id_level_two;
    private String master_id_level_two_name;
    private String master_id_name;
    private String name;
    private String optional_text;
    private String profilepicture;
    private String user_id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterested_course_text() {
        return this.interested_course_text;
    }

    public void setInterested_course_text(String interested_course_text) {
        this.interested_course_text = interested_course_text;
    }

    public String getMaster_id_name() {
        return this.master_id_name;
    }

    public void setMaster_id_name(String master_id_name) {
        this.master_id_name = master_id_name;
    }

    public String getMaster_id_level_one_name() {
        return this.master_id_level_one_name;
    }

    public void setMaster_id_level_one_name(String master_id_level_one_name) {
        this.master_id_level_one_name = master_id_level_one_name;
    }

    public String getMaster_id_level_two_name() {
        return this.master_id_level_two_name;
    }

    public void setMaster_id_level_two_name(String master_id_level_two_name) {
        this.master_id_level_two_name = master_id_level_two_name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilepicture() {
        return this.profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public static Registration newInstance() {
        Registration registration2 = new Registration();
        registration = registration2;
        return registration2;
    }

    public static Registration getInstance() {
        if (registration == null) {
            registration = new Registration();
        }
        return registration;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMaster_id() {
        return this.master_id;
    }

    public void setMaster_id(String master_id) {
        this.master_id = master_id;
    }

    public String getMaster_id_level_one() {
        return this.master_id_level_one;
    }

    public void setMaster_id_level_one(String master_id_level_one) {
        this.master_id_level_one = master_id_level_one;
    }

    public String getMaster_id_level_two() {
        return this.master_id_level_two;
    }

    public void setMaster_id_level_two(String master_id_level_two) {
        this.master_id_level_two = master_id_level_two;
    }

    public String getOptional_text() {
        return this.optional_text;
    }

    public void setOptional_text(String optional_text) {
        this.optional_text = optional_text;
    }

    public String getInterested_course() {
        return this.interested_course;
    }

    public void setInterested_course(String interested_course) {
        this.interested_course = interested_course;
    }
}
