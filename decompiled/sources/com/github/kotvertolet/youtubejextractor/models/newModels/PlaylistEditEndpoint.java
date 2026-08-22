package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaylistEditEndpoint.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaylistEditEndpoint;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", Constants.KEY_ACTIONS, "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ActionsItem;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "playlistId", "", "getPlaylistId", "()Ljava/lang/String;", "setPlaylistId", "(Ljava/lang/String;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class PlaylistEditEndpoint implements Parcelable, Serializable {
    public static final Parcelable.Creator<PlaylistEditEndpoint> CREATOR = new Creator();

    @SerializedName(Constants.KEY_ACTIONS)
    private List<ActionsItem> actions;

    @SerializedName("playlistId")
    private String playlistId;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PlaylistEditEndpoint> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaylistEditEndpoint createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new PlaylistEditEndpoint();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaylistEditEndpoint[] newArray(int i) {
            return new PlaylistEditEndpoint[i];
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

    public final String getPlaylistId() {
        return this.playlistId;
    }

    public final void setPlaylistId(String str) {
        this.playlistId = str;
    }

    public final List<ActionsItem> getActions() {
        return this.actions;
    }

    public final void setActions(List<ActionsItem> list) {
        this.actions = list;
    }

    public String toString() {
        return "PlaylistEditEndpoint{playlistId = '" + this.playlistId + "',actions = '" + this.actions + "'}";
    }
}
