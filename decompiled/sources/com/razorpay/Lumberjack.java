package com.razorpay;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.network.api.CtApi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsProperty;
import com.x5.template.ThemeConfig;
import datamodels.PWEStaticDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
final class Lumberjack {
    private static final String ALLOWLIST_DEFAULT_KEYWORD = "default";
    private static final int AUTO_FLUSH_THRESHOLD = 10;
    private static final Map<String, Set<String>> DEDUP_MERGE_KEYS;
    private static final Set<String> DEFAULT_ALLOWED_EVENTS;
    private static boolean NETWORK_BLUETOOTH = false;
    private static String NETWORK_CARRIER = null;
    private static boolean NETWORK_CELLULAR = false;
    private static String NETWORK_CELLULAR_TYPE = null;
    private static boolean NETWORK_WIFI = false;
    private static final String SAVED_EVENTS_DATA = "SavedEventsData";
    private static float SCREEN_DENSITY = 0.0f;
    private static int SCREEN_HEIGHT = 0;
    private static int SCREEN_WIDTH = 0;
    private static final int TIME_FLUSH_INTERVAL_SECONDS = 10;
    private static JSONObject contextJsonData;
    private static String deviceUuid;
    private static ScheduledExecutorService flushScheduler;
    private static JSONObject lumberjackPayload;
    private static ScheduledFuture<?> scheduledFlushTask;
    private static String sdkVersion;
    private static final Object timerLock = new Object();
    private static String DEVICE_MANUFACTURER = Build.MANUFACTURER;
    private static String DEVICE_MODEL = Build.MODEL;
    private static String DEVICE_NAME = Build.DEVICE;
    private static boolean isLumberjackInitialized = false;
    private static String sdkType = "standalone";
    private static ArrayList<JSONObject> preInitBatch = new ArrayList<>();
    private static Map<String, Object> paymentProperties = new ConcurrentHashMap();
    private static Map<String, Object> orderProperties = new ConcurrentHashMap();
    private static final Set<String> DEDUP_EVENTS = new HashSet(Arrays.asList(AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_START.getEventName(), AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_SUCCESS.getEventName(), AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI.getEventName(), AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_START.getEventName(), AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_SUCCESS.getEventName(), AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_RECEIVED_SMS.getEventName(), AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_SHOWED_ONE_TIME_CONSENT.getEventName(), AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TIMEOUT.getEventName(), AnalyticsEvent.PHONE_NUMBER_HINT_INTENT_LAUNCH_FAILED.getEventName(), AnalyticsEvent.WEB_VIEW_PRIMARY_TO_SECONDARY_SWITCH.getEventName(), AnalyticsEvent.WEB_VIEW_SECONDARY_TO_PRIMARY_SWITCH.getEventName(), AnalyticsEvent.CHECKOUT_HARD_BACK_PRESSED.getEventName()));
    private static Map<String, Integer> dedupAttemptCount = new ConcurrentHashMap();

    Lumberjack() {
    }

