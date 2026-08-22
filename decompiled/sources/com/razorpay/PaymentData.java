package com.razorpay;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PaymentData implements Serializable {
    private JSONObject data = new JSONObject();
    private String externalWallet;
    private String orderId;
    private String paymentId;
    private String signature;
    private String userContact;
    private String userEmail;

    public String getUserEmail() {
        return this.userEmail;
    }

    void setUserEmail(String str) {
        this.userEmail = str;
    }

    public String getUserContact() {
        return this.userContact;
    }

    void setUserContact(String str) {
        this.userContact = str;
    }

    void setPaymentId(String str) {
        this.paymentId = str;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    void setOrderId(String str) {
        this.orderId = str;
    }

    public String getSignature() {
        return this.signature;
    }

    void setSignature(String str) {
        this.signature = str;
    }

    void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public JSONObject getData() {
        return this.data;
    }

    void setExternalWallet(String str) {
        this.externalWallet = str;
    }

    public String getExternalWallet() {
        return this.externalWallet;
    }
}
