package com.microsoft.clarity.models.ingest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/clarity/models/ingest/WebViewAnalyticsEvent;", "Lcom/microsoft/clarity/models/ingest/BaseWebViewEvent;", "webViewHashCode", "", "event", "", "absoluteTimestamp", "", "webViewActivityName", "webViewActivityHashCode", "type", "(ILjava/lang/String;JLjava/lang/String;II)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebViewAnalyticsEvent extends BaseWebViewEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewAnalyticsEvent(int i, String event, long j, String webViewActivityName, int i2, int i3) {
        super(i, event, j, webViewActivityName, i2, i3);
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(webViewActivityName, "webViewActivityName");
    }
}
