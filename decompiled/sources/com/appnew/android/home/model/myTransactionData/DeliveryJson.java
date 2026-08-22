package com.appnew.android.home.model.myTransactionData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DeliveryJson implements Serializable {

    @SerializedName("awbno")
    @Expose
    private String awbno;

    @SerializedName("carrier")
    @Expose
    private String carrier;

    @SerializedName("carrier_id")
    @Expose
    private String carrierId;

    @SerializedName("country_code")
    @Expose
    private String countryCode;

    @SerializedName("current_status")
    @Expose
    private String currentStatus;

    @SerializedName("current_status_desc")
    @Expose
    private String currentStatusDesc;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("order_data")
    @Expose
    private String orderData;

    @SerializedName("order_id")
    @Expose
    private String orderId;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("pickupdate")
    @Expose
    private String pickupdate;

    @SerializedName("scans")
    @Expose
    private List<Scan> scans = null;

    @SerializedName("status_time")
    @Expose
    private String statusTime;

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("tracking_url")
    @Expose
    private String trackingUrl;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAwbno() {
        return this.awbno;
    }

    public void setAwbno(String awbno) {
        this.awbno = awbno;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPickupdate() {
        return this.pickupdate;
    }

    public void setPickupdate(String pickupdate) {
        this.pickupdate = pickupdate;
    }

    public String getCurrentStatusDesc() {
        return this.currentStatusDesc;
    }

    public void setCurrentStatusDesc(String currentStatusDesc) {
        this.currentStatusDesc = currentStatusDesc;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatusTime() {
        return this.statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public String getOrderData() {
        return this.orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierId() {
        return this.carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getTrackingUrl() {
        return this.trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public List<Scan> getScans() {
        return this.scans;
    }

    public void setScans(List<Scan> scans) {
        this.scans = scans;
    }
}
