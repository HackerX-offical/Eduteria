package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeaturedChannel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\b\u0010'\u001a\u00020\u0005H\u0016J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeaturedChannel;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "channelName", "", "getChannelName", "()Ljava/lang/String;", "setChannelName", "(Ljava/lang/String;)V", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "navigationEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;", "getNavigationEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;", "setNavigationEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;)V", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "subscribeButton", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButton;", "getSubscribeButton", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButton;", "setSubscribeButton", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButton;)V", "trackingParams", "getTrackingParams", "setTrackingParams", "watermark", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Watermark;", "getWatermark", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Watermark;", "setWatermark", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Watermark;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class FeaturedChannel implements Parcelable, Serializable {
    public static final Parcelable.Creator<FeaturedChannel> CREATOR = new Creator();

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("endTimeMs")
    private String endTimeMs;

    @SerializedName("navigationEndpoint")
    private NavigationEndpoint navigationEndpoint;

    @SerializedName("startTimeMs")
    private String startTimeMs;

    @SerializedName("subscribeButton")
    private SubscribeButton subscribeButton;

    @SerializedName("trackingParams")
    private String trackingParams;

    @SerializedName("watermark")
    private Watermark watermark;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FeaturedChannel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeaturedChannel createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new FeaturedChannel();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeaturedChannel[] newArray(int i) {
            return new FeaturedChannel[i];
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

    public final String getTrackingParams() {
        return this.trackingParams;
    }

    public final void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public final Watermark getWatermark() {
        return this.watermark;
    }

    public final void setWatermark(Watermark watermark) {
        this.watermark = watermark;
    }

    public final SubscribeButton getSubscribeButton() {
        return this.subscribeButton;
    }

    public final void setSubscribeButton(SubscribeButton subscribeButton) {
        this.subscribeButton = subscribeButton;
    }

    public final String getStartTimeMs() {
        return this.startTimeMs;
    }

    public final void setStartTimeMs(String str) {
        this.startTimeMs = str;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final String getEndTimeMs() {
        return this.endTimeMs;
    }

    public final void setEndTimeMs(String str) {
        this.endTimeMs = str;
    }

    public final NavigationEndpoint getNavigationEndpoint() {
        return this.navigationEndpoint;
    }

    public final void setNavigationEndpoint(NavigationEndpoint navigationEndpoint) {
        this.navigationEndpoint = navigationEndpoint;
    }

    public String toString() {
        return "FeaturedChannel{trackingParams = '" + this.trackingParams + "',watermark = '" + this.watermark + "',subscribeButton = '" + this.subscribeButton + "',startTimeMs = '" + this.startTimeMs + "',channelName = '" + this.channelName + "',endTimeMs = '" + this.endTimeMs + "',navigationEndpoint = '" + this.navigationEndpoint + "'}";
    }
}
