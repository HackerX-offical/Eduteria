package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPlayerConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u00105\u001a\u000206HÖ\u0001J\b\u00107\u001a\u000208H\u0016J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000206HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006>"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideoPlayerConfig;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "messages", "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/MessagesItem;", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "microformat", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Microformat;", "getMicroformat", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Microformat;", "setMicroformat", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Microformat;)V", "playabilityStatus", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;", "getPlayabilityStatus", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;", "setPlayabilityStatus", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;)V", "playbackTracking", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaybackTracking;", "getPlaybackTracking", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaybackTracking;", "setPlaybackTracking", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaybackTracking;)V", "playerConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerConfig;", "getPlayerConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerConfig;", "setPlayerConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerConfig;)V", "responseContext", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ResponseContext;", "getResponseContext", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/ResponseContext;", "setResponseContext", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/ResponseContext;)V", "streamingData", "Lcom/github/kotvertolet/youtubejextractor/models/youtube/videoData/StreamingData;", "getStreamingData", "()Lcom/github/kotvertolet/youtubejextractor/models/youtube/videoData/StreamingData;", "setStreamingData", "(Lcom/github/kotvertolet/youtubejextractor/models/youtube/videoData/StreamingData;)V", "videoDetails", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideoDetails;", "getVideoDetails", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideoDetails;", "setVideoDetails", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideoDetails;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class VideoPlayerConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoPlayerConfig> CREATOR = new Creator();

    @SerializedName("messages")
    private List<MessagesItem> messages;

    @SerializedName("microformat")
    private Microformat microformat;

    @SerializedName("playabilityStatus")
    private PlayabilityStatus playabilityStatus;

    @SerializedName("playbackTracking")
    private PlaybackTracking playbackTracking;

    @SerializedName("playerConfig")
    private PlayerConfig playerConfig;

    @SerializedName("responseContext")
    private ResponseContext responseContext;

    @SerializedName("streamingData")
    private StreamingData streamingData;

    @SerializedName("videoDetails")
    private VideoDetails videoDetails;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VideoPlayerConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlayerConfig createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new VideoPlayerConfig();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlayerConfig[] newArray(int i) {
            return new VideoPlayerConfig[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(1);
    }

    public final PlayerConfig getPlayerConfig() {
        return this.playerConfig;
    }

    public final void setPlayerConfig(PlayerConfig playerConfig) {
        this.playerConfig = playerConfig;
    }

    public final VideoDetails getVideoDetails() {
        return this.videoDetails;
    }

    public final void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public final StreamingData getStreamingData() {
        return this.streamingData;
    }

    public final void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }

    public final ResponseContext getResponseContext() {
        return this.responseContext;
    }

    public final void setResponseContext(ResponseContext responseContext) {
        this.responseContext = responseContext;
    }

    public final PlayabilityStatus getPlayabilityStatus() {
        return this.playabilityStatus;
    }

    public final void setPlayabilityStatus(PlayabilityStatus playabilityStatus) {
        this.playabilityStatus = playabilityStatus;
    }

    public final List<MessagesItem> getMessages() {
        return this.messages;
    }

    public final void setMessages(List<MessagesItem> list) {
        this.messages = list;
    }

    public final PlaybackTracking getPlaybackTracking() {
        return this.playbackTracking;
    }

    public final void setPlaybackTracking(PlaybackTracking playbackTracking) {
        this.playbackTracking = playbackTracking;
    }

    public final Microformat getMicroformat() {
        return this.microformat;
    }

    public final void setMicroformat(Microformat microformat) {
        this.microformat = microformat;
    }

    public String toString() {
        return "YoutubeResponse{playerConfig = '" + this.playerConfig + "',videoDetails = '" + this.videoDetails + "',streamingData = '" + this.streamingData + "',responseContext = '" + this.responseContext + "',playbackTracking = '" + this.playbackTracking + "',microformat = '" + this.microformat + "'}";
    }
}
