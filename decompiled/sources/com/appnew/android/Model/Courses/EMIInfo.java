package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class EMIInfo implements Serializable {

    @SerializedName("attribute")
    @Expose
    private String attribute;

    @SerializedName("comletion_date")
    @Expose
    private String comletionDate;

    @SerializedName("emi_mrp")
    @Expose
    private String emiMrp;

    @SerializedName("emi_no")
    @Expose
    private String emiNo;

    @SerializedName("emi_validity")
    @Expose
    private String emiValidity;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("invoice_url")
    @Expose
    private String invoiceUrl;

    @SerializedName("txn_id")
    @Expose
    private String txnId;

    @SerializedName("txn_status")
    @Expose
    private String txnStatus;

    @SerializedName("valid_from")
    @Expose
    private String validFrom;

    @SerializedName("valid_to")
    @Expose
    private String validTo;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmiNo() {
        return this.emiNo;
    }

    public void setEmiNo(String emiNo) {
        this.emiNo = emiNo;
    }

    public String getEmiMrp() {
        return this.emiMrp;
    }

    public void setEmiMrp(String emiMrp) {
        this.emiMrp = emiMrp;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getEmiValidity() {
        return this.emiValidity;
    }

    public void setEmiValidity(String emiValidity) {
        this.emiValidity = emiValidity;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getComletionDate() {
        return this.comletionDate;
    }

    public void setComletionDate(String comletionDate) {
        this.comletionDate = comletionDate;
    }

    public String getValidTo() {
        return this.validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getTxnStatus() {
        return this.txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }
}
