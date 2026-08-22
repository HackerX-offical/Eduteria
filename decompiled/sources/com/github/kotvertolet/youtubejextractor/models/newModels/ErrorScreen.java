package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010HÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ErrorScreen;", "Landroid/os/Parcelable;", "()V", "playabilityStatus", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;", "getPlayabilityStatus", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;", "setPlayabilityStatus", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayabilityStatus;)V", "playerErrorMessageRenderer", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerErrorMessageRenderer;", "getPlayerErrorMessageRenderer", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerErrorMessageRenderer;", "setPlayerErrorMessageRenderer", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerErrorMessageRenderer;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorScreen implements Parcelable {
    public static final Parcelable.Creator<ErrorScreen> CREATOR = new Creator();

    @SerializedName("playabilityStatus")
    private PlayabilityStatus playabilityStatus;

    @SerializedName("playerErrorMessageRenderer")
    private PlayerErrorMessageRenderer playerErrorMessageRenderer;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ErrorScreen> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ErrorScreen createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new ErrorScreen();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ErrorScreen[] newArray(int i) {
            return new ErrorScreen[i];
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

    public final PlayabilityStatus getPlayabilityStatus() {
        return this.playabilityStatus;
    }

    public final void setPlayabilityStatus(PlayabilityStatus playabilityStatus) {
        this.playabilityStatus = playabilityStatus;
    }

    public final PlayerErrorMessageRenderer getPlayerErrorMessageRenderer() {
        return this.playerErrorMessageRenderer;
    }

    public final void setPlayerErrorMessageRenderer(PlayerErrorMessageRenderer playerErrorMessageRenderer) {
        this.playerErrorMessageRenderer = playerErrorMessageRenderer;
    }

    public String toString() {
        return "ErrorScreen{playabilityStatus = '" + this.playabilityStatus + "',playerErrorMessageRenderer = '" + this.playerErrorMessageRenderer + "'}";
    }
}
