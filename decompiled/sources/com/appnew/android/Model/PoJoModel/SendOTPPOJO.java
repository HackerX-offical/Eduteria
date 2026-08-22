package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class SendOTPPOJO implements Serializable {
    private String is_registration;
    private String mobile;
    private String otp;

    public SendOTPPOJO(String mobile, String otp, String is_registration) {
        this.mobile = mobile;
        this.otp = otp;
        this.is_registration = is_registration;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getIs_registration() {
        return this.is_registration;
    }

    public void setIs_registration(String is_registration) {
        this.is_registration = is_registration;
    }
}