    static {
        HashMap map = new HashMap();
        DEDUP_MERGE_KEYS = map;
        map.put(AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_SUCCESS.getEventName(), new HashSet(Arrays.asList("deviceApps")));
        map.put(AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_SUCCESS.getEventName(), new HashSet(Arrays.asList("allUpiDeviceApps")));
        map.put(AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_START.getEventName(), new HashSet());
        map.put(AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_START.getEventName(), new HashSet());
        map.put(AnalyticsEvent.CUSTOM_UI_GET_APPS_SUPPORTING_UPI.getEventName(), new HashSet());
        map.put(AnalyticsEvent.CHECKOUT_HARD_BACK_PRESSED.getEventName(), new HashSet());
        map.put(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_RECEIVED_SMS.getEventName(), new HashSet());
        map.put(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_SHOWED_ONE_TIME_CONSENT.getEventName(), new HashSet());
        map.put(AnalyticsEvent.AUTO_READ_OTP_SMS_RETRIEVER_API_TIMEOUT.getEventName(), new HashSet());
        map.put(AnalyticsEvent.PHONE_NUMBER_HINT_INTENT_LAUNCH_FAILED.getEventName(), new HashSet());
        map.put(AnalyticsEvent.WEB_VIEW_PRIMARY_TO_SECONDARY_SWITCH.getEventName(), new HashSet());
        map.put(AnalyticsEvent.WEB_VIEW_SECONDARY_TO_PRIMARY_SWITCH.getEventName(), new HashSet());
        HashSet hashSet = new HashSet();
        DEFAULT_ALLOWED_EVENTS = hashSet;
        hashSet.add(AnalyticsEvent.CUSTOM_UI_INIT_END.getEventName());
        hashSet.add(AnalyticsEvent.FETCH_PREFERENCES_CALLED.getEventName());
        hashSet.add(AnalyticsEvent.FETCH_PREFERENCES_CALL_SUCCESS.getEventName());
        hashSet.add(AnalyticsEvent.FETCH_PREFERENCES_METHODS_CALL_FAIL.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_SUBMIT_START.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_PAYLOAD_PASSED.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_TLS_ERROR.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_CALLED.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_UPI_APP_LAUNCHED.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_NATIVE_INTENT_ONACTIVITY_RESULT.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_PAYMENT_COMPLETE.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_HARD.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_BACK_PRESSED_SOFT.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_START.getEventName());
        hashSet.add(AnalyticsEvent.CUSTOM_UI_UPI_APPS_DISCOVERY_SUCCESS.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_INIT.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_LOADED.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_SUBMIT.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_PAYMENT_COMPLETE.getEventName());
        hashSet.add(AnalyticsEvent.CALLING_ON_SUCCESS.getEventName());
        hashSet.add(AnalyticsEvent.CALLING_ON_ERROR.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_SOFT_BACK_PRESSED.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_HARD_BACK_PRESSED.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_JS_DISMISSED.getEventName());
        hashSet.add(AnalyticsEvent.ACTIVITY_ONDESTROY_CALLED.getEventName());
        hashSet.add(AnalyticsEvent.CHECKOUT_TLS_ERROR.getEventName());
        hashSet.add(AnalyticsEvent.WEBVIEW_CREATION_FAILED.getEventName());
        hashSet.add(AnalyticsEvent.WEBVIEW_RENDERER_CRASHED.getEventName());
        hashSet.add(AnalyticsEvent.WEB_VIEW_NETWORK_ERROR_RETRY.getEventName());
        hashSet.add(AnalyticsEvent.WEB_VIEW_NETWORK_RETRY_EXHAUSTED.getEventName());
        hashSet.add(AnalyticsEvent.WEB_VIEW_NETWORK_ERROR.getEventName());
        hashSet.add(AnalyticsEvent.WEB_VIEW_SECONDARY_NETWORK_ERROR.getEventName());
    }

    private static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    private static CharSequence getUserAgent() {
        return AnalyticsUtil.returnUndefinedIfNull(System.getProperty("http.agent"));
    }

    private static CharSequence getTimeZone() {
        return AnalyticsUtil.returnUndefinedIfNull(TimeZone.getDefault().getID());
    }

    private static void setNetworkDetails(Context context) {
        NETWORK_CELLULAR_TYPE = BaseUtils.getCellularNetworkType(context);
        NETWORK_CARRIER = BaseUtils.getCellularNetworkProviderName(context);
        int i = AnonymousClass3.$SwitchMap$com$razorpay$NetworkType[BaseUtils.getDataNetworkType(context).ordinal()];
        if (i == 1) {
            NETWORK_WIFI = true;
        } else if (i == 2) {
            NETWORK_CELLULAR = true;
        } else {
            if (i != 3) {
                return;
            }
            NETWORK_BLUETOOTH = true;
        }
    }

