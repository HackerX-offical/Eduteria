package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddToWatchLaterCommand.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/AddToWatchLaterCommand;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "clickTrackingParams", "", "getClickTrackingParams", "()Ljava/lang/String;", "setClickTrackingParams", "(Ljava/lang/String;)V", "commandMetadata", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;", "getCommandMetadata", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;", "setCommandMetadata", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;)V", "playlistEditEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaylistEditEndpoint;", "getPlaylistEditEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaylistEditEndpoint;", "setPlaylistEditEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/PlaylistEditEndpoint;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class AddToWatchLaterCommand implements Parcelable, Serializable {
    public static final Parcelable.Creator<AddToWatchLaterCommand> CREATOR = new Creator();

    @SerializedName("clickTrackingParams")
    private String clickTrackingParams;

    @SerializedName("commandMetadata")
    private CommandMetadata commandMetadata;

    @SerializedName("playlistEditEndpoint")
    private PlaylistEditEndpoint playlistEditEndpoint;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AddToWatchLaterCommand> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddToWatchLaterCommand createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new AddToWatchLaterCommand();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddToWatchLaterCommand[] newArray(int i) {
            return new AddToWatchLaterCommand[i];
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

    public final CommandMetadata getCommandMetadata() {
        return this.commandMetadata;
    }

    public final void setCommandMetadata(CommandMetadata commandMetadata) {
        this.commandMetadata = commandMetadata;
    }

    public final PlaylistEditEndpoint getPlaylistEditEndpoint() {
        return this.playlistEditEndpoint;
    }

    public final void setPlaylistEditEndpoint(PlaylistEditEndpoint playlistEditEndpoint) {
        this.playlistEditEndpoint = playlistEditEndpoint;
    }

    public final String getClickTrackingParams() {
        return this.clickTrackingParams;
    }

    public final void setClickTrackingParams(String str) {
        this.clickTrackingParams = str;
    }

    public String toString() {
        return "AddToWatchLaterCommand{commandMetadata = '" + this.commandMetadata + "',playlistEditEndpoint = '" + this.playlistEditEndpoint + "',clickTrackingParams = '" + this.clickTrackingParams + "'}";
    }
}
