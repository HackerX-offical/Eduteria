package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.ingest.EventType;

/* JADX INFO: loaded from: classes9.dex */
public final class DoubleClick extends AnalyticsEvent {
    private final int pointerId;
    private final EventType type;
    private final float x;
    private final float y;

    public DoubleClick(long j, String str, int i, int i2, float f2, float f3) {
        super(j, str, i);
        this.pointerId = i2;
        this.x = f2;
        this.y = f3;
        this.type = EventType.DoubleClick;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return b.a(Constants.AES_PREFIX).append(getTimestamp()).append(Constants.SEPARATOR_COMMA).append(getType().getCustomOrdinal()).append(Constants.SEPARATOR_COMMA).append(this.pointerId).append(Constants.SEPARATOR_COMMA).append(StrictMath.round(this.x)).append(Constants.SEPARATOR_COMMA).append(StrictMath.round(this.y)).append(Constants.AES_SUFFIX).toString();
    }
}
