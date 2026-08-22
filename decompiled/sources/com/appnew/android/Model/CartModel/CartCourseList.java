package com.appnew.android.Model.CartModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CartCourseList implements Serializable {

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName(Const.COURSE_PRICE)
    @Expose
    private String coursePrice;

    @SerializedName("tax")
    @Expose
    private String tax;

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCoursePrice() {
        return this.coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
