package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kotvertolet.youtubejextractor.models.newModels.AdaptiveFormatsItem;

/* JADX INFO: loaded from: classes7.dex */
public class AdaptiveVideoStream extends StreamItem {
    public static final Parcelable.Creator<AdaptiveVideoStream> CREATOR = new Parcelable.Creator<AdaptiveVideoStream>() { // from class: com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdaptiveVideoStream createFromParcel(Parcel parcel) {
            return new AdaptiveVideoStream(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdaptiveVideoStream[] newArray(int i) {
            return new AdaptiveVideoStream[0];
        }
    };
    private int fps;
    private String projectionType;
    private String qualityLabel;
    private String size;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AdaptiveVideoStream(String str, String str2, int i, int i2, String str3, int i3, int i4, int i5, String str4, String str5, String str6) {
        super(str, str2, i, i2, str3, i3, i4);
        this.fps = i5;
        this.size = str4;
        this.qualityLabel = str5;
        this.projectionType = str6;
    }

    public AdaptiveVideoStream(AdaptiveFormatsItem adaptiveFormatsItem) {
        super(adaptiveFormatsItem);
        this.fps = adaptiveFormatsItem.getFps();
        this.qualityLabel = adaptiveFormatsItem.getQualityLabel();
        this.projectionType = adaptiveFormatsItem.getProjectionType();
    }

    public int getFps() {
        return this.fps;
    }

    public void setFps(int i) {
        this.fps = i;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String getQualityLabel() {
        return this.qualityLabel;
    }

    public void setQualityLabel(String str) {
        this.qualityLabel = str;
    }

    public String getProjectionType() {
        return this.projectionType;
    }

    public void setProjectionType(String str) {
        this.projectionType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.extension);
        parcel.writeString(this.codec);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.iTag);
        parcel.writeString(this.url);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.approxDurationMs.intValue());
        parcel.writeInt(this.fps);
        parcel.writeString(this.size);
        parcel.writeString(this.qualityLabel);
        parcel.writeString(this.projectionType);
    }

    @Override // com.github.kotvertolet.youtubejextractor.models.StreamItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        AdaptiveVideoStream adaptiveVideoStream = (AdaptiveVideoStream) obj;
        if (this.fps != adaptiveVideoStream.fps) {
            return false;
        }
        String str = this.size;
        if (str == null ? adaptiveVideoStream.size != null : !str.equals(adaptiveVideoStream.size)) {
            return false;
        }
        String str2 = this.qualityLabel;
        if (str2 == null ? adaptiveVideoStream.qualityLabel != null : !str2.equals(adaptiveVideoStream.qualityLabel)) {
            return false;
        }
        String str3 = this.projectionType;
        String str4 = adaptiveVideoStream.projectionType;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    @Override // com.github.kotvertolet.youtubejextractor.models.StreamItem
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.fps) * 31;
        String str = this.size;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.qualityLabel;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.projectionType;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.github.kotvertolet.youtubejextractor.models.StreamItem
    public String toString() {
        return "VideoStreamItem{fps=" + this.fps + ", size='" + this.size + "', qualityLabel='" + this.qualityLabel + "', projectionType=" + this.projectionType + ", extension='" + this.extension + "', codec='" + this.codec + "', bitrate=" + this.bitrate + ", iTag=" + this.iTag + ", url='" + this.url + "', averageBitrate=" + this.averageBitrate + ", approxDurationMs=" + this.approxDurationMs + '}';
    }
}
