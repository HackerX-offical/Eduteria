package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FreeCourseTwoPOJO implements Serializable {
    private String address;
    private String coupon_applied;
    private String course_id;

    public FreeCourseTwoPOJO(String course_id, String address, String coupon_applied) {
        this.course_id = course_id;
        this.address = address;
        this.coupon_applied = coupon_applied;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoupon_applied() {
        return this.coupon_applied;
    }

    public void setCoupon_applied(String coupon_applied) {
        this.coupon_applied = coupon_applied;
    }
}
