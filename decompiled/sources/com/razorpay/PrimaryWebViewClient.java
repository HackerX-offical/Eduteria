package com.razorpay;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnew.android.Utils.Const;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
class PrimaryWebViewClient extends WebViewClient {
    int maxRetryCount = 2;
    CheckoutPresenter presenter;

    public PrimaryWebViewClient(CheckoutPresenter checkoutPresenter) {
        this.presenter = checkoutPresenter;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("PrimaryWebViewClient", "shouldOverrideUrlLoading", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            boolean zShouldOverrideUrlLoading = this.presenter.shouldOverrideUrlLoading(webView, str);
            AnalyticsUtil.logCheckoutFunctionExit("PrimaryWebViewClient", "shouldOverrideUrlLoading", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return zShouldOverrideUrlLoading;
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String strSubstring;
        try {
            Logger.d("shouldInterceptRequest: " + webResourceRequest.getUrl().toString());
            strSubstring = webResourceRequest.getUrl().toString().substring(webResourceRequest.getUrl().toString().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
        } catch (Exception unused) {
            strSubstring = "";
        }
        try {
            if (!CheckoutCacheManager.getInstance().isFetchedPublicPageUsed && strSubstring.equalsIgnoreCase("v2-entry.modern.js")) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            if (!strSubstring.isEmpty()) {
                String fileIfBuildExists = CheckoutCacheManager.getInstance().getFileIfBuildExists(strSubstring);
                if (!fileIfBuildExists.isEmpty()) {
                    String str = "text/javascript";
                    if (strSubstring.endsWith("css")) {
                        str = "text/css";
                    }
                    HashMap map = new HashMap();
                    map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                    return new WebResourceResponse(str, "UTF-8", 200, "OK", map, new ByteArrayInputStream(fileIfBuildExists.getBytes()));
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (str.contains("NAME_NOT_RESOLVED")) {
            if (this.maxRetryCount > 0) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_NETWORK_ERROR_RETRY);
                this.presenter.loadForm("");
                this.maxRetryCount--;
                return;
            } else {
                AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_NETWORK_RETRY_EXHAUSTED);
                this.presenter.showLoaderDialog(2, str);
                return;
            }
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_NETWORK_ERROR);
        this.presenter.destroyActivity(2, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("PrimaryWebViewClient", "onPageStarted", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            Logger.d("onPageStarted: " + str);
            Logger.d("LOAD_TIME onPageStarted:" + System.currentTimeMillis());
            webView.setTag(str);
            this.presenter.onPageStarted(1, webView, str);
            CheckoutUtils.toggleWebviewBackground(webView, str.contains(GlobalUrlConfig.instance().getBaseUrl()));
            AnalyticsUtil.logCheckoutFunctionExit("PrimaryWebViewClient", "onPageStarted", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("onPageFinished: " + str);
        Logger.d("LOAD_TIME onPageFinished:" + System.currentTimeMillis());
        this.presenter.onPageFinished(1, webView, str);
        CheckoutUtils.toggleWebviewBackground(webView, str.contains(GlobalUrlConfig.instance().getBaseUrl()));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            trackRendererCrash(webView, renderProcessGoneDetail, "primary_webview");
            return true;
        } catch (Exception e2) {
            Logger.e("Error in onRenderProcessGone: " + e2.getMessage());
            return true;
        }
    }

    private void trackRendererCrash(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail, String str) {
        try {
            HashMap map = new HashMap();
            if (renderProcessGoneDetail != null) {
                map.put("did_crash", Boolean.valueOf(renderProcessGoneDetail.didCrash()));
                map.put("renderer_priority_at_exit", Integer.valueOf(renderProcessGoneDetail.rendererPriorityAtExit()));
            } else {
                map.put("did_crash", "unknown");
                map.put("renderer_priority_at_exit", "unknown");
            }
            map.put(Const.manufacturer, Build.MANUFACTURER);
            map.put("model", Build.MODEL);
            map.put("os_version", Build.VERSION.RELEASE);
            if (webView != null && webView.getContext() != null) {
                int performanceClass = PerformanceUtil.getPerformanceClass(webView.getContext());
                boolean zIsLowEndDevice = PerformanceUtil.isLowEndDevice(webView.getContext());
                map.put("performance_class", Integer.valueOf(performanceClass));
                map.put("is_low_end_device", Boolean.valueOf(zIsLowEndDevice));
                ActivityManager activityManager = (ActivityManager) webView.getContext().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    map.put("total_ram_mb", Long.valueOf(memoryInfo.totalMem / 1048576));
                }
            }
            map.put("cpu_cores", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
            map.put("webview_type", str);
            AnalyticsUtil.trackEvent(AnalyticsEvent.WEBVIEW_RENDERER_CRASHED, AnalyticsUtil.getJSONResponse(map));
            Logger.d("Renderer crash analytics tracked");
        } catch (Exception e2) {
            Logger.e("Error tracking renderer crash: " + e2.getMessage());
        }
    }
}
