package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdaptiveFormatsItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010]\u001a\u00020\u000bHÖ\u0001J\u0013\u0010^\u001a\u0002082\b\u0010_\u001a\u0004\u0018\u00010`H\u0096\u0002J\b\u0010a\u001a\u00020\u000bH\u0016J\u0019\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001e\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR \u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR \u0010K\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR \u0010N\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR \u0010Q\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR \u0010T\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR \u0010W\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0007\"\u0004\bY\u0010\tR\u001e\u0010Z\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000f¨\u0006g"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/AdaptiveFormatsItem;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "approxDurationMs", "", "getApproxDurationMs", "()Ljava/lang/String;", "setApproxDurationMs", "(Ljava/lang/String;)V", "audioChannels", "", "getAudioChannels", "()I", "setAudioChannels", "(I)V", "audioQuality", "getAudioQuality", "setAudioQuality", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "averageBitrate", "getAverageBitrate", "setAverageBitrate", "bitrate", "getBitrate", "setBitrate", "cipher", "Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/Cipher;", "getCipher", "()Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/Cipher;", "setCipher", "(Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/Cipher;)V", "contentLength", "getContentLength", "setContentLength", "fps", "getFps", "setFps", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "setHeight", "indexRange", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/IndexRange;", "getIndexRange", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/IndexRange;", "setIndexRange", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/IndexRange;)V", "initRange", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/InitRange;", "getInitRange", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/InitRange;", "setInitRange", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/InitRange;)V", "isHighReplication", "", "()Z", "setHighReplication", "(Z)V", "itag", "getItag", "setItag", "lastModified", "getLastModified", "setLastModified", "loudnessDb", "", "getLoudnessDb", "()D", "setLoudnessDb", "(D)V", "mimeType", "getMimeType", "setMimeType", "projectionType", "getProjectionType", "setProjectionType", "quality", "getQuality", "setQuality", "qualityLabel", "getQualityLabel", "setQualityLabel", "type", "getType", "setType", "url", "getUrl", "setUrl", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "setWidth", "describeContents", "equals", "o", "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class AdaptiveFormatsItem implements Parcelable, Serializable {
    public static final Parcelable.Creator<AdaptiveFormatsItem> CREATOR = new Creator();

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

    @SerializedName(alternate = {"cipher"}, value = "signatureCipher")
    private Cipher cipher;

    @SerializedName("contentLength")
    private String contentLength;

    @SerializedName("fps")
    private int fps;

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("indexRange")
    private IndexRange indexRange;

    @SerializedName("initRange")
    private InitRange initRange;

    @SerializedName("highReplication")
    private boolean isHighReplication;

    @SerializedName("itag")
    private int itag;

    @SerializedName("lastModified")
    private String lastModified;

    @SerializedName("loudnessDb")
    private double loudnessDb;

    @SerializedName("mimeType")
    private String mimeType;

    @SerializedName("projectionType")
    private String projectionType;

    @SerializedName("quality")
    private String quality;

    @SerializedName("qualityLabel")
    private String qualityLabel;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    private int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdaptiveFormatsItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AdaptiveFormatsItem createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new AdaptiveFormatsItem();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AdaptiveFormatsItem[] newArray(int i) {
            return new AdaptiveFormatsItem[i];
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

    public final Cipher getCipher() {
        return this.cipher;
    }

    public final void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public final int getItag() {
        return this.itag;
    }

    public final void setItag(int i) {
        this.itag = i;
    }

    public final IndexRange getIndexRange() {
        return this.indexRange;
    }

    public final void setIndexRange(IndexRange indexRange) {
        this.indexRange = indexRange;
    }

    public final String getProjectionType() {
        return this.projectionType;
    }

    public final void setProjectionType(String str) {
        this.projectionType = str;
    }

    public final InitRange getInitRange() {
        return this.initRange;
    }

    public final void setInitRange(InitRange initRange) {
        this.initRange = initRange;
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

    public final int getAudioChannels() {
        return this.audioChannels;
    }

    public final void setAudioChannels(int i) {
        this.audioChannels = i;
    }

    public final String getContentLength() {
        return this.contentLength;
    }

    public final void setContentLength(String str) {
        this.contentLength = str;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public final void setLastModified(String str) {
        this.lastModified = str;
    }

    public final double getLoudnessDb() {
        return this.loudnessDb;
    }

    public final void setLoudnessDb(double d2) {
        this.loudnessDb = d2;
    }

    public final int getAverageBitrate() {
        return this.averageBitrate;
    }

    public final void setAverageBitrate(int i) {
        this.averageBitrate = i;
    }

    /* JADX INFO: renamed from: isHighReplication, reason: from getter */
    public final boolean getIsHighReplication() {
        return this.isHighReplication;
    }

    public final void setHighReplication(boolean z) {
        this.isHighReplication = z;
    }

    public final String getQualityLabel() {
        return this.qualityLabel;
    }

    public final void setQualityLabel(String str) {
        this.qualityLabel = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getFps() {
        return this.fps;
    }

    public final void setFps(int i) {
        this.fps = i;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && Intrinsics.areEqual(getClass(), o.getClass())) {
            AdaptiveFormatsItem adaptiveFormatsItem = (AdaptiveFormatsItem) o;
            if (this.itag != adaptiveFormatsItem.itag || this.bitrate != adaptiveFormatsItem.bitrate || this.audioChannels != adaptiveFormatsItem.audioChannels || Double.compare(adaptiveFormatsItem.loudnessDb, this.loudnessDb) != 0 || this.averageBitrate != adaptiveFormatsItem.averageBitrate || this.isHighReplication != adaptiveFormatsItem.isHighReplication || this.width != adaptiveFormatsItem.width || this.fps != adaptiveFormatsItem.fps || this.height != adaptiveFormatsItem.height) {
                return false;
            }
            if (this.cipher != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.cipher) : adaptiveFormatsItem.cipher != null) {
                return false;
            }
            if (this.indexRange != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.indexRange) : adaptiveFormatsItem.indexRange != null) {
                return false;
            }
            if (this.projectionType != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.projectionType) : adaptiveFormatsItem.projectionType != null) {
                return false;
            }
            if (this.initRange != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.initRange) : adaptiveFormatsItem.initRange != null) {
                return false;
            }
            if (this.mimeType != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.mimeType) : adaptiveFormatsItem.mimeType != null) {
                return false;
            }
            if (this.audioQuality != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.audioQuality) : adaptiveFormatsItem.audioQuality != null) {
                return false;
            }
            if (this.approxDurationMs != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.approxDurationMs) : adaptiveFormatsItem.approxDurationMs != null) {
                return false;
            }
            if (this.url != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.url) : adaptiveFormatsItem.url != null) {
                return false;
            }
            if (this.audioSampleRate != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.audioSampleRate) : adaptiveFormatsItem.audioSampleRate != null) {
                return false;
            }
            if (this.quality != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.quality) : adaptiveFormatsItem.quality != null) {
                return false;
            }
            if (this.contentLength != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.contentLength) : adaptiveFormatsItem.contentLength != null) {
                return false;
            }
            if (this.lastModified != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.lastModified) : adaptiveFormatsItem.lastModified != null) {
                return false;
            }
            if (this.qualityLabel != null ? !Intrinsics.areEqual(r2, adaptiveFormatsItem.qualityLabel) : adaptiveFormatsItem.qualityLabel != null) {
                return false;
            }
            String str = this.type;
            String str2 = adaptiveFormatsItem.type;
            if (str != null) {
                return Intrinsics.areEqual(str, str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Cipher cipher = this.cipher;
        int iHashCode = 0;
        int iHashCode2 = ((((cipher == null || cipher == null) ? 0 : cipher.hashCode()) * 31) + this.itag) * 31;
        IndexRange indexRange = this.indexRange;
        int iHashCode3 = (iHashCode2 + ((indexRange == null || indexRange == null) ? 0 : indexRange.hashCode())) * 31;
        String str = this.projectionType;
        int iHashCode4 = (iHashCode3 + ((str == null || str == null) ? 0 : str.hashCode())) * 31;
        InitRange initRange = this.initRange;
        int iHashCode5 = (((iHashCode4 + ((initRange == null || initRange == null) ? 0 : initRange.hashCode())) * 31) + this.bitrate) * 31;
        String str2 = this.mimeType;
        int iHashCode6 = (iHashCode5 + ((str2 == null || str2 == null) ? 0 : str2.hashCode())) * 31;
        String str3 = this.audioQuality;
        int iHashCode7 = (iHashCode6 + ((str3 == null || str3 == null) ? 0 : str3.hashCode())) * 31;
        String str4 = this.approxDurationMs;
        int iHashCode8 = (iHashCode7 + ((str4 == null || str4 == null) ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int iHashCode9 = (iHashCode8 + ((str5 == null || str5 == null) ? 0 : str5.hashCode())) * 31;
        String str6 = this.audioSampleRate;
        int iHashCode10 = (iHashCode9 + ((str6 == null || str6 == null) ? 0 : str6.hashCode())) * 31;
        String str7 = this.quality;
        int iHashCode11 = (((iHashCode10 + ((str7 == null || str7 == null) ? 0 : str7.hashCode())) * 31) + this.audioChannels) * 31;
        String str8 = this.contentLength;
        int iHashCode12 = (iHashCode11 + ((str8 == null || str8 == null) ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastModified;
        int iHashCode13 = iHashCode12 + ((str9 == null || str9 == null) ? 0 : str9.hashCode());
        long jDoubleToLongBits = Double.doubleToLongBits(this.loudnessDb);
        int i = ((((((iHashCode13 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.averageBitrate) * 31) + (this.isHighReplication ? 1 : 0)) * 31;
        String str10 = this.qualityLabel;
        int iHashCode14 = (((((i + ((str10 == null || str10 == null) ? 0 : str10.hashCode())) * 31) + this.width) * 31) + this.fps) * 31;
        String str11 = this.type;
        if (str11 != null && str11 != null) {
            iHashCode = str11.hashCode();
        }
        return ((iHashCode14 + iHashCode) * 31) + this.height;
    }
}
