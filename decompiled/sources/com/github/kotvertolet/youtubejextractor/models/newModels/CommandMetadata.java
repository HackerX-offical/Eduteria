package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommandMetadata.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "webCommandMetadata", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebCommandMetadata;", "getWebCommandMetadata", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebCommandMetadata;", "setWebCommandMetadata", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebCommandMetadata;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class CommandMetadata implements Parcelable, Serializable {
    public static final Parcelable.Creator<CommandMetadata> CREATOR = new Creator();

    @SerializedName("webCommandMetadata")
    private WebCommandMetadata webCommandMetadata;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CommandMetadata> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommandMetadata createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new CommandMetadata();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommandMetadata[] newArray(int i) {
            return new CommandMetadata[i];
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

    public final WebCommandMetadata getWebCommandMetadata() {
        return this.webCommandMetadata;
    }

    public final void setWebCommandMetadata(WebCommandMetadata webCommandMetadata) {
        this.webCommandMetadata = webCommandMetadata;
    }

    public String toString() {
        return "CommandMetadata{webCommandMetadata = '" + this.webCommandMetadata + "'}";
    }
}
