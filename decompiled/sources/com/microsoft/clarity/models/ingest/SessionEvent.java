package com.microsoft.clarity.models.ingest;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/ingest/SessionEvent;", "", "()V", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SessionEvent {
    public abstract EventType getType();

    public abstract String serialize();
}
