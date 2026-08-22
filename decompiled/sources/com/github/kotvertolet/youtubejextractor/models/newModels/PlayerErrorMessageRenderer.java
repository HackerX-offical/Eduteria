package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerErrorMessageRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cHÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlayerErrorMessageRenderer;", "Landroid/os/Parcelable;", "()V", "icon", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;", "getIcon", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;", "setIcon", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;)V", "reason", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Reason;", "getReason", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Reason;", "setReason", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Reason;)V", "subreason", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Subreason;", "getSubreason", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Subreason;", "setSubreason", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Subreason;)V", "thumbnail", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "getThumbnail", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;", "setThumbnail", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Thumbnail;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerErrorMessageRenderer implements Parcelable {
    public static final Parcelable.Creator<PlayerErrorMessageRenderer> CREATOR = new Creator();

    @SerializedName("icon")
    private Icon icon;

    @SerializedName("reason")
    private Reason reason;

    @SerializedName("subreason")
    private Subreason subreason;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlayerErrorMessageRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerErrorMessageRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlayerErrorMessageRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayerErrorMessageRenderer[] newArray(int i) {
            return new PlayerErrorMessageRenderer[i];
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

    public final Reason getReason() {
        return this.reason;
    }

    public final void setReason(Reason reason) {
        this.reason = reason;
    }

    public final Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final void setIcon(Icon icon) {
        this.icon = icon;
    }

    public final Subreason getSubreason() {
        return this.subreason;
    }

    public final void setSubreason(Subreason subreason) {
        this.subreason = subreason;
    }

    public String toString() {
        return "PlayerErrorMessageRenderer{reason = '" + this.reason + "',thumbnail = '" + this.thumbnail + "',icon = '" + this.icon + "',subreason = '" + this.subreason + "'}";
    }
}
