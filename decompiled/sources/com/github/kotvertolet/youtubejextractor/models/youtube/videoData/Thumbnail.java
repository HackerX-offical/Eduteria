package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class Thumbnail implements Parcelable, Serializable {
    public static final Parcelable.Creator<Thumbnail> CREATOR = new Parcelable.Creator<Thumbnail>() { // from class: com.github.kotvertolet.youtubejextractor.models.youtube.videoData.Thumbnail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Thumbnail createFromParcel(Parcel parcel) {
            return new Thumbnail(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Thumbnail[] newArray(int i) {
            return new Thumbnail[i];
        }
    };

    @SerializedName("thumbnails")
    private List<ThumbnailsItem> thumbnails;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Thumbnail() {
    }

    public Thumbnail(List<ThumbnailsItem> list) {
        this.thumbnails = list;
    }

    protected Thumbnail(Parcel parcel) {
        this.thumbnails = parcel.createTypedArrayList(ThumbnailsItem.CREATOR);
    }

    public List<ThumbnailsItem> getThumbnails() {
        return this.thumbnails;
    }

    public void setThumbnails(List<ThumbnailsItem> list) {
        this.thumbnails = list;
    }

    public String toString() {
        return "Thumbnail{thumbnails = '" + this.thumbnails + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thumbnail)) {
            return false;
        }
        List<ThumbnailsItem> list = this.thumbnails;
        List<ThumbnailsItem> list2 = ((Thumbnail) obj).thumbnails;
        return list != null ? list.equals(list2) : list2 == null;
    }

    public int hashCode() {
        List<ThumbnailsItem> list = this.thumbnails;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.thumbnails);
    }
}
