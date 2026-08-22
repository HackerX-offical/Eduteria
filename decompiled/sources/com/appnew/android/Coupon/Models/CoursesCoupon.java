package com.appnew.android.Coupon.Models;

import com.appnew.android.Model.Courses.Installment;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CoursesCoupon implements Serializable {
    String cat_type;
    Available coupon;
    String course_sp;
    String cover_image;
    String discount;
    String external_coupon_off;
    String external_coupon_remark;
    String final_mrp;
    String id;
    private List<Installment> installment;
    String is_gst;
    String is_purchased;
    boolean is_select;
    String mrp;
    String quantity;
    String second_discount;
    Integer stopValidationOnCoupon;
    String tax;
    String tax_rate;
    String title;
    String validity;

    public String getExternal_coupon_remark() {
        return this.external_coupon_remark;
    }

    public void setExternal_coupon_remark(String external_coupon_remark) {
        this.external_coupon_remark = external_coupon_remark;
    }

    public String getSecond_discount() {
        return this.second_discount;
    }

    public void setSecond_discount(String second_discount) {
        this.second_discount = second_discount;
    }

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
    }

    public List<Installment> getInstallment() {
        return this.installment;
    }

    public void setInstallment(List<Installment> installment) {
        this.installment = installment;
    }

    public boolean isIs_select() {
        return this.is_select;
    }

    public void setIs_select(boolean is_select) {
        this.is_select = is_select;
    }

    public Available getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Available coupon) {
        this.coupon = coupon;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getFinal_mrp() {
        return this.final_mrp;
    }

    public void setFinal_mrp(String final_mrp) {
        this.final_mrp = final_mrp;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCourse_sp() {
        return this.course_sp;
    }

    public void setCourse_sp(String course_sp) {
        this.course_sp = course_sp;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getExternal_coupon_off() {
        return this.external_coupon_off;
    }

    public void setExternal_coupon_off(String external_coupon_off) {
        this.external_coupon_off = external_coupon_off;
    }

    public Integer getStopValidationOnCoupon() {
        return this.stopValidationOnCoupon;
    }

    public void setStopValidationOnCoupon(Integer stopValidationOnCoupon) {
        this.stopValidationOnCoupon = stopValidationOnCoupon;
    }

    public String getIs_gst() {
        return this.is_gst;
    }

    public void setIs_gst(String is_gst) {
        this.is_gst = is_gst;
    }

    public String getTax_rate() {
        return this.tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
