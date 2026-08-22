package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AtrUrl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/AtrUrl;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "elapsedMediaTimeSeconds", "", "getElapsedMediaTimeSeconds", "()I", "setElapsedMediaTimeSeconds", "(I)V", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class AtrUrl implements Parcelable, Serializable {
    public static final Parcelable.Creator<AtrUrl> CREATOR = new Creator();

    @SerializedName("baseUrl")
    private String baseUrl;

    @SerializedName("elapsedMediaTimeSeconds")
    private int elapsedMediaTimeSeconds;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AtrUrl> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AtrUrl createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new AtrUrl();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AtrUrl[] newArray(int i) {
            return new AtrUrl[i];
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

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public final int getElapsedMediaTimeSeconds() {
        return this.elapsedMediaTimeSeconds;
    }

    public final void setElapsedMediaTimeSeconds(int i) {
        this.elapsedMediaTimeSeconds = i;
    }

    public String toString() {
        return "AtrUrl{baseUrl = '" + this.baseUrl + "',elapsedMediaTimeSeconds = '" + this.elapsedMediaTimeSeconds + "'}";
    }
}
