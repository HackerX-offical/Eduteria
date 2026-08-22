package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Embed.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0019\u001a\u00020\u000eHÖ\u0001J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/Embed;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "flashSecureUrl", "", "getFlashSecureUrl", "()Ljava/lang/String;", "setFlashSecureUrl", "(Ljava/lang/String;)V", "flashUrl", "getFlashUrl", "setFlashUrl", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getHeight", "()I", "setHeight", "(I)V", "iframeUrl", "getIframeUrl", "setIframeUrl", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "setWidth", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class Embed implements Parcelable, Serializable {
    public static final Parcelable.Creator<Embed> CREATOR = new Creator();

    @SerializedName("flashSecureUrl")
    private String flashSecureUrl;

    @SerializedName("flashUrl")
    private String flashUrl;

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("iframeUrl")
    private String iframeUrl;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    private int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Embed> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Embed createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new Embed();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Embed[] newArray(int i) {
            return new Embed[i];
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

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final String getFlashUrl() {
        return this.flashUrl;
    }

    public final void setFlashUrl(String str) {
        this.flashUrl = str;
    }

    public final String getFlashSecureUrl() {
        return this.flashSecureUrl;
    }

    public final void setFlashSecureUrl(String str) {
        this.flashSecureUrl = str;
    }

    public final String getIframeUrl() {
        return this.iframeUrl;
    }

    public final void setIframeUrl(String str) {
        this.iframeUrl = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public String toString() {
        return "Embed{width = '" + this.width + "',flashUrl = '" + this.flashUrl + "',flashSecureUrl = '" + this.flashSecureUrl + "',iframeUrl = '" + this.iframeUrl + "',height = '" + this.height + "'}";
    }
}
