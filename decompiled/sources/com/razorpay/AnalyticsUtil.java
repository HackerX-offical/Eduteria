package com.razorpay;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.razorpay.AnalyticsProperty;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class AnalyticsUtil {
    static String BUILD_TYPE = null;
    static String FRAMEWORK = null;
    static String KEY_TYPE = null;
    static int MERCHANT_APP_BUILD = 0;
    static CharSequence MERCHANT_APP_NAME = null;
    static CharSequence MERCHANT_APP_NAMESPACE = null;
    static int MERCHANT_APP_TARGET_SDK = 0;
    static CharSequence MERCHANT_APP_VERSION = null;
    private static boolean isAnalyticsInitialized = false;
    static String libraryType = null;
    private static String localOrderId = null;
    private static String localPaymentId = null;
    private static String sdkType = "standealone";
    private static String sdkVersion;
    private static int sdkVersionCode;
    static int sessionErroredApiCalls;

    AnalyticsUtil() {
    }

    static void setup(Context context, String str, String str2, int i, String str3) {
        sdkType = str2;
        sdkVersionCode = i;
        sdkVersion = str3;
        setAppDetails(context, str);
        init(context, str);
    }

    private static void init(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Context not set");
        }
        if (str == null) {
            throw new RuntimeException("Merchant key not set");
        }
        Lumberjack.init(context, sdkType, sdkVersion);
        Lumberjack.addOrderProperty("merchant_key", str);
        Lumberjack.addOrderProperty("merchant_package", context.getPackageName());
        loadCachedCountryCode(context);
        RazorpayExceptionHandler.register(context);
        isAnalyticsInitialized = true;
    }

    private static void loadCachedCountryCode(Context context) {
        try {
            String value = SharedPreferenceUtil.getValue(context, "country_code");
            if (value == null || value.isEmpty()) {
                return;
            }
            Lumberjack.addOrderProperty("country_code", value);
        } catch (Exception unused) {
        }
    }

    static String getBuildType() {
        return BUILD_TYPE;
    }

    static String getKeyType() {
        return KEY_TYPE;
    }

    static void trackEvent(AnalyticsEvent analyticsEvent) {
        analyticsEvent.getEventName();
        Lumberjack.trackEvent(analyticsEvent.getEventName());
    }

    static void postData() {
        if (isAnalyticsInitialized) {
            Lumberjack.postData();
        }
    }

    static void trackEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
        Lumberjack.trackEvent(analyticsEvent.getEventName(), map);
    }

    static void trackEvent(AnalyticsEvent analyticsEvent, JSONObject jSONObject) {
        analyticsEvent.getEventName();
        Lumberjack.trackEvent(analyticsEvent.getEventName(), jSONObject);
    }

    static void trackEventWithMetric(AnalyticsEvent analyticsEvent, JSONObject jSONObject, long j) {
        analyticsEvent.getEventName();
        Lumberjack.trackEventWithMetric(analyticsEvent.getEventName(), jSONObject, j);
    }

    static void addProperty(String str, AnalyticsProperty analyticsProperty) {
        if (analyticsProperty.scope == AnalyticsProperty.Scope.PAYMENT) {
            Lumberjack.addPaymentProperty(str, analyticsProperty.value);
        } else if (analyticsProperty.scope == AnalyticsProperty.Scope.ORDER) {
            Lumberjack.addOrderProperty(str, analyticsProperty.value);
        }
    }

    static void addFilteredPropertiesFromPayload(JSONObject jSONObject) {
        Lumberjack.addFilteredPropertiesFromPayload(jSONObject);
    }

    static String getAppDetail() {
        if (isAnalyticsInitialized) {
            return ((Object) MERCHANT_APP_NAME) + "-" + ((Object) MERCHANT_APP_VERSION) + "-" + MERCHANT_APP_BUILD;
        }
        return null;
    }

    static void trackPage(String str, String str2) {
        Lumberjack.trackPage(str, str2);
    }

    static void reportError(String str, String str2, String str3) {
        Lumberjack.trackErrorEvent(AnalyticsEvent.ERROR_LOGGED.getEventName(), getJSONErrorResponse(str, getErrorProperties(str2, str3)), str2);
        if ((str2.equalsIgnoreCase("S0") || str2.equalsIgnoreCase("S1")) && sessionErroredApiCalls <= 0) {
            Lumberjack.logVajraCritialError(str2);
            sessionErroredApiCalls++;
        }
    }

    static void reportError(AbstractMethodError abstractMethodError, String str, String str2) {
        Lumberjack.trackErrorEvent(AnalyticsEvent.ERROR_LOGGED.getEventName(), getJSONErrorResponse(null, getErrorProperties(str, str2)), str);
        if ((str.equalsIgnoreCase("S0") || str.equalsIgnoreCase("S1")) && sessionErroredApiCalls <= 0) {
            Lumberjack.logVajraCritialError(str);
            sessionErroredApiCalls++;
        }
    }

    static Map<String, Object> getErrorProperties(String str, String str2) {
        HashMap map = new HashMap();
        map.put(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, str);
        map.put("unhandled", Boolean.TRUE);
        map.put("source", "self");
        map.put("stack", "");
        map.put("message", str2);
        return map;
    }

    static JSONObject getAnalyticsDataForCheckout(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "mobile_sdk");
            jSONObject.put("platform_version", sdkVersion);
            jSONObject.put("os", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            if (ResourceUtils.isTablet(context)) {
                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Constants.KEY_IS_TABLET);
                return jSONObject;
            }
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Const.MOBILE);
            return jSONObject;
        } catch (Exception e2) {
            reportError(e2.getLocalizedMessage(), "critical", e2.getMessage());
            return jSONObject;
        }
    }

    static void trackPageLoadStart(String str) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_START : AnalyticsEvent.PAGE_LOAD_START, getJSONResponse(getPageLoadStartProperties(str)));
    }

    static Map<String, Object> getPageLoadStartProperties(String str) {
        HashMap map = new HashMap();
        map.put("url", str);
        return map;
    }

    static void trackPageLoadEnd(String str, long j) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_FINISH : AnalyticsEvent.PAGE_LOAD_FINISH, getJSONResponse(getPageLoadEndProperties(str, j)));
    }

    static boolean isCheckoutUrl(String str) {
        return str.indexOf(CoreConfig.getInstance().getCheckoutEndpoint()) == 0;
    }

    static Map<String, Object> getPageLoadEndProperties(String str, long j) {
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("page_load_time", Double.valueOf(j / 1.0E9d));
        return map;
    }

    static void reset() {
        isAnalyticsInitialized = false;
        localPaymentId = null;
        localOrderId = null;
        Lumberjack.destroy();
    }

    static void setAppDetails(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            MERCHANT_APP_NAME = returnUndefinedIfNull(packageInfo.applicationInfo.loadLabel(packageManager));
            MERCHANT_APP_VERSION = returnUndefinedIfNull(packageInfo.versionName);
            MERCHANT_APP_NAMESPACE = returnUndefinedIfNull(packageInfo.packageName);
            MERCHANT_APP_TARGET_SDK = packageInfo.applicationInfo.targetSdkVersion;
            MERCHANT_APP_BUILD = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            reportError(e2.getMessage(), "S0", e2.getMessage());
        }
        BUILD_TYPE = BaseUtils.getAppBuildType(context);
        KEY_TYPE = getKeyType(str);
    }

    static String getKeyType(String str) {
        if (!isNullOrEmpty(str) && str.length() >= 8) {
            String strSubstring = str.substring(0, 8);
            if (strSubstring.equals("rzp_live")) {
                return "live";
            }
            if (strSubstring.equals("rzp_test")) {
                return Const.TEST;
            }
        }
        return null;
    }

    static boolean isNullOrEmpty(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        while (length > i && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length - i == 0;
    }

    static CharSequence returnUndefinedIfNull(CharSequence charSequence) {
        return isNullOrEmpty(charSequence) ? "undefined" : charSequence;
    }

    static String getLocalPaymentId() {
        if (localPaymentId == null) {
            localPaymentId = getUniqueId();
        }
        return localPaymentId;
    }

    static String getLocalOrderId() {
        if (localOrderId == null) {
            localOrderId = getUniqueId();
        }
        return localOrderId;
    }

    static void refreshPaymentSession() {
        localPaymentId = getUniqueId();
        Lumberjack.clearPaymentProperties();
    }

    static void refreshOrderSession() {
        localOrderId = getUniqueId();
        localPaymentId = getUniqueId();
        Lumberjack.clearOrderProperties();
        Lumberjack.clearPaymentProperties();
    }

    static void setLocalOrderId(String str) {
        localOrderId = str;
    }

    static String getUniqueId() {
        String str = tobase62((System.currentTimeMillis() - 1388534400000L) * 1000000) + tobase62((long) Math.floor(Math.random() * 1.4776336E7d));
        return str.length() > 14 ? str.substring(0, 14) : str;
    }

    static String tobase62(long j) {
        String str = "";
        String[] strArrSplit = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");
        while (j > 0) {
            str = String.valueOf(strArrSplit[(int) (j % 62)]) + str;
            j = (long) Math.floor(j / 62);
        }
        return str;
    }

    static void reportUncaughtException(Throwable th) {
        String stackTrace = getStackTrace(th);
        if (stackTrace.contains(BuildConfig.LIBRARY_PACKAGE_NAME)) {
            HashMap map = new HashMap(getErrorProperties("S0", th.getMessage()));
            Lumberjack.trackExceptionEvent(AnalyticsEvent.EXCEPTION_LOGGED.getEventName(), getJSONResponse(map), sanitizeStackTrace(stackTrace));
        }
    }

    static void reportCaughtException(Throwable th) {
        String stackTrace = getStackTrace(th);
        HashMap map = new HashMap(getErrorProperties("S1", th.getMessage()));
        Lumberjack.trackExceptionEvent(AnalyticsEvent.ERROR_LOGGED.getEventName(), getJSONResponse(map), sanitizeStackTrace(stackTrace));
    }

    static void logCheckoutFunctionEntry(String str, String str2, boolean z) {
        if (z) {
            try {
                HashMap map = new HashMap();
                map.put(com.tv9news.utils.helpers.AnalyticsConstants.class_name, str);
                map.put("function_name", str2);
                trackEvent(AnalyticsEvent.CHECKOUT_FUNCTION_ENTRY, map);
            } catch (Exception unused) {
            }
        }
    }

    static void logCheckoutFunctionExit(String str, String str2, boolean z) {
        if (z) {
            try {
                HashMap map = new HashMap();
                map.put(com.tv9news.utils.helpers.AnalyticsConstants.class_name, str);
                map.put("function_name", str2);
                trackEvent(AnalyticsEvent.CHECKOUT_FUNCTION_EXIT, map);
            } catch (Exception unused) {
            }
        }
    }

    static void logCustomUIFunctionEntry(String str, String str2, boolean z) {
        if (z) {
            try {
                HashMap map = new HashMap();
                map.put(com.tv9news.utils.helpers.AnalyticsConstants.class_name, str);
                map.put("function_name", str2);
                trackEvent(AnalyticsEvent.CUSTOMUI_FUNCTION_ENTRY, map);
            } catch (Exception unused) {
            }
        }
    }

    static void logCustomUIFunctionExit(String str, String str2, boolean z) {
        if (z) {
            try {
                HashMap map = new HashMap();
                map.put(com.tv9news.utils.helpers.AnalyticsConstants.class_name, str);
                map.put("function_name", str2);
                trackEvent(AnalyticsEvent.CUSTOMUI_FUNCTION_EXIT, map);
            } catch (Exception unused) {
            }
        }
    }

    static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    static String sanitizeStackTrace(String str) {
        if (isNullOrEmpty(str)) {
            return "";
        }
        try {
            String[] strArrSplit = str.split("\n");
            StringBuilder sb = new StringBuilder();
            int iMin = Math.min(strArrSplit.length, 20);
            int i = 0;
            while (true) {
                if (i >= iMin) {
                    break;
                }
                String str2 = strArrSplit[i];
                if (!str2.trim().isEmpty()) {
                    String strReplaceAll = str2.replaceAll("\\b[a-zA-Z0-9_-]{32,}\\b", "<token>").replaceAll("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", "<email>").replaceAll("\\b\\d{13,19}\\b", "****").replaceAll("\\b\\d{10,12}\\b", "<phone>");
                    if (strReplaceAll.length() > 500) {
                        strReplaceAll = strReplaceAll.substring(0, 497) + "...";
                    }
                    sb.append(strReplaceAll).append("\n");
                    if (sb.length() > 5000) {
                        sb.append("... (truncated for size)");
                        break;
                    }
                }
                i++;
            }
            return sb.toString().trim();
        } catch (Exception e2) {
            return "Stack trace sanitization failed: " + e2.getClass().getSimpleName();
        }
    }

    static void setFramework(String str) {
        FRAMEWORK = str;
    }

    static String getFramework() {
        return isNullOrEmpty(FRAMEWORK) ? AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE : FRAMEWORK;
    }

    public static void saveEventsToPreferences(Context context) {
        Lumberjack.saveEventsToPreferences(context);
    }

    public static JSONObject getExtraAnalyticsPayload() {
        return Lumberjack.getContextPayload();
    }

    public static JSONObject getJSONResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SaslNonza.Response.ELEMENT, str);
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject getJSONResponse(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                reportError(e2.getLocalizedMessage(), "S0", "Error adding analytics property " + entry.getKey() + " to JSONObject");
            }
        }
        return jSONObject;
    }

    public static JSONObject getJSONErrorResponse(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, map.get(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY));
            jSONObject3.put("unhandled", map.get("unhandled"));
            jSONObject3.put("source", map.get("source"));
            JSONObject jSONObject4 = new JSONObject();
            if (str == null) {
                jSONObject4.put("stack", "AbstractMethodError");
            } else {
                jSONObject4.put("stack", str);
            }
            jSONObject4.put("message", map.get("message"));
            jSONObject4.put("tags", jSONObject3);
            jSONObject2.put("error", jSONObject4);
            jSONObject.put("data", jSONObject2);
            return jSONObject;
        } catch (JSONException e2) {
            reportError(e2.getLocalizedMessage(), "S0", "Error adding analytics property " + map.get("message") + " to JSONObject");
            return jSONObject;
        }
    }
}
