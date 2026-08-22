package com.appnew.android.Model.Courses;

import com.appnew.android.Model.InstallmentData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class InstallmentResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("installment")
    @Expose
    private List<Installment> installment;

    @SerializedName("is_gst")
    @Expose
    private String is_gst;

    @SerializedName("payment_mode")
    @Expose
    private String payment_mode;

    @SerializedName("tax_rate")
    @Expose
    private String tax_rate;

    @SerializedName("user_installment_data")
    @Expose
    private List<InstallmentData> user_installment_data;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public List<Installment> getInstallment() {
        return this.installment;
    }

    public void setInstallment(List<Installment> installment) {
        this.installment = installment;
    }

    public List<InstallmentData> getUser_installment_data() {
        return this.user_installment_data;
    }

    public void setUser_installment_data(List<InstallmentData> user_installment_data) {
        this.user_installment_data = user_installment_data;
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
}
