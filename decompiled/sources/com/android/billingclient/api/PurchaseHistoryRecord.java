package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.appevents.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public class PurchaseHistoryRecord {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    public PurchaseHistoryRecord(String str, String str2) throws JSONException {
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
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.zza, purchaseHistoryRecord.getOriginalJson()) && TextUtils.equals(this.zzb, purchaseHistoryRecord.getSignature());
    }

    public String getDeveloperPayload() {
        return this.zzc.optString(SDKConstants.PARAM_DEVELOPER_PAYLOAD);
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public List<String> getProducts() {
        return zza();
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

    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.zza));
    }
}
