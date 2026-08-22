package com.paytm.pgsdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.paytm.pgsdk.model.ProcessTransactionInfo;
import datamodels.PWEStaticDataModel;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmWebView extends WebView implements WebClientListener {
    private static final String CALLBACK = "/CAS/Response";
    public static final String HTML_OUT = "HTMLOUT";
    public static final String JAVA_SCRIPT = "javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);";
    public static final String JAVA_SCRIPT_UPI = "javascript:window.upiIntent.setUpiIntentApps(";
    private static final String PAYTM_CALLBACK = "theia/paytmCallback";
    public static final int REQUEST_CODE_UPI_APP = 105;
    private static final String SUCCESS = "01";
    private static final String Y = "Y";
    private AtomicBoolean isFetchTxnPorcessed;
    private final PaytmPGActivity mContext;
    private HashMap<String, ResolveInfo> mResolveInfoMap;
    private volatile boolean mbMerchantCallbackURLLoaded;

    public interface WbCListeners {
        void onPageLoaded(String str);
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public PaytmWebView(Context context, Bundle bundle) {
        super(context);
        this.isFetchTxnPorcessed = new AtomicBoolean(false);
        this.mContext = (PaytmPGActivity) context;
        this.mResolveInfoMap = new HashMap<>();
        setWebChromeClient(new WebChromeClient() { // from class: com.paytm.pgsdk.PaytmWebView.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                PaytmUtility.debugLog("JavaScript Alert " + str);
                return super.onJsAlert(webView, str, str2, jsResult);
            }
        });
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new PaytmJavaScriptInterface(), HTML_OUT);
    }

    public void setWebCLientCallBacks() {
        setWebViewClient(PaytmAssist.getAssistInstance().getWebClientInstance());
        PaytmAssist.getAssistInstance().getWebClientInstance().addAssistWebClientListener(this);
    }

    private synchronized void startProgressDialog() {
        try {
            ((Activity) getContext()).runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    PaytmWebView.this.mContext.mProgress.setVisibility(0);
                    PaytmUtility.debugLog("Progress dialog started");
                }
            });
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.printStackTrace(e2);
        }
    }

    private synchronized void stopProgressDialog() {
        try {
            ((Activity) getContext()).runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    PaytmWebView.this.mContext.mProgress.setVisibility(8);
                    PaytmUtility.debugLog("Progress dialog ended");
                }
            });
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle parseResponse(String str) {
        Bundle bundle;
        PaytmUtility.debugLog("Parsing the Merchant Response");
        bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    PaytmUtility.debugLog(next + " = " + string);
                    bundle.putString(next, string);
                }
            }
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.debugLog("Error while parsing the Merchant Response");
            PaytmUtility.printStackTrace(e2);
        }
        return bundle;
    }

    private synchronized boolean isValidChecksum(Bundle bundle) {
        boolean z;
        z = false;
        if (bundle != null) {
            try {
                if (bundle.size() > 0 && bundle.containsKey(PaytmConstants.IS_CHECKSUM_VALID)) {
                    if (bundle.getString(PaytmConstants.IS_CHECKSUM_VALID).equalsIgnoreCase(Y)) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                PaytmUtility.printStackTrace(e2);
            }
        }
        return z;
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        Intent intent;
        PaytmUtility.debugLog("Wc Page finsih " + str);
        if (this.mContext.isFinishing()) {
            return;
        }
        if (PaytmPGService.getService() == null || PaytmPGService.getService().mOrder == null) {
            PaytmUtility.debugLog("Transaction cancelled before loading web com.paytm.pgsdk.view completely.");
            return;
        }
        HashMap<String, String> requestParamMap = PaytmPGService.getService().mOrder.getRequestParamMap();
        if (requestParamMap != null) {
            PaytmUtility.debugLog("page finish url" + str);
            try {
                try {
                    PaytmUtility.debugLog("Page finished loading " + str);
                    if (requestParamMap.get("CALLBACK_URL") != null && str.contains(requestParamMap.get("CALLBACK_URL"))) {
                        PaytmUtility.debugLog("Merchant specific Callback Url is finished loading. Extract data now. ");
                        this.mbMerchantCallbackURLLoaded = true;
                        loadUrl(JAVA_SCRIPT);
                    } else if (str.endsWith(CALLBACK) || str.contains(PAYTM_CALLBACK)) {
                        PaytmUtility.debugLog("CAS Callback Url is finished loading. Extract data now. ");
                        loadUrl(JAVA_SCRIPT);
                    }
                } catch (Exception e2) {
                    AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                    if (str.equals(PaytmPGService.getService().mPGURL)) {
                        AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                    }
                    PaytmUtility.printStackTrace(e2);
                    if (requestParamMap.get("postnotificationurl") != null) {
                        intent = new Intent(this.mContext, (Class<?>) IntentServicePostNotification.class);
                    }
                }
                if (requestParamMap.get("postnotificationurl") != null) {
                    intent = new Intent(this.mContext, (Class<?>) IntentServicePostNotification.class);
                    intent.putExtra("url", requestParamMap.get("postnotificationurl"));
                    this.mContext.startService(intent);
                }
            } catch (Throwable th) {
                if (requestParamMap.get("postnotificationurl") != null) {
                    Intent intent2 = new Intent(this.mContext, (Class<?>) IntentServicePostNotification.class);
                    intent2.putExtra("url", requestParamMap.get("postnotificationurl"));
                    this.mContext.startService(intent2);
                }
                throw th;
            }
        }
        if (str.equals(PaytmPGService.getService().mPGURL)) {
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
        }
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        PaytmUtility.debugLog("Wc Page Start " + str);
        checkForDynamicURL(str);
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, "Error occurred while loading url " + sslError.getUrl());
        PaytmUtility.debugLog("Error occured while loading url " + sslError.getUrl());
        if (sslError.getUrl().equals(PaytmPGService.getService().mPGURL)) {
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
        }
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void WcshouldInterceptRequest(WebView webView, String str) {
        checkForDynamicURL(str);
    }

    private class PaytmWebViewClient extends EasypayWebViewClient {
        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            PaytmWebView.this.checkForDynamicURL(str);
        }

        /* JADX WARN: Finally extract failed */
        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onPageFinished(WebView webView, String str) {
            Intent intent;
            PaytmWebView paytmWebView;
            if (!PaytmWebView.this.mContext.isFinishing()) {
                if (PaytmPGService.getService() != null && PaytmPGService.getService().mOrder != null) {
                    HashMap<String, String> requestParamMap = PaytmPGService.getService().mOrder.getRequestParamMap();
                    if (requestParamMap != null) {
                        try {
                            PaytmUtility.debugLog("page finish url" + str);
                            try {
                                PaytmUtility.debugLog("Page finished loading " + str);
                                if (requestParamMap.get("CALLBACK_URL") != null && str.contains(requestParamMap.get("CALLBACK_URL"))) {
                                    PaytmUtility.debugLog("Merchant specific Callback Url is finished loading. Extract data now. ");
                                    PaytmWebView.this.mbMerchantCallbackURLLoaded = true;
                                    PaytmWebView.this.loadUrl(PaytmWebView.JAVA_SCRIPT);
                                } else if (str.endsWith(PaytmWebView.CALLBACK) || str.contains(PaytmWebView.PAYTM_CALLBACK)) {
                                    PaytmUtility.debugLog("CAS Callback Url is finished loading. Extract data now. ");
                                    PaytmWebView.this.loadUrl(PaytmWebView.JAVA_SCRIPT);
                                }
                            } catch (Exception e2) {
                                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                                if (str.equals(PaytmPGService.getService().mPGURL)) {
                                    AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                                }
                                PaytmUtility.printStackTrace(e2);
                                if (requestParamMap.get("postnotificationurl") != null) {
                                    intent = new Intent(PaytmWebView.this.mContext, (Class<?>) IntentServicePostNotification.class);
                                    intent.putExtra("url", requestParamMap.get("postnotificationurl"));
                                    paytmWebView = PaytmWebView.this;
                                    paytmWebView.mContext.startService(intent);
                                }
                            }
                            if (requestParamMap.get("postnotificationurl") != null) {
                                intent = new Intent(PaytmWebView.this.mContext, (Class<?>) IntentServicePostNotification.class);
                                intent.putExtra("url", requestParamMap.get("postnotificationurl"));
                                paytmWebView = PaytmWebView.this;
                                paytmWebView.mContext.startService(intent);
                            }
                        } catch (Throwable th) {
                            if (requestParamMap.get("postnotificationurl") != null) {
                                Intent intent2 = new Intent(PaytmWebView.this.mContext, (Class<?>) IntentServicePostNotification.class);
                                intent2.putExtra("url", requestParamMap.get("postnotificationurl"));
                                PaytmWebView.this.mContext.startService(intent2);
                            }
                            throw th;
                        }
                    }
                    super.onPageFinished(webView, str);
                    if (str.equals(PaytmPGService.getService().mPGURL)) {
                        AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                    }
                }
                PaytmUtility.debugLog("Transaction cancelled before loading web com.paytm.pgsdk.view completely.");
            }
        }

        public PaytmWebViewClient() {
            super(PaytmWebView.this.mContext);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            PaytmWebView.this.checkForDynamicURL(webResourceRequest.getUrl().toString());
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onReceivedError(WebView webView, int i, String str, String str2) {
            PaytmUtility.debugLog("Error occured while loading url " + str2);
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, "Error occurred while loading url " + str2);
            super.onReceivedError(webView, i, str, str2);
            if (str2.equals(PaytmPGService.getService().mPGURL)) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
            }
            PaytmUtility.debugLog("Error code is " + i + "Description is " + str);
            if (i == -6) {
                ((Activity) PaytmWebView.this.getContext()).finish();
                PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                if (paytmPaymentTransactionCallback != null) {
                    paytmPaymentTransactionCallback.onErrorLoadingWebPage(i, str, str2);
                }
            }
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            PaytmUtility.debugLog("SSL Error occured " + sslError.toString());
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, "SSL Error occurred " + sslError.getUrl());
            if (sslError.getUrl().equals(PaytmPGService.getService().mPGURL)) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
            }
            PaytmUtility.debugLog("SSL Handler is " + sslErrorHandler);
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            PaytmUtility.debugLog("shouldOverrideUrlLoading" + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            PaytmUtility.debugLog("onPageCommitVisible" + str);
            super.onPageCommitVisible(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            PaytmUtility.debugLog("onReceivedError" + webResourceRequest.getUrl());
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, "onReceivedError " + webResourceRequest.getUrl());
            if (webResourceRequest.getUrl().toString().equals(PaytmPGService.getService().mPGURL)) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            PaytmUtility.debugLog("onReceivedHttpError" + webResourceRequest.getUrl());
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, "onReceivedHttpError " + webResourceRequest.getUrl());
            if (webResourceRequest.getUrl().toString().equals(PaytmPGService.getService().mPGURL)) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTMH5_LOAD, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            super.onFormResubmission(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForDynamicURL(String str) {
        HashMap<String, String> requestParamMap;
        if (TextUtils.isEmpty(str) || PaytmPGService.getService().mOrder == null || (requestParamMap = PaytmPGService.getService().mOrder.getRequestParamMap()) == null || requestParamMap.get("CALLBACK_URL") == null || requestParamMap.get("CALLBACK_URL").contains(PAYTM_CALLBACK) || !str.contains(requestParamMap.get("CALLBACK_URL"))) {
            return;
        }
        PaytmUtility.debugLog("Merchant specific Callback Url is finished loading. Extract data now. ");
        this.mbMerchantCallbackURLLoaded = true;
        fetchTransactionStatus();
    }

    public class PaytmJavaScriptInterface {
        public PaytmJavaScriptInterface() {
        }

        @JavascriptInterface
        public synchronized void processResponse(String str) {
            try {
                PaytmUtility.debugLog("Merchant Response is " + str);
                Bundle response = PaytmWebView.this.parseResponse(str);
                String str2 = PaytmPGService.getService().mOrder.getRequestParamMap().get("CALLBACK_URL");
                returnResponse(response);
                if (TextUtils.isEmpty(str2)) {
                    PaytmUtility.debugLog("Returning the response back to Merchant Application");
                    PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                    if (paytmPaymentTransactionCallback != null) {
                        AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", "success");
                        paytmPaymentTransactionCallback.onTransactionCancel("no callback url", null);
                    }
                } else {
                    AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                    PaytmUtility.debugLog("Merchant Specific URL is present, So posting all parameters to Merchant specific URL");
                }
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                PaytmUtility.printStackTrace(e2);
            }
        }

        @JavascriptInterface
        public synchronized void inVokeUpiFlow(String str) {
            try {
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                PaytmUtility.printStackTrace(e2);
            }
            if (PaytmWebView.this.mContext != null) {
                PaytmWebView paytmWebView = PaytmWebView.this;
                final String str2 = "javascript:window.upiIntent.setUpiIntentApps('" + paytmWebView.getUpiAppList(paytmWebView.mContext) + "')";
                PaytmWebView.this.post(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.PaytmJavaScriptInterface.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PaytmWebView.this.loadUrl(str2);
                    }
                });
            }
        }

        @JavascriptInterface
        public synchronized void upiAppClicked(String str, String str2) {
            try {
                if (PaytmWebView.this.mContext != null) {
                    PaytmWebView.this.mContext.getPackageManager();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!PaytmWebView.this.mResolveInfoMap.isEmpty()) {
                        ActivityInfo activityInfo = ((ResolveInfo) PaytmWebView.this.mResolveInfoMap.get(str)).activityInfo;
                        ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                        new Uri.Builder().scheme(PWEStaticDataModel.PAYOPT_UPI_CODE).authority("pay");
                        intent.setData(Uri.parse(Uri.parse(str2).buildUpon().toString()));
                        intent.setComponent(componentName);
                        PaytmUtility.debugLog("App click package:" + str);
                        PaytmUtility.debugLog("App click deeplink:" + str2.toString());
                        PaytmWebView.this.mContext.startActivityForResult(intent, 105);
                    }
                }
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                PaytmUtility.printStackTrace(e2);
            }
        }

        private synchronized void returnResponse(final Bundle bundle) {
            try {
                final PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.PaytmJavaScriptInterface.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (paytmPaymentTransactionCallback != null) {
                                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", "success");
                                paytmPaymentTransactionCallback.onTransactionResponse(bundle);
                            }
                        } catch (Exception e2) {
                            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                            PaytmUtility.printStackTrace(e2);
                            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback2 = paytmPaymentTransactionCallback;
                            if (paytmPaymentTransactionCallback2 != null) {
                                paytmPaymentTransactionCallback2.onErrorLoadingWebPage(0, e2.getMessage(), PaytmWebView.this.getUrl());
                            }
                        }
                        ((Activity) PaytmWebView.this.getContext()).finish();
                    }
                });
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_RESPONSE_BACK, Constants.FLOW_TYPE_REDIRECTION, "status", Constants.EVENT_LABEL_FAIL);
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                PaytmUtility.printStackTrace(e2);
                if (PaytmPGService.getService() != null && PaytmPGService.getService().getmPaymentTransactionCallback() != null) {
                    PaytmPGService.getService().getmPaymentTransactionCallback().onErrorLoadingWebPage(0, e2.getMessage(), PaytmWebView.this.getUrl());
                }
                ((Activity) PaytmWebView.this.getContext()).finish();
            }
        }

        @JavascriptInterface
        public synchronized void saveMobileNum(String str) {
        }

        @JavascriptInterface
        public synchronized void postMobileNum(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUpiAppList(Context context) {
        String json = "";
        if (context != null) {
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                Uri.Builder builder = new Uri.Builder();
                builder.scheme(PWEStaticDataModel.PAYOPT_UPI_CODE).authority("pay");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(builder.toString()));
                PackageManager packageManager = context.getPackageManager();
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
                    map.put(resolveInfo.loadLabel(packageManager).toString(), resolveInfo.activityInfo.packageName);
                    this.mResolveInfoMap.put(resolveInfo.activityInfo.packageName, resolveInfo);
                }
                json = gson.toJson(map);
                PaytmUtility.debugLog("Upi App List" + json);
                return json;
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                e2.printStackTrace();
            }
        }
        return json;
    }

    public void fetchTransactionStatus() {
        if (this.isFetchTxnPorcessed.get()) {
            return;
        }
        this.isFetchTxnPorcessed.set(true);
        PaytmPGService service = PaytmPGService.getService();
        String transactionStatusUrl = PaytmPGService.getTransactionStatusUrl();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("txnToken", service.mOrder.getRequestParamMap().get(Constants.TXN_TOKEN));
            jSONObject3.put("mid", service.mOrder.getRequestParamMap().get("MID"));
            jSONObject3.put("orderId", service.mOrder.getRequestParamMap().get("ORDER_ID"));
            jSONObject3.put("isCallbackUrlRequired", true);
            jSONObject.put("body", jSONObject3);
            jSONObject.put("head", jSONObject2);
            new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(transactionStatusUrl).header("content-type", "application/json").header("Accept", "application/json").post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString().getBytes())).build()).enqueue(new Callback() { // from class: com.paytm.pgsdk.PaytmWebView.4
                @Override // okhttp3.Callback
                public void onResponse(Call call, final Response response) throws IOException {
                    ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                            try {
                                if (response.code() == 200 && response.body() != null) {
                                    ProcessTransactionInfo processTransactionInfo = (ProcessTransactionInfo) new Gson().fromJson(response.body().string(), ProcessTransactionInfo.class);
                                    if (processTransactionInfo.getBody() != null && processTransactionInfo.getBody().getTxnInfo() != null) {
                                        try {
                                            paytmPaymentTransactionCallback.onTransactionResponse(PaytmWebView.this.parseResponse(new Gson().toJson(processTransactionInfo.getBody().getTxnInfo())));
                                        } catch (Exception unused) {
                                            paytmPaymentTransactionCallback.onTransactionResponse(null);
                                        }
                                        ((Activity) PaytmWebView.this.getContext()).finish();
                                        return;
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                            paytmPaymentTransactionCallback.onTransactionResponse(null);
                            ((Activity) PaytmWebView.this.getContext()).finish();
                        }
                    });
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmWebView.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                            if (paytmPaymentTransactionCallback != null) {
                                paytmPaymentTransactionCallback.onTransactionResponse(null);
                            }
                            ((Activity) PaytmWebView.this.getContext()).finish();
                        }
                    });
                }
            });
        } catch (Exception e2) {
            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
            if (paytmPaymentTransactionCallback != null) {
                paytmPaymentTransactionCallback.onTransactionResponse(null);
            }
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
        }
    }
}
