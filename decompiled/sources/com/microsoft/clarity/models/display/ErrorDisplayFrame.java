package com.microsoft.clarity.models.display;

import com.microsoft.clarity.models.observers.ObservedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/microsoft/clarity/models/display/ErrorDisplayFrame;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "absoluteTimestamp", "", "activityName", "", "activityId", "", "reason", "(JLjava/lang/String;ILjava/lang/String;)V", "getActivityId", "()I", "setActivityId", "(I)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getReason", "setReason", "toJson", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ErrorDisplayFrame extends ObservedEvent {
    private int activityId;
    private String activityName;
    private String reason;

    public ErrorDisplayFrame() {
        this(0L, null, 0, null, 15, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorDisplayFrame(long j, String activityName, int i, String reason) {
        super(j);
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.activityName = activityName;
        this.activityId = i;
        this.reason = reason;
    }

    public /* synthetic */ ErrorDisplayFrame(long j, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str2);
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setActivityId(int i) {
        this.activityId = i;
    }

    public final void setActivityName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityName = str;
    }

    public final void setReason(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reason = str;
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", getAbsoluteTimestamp());
        jSONObject.put("activityName", this.activityName);
        jSONObject.put("activityId", this.activityId);
        jSONObject.put("reason", this.reason);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }
}
