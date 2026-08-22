package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\b\u0010$\u001a\u00020%H\u0016J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerConfig;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "audioConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/AudioConfig;", "getAudioConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/AudioConfig;", "setAudioConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/AudioConfig;)V", "daiConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/DaiConfig;", "getDaiConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/DaiConfig;", "setDaiConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/DaiConfig;)V", "mediaCommonConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/MediaCommonConfig;", "getMediaCommonConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/MediaCommonConfig;", "setMediaCommonConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/MediaCommonConfig;)V", "streamSelectionConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/StreamSelectionConfig;", "getStreamSelectionConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/StreamSelectionConfig;", "setStreamSelectionConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/StreamSelectionConfig;)V", "webPlayerConfig", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebPlayerConfig;", "getWebPlayerConfig", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebPlayerConfig;", "setWebPlayerConfig", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebPlayerConfig;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlayerConfig> CREATOR = new Creator();

    @SerializedName("audioConfig")
    private AudioConfig audioConfig;

    @SerializedName("daiConfig")
    private DaiConfig daiConfig;

    @SerializedName("mediaCommonConfig")
    private MediaCommonConfig mediaCommonConfig;

    @SerializedName("streamSelectionConfig")
    private StreamSelectionConfig streamSelectionConfig;

    @SerializedName("webPlayerConfig")
    private WebPlayerConfig webPlayerConfig;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerConfig createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlayerConfig();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerConfig[] newArray(int i) {
            return new PlayerConfig[i];
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

    public final WebPlayerConfig getWebPlayerConfig() {
        return this.webPlayerConfig;
    }

    public final void setWebPlayerConfig(WebPlayerConfig webPlayerConfig) {
        this.webPlayerConfig = webPlayerConfig;
    }

    public final MediaCommonConfig getMediaCommonConfig() {
        return this.mediaCommonConfig;
    }

    public final void setMediaCommonConfig(MediaCommonConfig mediaCommonConfig) {
        this.mediaCommonConfig = mediaCommonConfig;
    }

    public final DaiConfig getDaiConfig() {
        return this.daiConfig;
    }

    public final void setDaiConfig(DaiConfig daiConfig) {
        this.daiConfig = daiConfig;
    }

    public final AudioConfig getAudioConfig() {
        return this.audioConfig;
    }

    public final void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public final StreamSelectionConfig getStreamSelectionConfig() {
        return this.streamSelectionConfig;
    }

    public final void setStreamSelectionConfig(StreamSelectionConfig streamSelectionConfig) {
        this.streamSelectionConfig = streamSelectionConfig;
    }

    public String toString() {
        return "PlayerConfig{webPlayerConfig = '" + this.webPlayerConfig + "',mediaCommonConfig = '" + this.mediaCommonConfig + "',daiConfig = '" + this.daiConfig + "',audioConfig = '" + this.audioConfig + "',streamSelectionConfig = '" + this.streamSelectionConfig + "'}";
    }
}
