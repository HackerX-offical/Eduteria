package com.appnew.android.Model.test_sere;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class OrderHistoryData implements Serializable {
    private String coupon_applied;
    private String course_id;
    private String course_learner;
    private String course_price;
    private String cover_image;
    private String creation_time;
    private String gst;
    private String id;
    private String instructor_id;
    private String instructor_share;
    private String is_complete;
    private String is_dams;
    private String is_validity;
    private String net_amt;
    private String payIvia;
    private String points_rate;
    private String points_used;
    private String post_transaction_id;
    private String pre_transaction_id;
    private String refund_id;
    private String title;
    private String transaction_status;
    private String user_id;
    private String validity;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIs_dams() {
        return this.is_dams;
    }

    public void setIs_dams(String is_dams) {
        this.is_dams = is_dams;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
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

    public String getRefund_id() {
        return this.refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getPayIvia() {
        return this.payIvia;
    }

    public void setPayIvia(String payIvia) {
        this.payIvia = payIvia;
    }

    public String getCoupon_applied() {
        return this.coupon_applied;
    }

    public void setCoupon_applied(String coupon_applied) {
        this.coupon_applied = coupon_applied;
    }

    public String getCourse_price() {
        return this.course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getPoints_used() {
        return this.points_used;
    }

    public void setPoints_used(String points_used) {
        this.points_used = points_used;
    }

    public String getPoints_rate() {
        return this.points_rate;
    }

    public void setPoints_rate(String points_rate) {
        this.points_rate = points_rate;
    }

    public String getTransaction_status() {
        return this.transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getInstructor_id() {
        return this.instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_share() {
        return this.instructor_share;
    }

    public void setInstructor_share(String instructor_share) {
        this.instructor_share = instructor_share;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getIs_complete() {
        return this.is_complete;
    }

    public void setIs_complete(String is_complete) {
        this.is_complete = is_complete;
    }

    public String getIs_validity() {
        return this.is_validity;
    }

    public void setIs_validity(String is_validity) {
        this.is_validity = is_validity;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getCourse_learner() {
        return this.course_learner;
    }

    public void setCourse_learner(String course_learner) {
        this.course_learner = course_learner;
    }

    public String getNet_amt() {
        return this.net_amt;
    }

    public void setNet_amt(String net_amt) {
        this.net_amt = net_amt;
    }

    public String getGst() {
        return this.gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
}
