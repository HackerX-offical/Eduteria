package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebCommandMetadata.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u001b\u001a\u00020\u0010HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\""}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebCommandMetadata;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "apiUrl", "", "getApiUrl", "()Ljava/lang/String;", "setApiUrl", "(Ljava/lang/String;)V", "isSendPost", "", "()Z", "setSendPost", "(Z)V", "rootVe", "", "getRootVe", "()I", "setRootVe", "(I)V", "url", "getUrl", "setUrl", "webPageType", "getWebPageType", "setWebPageType", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class WebCommandMetadata implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebCommandMetadata> CREATOR = new Creator();

    @SerializedName("apiUrl")
    private String apiUrl;

    @SerializedName("sendPost")
    private boolean isSendPost;

    @SerializedName("rootVe")
    private int rootVe;

    @SerializedName("url")
    private String url;

    @SerializedName("webPageType")
    private String webPageType;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<WebCommandMetadata> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebCommandMetadata createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new WebCommandMetadata();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebCommandMetadata[] newArray(int i) {
            return new WebCommandMetadata[i];
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

    public final String getApiUrl() {
        return this.apiUrl;
    }

    public final void setApiUrl(String str) {
        this.apiUrl = str;
    }

    public final int getRootVe() {
        return this.rootVe;
    }

    public final void setRootVe(int i) {
        this.rootVe = i;
    }

    public final String getWebPageType() {
        return this.webPageType;
    }

    public final void setWebPageType(String str) {
        this.webPageType = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* JADX INFO: renamed from: isSendPost, reason: from getter */
    public final boolean getIsSendPost() {
        return this.isSendPost;
    }

    public final void setSendPost(boolean z) {
        this.isSendPost = z;
    }

    public String toString() {
        return "WebCommandMetadata{apiUrl = '" + this.apiUrl + "',rootVe = '" + this.rootVe + "',webPageType = '" + this.webPageType + "',url = '" + this.url + "',sendPost = '" + this.isSendPost + "'}";
    }
}
