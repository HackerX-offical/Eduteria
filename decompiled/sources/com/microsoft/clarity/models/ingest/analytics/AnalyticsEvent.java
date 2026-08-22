package com.microsoft.clarity.models.ingest.analytics;

import com.microsoft.clarity.models.ingest.SessionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "Lcom/microsoft/clarity/models/ingest/SessionEvent;", "timestamp", "", "activityName", "", "activityId", "", "(JLjava/lang/String;I)V", "getActivityId", "()I", "setActivityId", "(I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AnalyticsEvent extends SessionEvent {
    private int activityId;
    private String activityName;
    private long timestamp;

    public AnalyticsEvent(long j, String activityName, int i) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.timestamp = j;
        this.activityName = activityName;
        this.activityId = i;
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setActivityId(int i) {
        this.activityId = i;
    }

    public final void setActivityName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityName = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }
}
