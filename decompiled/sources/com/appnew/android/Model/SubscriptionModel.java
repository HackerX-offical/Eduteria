package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\fHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006'"}, d2 = {"Lcom/appnew/android/Model/SubscriptionModel;", "Ljava/io/Serializable;", "status", "", "message", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/SubscriptionData;", "Lkotlin/collections/ArrayList;", "time", "", "interval", "", "cd_time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;JIJ)V", "getStatus", "()Ljava/lang/String;", "getMessage", "getData", "()Ljava/util/ArrayList;", "getTime", "()J", "getInterval", "()I", "getCd_time", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscriptionModel implements Serializable {
    public static final int $stable = 8;

    @SerializedName("cd_time")
    private final long cd_time;

    @SerializedName("data")
    private final ArrayList<SubscriptionData> data;

    @SerializedName("interval")
    private final int interval;

    @SerializedName("message")
    private final String message;

    @SerializedName("status")
    private final String status;

    @SerializedName("time")
    private final long time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubscriptionModel copy$default(SubscriptionModel subscriptionModel, String str, String str2, ArrayList arrayList, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subscriptionModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = subscriptionModel.message;
        }
        if ((i2 & 4) != 0) {
            arrayList = subscriptionModel.data;
        }
        if ((i2 & 8) != 0) {
            j = subscriptionModel.time;
        }
        if ((i2 & 16) != 0) {
            i = subscriptionModel.interval;
        }
        if ((i2 & 32) != 0) {
            j2 = subscriptionModel.cd_time;
        }
        int i3 = i;
        long j3 = j;
        ArrayList arrayList2 = arrayList;
        return subscriptionModel.copy(str, str2, arrayList2, j3, i3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<SubscriptionData> component3() {
        return this.data;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getCd_time() {
        return this.cd_time;
    }

    public final SubscriptionModel copy(String status, String message, ArrayList<SubscriptionData> data, long time, int interval, long cd_time) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        return new SubscriptionModel(status, message, data, time, interval, cd_time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionModel)) {
            return false;
        }
        SubscriptionModel subscriptionModel = (SubscriptionModel) other;
        return Intrinsics.areEqual(this.status, subscriptionModel.status) && Intrinsics.areEqual(this.message, subscriptionModel.message) && Intrinsics.areEqual(this.data, subscriptionModel.data) && this.time == subscriptionModel.time && this.interval == subscriptionModel.interval && this.cd_time == subscriptionModel.cd_time;
    }

    public int hashCode() {
        return (((((((((this.status.hashCode() * 31) + this.message.hashCode()) * 31) + this.data.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.interval)) * 31) + Long.hashCode(this.cd_time);
    }

    public String toString() {
        return "SubscriptionModel(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ", time=" + this.time + ", interval=" + this.interval + ", cd_time=" + this.cd_time + ")";
    }

    public SubscriptionModel(String status, String message, ArrayList<SubscriptionData> data, long j, int i, long j2) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = j;
        this.interval = i;
        this.cd_time = j2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<SubscriptionData> getData() {
        return this.data;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final long getCd_time() {
        return this.cd_time;
    }
}
