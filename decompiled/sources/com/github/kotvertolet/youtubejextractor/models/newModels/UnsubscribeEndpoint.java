package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnsubscribeEndpoint.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeEndpoint;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "channelIds", "", "", "getChannelIds", "()Ljava/util/List;", "setChannelIds", "(Ljava/util/List;)V", NativeProtocol.WEB_DIALOG_PARAMS, "getParams", "()Ljava/lang/String;", "setParams", "(Ljava/lang/String;)V", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class UnsubscribeEndpoint implements Parcelable, Serializable {
    public static final Parcelable.Creator<UnsubscribeEndpoint> CREATOR = new Creator();

    @SerializedName("channelIds")
    private List<String> channelIds;

    @SerializedName(NativeProtocol.WEB_DIALOG_PARAMS)
    private String params;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UnsubscribeEndpoint> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnsubscribeEndpoint createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new UnsubscribeEndpoint();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnsubscribeEndpoint[] newArray(int i) {
            return new UnsubscribeEndpoint[i];
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

    public final List<String> getChannelIds() {
        return this.channelIds;
    }

    public final void setChannelIds(List<String> list) {
        this.channelIds = list;
    }

    public final String getParams() {
        return this.params;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    public String toString() {
        return "UnsubscribeEndpoint{channelIds = '" + this.channelIds + "',params = '" + this.params + "'}";
    }
}
