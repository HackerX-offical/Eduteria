package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerMicroformatRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020 J\u000e\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020 J\b\u0010L\u001a\u00020\u0006H\u0016J\u0019\u0010M\u001a\u00020H2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020FHÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R \u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020 8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R \u0010&\u001a\u00020 2\u0006\u0010$\u001a\u00020 8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R \u0010'\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR \u0010*\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR \u0010-\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR \u00100\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010?\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR \u0010B\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000f¨\u0006Q"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerMicroformatRenderer;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "availableCountries", "", "", "getAvailableCountries", "()Ljava/util/List;", "setAvailableCountries", "(Ljava/util/List;)V", Const.CATEGORY, "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "description", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Description;", "getDescription", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Description;", "setDescription", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Description;)V", "embed", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Embed;", "getEmbed", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Embed;", "setEmbed", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Embed;)V", "externalChannelId", "getExternalChannelId", "setExternalChannelId", "isHasYpcMetadata", "", "()Z", "setHasYpcMetadata", "(Z)V", "<set-?>", "isIsFamilySafe", "isIsUnlisted", "lengthSeconds", "getLengthSeconds", "setLengthSeconds", "ownerChannelName", "getOwnerChannelName", "setOwnerChannelName", "ownerProfileUrl", "getOwnerProfileUrl", "setOwnerProfileUrl", "publishDate", "getPublishDate", "setPublishDate", "thumbnail", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "getThumbnail", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "setThumbnail", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;)V", "title", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Title;", "getTitle", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Title;", "setTitle", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Title;)V", "uploadDate", "getUploadDate", "setUploadDate", "viewCount", "getViewCount", "setViewCount", "describeContents", "", "setIsFamilySafe", "", "isFamilySafe", "setIsUnlisted", "isUnlisted", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerMicroformatRenderer implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlayerMicroformatRenderer> CREATOR = new Creator();

    @SerializedName("availableCountries")
    private List<String> availableCountries;

    @SerializedName(Const.CATEGORY)
    private String category;

    @SerializedName("description")
    private Description description;

    @SerializedName("embed")
    private Embed embed;

    @SerializedName("externalChannelId")
    private String externalChannelId;

    @SerializedName("hasYpcMetadata")
    private boolean isHasYpcMetadata;

    @SerializedName("isFamilySafe")
    private boolean isIsFamilySafe;

    @SerializedName("isUnlisted")
    private boolean isIsUnlisted;

    @SerializedName("lengthSeconds")
    private String lengthSeconds;

    @SerializedName("ownerChannelName")
    private String ownerChannelName;

    @SerializedName("ownerProfileUrl")
    private String ownerProfileUrl;

    @SerializedName("publishDate")
    private String publishDate;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("title")
    private Title title;

    @SerializedName("uploadDate")
    private String uploadDate;

    @SerializedName("viewCount")
    private String viewCount;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerMicroformatRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerMicroformatRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlayerMicroformatRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerMicroformatRenderer[] newArray(int i) {
            return new PlayerMicroformatRenderer[i];
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

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public final String getExternalChannelId() {
        return this.externalChannelId;
    }

    public final void setExternalChannelId(String str) {
        this.externalChannelId = str;
    }

    public final String getPublishDate() {
        return this.publishDate;
    }

    public final void setPublishDate(String str) {
        this.publishDate = str;
    }

    public final Description getDescription() {
        return this.description;
    }

    public final void setDescription(Description description) {
        this.description = description;
    }

    public final String getLengthSeconds() {
        return this.lengthSeconds;
    }

    public final void setLengthSeconds(String str) {
        this.lengthSeconds = str;
    }

    public final Title getTitle() {
        return this.title;
    }

    public final void setTitle(Title title) {
        this.title = title;
    }

    /* JADX INFO: renamed from: isHasYpcMetadata, reason: from getter */
    public final boolean getIsHasYpcMetadata() {
        return this.isHasYpcMetadata;
    }

    public final void setHasYpcMetadata(boolean z) {
        this.isHasYpcMetadata = z;
    }

    public final String getOwnerChannelName() {
        return this.ownerChannelName;
    }

    public final void setOwnerChannelName(String str) {
        this.ownerChannelName = str;
    }

    public final String getUploadDate() {
        return this.uploadDate;
    }

    public final void setUploadDate(String str) {
        this.uploadDate = str;
    }

    public final String getOwnerProfileUrl() {
        return this.ownerProfileUrl;
    }

    public final void setOwnerProfileUrl(String str) {
        this.ownerProfileUrl = str;
    }

    /* JADX INFO: renamed from: isIsUnlisted, reason: from getter */
    public final boolean getIsIsUnlisted() {
        return this.isIsUnlisted;
    }

    public final Embed getEmbed() {
        return this.embed;
    }

    public final void setEmbed(Embed embed) {
        this.embed = embed;
    }

    public final String getViewCount() {
        return this.viewCount;
    }

    public final void setViewCount(String str) {
        this.viewCount = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    /* JADX INFO: renamed from: isIsFamilySafe, reason: from getter */
    public final boolean getIsIsFamilySafe() {
        return this.isIsFamilySafe;
    }

    public final List<String> getAvailableCountries() {
        return this.availableCountries;
    }

    public final void setAvailableCountries(List<String> list) {
        this.availableCountries = list;
    }

    public final void setIsUnlisted(boolean isUnlisted) {
        this.isIsUnlisted = isUnlisted;
    }

    public final void setIsFamilySafe(boolean isFamilySafe) {
        this.isIsFamilySafe = isFamilySafe;
    }

    public String toString() {
        return "PlayerMicroformatRenderer{thumbnail = '" + this.thumbnail + "',externalChannelId = '" + this.externalChannelId + "',publishDate = '" + this.publishDate + "',description = '" + this.description + "',lengthSeconds = '" + this.lengthSeconds + "',title = '" + this.title + "',hasYpcMetadata = '" + this.isHasYpcMetadata + "',ownerChannelName = '" + this.ownerChannelName + "',uploadDate = '" + this.uploadDate + "',ownerProfileUrl = '" + this.ownerProfileUrl + "',isUnlisted = '" + this.isIsUnlisted + "',embed = '" + this.embed + "',viewCount = '" + this.viewCount + "',category = '" + this.category + "',isFamilySafe = '" + this.isIsFamilySafe + "',availableCountries = '" + this.availableCountries + "'}";
    }
}
