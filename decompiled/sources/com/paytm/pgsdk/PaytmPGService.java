package com.paytm.pgsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmPGService {
    private static final String PRODUCTION_CANCEL_TRANSACTION_URL = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/CANCEL_TXN";
    private static final String PRODUCTION_CAS_URL = "https://secure.paytm.in/oltp-web/generateChecksum";
    private static final String PRODUCTION_PG_URL = "https://secure.paytm.in/oltp-web/processTransaction";
    private static final String PRODUCTION_STATUS_QUERY_URL = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/TXNSTATUS";
    private static final String STAGING_CANCEL_TRANSACTION_URL = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/CANCEL_TXN";
    private static final String STAGING_CAS_URL = "https://pguat.paytm.com:8448/CAS/ChecksumGenerator";
    private static final String STAGING_PG_URL = "https://pguat.paytm.com/oltp-web/processTransaction";
    private static final String STAGING_STATUS_QUERY_URL = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/TXNSTATUS";
    private static volatile PaytmPGService mService = null;
    public static String pgUrlDemo = "";
    private boolean isAssistEnabled = true;
    protected volatile String mCancelTransactionURL;
    public volatile PaytmClientCertificate mCertificate;
    public volatile PaytmOrder mOrder;
    protected volatile String mPGURL;
    private volatile PaytmPaymentTransactionCallback mPaymentTransactionCallback;
    protected volatile PaytmRefundCallback mRefundCallback;
    protected volatile PaytmStatusQueryCallback mStatusQueryCallback;
    private volatile String mStatusQueryURL;
    private volatile boolean mbServiceRunning;
    private String mid;
    private String orderId;
    private String txnToken;

    private boolean isAssistEnabled() {
        return this.isAssistEnabled;
    }

    public void setAssistEnabled(boolean z) {
        this.isAssistEnabled = z;
    }

    public static synchronized PaytmPGService getService() {
        try {
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.printStackTrace(e2);
        }
        if (mService == null) {
            PaytmUtility.debugLog("Creating an instance of Paytm PG Service...");
            mService = new PaytmPGService();
            PaytmUtility.debugLog("Created a new instance of Paytm PG Service.");
        }
        return mService;
    }

    private static String getBaseUrl() {
        if (!TextUtils.isEmpty(getService().mPGURL)) {
            try {
                return new URL(getService().mPGURL).getHost();
            } catch (MalformedURLException unused) {
                return "securegw.paytm.in";
            }
        }
        return "securegw.paytm.in";
    }

    public static String closeOrderUrl() {
        return "https://" + getBaseUrl() + Constants.KEY_CLOSE_ORDER_URL;
    }

    public static String getTransactionStatusUrl() {
        return "https://" + getBaseUrl() + Constants.KEY_TRANS_STATUS_URL;
    }

    public static synchronized PaytmPGService getStagingService(String str) {
        PaytmPGService service;
        service = getService();
        service.mStatusQueryURL = STAGING_STATUS_QUERY_URL;
        if (!TextUtils.isEmpty(str)) {
            service.mPGURL = str;
            pgUrlDemo = service.mPGURL;
        } else {
            service.mPGURL = "https://securegw-stage.paytm.in/theia/processTransaction";
            pgUrlDemo = service.mPGURL;
        }
        SaveReferences.getInstance().setProduction(false);
        return service;
    }

    public static synchronized PaytmPGService getProductionService() {
        PaytmPGService service;
        service = getService();
        service.mCancelTransactionURL = "https://securegw.paytm.in/theia/closeOrder";
        service.mPGURL = "https://securegw.paytm.in/theia/processTransaction";
        SaveReferences.getInstance().setProduction(true);
        return service;
    }

    public static synchronized PaytmPGService getPreProductionService() {
        PaytmPGService service;
        service = getService();
        service.mCancelTransactionURL = "https://securegw.paytm.in/theia/closeOrder";
        service.mPGURL = "https://securegw-preprod.paytm.in/theia/processTransaction";
        SaveReferences.getInstance().setProduction(true);
        return service;
    }

    public static synchronized PaytmPGService getShowPaymentService(PaytmOrder paytmOrder, String str) {
        PaytmPGService service;
        HashMap<String, String> requestParamMap = paytmOrder.getRequestParamMap();
        if (TextUtils.isEmpty(str)) {
            str = "https://securegw.paytm.in/theia/api/v1/showPaymentPage";
        }
        String str2 = requestParamMap.get("ORDER_ID");
        String str3 = requestParamMap.get("MID");
        service = getService();
        service.mPGURL = str + "?mid=" + str3 + "&orderId=" + str2;
        SaveReferences.getInstance().setProduction(true);
        return service;
    }

    public static synchronized PaytmPGService getStagingShowPaymentService() {
        PaytmPGService service;
        service = getService();
        service.mPGURL = "https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage";
        return service;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public synchronized void initialize(PaytmOrder paytmOrder, PaytmClientCertificate paytmClientCertificate) {
        this.mOrder = paytmOrder;
        if (this.mOrder.getRequestParamMap() != null) {
            this.mid = this.mOrder.getRequestParamMap().get("MID");
            this.orderId = this.mOrder.getRequestParamMap().get("ORDER_ID");
            this.txnToken = this.mOrder.getRequestParamMap().get(Constants.TXN_TOKEN);
        }
        this.mCertificate = paytmClientCertificate;
    }

    public void enableLog(Context context) {
        ApplicationInfo applicationinfo = getApplicationinfo(context);
        if (applicationinfo != null) {
            int i = applicationinfo.flags & 2;
            applicationinfo.flags = i;
            Log.setEnableDebugLog(i != 0);
            return;
        }
        Log.setEnableDebugLog(false);
    }

    public synchronized void startPaymentTransaction(Context context, boolean z, boolean z2, PaytmPaymentTransactionCallback paytmPaymentTransactionCallback) {
        try {
            enableLog(context);
            if (PaytmUtility.isNetworkAvailable(context)) {
                if (this.mOrder != null && (this.mOrder.getRequestParamMap() == null || this.mOrder.getRequestParamMap().size() <= 0)) {
                    paytmPaymentTransactionCallback.onTransactionCancel("Invalid Params passed", null);
                    return;
                }
                if (!this.mbServiceRunning) {
                    Bundle bundle = new Bundle();
                    if (this.mOrder != null) {
                        for (Map.Entry<String, String> entry : this.mOrder.getRequestParamMap().entrySet()) {
                            PaytmUtility.debugLog(entry.getKey() + " = " + entry.getValue());
                            bundle.putString(entry.getKey(), entry.getValue());
                        }
                    }
                    PaytmUtility.debugLog("Starting the Service...");
                    Intent intent = new Intent(context, (Class<?>) PaytmPGActivity.class);
                    intent.putExtra("mid", this.mid);
                    intent.putExtra("orderId", this.orderId);
                    intent.putExtra("Parameters", bundle);
                    intent.putExtra("HIDE_HEADER", z);
                    intent.putExtra(Constants.IS_ENABLE_ASSIST, isAssistEnabled());
                    intent.putExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", z2);
                    this.mbServiceRunning = true;
                    this.mPaymentTransactionCallback = paytmPaymentTransactionCallback;
                    SaveReferences.getInstance().setPaytmPaymentTransactionCallback(paytmPaymentTransactionCallback);
                    ((Activity) context).startActivity(intent);
                    PaytmUtility.debugLog("Service Started.");
                } else {
                    PaytmUtility.debugLog("Service is already running.");
                }
            } else {
                stopService();
                paytmPaymentTransactionCallback.networkNotAvailable();
            }
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            stopService();
            PaytmUtility.printStackTrace(e2);
        }
    }

    public synchronized void startPaymentTransaction(Context context, boolean z, PaytmPaymentTransactionCallback paytmPaymentTransactionCallback) {
        try {
            enableLog(context);
            if (PaytmUtility.isNetworkAvailable(context)) {
                if (!this.mbServiceRunning) {
                    Bundle bundle = new Bundle();
                    bundle.putString("mid", this.mid);
                    bundle.putString("orderId", this.orderId);
                    bundle.putString("txnToken", this.txnToken);
                    PaytmUtility.debugLog("Starting the Service...");
                    Intent intent = new Intent(context, (Class<?>) PaytmPGActivity.class);
                    intent.putExtra("mid", this.mid);
                    intent.putExtra("orderId", this.orderId);
                    intent.putExtra("Parameters", bundle);
                    intent.putExtra("HIDE_HEADER", z);
                    intent.putExtra(Constants.IS_ENABLE_ASSIST, isAssistEnabled());
                    this.mbServiceRunning = true;
                    this.mPaymentTransactionCallback = paytmPaymentTransactionCallback;
                    SaveReferences.getInstance().setPaytmPaymentTransactionCallback(paytmPaymentTransactionCallback);
                    ((Activity) context).startActivity(intent);
                    PaytmUtility.debugLog("Service Started.");
                } else {
                    PaytmUtility.debugLog("Service is already running.");
                }
            } else {
                stopService();
                paytmPaymentTransactionCallback.networkNotAvailable();
            }
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            stopService();
            PaytmUtility.printStackTrace(e2);
        }
    }

    protected synchronized void stopService() {
        mService = null;
        PaytmUtility.debugLog("Service Stopped.");
    }

    private ApplicationInfo getApplicationinfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.debugLog(e2.getLocalizedMessage());
            return null;
        }
    }

    public PaytmPaymentTransactionCallback getmPaymentTransactionCallback() {
        if (this.mPaymentTransactionCallback == null) {
            return SaveReferences.getInstance().getPaytmPaymentTransactionCallback();
        }
        return this.mPaymentTransactionCallback;
    }
}
