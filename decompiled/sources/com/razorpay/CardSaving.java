package com.razorpay;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.razorpay.AnalyticsProperty;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class CardSaving {
    CardSaving() {
    }

    static void sendBroadcastForFetchingDeviceToken(Context context) {
        Intent intent = new Intent();
        intent.setAction("rzp.device_token.share");
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        for (int i = 0; i < listQueryBroadcastReceivers.size(); i++) {
            ResolveInfo resolveInfo = listQueryBroadcastReceivers.get(i);
            intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(BuildConfig.LIBRARY_PACKAGE_NAME, "com.razorpay.CheckoutActivity"));
            intent.putExtra("forward", intent2);
            context.sendOrderedBroadcast(intent, null, new BroadcastReceiver() { // from class: com.razorpay.CardSaving.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent3) {
                    String string;
                    Bundle resultExtras = getResultExtras(false);
                    if (resultExtras == null || (string = resultExtras.getString("device_token_info_list")) == null) {
                        return;
                    }
                    try {
                        CardSaving.getCorrectDeviceTokenFromInfoListAndSave(context2, new JSONArray(string));
                    } catch (Exception unused) {
                    }
                }
            }, null, -1, null, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String getCorrectDeviceTokenFromInfoListAndSave(android.content.Context r16, org.json.JSONArray r17) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.CardSaving.getCorrectDeviceTokenFromInfoListAndSave(android.content.Context, org.json.JSONArray):java.lang.String");
    }

    static void fetchDeviceTokenFromOtherAppsIfRequired(Context context) throws IllegalStateException {
        if (ConfigCheckout.getInstance().isCardSavingLocalEnabled() && getDeviceToken(context) != null) {
            AnalyticsUtil.addProperty("device_token_source_single", new AnalyticsProperty(context.getPackageName(), AnalyticsProperty.Scope.ORDER));
        } else if (ConfigCheckout.getInstance().isCardSavingBroadcastReceiverFlowEnabled()) {
            sendBroadcastForFetchingDeviceToken(context);
        } else if (ConfigCheckout.getInstance().isCardSavingSharedPreferencesFlowEnabled()) {
            getCorrectDeviceTokenFromInfoListAndSave(context, getListOfRazorpayPackages(context));
        }
    }

    private static JSONArray getListOfRazorpayPackages(Context context) {
        JSONArray jSONArray = new JSONArray();
        Iterator<ResolveInfo> it = BaseUtils.getListOfAppsWhichHandleDeepLink(context, "io.rzp://rzp.io").iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = it.next().activityInfo.taskAffinity;
            i++;
            try {
                String deviceToken = getDeviceToken(context.createPackageContext(str, 2));
                if (deviceToken != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rzp_device_token", deviceToken);
                    jSONObject.put("card_saving_token_source", str);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e2) {
                if (e2 instanceof SecurityException) {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.SHARE_PREFERENCES_SECURITY_EXCEPTION);
                } else {
                    AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
                }
                Logger.e("Error fetching global device token", e2);
            }
        }
        AnalyticsUtil.addProperty("sdk_count", new AnalyticsProperty(i, AnalyticsProperty.Scope.ORDER));
        AnalyticsUtil.addProperty("sdk_count_with_token", new AnalyticsProperty(jSONArray.length(), AnalyticsProperty.Scope.ORDER));
        return jSONArray;
    }

    static String getAppToken(Context context) {
        return SharedPreferenceUtil.getPrivatePrefs(context).getString("rzp_app_token", null);
    }

    static void setAppToken(Context context, String str) {
        SharedPreferenceUtil.getPrivateEditor(context).putString("rzp_app_token", str).apply();
    }

    static String getDeviceToken(Context context) {
        return SharedPreferenceUtil.getPublicPrefs(context).getString("rzp_device_token", null);
    }

    static void setDeviceToken(Context context, String str) {
        SharedPreferenceUtil.getPublicEditor(context).putString("rzp_device_token", str).apply();
    }

    static void clearDeviceToken(Context context) {
        SharedPreferenceUtil.getPublicEditor(context).remove("rzp_device_token").apply();
    }
}
