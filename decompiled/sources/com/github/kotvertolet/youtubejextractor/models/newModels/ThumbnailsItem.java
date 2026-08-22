package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbnailsItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ThumbnailsItem;", "Landroid/os/Parcelable;", "()V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getHeight", "()I", "setHeight", "(I)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "setWidth", "describeContents", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ThumbnailsItem implements Parcelable {
    public static final Parcelable.Creator<ThumbnailsItem> CREATOR = new Creator();

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("url")
    private String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
    private int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ThumbnailsItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThumbnailsItem createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new ThumbnailsItem();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ThumbnailsItem[] newArray(int i) {
            return new ThumbnailsItem[i];
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

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public String toString() {
        return "ThumbnailsItem{width = '" + this.width + "',url = '" + this.url + "',height = '" + this.height + "'}";
    }
}
