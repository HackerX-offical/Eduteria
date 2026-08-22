package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class VideoDetails implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoDetails> CREATOR = new Parcelable.Creator<VideoDetails>() { // from class: com.github.kotvertolet.youtubejextractor.models.youtube.videoData.VideoDetails.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoDetails createFromParcel(Parcel parcel) {
            return new VideoDetails(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoDetails[] newArray(int i) {
            return new VideoDetails[i];
        }
    };

    @SerializedName("allowRatings")
    private boolean allowRatings;

    @SerializedName("author")
    private String author;

    @SerializedName("averageRating")
    private double averageRating;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("isCrawlable")
    private boolean isCrawlable;

    @SerializedName("isLiveContent")
    private boolean isLiveContent;

    @SerializedName("isOwnerViewing")
    private boolean isOwnerViewing;

    @SerializedName("isPrivate")
    private boolean isPrivate;

    @SerializedName("isUnpluggedCorpus")
    private boolean isUnpluggedCorpus;

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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VideoDetails() {
    }

    public VideoDetails(boolean z, Thumbnail thumbnail, boolean z2, List<String> list, String str, String str2, String str3, String str4, boolean z3, String str5, boolean z4, double d2, boolean z5, boolean z6, String str6, String str7) {
        this.isOwnerViewing = z;
        this.thumbnail = thumbnail;
        this.isLiveContent = z2;
        this.keywords = list;
        this.author = str;
        this.lengthSeconds = str2;
        this.videoId = str3;
        this.shortDescription = str4;
        this.isPrivate = z3;
        this.title = str5;
        this.isCrawlable = z4;
        this.averageRating = d2;
        this.isUnpluggedCorpus = z5;
        this.allowRatings = z6;
        this.viewCount = str6;
        this.channelId = str7;
    }

    protected VideoDetails(Parcel parcel) {
        this.isOwnerViewing = parcel.readInt() != 0;
        this.thumbnail = (Thumbnail) parcel.readParcelable(Thumbnail.class.getClassLoader());
        this.isLiveContent = parcel.readInt() != 0;
        this.keywords = parcel.createStringArrayList();
        this.author = parcel.readString();
        this.lengthSeconds = parcel.readString();
        this.videoId = parcel.readString();
        this.shortDescription = parcel.readString();
        this.isPrivate = parcel.readInt() != 0;
        this.title = parcel.readString();
        this.isCrawlable = parcel.readInt() != 0;
        this.averageRating = parcel.readDouble();
        this.isUnpluggedCorpus = parcel.readInt() != 0;
        this.allowRatings = parcel.readInt() != 0;
        this.viewCount = parcel.readString();
        this.channelId = parcel.readString();
    }

    public boolean isIsOwnerViewing() {
        return this.isOwnerViewing;
    }

    public void setIsOwnerViewing(boolean z) {
        this.isOwnerViewing = z;
    }

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isLiveContent() {
        return this.isLiveContent;
    }

    public void setIsLiveContent(boolean z) {
        this.isLiveContent = z;
    }

    public List<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(List<String> list) {
        this.keywords = list;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public String getLengthSeconds() {
        return this.lengthSeconds;
    }

    public void setLengthSeconds(String str) {
        this.lengthSeconds = str;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String str) {
        this.shortDescription = str;
    }

    public boolean isIsPrivate() {
        return this.isPrivate;
    }

    public void setIsPrivate(boolean z) {
        this.isPrivate = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isIsCrawlable() {
        return this.isCrawlable;
    }

    public void setIsCrawlable(boolean z) {
        this.isCrawlable = z;
    }

    public double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(double d2) {
        this.averageRating = d2;
    }

    public boolean isIsUnpluggedCorpus() {
        return this.isUnpluggedCorpus;
    }

    public void setIsUnpluggedCorpus(boolean z) {
        this.isUnpluggedCorpus = z;
    }

    public boolean isAllowRatings() {
        return this.allowRatings;
    }

    public void setAllowRatings(boolean z) {
        this.allowRatings = z;
    }

    public String getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(String str) {
        this.viewCount = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public String toString() {
        return "VideoDetails{isOwnerViewing = '" + this.isOwnerViewing + "',thumbnail = '" + this.thumbnail + "',isLiveContent = '" + this.isLiveContent + "',keywords = '" + this.keywords + "',author = '" + this.author + "',lengthSeconds = '" + this.lengthSeconds + "',videoId = '" + this.videoId + "',shortDescription = '" + this.shortDescription + "',isPrivate = '" + this.isPrivate + "',title = '" + this.title + "',isCrawlable = '" + this.isCrawlable + "',averageRating = '" + this.averageRating + "',isUnpluggedCorpus = '" + this.isUnpluggedCorpus + "',allowRatings = '" + this.allowRatings + "',viewCount = '" + this.viewCount + "',channelId = '" + this.channelId + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoDetails)) {
            return false;
        }
        VideoDetails videoDetails = (VideoDetails) obj;
        if (this.isOwnerViewing != videoDetails.isOwnerViewing || this.isLiveContent != videoDetails.isLiveContent || this.isPrivate != videoDetails.isPrivate || this.isCrawlable != videoDetails.isCrawlable || Double.compare(videoDetails.averageRating, this.averageRating) != 0 || this.isUnpluggedCorpus != videoDetails.isUnpluggedCorpus || this.allowRatings != videoDetails.allowRatings) {
            return false;
        }
        Thumbnail thumbnail = this.thumbnail;
        if (thumbnail == null ? videoDetails.thumbnail != null : !thumbnail.equals(videoDetails.thumbnail)) {
            return false;
        }
        List<String> list = this.keywords;
        if (list == null ? videoDetails.keywords != null : !list.equals(videoDetails.keywords)) {
            return false;
        }
        String str = this.author;
        if (str == null ? videoDetails.author != null : !str.equals(videoDetails.author)) {
            return false;
        }
        String str2 = this.lengthSeconds;
        if (str2 == null ? videoDetails.lengthSeconds != null : !str2.equals(videoDetails.lengthSeconds)) {
            return false;
        }
        String str3 = this.videoId;
        if (str3 == null ? videoDetails.videoId != null : !str3.equals(videoDetails.videoId)) {
            return false;
        }
        String str4 = this.shortDescription;
        if (str4 == null ? videoDetails.shortDescription != null : !str4.equals(videoDetails.shortDescription)) {
            return false;
        }
        String str5 = this.title;
        if (str5 == null ? videoDetails.title != null : !str5.equals(videoDetails.title)) {
            return false;
        }
        String str6 = this.viewCount;
        if (str6 == null ? videoDetails.viewCount != null : !str6.equals(videoDetails.viewCount)) {
            return false;
        }
        String str7 = this.channelId;
        String str8 = videoDetails.channelId;
        return str7 != null ? str7.equals(str8) : str8 == null;
    }

    public int hashCode() {
        int i = (this.isOwnerViewing ? 1 : 0) * 31;
        Thumbnail thumbnail = this.thumbnail;
        int iHashCode = (((i + (thumbnail != null ? thumbnail.hashCode() : 0)) * 31) + (this.isLiveContent ? 1 : 0)) * 31;
        List<String> list = this.keywords;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.author;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.lengthSeconds;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.videoId;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.shortDescription;
        int iHashCode6 = (((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.isPrivate ? 1 : 0)) * 31;
        String str5 = this.title;
        int iHashCode7 = ((iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.isCrawlable ? 1 : 0);
        long jDoubleToLongBits = Double.doubleToLongBits(this.averageRating);
        int i2 = ((((((iHashCode7 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + (this.isUnpluggedCorpus ? 1 : 0)) * 31) + (this.allowRatings ? 1 : 0)) * 31;
        String str6 = this.viewCount;
        int iHashCode8 = (i2 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.channelId;
        return iHashCode8 + (str7 != null ? str7.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.isOwnerViewing ? 1 : 0);
        parcel.writeParcelable(this.thumbnail, i);
        parcel.writeInt(this.isLiveContent ? 1 : 0);
        parcel.writeList(this.keywords);
        parcel.writeString(this.author);
        parcel.writeString(this.lengthSeconds);
        parcel.writeString(this.videoId);
        parcel.writeString(this.shortDescription);
        parcel.writeInt(this.isPrivate ? 1 : 0);
        parcel.writeString(this.title);
        parcel.writeInt(this.isCrawlable ? 1 : 0);
        parcel.writeDouble(this.averageRating);
        parcel.writeInt(this.isUnpluggedCorpus ? 1 : 0);
        parcel.writeInt(this.allowRatings ? 1 : 0);
        parcel.writeString(this.viewCount);
        parcel.writeString(this.channelId);
    }
}
