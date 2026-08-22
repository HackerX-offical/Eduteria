package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebPlayerActionsPorting.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\b\u0010$\u001a\u00020%H\u0016J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebPlayerActionsPorting;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "addToWatchLaterCommand", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/AddToWatchLaterCommand;", "getAddToWatchLaterCommand", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/AddToWatchLaterCommand;", "setAddToWatchLaterCommand", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/AddToWatchLaterCommand;)V", "getSharePanelCommand", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/GetSharePanelCommand;", "getGetSharePanelCommand", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/GetSharePanelCommand;", "setGetSharePanelCommand", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/GetSharePanelCommand;)V", "removeFromWatchLaterCommand", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/RemoveFromWatchLaterCommand;", "getRemoveFromWatchLaterCommand", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/RemoveFromWatchLaterCommand;", "setRemoveFromWatchLaterCommand", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/RemoveFromWatchLaterCommand;)V", "subscribeCommand", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeCommand;", "getSubscribeCommand", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeCommand;", "setSubscribeCommand", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeCommand;)V", "unsubscribeCommand", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeCommand;", "getUnsubscribeCommand", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeCommand;", "setUnsubscribeCommand", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeCommand;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class WebPlayerActionsPorting implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebPlayerActionsPorting> CREATOR = new Creator();

    @SerializedName("addToWatchLaterCommand")
    private AddToWatchLaterCommand addToWatchLaterCommand;

    @SerializedName("getSharePanelCommand")
    private GetSharePanelCommand getSharePanelCommand;

    @SerializedName("removeFromWatchLaterCommand")
    private RemoveFromWatchLaterCommand removeFromWatchLaterCommand;

    @SerializedName("subscribeCommand")
    private SubscribeCommand subscribeCommand;

    @SerializedName("unsubscribeCommand")
    private UnsubscribeCommand unsubscribeCommand;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<WebPlayerActionsPorting> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebPlayerActionsPorting createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new WebPlayerActionsPorting();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebPlayerActionsPorting[] newArray(int i) {
            return new WebPlayerActionsPorting[i];
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

    public final RemoveFromWatchLaterCommand getRemoveFromWatchLaterCommand() {
        return this.removeFromWatchLaterCommand;
    }

    public final void setRemoveFromWatchLaterCommand(RemoveFromWatchLaterCommand removeFromWatchLaterCommand) {
        this.removeFromWatchLaterCommand = removeFromWatchLaterCommand;
    }

    public final SubscribeCommand getSubscribeCommand() {
        return this.subscribeCommand;
    }

    public final void setSubscribeCommand(SubscribeCommand subscribeCommand) {
        this.subscribeCommand = subscribeCommand;
    }

    public final GetSharePanelCommand getGetSharePanelCommand() {
        return this.getSharePanelCommand;
    }

    public final void setGetSharePanelCommand(GetSharePanelCommand getSharePanelCommand) {
        this.getSharePanelCommand = getSharePanelCommand;
    }

    public final UnsubscribeCommand getUnsubscribeCommand() {
        return this.unsubscribeCommand;
    }

    public final void setUnsubscribeCommand(UnsubscribeCommand unsubscribeCommand) {
        this.unsubscribeCommand = unsubscribeCommand;
    }

    public final AddToWatchLaterCommand getAddToWatchLaterCommand() {
        return this.addToWatchLaterCommand;
    }

    public final void setAddToWatchLaterCommand(AddToWatchLaterCommand addToWatchLaterCommand) {
        this.addToWatchLaterCommand = addToWatchLaterCommand;
    }

    public String toString() {
        return "WebPlayerActionsPorting{removeFromWatchLaterCommand = '" + this.removeFromWatchLaterCommand + "',subscribeCommand = '" + this.subscribeCommand + "',getSharePanelCommand = '" + this.getSharePanelCommand + "',unsubscribeCommand = '" + this.unsubscribeCommand + "',addToWatchLaterCommand = '" + this.addToWatchLaterCommand + "'}";
    }
}
