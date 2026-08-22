package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ApplyCouponPOJO implements Serializable {
    private String coupon_code;
    private String course_id;
    private String emi_no;

    public ApplyCouponPOJO(String course_id, String coupon_code, String emi_no) {
        this.course_id = course_id;
        this.coupon_code = coupon_code;
        this.emi_no = emi_no;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCoupon_code() {
        return this.coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getEmi_no() {
        return this.emi_no;
    }

    public void setEmi_no(String emi_no) {
        this.emi_no = emi_no;
    }
}
