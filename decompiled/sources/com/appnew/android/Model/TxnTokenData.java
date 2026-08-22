package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.db.Column;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.tv9news.utils.helpers.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TxnTokenData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006:"}, d2 = {"Lcom/appnew/android/Model/TxnTokenData;", "", "id", "", "entity", Column.CREATED_AT, "close_by", "name", "usage", "type", "image_url", AnalyticsConstants.payment_amount, "status", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getEntity", "setEntity", "getCreated_at", "setCreated_at", "getClose_by", "setClose_by", "getName", "setName", "getUsage", "setUsage", "getType", "setType", "getImage_url", "setImage_url", "getPayment_amount", "setPayment_amount", "getStatus", "setStatus", "getDescription", "setDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TxnTokenData {
    public static final int $stable = 8;
    private String close_by;
    private String created_at;
    private String description;
    private String entity;
    private String id;
    private String image_url;
    private String name;
    private String payment_amount;
    private String status;
    private String type;
    private String usage;

    public TxnTokenData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ TxnTokenData copy$default(TxnTokenData txnTokenData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = txnTokenData.id;
        }
        if ((i & 2) != 0) {
            str2 = txnTokenData.entity;
        }
        if ((i & 4) != 0) {
            str3 = txnTokenData.created_at;
        }
        if ((i & 8) != 0) {
            str4 = txnTokenData.close_by;
        }
        if ((i & 16) != 0) {
            str5 = txnTokenData.name;
        }
        if ((i & 32) != 0) {
            str6 = txnTokenData.usage;
        }
        if ((i & 64) != 0) {
            str7 = txnTokenData.type;
        }
        if ((i & 128) != 0) {
            str8 = txnTokenData.image_url;
        }
        if ((i & 256) != 0) {
            str9 = txnTokenData.payment_amount;
        }
        if ((i & 512) != 0) {
            str10 = txnTokenData.status;
        }
        if ((i & 1024) != 0) {
            str11 = txnTokenData.description;
        }
        String str12 = str10;
        String str13 = str11;
        String str14 = str8;
        String str15 = str9;
        String str16 = str6;
        String str17 = str7;
        String str18 = str5;
        String str19 = str3;
        return txnTokenData.copy(str, str2, str19, str4, str18, str16, str17, str14, str15, str12, str13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEntity() {
        return this.entity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClose_by() {
        return this.close_by;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUsage() {
        return this.usage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getImage_url() {
        return this.image_url;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPayment_amount() {
        return this.payment_amount;
    }

    public final TxnTokenData copy(String id, String entity, String created_at, String close_by, String name, String usage, String type, String image_url, String payment_amount, String status, String description) {
        return new TxnTokenData(id, entity, created_at, close_by, name, usage, type, image_url, payment_amount, status, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TxnTokenData)) {
            return false;
        }
        TxnTokenData txnTokenData = (TxnTokenData) other;
        return Intrinsics.areEqual(this.id, txnTokenData.id) && Intrinsics.areEqual(this.entity, txnTokenData.entity) && Intrinsics.areEqual(this.created_at, txnTokenData.created_at) && Intrinsics.areEqual(this.close_by, txnTokenData.close_by) && Intrinsics.areEqual(this.name, txnTokenData.name) && Intrinsics.areEqual(this.usage, txnTokenData.usage) && Intrinsics.areEqual(this.type, txnTokenData.type) && Intrinsics.areEqual(this.image_url, txnTokenData.image_url) && Intrinsics.areEqual(this.payment_amount, txnTokenData.payment_amount) && Intrinsics.areEqual(this.status, txnTokenData.status) && Intrinsics.areEqual(this.description, txnTokenData.description);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.entity;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.created_at;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.close_by;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.usage;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.type;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.image_url;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.payment_amount;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.status;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.description;
        return iHashCode10 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        return "TxnTokenData(id=" + this.id + ", entity=" + this.entity + ", created_at=" + this.created_at + ", close_by=" + this.close_by + ", name=" + this.name + ", usage=" + this.usage + ", type=" + this.type + ", image_url=" + this.image_url + ", payment_amount=" + this.payment_amount + ", status=" + this.status + ", description=" + this.description + ")";
    }

    public TxnTokenData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.id = str;
        this.entity = str2;
        this.created_at = str3;
        this.close_by = str4;
        this.name = str5;
        this.usage = str6;
        this.type = str7;
        this.image_url = str8;
        this.payment_amount = str9;
        this.status = str10;
        this.description = str11;
    }

    public /* synthetic */ TxnTokenData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getEntity() {
        return this.entity;
    }

    public final void setEntity(String str) {
        this.entity = str;
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final void setCreated_at(String str) {
        this.created_at = str;
    }

    public final String getClose_by() {
        return this.close_by;
    }

    public final void setClose_by(String str) {
        this.close_by = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getUsage() {
        return this.usage;
    }

    public final void setUsage(String str) {
        this.usage = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final void setImage_url(String str) {
        this.image_url = str;
    }

    public final String getPayment_amount() {
        return this.payment_amount;
    }

    public final void setPayment_amount(String str) {
        this.payment_amount = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }
}
