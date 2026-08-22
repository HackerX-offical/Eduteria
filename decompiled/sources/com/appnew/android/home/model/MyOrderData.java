package com.appnew.android.home.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class MyOrderData implements Parcelable {
    public static final Parcelable.Creator<MyOrderData> CREATOR = new Parcelable.Creator<MyOrderData>() { // from class: com.appnew.android.home.model.MyOrderData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyOrderData createFromParcel(Parcel in) {
            return new MyOrderData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyOrderData[] newArray(int size) {
            return new MyOrderData[size];
        }
    };
    private String by_name;
    private String date;
    private String detail;
    private String id;
    private String image;
    private String name;
    private String price;
    private String status;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MyOrderData(String id, String name, String image, String by_name, String date, String detail, String price, String status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.by_name = by_name;
        this.date = date;
        this.detail = detail;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBy_name() {
        return this.by_name;
    }

    public void setBy_name(String by_name) {
        this.by_name = by_name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    protected MyOrderData(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.image = in.readString();
        this.by_name = in.readString();
        this.date = in.readString();
        this.detail = in.readString();
        this.price = in.readString();
        this.status = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.by_name);
        dest.writeString(this.date);
        dest.writeString(this.detail);
        dest.writeString(this.price);
        dest.writeString(this.status);
    }
}
