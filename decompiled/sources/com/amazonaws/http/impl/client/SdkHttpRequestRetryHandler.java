package com.amazonaws.http.impl.client;

import com.amazonaws.util.AWSRequestMetrics;
import java.io.IOException;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    public static final SdkHttpRequestRetryHandler Singleton = new SdkHttpRequestRetryHandler();

    private SdkHttpRequestRetryHandler() {
    }

    @Override // org.apache.http.impl.client.DefaultHttpRequestRetryHandler, org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        AWSRequestMetrics aWSRequestMetrics;
        boolean zRetryRequest = super.retryRequest(iOException, i, httpContext);
        if (zRetryRequest && (aWSRequestMetrics = (AWSRequestMetrics) httpContext.getAttribute("AWSRequestMetrics")) != null) {
            aWSRequestMetrics.incrementCounter(AWSRequestMetrics.Field.HttpClientRetryCount);
        }
        return zRetryRequest;
    }
}
