package com.appnew.android.Model.subscription;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionAllData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b\u0012 \b\u0002\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bHÆ\u0003J!\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0095\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b2 \b\u0002\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R.\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R.\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/appnew/android/Model/subscription/SubscriptionAllData;", "Ljava/io/Serializable;", "subscriptionId", "", "paymentMode", "subscriptionData", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", "Lkotlin/collections/ArrayList;", "subscriptionMeta", "Lcom/appnew/android/Model/subscription/SubscriptionMetaItem;", "id", "isGst", "taxRate", "PlanId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubscriptionId", "()Ljava/lang/String;", "getPaymentMode", "getSubscriptionData", "()Ljava/util/ArrayList;", "getSubscriptionMeta", "getId", "getTaxRate", "getPlanId", "setPlanId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscriptionAllData implements Serializable {
    public static final int $stable = 8;

    @SerializedName("planId")
    private String PlanId;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_gst")
    private final String isGst;

    @SerializedName("payment_mode")
    private final String paymentMode;

    @SerializedName("subscription_data")
    private final ArrayList<SubscriptionDataItem> subscriptionData;

    @SerializedName("subscription_id")
    private final String subscriptionId;

    @SerializedName("subscription_meta")
    private final ArrayList<SubscriptionMetaItem> subscriptionMeta;

    @SerializedName("tax_rate")
    private final String taxRate;

    public SubscriptionAllData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubscriptionAllData copy$default(SubscriptionAllData subscriptionAllData, String str, String str2, ArrayList arrayList, ArrayList arrayList2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionAllData.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = subscriptionAllData.paymentMode;
        }
        if ((i & 4) != 0) {
            arrayList = subscriptionAllData.subscriptionData;
        }
        if ((i & 8) != 0) {
            arrayList2 = subscriptionAllData.subscriptionMeta;
        }
        if ((i & 16) != 0) {
            str3 = subscriptionAllData.id;
        }
        if ((i & 32) != 0) {
            str4 = subscriptionAllData.isGst;
        }
        if ((i & 64) != 0) {
            str5 = subscriptionAllData.taxRate;
        }
        if ((i & 128) != 0) {
            str6 = subscriptionAllData.PlanId;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str3;
        String str10 = str4;
        return subscriptionAllData.copy(str, str2, arrayList, arrayList2, str9, str10, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final ArrayList<SubscriptionDataItem> component3() {
        return this.subscriptionData;
    }

    public final ArrayList<SubscriptionMetaItem> component4() {
        return this.subscriptionMeta;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIsGst() {
        return this.isGst;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTaxRate() {
        return this.taxRate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPlanId() {
        return this.PlanId;
    }

    public final SubscriptionAllData copy(String subscriptionId, String paymentMode, ArrayList<SubscriptionDataItem> subscriptionData, ArrayList<SubscriptionMetaItem> subscriptionMeta, String id, String isGst, String taxRate, String PlanId) {
        return new SubscriptionAllData(subscriptionId, paymentMode, subscriptionData, subscriptionMeta, id, isGst, taxRate, PlanId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionAllData)) {
            return false;
        }
        SubscriptionAllData subscriptionAllData = (SubscriptionAllData) other;
        return Intrinsics.areEqual(this.subscriptionId, subscriptionAllData.subscriptionId) && Intrinsics.areEqual(this.paymentMode, subscriptionAllData.paymentMode) && Intrinsics.areEqual(this.subscriptionData, subscriptionAllData.subscriptionData) && Intrinsics.areEqual(this.subscriptionMeta, subscriptionAllData.subscriptionMeta) && Intrinsics.areEqual(this.id, subscriptionAllData.id) && Intrinsics.areEqual(this.isGst, subscriptionAllData.isGst) && Intrinsics.areEqual(this.taxRate, subscriptionAllData.taxRate) && Intrinsics.areEqual(this.PlanId, subscriptionAllData.PlanId);
    }

    public int hashCode() {
        String str = this.subscriptionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.paymentMode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<SubscriptionDataItem> arrayList = this.subscriptionData;
        int iHashCode3 = (iHashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<SubscriptionMetaItem> arrayList2 = this.subscriptionMeta;
        int iHashCode4 = (iHashCode3 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        String str3 = this.id;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.isGst;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.taxRate;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.PlanId;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionAllData(subscriptionId=" + this.subscriptionId + ", paymentMode=" + this.paymentMode + ", subscriptionData=" + this.subscriptionData + ", subscriptionMeta=" + this.subscriptionMeta + ", id=" + this.id + ", isGst=" + this.isGst + ", taxRate=" + this.taxRate + ", PlanId=" + this.PlanId + ")";
    }

    public SubscriptionAllData(String str, String str2, ArrayList<SubscriptionDataItem> arrayList, ArrayList<SubscriptionMetaItem> arrayList2, String str3, String str4, String str5, String str6) {
        this.subscriptionId = str;
        this.paymentMode = str2;
        this.subscriptionData = arrayList;
        this.subscriptionMeta = arrayList2;
        this.id = str3;
        this.isGst = str4;
        this.taxRate = str5;
        this.PlanId = str6;
    }

    public /* synthetic */ SubscriptionAllData(String str, String str2, ArrayList arrayList, ArrayList arrayList2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : arrayList, (i & 8) != 0 ? null : arrayList2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6);
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final ArrayList<SubscriptionDataItem> getSubscriptionData() {
        return this.subscriptionData;
    }

    public final ArrayList<SubscriptionMetaItem> getSubscriptionMeta() {
        return this.subscriptionMeta;
    }

    public final String getId() {
        return this.id;
    }

    public final String isGst() {
        return this.isGst;
    }

    public final String getTaxRate() {
        return this.taxRate;
    }

    public final String getPlanId() {
        return this.PlanId;
    }

    public final void setPlanId(String str) {
        this.PlanId = str;
    }
}
