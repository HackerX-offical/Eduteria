package com.appnew.android.Model.StudentModel;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Model/StudentModel/Data;", "", "batchId", "", "name", "batchName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBatchId", "()Ljava/lang/String;", "setBatchId", "(Ljava/lang/String;)V", "getName", "setName", "getBatchName", "setBatchName", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName(Const.BATCH_ID)
    private String batchId;

    @SerializedName("batch_name")
    private String batchName;

    @SerializedName("name")
    private String name;

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.batchId;
        }
        if ((i & 2) != 0) {
            str2 = data.name;
        }
        if ((i & 4) != 0) {
            str3 = data.batchName;
        }
        return data.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBatchName() {
        return this.batchName;
    }

    public final Data copy(String batchId, String name, String batchName) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(batchName, "batchName");
        return new Data(batchId, name, batchName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.batchId, data.batchId) && Intrinsics.areEqual(this.name, data.name) && Intrinsics.areEqual(this.batchName, data.batchName);
    }

    public int hashCode() {
        return (((this.batchId.hashCode() * 31) + this.name.hashCode()) * 31) + this.batchName.hashCode();
    }

    public String toString() {
        return "Data(batchId=" + this.batchId + ", name=" + this.name + ", batchName=" + this.batchName + ")";
    }

    public Data(String batchId, String name, String batchName) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(batchName, "batchName");
        this.batchId = batchId;
        this.name = name;
        this.batchName = batchName;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final void setBatchId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getBatchName() {
        return this.batchName;
    }

    public final void setBatchName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchName = str;
    }
}
