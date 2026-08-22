package com.razorpay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class RzpTokenReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String deviceToken = CardSaving.getDeviceToken(context);
        Bundle resultExtras = getResultExtras(true);
        int flags = intent.getFlags();
        try {
            Intent intent2 = (Intent) intent.getExtras().get("forward");
            if (intent2.getComponent().getPackageName().equalsIgnoreCase(BuildConfig.LIBRARY_PACKAGE_NAME) && intent2.getComponent().getClassName().equalsIgnoreCase("com.razorpay.CheckoutActivity") && (flags & 1) == 0 && (flags & 2) == 0 && !TextUtils.isEmpty(deviceToken)) {
                JSONArray jSONArray = new JSONArray();
                String string = resultExtras.getString("device_token_info_list");
                if (string != null) {
                    try {
                        jSONArray = new JSONArray(string);
                    } catch (Exception unused) {
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("rzp_device_token", deviceToken);
                    jSONObject.put("card_saving_token_source", context.getPackageName());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
                resultExtras.putString("device_token_info_list", jSONArray.toString());
            }
        } catch (Exception unused3) {
        }
    }
}
