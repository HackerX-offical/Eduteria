package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class UpdateMobilePOJO implements Serializable {
    private String mobile;
    private String otp;

    public UpdateMobilePOJO(String mobile, String otp) {
        this.mobile = mobile;
        this.otp = otp;
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
}
