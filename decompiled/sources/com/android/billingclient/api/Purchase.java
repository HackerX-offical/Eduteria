package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.appevents.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public class Purchase {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    public static final class PendingPurchaseUpdate {
        private final JSONObject mParsedJson;

        private PendingPurchaseUpdate(JSONObject jSONObject) {
            this.mParsedJson = jSONObject;
        }

        public List<String> getProducts() {
            JSONArray jSONArrayOptJSONArray;
            ArrayList arrayList = new ArrayList();
            if (this.mParsedJson.has("productIds") && (jSONArrayOptJSONArray = this.mParsedJson.optJSONArray("productIds")) != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            return arrayList;
        }

        public String getPurchaseToken() {
            return this.mParsedJson.optString("purchaseToken");
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PurchaseState {
        public static final int PENDING = 2;
        public static final int PURCHASED = 1;
        public static final int UNSPECIFIED_STATE = 0;
    }

    public Purchase(String str, String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    private final ArrayList zza() {
        ArrayList arrayList = new ArrayList();
        if (this.zzc.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.zzc.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
        } else if (this.zzc.has("productId")) {
            arrayList.add(this.zzc.optString("productId"));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.zza, purchase.getOriginalJson()) && TextUtils.equals(this.zzb, purchase.getSignature());
    }

    public AccountIdentifiers getAccountIdentifiers() {
        JSONObject jSONObject = this.zzc;
        String strOptString = jSONObject.optString("obfuscatedAccountId");
        String strOptString2 = jSONObject.optString("obfuscatedProfileId");
        if (strOptString == null && strOptString2 == null) {
            return null;
        }
        return new AccountIdentifiers(strOptString, strOptString2);
    }

    public String getDeveloperPayload() {
        return this.zzc.optString(SDKConstants.PARAM_DEVELOPER_PAYLOAD);
    }

    public String getOrderId() {
        String strOptString = this.zzc.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getPackageName() {
        return this.zzc.optString("packageName");
    }

    public PendingPurchaseUpdate getPendingPurchaseUpdate() {
        JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("pendingPurchaseUpdate");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return new PendingPurchaseUpdate(jSONObjectOptJSONObject);
    }

    public List<String> getProducts() {
        return zza();
    }

    public int getPurchaseState() {
        return this.zzc.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public long getPurchaseTime() {
        return this.zzc.optLong(Constants.GP_IAP_PURCHASE_TIME);
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public int getQuantity() {
        return this.zzc.optInt(FirebaseAnalytics.Param.QUANTITY, 1);
    }

    public String getSignature() {
        return this.zzb;
    }

    @Deprecated
    public ArrayList<String> getSkus() {
        return zza();
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isAcknowledged() {
        return this.zzc.optBoolean("acknowledged", true);
    }

    public boolean isAutoRenewing() {
        return this.zzc.optBoolean(Constants.GP_IAP_AUTORENEWING);
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.zza));
    }
}
