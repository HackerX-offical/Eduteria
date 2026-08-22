package com.paytm.pgsdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class TransactionManager {
    private static final String AUTH_TOKEN_URI = "content://net.one97.paytm.trustlogin.TrustInfo/user/token";
    private static final String CURSOR_AUTH_TOKEN = "auth_code";
    public static final String ENABLE_PAYTM_TRANSPARENT_INVOKE = "paytm_invoke";
    public static final String PAYTM_APP_PACKAGE = "net.one97.paytm";
    private String callingBridge;
    private PaytmPaymentTransactionCallback mPaymentTransactionCallback;
    private PaytmOrder paytmOrder;
    private String showPaymentUrl = "https://securegw.paytm.in/theia/api/v1/showPaymentPage";
    private boolean enableAppInvoke = true;
    private boolean enableRedirectionFlow = true;
    private boolean isSubscriptionFlow = false;
    private boolean isPcfMerchant = false;
    private boolean isEmiSubventionEnabled = false;
    private Activity mContext = null;
    private Integer appInvokeRequestCode = null;
    private boolean appInvokedToGetCursor = false;
    private String mClientId = null;
    private final BroadcastReceiver startTransactionBroadcastReceiver = new BroadcastReceiver() { // from class: com.paytm.pgsdk.TransactionManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Constants.USER_MATCH_RESULT_ACTION.equals(intent.getAction())) {
                LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(TransactionManager.this.startTransactionBroadcastReceiver);
                boolean booleanExtra = intent.getBooleanExtra(Constants.USER_MATCHES, false);
                if (TransactionManager.this.mContext == null || TransactionManager.this.appInvokeRequestCode == null) {
                    return;
                }
                if (booleanExtra) {
                    TransactionManager transactionManager = TransactionManager.this;
                    transactionManager.startTransaction(transactionManager.mContext, TransactionManager.this.appInvokeRequestCode.intValue());
                    return;
                } else {
                    TransactionManager transactionManager2 = TransactionManager.this;
                    transactionManager2.startRedirectionFlow(transactionManager2.mContext);
                    return;
                }
            }
            if (Constants.USER_LOGIN_STATUS_RESULT_ACTION.equalsIgnoreCase(intent.getAction())) {
                LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(TransactionManager.this.startTransactionBroadcastReceiver);
                if (intent.getBooleanExtra(Constants.FEATURE_AVAILABLE_IN_APP, false)) {
                    boolean booleanExtra2 = intent.getBooleanExtra("user_logged_in", false);
                    if (TransactionManager.this.mContext == null || TransactionManager.this.appInvokeRequestCode == null) {
                        return;
                    }
                    if (booleanExtra2) {
                        TransactionManager transactionManager3 = TransactionManager.this;
                        transactionManager3.startTransaction(transactionManager3.mContext, TransactionManager.this.appInvokeRequestCode.intValue());
                        return;
                    } else {
                        TransactionManager transactionManager4 = TransactionManager.this;
                        transactionManager4.startRedirectionFlow(transactionManager4.mContext);
                        return;
                    }
                }
                TransactionManager transactionManager5 = TransactionManager.this;
                transactionManager5.verifyLoginStatusAndStartTxnUsingAuthCodeFlow(transactionManager5.mContext, TransactionManager.this.appInvokeRequestCode.intValue(), TransactionManager.this.mClientId);
            }
        }
    };
    private boolean enableAssist = true;

    public String getCallingBridge() {
        return this.callingBridge;
    }

    public void setCallingBridge(String str) {
        this.callingBridge = str;
        AnalyticsManager.getInstance().setCallingBridge(str);
    }

    private boolean isEnableAssist() {
        return this.enableAssist;
    }

    public void setEnableAssist(boolean z) {
        this.enableAssist = z;
    }

    private boolean isSubscriptionFlow() {
        return this.isSubscriptionFlow;
    }

    public void setSubscriptioFlow(boolean z) {
        this.isSubscriptionFlow = z;
    }

    public TransactionManager(PaytmOrder paytmOrder, PaytmPaymentTransactionCallback paytmPaymentTransactionCallback) {
        if (paytmOrder == null) {
            throw new IllegalArgumentException("Transaction params cannot be null");
        }
        this.mPaymentTransactionCallback = paytmPaymentTransactionCallback;
        this.paytmOrder = paytmOrder;
    }

    public TransactionManager() {
    }

    public void setAppInvokeEnabled(boolean z) {
        this.enableAppInvoke = z;
    }

    public void setRedirectionEnabled(boolean z) {
        this.enableRedirectionFlow = z;
    }

    public void startTransaction(Activity activity, int i, String str) {
        AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_SDK_INITIALIZED, "", AnalyticsManager.getInstance().getEventLabelString(this.paytmOrder));
        String paytmVersion = getPaytmVersion(activity);
        if (PaytmUtility.isPaytmAppInstalled(activity) && this.enableAppInvoke && versionCompare(paytmVersion, str) >= 0) {
            if ((isSubscriptionFlow() && versionCompare(paytmVersion, "8.10.8") < 0) || ((this.isPcfMerchant && versionCompare(paytmVersion, "9.0.0") < 0) || (this.isEmiSubventionEnabled && versionCompare(paytmVersion, "9.10.0") < 0))) {
                startRedirectionFlow(activity);
                return;
            } else {
                startPaytmAppInvoke(activity, i);
                return;
            }
        }
        if (this.enableRedirectionFlow) {
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_INVOKE, Constants.FLOW_TYPE_APP_INVOKE, "status", Constants.EVENT_LABEL_FAIL);
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_WEB_VIEW_BRIDGE, Constants.FLOW_TYPE_REDIRECTION, AnalyticsManager.getInstance().getEventLabelString(this.paytmOrder));
            startRedirectionFlow(activity);
        } else {
            this.mPaymentTransactionCallback.onErrorProceed("Some Error Occurred in Selected payment Flow . Please  enableRedirectionFlow true ");
            PaytmUtility.debugLog("No payment flow opted");
        }
    }

    public void startTransaction(Activity activity, boolean z, String str, String str2, int i) {
        boolean zIsPaytmAppInstalled = isPaytmAppInstalled(activity);
        if (!TextUtils.isEmpty(str) && zIsPaytmAppInstalled && this.enableAppInvoke && z) {
            this.mContext = activity;
            this.appInvokeRequestCode = Integer.valueOf(i);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constants.USER_MATCH_RESULT_ACTION);
            LocalBroadcastManager.getInstance(activity.getApplicationContext()).registerReceiver(this.startTransactionBroadcastReceiver, intentFilter);
            Intent intent = new Intent(activity, (Class<?>) AioMatchUserActivity.class);
            intent.putExtra(Constants.KEY_USER_MOBILE_HASH, str);
            intent.putExtra(Constants.KEY_USER_MOBILE_HASH_2, str2);
            activity.startActivity(intent);
            return;
        }
        startTransaction(activity, i);
    }

    public void startTransaction(Activity activity, int i) {
        startTransaction(activity, i, "0.0.0");
    }

    public void startTransactionForONUS(Activity activity, int i) {
        startTransaction(activity, i, "8.12.8");
    }

    public void startTransactionAfterCheckingLoginStatus(Activity activity, String str, int i) {
        if (isPaytmAppInstalled(activity) && this.enableAppInvoke) {
            this.mContext = activity;
            this.appInvokeRequestCode = Integer.valueOf(i);
            this.mClientId = str;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constants.USER_LOGIN_STATUS_RESULT_ACTION);
            LocalBroadcastManager.getInstance(activity.getApplicationContext()).registerReceiver(this.startTransactionBroadcastReceiver, intentFilter);
            Intent intent = new Intent(activity, (Class<?>) AioMatchUserActivity.class);
            intent.putExtra(AioMatchUserActivity.CHECK_USER_LOGIN_ONLY, true);
            activity.startActivity(intent);
            return;
        }
        startTransaction(activity, i);
    }

    private boolean isPaytmAppInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(PAYTM_APP_PACKAGE, 0);
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_EXIST, Constants.FLOW_TYPE_APP_INVOKE, Constants.EVENT_LABEL_KEY_EXIST, "true");
            return true;
        } catch (Exception unused) {
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_EXIST, Constants.FLOW_TYPE_APP_INVOKE, Constants.EVENT_LABEL_KEY_EXIST, "false");
            PaytmUtility.debugLog("Paytm app not installed");
            return false;
        }
    }

    private String getPaytmVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(PAYTM_APP_PACKAGE, 0).versionName;
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_APP_INVOKE, e2.getMessage());
            PaytmUtility.debugLog("Paytm app not installed");
            return null;
        }
    }

    private int versionCompare(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length && strArrSplit[i].equalsIgnoreCase(strArrSplit2[i])) {
            i++;
        }
        if (i < strArrSplit.length && i < strArrSplit2.length) {
            return Integer.signum(Integer.valueOf(strArrSplit[i]).compareTo(Integer.valueOf(strArrSplit2[i])));
        }
        return Integer.signum(strArrSplit.length - strArrSplit2.length);
    }

    private void startPaytmAppInvoke(Activity activity, int i) {
        double d2;
        String str;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        HashMap<String, String> requestParamMap = this.paytmOrder.getRequestParamMap();
        String str2 = requestParamMap.get("TXN_AMOUNT");
        try {
            d2 = Double.parseDouble(str2);
        } catch (NumberFormatException e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_APP_INVOKE, e2.getMessage());
            d2 = 0.0d;
        }
        bundle.putBoolean("nativeSdkEnabled", true);
        bundle.putString("orderid", requestParamMap.get("ORDER_ID"));
        bundle.putString("txnToken", requestParamMap.get(Constants.TXN_TOKEN));
        bundle.putString("mid", requestParamMap.get("MID"));
        bundle.putDouble("nativeSdkForMerchantAmount", d2);
        String paytmVersion = getPaytmVersion(activity);
        AnalyticsManager.getInstance().sendLogEvent(Constants.EVENT_ACTION_APP_INVOKE_BRIDGE, Constants.FLOW_TYPE_APP_INVOKE, AnalyticsManager.getInstance().getEventLabelString(this.paytmOrder), paytmVersion);
        try {
            if (versionCompare(paytmVersion, "8.6.0") < 0) {
                intent.setComponent(new ComponentName(PAYTM_APP_PACKAGE, "net.one97.paytm.AJRJarvisSplash"));
            } else {
                intent.setComponent(new ComponentName(PAYTM_APP_PACKAGE, "net.one97.paytm.AJRRechargePaymentActivity"));
                intent.putExtra("enable_paytm_invoke", true);
                intent.putExtra(ENABLE_PAYTM_TRANSPARENT_INVOKE, true);
                intent.putExtra(FirebaseAnalytics.Param.PRICE, str2);
                intent.putExtra("nativeSdkEnabled", true);
                intent.putExtra("orderid", requestParamMap.get("ORDER_ID"));
                intent.putExtra("txnToken", requestParamMap.get(Constants.TXN_TOKEN));
                intent.putExtra("mid", requestParamMap.get("MID"));
                intent.addFlags(134217728);
            }
            intent.putExtra("isFromAIO", true);
            intent.putExtra("paymentmode", 2);
            intent.putExtra("bill", bundle);
            intent.putExtra("isFromAIO", true);
            HashMap<String, Object> extraParams = getExtraParams();
            if (extraParams != null) {
                intent.putExtra("extraParams", extraParams);
            }
            str = paytmVersion;
            try {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_INVOKE, Constants.FLOW_TYPE_APP_INVOKE, "status", "success", str);
            } catch (Exception unused) {
            }
            try {
                activity.startActivityForResult(intent, i);
            } catch (Exception unused2) {
                AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_INVOKE, Constants.FLOW_TYPE_APP_INVOKE, "status", Constants.EVENT_LABEL_FAIL, str);
                startRedirectionFlow(activity);
            }
        } catch (Exception unused3) {
            str = paytmVersion;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRedirectionFlow(Context context) {
        PaytmPGService showPaymentService = PaytmPGService.getShowPaymentService(this.paytmOrder, this.showPaymentUrl);
        showPaymentService.initialize(this.paytmOrder, null);
        showPaymentService.setAssistEnabled(isEnableAssist());
        showPaymentService.startPaymentTransaction(context, true, this.mPaymentTransactionCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyLoginStatusAndStartTxnUsingAuthCodeFlow(final Activity activity, int i, String str) {
        if (!TextUtils.isEmpty(fetchAuthCode(activity, str))) {
            startTransaction(activity, i);
        } else if (this.appInvokedToGetCursor) {
            new Handler().postDelayed(new Runnable() { // from class: com.paytm.pgsdk.TransactionManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TransactionManager.this.startRedirectionFlow(activity);
                }
            }, 2500L);
        } else {
            startRedirectionFlow(activity);
        }
    }

    private String fetchAuthCode(Context context, String str) {
        if (!isPaytmAppInstalled(context) && this.enableAppInvoke) {
            return null;
        }
        this.appInvokedToGetCursor = false;
        Cursor cursorToQueryAuthTokenFromPaytmApp = getCursorToQueryAuthTokenFromPaytmApp(context, str);
        String authTokenFromCursor = getAuthTokenFromCursor(cursorToQueryAuthTokenFromPaytmApp);
        if (cursorToQueryAuthTokenFromPaytmApp != null && TextUtils.isEmpty(authTokenFromCursor)) {
            return null;
        }
        if (cursorToQueryAuthTokenFromPaytmApp == null || TextUtils.isEmpty(authTokenFromCursor)) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(PAYTM_APP_PACKAGE, "net.one97.paytm.nativesdk.InvokePaytmTransparentActivity"));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    this.appInvokedToGetCursor = true;
                    context.startActivity(intent);
                    authTokenFromCursor = getAuthTokenFromCursor(getCursorToQueryAuthTokenFromPaytmApp(context, str));
                }
            } catch (Exception e2) {
                PaytmUtility.printStackTrace(e2);
            }
        }
        if (!TextUtils.isEmpty(authTokenFromCursor)) {
            PaytmUtility.debugLog("Auth Code: " + authTokenFromCursor);
        } else {
            PaytmUtility.debugLog("Auth Code is EMPTY");
        }
        return authTokenFromCursor;
    }

    private Cursor getCursorToQueryAuthTokenFromPaytmApp(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client_id", str);
            jSONObject.put("isTrusted", true);
            jSONObject.put("shouldMatchMobile", false);
            jSONObject.put(AnalyticsConstants.PACKAGE, "net.one97.paytm.nativesdk");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return context.getContentResolver().query(Uri.parse(AUTH_TOKEN_URI), null, jSONObject.toString(), null, null);
    }

    private String getAuthTokenFromCursor(Cursor cursor) {
        String string;
        if (cursor == null) {
            return null;
        }
        cursor.moveToFirst();
        do {
            string = cursor.getString(cursor.getColumnIndex("auth_code"));
            PaytmUtility.debugLog("Found Authtoken credential as " + string);
        } while (cursor.moveToNext());
        cursor.close();
        return string;
    }

    public void setShowPaymentUrl(String str) {
        this.showPaymentUrl = str;
    }

    public void setPcfMerchant(boolean z) {
        this.isPcfMerchant = z;
    }

    private HashMap<String, Object> getExtraParams() {
        HashMap<String, Object> map = new HashMap<>();
        String str = this.callingBridge;
        if (str != null && !str.isEmpty()) {
            map.put("hybridPlatform", this.callingBridge);
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public void setEmiSubventionEnabled(boolean z) {
        this.isEmiSubventionEnabled = z;
    }
}
