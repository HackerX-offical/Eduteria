package com.appnew.android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PopupData implements Serializable {

    @SerializedName("course")
    @Expose
    private String course;

    @SerializedName("course_product")
    @Expose
    private String courseProduct;

    @SerializedName("enable_status")
    @Expose
    private String enable_status;

    @SerializedName("gift_course")
    @Expose
    private String giftCourse;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("popup_pass")
    @Expose
    private String popupPass;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private String type;

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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseProduct() {
        return this.courseProduct;
    }

    public void setCourseProduct(String courseProduct) {
        this.courseProduct = courseProduct;
    }

    public String getGiftCourse() {
        return this.giftCourse;
    }

    public void setGiftCourse(String giftCourse) {
        this.giftCourse = giftCourse;
    }

    public String getPopupPass() {
        return this.popupPass;
    }

    public void setPopupPass(String popupPass) {
        this.popupPass = popupPass;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEnable_status() {
        return this.enable_status;
    }

    public void setEnable_status(String enable_status) {
        this.enable_status = enable_status;
    }
}
