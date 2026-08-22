package com.microsoft.clarity.h;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;

/* JADX INFO: loaded from: classes9.dex */
public interface a extends d {
    void a(DisplayFrame displayFrame);

    void a(ErrorDisplayFrame errorDisplayFrame);

    void a(WebViewAnalyticsEvent webViewAnalyticsEvent);

    void a(WebViewMutationEvent webViewMutationEvent);

    void b(AnalyticsEvent analyticsEvent);
}
