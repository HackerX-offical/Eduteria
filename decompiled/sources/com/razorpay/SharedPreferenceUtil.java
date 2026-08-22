package com.razorpay;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class SharedPreferenceUtil {
    private static final String KEY_DATA = "data";
    private static final String KEY_IV = "iv";
    private static final String KEY_SDK_VERSION = "sdk_version";
    private static final String NAME_PRIVATE = "rzp_preference_private";
    private static final String NAME_PUBLIC = "rzp_preference_public";
    private static final String NAME_STORAGE_BRIDGE = "rzp_preferences_storage_bridge";
    private static SharedPreferences.Editor privateEditor;
    private static SharedPreferences privatePrefs;

    SharedPreferenceUtil() {
    }

    static SharedPreferences getPrivatePrefs(Context context) {
        if (privatePrefs == null) {
            privatePrefs = context.getSharedPreferences(NAME_PRIVATE, 0);
        }
        return privatePrefs;
    }

    static SharedPreferences.Editor getPrivateEditor(Context context) {
        if (privateEditor == null) {
            privateEditor = getPrivatePrefs(context).edit();
        }
        return privateEditor;
    }

    static SharedPreferences getPublicPrefs(Context context) {
        try {
            return context.getSharedPreferences(NAME_PUBLIC, 0);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
            return context.getSharedPreferences(NAME_PUBLIC, 0);
        }
    }

    static SharedPreferences.Editor getPublicEditor(Context context) {
        return getPublicPrefs(context).edit();
    }

    static SharedPreferences.Editor getStorageBridgeEditor(Context context) {
        return getStorageBridgePrefs(context).edit();
    }

    static SharedPreferences getStorageBridgePrefs(Context context) {
        return context.getSharedPreferences(NAME_STORAGE_BRIDGE, 0);
    }

    static void handleSdkUpdate(Context context, String str) {
        try {
            if (str.equalsIgnoreCase(getValue(context, KEY_SDK_VERSION))) {
                return;
            }
            setValue(context, "rzp_config_json", null);
            setValue(context, "rzp_config_version", null);
            setValue(context, KEY_SDK_VERSION, str);
        } catch (NullPointerException unused) {
            setValue(context, "rzp_config_json", null);
            setValue(context, "rzp_config_version", null);
            setValue(context, KEY_SDK_VERSION, str);
        }
    }

    static String getProtectedValue(Context context, String str, String str2) {
        try {
            String value = getValue(context, str);
            if (value == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(value);
            CryptLib cryptLib = new CryptLib();
            if (str2 == null || str2.equals(jSONObject.getString(KEY_SDK_VERSION))) {
                return cryptLib.decrypt(jSONObject.getString("data"), "b12c6fb592d1192ce06d2d5695201fde", jSONObject.getString(KEY_IV));
            }
            return null;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getLocalizedMessage());
            return null;
        }
    }

    static void setProtectedValue(Context context, String str, String str2, String str3) {
        try {
            if (str2 == null) {
                removeValue(context, str);
                return;
            }
            String randomString = BaseUtils.getRandomString();
            String strEncrypt = new CryptLib().encrypt(str2, "b12c6fb592d1192ce06d2d5695201fde", randomString);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", strEncrypt);
            jSONObject.put(KEY_IV, randomString);
            if (str3 != null) {
                jSONObject.put(KEY_SDK_VERSION, str3);
            }
            setValue(context, str, jSONObject.toString());
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getLocalizedMessage());
        }
    }

    static String getValue(Context context, String str) {
        return getPrivatePrefs(context).getString(str, null);
    }

    static void setValue(Context context, String str, String str2) {
        SharedPreferences.Editor privateEditor2 = getPrivateEditor(context);
        privateEditor2.putString(str, str2);
        privateEditor2.commit();
    }

    static void removeValue(Context context, String str) {
        SharedPreferences.Editor privateEditor2 = getPrivateEditor(context);
        privateEditor2.remove(str);
        privateEditor2.commit();
    }
}
