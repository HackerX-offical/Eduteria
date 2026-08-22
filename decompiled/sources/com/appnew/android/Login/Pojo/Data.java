package com.appnew.android.Login.Pojo;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName(Const.OTP)
    @Expose
    private Integer otp;

    @SerializedName("contact")
    @Expose
    private List<Long> contact = null;

    @SerializedName("course")
    @Expose
    private List<String> course = null;

    @SerializedName("email")
    @Expose
    private List<String> email = null;

    @SerializedName("enrollmentno")
    @Expose
    private List<String> enrollmentno = null;

    @SerializedName("sku")
    @Expose
    private List<String> sku = null;

    @SerializedName("sname")
    @Expose
    private List<String> sname = null;

    public List<Long> getContact() {
        return this.contact;
    }

    public void setContact(List<Long> contact) {
        this.contact = contact;
    }

    public List<String> getCourse() {
        return this.course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public List<String> getEmail() {
        return this.email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getEnrollmentno() {
        return this.enrollmentno;
    }

    public void setEnrollmentno(List<String> enrollmentno) {
        this.enrollmentno = enrollmentno;
    }

    public List<String> getSku() {
        return this.sku;
    }

    public void setSku(List<String> sku) {
        this.sku = sku;
    }

    public List<String> getSname() {
        return this.sname;
    }

    public void setSname(List<String> sname) {
        this.sname = sname;
    }

    public Integer getOtp() {
        return this.otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }
}
