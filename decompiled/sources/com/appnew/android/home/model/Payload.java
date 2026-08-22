package com.appnew.android.home.model;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtraVideoType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/home/model/Payload;", "Ljava/io/Serializable;", "tileType", "", "revertApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTileType", "()Ljava/lang/String;", "setTileType", "(Ljava/lang/String;)V", "getRevertApi", "setRevertApi", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Payload implements Serializable {
    public static final int $stable = 8;

    @SerializedName(Const.REVERT_API)
    private String revertApi;

    @SerializedName(Const.TILE_TYPE)
    private String tileType;

    /* JADX WARN: Multi-variable type inference failed */
    public Payload() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Payload copy$default(Payload payload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payload.tileType;
        }
        if ((i & 2) != 0) {
            str2 = payload.revertApi;
        }
        return payload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTileType() {
        return this.tileType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRevertApi() {
        return this.revertApi;
    }

    public final Payload copy(String tileType, String revertApi) {
        return new Payload(tileType, revertApi);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) other;
        return Intrinsics.areEqual(this.tileType, payload.tileType) && Intrinsics.areEqual(this.revertApi, payload.revertApi);
    }

    public int hashCode() {
        String str = this.tileType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.revertApi;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Payload(tileType=" + this.tileType + ", revertApi=" + this.revertApi + ")";
    }

    public Payload(String str, String str2) {
        this.tileType = str;
        this.revertApi = str2;
    }

    public /* synthetic */ Payload(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getTileType() {
        return this.tileType;
    }

    public final void setTileType(String str) {
        this.tileType = str;
    }

    public final String getRevertApi() {
        return this.revertApi;
    }

    public final void setRevertApi(String str) {
        this.revertApi = str;
    }
}
