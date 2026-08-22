package com.paytm.pgsdk;

import android.os.Build;
import com.clevertap.android.sdk.network.api.CtApi;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class AnalyticsManager {
    private static volatile AnalyticsManager INSTANCE;
    private String callingBridge = "";
    private String mid = "";
    private String orderId = "";
    public final MediaType JSON = MediaType.get(CtApi.DEFAULT_CONTENT_TYPE);

    public void sendLogEvent(String str, String str2, String str3, String str4) {
    }

    public String getCallingBridge() {
        return this.callingBridge;
    }

    public void setCallingBridge(String str) {
        this.callingBridge = str;
    }

    private AnalyticsManager() {
    }

    public static AnalyticsManager getInstance() {
        if (INSTANCE == null) {
            synchronized (AnalyticsManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AnalyticsManager();
                }
            }
        }
        return INSTANCE;
    }

    public void logEvent(String str, String str2, String str3) {
        sendLogEvent(str, str2, str3, "");
    }

    public void logEvent(String str, String str2, String str3, String str4) {
        logEvent(str, str2, str3 + "=" + str4);
    }

    public void logEvent(String str, String str2, String str3, String str4, String str5) {
        sendLogEvent(str, str2, str3 + "=" + str4, str5);
    }

    public void logErrorEvent(String str, String str2) {
        logEvent(Constants.EVENT_ACTION_ERROR, str, Constants.EVENT_LABEL_KEY_ERROR_DESCRIPTION, str2);
    }

    public String getEventLabelString(PaytmOrder paytmOrder) {
        if (paytmOrder != null && paytmOrder.getRequestParamMap() != null) {
            this.mid = paytmOrder.getRequestParamMap().get("MID");
            this.orderId = paytmOrder.getRequestParamMap().get("ORDER_ID");
        }
        return "mid=" + this.mid + "^orderId=" + this.orderId + "^bridgeName=" + this.callingBridge;
    }

    private String getEventLoggerData(String str, String str2, String str3, String str4) {
        String str5 = Build.MANUFACTURER + "-" + Build.MODEL;
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strValueOf2 = String.valueOf(Build.VERSION.SDK_INT);
        String str6 = this.callingBridge;
        if (str6 == null) {
            str6 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventType", Constants.EVENT_TYPE_ALL_IN_ONE);
            jSONObject.put("mid", this.mid);
            jSONObject.put("orderId", this.orderId);
            jSONObject.put("deviceModel", str5);
            jSONObject.put("os", "android");
            jSONObject.put("osVersion", strValueOf2);
            jSONObject.put("timestamp", strValueOf);
            jSONObject.put("flow", str2);
            jSONObject.put("sdkVersion", "AIO_1.0");
            jSONObject.put("platform", "SDK");
            jSONObject.put("deviceType", "SmartPhone");
            jSONObject.put("eventCategory", Constants.EVENT_TYPE_ALL_IN_ONE);
            jSONObject.put("eventAction", str);
            jSONObject.put("eventLabel", str3);
            jSONObject.put(Constants.EVENT_LABEL_BRIDGE, str6);
            if (!str4.isEmpty()) {
                jSONObject.put("PaytmAppVersion", "Android_" + str4);
            }
            jSONObject.put("env", "allinone_sdk_prod");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static void destroyInstance() {
        if (INSTANCE != null) {
            INSTANCE = null;
        }
    }
}
