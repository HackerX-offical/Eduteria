package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/BaselineEvent;", "Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "timestamp", "", "activityName", "", "activityId", "", "visible", "", "(JLjava/lang/String;IZ)V", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaselineEvent extends AnalyticsEvent {
    private final EventType type;
    private final boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaselineEvent(long j, String activityName, int i, boolean z) {
        super(j, activityName, i);
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.visible = z;
        this.type = EventType.Baseline;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        boolean z = this.visible;
        StringBuilder sb = new StringBuilder(Constants.AES_PREFIX);
        sb.append(getTimestamp()).append(CsvReader.Letters.COMMA).append(getType().getCustomOrdinal()).append(CsvReader.Letters.COMMA).append(z ? 1 : 0).append(",0,0,0,0,0,0,0,0,0]");
        return sb.toString();
    }
}
