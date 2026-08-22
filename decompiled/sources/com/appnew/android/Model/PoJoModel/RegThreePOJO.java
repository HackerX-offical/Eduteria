package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RegThreePOJO implements Serializable {
    private String age;
    private String c_code;
    private String device_id;
    private String device_tokken;
    private String device_type;
    private String email;
    private String gender;
    private String is_social;
    private String location;
    private String mobile;
    private String name;
    private String otp;
    private String password;
    private String social_tokken;
    private String social_type;
    private String user_tokken;

    public RegThreePOJO(String name, String email, String location, String age, String gender, String password, String mobile, String c_code, String is_social, String social_type, String social_tokken, String device_type, String device_id, String device_tokken, String user_tokken, String otp) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.mobile = mobile;
        this.c_code = c_code;
        this.is_social = is_social;
        this.social_type = social_type;
        this.social_tokken = social_tokken;
        this.device_type = device_type;
        this.device_id = device_id;
        this.device_tokken = device_tokken;
        this.user_tokken = user_tokken;
        this.otp = otp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
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

    public String getSocial_tokken() {
        return this.social_tokken;
    }

    public void setSocial_tokken(String social_tokken) {
        this.social_tokken = social_tokken;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
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

    public String getUser_tokken() {
        return this.user_tokken;
    }

    public void setUser_tokken(String user_tokken) {
        this.user_tokken = user_tokken;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
