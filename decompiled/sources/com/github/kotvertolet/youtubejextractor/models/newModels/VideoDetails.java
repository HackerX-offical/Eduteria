package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoDetails.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0014J\u000e\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\u0014J\u000e\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020\u0014J\u000e\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020\u0014J\b\u0010E\u001a\u00020\u0005H\u0016J\u0019\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020;HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001e\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\t¨\u0006J"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideoDetails;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "author", "", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "averageRating", "", "getAverageRating", "()D", "setAverageRating", "(D)V", "channelId", "getChannelId", "setChannelId", "isAllowRatings", "", "()Z", "setAllowRatings", "(Z)V", "<set-?>", "isIsCrawlable", "isIsOwnerViewing", "isIsPrivate", "isIsUnpluggedCorpus", "isLiveContent", "setLiveContent", "keywords", "", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "lengthSeconds", "getLengthSeconds", "setLengthSeconds", "shortDescription", "getShortDescription", "setShortDescription", "thumbnail", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "getThumbnail", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "setThumbnail", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;)V", "title", "getTitle", "setTitle", "videoId", "getVideoId", "setVideoId", "viewCount", "getViewCount", "setViewCount", "describeContents", "", "setIsCrawlable", "", "isCrawlable", "setIsOwnerViewing", "isOwnerViewing", "setIsPrivate", "isPrivate", "setIsUnpluggedCorpus", "isUnpluggedCorpus", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class VideoDetails implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoDetails> CREATOR = new Creator();

    @SerializedName("author")
    private String author;

    @SerializedName("averageRating")
    private double averageRating;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("allowRatings")
    private boolean isAllowRatings;

    @SerializedName("isCrawlable")
    private boolean isIsCrawlable;

    @SerializedName("isOwnerViewing")
    private boolean isIsOwnerViewing;

    @SerializedName("isPrivate")
    private boolean isIsPrivate;

    @SerializedName("isUnpluggedCorpus")
    private boolean isIsUnpluggedCorpus;

    @SerializedName("isLiveContent")
    private boolean isLiveContent;

    @SerializedName("keywords")
    private List<String> keywords;

    @SerializedName("lengthSeconds")
    private String lengthSeconds;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("title")
    private String title;

    @SerializedName("videoId")
    private String videoId;

    @SerializedName("viewCount")
    private String viewCount;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VideoDetails> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoDetails createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new VideoDetails();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoDetails[] newArray(int i) {
            return new VideoDetails[i];
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

    /* JADX INFO: renamed from: isIsOwnerViewing, reason: from getter */
    public final boolean getIsIsOwnerViewing() {
        return this.isIsOwnerViewing;
    }

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /* JADX INFO: renamed from: isLiveContent, reason: from getter */
    public final boolean getIsLiveContent() {
        return this.isLiveContent;
    }

    public final void setLiveContent(boolean z) {
        this.isLiveContent = z;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final void setKeywords(List<String> list) {
        this.keywords = list;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final void setAuthor(String str) {
        this.author = str;
    }

    public final String getLengthSeconds() {
        return this.lengthSeconds;
    }

    public final void setLengthSeconds(String str) {
        this.lengthSeconds = str;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final void setShortDescription(String str) {
        this.shortDescription = str;
    }

    /* JADX INFO: renamed from: isIsPrivate, reason: from getter */
    public final boolean getIsIsPrivate() {
        return this.isIsPrivate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: renamed from: isIsCrawlable, reason: from getter */
    public final boolean getIsIsCrawlable() {
        return this.isIsCrawlable;
    }

    public final double getAverageRating() {
        return this.averageRating;
    }

    public final void setAverageRating(double d2) {
        this.averageRating = d2;
    }

    /* JADX INFO: renamed from: isIsUnpluggedCorpus, reason: from getter */
    public final boolean getIsIsUnpluggedCorpus() {
        return this.isIsUnpluggedCorpus;
    }

    /* JADX INFO: renamed from: isAllowRatings, reason: from getter */
    public final boolean getIsAllowRatings() {
        return this.isAllowRatings;
    }

    public final void setAllowRatings(boolean z) {
        this.isAllowRatings = z;
    }

    public final String getViewCount() {
        return this.viewCount;
    }

    public final void setViewCount(String str) {
        this.viewCount = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setIsOwnerViewing(boolean isOwnerViewing) {
        this.isIsOwnerViewing = isOwnerViewing;
    }

    public final void setIsPrivate(boolean isPrivate) {
        this.isIsPrivate = isPrivate;
    }

    public final void setIsCrawlable(boolean isCrawlable) {
        this.isIsCrawlable = isCrawlable;
    }

    public final void setIsUnpluggedCorpus(boolean isUnpluggedCorpus) {
        this.isIsUnpluggedCorpus = isUnpluggedCorpus;
    }

    public String toString() {
        return "VideoDetails{isOwnerViewing = '" + this.isIsOwnerViewing + "',thumbnail = '" + this.thumbnail + "',isLiveContent = '" + this.isLiveContent + "',keywords = '" + this.keywords + "',author = '" + this.author + "',lengthSeconds = '" + this.lengthSeconds + "',videoId = '" + this.videoId + "',shortDescription = '" + this.shortDescription + "',isPrivate = '" + this.isIsPrivate + "',title = '" + this.title + "',isCrawlable = '" + this.isIsCrawlable + "',averageRating = '" + this.averageRating + "',isUnpluggedCorpus = '" + this.isIsUnpluggedCorpus + "',allowRatings = '" + this.isAllowRatings + "',viewCount = '" + this.viewCount + "',channelId = '" + this.channelId + "'}";
    }
}
