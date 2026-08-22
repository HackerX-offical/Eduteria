package com.razorpay;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnew.android.Utils.Const;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
class SecondaryWebViewClient extends WebViewClient {
    CheckoutPresenter presenter;

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public SecondaryWebViewClient(CheckoutPresenter checkoutPresenter) {
        this.presenter = checkoutPresenter;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_SECONDARY_NETWORK_ERROR);
        this.presenter.destroyActivity(2, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        webView.setTag(str);
        this.presenter.onPageStarted(2, webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.presenter.onPageFinished(2, webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            trackRendererCrash(webView, renderProcessGoneDetail, "secondary_webview");
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
