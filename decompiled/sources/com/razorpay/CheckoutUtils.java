package com.razorpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.Utils.Const;
import com.facebook.internal.NativeProtocol;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
final class CheckoutUtils {
    private static Dialog dialog = null;
    private static boolean isHostedOptimizerEnabled = false;

    interface BackButtonDialogCallback {
        void onNegativeButtonClick();

        void onPositiveButtonClick();
    }

    CheckoutUtils() {
    }

    static void addAddons(Context context, String str) {
        AnalyticsUtil.setup(context, str, ConfigCheckout.SDK_TYPE, ConfigCheckout.SDK_VERSION_CODE, ConfigCheckout.SDK_VERSION);
    }

    static String getCheckoutUrlWithOptions(CheckoutOptions checkoutOptions) {
        String strAddParamToUrl = addParamToUrl(GlobalUrlConfig.instance().getCheckoutUrl(), "version", ConfigCheckout.SDK_VERSION);
        Map<String, String> checkoutUrlConfig = ConfigCheckout.getInstance().getCheckoutUrlConfig();
        for (String str : checkoutUrlConfig.keySet()) {
            strAddParamToUrl = addParamToUrl(strAddParamToUrl, str, checkoutUrlConfig.get(str));
        }
        for (String str2 : ConfigCheckout.getInstance().getCheckoutAppendKeys()) {
            if (checkoutOptions.has(str2)) {
                strAddParamToUrl = addParamToUrl(strAddParamToUrl, str2, (String) checkoutOptions.get(str2));
            }
        }
        Logger.d("Modified Url: " + strAddParamToUrl);
        return strAddParamToUrl;
    }

    static boolean isDynamicUrlConfigUsed(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return new CheckoutOptions(bundle.getString("OPTIONS")).getAsJson().has("hosted_config");
    }

