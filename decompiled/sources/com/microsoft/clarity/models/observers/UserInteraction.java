package com.microsoft.clarity.models.observers;

import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/observers/UserInteraction;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "analyticsEvent", "Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "(Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;)V", "getAnalyticsEvent", "()Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserInteraction extends ObservedEvent {
    private final AnalyticsEvent analyticsEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInteraction(AnalyticsEvent analyticsEvent) {
        super(analyticsEvent.getTimestamp());
        Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
        this.analyticsEvent = analyticsEvent;
    }

    public final AnalyticsEvent getAnalyticsEvent() {
        return this.analyticsEvent;
    }
}
