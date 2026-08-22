package com.appnew.android.Model.Courses;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Basic implements Serializable {
    private String color_code;
    private String combo_course_ids;
    private String course_attribute;
    private String course_sp;
    private String desc_header_image;
    private String description;
    private List<EMIInfo> emi_prices;
    private String holderType;
    private String id;
    private String image_icon;
    private String is_postal_available;
    private String is_purchased;
    private String l_text;
    private String mrp;
    private String payment_type;
    private String r_text;
    private String title;
    private String title_2;
    private String validity;

    public Basic(String image_icon, String id, String title, String course_sp, String desc_header_image, String description, String validity, String payment_type, String color_code, String is_purchased, String mrp, String course_attribute, String l_text, String r_text, String is_postal_available, String holderType, String combo_course_ids, List<EMIInfo> emi_prices) {
        this.image_icon = image_icon;
        this.id = id;
        this.title = title;
        this.course_sp = course_sp;
        this.desc_header_image = desc_header_image;
        this.description = description;
        this.validity = validity;
        this.payment_type = payment_type;
        this.color_code = color_code;
        this.is_purchased = is_purchased;
        this.mrp = mrp;
        this.course_attribute = course_attribute;
        this.l_text = l_text;
        this.r_text = r_text;
        this.is_postal_available = is_postal_available;
        this.holderType = holderType;
        this.combo_course_ids = combo_course_ids;
        this.emi_prices = emi_prices;
    }

    public Basic(String image_icon, String id, String title, String course_sp, String desc_header_image, String description, String validity, String payment_type, String color_code, String is_purchased, String mrp, String course_attribute, String l_text, String r_text, String is_postal_available, String holderType, String combo_course_ids) {
        this.emi_prices = null;
        this.image_icon = image_icon;
        this.id = id;
        this.title = title;
        this.course_sp = course_sp;
        this.desc_header_image = desc_header_image;
        this.description = description;
        this.validity = validity;
        this.payment_type = payment_type;
        this.color_code = color_code;
        this.is_purchased = is_purchased;
        this.mrp = mrp;
        this.course_attribute = course_attribute;
        this.l_text = l_text;
        this.r_text = r_text;
        this.is_postal_available = is_postal_available;
        this.holderType = holderType;
        this.combo_course_ids = combo_course_ids;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_icon() {
        return this.image_icon;
    }

    public void setImage_icon(String image_icon) {
        this.image_icon = image_icon;
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

    public String getTitle_2() {
        return this.title_2;
    }

    public void setTitle_2(String title_2) {
        this.title_2 = title_2;
    }

    public String getCourse_sp() {
        return this.course_sp;
    }

    public void setCourse_sp(String course_sp) {
        this.course_sp = course_sp;
    }

    public String getDesc_header_image() {
        return this.desc_header_image;
    }

    public void setDesc_header_image(String desc_header_image) {
        this.desc_header_image = desc_header_image;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getPayment_type() {
        return this.payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getColor_code() {
        return this.color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCourse_attribute() {
        return this.course_attribute;
    }

    public void setCourse_attribute(String course_attribute) {
        this.course_attribute = course_attribute;
    }

    public String getL_text() {
        return this.l_text;
    }

    public void setL_text(String l_text) {
        this.l_text = l_text;
    }

    public String getR_text() {
        return this.r_text;
    }

    public void setR_text(String r_text) {
        this.r_text = r_text;
    }

    public String getIs_postal_available() {
        return this.is_postal_available;
    }

    public void setIs_postal_available(String is_postal_available) {
        this.is_postal_available = is_postal_available;
    }

    public String getHolderType() {
        return this.holderType;
    }

    public void setHolderType(String holderType) {
        this.holderType = holderType;
    }

    public String getCombo_course_ids() {
        return this.combo_course_ids;
    }

    public void setCombo_course_ids(String combo_course_ids) {
        this.combo_course_ids = combo_course_ids;
    }

    public List<EMIInfo> getEmiPrices() {
        return this.emi_prices;
    }

    public void setEmiPrices(List<EMIInfo> emi_prices) {
        this.emi_prices = emi_prices;
    }
}
