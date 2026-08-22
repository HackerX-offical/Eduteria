package com.microsoft.clarity.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 62\u00020\u0001:\u00016B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJN\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0006\u00101\u001a\u00020\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u00067"}, d2 = {"Lcom/microsoft/clarity/models/PayloadMetadata;", "", "sessionId", "", "pageNum", "", "sequence", "start", "", TypedValues.TransitionType.S_DURATION, "startTimeRelativeToPage", "(Ljava/lang/String;IIJLjava/lang/Long;Ljava/lang/Long;)V", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "fallbackWorkerId", "Ljava/util/UUID;", "getFallbackWorkerId", "()Ljava/util/UUID;", "setFallbackWorkerId", "(Ljava/util/UUID;)V", "fallbackWorkerStartTime", "getFallbackWorkerStartTime", "setFallbackWorkerStartTime", "maxPayloadDuration", "getMaxPayloadDuration", "()I", "getPageNum", "getSequence", "getSessionId", "()Ljava/lang/String;", "getStart", "()J", "getStartTimeRelativeToPage", "setStartTimeRelativeToPage", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "(Ljava/lang/String;IIJLjava/lang/Long;Ljava/lang/Long;)Lcom/microsoft/clarity/models/PayloadMetadata;", "equals", "", "other", "hashCode", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "updateDuration", "", "eventPageRelativeTimestamp", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class PayloadMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private transient Long duration;
    private transient UUID fallbackWorkerId;
    private transient Long fallbackWorkerStartTime;
    private final int maxPayloadDuration;
    private final int pageNum;
    private final int sequence;
    private final String sessionId;
    private final long start;
    private transient Long startTimeRelativeToPage;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/PayloadMetadata$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/PayloadMetadata;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayloadMetadata fromJson(String jsonString) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            String string = jSONObject.getString("sessionId");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"sessionId\")");
            return new PayloadMetadata(string, jSONObject.getInt("pageNum"), jSONObject.getInt("sequence"), jSONObject.getLong("start"), null, null, 48, null);
        }
    }

    public PayloadMetadata(String sessionId, int i, int i2, long j, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.pageNum = i;
        this.sequence = i2;
        this.start = j;
        this.duration = l;
        this.startTimeRelativeToPage = l2;
        this.maxPayloadDuration = Math.min(i2 * 1000, 30000);
    }

    public /* synthetic */ PayloadMetadata(String str, int i, int i2, long j, Long l, Long l2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, j, (i3 & 16) != 0 ? null : l, (i3 & 32) != 0 ? null : l2);
    }

    public static /* synthetic */ PayloadMetadata copy$default(PayloadMetadata payloadMetadata, String str, int i, int i2, long j, Long l, Long l2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = payloadMetadata.sessionId;
        }
        if ((i3 & 2) != 0) {
            i = payloadMetadata.pageNum;
        }
        if ((i3 & 4) != 0) {
            i2 = payloadMetadata.sequence;
        }
        if ((i3 & 8) != 0) {
            j = payloadMetadata.start;
        }
        if ((i3 & 16) != 0) {
            l = payloadMetadata.duration;
        }
        if ((i3 & 32) != 0) {
            l2 = payloadMetadata.startTimeRelativeToPage;
        }
        long j2 = j;
        int i4 = i2;
        return payloadMetadata.copy(str, i, i4, j2, l, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getStartTimeRelativeToPage() {
        return this.startTimeRelativeToPage;
    }

    public final PayloadMetadata copy(String sessionId, int pageNum, int sequence, long start, Long duration, Long startTimeRelativeToPage) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new PayloadMetadata(sessionId, pageNum, sequence, start, duration, startTimeRelativeToPage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayloadMetadata)) {
            return false;
        }
        PayloadMetadata payloadMetadata = (PayloadMetadata) other;
        return Intrinsics.areEqual(this.sessionId, payloadMetadata.sessionId) && this.pageNum == payloadMetadata.pageNum && this.sequence == payloadMetadata.sequence && this.start == payloadMetadata.start && Intrinsics.areEqual(this.duration, payloadMetadata.duration) && Intrinsics.areEqual(this.startTimeRelativeToPage, payloadMetadata.startTimeRelativeToPage);
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final UUID getFallbackWorkerId() {
        return this.fallbackWorkerId;
    }

    public final Long getFallbackWorkerStartTime() {
        return this.fallbackWorkerStartTime;
    }

    public final int getMaxPayloadDuration() {
        return this.maxPayloadDuration;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getStart() {
        return this.start;
    }

    public final Long getStartTimeRelativeToPage() {
        return this.startTimeRelativeToPage;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.start) + ((Integer.hashCode(this.sequence) + ((Integer.hashCode(this.pageNum) + (this.sessionId.hashCode() * 31)) * 31)) * 31)) * 31;
        Long l = this.duration;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.startTimeRelativeToPage;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setDuration(Long l) {
        this.duration = l;
    }

    public final void setFallbackWorkerId(UUID uuid) {
        this.fallbackWorkerId = uuid;
    }

    public final void setFallbackWorkerStartTime(Long l) {
        this.fallbackWorkerStartTime = l;
    }

    public final void setStartTimeRelativeToPage(Long l) {
        this.startTimeRelativeToPage = l;
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sessionId", this.sessionId);
        jSONObject.put("pageNum", this.pageNum);
        jSONObject.put("sequence", this.sequence);
        jSONObject.put("start", this.start);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }

    public String toString() {
        return b.a("PayloadMetadata(sessionId=").append(this.sessionId).append(", pageNum=").append(this.pageNum).append(", sequence=").append(this.sequence).append(", start=").append(this.start).append(", duration=").append(this.duration).append(", startTimeRelativeToPage=").append(this.startTimeRelativeToPage).append(')').toString();
    }

    public final void updateDuration(long eventPageRelativeTimestamp) {
        Long l = this.duration;
        this.duration = Long.valueOf(Math.max(l != null ? l.longValue() : 0L, eventPageRelativeTimestamp - this.start));
    }
}
