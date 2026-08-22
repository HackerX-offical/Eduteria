package com.razorpay;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class AutoOtpUtils {
    AutoOtpUtils() {
    }

    static void incrementSmsPermissionAskedCount(Context context) {
        SharedPreferenceUtil.getPrivateEditor(context).putInt("rzp_permission_asked_count", SharedPreferenceUtil.getPrivatePrefs(context).getInt("rzp_permission_asked_count", 0) + 1).apply();
    }

    static int getSmsPermissionAskedCount(Context context) {
        return SharedPreferenceUtil.getPrivatePrefs(context).getInt("rzp_permission_asked_count", 0);
    }

    static JSONObject createStatsPayload(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("otp_read", z ? 1 : 0);
            return jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
            return null;
        }
    }
}
