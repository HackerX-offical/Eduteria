package com.microsoft.clarity.models.observers;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/observers/ObservedEvent;", "", "absoluteTimestamp", "", "(J)V", "getAbsoluteTimestamp", "()J", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ObservedEvent {
    private final long absoluteTimestamp;

    public ObservedEvent(long j) {
        this.absoluteTimestamp = j;
    }

    public final long getAbsoluteTimestamp() {
        return this.absoluteTimestamp;
    }
}
