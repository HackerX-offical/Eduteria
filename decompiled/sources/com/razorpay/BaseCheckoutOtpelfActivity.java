package com.razorpay;

import android.os.Bundle;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
abstract class BaseCheckoutOtpelfActivity extends BaseCheckoutActivity {
    BaseCheckoutOtpelfActivity() {
    }

    @Override // com.razorpay.BaseCheckoutActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        HashMap<String, String> allPluginsFromManifest = BaseUtils.getAllPluginsFromManifest(this);
        if (allPluginsFromManifest == null || allPluginsFromManifest.size() == 0) {
            this.presenter = new OtpElfCheckoutPresenterImpl(this, this);
            this.checkoutBridgeObject = new CheckoutBridge((CheckoutInteractor) this.presenter, 1);
            super.onCreate(bundle);
            return;
        }
        this.presenter = new PluginOtpElfCheckoutPresenterImpl(this, this, allPluginsFromManifest);
        this.checkoutBridgeObject = new PluginCheckoutBridge((PluginCheckoutInteractor) this.presenter, 1);
        super.onCreate(bundle);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isAmazonPluginIntegrated", false);
            jSONObject.put("isGooglePayPluginIntegrated", false);
        } catch (JSONException unused) {
        }
        for (String str : allPluginsFromManifest.values()) {
            try {
                if (allPluginsFromManifest.size() > 0 && str.equalsIgnoreCase("com.razorpay.RazorpayAmazon")) {
                    jSONObject.put("isAmazonPluginIntegrated", true);
                }
                if (allPluginsFromManifest.size() > 0 && str.equalsIgnoreCase("com.razorpay.RzpGpayMerged")) {
                    jSONObject.put("isGooglePayPluginIntegrated", true);
                }
                RzpPlugin rzpPlugin = (RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(str).newInstance();
                RzpPluginCompatibilityResponse rzpPluginCompatibilityResponseIsCompatible = rzpPlugin.isCompatible(ConfigCheckout.SDK_TYPE, ConfigCheckout.SDK_VERSION_CODE, ConfigCheckout.SDK_VERSION);
                if (!rzpPluginCompatibilityResponseIsCompatible.isCompatible()) {
                    destroy(7, rzpPluginCompatibilityResponseIsCompatible.getErrorMessage());
                    return;
                }
                rzpPlugin.isRegistered(this, new RzpPluginRegisterCallback() { // from class: com.razorpay.BaseCheckoutOtpelfActivity.1
                    @Override // com.razorpay.RzpPluginRegisterCallback
                    public void onResponse(boolean z) {
                    }
                });
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
