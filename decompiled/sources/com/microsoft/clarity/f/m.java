package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;

/* JADX INFO: loaded from: classes9.dex */
public interface m extends n {
    void a(DisplayFrame displayFrame);

    void a(ErrorDisplayFrame errorDisplayFrame);

    void a(WebViewAnalyticsEvent webViewAnalyticsEvent);

    void a(WebViewMutationEvent webViewMutationEvent);

    void a(AnalyticsEvent analyticsEvent);

    void a(String str);

    void a(String str, String str2);

    void c();
}
