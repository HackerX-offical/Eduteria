package com.appnew.android.Model.TeacherTimeTable;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Model/TeacherTimeTable/Data;", "", "batchId", "", "batchTimetable", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", "Lkotlin/collections/ArrayList;", "title", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getBatchId", "()Ljava/lang/String;", "setBatchId", "(Ljava/lang/String;)V", "getBatchTimetable", "()Ljava/util/ArrayList;", "setBatchTimetable", "(Ljava/util/ArrayList;)V", "getTitle", "setTitle", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName(Const.BATCH_ID)
    private String batchId;

    @SerializedName("batch_timetable")
    private ArrayList<BatchTimetable> batchTimetable;

    @SerializedName("title")
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, String str, ArrayList arrayList, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.batchId;
        }
        if ((i & 2) != 0) {
            arrayList = data.batchTimetable;
        }
        if ((i & 4) != 0) {
            str2 = data.title;
        }
        return data.copy(str, arrayList, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    public final ArrayList<BatchTimetable> component2() {
        return this.batchTimetable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final Data copy(String batchId, ArrayList<BatchTimetable> batchTimetable, String title) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(batchTimetable, "batchTimetable");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Data(batchId, batchTimetable, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.batchId, data.batchId) && Intrinsics.areEqual(this.batchTimetable, data.batchTimetable) && Intrinsics.areEqual(this.title, data.title);
    }

    public int hashCode() {
        return (((this.batchId.hashCode() * 31) + this.batchTimetable.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "Data(batchId=" + this.batchId + ", batchTimetable=" + this.batchTimetable + ", title=" + this.title + ")";
    }

    public Data(String batchId, ArrayList<BatchTimetable> batchTimetable, String title) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(batchTimetable, "batchTimetable");
        Intrinsics.checkNotNullParameter(title, "title");
        this.batchId = batchId;
        this.batchTimetable = batchTimetable;
        this.title = title;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final void setBatchId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batchId = str;
    }

    public final ArrayList<BatchTimetable> getBatchTimetable() {
        return this.batchTimetable;
    }

    public final void setBatchTimetable(ArrayList<BatchTimetable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.batchTimetable = arrayList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
