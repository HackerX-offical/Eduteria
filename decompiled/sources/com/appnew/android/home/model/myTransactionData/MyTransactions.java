package com.appnew.android.home.model.myTransactionData;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MyTransactions implements Serializable {

    @SerializedName("amount_paid")
    @Expose
    private String amountPaid;

    @SerializedName(Const.COLOR_CODE)
    @Expose
    private String colorCode;

    @SerializedName("course_attribute")
    @Expose
    private String courseAttribute;

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName("course_sp")
    @Expose
    private String courseSp;

    @SerializedName(Const.COURSE_TYPE)
    @Expose
    private String courseType;

    @SerializedName("cover_image")
    @Expose
    private String coverImage;

    @SerializedName("delivery_json")
    @Expose
    private List<DeliveryJson> deliveryJson = null;

    @SerializedName("delivery_status")
    @Expose
    private String deliveryStatus;

    @SerializedName("desc_header_image")
    @Expose
    private String descHeaderImage;

    @SerializedName("holder_type")
    @Expose
    private String holderType;

    @SerializedName("invoice_url")
    @Expose
    private String invoiceUrl;

    @SerializedName("mrp")
    @Expose
    private String mrp;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("transaction_date")
    @Expose
    private String transactionDate;

    @SerializedName("transaction_id")
    @Expose
    private String transactionId;

    @SerializedName("transaction_mode")
    @Expose
    private String transactionMode;

    @SerializedName(Const.TRANSACTION_STATUS)
    @Expose
    private String transactionStatus;

    @SerializedName("validity")
    @Expose
    private String validity;

    public String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public List<DeliveryJson> getDeliveryJson() {
        return this.deliveryJson;
    }

    public void setDeliveryJson(List<DeliveryJson> deliveryJson) {
        this.deliveryJson = deliveryJson;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionMode() {
        return this.transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseAttribute() {
        return this.courseAttribute;
    }

    public void setCourseAttribute(String courseAttribute) {
        this.courseAttribute = courseAttribute;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescHeaderImage() {
        return this.descHeaderImage;
    }

    public void setDescHeaderImage(String descHeaderImage) {
        this.descHeaderImage = descHeaderImage;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCourseSp() {
        return this.courseSp;
    }

    public void setCourseSp(String courseSp) {
        this.courseSp = courseSp;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCourseType() {
        return this.courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public String getHolderType() {
        return this.holderType;
    }

    public void setHolderType(String holderType) {
        this.holderType = holderType;
    }
}
