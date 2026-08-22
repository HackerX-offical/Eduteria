package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Topper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/Model/ExpectedRank;", "Ljava/io/Serializable;", "percentile", "", "rank", "hide", "increase_marks", "notes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPercentile", "()Ljava/lang/String;", "getRank", "getHide", "getIncrease_marks", "getNotes", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExpectedRank implements Serializable {
    public static final int $stable = 0;

    @SerializedName("hide")
    private final String hide;

    @SerializedName("increase_marks")
    private final String increase_marks;

    @SerializedName("notes")
    private final String notes;

    @SerializedName("percentile")
    private final String percentile;

    @SerializedName("rank")
    private final String rank;

    public static /* synthetic */ ExpectedRank copy$default(ExpectedRank expectedRank, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expectedRank.percentile;
        }
        if ((i & 2) != 0) {
            str2 = expectedRank.rank;
        }
        if ((i & 4) != 0) {
            str3 = expectedRank.hide;
        }
        if ((i & 8) != 0) {
            str4 = expectedRank.increase_marks;
        }
        if ((i & 16) != 0) {
            str5 = expectedRank.notes;
        }
        String str6 = str5;
        String str7 = str3;
        return expectedRank.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPercentile() {
        return this.percentile;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRank() {
        return this.rank;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHide() {
        return this.hide;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIncrease_marks() {
        return this.increase_marks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    public final ExpectedRank copy(String percentile, String rank, String hide, String increase_marks, String notes) {
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(hide, "hide");
        Intrinsics.checkNotNullParameter(increase_marks, "increase_marks");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new ExpectedRank(percentile, rank, hide, increase_marks, notes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpectedRank)) {
            return false;
        }
        ExpectedRank expectedRank = (ExpectedRank) other;
        return Intrinsics.areEqual(this.percentile, expectedRank.percentile) && Intrinsics.areEqual(this.rank, expectedRank.rank) && Intrinsics.areEqual(this.hide, expectedRank.hide) && Intrinsics.areEqual(this.increase_marks, expectedRank.increase_marks) && Intrinsics.areEqual(this.notes, expectedRank.notes);
    }

    public int hashCode() {
        return (((((((this.percentile.hashCode() * 31) + this.rank.hashCode()) * 31) + this.hide.hashCode()) * 31) + this.increase_marks.hashCode()) * 31) + this.notes.hashCode();
    }

    public String toString() {
        return "ExpectedRank(percentile=" + this.percentile + ", rank=" + this.rank + ", hide=" + this.hide + ", increase_marks=" + this.increase_marks + ", notes=" + this.notes + ")";
    }

    public ExpectedRank(String percentile, String rank, String hide, String increase_marks, String notes) {
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(hide, "hide");
        Intrinsics.checkNotNullParameter(increase_marks, "increase_marks");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.percentile = percentile;
        this.rank = rank;
        this.hide = hide;
        this.increase_marks = increase_marks;
        this.notes = notes;
    }

    public final String getPercentile() {
        return this.percentile;
    }

    public final String getRank() {
        return this.rank;
    }

    public final String getHide() {
        return this.hide;
    }

    public final String getIncrease_marks() {
        return this.increase_marks;
    }

    public final String getNotes() {
        return this.notes;
    }
}
