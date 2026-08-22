package com.appnew.android.feeds.dataclass.comment;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006)"}, d2 = {"Lcom/appnew/android/feeds/dataclass/comment/CommentModel;", "", "cd_time", "", "data", "", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLjava/util/List;IILjava/lang/String;ZI)V", "getCd_time", "()J", "getData", "()Ljava/util/List;", "getInterval", "()I", "getLimit", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CommentModel {
    public static final int $stable = 8;
    private final long cd_time;
    private final List<Data> data;
    private final int interval;
    private final int limit;
    private final String message;
    private final boolean status;
    private final int time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentModel copy$default(CommentModel commentModel, long j, List list, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = commentModel.cd_time;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            list = commentModel.data;
        }
        List list2 = list;
        if ((i4 & 4) != 0) {
            i = commentModel.interval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = commentModel.limit;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str = commentModel.message;
        }
        return commentModel.copy(j2, list2, i5, i6, str, (i4 & 32) != 0 ? commentModel.status : z, (i4 & 64) != 0 ? commentModel.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCd_time() {
        return this.cd_time;
    }

    public final List<Data> component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTime() {
        return this.time;
    }

    public final CommentModel copy(long cd_time, List<Data> data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new CommentModel(cd_time, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentModel)) {
            return false;
        }
        CommentModel commentModel = (CommentModel) other;
        return this.cd_time == commentModel.cd_time && Intrinsics.areEqual(this.data, commentModel.data) && this.interval == commentModel.interval && this.limit == commentModel.limit && Intrinsics.areEqual(this.message, commentModel.message) && this.status == commentModel.status && this.time == commentModel.time;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.cd_time) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "CommentModel(cd_time=" + this.cd_time + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public CommentModel(long j, List<Data> data, int i, int i2, String message, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.cd_time = j;
        this.data = data;
        this.interval = i;
        this.limit = i2;
        this.message = message;
        this.status = z;
        this.time = i3;
    }

    public final long getCd_time() {
        return this.cd_time;
    }

    public final List<Data> getData() {
        return this.data;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final int getTime() {
        return this.time;
    }
}
