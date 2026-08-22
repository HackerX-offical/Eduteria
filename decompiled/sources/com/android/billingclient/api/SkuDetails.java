package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    public String getDescription() {
        return this.zzb.optString("description");
    }

    public String getFreeTrialPeriod() {
        return this.zzb.optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
    }

    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong(Constants.GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS);
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt(Constants.GP_IAP_INTRODUCTORY_PRICE_CYCLES);
    }

    public String getIntroductoryPricePeriod() {
        return this.zzb.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_PERIOD);
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getOriginalPrice() {
        return this.zzb.has("original_price") ? this.zzb.optString("original_price") : getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        return this.zzb.has("original_price_micros") ? this.zzb.optLong("original_price_micros") : getPriceAmountMicros();
    }

    public String getPrice() {
        return this.zzb.optString(FirebaseAnalytics.Param.PRICE);
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4);
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4);
    }

    public String getSku() {
        return this.zzb.optString("productId");
    }

    public String getSubscriptionPeriod() {
        return this.zzb.optString(Constants.GP_IAP_SUBSCRIPTION_PERIOD);
    }

    public String getTitle() {
        return this.zzb.optString("title");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.zza));
    }

    public int zza() {
        return this.zzb.optInt("offer_type");
    }

    public String zzb() {
        return this.zzb.optString("offer_id");
    }

    public String zzc() {
        String strOptString = this.zzb.optString("offerIdToken");
        return strOptString.isEmpty() ? this.zzb.optString("offer_id_token") : strOptString;
    }

    public final String zzd() {
        return this.zzb.optString("packageName");
    }

    public String zze() {
        return this.zzb.optString("serializedDocid");
    }

    final String zzf() {
        return this.zzb.optString("skuDetailsToken");
    }
}
