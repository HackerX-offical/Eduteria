package com.appnew.android.home.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class CategoryProgressData implements Parcelable {
    public static final Parcelable.Creator<CategoryProgressData> CREATOR = new Parcelable.Creator<CategoryProgressData>() { // from class: com.appnew.android.home.model.CategoryProgressData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CategoryProgressData createFromParcel(Parcel in) {
            return new CategoryProgressData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CategoryProgressData[] newArray(int size) {
            return new CategoryProgressData[size];
        }
    };
    private CategoryData categoryData;
    private String id;
    private String name;
    private String progress;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CategoryProgressData(String id, String name, String progress, CategoryData categoryData) {
        this.id = id;
        this.name = name;
        this.progress = progress;
        this.categoryData = categoryData;
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

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public CategoryData getCategoryData() {
        return this.categoryData;
    }

    public void setCategoryData(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    protected CategoryProgressData(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.progress = in.readString();
        this.categoryData = (CategoryData) in.readValue(CategoryData.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.progress);
        dest.writeValue(this.categoryData);
    }
}
