package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class LoginAuthPOJO implements Serializable {
    private String device_id;
    private String device_type;
    private String email;
    private String is_social;
    private String location;
    private String password;
    private String profile_picture;
    private String social_type;
    private String device_tokken = this.device_tokken;
    private String device_tokken = this.device_tokken;

    public LoginAuthPOJO(String mobile, String email, String password, String is_social, String social_type, String device_type, String location, String device_id, String profile_picture) {
        this.email = email;
        this.password = password;
        this.is_social = is_social;
        this.social_type = social_type;
        this.device_type = device_type;
        this.location = location;
        this.device_id = device_id;
        this.profile_picture = profile_picture;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_social() {
        return this.is_social;
    }

    public void setIs_social(String is_social) {
        this.is_social = is_social;
    }

    public String getSocial_type() {
        return this.social_type;
    }

    public void setSocial_type(String social_type) {
        this.social_type = social_type;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_tokken() {
        return this.device_tokken;
    }

    public void setDevice_tokken(String device_tokken) {
        this.device_tokken = device_tokken;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
