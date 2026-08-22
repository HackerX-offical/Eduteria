package com.appnew.android.home.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class CategoryData implements Parcelable {
    public static final Parcelable.Creator<CategoryData> CREATOR = new Parcelable.Creator<CategoryData>() { // from class: com.appnew.android.home.model.CategoryData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CategoryData createFromParcel(Parcel in) {
            return new CategoryData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CategoryData[] newArray(int size) {
            return new CategoryData[size];
        }
    };
    private String five;
    private String five_data;
    private String four;
    private String four_data;
    private String one;
    private String one_data;
    private String three;
    private String three_data;
    private String title;
    private String two;
    private String two_data;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CategoryData(String title, String one, String one_data, String two, String two_data, String three, String three_data, String four, String four_data, String five, String five_data) {
        this.title = title;
        this.one = one;
        this.one_data = one_data;
        this.two = two;
        this.two_data = two_data;
        this.three = three;
        this.three_data = three_data;
        this.four = four;
        this.four_data = four_data;
        this.five = five;
        this.five_data = five_data;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOne() {
        return this.one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getOne_data() {
        return this.one_data;
    }

    public void setOne_data(String one_data) {
        this.one_data = one_data;
    }

    public String getTwo() {
        return this.two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getTwo_data() {
        return this.two_data;
    }

    public void setTwo_data(String two_data) {
        this.two_data = two_data;
    }

    public String getThree() {
        return this.three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getThree_data() {
        return this.three_data;
    }

    public void setThree_data(String three_data) {
        this.three_data = three_data;
    }

    public String getFour() {
        return this.four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFour_data() {
        return this.four_data;
    }

    public void setFour_data(String four_data) {
        this.four_data = four_data;
    }

    public String getFive() {
        return this.five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getFive_data() {
        return this.five_data;
    }

    public void setFive_data(String five_data) {
        this.five_data = five_data;
    }

    protected CategoryData(Parcel in) {
        this.title = in.readString();
        this.one = in.readString();
        this.one_data = in.readString();
        this.two = in.readString();
        this.two_data = in.readString();
        this.three = in.readString();
        this.three_data = in.readString();
        this.four = in.readString();
        this.four_data = in.readString();
        this.five = in.readString();
        this.five_data = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.one);
        dest.writeString(this.one_data);
        dest.writeString(this.two);
        dest.writeString(this.two_data);
        dest.writeString(this.three);
        dest.writeString(this.three_data);
        dest.writeString(this.four);
        dest.writeString(this.four_data);
        dest.writeString(this.five);
        dest.writeString(this.five_data);
    }
}
