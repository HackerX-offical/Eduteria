package com.appnew.android.Model;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentCredentialsResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006$"}, d2 = {"Lcom/appnew/android/Model/Rzp;", "", "mode", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "metaName", "isSplit", "discount", "secret", "key", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getAccountId", "getMetaName", "getDiscount", "getSecret", "getKey", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Rzp {
    public static final int $stable = 0;

    @SerializedName("account_id")
    private final String accountId;

    @SerializedName("discount")
    private final String discount;

    @SerializedName("is_split")
    private final String isSplit;

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

    public Rzp() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ Rzp copy$default(Rzp rzp, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rzp.mode;
        }
        if ((i & 2) != 0) {
            str2 = rzp.accountId;
        }
        if ((i & 4) != 0) {
            str3 = rzp.metaName;
        }
        if ((i & 8) != 0) {
            str4 = rzp.isSplit;
        }
        if ((i & 16) != 0) {
            str5 = rzp.discount;
        }
        if ((i & 32) != 0) {
            str6 = rzp.secret;
        }
        if ((i & 64) != 0) {
            str7 = rzp.key;
        }
        if ((i & 128) != 0) {
            str8 = rzp.status;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return rzp.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMetaName() {
        return this.metaName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIsSplit() {
        return this.isSplit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final Rzp copy(String mode, String accountId, String metaName, String isSplit, String discount, String secret, String key, String status) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        return new Rzp(mode, accountId, metaName, isSplit, discount, secret, key, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rzp)) {
            return false;
        }
        Rzp rzp = (Rzp) other;
        return Intrinsics.areEqual(this.mode, rzp.mode) && Intrinsics.areEqual(this.accountId, rzp.accountId) && Intrinsics.areEqual(this.metaName, rzp.metaName) && Intrinsics.areEqual(this.isSplit, rzp.isSplit) && Intrinsics.areEqual(this.discount, rzp.discount) && Intrinsics.areEqual(this.secret, rzp.secret) && Intrinsics.areEqual(this.key, rzp.key) && Intrinsics.areEqual(this.status, rzp.status);
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accountId;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.metaName.hashCode()) * 31;
        String str3 = this.isSplit;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.discount;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.secret;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.key;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.status;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "Rzp(mode=" + this.mode + ", accountId=" + this.accountId + ", metaName=" + this.metaName + ", isSplit=" + this.isSplit + ", discount=" + this.discount + ", secret=" + this.secret + ", key=" + this.key + ", status=" + this.status + ")";
    }

    public Rzp(String str, String str2, String metaName, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        this.mode = str;
        this.accountId = str2;
        this.metaName = metaName;
        this.isSplit = str3;
        this.discount = str4;
        this.secret = str5;
        this.key = str6;
        this.status = str7;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getMetaName() {
        return this.metaName;
    }

    public /* synthetic */ Rzp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8);
    }

    public final String isSplit() {
        return this.isSplit;
    }

    public final String getDiscount() {
        return this.discount;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getStatus() {
        return this.status;
    }
}
