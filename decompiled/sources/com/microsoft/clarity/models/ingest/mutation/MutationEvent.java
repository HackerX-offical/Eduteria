package com.microsoft.clarity.models.ingest.mutation;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/microsoft/clarity/models/ingest/mutation/MutationEvent;", "Lcom/microsoft/clarity/models/ingest/mutation/BaseMutationEvent;", "timestamp", "", "isKeyFrame", "", "payload", "", "(JZLjava/lang/String;)V", "()Z", "getPayload", "()Ljava/lang/String;", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MutationEvent extends BaseMutationEvent {
    private final boolean isKeyFrame;
    private final String payload;
    private final EventType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutationEvent(long j, boolean z, String payload) {
        super(j);
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.isKeyFrame = z;
        this.payload = payload;
        this.type = EventType.Mutation;
    }

    public final String getPayload() {
        return this.payload;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isKeyFrame, reason: from getter */
    public final boolean getIsKeyFrame() {
        return this.isKeyFrame;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return Constants.AES_PREFIX + getTimestamp() + CsvReader.Letters.COMMA + getType().getCustomOrdinal() + CsvReader.Letters.COMMA + this.isKeyFrame + ",\"" + this.payload + "\"]";
    }
}
