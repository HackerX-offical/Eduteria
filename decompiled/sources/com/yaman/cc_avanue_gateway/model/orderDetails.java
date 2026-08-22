package com.yaman.cc_avanue_gateway.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes9.dex */
public class orderDetails implements Parcelable {
    public static final Parcelable.Creator<orderDetails> CREATOR = new Parcelable.Creator<orderDetails>() { // from class: com.yaman.cc_avanue_gateway.model.orderDetails.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public orderDetails createFromParcel(Parcel parcel) {
            return new orderDetails(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public orderDetails[] newArray(int i) {
            return new orderDetails[i];
        }
    };
    String access_code;
    String cancel_url;
    String enc_val;
    String order_id;
    String redirect_url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEnc_val() {
        return this.enc_val;
    }

    public void setEnc_val(String str) {
        this.enc_val = str;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setRedirect_url(String str) {
        this.redirect_url = str;
    }

    public String getCancel_url() {
        return this.cancel_url;
    }

    public void setCancel_url(String str) {
        this.cancel_url = str;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public String getAccess_code() {
        return this.access_code;
    }

    public void setAccess_code(String str) {
        this.access_code = str;
    }

    public orderDetails() {
    }

    public orderDetails(Parcel parcel) {
        this.enc_val = parcel.readString();
        this.redirect_url = parcel.readString();
        this.cancel_url = parcel.readString();
        this.order_id = parcel.readString();
        this.access_code = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.enc_val);
        parcel.writeString(this.redirect_url);
        parcel.writeString(this.cancel_url);
        parcel.writeString(this.order_id);
        parcel.writeString(this.access_code);
    }
}
