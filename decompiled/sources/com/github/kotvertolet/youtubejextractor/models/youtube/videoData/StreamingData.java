package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream;
import com.github.kotvertolet.youtubejextractor.models.newModels.AdaptiveFormatsItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class StreamingData implements Parcelable, Serializable {
    public static final Parcelable.Creator<StreamingData> CREATOR = new Parcelable.Creator<StreamingData>() { // from class: com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreamingData createFromParcel(Parcel parcel) {
            return new StreamingData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreamingData[] newArray(int i) {
            return new StreamingData[i];
        }
    };

    @Expose
    private List<AdaptiveAudioStream> adaptiveAudioStreams;

    @SerializedName("adaptiveFormats")
    private List<AdaptiveFormatsItem> adaptiveFormats;

    @Expose
    private List<AdaptiveVideoStream> adaptiveVideoStreams;

    @SerializedName("dashManifestUrl")
    private String dashManifestUrl;

    @SerializedName("expiresInSeconds")
    private String expiresInSeconds;

    @SerializedName("hlsManifestUrl")
    private String hlsManifestUrl;

    @SerializedName("formats")
    private List<MuxedStream> muxedStreams;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StreamingData() {
        this.adaptiveAudioStreams = new ArrayList();
        this.adaptiveVideoStreams = new ArrayList();
    }

    protected StreamingData(Parcel parcel) {
        this.adaptiveAudioStreams = new ArrayList();
        this.adaptiveVideoStreams = new ArrayList();
        this.expiresInSeconds = parcel.readString();
        this.dashManifestUrl = parcel.readString();
        this.hlsManifestUrl = parcel.readString();
        this.adaptiveAudioStreams = parcel.createTypedArrayList(AdaptiveAudioStream.CREATOR);
        this.adaptiveVideoStreams = parcel.createTypedArrayList(AdaptiveVideoStream.CREATOR);
    }

    public String getExpiresInSeconds() {
        return this.expiresInSeconds;
    }

    public void setExpiresInSeconds(String str) {
        this.expiresInSeconds = str;
    }

    public String getDashManifestUrl() {
        return this.dashManifestUrl;
    }

    public void setDashManifestUrl(String str) {
        this.dashManifestUrl = str;
    }

    public String getHlsManifestUrl() {
        return this.hlsManifestUrl;
    }

    public void setHlsManifestUrl(String str) {
        this.hlsManifestUrl = str;
    }

    public List<AdaptiveFormatsItem> getAdaptiveFormats() {
        return this.adaptiveFormats;
    }

    public void setAdaptiveFormats(List<AdaptiveFormatsItem> list) {
        this.adaptiveFormats = list;
    }

    public List<MuxedStream> getMuxedStreams() {
        return this.muxedStreams;
    }

    public void setMuxedStreams(List<MuxedStream> list) {
        this.muxedStreams = list;
    }

    public List<AdaptiveAudioStream> getAdaptiveAudioStreams() {
        return this.adaptiveAudioStreams;
    }

    public void setAdaptiveAudioStreams(List<AdaptiveAudioStream> list) {
        this.adaptiveAudioStreams = list;
    }

    public List<AdaptiveVideoStream> getAdaptiveVideoStreams() {
        return this.adaptiveVideoStreams;
    }

    public void setAdaptiveVideoStreams(List<AdaptiveVideoStream> list) {
        this.adaptiveVideoStreams = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.expiresInSeconds);
        parcel.writeString(this.dashManifestUrl);
        parcel.writeString(this.hlsManifestUrl);
        parcel.writeList(this.adaptiveAudioStreams);
        parcel.writeList(this.adaptiveVideoStreams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamingData)) {
            return false;
        }
        StreamingData streamingData = (StreamingData) obj;
        String str = this.expiresInSeconds;
        if (str == null ? streamingData.expiresInSeconds != null : !str.equals(streamingData.expiresInSeconds)) {
            return false;
        }
        String str2 = this.dashManifestUrl;
        if (str2 == null ? streamingData.dashManifestUrl != null : !str2.equals(streamingData.dashManifestUrl)) {
            return false;
        }
        String str3 = this.hlsManifestUrl;
        if (str3 == null ? streamingData.hlsManifestUrl != null : !str3.equals(streamingData.hlsManifestUrl)) {
            return false;
        }
        List<AdaptiveAudioStream> list = this.adaptiveAudioStreams;
        if (list == null ? streamingData.adaptiveAudioStreams != null : !list.equals(streamingData.adaptiveAudioStreams)) {
            return false;
        }
        List<AdaptiveVideoStream> list2 = this.adaptiveVideoStreams;
        List<AdaptiveVideoStream> list3 = streamingData.adaptiveVideoStreams;
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public int hashCode() {
        String str = this.expiresInSeconds;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.dashManifestUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.hlsManifestUrl;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<AdaptiveAudioStream> list = this.adaptiveAudioStreams;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<AdaptiveVideoStream> list2 = this.adaptiveVideoStreams;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "RawStreamingData{expiresInSeconds='" + this.expiresInSeconds + "', dashManifestUrl='" + this.dashManifestUrl + "', hlsManifestUrl='" + this.hlsManifestUrl + "', audioStreamItems=" + this.adaptiveAudioStreams + ", videoStreamItems=" + this.adaptiveVideoStreams + '}';
    }
}
