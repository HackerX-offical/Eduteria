package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/FragmentVisibility;", "Lcom/microsoft/clarity/models/ingest/analytics/Visibility;", "timestamp", "", "activityName", "", "activityId", "", "state", "fragmentName", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentVisibility extends Visibility {
    private final String fragmentName;
    private final EventType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentVisibility(long j, String activityName, int i, String state, String fragmentName) {
        super(j, activityName, i, state);
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        this.fragmentName = fragmentName;
        this.type = EventType.FragmentVisibility;
    }

    @Override // com.microsoft.clarity.models.ingest.analytics.Visibility, com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.analytics.Visibility, com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return Constants.AES_PREFIX + getTimestamp() + CsvReader.Letters.COMMA + getType().getCustomOrdinal() + ",\"" + this.fragmentName + "\",\"" + getState() + "\"]";
    }
}
