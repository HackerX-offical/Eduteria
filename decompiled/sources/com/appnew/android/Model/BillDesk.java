package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentCredentialsResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/Model/BillDesk;", "", "mode", "", "secret", "key", "metaName", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getSecret", "getKey", "getMetaName", "getStatus", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BillDesk {
    public static final int $stable = 0;

    @SerializedName("key")
    private final String key;

    @SerializedName("meta_name")
    private final String metaName;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("secret")
    private final String secret;

    @SerializedName("status")
    private final String status;

    public BillDesk() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BillDesk copy$default(BillDesk billDesk, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billDesk.mode;
        }
        if ((i & 2) != 0) {
            str2 = billDesk.secret;
        }
        if ((i & 4) != 0) {
            str3 = billDesk.key;
        }
        if ((i & 8) != 0) {
            str4 = billDesk.metaName;
        }
        if ((i & 16) != 0) {
            str5 = billDesk.status;
        }
        String str6 = str5;
        String str7 = str3;
        return billDesk.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMetaName() {
        return this.metaName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final BillDesk copy(String mode, String secret, String key, String metaName, String status) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        return new BillDesk(mode, secret, key, metaName, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BillDesk)) {
            return false;
        }
        BillDesk billDesk = (BillDesk) other;
        return Intrinsics.areEqual(this.mode, billDesk.mode) && Intrinsics.areEqual(this.secret, billDesk.secret) && Intrinsics.areEqual(this.key, billDesk.key) && Intrinsics.areEqual(this.metaName, billDesk.metaName) && Intrinsics.areEqual(this.status, billDesk.status);
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secret;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.metaName.hashCode()) * 31;
        String str4 = this.status;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BillDesk(mode=" + this.mode + ", secret=" + this.secret + ", key=" + this.key + ", metaName=" + this.metaName + ", status=" + this.status + ")";
    }

    public BillDesk(String str, String str2, String str3, String metaName, String str4) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        this.mode = str;
        this.secret = str2;
        this.key = str3;
        this.metaName = metaName;
        this.status = str4;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMetaName() {
        return this.metaName;
    }

    public /* synthetic */ BillDesk(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getStatus() {
        return this.status;
    }
}
