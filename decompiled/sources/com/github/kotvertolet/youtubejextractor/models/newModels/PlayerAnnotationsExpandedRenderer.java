package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerAnnotationsExpandedRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerAnnotationsExpandedRenderer;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "annotationId", "", "getAnnotationId", "()Ljava/lang/String;", "setAnnotationId", "(Ljava/lang/String;)V", "featuredChannel", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeaturedChannel;", "getFeaturedChannel", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeaturedChannel;", "setFeaturedChannel", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeaturedChannel;)V", "isAllowSwipeDismiss", "", "()Z", "setAllowSwipeDismiss", "(Z)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerAnnotationsExpandedRenderer implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlayerAnnotationsExpandedRenderer> CREATOR = new Creator();

    @SerializedName("annotationId")
    private String annotationId;

    @SerializedName("featuredChannel")
    private FeaturedChannel featuredChannel;

    @SerializedName("allowSwipeDismiss")
    private boolean isAllowSwipeDismiss;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerAnnotationsExpandedRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerAnnotationsExpandedRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlayerAnnotationsExpandedRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerAnnotationsExpandedRenderer[] newArray(int i) {
            return new PlayerAnnotationsExpandedRenderer[i];
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

    public final FeaturedChannel getFeaturedChannel() {
        return this.featuredChannel;
    }

    public final void setFeaturedChannel(FeaturedChannel featuredChannel) {
        this.featuredChannel = featuredChannel;
    }

    public final String getAnnotationId() {
        return this.annotationId;
    }

    public final void setAnnotationId(String str) {
        this.annotationId = str;
    }

    /* JADX INFO: renamed from: isAllowSwipeDismiss, reason: from getter */
    public final boolean getIsAllowSwipeDismiss() {
        return this.isAllowSwipeDismiss;
    }

    public final void setAllowSwipeDismiss(boolean z) {
        this.isAllowSwipeDismiss = z;
    }

    public String toString() {
        return "PlayerAnnotationsExpandedRenderer{featuredChannel = '" + this.featuredChannel + "',annotationId = '" + this.annotationId + "',allowSwipeDismiss = '" + this.isAllowSwipeDismiss + "'}";
    }
}
