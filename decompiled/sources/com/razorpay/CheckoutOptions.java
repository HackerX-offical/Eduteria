package com.razorpay;

import android.app.Activity;
import android.text.TextUtils;
import com.appnew.android.Utils.Const;
import com.razorpay.AnalyticsProperty;
import org.jivesoftware.smackx.message_fastening.element.ExternalElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class CheckoutOptions {
    private JSONObject options;

    CheckoutOptions(String str) {
        try {
            this.options = new JSONObject(str);
        } catch (JSONException e2) {
            AnalyticsUtil.reportError("CheckoutOptions", "S0", e2.getMessage());
        }
    }

    String getMerchantKey() {
        try {
            return this.options.getString("key");
        } catch (JSONException e2) {
            Logger.e("Error reading options!", e2);
            AnalyticsUtil.reportError("CheckoutOptions", "S0", e2.getMessage());
            return null;
        }
    }

    boolean shouldSendHashForSms() {
        try {
            if (this.options.has("send_sms_hash")) {
                return this.options.getBoolean("send_sms_hash");
            }
            return true;
        } catch (JSONException e2) {
            Logger.e("Error reading options!", e2);
            AnalyticsUtil.reportError(getClass().getName(), "error:exception", e2.getMessage());
            return true;
        }
    }

    boolean allowRotation() {
        try {
            if (this.options.has("allow_rotation")) {
                return this.options.getBoolean("allow_rotation");
            }
            return false;
        } catch (JSONException e2) {
            Logger.e("Error reading options!", e2);
            AnalyticsUtil.reportError(getClass().getName(), "error:exception", e2.getMessage());
            return true;
        }
    }

    boolean shouldDisableHardwareAccelerationForLowEndDevices() {
        try {
            if (this.options.has("disable_hardware_acceleration")) {
                return this.options.getBoolean("disable_hardware_acceleration");
            }
            return false;
        } catch (JSONException e2) {
            Logger.e("Error reading options!", e2);
            AnalyticsUtil.reportError(getClass().getName(), "error:exception", e2.getMessage());
            return false;
        }
    }

    JSONObject getAsJson() {
        return this.options;
    }

    String getAsString() {
        return this.options.toString();
    }

    String getOrderId() {
        try {
            if (this.options.has("order_id")) {
                return this.options.getString("order_id");
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    JSONObject getPrefill() {
        return this.options.optJSONObject("prefill");
    }

    JSONObject getOtpElfPreferences() {
        return this.options.optJSONObject("otpelf_preferences");
    }

    void logMerchantOptions() {
        try {
            JSONObject jSONObject = new JSONObject(this.options.toString());
            if (jSONObject.has("prefill")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("prefill");
                jSONObject2.remove("card");
                jSONObject2.remove("card[number]");
                jSONObject2.remove("card[expiry]");
                jSONObject2.remove("card[cvv]");
                jSONObject.put("prefill", jSONObject2);
            }
            jSONObject.remove("image");
            AnalyticsUtil.addProperty("merchant options", new AnalyticsProperty(jSONObject, AnalyticsProperty.Scope.ORDER));
        } catch (Exception e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S2", e2.getMessage());
        }
    }

    void modifyMerchantOptions(Activity activity, int i) {
        String base64FromCurrentAppsResource;
        put("redirect", Boolean.TRUE);
        if (i != 0 && (base64FromCurrentAppsResource = CheckoutUtils.getBase64FromCurrentAppsResource(activity, i)) != null) {
            put("image", base64FromCurrentAppsResource);
        }
        String userEmail = CheckoutUtils.getUserEmail(activity);
        if (!TextUtils.isEmpty(userEmail)) {
            prefillEmail(userEmail);
        }
        String userContact = CheckoutUtils.getUserContact(activity);
        if (TextUtils.isEmpty(userContact)) {
            return;
        }
        prefillContact(userContact);
    }

    String getOptionsWithoutImage() {
        put("image", null);
        return this.options.toString();
    }

    private void prefillContact(String str) {
        if (getPrefill() == null || !getPrefill().has("contact")) {
            putPrefill("contact", str);
        }
    }

    private void prefillEmail(String str) {
        if (getPrefill() == null || !getPrefill().has("email")) {
            putPrefill("email", str);
        }
    }

    void putPrefill(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (getPrefill() != null) {
            jSONObject = getPrefill();
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getMessage());
        }
        try {
            this.options.put("prefill", jSONObject);
        } catch (JSONException e3) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e3.getMessage());
        }
    }

    private void put(String str, Object obj) {
        try {
            this.options.put(str, obj);
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getMessage());
        }
    }

    boolean has(String str) {
        return this.options.has(str);
    }

    String getPrefilledContact() {
        if (getPrefill() == null) {
            return null;
        }
        return getPrefill().optString("contact");
    }

    String getPrefilledEmail() {
        if (getPrefill() == null) {
            return null;
        }
        return getPrefill().optString("email");
    }

    public boolean hasExternalWallet(String str) {
        try {
            if (this.options.has(ExternalElement.ELEMENT)) {
                return this.options.getJSONObject(ExternalElement.ELEMENT).getJSONArray("wallets").toString().contains(str);
            }
            return false;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S2", e2.getMessage());
            return false;
        }
    }

    public String getColor() {
        try {
            JSONObject asJson = getAsJson();
            if (asJson.has(Const.THEME) && asJson.getJSONObject(Const.THEME).has("color")) {
                return asJson.getJSONObject(Const.THEME).getString("color");
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    <T> T get(String str) {
        Object objOpt = this.options.opt(str);
        if (objOpt == null) {
            return null;
        }
        return (T) objOpt.getClass().cast(objOpt);
    }
}
