package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.ingest.EventType;

/* JADX INFO: loaded from: classes9.dex */
public class Visibility extends AnalyticsEvent {
    private final String state;
    private final EventType type;

    public Visibility(long j, String str, int i, String str2) {
        super(j, str, i);
        this.state = str2;
        this.type = EventType.Visibility;
    }

    public String getState() {
        return this.state;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return b.a(Constants.AES_PREFIX).append(getTimestamp()).append(Constants.SEPARATOR_COMMA).append(getType().getCustomOrdinal()).append(",\"").append(this.state).append("\"]").toString();
    }
}
