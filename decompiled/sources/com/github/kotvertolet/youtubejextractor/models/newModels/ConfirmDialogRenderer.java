package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfirmDialogRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\b\u0010$\u001a\u00020\u001dH\u0016J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ConfirmDialogRenderer;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "cancelButton", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/CancelButton;", "getCancelButton", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/CancelButton;", "setCancelButton", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/CancelButton;)V", "confirmButton", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ConfirmButton;", "getConfirmButton", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/ConfirmButton;", "setConfirmButton", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/ConfirmButton;)V", "dialogMessages", "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/DialogMessagesItem;", "getDialogMessages", "()Ljava/util/List;", "setDialogMessages", "(Ljava/util/List;)V", "isPrimaryIsCancel", "", "()Z", "setPrimaryIsCancel", "(Z)V", "trackingParams", "", "getTrackingParams", "()Ljava/lang/String;", "setTrackingParams", "(Ljava/lang/String;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmDialogRenderer implements Parcelable, Serializable {
    public static final Parcelable.Creator<ConfirmDialogRenderer> CREATOR = new Creator();

    @SerializedName("cancelButton")
    private CancelButton cancelButton;

    @SerializedName("confirmButton")
    private ConfirmButton confirmButton;

    @SerializedName("dialogMessages")
    private List<DialogMessagesItem> dialogMessages;

    @SerializedName("primaryIsCancel")
    private boolean isPrimaryIsCancel;

    @SerializedName("trackingParams")
    private String trackingParams;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ConfirmDialogRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmDialogRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new ConfirmDialogRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConfirmDialogRenderer[] newArray(int i) {
            return new ConfirmDialogRenderer[i];
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

    public final String getTrackingParams() {
        return this.trackingParams;
    }

    public final void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public final CancelButton getCancelButton() {
        return this.cancelButton;
    }

    public final void setCancelButton(CancelButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public final ConfirmButton getConfirmButton() {
        return this.confirmButton;
    }

    public final void setConfirmButton(ConfirmButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public final List<DialogMessagesItem> getDialogMessages() {
        return this.dialogMessages;
    }

    public final void setDialogMessages(List<DialogMessagesItem> list) {
        this.dialogMessages = list;
    }

    /* JADX INFO: renamed from: isPrimaryIsCancel, reason: from getter */
    public final boolean getIsPrimaryIsCancel() {
        return this.isPrimaryIsCancel;
    }

    public final void setPrimaryIsCancel(boolean z) {
        this.isPrimaryIsCancel = z;
    }

    public String toString() {
        return "ConfirmDialogRenderer{trackingParams = '" + this.trackingParams + "',cancelButton = '" + this.cancelButton + "',confirmButton = '" + this.confirmButton + "',dialogMessages = '" + this.dialogMessages + "',primaryIsCancel = '" + this.isPrimaryIsCancel + "'}";
    }
}
