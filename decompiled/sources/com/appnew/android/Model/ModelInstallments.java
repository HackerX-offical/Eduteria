package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModelInstallments.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Model/ModelInstallments;", "Ljava/io/Serializable;", "status", "", "message", "time", "", "emi", "", "Lcom/appnew/android/Model/Emi;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getMessage", "getTime", "()J", "getEmi", "()Ljava/util/List;", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ModelInstallments implements Serializable {
    public static final int $stable = 8;

    @SerializedName("data")
    private final List<Emi> emi;

    @SerializedName("message")
    private final String message;

    @SerializedName("status")
    private final String status;

    @SerializedName("time")
    private final long time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelInstallments copy$default(ModelInstallments modelInstallments, String str, String str2, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelInstallments.status;
        }
        if ((i & 2) != 0) {
            str2 = modelInstallments.message;
        }
        if ((i & 4) != 0) {
            j = modelInstallments.time;
        }
        if ((i & 8) != 0) {
            list = modelInstallments.emi;
        }
        List list2 = list;
        return modelInstallments.copy(str, str2, j, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final List<Emi> component4() {
        return this.emi;
    }

    public final ModelInstallments copy(String status, String message, long time, List<Emi> emi) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emi, "emi");
        return new ModelInstallments(status, message, time, emi);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInstallments)) {
            return false;
        }
        ModelInstallments modelInstallments = (ModelInstallments) other;
        return Intrinsics.areEqual(this.status, modelInstallments.status) && Intrinsics.areEqual(this.message, modelInstallments.message) && this.time == modelInstallments.time && Intrinsics.areEqual(this.emi, modelInstallments.emi);
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + this.emi.hashCode();
    }

    public String toString() {
        return "ModelInstallments(status=" + this.status + ", message=" + this.message + ", time=" + this.time + ", emi=" + this.emi + ")";
    }

    public ModelInstallments(String status, String message, long j, List<Emi> emi) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emi, "emi");
        this.status = status;
        this.message = message;
        this.time = j;
        this.emi = emi;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getTime() {
        return this.time;
    }

    public final List<Emi> getEmi() {
        return this.emi;
    }
}
