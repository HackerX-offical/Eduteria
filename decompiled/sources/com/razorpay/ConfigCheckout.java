package com.razorpay;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class ConfigCheckout extends BaseConfig {
    static String CONFIG_AUTH_KEY = "2HujvzmUo2nuRLLqhIHIV4sCEmRw9FIc";
    static String CONFIG_VERSION = "3.0.5";
    private static final Object INIT_LOCK = new Object();
    static boolean IS_MAGIC_ENABLED = true;
    static String SDK_TYPE = "standard";
    static String SDK_VERSION = "1.7.14";
    static int SDK_VERSION_CODE = 1714;
    private static ConfigCheckout sConfig = null;
    private static boolean sInitialized = false;
    private static boolean useDynamicConfigUrl;
    private JSONObject configJson;
    private boolean mBackButtonAlertEnabled;
    private String mBackButtonAlertMessage;
    private String mBackButtonNegativeText;
    private String mBackButtonPositiveText;
    private boolean mCardSavingBroadcastReceiverFlowEnabled;
    private boolean mCardSavingLocalEnabled;
    private boolean mCardSavingSharedPreferencesFlowEnabled;
    private String mNativeLoaderColor;
    private boolean mNativeLoaderEnabled;
    private Boolean mRetryEnabled;
    private int mRetryMaxCount;
    private boolean mVerboseLoggingEnabled;
    private ArrayList<String> mCheckoutAppendKeys = new ArrayList<>();
    private Map<String, String> mCheckoutUrlConfig = new HashMap();
    private boolean retrySetFromOptions = false;

    private ConfigCheckout() {
    }

    public static ConfigCheckout getInstance() {
        if (sConfig == null) {
            ConfigCheckout configCheckout = new ConfigCheckout();
            sConfig = configCheckout;
            CoreConfig.setInstance(configCheckout);
        }
        return sConfig;
    }

    public void init(Context context) {
        setConfig(getConfigJson(context));
    }

    static void ensureInitialized(Context context) {
        if (sInitialized) {
            return;
        }
        synchronized (INIT_LOCK) {
            if (sInitialized) {
                return;
            }
            getInstance().init(context);
            sInitialized = true;
        }
    }

    public void setRetryConfigFromOptions(JSONObject jSONObject) {
        try {
            setRetryConfig(jSONObject, true);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getLocalizedMessage());
        }
    }

    private static JSONObject getConfigJson(Context context) {
        return BaseConfig.getConfig(context, R.raw.rzp_config_checkout);
    }

    private void setCheckoutConfig(JSONObject jSONObject) throws Exception {
        this.mCheckoutAppendKeys = BaseUtils.jsonStringArrayToArrayList((JSONArray) BaseUtils.getJsonValue("checkout.append_keys", jSONObject, new JSONArray()));
        JSONObject jSONObject2 = (JSONObject) BaseUtils.getJsonValue("checkout.url_config", jSONObject, new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.mCheckoutUrlConfig.put(next, jSONObject2.getString(next));
        }
    }

    private void setCardSavingConfig(JSONObject jSONObject) throws Exception {
        this.mCardSavingBroadcastReceiverFlowEnabled = ((Boolean) BaseUtils.getJsonValue("card_saving.broadcast_receiver_flow", jSONObject, Boolean.FALSE)).booleanValue();
        this.mCardSavingSharedPreferencesFlowEnabled = ((Boolean) BaseUtils.getJsonValue("card_saving.shared_preferences_flow", jSONObject, Boolean.FALSE)).booleanValue();
        this.mCardSavingLocalEnabled = ((Boolean) BaseUtils.getJsonValue("card_saving.local", jSONObject, Boolean.FALSE)).booleanValue();
    }

    private void setNativeLoaderConfig(JSONObject jSONObject) throws Exception {
        this.mNativeLoaderColor = (String) BaseUtils.getJsonValue("native_loader.color", jSONObject, "");
        this.mNativeLoaderEnabled = ((Boolean) BaseUtils.getJsonValue("native_loader.enable", jSONObject, Boolean.TRUE)).booleanValue();
    }

    private void setRetryConfig(JSONObject jSONObject, boolean z) throws Exception {
        if (!this.retrySetFromOptions) {
            this.mRetryEnabled = Boolean.valueOf(((Boolean) BaseUtils.getJsonValue("retry.enabled", jSONObject, Boolean.TRUE)).booleanValue());
            this.mRetryMaxCount = ((Integer) BaseUtils.getJsonValue("retry.max_count", jSONObject, (Object) (-1))).intValue();
        }
        this.retrySetFromOptions = z;
    }

    public Boolean getPrefetchEnabled() {
        return Boolean.valueOf(((Boolean) BaseUtils.getJsonValue("performance.prefetch", this.configJson, Boolean.TRUE)).booleanValue());
    }

    public Boolean getPreloadEnabled() {
        return Boolean.valueOf(((Boolean) BaseUtils.getJsonValue("performance.preload", this.configJson, Boolean.TRUE)).booleanValue());
    }

    public Boolean getAppStartupUsageEnabled() {
        return Boolean.valueOf(((Boolean) BaseUtils.getJsonValue("performance.app_startup", this.configJson, Boolean.TRUE)).booleanValue());
    }

    private void setBankButtonConfig(JSONObject jSONObject) throws Exception {
        this.mBackButtonAlertMessage = (String) BaseUtils.getJsonValue("back_button.alert_message", jSONObject, "");
        this.mBackButtonAlertEnabled = ((Boolean) BaseUtils.getJsonValue("back_button.enable", jSONObject, Boolean.FALSE)).booleanValue();
        this.mBackButtonPositiveText = (String) BaseUtils.getJsonValue("back_button.positive_text", jSONObject, "");
        this.mBackButtonNegativeText = (String) BaseUtils.getJsonValue("back_button.negative_text", jSONObject, "");
    }

    private void setVerboseLoggingConfig(JSONObject jSONObject) throws Exception {
        this.mVerboseLoggingEnabled = ((Boolean) BaseUtils.getJsonValue("feature_flags.verbose_logging.enabled", jSONObject, Boolean.FALSE)).booleanValue();
    }

    @Override // com.razorpay.BaseConfig
    public void setConfig(JSONObject jSONObject) {
        try {
            setCheckoutConfig(jSONObject);
            setCardSavingConfig(jSONObject);
            setNativeLoaderConfig(jSONObject);
            setRetryConfig(jSONObject, false);
            setBankButtonConfig(jSONObject);
            setVerboseLoggingConfig(jSONObject);
            this.configJson = jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S2", e2.getMessage());
            Logger.e("Error in setting Config, ErrorMessage=" + e2.getMessage());
            e2.printStackTrace();
        }
        super.setConfig(jSONObject);
    }

    public boolean isCardSavingLocalEnabled() {
        return this.mCardSavingLocalEnabled;
    }

    public String getNativeLoaderColor() {
        return this.mNativeLoaderColor;
    }

    public boolean isNativeLoaderEnabled() {
        return this.mNativeLoaderEnabled;
    }

    public boolean isRetryEnabled() {
        return this.mRetryEnabled.booleanValue();
    }

    public int getRetryMaxCount() {
        return this.mRetryMaxCount;
    }

    public Map<String, String> getCheckoutUrlConfig() {
        return this.mCheckoutUrlConfig;
    }

    public ArrayList<String> getCheckoutAppendKeys() {
        return this.mCheckoutAppendKeys;
    }

    public String getBackButtonNegativeText() {
        return this.mBackButtonNegativeText;
    }

    public String getBackButtonPositiveText() {
        return this.mBackButtonPositiveText;
    }

    public boolean isBackButtonAlertEnabled() {
        return this.mBackButtonAlertEnabled;
    }

    public String getBackButtonAlertMessage() {
        return this.mBackButtonAlertMessage;
    }

    public boolean isCardSavingBroadcastReceiverFlowEnabled() {
        return this.mCardSavingBroadcastReceiverFlowEnabled;
    }

    public boolean isCardSavingSharedPreferencesFlowEnabled() {
        return this.mCardSavingSharedPreferencesFlowEnabled;
    }

    @Override // com.razorpay.BaseConfig
    public boolean isVerboseLoggingEnabled() {
        return this.mVerboseLoggingEnabled;
    }

    static void fetchConfig(Context context, String str) {
        if (getInstance().isConfigEnabled()) {
            HashMap map = new HashMap();
            map.put("AuthKey", CONFIG_AUTH_KEY);
            map.put("Content-type", "application/json");
            map.put("CurrentSettingVersion", getCurrentConfigVersion(context));
            boolean zBooleanValue = ((Boolean) BaseUtils.getJsonValue("use_dynamic_config_url", getInstance().configJson, Boolean.FALSE)).booleanValue();
            useDynamicConfigUrl = zBooleanValue;
            if (zBooleanValue) {
                String strBuildConfigUrl = buildConfigUrl(GlobalUrlConfig.instance().getButlerUrl(), context, str);
                BaseConfig.fetchConfig(strBuildConfigUrl, strBuildConfigUrl, map, context);
            } else {
                BaseConfig.fetchConfig(buildConfigUrl("https://api.razorpay.com/v2/settings/sdk", context, str), buildConfigUrl("https://butler.razorpay.com/v1/settings", context, str), map, context);
            }
        }
    }

    private static String buildConfigUrl(String str, Context context, String str2) {
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("tenant", "android_checkout").appendQueryParameter("sdk_version", SDK_VERSION).appendQueryParameter("sdk_type", SDK_TYPE).appendQueryParameter("magic_enabled", String.valueOf(IS_MAGIC_ENABLED)).appendQueryParameter("sdk_version_code", String.valueOf(SDK_VERSION_CODE)).appendQueryParameter("app_version", BuildConfig.VERSION_NAME).appendQueryParameter("version", getCurrentConfigVersionTag(getCurrentConfigVersion(context)));
        BaseConfig.getFetchConfigBuilder(builderAppendQueryParameter, context, str2);
        return builderAppendQueryParameter.build().toString();
    }

    private static String getCurrentConfigVersion(Context context) {
        String baseCurrentConfigVersion = BaseConfig.getBaseCurrentConfigVersion(context);
        return baseCurrentConfigVersion == null ? CONFIG_VERSION : baseCurrentConfigVersion;
    }
}
