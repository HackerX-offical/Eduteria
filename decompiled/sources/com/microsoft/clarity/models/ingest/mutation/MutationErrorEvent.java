package com.microsoft.clarity.models.ingest.mutation;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.n.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/ingest/mutation/MutationErrorEvent;", "Lcom/microsoft/clarity/models/ingest/mutation/BaseMutationEvent;", "timestamp", "", "reason", "", "(JLjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MutationErrorEvent extends BaseMutationEvent {
    private final String reason;
    private final EventType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutationErrorEvent(long j, String reason) {
        super(j);
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.reason = reason;
        this.type = EventType.MutationError;
    }

    public final String getReason() {
        return this.reason;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return Constants.AES_PREFIX + getTimestamp() + CsvReader.Letters.COMMA + getType().getCustomOrdinal() + ",\"" + k.a(this.reason) + "\"]";
    }
}
