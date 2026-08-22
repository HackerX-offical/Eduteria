package com.appnew.android.Model.subscription;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionAllData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", "Ljava/io/Serializable;", "planTitle", "", "id", "recurring_amount", "description", "short_description", "plan_type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlanTitle", "()Ljava/lang/String;", "getId", "getRecurring_amount", "getDescription", "getShort_description", "getPlan_type", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscriptionDataItem implements Serializable {
    public static final int $stable = 0;

    @SerializedName("description")
    private final String description;

    @SerializedName("id")
    private final String id;

    @SerializedName("plan_title")
    private final String planTitle;

    @SerializedName("plan_type")
    private final String plan_type;

    @SerializedName("recurring_amount")
    private final String recurring_amount;

    @SerializedName("short_description")
    private final String short_description;

    public SubscriptionDataItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SubscriptionDataItem copy$default(SubscriptionDataItem subscriptionDataItem, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionDataItem.planTitle;
        }
        if ((i & 2) != 0) {
            str2 = subscriptionDataItem.id;
        }
        if ((i & 4) != 0) {
            str3 = subscriptionDataItem.recurring_amount;
        }
        if ((i & 8) != 0) {
            str4 = subscriptionDataItem.description;
        }
        if ((i & 16) != 0) {
            str5 = subscriptionDataItem.short_description;
        }
        if ((i & 32) != 0) {
            str6 = subscriptionDataItem.plan_type;
        }
        String str7 = str5;
        String str8 = str6;
        return subscriptionDataItem.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlanTitle() {
        return this.planTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRecurring_amount() {
        return this.recurring_amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getShort_description() {
        return this.short_description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPlan_type() {
        return this.plan_type;
    }

    public final SubscriptionDataItem copy(String planTitle, String id, String recurring_amount, String description, String short_description, String plan_type) {
        return new SubscriptionDataItem(planTitle, id, recurring_amount, description, short_description, plan_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionDataItem)) {
            return false;
        }
        SubscriptionDataItem subscriptionDataItem = (SubscriptionDataItem) other;
        return Intrinsics.areEqual(this.planTitle, subscriptionDataItem.planTitle) && Intrinsics.areEqual(this.id, subscriptionDataItem.id) && Intrinsics.areEqual(this.recurring_amount, subscriptionDataItem.recurring_amount) && Intrinsics.areEqual(this.description, subscriptionDataItem.description) && Intrinsics.areEqual(this.short_description, subscriptionDataItem.short_description) && Intrinsics.areEqual(this.plan_type, subscriptionDataItem.plan_type);
    }

    public int hashCode() {
        String str = this.planTitle;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.recurring_amount;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.short_description;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.plan_type;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionDataItem(planTitle=" + this.planTitle + ", id=" + this.id + ", recurring_amount=" + this.recurring_amount + ", description=" + this.description + ", short_description=" + this.short_description + ", plan_type=" + this.plan_type + ")";
    }

    public SubscriptionDataItem(String str, String str2, String str3, String str4, String str5, String str6) {
        this.planTitle = str;
        this.id = str2;
        this.recurring_amount = str3;
        this.description = str4;
        this.short_description = str5;
        this.plan_type = str6;
    }

    public /* synthetic */ SubscriptionDataItem(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getPlanTitle() {
        return this.planTitle;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRecurring_amount() {
        return this.recurring_amount;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getShort_description() {
        return this.short_description;
    }

    public final String getPlan_type() {
        return this.plan_type;
    }
}
