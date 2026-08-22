package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class YoutubeVideoData implements Parcelable, Serializable {
    public static final Parcelable.Creator<YoutubeVideoData> CREATOR = new Parcelable.Creator<YoutubeVideoData>() { // from class: com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YoutubeVideoData createFromParcel(Parcel parcel) {
            return new YoutubeVideoData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public YoutubeVideoData[] newArray(int i) {
            return new YoutubeVideoData[i];
        }
    };

    @SerializedName("streamingData")
    private StreamingData streamingData;

    @SerializedName("videoDetails")
    private VideoDetails videoDetails;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public YoutubeVideoData() {
    }

    protected YoutubeVideoData(Parcel parcel) {
        this.videoDetails = (VideoDetails) parcel.readParcelable(VideoDetails.class.getClassLoader());
        this.streamingData = (StreamingData) parcel.readParcelable(StreamingData.class.getClassLoader());
    }

    public VideoDetails getVideoDetails() {
        return this.videoDetails;
    }

    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public StreamingData getStreamingData() {
        return this.streamingData;
    }

    public void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }

    public String toString() {
        return "YoutubeVideoData{videoDetails=" + this.videoDetails + ", streamingData=" + this.streamingData + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YoutubeVideoData)) {
            return false;
        }
        YoutubeVideoData youtubeVideoData = (YoutubeVideoData) obj;
        if (this.videoDetails.equals(youtubeVideoData.videoDetails)) {
            return this.streamingData.equals(youtubeVideoData.streamingData);
        }
        return false;
    }

    public int hashCode() {
        return (this.videoDetails.hashCode() * 31) + this.streamingData.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.videoDetails, i);
        parcel.writeParcelable(this.streamingData, i);
    }
}
