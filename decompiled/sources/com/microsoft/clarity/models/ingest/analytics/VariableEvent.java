package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.n.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/VariableEvent;", "Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "timestamp", "", "activityName", "", "activityId", "", "Variables", "", "(JLjava/lang/String;ILjava/util/Map;)V", "getVariables", "()Ljava/util/Map;", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VariableEvent extends AnalyticsEvent {
    private final Map<String, String> Variables;
    private final EventType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableEvent(long j, String activityName, int i, Map<String, String> Variables) {
        super(j, activityName, i);
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(Variables, "Variables");
        this.Variables = Variables;
        this.type = EventType.Variable;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    public final Map<String, String> getVariables() {
        return this.Variables;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.AES_PREFIX + getTimestamp() + CsvReader.Letters.COMMA + getType().getCustomOrdinal());
        for (Map.Entry<String, String> entry : this.Variables.entrySet()) {
            sb.append(b.a(",\"").append(entry.getKey()).append("\",[\"").append(k.a(entry.getValue())).append("\"]").toString());
        }
        sb.append(Constants.AES_SUFFIX);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
