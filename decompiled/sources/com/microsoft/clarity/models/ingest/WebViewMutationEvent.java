package com.microsoft.clarity.models.ingest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/ingest/WebViewMutationEvent;", "Lcom/microsoft/clarity/models/ingest/BaseWebViewEvent;", "webViewHashCode", "", "event", "", "absoluteTimestamp", "", "webViewActivityName", "webViewActivityHashCode", "type", "pageUrl", "(ILjava/lang/String;JLjava/lang/String;IILjava/lang/String;)V", "getPageUrl", "()Ljava/lang/String;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebViewMutationEvent extends BaseWebViewEvent {
    private final String pageUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewMutationEvent(int i, String event, long j, String webViewActivityName, int i2, int i3, String pageUrl) {
        super(i, event, j, webViewActivityName, i2, i3);
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(webViewActivityName, "webViewActivityName");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        this.pageUrl = pageUrl;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }
}
