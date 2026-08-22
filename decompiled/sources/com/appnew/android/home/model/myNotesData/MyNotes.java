package com.appnew.android.home.model.myNotesData;

import android.os.Parcel;
import android.os.Parcelable;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class MyNotes implements Parcelable {
    public static final Parcelable.Creator<MyNotes> CREATOR = new Parcelable.Creator<MyNotes>() { // from class: com.appnew.android.home.model.myNotesData.MyNotes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyNotes createFromParcel(Parcel in) {
            return new MyNotes(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyNotes[] newArray(int size) {
            return new MyNotes[size];
        }
    };

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

    @SerializedName("desc_header_image")
    @Expose
    private String descHeaderImage;

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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    protected MyNotes(Parcel in) {
        this.transactionStatus = in.readString();
        this.transactionMode = in.readString();
        this.transactionId = in.readString();
        this.amountPaid = in.readString();
        this.transactionDate = in.readString();
        this.courseId = in.readString();
        this.title = in.readString();
        this.courseAttribute = in.readString();
        this.coverImage = in.readString();
        this.descHeaderImage = in.readString();
        this.mrp = in.readString();
        this.courseSp = in.readString();
        this.colorCode = in.readString();
        this.validity = in.readString();
        this.courseType = in.readString();
        this.invoiceUrl = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.transactionStatus);
        dest.writeString(this.transactionMode);
        dest.writeString(this.transactionId);
        dest.writeString(this.amountPaid);
        dest.writeString(this.transactionDate);
        dest.writeString(this.courseId);
        dest.writeString(this.title);
        dest.writeString(this.courseAttribute);
        dest.writeString(this.coverImage);
        dest.writeString(this.descHeaderImage);
        dest.writeString(this.mrp);
        dest.writeString(this.courseSp);
        dest.writeString(this.colorCode);
        dest.writeString(this.validity);
        dest.writeString(this.courseType);
        dest.writeString(this.invoiceUrl);
    }
}
