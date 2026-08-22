package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class InitEMIPaymentPOJO implements Serializable {
    private String coupon_applied;
    private String course_id;
    private String course_price;
    private String emi_no;
    private String pay_via;
    private String post_transaction_id;
    private String pre_transaction_id;
    private String transaction_status;
    private String txn_id;

    public InitEMIPaymentPOJO(String course_id, String transaction_status, String pre_transaction_id, String post_transaction_id, String emi_no, String txn_id, String pay_via, String course_price, String coupon_applied) {
        this.course_id = course_id;
        this.transaction_status = transaction_status;
        this.pre_transaction_id = pre_transaction_id;
        this.post_transaction_id = post_transaction_id;
        this.emi_no = emi_no;
        this.txn_id = txn_id;
        this.pay_via = pay_via;
        this.course_price = course_price;
        this.coupon_applied = coupon_applied;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTransaction_status() {
        return this.transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getPre_transaction_id() {
        return this.pre_transaction_id;
    }

    public void setPre_transaction_id(String pre_transaction_id) {
        this.pre_transaction_id = pre_transaction_id;
    }

    public String getPost_transaction_id() {
        return this.post_transaction_id;
    }

    public void setPost_transaction_id(String post_transaction_id) {
        this.post_transaction_id = post_transaction_id;
    }

    public String getEmi_no() {
        return this.emi_no;
    }

    public void setEmi_no(String emi_no) {
        this.emi_no = emi_no;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getPay_via() {
        return this.pay_via;
    }

    public void setPay_via(String pay_via) {
        this.pay_via = pay_via;
    }

    public String getCourse_price() {
        return this.course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getCoupon_applied() {
        return this.coupon_applied;
    }

    public void setCoupon_applied(String coupon_applied) {
        this.coupon_applied = coupon_applied;
    }
}
