package com.appnew.android.Model.subscription;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionAllData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006)"}, d2 = {"Lcom/appnew/android/Model/subscription/SubscriptionMetaItem;", "Ljava/io/Serializable;", "subscriptionId", "", TypedValues.TransitionType.S_DURATION, "planTitle", FirebaseAnalytics.Param.PRICE, "validityMy", "plateformsName", "plateforms", "tax", "delivery_charge_subscription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubscriptionId", "()Ljava/lang/String;", "getDuration", "getPlanTitle", "getPrice", "getValidityMy", "getPlateformsName", "getPlateforms", "getTax", "getDelivery_charge_subscription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscriptionMetaItem implements Serializable {
    public static final int $stable = 0;

    @SerializedName("delivery_charge_subscription")
    private final String delivery_charge_subscription;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    private final String duration;

    @SerializedName("plan_title")
    private final String planTitle;

    @SerializedName("plateforms")
    private final String plateforms;

    @SerializedName("plateforms_name")
    private final String plateformsName;

    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final String price;

    @SerializedName("subscription_id")
    private final String subscriptionId;

    @SerializedName("tax")
    private final String tax;

    @SerializedName("validity_my")
    private final String validityMy;

    public SubscriptionMetaItem() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ SubscriptionMetaItem copy$default(SubscriptionMetaItem subscriptionMetaItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionMetaItem.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = subscriptionMetaItem.duration;
        }
        if ((i & 4) != 0) {
            str3 = subscriptionMetaItem.planTitle;
        }
        if ((i & 8) != 0) {
            str4 = subscriptionMetaItem.price;
        }
        if ((i & 16) != 0) {
            str5 = subscriptionMetaItem.validityMy;
        }
        if ((i & 32) != 0) {
            str6 = subscriptionMetaItem.plateformsName;
        }
        if ((i & 64) != 0) {
            str7 = subscriptionMetaItem.plateforms;
        }
        if ((i & 128) != 0) {
            str8 = subscriptionMetaItem.tax;
        }
        if ((i & 256) != 0) {
            str9 = subscriptionMetaItem.delivery_charge_subscription;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return subscriptionMetaItem.copy(str, str2, str15, str4, str14, str12, str13, str10, str11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlanTitle() {
        return this.planTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getValidityMy() {
        return this.validityMy;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPlateformsName() {
        return this.plateformsName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPlateforms() {
        return this.plateforms;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTax() {
        return this.tax;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDelivery_charge_subscription() {
        return this.delivery_charge_subscription;
    }

    public final SubscriptionMetaItem copy(String subscriptionId, String duration, String planTitle, String price, String validityMy, String plateformsName, String plateforms, String tax, String delivery_charge_subscription) {
        return new SubscriptionMetaItem(subscriptionId, duration, planTitle, price, validityMy, plateformsName, plateforms, tax, delivery_charge_subscription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionMetaItem)) {
            return false;
        }
        SubscriptionMetaItem subscriptionMetaItem = (SubscriptionMetaItem) other;
        return Intrinsics.areEqual(this.subscriptionId, subscriptionMetaItem.subscriptionId) && Intrinsics.areEqual(this.duration, subscriptionMetaItem.duration) && Intrinsics.areEqual(this.planTitle, subscriptionMetaItem.planTitle) && Intrinsics.areEqual(this.price, subscriptionMetaItem.price) && Intrinsics.areEqual(this.validityMy, subscriptionMetaItem.validityMy) && Intrinsics.areEqual(this.plateformsName, subscriptionMetaItem.plateformsName) && Intrinsics.areEqual(this.plateforms, subscriptionMetaItem.plateforms) && Intrinsics.areEqual(this.tax, subscriptionMetaItem.tax) && Intrinsics.areEqual(this.delivery_charge_subscription, subscriptionMetaItem.delivery_charge_subscription);
    }

    public int hashCode() {
        String str = this.subscriptionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.planTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.price;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.validityMy;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.plateformsName;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.plateforms;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tax;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.delivery_charge_subscription;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionMetaItem(subscriptionId=" + this.subscriptionId + ", duration=" + this.duration + ", planTitle=" + this.planTitle + ", price=" + this.price + ", validityMy=" + this.validityMy + ", plateformsName=" + this.plateformsName + ", plateforms=" + this.plateforms + ", tax=" + this.tax + ", delivery_charge_subscription=" + this.delivery_charge_subscription + ")";
    }

    public SubscriptionMetaItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.subscriptionId = str;
        this.duration = str2;
        this.planTitle = str3;
        this.price = str4;
        this.validityMy = str5;
        this.plateformsName = str6;
        this.plateforms = str7;
        this.tax = str8;
        this.delivery_charge_subscription = str9;
    }

    public /* synthetic */ SubscriptionMetaItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9);
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getPlanTitle() {
        return this.planTitle;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getValidityMy() {
        return this.validityMy;
    }

    public final String getPlateformsName() {
        return this.plateformsName;
    }

    public final String getPlateforms() {
        return this.plateforms;
    }

    public final String getTax() {
        return this.tax;
    }

    public final String getDelivery_charge_subscription() {
        return this.delivery_charge_subscription;
    }
}
