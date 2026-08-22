package com.appnew.android.Model;

import androidx.core.app.FrameMetricsAggregator;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentCredentialsResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Js\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/appnew/android/Model/Ccav;", "", "mode", "", "secret", "key", "url", "metaName", "status", "cancel_url", "redirect_url", "android_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getSecret", "getKey", "getUrl", "getMetaName", "getStatus", "getCancel_url", "getRedirect_url", "getAndroid_url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Ccav {
    public static final int $stable = 0;

    @SerializedName("android_url")
    private final String android_url;

    @SerializedName("cancel_url")
    private final String cancel_url;

    @SerializedName("key")
    private final String key;

    @SerializedName("meta_name")
    private final String metaName;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("redirect_url")
    private final String redirect_url;

    @SerializedName("secret")
    private final String secret;

    @SerializedName("status")
    private final String status;

    @SerializedName("url")
    private final String url;

    public Ccav() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ Ccav copy$default(Ccav ccav, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ccav.mode;
        }
        if ((i & 2) != 0) {
            str2 = ccav.secret;
        }
        if ((i & 4) != 0) {
            str3 = ccav.key;
        }
        if ((i & 8) != 0) {
            str4 = ccav.url;
        }
        if ((i & 16) != 0) {
            str5 = ccav.metaName;
        }
        if ((i & 32) != 0) {
            str6 = ccav.status;
        }
        if ((i & 64) != 0) {
            str7 = ccav.cancel_url;
        }
        if ((i & 128) != 0) {
            str8 = ccav.redirect_url;
        }
        if ((i & 256) != 0) {
            str9 = ccav.android_url;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return ccav.copy(str, str2, str15, str4, str14, str12, str13, str10, str11);
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

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCancel_url() {
        return this.cancel_url;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRedirect_url() {
        return this.redirect_url;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAndroid_url() {
        return this.android_url;
    }

    public final Ccav copy(String mode, String secret, String key, String url, String metaName, String status, String cancel_url, String redirect_url, String android_url) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        return new Ccav(mode, secret, key, url, metaName, status, cancel_url, redirect_url, android_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ccav)) {
            return false;
        }
        Ccav ccav = (Ccav) other;
        return Intrinsics.areEqual(this.mode, ccav.mode) && Intrinsics.areEqual(this.secret, ccav.secret) && Intrinsics.areEqual(this.key, ccav.key) && Intrinsics.areEqual(this.url, ccav.url) && Intrinsics.areEqual(this.metaName, ccav.metaName) && Intrinsics.areEqual(this.status, ccav.status) && Intrinsics.areEqual(this.cancel_url, ccav.cancel_url) && Intrinsics.areEqual(this.redirect_url, ccav.redirect_url) && Intrinsics.areEqual(this.android_url, ccav.android_url);
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
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cancel_url;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.redirect_url;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.android_url;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "Ccav(mode=" + this.mode + ", secret=" + this.secret + ", key=" + this.key + ", url=" + this.url + ", metaName=" + this.metaName + ", status=" + this.status + ", cancel_url=" + this.cancel_url + ", redirect_url=" + this.redirect_url + ", android_url=" + this.android_url + ")";
    }

    public Ccav(String str, String str2, String str3, String str4, String metaName, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        this.mode = str;
        this.secret = str2;
        this.key = str3;
        this.url = str4;
        this.metaName = metaName;
        this.status = str5;
        this.cancel_url = str6;
        this.redirect_url = str7;
        this.android_url = str8;
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

    public /* synthetic */ Ccav(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getCancel_url() {
        return this.cancel_url;
    }

    public final String getRedirect_url() {
        return this.redirect_url;
    }

    public final String getAndroid_url() {
        return this.android_url;
    }
}
