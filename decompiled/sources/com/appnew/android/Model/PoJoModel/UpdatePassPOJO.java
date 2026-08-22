package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class UpdatePassPOJO implements Serializable {
    private String c_code;
    private String mobile;
    private String otp;
    private String password;

    public UpdatePassPOJO(String c_code, String otp, String mobile, String password) {
        this.c_code = c_code;
        this.otp = otp;
        this.mobile = mobile;
        this.password = password;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
