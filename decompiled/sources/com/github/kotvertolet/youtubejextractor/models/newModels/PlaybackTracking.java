package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaybackTracking.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\b\u0010<\u001a\u00020=H\u0016J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020;HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006C"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaybackTracking;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "atrUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/AtrUrl;", "getAtrUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/AtrUrl;", "setAtrUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/AtrUrl;)V", "googleRemarketingUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/GoogleRemarketingUrl;", "getGoogleRemarketingUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/GoogleRemarketingUrl;", "setGoogleRemarketingUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/GoogleRemarketingUrl;)V", "ptrackingUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PtrackingUrl;", "getPtrackingUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PtrackingUrl;", "setPtrackingUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PtrackingUrl;)V", "qoeUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/QoeUrl;", "getQoeUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/QoeUrl;", "setQoeUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/QoeUrl;)V", "setAwesomeUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SetAwesomeUrl;", "getSetAwesomeUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SetAwesomeUrl;", "setSetAwesomeUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SetAwesomeUrl;)V", "videostatsDelayplayUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsDelayplayUrl;", "getVideostatsDelayplayUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsDelayplayUrl;", "setVideostatsDelayplayUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsDelayplayUrl;)V", "videostatsPlaybackUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsPlaybackUrl;", "getVideostatsPlaybackUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsPlaybackUrl;", "setVideostatsPlaybackUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsPlaybackUrl;)V", "videostatsWatchtimeUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsWatchtimeUrl;", "getVideostatsWatchtimeUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsWatchtimeUrl;", "setVideostatsWatchtimeUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/VideostatsWatchtimeUrl;)V", "youtubeRemarketingUrl", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/YoutubeRemarketingUrl;", "getYoutubeRemarketingUrl", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/YoutubeRemarketingUrl;", "setYoutubeRemarketingUrl", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/YoutubeRemarketingUrl;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlaybackTracking implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlaybackTracking> CREATOR = new Creator();

    @SerializedName("atrUrl")
    private AtrUrl atrUrl;

    @SerializedName("googleRemarketingUrl")
    private GoogleRemarketingUrl googleRemarketingUrl;

    @SerializedName("ptrackingUrl")
    private PtrackingUrl ptrackingUrl;

    @SerializedName("qoeUrl")
    private QoeUrl qoeUrl;

    @SerializedName("setAwesomeUrl")
    private SetAwesomeUrl setAwesomeUrl;

    @SerializedName("videostatsDelayplayUrl")
    private VideostatsDelayplayUrl videostatsDelayplayUrl;

    @SerializedName("videostatsPlaybackUrl")
    private VideostatsPlaybackUrl videostatsPlaybackUrl;

    @SerializedName("videostatsWatchtimeUrl")
    private VideostatsWatchtimeUrl videostatsWatchtimeUrl;

    @SerializedName("youtubeRemarketingUrl")
    private YoutubeRemarketingUrl youtubeRemarketingUrl;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlaybackTracking> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaybackTracking createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlaybackTracking();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaybackTracking[] newArray(int i) {
            return new PlaybackTracking[i];
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

    public final VideostatsWatchtimeUrl getVideostatsWatchtimeUrl() {
        return this.videostatsWatchtimeUrl;
    }

    public final void setVideostatsWatchtimeUrl(VideostatsWatchtimeUrl videostatsWatchtimeUrl) {
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
    }

    public final VideostatsDelayplayUrl getVideostatsDelayplayUrl() {
        return this.videostatsDelayplayUrl;
    }

    public final void setVideostatsDelayplayUrl(VideostatsDelayplayUrl videostatsDelayplayUrl) {
        this.videostatsDelayplayUrl = videostatsDelayplayUrl;
    }

    public final QoeUrl getQoeUrl() {
        return this.qoeUrl;
    }

    public final void setQoeUrl(QoeUrl qoeUrl) {
        this.qoeUrl = qoeUrl;
    }

    public final YoutubeRemarketingUrl getYoutubeRemarketingUrl() {
        return this.youtubeRemarketingUrl;
    }

    public final void setYoutubeRemarketingUrl(YoutubeRemarketingUrl youtubeRemarketingUrl) {
        this.youtubeRemarketingUrl = youtubeRemarketingUrl;
    }

    public final GoogleRemarketingUrl getGoogleRemarketingUrl() {
        return this.googleRemarketingUrl;
    }

    public final void setGoogleRemarketingUrl(GoogleRemarketingUrl googleRemarketingUrl) {
        this.googleRemarketingUrl = googleRemarketingUrl;
    }

    public final SetAwesomeUrl getSetAwesomeUrl() {
        return this.setAwesomeUrl;
    }

    public final void setSetAwesomeUrl(SetAwesomeUrl setAwesomeUrl) {
        this.setAwesomeUrl = setAwesomeUrl;
    }

    public final VideostatsPlaybackUrl getVideostatsPlaybackUrl() {
        return this.videostatsPlaybackUrl;
    }

    public final void setVideostatsPlaybackUrl(VideostatsPlaybackUrl videostatsPlaybackUrl) {
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
    }

    public final PtrackingUrl getPtrackingUrl() {
        return this.ptrackingUrl;
    }

    public final void setPtrackingUrl(PtrackingUrl ptrackingUrl) {
        this.ptrackingUrl = ptrackingUrl;
    }

    public final AtrUrl getAtrUrl() {
        return this.atrUrl;
    }

    public final void setAtrUrl(AtrUrl atrUrl) {
        this.atrUrl = atrUrl;
    }

    public String toString() {
        return "PlaybackTracking{videostatsWatchtimeUrl = '" + this.videostatsWatchtimeUrl + "',videostatsDelayplayUrl = '" + this.videostatsDelayplayUrl + "',qoeUrl = '" + this.qoeUrl + "',youtubeRemarketingUrl = '" + this.youtubeRemarketingUrl + "',googleRemarketingUrl = '" + this.googleRemarketingUrl + "',setAwesomeUrl = '" + this.setAwesomeUrl + "',videostatsPlaybackUrl = '" + this.videostatsPlaybackUrl + "',ptrackingUrl = '" + this.ptrackingUrl + "',atrUrl = '" + this.atrUrl + "'}";
    }
}
