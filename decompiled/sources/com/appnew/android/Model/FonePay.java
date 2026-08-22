package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentCredentialsResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Model/FonePay;", "", "mode", "", "secret", "key", "url", "metaName", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getSecret", "getKey", "getUrl", "getMetaName", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FonePay {
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

    @SerializedName("url")
    private final String url;

    public FonePay() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FonePay copy$default(FonePay fonePay, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fonePay.mode;
        }
        if ((i & 2) != 0) {
            str2 = fonePay.secret;
        }
        if ((i & 4) != 0) {
            str3 = fonePay.key;
        }
        if ((i & 8) != 0) {
            str4 = fonePay.url;
        }
        if ((i & 16) != 0) {
            str5 = fonePay.metaName;
        }
        if ((i & 32) != 0) {
            str6 = fonePay.status;
        }
        String str7 = str5;
        String str8 = str6;
        return fonePay.copy(str, str2, str3, str4, str7, str8);
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
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMetaName() {
        return this.metaName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final FonePay copy(String mode, String secret, String key, String url, String metaName, String status) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        return new FonePay(mode, secret, key, url, metaName, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FonePay)) {
            return false;
        }
        FonePay fonePay = (FonePay) other;
        return Intrinsics.areEqual(this.mode, fonePay.mode) && Intrinsics.areEqual(this.secret, fonePay.secret) && Intrinsics.areEqual(this.key, fonePay.key) && Intrinsics.areEqual(this.url, fonePay.url) && Intrinsics.areEqual(this.metaName, fonePay.metaName) && Intrinsics.areEqual(this.status, fonePay.status);
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secret;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.url;
        int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.metaName.hashCode()) * 31;
        String str5 = this.status;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "FonePay(mode=" + this.mode + ", secret=" + this.secret + ", key=" + this.key + ", url=" + this.url + ", metaName=" + this.metaName + ", status=" + this.status + ")";
    }

    public FonePay(String str, String str2, String str3, String str4, String metaName, String str5) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        this.mode = str;
        this.secret = str2;
        this.key = str3;
        this.url = str4;
        this.metaName = metaName;
        this.status = str5;
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

    public final String getUrl() {
        return this.url;
    }

    public final String getMetaName() {
        return this.metaName;
    }

    public /* synthetic */ FonePay(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getStatus() {
        return this.status;
    }
}