    /* JADX INFO: renamed from: com.razorpay.Lumberjack$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$razorpay$NetworkType;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$com$razorpay$NetworkType = iArr;
            try {
                iArr[NetworkType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$razorpay$NetworkType[NetworkType.CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$razorpay$NetworkType[NetworkType.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void setDisplayDetails(Context context) {
        Display defaultDisplay = ((WindowManager) BaseUtils.getSystemService(context, "window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        SCREEN_DENSITY = displayMetrics.density;
        SCREEN_HEIGHT = displayMetrics.heightPixels;
        SCREEN_WIDTH = displayMetrics.widthPixels;
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private static String getEventType() {
        if ("custom".equalsIgnoreCase(sdkType)) {
            return "checkout-custom";
        }
        return "checkout";
    }

    private static String getSource() {
        if ("custom".equalsIgnoreCase(sdkType)) {
            return "customui_android";
        }
        return "checkout_android";
    }

    private static String getCreatedDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    private static String getMerchantKeyForUrl() {
        Object obj = orderProperties.get("merchant_key");
        return obj != null ? obj.toString() : "";
    }

    private static JSONObject getDeviceDataJson(Context context) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", BaseConfig.getAdvertisingId(context));
        jSONObject.put(Const.manufacturer, DEVICE_MANUFACTURER);
        jSONObject.put("model", DEVICE_MODEL);
        jSONObject.put("name", DEVICE_NAME);
        jSONObject.put("type", "phone");
        jSONObject.put("version", CtApi.DEFAULT_QUERY_PARAM_OS + Build.VERSION.RELEASE);
        jSONObject.put(DEVICE_MANUFACTURER, Build.MANUFACTURER);
        jSONObject.put(DEVICE_MODEL, Build.MODEL);
        jSONObject.put("device_size", BaseUtils.getDisplayWidth(context) + "w X " + BaseUtils.getDisplayHeight(context) + "h");
        jSONObject.put("device_resolution", BaseUtils.getDisplayResolution(context));
        long totalRamMB = BaseUtils.getTotalRamMB(context);
        jSONObject.put("total_ram_mb", totalRamMB);
        jSONObject.put("free_ram_mb", BaseUtils.getFreeRamMB(context));
        jSONObject.put("cpu_cores", BaseUtils.getCpuCores());
        jSONObject.put("performance_class", PerformanceUtil.getPerformanceClass(context));
        jSONObject.put("is_low_end_device", PerformanceUtil.isLowEndDevice(context));
        jSONObject.put("power_save_mode", BaseUtils.isPowerSaveMode(context));
        jSONObject.put("battery_level", BaseUtils.getBatteryLevel(context));
        jSONObject.put("is_charging", BaseUtils.isCharging(context));
        jSONObject.put("is_low_ram_device", totalRamMB <= 4096);
        jSONObject.put("gpu_renderer", GpuInfoUtil.getGpuRenderer());
        jSONObject.put("gpu_vendor", GpuInfoUtil.getGpuVendor());
        return jSONObject;
    }

    private static JSONObject getSdkDataJson() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", sdkVersion);
        jSONObject.put("platform", "android");
        jSONObject.put("type", sdkType);
        jSONObject.put("framework", AnalyticsUtil.getFramework());
        jSONObject.put("name", sdkType + "_android_" + AnalyticsUtil.getFramework());
        return jSONObject;
    }

    private static JSONObject getNetworkDataJson(Context context) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bluetooth", NETWORK_BLUETOOTH);
        jSONObject.put("carrier", NETWORK_CARRIER);
        jSONObject.put("cellular", NETWORK_CELLULAR);
        jSONObject.put("cellular_network_type", NETWORK_CELLULAR_TYPE);
        jSONObject.put(Constants.CLTAP_CONNECTED_TO_WIFI, NETWORK_WIFI);
        jSONObject.put("carrier_network", BaseUtils.getCarrierOperatorName(context));
        jSONObject.put(com.tv9news.utils.helpers.AnalyticsConstants.NETWORK_TYPE, BaseUtils.getNetworkType(context));
        jSONObject.put(Const.LAST_IP_ADDRESS, BaseUtils.ipAddress);
        jSONObject.put("is_roming", BaseUtils.isNetworkRoaming(context));
        Map<String, String> deviceAttributes = BaseUtils.getDeviceAttributes(context);
        jSONObject.put("device_Id", deviceAttributes.get("device_Id"));
        String str = DEVICE_MANUFACTURER;
        jSONObject.put(str, deviceAttributes.get(str));
        String str2 = DEVICE_MODEL;
        jSONObject.put(str2, deviceAttributes.get(str2));
        return jSONObject;
    }

    private static JSONObject getScreenDataJson() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("density", SCREEN_DENSITY);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, SCREEN_WIDTH);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, SCREEN_HEIGHT);
        return jSONObject;
    }

    private static JSONObject getContextDataJson(Context context) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mode", AnalyticsUtil.getKeyType());
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, getDeviceDataJson(context));
        jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, getSdkDataJson());
        jSONObject.put("network", getNetworkDataJson(context));
        jSONObject.put("screen", getScreenDataJson());
        jSONObject.put(ThemeConfig.LOCALE, BaseUtils.getLocale());
        jSONObject.put("timezone", getTimeZone());
        jSONObject.put("framework", sdkType + "_android_" + AnalyticsUtil.getFramework());
        jSONObject.put("user_agent", getUserAgent());
        jSONObject.put("checkout_id", AnalyticsUtil.getLocalOrderId());
        jSONObject.put("local_order_id", AnalyticsUtil.getLocalOrderId());
        jSONObject.put("webview_user_agent", BaseUtils.getWebViewUserAgent(context));
        return jSONObject;
    }

    static void setBaseImportJSON(Context context) {
        try {
            setNetworkDetails(context);
            setDisplayDetails(context);
            GpuInfoUtil.loadFromCache(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", CoreConfig.getInstance().getLumberjackKey());
            jSONObject.put("events", new JSONArray());
            JSONObject contextDataJson = getContextDataJson(context);
            contextJsonData = contextDataJson;
            jSONObject.put("context", contextDataJson);
            jSONObject.put("mode", "live");
            lumberjackPayload = jSONObject;
            makeSessionApiPostRequest(getSessionCreatedJson());
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error in creating BaseImportJSON");
            lumberjackPayload = new JSONObject();
        }
    }

    static void updateGpuInfo() {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (contextJsonData == null || !GpuInfoUtil.isGpuInfoAvailable() || (jSONObjectOptJSONObject = contextJsonData.optJSONObject(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) == null) {
                return;
            }
            jSONObjectOptJSONObject.put("gpu_renderer", GpuInfoUtil.getGpuRenderer());
            jSONObjectOptJSONObject.put("gpu_vendor", GpuInfoUtil.getGpuVendor());
            GpuInfoUtil.getGpuRenderer();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", "Error updating GPU info in context");
        }
    }

    private static void addToBatch(JSONObject jSONObject) {
        int length;
        int iIntValue;
        if (!isLumberjackInitialized) {
            preInitBatch.add(jSONObject);
            return;
        }
        try {
            JSONObject jSONObjectAddGlobalProperties = addGlobalProperties(jSONObject);
            String strOptString = jSONObjectAddGlobalProperties.optString("event", "");
            if (DEDUP_EVENTS.contains(strOptString) && (iIntValue = dedupAttemptCount.merge(strOptString, 1, new BiFunction() { // from class: com.razorpay.Lumberjack$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
                }
            }).intValue()) > 1) {
                if (mergeIntoBatchedEvent(strOptString, jSONObjectAddGlobalProperties, iIntValue)) {
                    return;
                } else {
                    jSONObjectAddGlobalProperties.put("attempt", iIntValue);
                }
            }
            synchronized (lumberjackPayload) {
                JSONArray jSONArray = lumberjackPayload.getJSONArray("events");
                jSONArray.put(jSONObjectAddGlobalProperties);
                length = jSONArray.length();
            }
            if (length == 1) {
                startFlushTimer();
            }
            if (length >= 10) {
                postData();
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
        }
    }

    private static boolean mergeIntoBatchedEvent(String str, JSONObject jSONObject, int i) {
        JSONArray jSONArray;
        int i2;
        synchronized (lumberjackPayload) {
            try {
                try {
                    jSONArray = lumberjackPayload.getJSONArray("events");
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error merging dedup event properties");
                }
                for (i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (str.equals(jSONObject2.optString("event"))) {
                        Set<String> set = DEDUP_MERGE_KEYS.get(str);
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(JivePropertiesExtension.ELEMENT);
                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(JivePropertiesExtension.ELEMENT);
                        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null && set != null) {
                            String str2 = "attempt" + i + "_";
                            for (String str3 : set) {
                                if (jSONObjectOptJSONObject2.has(str3)) {
                                    jSONObjectOptJSONObject.put(str2 + str3, jSONObjectOptJSONObject2.get(str3));
                                }
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void addPaymentProperty(String str, Object obj) {
        paymentProperties.put(str, obj);
    }

    static void addOrderProperty(String str, Object obj) {
        orderProperties.put(str, obj);
    }

    static JSONObject createBaseTrackEvent(String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            jSONObject.put("timestamp", jCurrentTimeMillis);
            return jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error in creating base for trackEvent");
            return null;
        }
    }

    static void trackEvent(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error adding analytics property " + entry.getKey() + " to JSONObject");
            }
        }
        trackEvent(str, jSONObject);
    }

    static void trackEvent(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectCreateBaseTrackEvent = createBaseTrackEvent(str);
            if (jSONObjectCreateBaseTrackEvent == null) {
                jSONObjectCreateBaseTrackEvent = new JSONObject();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("local_order_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("checkout_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("local_payment_id", AnalyticsUtil.getLocalPaymentId());
            jSONObjectCreateBaseTrackEvent.put(JivePropertiesExtension.ELEMENT, jSONObject);
            addToBatch(jSONObjectCreateBaseTrackEvent);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error in adding properties to base json for event tracking");
        }
    }

    static void trackEvent(String str) {
        trackEvent(str, new JSONObject());
    }

    static void trackErrorEvent(String str, JSONObject jSONObject, String str2) {
        trackEventWithValue(str, jSONObject, str2);
    }

    static void trackExceptionEvent(String str, JSONObject jSONObject, String str2) {
        trackEventWithValue(str, jSONObject, str2);
    }

    private static void trackEventWithValue(String str, JSONObject jSONObject, String str2) {
        try {
            JSONObject jSONObjectCreateBaseTrackEvent = createBaseTrackEvent(str);
            if (jSONObjectCreateBaseTrackEvent == null) {
                jSONObjectCreateBaseTrackEvent = new JSONObject();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("local_order_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("checkout_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("local_payment_id", AnalyticsUtil.getLocalPaymentId());
            jSONObjectCreateBaseTrackEvent.put(JivePropertiesExtension.ELEMENT, jSONObject);
            if (str2 != null && !str2.isEmpty()) {
                jSONObjectCreateBaseTrackEvent.put("value", str2);
            }
            addToBatch(jSONObjectCreateBaseTrackEvent);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error in tracking event with value/content");
        }
    }

    static void trackEventWithMetric(String str, JSONObject jSONObject, long j) {
        try {
            JSONObject jSONObjectCreateBaseTrackEvent = createBaseTrackEvent(str);
            if (jSONObjectCreateBaseTrackEvent == null) {
                jSONObjectCreateBaseTrackEvent = new JSONObject();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("local_order_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("checkout_id", AnalyticsUtil.getLocalOrderId());
            jSONObject.put("local_payment_id", AnalyticsUtil.getLocalPaymentId());
            jSONObjectCreateBaseTrackEvent.put(JivePropertiesExtension.ELEMENT, jSONObject);
            jSONObjectCreateBaseTrackEvent.put("metric", j);
            addToBatch(jSONObjectCreateBaseTrackEvent);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error in tracking event with metric");
        }
    }

    static void trackPage(String str, String str2) {
        HashMap map = new HashMap();
        map.put("url", str2);
        trackEvent("Viewed " + str + " Page", map);
    }

    static JSONObject addGlobalProperties(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.has(JivePropertiesExtension.ELEMENT) ? jSONObject.getJSONObject(JivePropertiesExtension.ELEMENT) : null;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("merchant_app_name", AnalyticsUtil.MERCHANT_APP_NAME);
            jSONObject2.put("merchant_app_version", AnalyticsUtil.MERCHANT_APP_VERSION);
            jSONObject2.put("merchant_app_package", AnalyticsUtil.MERCHANT_APP_NAMESPACE);
            jSONObject2.put("merchant_app_target_sdk", AnalyticsUtil.MERCHANT_APP_TARGET_SDK);
            jSONObject2.put("merchant_app_build", AnalyticsUtil.MERCHANT_APP_BUILD);
            jSONObject2.put("platform", "mobile_sdk");
            jSONObject2.put("platform_version", sdkVersion);
            jSONObject2.put("os", "android");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("library", AnalyticsUtil.libraryType);
            for (Map.Entry<String, Object> entry : paymentProperties.entrySet()) {
                try {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error adding analytics property " + entry.getKey() + " to JSONObject");
                }
            }
            for (Map.Entry<String, Object> entry2 : orderProperties.entrySet()) {
                try {
                    jSONObject2.put(entry2.getKey(), entry2.getValue());
                } catch (Exception e3) {
                    AnalyticsUtil.reportError(e3.getMessage(), "S0", "Error adding analytics property " + entry2.getKey() + " to JSONObject");
                }
            }
            jSONObject.put(JivePropertiesExtension.ELEMENT, jSONObject2);
            if (CoreConfig.getInstance().isLumberjackV2Enabled().booleanValue()) {
                jSONObject.put("event_type", getEventType());
                jSONObject.put("event_version", "v2");
                jSONObject.put("origin", getSource());
                jSONObject.put("uuid", deviceUuid);
                jSONObject.put("checkout_id", AnalyticsUtil.getLocalOrderId());
                jSONObject.put("build_id", sdkVersion);
                jSONObject.put("platform", 2L);
                jSONObject.put("env", 1L);
                jSONObject.put("os_version", Build.VERSION.RELEASE);
                jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                Object obj = orderProperties.get("merchant_key");
                if (obj != null) {
                    jSONObject.put("merchant_key", obj.toString());
                }
                jSONObject.put("merchant_id", "");
                Object obj2 = orderProperties.get("order_id");
                if (obj2 != null) {
                    jSONObject.put("order_id", obj2.toString());
                }
                Object obj3 = paymentProperties.get(FirebaseAnalytics.Param.METHOD);
                if (obj3 != null) {
                    jSONObject.put(FirebaseAnalytics.Param.METHOD, obj3.toString());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    static void postData() {
        synchronized (lumberjackPayload) {
            JSONObject jSONObjectFilterPayload = filterPayload(lumberjackPayload);
            lumberjackPayload = jSONObjectFilterPayload;
            makePostRequest(jSONObjectFilterPayload);
        }
        clearEvents();
    }

    private static void makePostRequest(JSONObject jSONObject) {
        try {
            if (!CoreConfig.getInstance().isLumberjackEnabled().booleanValue() || CoreConfig.getInstance().isVersionBlocked(sdkVersion) || jSONObject.getJSONArray("events").length() == 0) {
                return;
            }
            HashMap map = new HashMap();
            map.put("x-identifier", CoreConfig.getInstance().getLumberjackSdkIdentifier());
            map.put("Content-Type", "application/json");
            String string = jSONObject.toString();
            String merchantKeyForUrl = getMerchantKeyForUrl();
            String trackUrl = GlobalUrlConfig.instance().getTrackUrl();
            if (!merchantKeyForUrl.isEmpty()) {
                trackUrl = trackUrl + "?key_id=" + merchantKeyForUrl;
            }
            Owl.post(trackUrl, string, map, new Callback() { // from class: com.razorpay.Lumberjack.1
                @Override // com.razorpay.Callback
                public void run(ResponseObject responseObject) {
                    responseObject.getResponseResult();
                }
            });
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "makePostRequest: failed to read events array");
        }
    }

    private static void clearEvents() {
        try {
            JSONObject jSONObject = lumberjackPayload;
            if (jSONObject == null) {
                return;
            }
            synchronized (jSONObject) {
                lumberjackPayload.put("events", new JSONArray());
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
        }
    }

    static void init(Context context, String str, String str2) {
        stopFlushTimer();
        sdkType = str;
        sdkVersion = str2;
        deviceUuid = BaseConfig.getAdvertisingId(context);
        dedupAttemptCount.clear();
        setBaseImportJSON(context);
        isLumberjackInitialized = true;
        addQueuedDataToBatch();
        transmitSavedEvents(context);
    }

    static void transmitSavedEvents(Context context) {
        String protectedValue = SharedPreferenceUtil.getProtectedValue(context, SAVED_EVENTS_DATA, null);
        if (protectedValue == null || protectedValue.isEmpty()) {
            return;
        }
        try {
            makePostRequest(new JSONObject(protectedValue));
            SharedPreferenceUtil.removeValue(context, SAVED_EVENTS_DATA);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
        }
    }

    private static void addQueuedDataToBatch() {
        Iterator<JSONObject> it = preInitBatch.iterator();
        while (it.hasNext()) {
            addToBatch(it.next());
        }
        clearPreInitData();
    }

    private static void clearPreInitData() {
        preInitBatch = new ArrayList<>();
    }

    private static void addPropertyFromJSONObject(JSONObject jSONObject, String str, AnalyticsProperty.Scope scope) {
        try {
            Object valueFromJsonObject = getValueFromJsonObject(jSONObject, str);
            if (valueFromJsonObject != null) {
                if (scope == AnalyticsProperty.Scope.PAYMENT) {
                    addPaymentProperty(str, valueFromJsonObject);
                } else if (scope == AnalyticsProperty.Scope.ORDER) {
                    addOrderProperty(str, valueFromJsonObject);
                }
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    static Object getValueFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.get(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            return null;
        }
    }

    static String getStringFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            return null;
        }
    }

    static boolean getBooleanFromJsonObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            return false;
        }
    }

    static void addAmountToProperties(JSONObject jSONObject) {
        try {
            addOrderProperty("amount", Long.valueOf(Long.parseLong(getStringFromJsonObject(jSONObject, "amount"))));
        } catch (Exception unused) {
        }
    }

    static void addFrameworkToProperties(JSONObject jSONObject) {
        try {
            addOrderProperty("framework", jSONObject.has("framework") ? getStringFromJsonObject(jSONObject, "framework") : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
        } catch (Exception unused) {
        }
    }

    static void addFilteredPropertiesFromPayload(JSONObject jSONObject) {
        try {
            addAmountToProperties(jSONObject);
            addFrameworkToProperties(jSONObject);
            addPropertyFromJSONObject(jSONObject, "contact", AnalyticsProperty.Scope.ORDER);
            addPropertyFromJSONObject(jSONObject, "email", AnalyticsProperty.Scope.ORDER);
            addPropertyFromJSONObject(jSONObject, "order_id", AnalyticsProperty.Scope.ORDER);
            String stringFromJsonObject = getStringFromJsonObject(jSONObject, FirebaseAnalytics.Param.METHOD);
            if (stringFromJsonObject == null) {
                return;
            }
            if (jSONObject.has("token")) {
                stringFromJsonObject = "saved card";
            }
            addPaymentProperty(FirebaseAnalytics.Param.METHOD, stringFromJsonObject);
            if (stringFromJsonObject.equals("card")) {
                String stringFromJsonObject2 = getStringFromJsonObject(jSONObject, "card[number]");
                if (AnalyticsUtil.isNullOrEmpty(stringFromJsonObject2) || stringFromJsonObject2.length() < 6) {
                    return;
                }
                addPaymentProperty("card_number", stringFromJsonObject2.substring(0, 6));
                return;
            }
            if (stringFromJsonObject.equals("saved card")) {
                addOrderProperty("Checkout Login", new StringBuilder().append(!getBooleanFromJsonObject(jSONObject, "razorpay_otp")).toString());
            } else if (stringFromJsonObject.equals("netbanking")) {
                addPropertyFromJSONObject(jSONObject, "bank", AnalyticsProperty.Scope.PAYMENT);
            } else if (stringFromJsonObject.equals("wallet")) {
                addPropertyFromJSONObject(jSONObject, "wallet", AnalyticsProperty.Scope.PAYMENT);
            } else if (stringFromJsonObject.equals(PWEStaticDataModel.PAYOPT_UPI_CODE)) {
                addPaymentProperty("flow", getStringFromJsonObject(jSONObject, "_[flow]"));
            }
        } catch (Exception e2) {
            e2.getMessage();
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    static void destroy() {
        stopFlushTimer();
        shutdownScheduler();
        clearOrderProperties();
        clearPaymentProperties();
        clearEventData();
        dedupAttemptCount.clear();
        isLumberjackInitialized = false;
    }

    static void clearPaymentProperties() {
        paymentProperties = new ConcurrentHashMap();
    }

    static void clearOrderProperties() {
        orderProperties = new ConcurrentHashMap();
    }

    private static void clearEventData() {
        clearEvents();
        clearPreInitData();
    }

    private static void startFlushTimer() {
        if (isLumberjackInitialized) {
            synchronized (timerLock) {
                ScheduledFuture<?> scheduledFuture = scheduledFlushTask;
                if (scheduledFuture == null || scheduledFuture.isCancelled() || scheduledFlushTask.isDone()) {
                    ScheduledExecutorService scheduledExecutorService = flushScheduler;
                    if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                        flushScheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.razorpay.Lumberjack$$ExternalSyntheticLambda1
                            @Override // java.util.concurrent.ThreadFactory
                            public final Thread newThread(Runnable runnable) {
                                return Lumberjack.lambda$startFlushTimer$0(runnable);
                            }
                        });
                    }
                    scheduledFlushTask = flushScheduler.scheduleWithFixedDelay(new Runnable() { // from class: com.razorpay.Lumberjack$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Lumberjack.timedFlush();
                        }
                    }, 10L, 10L, TimeUnit.SECONDS);
                }
            }
        }
    }

    static /* synthetic */ Thread lambda$startFlushTimer$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "Lumberjack-FlushTimer");
        thread.setDaemon(true);
        return thread;
    }

    private static void stopFlushTimer() {
        synchronized (timerLock) {
            ScheduledFuture<?> scheduledFuture = scheduledFlushTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                scheduledFlushTask = null;
            }
        }
    }

    private static void shutdownScheduler() {
        synchronized (timerLock) {
            ScheduledExecutorService scheduledExecutorService = flushScheduler;
            if (scheduledExecutorService != null) {
                try {
                    scheduledExecutorService.shutdownNow();
                } catch (Exception unused) {
                }
                flushScheduler = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void timedFlush() {
        int length;
        if (!isLumberjackInitialized) {
            stopFlushTimer();
            return;
        }
        try {
            synchronized (lumberjackPayload) {
                JSONArray jSONArrayOptJSONArray = lumberjackPayload.optJSONArray("events");
                length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
            }
            if (length > 0) {
                postData();
            }
            synchronized (lumberjackPayload) {
                JSONArray jSONArrayOptJSONArray2 = lumberjackPayload.optJSONArray("events");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() == 0) {
                    stopFlushTimer();
                }
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", "Error in timed flush");
        }
    }

    static JSONObject filterPayload(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            String lumberjackAllowedEventsRegex = CoreConfig.getInstance().getLumberjackAllowedEventsRegex();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            if (lumberjackAllowedEventsRegex == null || lumberjackAllowedEventsRegex.trim().isEmpty()) {
                while (i < jSONArray.length()) {
                    jSONArray2.put(filterEvent(jSONArray.getJSONObject(i)));
                    i++;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : lumberjackAllowedEventsRegex.split(Constants.SEPARATOR_COMMA)) {
                    String strTrim = str.trim();
                    if ("default".equals(strTrim)) {
                        arrayList.addAll(DEFAULT_ALLOWED_EVENTS);
                    } else if (!strTrim.isEmpty()) {
                        arrayList.add(strTrim);
                    }
                }
                while (i < jSONArray.length()) {
                    JSONObject jSONObjectFilterEvent = filterEvent(jSONArray.getJSONObject(i));
                    if (isEventAllowed(jSONObjectFilterEvent.optString("event", ""), arrayList)) {
                        jSONArray2.put(jSONObjectFilterEvent);
                    }
                    i++;
                }
            }
            jSONObject.put("events", jSONArray2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static boolean isEventAllowed(String str, List<String> list) {
        for (String str2 : list) {
            try {
                if (!str2.contains(")+") && !str2.contains(")*") && !str2.contains(")?") && !str2.contains("}+") && !str2.contains("}*") && str.matches(str2)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static JSONObject filterEvent(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(JivePropertiesExtension.ELEMENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(JivePropertiesExtension.ELEMENT);
            if (jSONObject2.has("url")) {
                jSONObject2.put("url", filterUrl(jSONObject2.getString("url")));
            }
            jSONObject.put(JivePropertiesExtension.ELEMENT, jSONObject2);
        }
        return jSONObject;
    }

    static String filterUrl(String str) {
        return str.startsWith("data:") ? "Data present in url" : str;
    }

    static JSONObject getLumberjackPayload() {
        return lumberjackPayload;
    }

    static JSONObject getContextPayload() {
        return contextJsonData;
    }

    static ArrayList<JSONObject> getPreInitBatch() {
        return preInitBatch;
    }

    static Map<String, Object> getPaymentProperties() {
        return paymentProperties;
    }

    static Map<String, Object> getOrderProperties() {
        return orderProperties;
    }

    static void saveEventsToPreferences(Context context) {
        synchronized (lumberjackPayload) {
            SharedPreferenceUtil.setProtectedValue(context, SAVED_EVENTS_DATA, filterPayload(lumberjackPayload).toString(), sdkVersion);
        }
    }

    static JSONObject getSessionCreatedJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", CoreConfig.getInstance().getLumberjackKey());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "checkout.mobile.sessionCreated.metrics");
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", "session_created");
            jSONObject3.put("platform", "android");
            jSONObject3.put("framework", sdkType + "_android_" + AnalyticsUtil.getFramework());
            jSONArray2.put(jSONObject3);
            jSONObject2.put("labels", jSONArray2);
            jSONArray.put(jSONObject2);
            jSONObject.put("metrics", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return jSONObject;
        }
    }

    static JSONObject getSessionErroredJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", CoreConfig.getInstance().getLumberjackKey());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "checkout.mobile.sessionErrored.metrics");
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", "session_errored");
            jSONObject3.put("platform", "android");
            jSONObject3.put("framework", sdkType + "_android_" + AnalyticsUtil.getFramework());
            jSONObject3.put(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, str);
            jSONArray2.put(jSONObject3);
            jSONObject2.put("labels", jSONArray2);
            jSONArray.put(jSONObject2);
            jSONObject.put("metrics", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return jSONObject;
        }
    }

    static void logVajraCritialError(String str) {
        makeSessionApiPostRequest(getSessionErroredJson(str));
    }

    private static void makeSessionApiPostRequest(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("accept", "application/json");
        map.put("content-type", "applications/json");
        Owl.post("https://lumberjack-metrics.razorpay.com/v1/frontend-metrics", jSONObject.toString(), map, new Callback() { // from class: com.razorpay.Lumberjack.2
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                responseObject.getResponseResult();
            }
        });
    }
}
