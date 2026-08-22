package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatsItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010=\u001a\u00020\u000bHÖ\u0001J\b\u0010>\u001a\u00020\u0005H\u0016J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001e\u0010:\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000f¨\u0006D"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/FormatsItem;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "approxDurationMs", "", "getApproxDurationMs", "()Ljava/lang/String;", "setApproxDurationMs", "(Ljava/lang/String;)V", "audioChannels", "", "getAudioChannels", "()I", "setAudioChannels", "(I)V", "audioQuality", "getAudioQuality", "setAudioQuality", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "averageBitrate", "getAverageBitrate", "setAverageBitrate", "bitrate", "getBitrate", "setBitrate", "contentLength", "getContentLength", "setContentLength", "fps", "getFps", "setFps", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "setHeight", "itag", "getItag", "setItag", "lastModified", "getLastModified", "setLastModified", "mimeType", "getMimeType", "setMimeType", "projectionType", "getProjectionType", "setProjectionType", "quality", "getQuality", "setQuality", "qualityLabel", "getQualityLabel", "setQualityLabel", "url", "getUrl", "setUrl", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "setWidth", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class FormatsItem implements Parcelable, Serializable {
    public static final Parcelable.Creator<FormatsItem> CREATOR = new Creator();

    @SerializedName("approxDurationMs")
    private String approxDurationMs;

    @SerializedName("audioChannels")
    private int audioChannels;

    @SerializedName("audioQuality")
    private String audioQuality;

    @SerializedName("audioSampleRate")
    private String audioSampleRate;

    @SerializedName("averageBitrate")
    private int averageBitrate;

    @SerializedName("bitrate")
    private int bitrate;

    @SerializedName("contentLength")
    private String contentLength;

    @SerializedName("fps")
    private int fps;

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("itag")
    private int itag;

    @SerializedName("lastModified")
    private String lastModified;

    @SerializedName("mimeType")
    private String mimeType;

    @SerializedName("projectionType")
    private String projectionType;

    @SerializedName("quality")
    private String quality;

    @SerializedName("qualityLabel")
    private String qualityLabel;

    @SerializedName("url")
    private String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    private int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FormatsItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormatsItem createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new FormatsItem();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormatsItem[] newArray(int i) {
            return new FormatsItem[i];
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

    public final int getItag() {
        return this.itag;
    }

    public final void setItag(int i) {
        this.itag = i;
    }

    public final int getFps() {
        return this.fps;
    }

    public final void setFps(int i) {
        this.fps = i;
    }

    public final String getProjectionType() {
        return this.projectionType;
    }

    public final void setProjectionType(String str) {
        this.projectionType = str;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final void setBitrate(int i) {
        this.bitrate = i;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final String getAudioQuality() {
        return this.audioQuality;
    }

    public final void setAudioQuality(String str) {
        this.audioQuality = str;
    }

    public final String getApproxDurationMs() {
        return this.approxDurationMs;
    }

    public final void setApproxDurationMs(String str) {
        this.approxDurationMs = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public final void setAudioSampleRate(String str) {
        this.audioSampleRate = str;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final String getQualityLabel() {
        return this.qualityLabel;
    }

    public final void setQualityLabel(String str) {
        this.qualityLabel = str;
    }

    public final int getAudioChannels() {
        return this.audioChannels;
    }

    public final void setAudioChannels(int i) {
        this.audioChannels = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public final void setLastModified(String str) {
        this.lastModified = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final String getContentLength() {
        return this.contentLength;
    }

    public final void setContentLength(String str) {
        this.contentLength = str;
    }

    public final int getAverageBitrate() {
        return this.averageBitrate;
    }

    public final void setAverageBitrate(int i) {
        this.averageBitrate = i;
    }

    public String toString() {
        return "FormatsItem{itag = '" + this.itag + "',fps = '" + this.fps + "',projectionType = '" + this.projectionType + "',bitrate = '" + this.bitrate + "',mimeType = '" + this.mimeType + "',audioQuality = '" + this.audioQuality + "',approxDurationMs = '" + this.approxDurationMs + "',url = '" + this.url + "',audioSampleRate = '" + this.audioSampleRate + "',quality = '" + this.quality + "',qualityLabel = '" + this.qualityLabel + "',audioChannels = '" + this.audioChannels + "',width = '" + this.width + "',lastModified = '" + this.lastModified + "',height = '" + this.height + "',contentLength = '" + this.contentLength + "',averageBitrate = '" + this.averageBitrate + "'}";
    }
}
