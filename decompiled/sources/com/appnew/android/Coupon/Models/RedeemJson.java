package com.appnew.android.Coupon.Models;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RedeemJson implements Serializable {
    String c_title;
    String coupon_type;
    String coupon_value;
    long created;
    String max_discount;
    String title;
    String txn_id;

    public long getCreated() {
        return this.created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getC_title() {
        return this.c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getCoupon_type() {
        return this.coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
    }

    public String getCoupon_value() {
        return this.coupon_value;
    }

    public void setCoupon_value(String coupon_value) {
        this.coupon_value = coupon_value;
    }

    public String getMax_discount() {
        return this.max_discount;
    }

    public void setMax_discount(String max_discount) {
        this.max_discount = max_discount;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }
}
