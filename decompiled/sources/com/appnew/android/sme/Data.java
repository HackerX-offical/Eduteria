package com.appnew.android.sme;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StudentDoubtListModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/sme/Data;", "", "doubts", "", "Lcom/appnew/android/sme/Doubt;", "id", "", "studentId", "subjectName", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDoubts", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getStudentId", "getSubjectName", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName("doubts")
    private final List<Doubt> doubts;

    @SerializedName("id")
    private final String id;

    @SerializedName("student_id")
    private final String studentId;

    @SerializedName("subject_name")
    private final String subjectName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = data.doubts;
        }
        if ((i & 2) != 0) {
            str = data.id;
        }
        if ((i & 4) != 0) {
            str2 = data.studentId;
        }
        if ((i & 8) != 0) {
            str3 = data.subjectName;
        }
        return data.copy(list, str, str2, str3);
    }

    public final List<Doubt> component1() {
        return this.doubts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    public final Data copy(List<Doubt> doubts, String id, String studentId, String subjectName) {
        Intrinsics.checkNotNullParameter(doubts, "doubts");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        return new Data(doubts, id, studentId, subjectName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.doubts, data.doubts) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.studentId, data.studentId) && Intrinsics.areEqual(this.subjectName, data.subjectName);
    }

    public int hashCode() {
        return (((((this.doubts.hashCode() * 31) + this.id.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.subjectName.hashCode();
    }

    public String toString() {
        return "Data(doubts=" + this.doubts + ", id=" + this.id + ", studentId=" + this.studentId + ", subjectName=" + this.subjectName + ")";
    }

    public Data(List<Doubt> doubts, String id, String studentId, String subjectName) {
        Intrinsics.checkNotNullParameter(doubts, "doubts");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.doubts = doubts;
        this.id = id;
        this.studentId = studentId;
        this.subjectName = subjectName;
    }

    public final List<Doubt> getDoubts() {
        return this.doubts;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }
}
