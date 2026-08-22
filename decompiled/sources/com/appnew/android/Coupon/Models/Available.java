package com.appnew.android.Coupon.Models;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Available implements Serializable {
    String coupon_for;
    String coupon_tilte;
    String coupon_type;
    String coupon_value;
    List<CoursesCoupon> courses;
    String end;
    String exceed_message;
    String id;
    String image;
    String max_discount;
    String max_usage;
    List<RedeemJson> redeem_json;
    String target_type;

    public String getTarget_type() {
        return this.target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public String getExceed_message() {
        return this.exceed_message;
    }

    public void setExceed_message(String exceed_message) {
        this.exceed_message = exceed_message;
    }

    public List<RedeemJson> getRedeem_json() {
        return this.redeem_json;
    }

    public void setRedeem_json(List<RedeemJson> redeem_json) {
        this.redeem_json = redeem_json;
    }

    public String getMax_discount() {
        return this.max_discount;
    }

    public void setMax_discount(String max_discount) {
        this.max_discount = max_discount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCoupon_title() {
        return this.coupon_tilte;
    }

    public void setCoupon_title(String coupon_tilte) {
        this.coupon_tilte = coupon_tilte;
    }

    public String getCoupon_type() {
        return this.coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
    }

    public String getCoupon_for() {
        return this.coupon_for;
    }

    public void setCoupon_for(String coupon_for) {
        this.coupon_for = coupon_for;
    }

    public String getMax_usage() {
        return this.max_usage;
    }

    public void setMax_usage(String max_usage) {
        this.max_usage = max_usage;
    }

    public String getCoupon_value() {
        return this.coupon_value;
    }

    public void setCoupon_value(String coupon_value) {
        this.coupon_value = coupon_value;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<CoursesCoupon> getCourses() {
        return this.courses;
    }

    public void setCourses(List<CoursesCoupon> courses) {
        this.courses = courses;
    }
}