    static void isFeatureEnabled(String str, final String str2, final Callback callback) {
        final ResponseObject responseObject = new ResponseObject();
        Owl.post("https://api.razorpay.com/v2/preferences?key_id=" + str, "{\"query\":[{\"resource\":\"merchant_features\"}],\"action\":\"get\"}", new Callback() { // from class: com.razorpay.CheckoutUtils.1
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject2) {
                if (responseObject2 != null) {
                    try {
                        if (responseObject2.getResponseCode() >= 400) {
                            boolean unused = CheckoutUtils.isHostedOptimizerEnabled = false;
                            return;
                        }
                        if (responseObject2.getResponseResult() != null) {
                            JSONObject jSONObject = new JSONObject(responseObject2.getResponseResult());
                            if (jSONObject.has("features")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("features");
                                if (jSONObject2.has("data")) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                    if (jSONObject3.has(str2)) {
                                        responseObject.setResponseResult(String.valueOf(jSONObject3.getBoolean(str2)));
                                        callback.run(responseObject);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        AnalyticsUtil.reportError(CheckoutUtils.class.getName(), "S0", e2.getMessage());
                        responseObject.setResponseResult("false");
                        callback.run(responseObject);
                    }
                }
            }
        });
    }

    static String getCheckoutUrlWithOptions(CheckoutOptions checkoutOptions, String str) {
        JSONObject asJson = checkoutOptions.getAsJson();
        if (str != null) {
            if (!str.contains(".html")) {
                str = addParamToUrl(str, "version", ConfigCheckout.SDK_VERSION);
            }
            Map<String, String> checkoutUrlConfig = ConfigCheckout.getInstance().getCheckoutUrlConfig();
            for (String str2 : checkoutUrlConfig.keySet()) {
                str = addParamToUrl(str, str2, checkoutUrlConfig.get(str2));
            }
            for (String str3 : ConfigCheckout.getInstance().getCheckoutAppendKeys()) {
                if (checkoutOptions.has(str3)) {
                    str = addParamToUrl(str, str3, (String) checkoutOptions.get(str3));
                }
            }
            Logger.d("Modified Url: " + str);
            return str;
        }
        if (checkoutOptions.has("hosted_config")) {
            try {
                JSONObject jSONObject = asJson.getJSONObject("hosted_config");
                String str4 = getHostedFrameBaseUrl(jSONObject.getString(TypedValues.AttributesType.S_FRAME)) + CoreConfig.getInstance().getHostedFrameBuild();
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                boolean z = true;
                for (int i = 0; i < jSONObject.length(); i++) {
                    String string = jSONObject.names().getString(i);
                    if (!string.equals(TypedValues.AttributesType.S_FRAME)) {
                        if (z) {
                            sb.append("?");
                            z = false;
                        } else {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(string, "UTF-8")).append("=").append(URLEncoder.encode(jSONObject.getString(string), "UTF-8"));
                    }
                }
                return getCheckoutUrlWithOptions(checkoutOptions, sb.toString());
            } catch (UnsupportedEncodingException | JSONException unused) {
                return getCheckoutUrlWithOptions(checkoutOptions);
            }
        }
        return getCheckoutUrlWithOptions(checkoutOptions);
    }

    public static String getHostedFrameBaseUrl(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + "://" + url.getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    static boolean isCheckoutUrl(WebView webView) {
        return (webView.getTag() == null ? "" : webView.getTag().toString()).contains(GlobalUrlConfig.instance().getBaseUrl());
    }

    static String addParamToUrl(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            return str;
        }
        String str4 = str + (str.contains("?") ? "&" : "?") + str2;
        return str3 == null ? str4 : str4 + "=" + str3;
    }

    static void disableFullScreenMode(Activity activity) {
        activity.getWindow().addFlags(2048);
        activity.getWindow().clearFlags(1024);
    }

    static boolean shouldRetryPayment(int i) {
        int retryMaxCount = ConfigCheckout.getInstance().getRetryMaxCount();
        if (ConfigCheckout.getInstance().isRetryEnabled()) {
            return retryMaxCount == -1 || retryMaxCount >= i;
        }
        return false;
    }

    static String getBase64FromCurrentAppsResource(Activity activity, int i) {
        return BaseUtils.getBase64FromResource(activity.getResources(), i);
    }

    static void setUserEmail(Context context, String str) {
        SharedPreferenceUtil.setProtectedValue(context, "rzp_user_email", str, null);
    }

    static void setMerchantOptions(Context context, String str, String str2) {
        if (str2 == null) {
            SharedPreferenceUtil.removeValue(context, "pref_merchant_options_" + str);
        } else {
            SharedPreferenceUtil.setProtectedValue(context, "pref_merchant_options_" + str, str2, null);
        }
    }

    static String getMerchantOptions(Context context, String str) {
        return SharedPreferenceUtil.getProtectedValue(context, "pref_merchant_options_" + str, null);
    }

    static void setUserContact(Context context, String str) {
        SharedPreferenceUtil.setProtectedValue(context, "rzp_user_contact", str, null);
    }

    static String getUserEmail(Context context) {
        return SharedPreferenceUtil.getProtectedValue(context, "rzp_user_email", null);
    }

    static String getUserContact(Context context) {
        return SharedPreferenceUtil.getProtectedValue(context, "rzp_user_contact", null);
    }

    static void showDialog(Context context, String str, String str2, String str3, final BackButtonDialogCallback backButtonDialogCallback) {
        new AlertDialog.Builder(context).setMessage(str).setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.razorpay.CheckoutUtils.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                backButtonDialogCallback.onPositiveButtonClick();
            }
        }).setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.razorpay.CheckoutUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                backButtonDialogCallback.onNegativeButtonClick();
            }
        }).show();
    }

    static JSONObject isPackageInstalled(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveInfo = new ResolveInfo();
            resolveInfo.resolvePackageName = packageManager.getPackageInfo(str, 0).packageName;
            return getAppExistenceDataInJson(context, resolveInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    static JSONObject getAppExistenceDataInJson(Context context, ResolveInfo resolveInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (resolveInfo.resolvePackageName.equalsIgnoreCase(BaseConstants.CRED_PACKAGE)) {
                jSONObject.put("shortcode", "cred");
                jSONObject.put("uri", "credpay");
                jSONObject.put("package_name", resolveInfo.resolvePackageName);
                return jSONObject;
            }
            if (resolveInfo.resolvePackageName.equalsIgnoreCase(BaseConstants.BHIM_PACKAGE_NAME)) {
                jSONObject.put("shortcode", "bhim");
                jSONObject.put("uri", "upi://pay");
                jSONObject.put("package_name", resolveInfo.resolvePackageName);
                return jSONObject;
            }
            jSONObject.put("package_name", resolveInfo.resolvePackageName);
            return jSONObject;
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getLocalizedMessage(), "S2", e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    static JSONArray getUpiIntentsDataInJsonArray(Context context) {
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = BaseUtils.getListOfAppsWhichHandleDeepLink(context, "upi://pay");
        if (listOfAppsWhichHandleDeepLink == null || listOfAppsWhichHandleDeepLink.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ResolveInfo> it = listOfAppsWhichHandleDeepLink.iterator();
        while (it.hasNext()) {
            jSONArray.put(getIntentDataInJson(context, it.next()));
        }
        return jSONArray;
    }

    static JSONArray getAppIntentDataInJsonArray(Context context) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        arrayList.add("credpay://checkout");
        arrayList.add("truecallersdk://truesdk");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List<ResolveInfo> listOfAppsWhichHandleDeepLink = BaseUtils.getListOfAppsWhichHandleDeepLink(context, (String) it.next());
            if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
                Iterator<ResolveInfo> it2 = listOfAppsWhichHandleDeepLink.iterator();
                while (it2.hasNext()) {
                    jSONArray.put(getAppIntentDataInJson(context, it2.next()));
                }
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    static JSONObject getAppIntentDataInJson(Context context, ResolveInfo resolveInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!resolveInfo.activityInfo.packageName.contains(BaseConstants.CRED_PACKAGE)) {
                if (resolveInfo.activityInfo.packageName.contains("com.truecaller")) {
                    jSONObject.put("package_name", "com.truecaller");
                    jSONObject.put("shortcode", (Object) null);
                    jSONObject.put("uri", (Object) null);
                }
                return jSONObject;
            }
            jSONObject.put("package_name", BaseConstants.CRED_PACKAGE);
            jSONObject.put("shortcode", "cred");
            jSONObject.put("uri", "credpay");
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
            return null;
        }
    }

    static JSONObject getIntentDataInJson(Context context, ResolveInfo resolveInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", resolveInfo.activityInfo.packageName);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, BaseUtils.getAppNameOfResolveInfo(resolveInfo, context));
            jSONObject.put(Const.APP_ICON, BaseUtils.getBase64FromOtherAppsResource(context, resolveInfo.activityInfo.packageName));
            return jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            e2.printStackTrace();
            return jSONObject;
        }
    }

    static void showLoader(Context context) {
        if (!ConfigCheckout.getInstance().isNativeLoaderEnabled() || context == null || ((Activity) context).isFinishing()) {
            return;
        }
        Dialog dialog2 = dialog;
        if (dialog2 == null || !dialog2.isShowing()) {
            Dialog dialog3 = new Dialog(context);
            dialog = dialog3;
            dialog3.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.setContentView(R.layout.rzp_loader);
            try {
                ((CircularProgressView) dialog.findViewById(R.id.progressBar)).setColor(Color.parseColor(ConfigCheckout.getInstance().getNativeLoaderColor()));
            } catch (Exception unused) {
            }
            ((LinearLayout) dialog.findViewById(R.id.ll_loader)).setOnClickListener(new View.OnClickListener() { // from class: com.razorpay.CheckoutUtils.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CheckoutUtils.dismissLoader();
                }
            });
            try {
                dialog.show();
            } catch (Exception e2) {
                Logger.e("Error showing loader", e2);
            }
        }
    }

    static void showLoaderForMagicX(Context context, String str) {
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        Dialog dialog2 = dialog;
        if (dialog2 == null || !dialog2.isShowing()) {
            Dialog dialog3 = new Dialog(context);
            dialog = dialog3;
            dialog3.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.setContentView(R.layout.rzp_loader);
            ((CircularProgressView) dialog.findViewById(R.id.progressBar)).setColor(Color.parseColor(str));
            ((LinearLayout) dialog.findViewById(R.id.ll_loader)).setOnClickListener(new View.OnClickListener() { // from class: com.razorpay.CheckoutUtils.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CheckoutUtils.dismissLoader();
                }
            });
            try {
                dialog.show();
            } catch (Exception e2) {
                Logger.e("Error showing loader", e2);
            }
        }
    }

    static boolean isDialogShowing() {
        Dialog dialog2 = dialog;
        if (dialog2 == null) {
            return false;
        }
        return dialog2.isShowing();
    }

    static void dismissLoader() {
        Dialog dialog2 = dialog;
        if (dialog2 == null) {
            return;
        }
        if (dialog2.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e2) {
                Logger.e("Error dismissing loader", e2);
            }
        }
        dialog = null;
    }

    static void clearUserData(Context context) {
        setUserContact(context, null);
        setUserEmail(context, null);
        CardSaving.setDeviceToken(context, null);
        clearUserRelatedCookies();
    }

    static void clearUserRelatedCookies() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie("https://api.razorpay.com", "razorpay_api_session=");
        WebStorage.getInstance().deleteAllData();
        cookieManager.removeSessionCookies(new ValueCallback<Boolean>() { // from class: com.razorpay.CheckoutUtils.6
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                if (bool.booleanValue()) {
                    CookieManager.getInstance().removeAllCookies(null);
                    CookieManager.getInstance().flush();
                }
            }
        });
    }

    public static void toggleWebviewBackground(WebView webView, boolean z) {
        if (webView != null) {
            if (z) {
                webView.setBackgroundColor(Color.parseColor("#99000000"));
                return;
            }
            Drawable background = webView.getBackground();
            if (background instanceof ColorDrawable) {
                int color = ((ColorDrawable) background).getColor();
                if (Color.alpha(color) == 0 || color == Color.parseColor("#99000000")) {
                    webView.setBackgroundColor(-1);
                    return;
                } else {
                    webView.setBackgroundColor(Color.parseColor("#99000000"));
                    return;
                }
            }
            webView.setBackgroundColor(Color.parseColor("#99000000"));
        }
    }

    public static Bundle getCheckoutActivityStateBundle(Activity activity) {
        try {
            String value = SharedPreferenceUtil.getValue(activity, "SAVED_STATE_BUNDLE_MAP");
            if (value == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(value);
            Bundle bundle = new Bundle();
            if (jSONObject.has("OPTIONS")) {
                bundle.putString("OPTIONS", jSONObject.getString("OPTIONS"));
            }
            if (jSONObject.has("DASH_OPTIONS")) {
                bundle.putString("DASH_OPTIONS", jSONObject.getString("DASH_OPTIONS"));
            }
            if (jSONObject.has("IMAGE")) {
                bundle.putInt("IMAGE", jSONObject.getInt("IMAGE"));
            }
            if (jSONObject.has(CheckoutConstants.DISABLE_FULL_SCREEN)) {
                bundle.putBoolean(CheckoutConstants.DISABLE_FULL_SCREEN, jSONObject.getBoolean(CheckoutConstants.DISABLE_FULL_SCREEN));
            }
            return bundle;
        } catch (Exception e2) {
            AnalyticsUtil.reportError("CheckoutUtils.getCheckoutActivityStateBundle()", "S1", e2.getMessage());
            return null;
        }
    }

    public static JSONObject checkoutActivityStateBundleToJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("OPTIONS", bundle.getString("OPTIONS"));
            jSONObject.put("DASH_OPTIONS", bundle.getString("DASH_OPTIONS"));
            if (bundle.containsKey("IMAGE")) {
                jSONObject.put("IMAGE", bundle.getInt("IMAGE"));
            }
            if (bundle.containsKey(CheckoutConstants.DISABLE_FULL_SCREEN)) {
                jSONObject.put(CheckoutConstants.DISABLE_FULL_SCREEN, bundle.getBoolean(CheckoutConstants.DISABLE_FULL_SCREEN));
            }
            return jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError("CheckoutUtils.checkoutActivityStateBundleToJSONObject()", "S1", e2.getMessage());
            return null;
        }
    }

    static boolean shouldDisableHardwareAcceleration(Context context, CheckoutOptions checkoutOptions) {
        try {
            if (context == null || checkoutOptions == null) {
                Logger.d("context or checkout options null, keeping HW accel enabled");
                return false;
            }
            String str = Build.MANUFACTURER;
            int performanceClass = PerformanceUtil.getPerformanceClass(context);
            boolean zIsLowEndDevice = PerformanceUtil.isLowEndDevice(context);
            HashMap map = new HashMap();
            map.put(Const.manufacturer, str);
            map.put("performance_class", Integer.valueOf(performanceClass));
            map.put("is_low_end_device", Boolean.valueOf(zIsLowEndDevice));
            map.put("merchant_flag_enabled", Boolean.valueOf(checkoutOptions.shouldDisableHardwareAccelerationForLowEndDevices()));
            if (!checkoutOptions.shouldDisableHardwareAccelerationForLowEndDevices()) {
                map.put("hw_acceleration_status", StreamManagement.Enabled.ELEMENT);
                map.put("reason", "merchant_flag_not_set");
                AnalyticsUtil.trackEventWithMetric(AnalyticsEvent.CHECKOUT_HARDWARE_ACCELERATION_CHECK, AnalyticsUtil.getJSONResponse(map), performanceClass);
                return false;
            }
            if (!zIsLowEndDevice) {
                map.put("hw_acceleration_status", StreamManagement.Enabled.ELEMENT);
                map.put("reason", "high_end_device");
                AnalyticsUtil.trackEventWithMetric(AnalyticsEvent.CHECKOUT_HARDWARE_ACCELERATION_CHECK, AnalyticsUtil.getJSONResponse(map), performanceClass);
                return false;
            }
            String str2 = "OPPO";
            boolean z = str != null && str.equalsIgnoreCase("OPPO");
            boolean z2 = str != null && str.equalsIgnoreCase("VIVO");
            if (!z && !z2) {
                map.put("hw_acceleration_status", StreamManagement.Enabled.ELEMENT);
                map.put("reason", "not_oppo_or_vivo_manufacturer");
                AnalyticsUtil.trackEventWithMetric(AnalyticsEvent.CHECKOUT_HARDWARE_ACCELERATION_CHECK, AnalyticsUtil.getJSONResponse(map), performanceClass);
                return false;
            }
            map.put("hw_acceleration_status", "disabled");
            map.put("reason", z ? "oppo_low_end_device" : "vivo_low_end_device");
            AnalyticsUtil.trackEventWithMetric(AnalyticsEvent.CHECKOUT_HARDWARE_ACCELERATION_CHECK, AnalyticsUtil.getJSONResponse(map), performanceClass);
            StringBuilder sb = new StringBuilder("Hardware acceleration disabled: ");
            if (!z) {
                str2 = "VIVO";
            }
            Logger.d(sb.append(str2).append(" low-end device detected").toString());
            return true;
        } catch (Exception e2) {
            Logger.e("Error in shouldDisableHardwareAcceleration: " + e2.getMessage());
            return false;
        }
    }
}
