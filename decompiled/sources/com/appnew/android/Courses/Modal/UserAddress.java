package com.appnew.android.Courses.Modal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class UserAddress implements Serializable {
    private String addressOne;
    private String addressTwo;
    private String phone;
    private String pincode;
    private String state;
    private String town;

    public UserAddress(String addressOne, String addressTwo, String town, String pincode, String state, String phone) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.town = town;
        this.pincode = pincode;
        this.state = state;
        this.phone = phone;
    }

    public String getAddressOne() {
        return this.addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return this.addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
