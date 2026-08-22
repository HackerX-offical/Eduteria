package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.ingest.EventType;

/* JADX INFO: loaded from: classes9.dex */
public final class Resize extends AnalyticsEvent {
    private final int height;
    private final EventType type;
    private final int width;

    public Resize(long j, String str, int i, int i2, int i3) {
        super(j, str, i);
        this.width = i2;
        this.height = i3;
        this.type = EventType.Resize;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return b.a(Constants.AES_PREFIX).append(getTimestamp()).append(Constants.SEPARATOR_COMMA).append(getType().getCustomOrdinal()).append(Constants.SEPARATOR_COMMA).append(this.width).append(Constants.SEPARATOR_COMMA).append(this.height).append(Constants.AES_SUFFIX).toString();
    }
}
