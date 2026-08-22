package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DynamicReadaheadConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/DynamicReadaheadConfig;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "maxReadAheadMediaTimeMs", "", "getMaxReadAheadMediaTimeMs", "()I", "setMaxReadAheadMediaTimeMs", "(I)V", "minReadAheadMediaTimeMs", "getMinReadAheadMediaTimeMs", "setMinReadAheadMediaTimeMs", "readAheadGrowthRateMs", "getReadAheadGrowthRateMs", "setReadAheadGrowthRateMs", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class DynamicReadaheadConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<DynamicReadaheadConfig> CREATOR = new Creator();

    @SerializedName("maxReadAheadMediaTimeMs")
    private int maxReadAheadMediaTimeMs;

    @SerializedName("minReadAheadMediaTimeMs")
    private int minReadAheadMediaTimeMs;

    @SerializedName("readAheadGrowthRateMs")
    private int readAheadGrowthRateMs;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DynamicReadaheadConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DynamicReadaheadConfig createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new DynamicReadaheadConfig();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DynamicReadaheadConfig[] newArray(int i) {
            return new DynamicReadaheadConfig[i];
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

    public final int getReadAheadGrowthRateMs() {
        return this.readAheadGrowthRateMs;
    }

    public final void setReadAheadGrowthRateMs(int i) {
        this.readAheadGrowthRateMs = i;
    }

    public final int getMaxReadAheadMediaTimeMs() {
        return this.maxReadAheadMediaTimeMs;
    }

    public final void setMaxReadAheadMediaTimeMs(int i) {
        this.maxReadAheadMediaTimeMs = i;
    }

    public final int getMinReadAheadMediaTimeMs() {
        return this.minReadAheadMediaTimeMs;
    }

    public final void setMinReadAheadMediaTimeMs(int i) {
        this.minReadAheadMediaTimeMs = i;
    }

    public String toString() {
        return "DynamicReadaheadConfig{readAheadGrowthRateMs = '" + this.readAheadGrowthRateMs + "',maxReadAheadMediaTimeMs = '" + this.maxReadAheadMediaTimeMs + "',minReadAheadMediaTimeMs = '" + this.minReadAheadMediaTimeMs + "'}";
    }
}
