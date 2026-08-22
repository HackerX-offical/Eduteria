package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/MetricEvent;", "Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "timestamp", "", "activityName", "", "activityId", "", "metrics", "", "Lcom/microsoft/clarity/models/ingest/analytics/Metric;", "(JLjava/lang/String;ILjava/util/Map;)V", "getMetrics", "()Ljava/util/Map;", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetricEvent extends AnalyticsEvent {
    private final Map<Metric, Long> metrics;
    private final EventType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricEvent(long j, String activityName, int i, Map<Metric, Long> metrics) {
        super(j, activityName, i);
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.metrics = metrics;
        this.type = EventType.Metric;
    }

    public final Map<Metric, Long> getMetrics() {
        return this.metrics;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.AES_PREFIX + getTimestamp() + CsvReader.Letters.COMMA + getType().getCustomOrdinal());
        for (Map.Entry<Metric, Long> entry : this.metrics.entrySet()) {
            sb.append(Constants.SEPARATOR_COMMA + entry.getKey().ordinal() + CsvReader.Letters.COMMA + entry.getValue().longValue());
        }
        sb.append(Constants.AES_SUFFIX);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
