package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ThumbnailsItem implements Parcelable, Serializable {
    public static final Parcelable.Creator<ThumbnailsItem> CREATOR = new Parcelable.Creator<ThumbnailsItem>() { // from class: com.github.kotvertolet.youtubejextractor.models.youtube.videoData.ThumbnailsItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThumbnailsItem createFromParcel(Parcel parcel) {
            return new ThumbnailsItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThumbnailsItem[] newArray(int i) {
            return new ThumbnailsItem[i];
        }
    };

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("url")
    private String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    private int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ThumbnailsItem() {
    }

    public ThumbnailsItem(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.url = str;
    }

    protected ThumbnailsItem(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.url = parcel.readString();
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String toString() {
        return "ThumbnailsItem{width = '" + this.width + "',url = '" + this.url + "',height = '" + this.height + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbnailsItem)) {
            return false;
        }
        ThumbnailsItem thumbnailsItem = (ThumbnailsItem) obj;
        if (this.width != thumbnailsItem.width || this.height != thumbnailsItem.height) {
            return false;
        }
        String str = this.url;
        String str2 = thumbnailsItem.url;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        int i = this.width * 31;
        String str = this.url;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.height;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.url);
    }
}
