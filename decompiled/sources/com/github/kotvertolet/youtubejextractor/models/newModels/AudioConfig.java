package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/AudioConfig;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "isEnablePerFormatLoudness", "", "()Z", "setEnablePerFormatLoudness", "(Z)V", "loudnessDb", "", "getLoudnessDb", "()D", "setLoudnessDb", "(D)V", "perceptualLoudnessDb", "getPerceptualLoudnessDb", "setPerceptualLoudnessDb", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class AudioConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<AudioConfig> CREATOR = new Creator();

    @SerializedName("enablePerFormatLoudness")
    private boolean isEnablePerFormatLoudness;

    @SerializedName("loudnessDb")
    private double loudnessDb;

    @SerializedName("perceptualLoudnessDb")
    private double perceptualLoudnessDb;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AudioConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AudioConfig createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new AudioConfig();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AudioConfig[] newArray(int i) {
            return new AudioConfig[i];
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

    public final double getPerceptualLoudnessDb() {
        return this.perceptualLoudnessDb;
    }

    public final void setPerceptualLoudnessDb(double d2) {
        this.perceptualLoudnessDb = d2;
    }

    public final double getLoudnessDb() {
        return this.loudnessDb;
    }

    public final void setLoudnessDb(double d2) {
        this.loudnessDb = d2;
    }

    /* JADX INFO: renamed from: isEnablePerFormatLoudness, reason: from getter */
    public final boolean getIsEnablePerFormatLoudness() {
        return this.isEnablePerFormatLoudness;
    }

    public final void setEnablePerFormatLoudness(boolean z) {
        this.isEnablePerFormatLoudness = z;
    }

    public String toString() {
        return "AudioConfig{perceptualLoudnessDb = '" + this.perceptualLoudnessDb + "',loudnessDb = '" + this.loudnessDb + "',enablePerFormatLoudness = '" + this.isEnablePerFormatLoudness + "'}";
    }
}
