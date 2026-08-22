package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: compiled from: Installment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Model/Courses/Installment;", "Ljava/io/Serializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "count", "getCount", "setCount", "cycle", "getCycle", "setCycle", "amountDescription", "Lcom/appnew/android/Model/Courses/AmountDescription;", "getAmountDescription", "()Lcom/appnew/android/Model/Courses/AmountDescription;", "setAmountDescription", "(Lcom/appnew/android/Model/Courses/AmountDescription;)V", "isSetExpanded", "", "()Z", "setSetExpanded", "(Z)V", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Installment implements Serializable {
    private static final long serialVersionUID = -4040590433175755945L;

    @SerializedName("amount_description")
    @Expose
    private AmountDescription amountDescription;

    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("cycle")
    @Expose
    private String cycle;

    @SerializedName("id")
    @Expose
    private String id;
    private boolean isSetExpanded;

    @SerializedName("name")
    @Expose
    private String name;
    public static final int $stable = 8;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getCount() {
        return this.count;
    }

    public final void setCount(String str) {
        this.count = str;
    }

    public final String getCycle() {
        return this.cycle;
    }

    public final void setCycle(String str) {
        this.cycle = str;
    }

    public final AmountDescription getAmountDescription() {
        return this.amountDescription;
    }

    public final void setAmountDescription(AmountDescription amountDescription) {
        this.amountDescription = amountDescription;
    }

    /* JADX INFO: renamed from: isSetExpanded, reason: from getter */
    public final boolean getIsSetExpanded() {
        return this.isSetExpanded;
    }

    public final void setSetExpanded(boolean z) {
        this.isSetExpanded = z;
    }
}
